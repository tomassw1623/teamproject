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
                    if (response.ok) {
                        window.location.href = "/login";
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

function updateGraphs(menuId) {
    // 예시 데이터, 실제 데이터는 서버에서 가져와야 함
    const barGraphData = {
        1: "1월 매출 데이터",
        2: "2월 매출 데이터",
        3: "3월 매출 데이터",
        4: "4월 매출 데이터",
        5: "5월 매출 데이터",
        6: "6월 매출 데이터",
        7: "7월 매출 데이터",
        8: "8월 매출 데이터",
        9: "9월 매출 데이터",
        10: "10월 매출 데이터",
        11: "11월 매출 데이터",
        12: "12월 매출 데이터",
    };

    const pieChartData = {
        1: "메뉴 1 판매 비율",
        2: "메뉴 2 판매 비율",
        3: "메뉴 3 판매 비율",
        4: "메뉴 4 판매 비율",
        5: "메뉴 5 판매 비율",
        6: "메뉴 6 판매 비율",
        7: "메뉴 7 판매 비율",
        8: "메뉴 8 판매 비율",
        9: "메뉴 9 판매 비율",
        10: "메뉴 10 판매 비율",
        11: "메뉴 11 판매 비율",
        12: "메뉴 12 판매 비율",
    };

    // 그래프 업데이트
    document.getElementById("barGraph").textContent = barGraphData[menuId];
    document.getElementById("pieChart").textContent = pieChartData[menuId];
}
