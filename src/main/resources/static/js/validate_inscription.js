let form = document.getElementById("register")
let user = document.getElementById("username")
let password = document.getElementById("password")
let check_password = document.getElementById("check_password")
let email = document.getElementById("email")
let check_email = document.getElementById("check_email")
let valid = document.getElementById("valid")
let form_create_user = document.getElementById("form_create_user")

form.setAttribute("disabled", "disabled")

function isValid() {
    if (valid.checked === true) {
        form.disabled = !((password.value && password.value === check_password.value) && (email.value && email.value === check_email.value));
    }
}

function disable() {
    valid.checked = false
    form.disabled = true
}

check_email.addEventListener("keyup", () => {
    disable()
})

email.addEventListener("keyup", () => {
    disable()
})

check_password.addEventListener("keyup", () => {
    disable()
})

password.addEventListener("keyup", () => {
    disable()
})

user.addEventListener("keyup", () => {
    disable()
})

valid.addEventListener("click", () => {
    isValid()
})

form_create_user.addEventListener("change", () => {
    isValid()
})