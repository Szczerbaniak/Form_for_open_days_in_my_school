/** @format */

const mainContainer = document.querySelector(".center"); // getting main div in form

const scale = (window.innerHeight * 0.9) / mainContainer.clientHeight; // getting scale so form would be 90% of website height

mainContainer.style.transform = `scale(${scale})`; // scaling form

const visitorName = document.querySelector("input[name='name']");
const visitorSecondName = document.querySelector("input[name='secName']");
const visitorSurname = document.querySelector("input[name='surname']");
const visitorPesel = document.querySelector("input[name='pesel']");
let visitorNameOfIdentityDocument = document.querySelector(
	"input[name='nameOfIdentityDocument']"
);
let visitorNumberOfIdentityDocument = document.querySelector(
	"input[name='numberOfIdentityDocument']"
);
const visitorEmail = document.querySelector("input[name='email']");
const visitorPhoneNumber = document.querySelector("input[name='phoneNumber']");
const visitorSchoolName = document.querySelector("input[name='schoolName']");
const visitorLocality = document.querySelector("input[name='locality']");
const visitorMajor = document.querySelector("input[name='major]");
const noPeselOptions = document.querySelector(".template");
const noPeselButton = document.querySelector(".no_pesel_button");
const sendButton = document.querySelector("#send");

noPeselButton.addEventListener("click", () => {
	noPeselOptions.classList.remove("template");
	noPeselButton.style.display = "none";
	visitorPesel.parentElement.style.display = "none";
	visitorPesel.value = null;
});

sendButton.addEventListener("click", () => {
	const visitorData = {
		name: visitorName.value,
		secondName: visitorSecondName.value,
		surname: visitorSurname.value,
		pesel: visitorPesel.value,
		nameOfIdentityDocument: visitorNameOfIdentityDocument.value,
		numberOfIdentityDocument: visitorNumberOfIdentityDocument.value,
		email: visitorEmail.value,
		phoneNumber: visitorPhoneNumber.value,
		schoolName: visitorSchoolName.value,
		locality: visitorLocality.value,
		major: "none",
		choiceNumber: 1,
	};

	console.log("Sending data: " + JSON.stringify(visitorData));

	fetch("http://localhost:8080/visitors/addVisitor", {
		method: "POST",
		body: JSON.stringify(visitorData),
		headers: {
			"Content-type": "application/json; charset=UTF-8",
		},
	})
		.then((response) => {
			if (response.ok) {
				console.info("data added to the table");
				window.alert("twoje dane zostały wysłane");
			} else {
				return Promise.reject(response);
			}
		})
		.catch((error) => {
			console.warn("Something went wrong.", error);
		});
});
