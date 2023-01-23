from flask import Flask, render_template, session, redirect, request
from flask_app import app
from flask_app.models.user import User
from flask_app.models.item import Item
from flask import flash

@app.route("/items/home")
def items_home():
    if "user_id" not in session:
        flash("Login to access dashboard")
        return redirect("/")
    user = User.get_by_id(session["user_id"])
    item = Item.get_all()

    return render_template("home.html", user=user, item=item)

@app.route("/item/<int:item_id>")
def item_detail(item_id):
    user = User.get_by_id(session["user_id"])
    item = Item.get_by_id(item_id)
    return render_template("item_detail.html", user=user, item=item)

@app.route("/item/create")
def item_create_page():
    return render_template("create_item.html")

@app.route("/item/edit/<int:item_id>")
def item_edit_page(item_id):
    item = Item.get_by_id(item_id)
    return render_template("edit_item.html", item=item)

@app.route("/items", methods=["POST"])
def create_item():
    valid_item = Item.create_valid_item(request.form)
    if valid_item:
        return redirect(f"/item/{valid_item.id}")
    return redirect("/item/create")

@app.route("/item/<int:item_id>", methods=["POST"])
def update_item(item_id):
    valid_item = Item.updated_item(request.form, session["user_id"])
    if not valid_item:
        return redirect (f"/item/edit/{item_id}")
    return redirect(f"/item/{item_id}")

@app.route("/item/delete/<int:item_id>")
def delete_by_id(item_id):
    Item.delete_item_by_id(item_id)
    return redirect("/items/home")