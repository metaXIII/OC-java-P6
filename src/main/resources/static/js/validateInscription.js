document.getElementById("condition").addEventListener("change", (e) => {
    if (e.target.checked === true)
        document.getElementById("buttonSubmitted").removeAttribute("disabled", "false")
    else
        document.getElementById("buttonSubmitted").setAttribute("disabled", "true")
})