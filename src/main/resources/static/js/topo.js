let el = document.getElementById("topo_selection")
let els = document.querySelectorAll(".result_topos")

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
        }
    })
}

function showAll() {
    els.forEach((e) => {
        e.style.display = "flex"
        e.nextElementSibling.style.display = "flex"
    })
}