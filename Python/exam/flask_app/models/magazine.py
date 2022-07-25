from flask_app import app
from flask_app.config.mysqlconnection import connectToMySQL
from flask import flash
from flask_bcrypt import Bcrypt
from flask_app.models import user
import re

bcrypt = Bcrypt(app)

EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')

DB = "exam_schema"

class Magazine:

    def __init__(self, magazine):
        self.id = magazine["id"]
        self.name = magazine["name"]
        self.description = magazine["description"]
        self.created_at = magazine["created_at"]
        self.updated_at = magazine["updated_at"]
        self.user = None


    @classmethod
    def create_valid_magazine(cls, magazine_dict):
        if not cls.is_valid(magazine_dict):
            return False
        
        query = "INSERT INTO magazine (name, description,user_id) VALUES(%(name)s, %(description)s,%(user_id)s);"
        magazine_id = connectToMySQL(DB).query_db(query, magazine_dict)
        magazine = cls.get_by_id(magazine_id)
        return magazine

    @classmethod
    def get_by_id(cls, magazine_id):
        data = {
            "id": magazine_id
        }
        query = "SELECT * FROM magazine WHERE id = %(id)s;"
        result = connectToMySQL(DB).query_db(query,data)[0]
        magazine = cls(result)
        user_obj = user.User.get_by_id(result["user_id"])
        magazine.user = user_obj
        return magazine

    @classmethod
    def delete_magazine_by_id(cls, magazine_id):
        data = {
            "id": magazine_id
        }
        query = "DELETE FROM magazine WHERE ID = %(id)s;"
        connectToMySQL(DB).query_db(query, data)
        return magazine_id

    @classmethod
    def updated_magazine(cls, magazine_dict, session_id):
        magazine = cls.get_by_id(magazine_dict["id"])
        if magazine.user.id != session_id:
            flash("You cannot update this.")
            return False

        if not cls.is_valid(magazine_dict):
            return False
        
        query = "UPDATE magazine SET name = %(name)s, description = %(description)s WHERE id = %(id)s;"
        result = connectToMySQL(DB).query_db(query,magazine_dict)
        magazine = cls.get_by_id(magazine_dict["id"])
        return magazine

    @classmethod
    def get_all(cls):
        query = "SELECT * FROM magazine JOIN users ON magazine.user_id=users.id"
        magazine_data = connectToMySQL(DB).query_db(query)
        magazines = []
        for magazine in magazine_data:
            magazine_obj = cls(magazine)
            magazine_obj.user= user.User(
                {
                    "id": magazine["user_id"],
                    "first_name": magazine["first_name"],
                    "last_name": magazine["last_name"],
                    "email": magazine["email"],
                    "password": magazine["password"],
                    "created_at": magazine["created_at"],
                    "updated_at": magazine["updated_at"]
                }
            )
            magazines.append(magazine_obj)
        return magazines

    @staticmethod
    def is_valid(magazine_dict):
        valid = True
        if len(magazine_dict["name"]) < 3:
            valid = False
            flash("Name must be atleast 3 characters!")
        if len(magazine_dict["description"]) < 3:
            valid = False
            flash("Description must be atleast 3 characters!")
        return valid