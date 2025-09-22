function menu(menuId){
    document.querySelectorAll(".menu").forEach(div => {
    div.classList.remove("actif");
    });
    document.getElementById(menuId).classList.add("actif");
}

document.querySelectorAll(".bouton-menu").forEach(btn => {
    btn.addEventListener("click", () => {
        menu(btn.getAttribute("data-target"));
    });
});
