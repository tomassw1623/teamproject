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
    // 여기에 로그아웃 기능을 추가하세요
    alert("로그아웃 되었습니다.");
}

function customerMyPage() {
    window.location.href = "/customer/cusmy_page";
}

function  ceoMyPage() {
    window.location.href = "/ceo/ceomy_page";
}

function prevPage() {
    // 이전 페이지로 이동하는 기능을 여기에 추가하세요
    alert("이전 페이지로 이동합니다.");
}

function nextPage() {
    // 다음 페이지로 이동하는 기능을 여기에 추가하세요
    alert("다음 페이지로 이동합니다.");
}

// 로그아웃 기능
document.addEventListener("DOMContentLoaded", function () {
    document
        .getElementById("logoutButton")
        .addEventListener("click", function () {
            fetch("/logout", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
            })
                .then((response) => {
                    if (response.ok) {  //  로그아웃 클릭 시 메인 페이지로 리다이렉트
                        window.location.href = "templates/index.html";
                    } else {
                        alert("로그아웃 실패");
                    }
                })
                .catch((error) => {
                    console.error("Error:", error);
                    alert("로그아웃 중 오류가 발생했습니다.");
                });
        });
});

document.getElementById("mypage").addEventListener("click", userMyPage);
document.getElementById("myPageButton").addEventListener("click", ceoMyPage);


document
    .getElementById("infoForm")
    .addEventListener("submit", function (event) {
        // 사용자 정보 수정 폼 제출 처리
        event.preventDefault();
        const formData = new FormData(this);

        fetch("/updateInfo", {
            method: "POST",
            body: formData,
        })
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                // 성공 메시지 또는 페이지 리로드 등
            })
            .catch((error) => {
                console.error("Error:", error);
            });
    });

document
    .getElementById("storeInfoForm")
    .addEventListener("submit", function (event) {
        // 가게 정보 수정 폼 제출 처리
        event.preventDefault();
        const formData = new FormData(this);

        fetch("/updateStoreInfo", {
            method: "POST",
            body: formData,
        })
            .then((response) => response.json())
            .then((data) => {
                console.log(data);
                // 성공 메시지 또는 페이지 리로드 등
            })
            .catch((error) => {
                console.error("Error:", error);
            });
    });
