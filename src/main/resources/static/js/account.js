console.log("hello")

let elements = document.querySelectorAll(".btn-danger")
elements.forEach(el => {
    el.textContent = "En réservation"
})