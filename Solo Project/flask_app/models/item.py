from flask_app import app
from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_bcrypt import Bcrypt
from flask_app.models import user
import re

bcrypt = Bcrypt(app)

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

DB = "soloproject"

class Item:

    def __init__(self, item):
        self.id = item["id"]
        self.name = item["name"]
        self.location = item["location"]
        self.description = item["description"]
        self.created_at = item["created_at"]
        self.updated_at = item["updated_at"]
        self.user = None


    @classmethod
    def create_valid_item(cls, item_dict):
        if not cls.is_valid(item_dict):
            return False
        
        query = "INSERT INTO item (name, location, description,user_id) VALUES(%(name)s, %(location)s, %(description)s,%(user_id)s);"
        item_id = connectToMySQL(DB).query_db(query, item_dict)
        item = cls.get_by_id(item_id)
        return item

    @classmethod
    def get_by_id(cls,item_id):
        data = {
            "id": item_id
        }
        query = "SELECT * FROM item WHERE id = %(id)s;"
        result = connectToMySQL(DB).query_db(query,data)[0]
        item = cls(result)
        user_obj = user.User.get_by_id(result["user_id"])
        item.user = user_obj
        return item

    @classmethod
    def delete_item_by_id(cls, item_id):
        data = {
            "id": item_id
        }
        query = "DELETE FROM item WHERE ID = %(id)s;"
        connectToMySQL(DB).query_db(query, data)
        return item_id

    @classmethod
    def updated_item(cls, item_dict, session_id):
        item = cls.get_by_id(item_dict["id"])
        if item.user.id != session_id:
            flash("You cannot update this.")
            return False

        if not cls.is_valid(item_dict):
            return False
        
        query = "UPDATE item SET name = %(name)s, location = %(location)s, description = %(description)s WHERE id = %(id)s;"
        result = connectToMySQL(DB).query_db(query,item_dict)
        item = cls.get_by_id(item_dict["id"])
        return item

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM item JOIN users ON item.user_id=users.id"
        item_data = connectToMySQL(DB).query_db(query)
        items = []
        for item in item_data:
            item_obj = cls(item)
            item_obj.user= user.User(
                {
                    "id":item["user_id"],
                    "first_name": item["first_name"],
                    "last_name": item["last_name"],
                    "email": item["email"],
                    "password": item["password"],
                    "created_at": item["created_at"],
                    "updated_at": item["updated_at"]
                }
            )
            items.append(item_obj)
        return items

    @staticmethod
    def is_valid(item_dict):
        valid = True
        if len(item_dict["name"]) < 3:
            valid = False
            flash("Name must be atleast 3 characters!")
        if len(item_dict["location"]) < 3:
            valid = False
            flash("Location must be atleast 3 characters!")
        if len(item_dict["description"]) < 3:
            valid = False
            flash("Description must be atleast 3 characters!")
        return valid