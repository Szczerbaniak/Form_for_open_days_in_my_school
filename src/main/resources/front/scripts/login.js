/** @format */

const mainContainer = document.querySelector(".center"); // getting main div in form
const scale = (window.innerHeight * 0.4) / mainContainer.clientHeight; // getting scale so form would be 90% of website height
mainContainer.style.transform = `scale(${scale})`; // scaling form

const givenUsername = document.querySelector("input[name='username']");
const givenPassword = document.querySelector("input[name='password']");
const loginBtn = document.querySelector("#loginBtn");

loginBtn.addEventListener("click", () => {
	const admin = {
		username: givenUsername.value,
		password: givenPassword.value,
		accountType: "test",
	};

	console.log("Sending data: " + JSON.stringify(admin));

	fetch("http://localhost:8080/visitors/isAdminCorrect", {
		method: "POST",
		body: JSON.stringify(admin),
		headers: {
			"Content-type": "application/json; charset=UTF-8",
		},
	})
		.then((response) => {
			if (response.ok) {
				sessionStorage.setItem("login", givenUsername.value);
				sessionStorage.setItem("password", givenPassword.value);
				location.href = "adminPanel.html";
			} else {
				return Promise.reject(response);
			}
		})
		.catch((error) => {
			console.warn("Something went wrong.", error);
		});
});
