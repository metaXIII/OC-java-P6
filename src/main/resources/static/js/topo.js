let el = document.getElementById("topo_selection")
let els = document.querySelectorAll(".result_topos")
let disabled = document.querySelectorAll(".disabled_element")

hide();
el.addEventListener("change", (e) => {
    if (e.target.value == 1) {
        hide()
    } else
        showAll()
})

function hide() {
    els.forEach((e) => {
        if (e.classList.contains("available")) {
            e.style.display = "flex"
            e.nextElementSibling.style.display = "flex"
        } else {
            e.style.display = "none"
            e.nextElementSibling.style.display = "none"
            disabled.forEach(e => {
                e.setAttribute("disabled", true);
                e.parentElement.removeAttribute("href")
                e.style.backgroundColor = "#721c24"
            })
        }
    })
}

function showAll() {
    els.forEach((e) => {
        e.style.display = "flex"
        e.nextElementSibling.style.display = "flex"
    })
}