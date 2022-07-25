from flask import Flask, render_template, session, redirect, request
from flask_app import app
from flask_app.models.user import User
from flask_app.models.magazine import Magazine
from flask import flash

@app.route("/magazines/home")
def magazines_home():
    if "user_id" not in session:
        flash("Login to access dashboard")
        return redirect("/")
    user = User.get_by_id(session["user_id"])
    magazine = Magazine.get_all()

    return render_template("home.html", user=user, magazine=magazine)

@app.route("/magazine/<int:magazine_id>")
def magazine_detail(magazine_id):
    user = User.get_by_id(session["user_id"])
    magazine = Magazine.get_by_id(magazine_id)
    return render_template("magazine_detail.html", user=user, magazine=magazine)

@app.route("/magazine/create")
def magazine_create_page():
    return render_template("create_magazine.html")

@app.route("/magazine/edit/<int:magazine_id>")
def magazine_edit_page(magazine_id):
    magazine = Magazine.get_by_id(magazine_id)
    return render_template("edit_magazine.html", magazine=magazine)

@app.route("/magazines", methods=["POST"])
def create_magazine():
    valid_magazine = Magazine.create_valid_magazine(request.form)
    if valid_magazine:
        return redirect(f"/magazine/{valid_magazine.id}")
    return redirect("/magazine/create")

@app.route("/magazine/<int:magazine_id>", methods=["POST"])
def update_magazine(magazine_id):
    valid_magazine = Magazine.updated_magazine(request.form, session["user_id"])
    if not valid_magazine:
        return redirect (f"/magazine/edit/{magazine_id}")
    return redirect(f"/magazine/{magazine_id}")

@app.route("/magazine/delete/<int:magazine_id>")
def delete_by_id(magazine_id):
    Magazine.delete_magazine_by_id(magazine_id)
    return redirect("/magazines/home")