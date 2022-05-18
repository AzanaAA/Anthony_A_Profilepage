function hide(element) {
    element.remove();
}

function change(element) {
    if(element.innerText == "Login") {
        element.innerText = "Logout"
    } else {
        element.innerText = "Login"
}
}