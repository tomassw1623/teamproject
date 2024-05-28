function showForm(formType) {
    const businessForm = document.getElementById("business-form");
    const userForm = document.getElementById("user-form");
    const businessTab = document.getElementById("business-tab");
    const userTab = document.getElementById("user-tab");

    if (formType === "business") {
        businessForm.style.display = "flex";
        userForm.style.display = "none";
        businessTab.classList.add("active");
        userTab.classList.remove("active");
    } else {
        businessForm.style.display = "none";
        userForm.style.display = "flex";
        businessTab.classList.remove("active");
        userTab.classList.add("active");
    }
}

// 초기 상태 설정
window.onload = function () {
    showForm("business");
};

function logout() {
    // 로그아웃 기능 추가
}