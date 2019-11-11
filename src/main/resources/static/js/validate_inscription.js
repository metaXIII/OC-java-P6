let form = document.getElementById("register")
let user = document.getElementById("username")
let password = document.getElementById("password")
let check_password = document.getElementById("check_password")
let email = document.getElementById("email")
let check_email = document.getElementById("check_email")
let valid = document.getElementById("valid")
let form_create_user = document.getElementById("form_create_user")

function isValid() {
    if (valid.checked === true) {
        form.disabled = !((password.value && password.value === check_password.value) && (email.value && email.value === check_email.value));
    }
}

function disable() {
    valid.checked = false
}

check_email.addEventListener("focus", () => {
    disable()
})

email.addEventListener("focus", () => {
    disable()
})

check_password.addEventListener("focus", () => {
    disable()
})

password.addEventListener("focus", () => {
    disable()
})

user.addEventListener("focus", () => {
    disable()
})

valid.addEventListener("click", () => {
    isValid()
})

form_create_user.addEventListener("change", () => {
    isValid()
})