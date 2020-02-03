console.log("hello")

let elements = document.querySelectorAll(".btn-danger")
elements.forEach(el => {
    el.setAttribute("disabled", "true")
    el.setAttribute("href", "#")
    el.textContent = "Indisponible"
})