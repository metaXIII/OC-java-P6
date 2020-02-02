let temp = document.querySelectorAll(".temporal_message")
temp.forEach(e =>
    setTimeout(() => e.style.display = "none", 2000)
)