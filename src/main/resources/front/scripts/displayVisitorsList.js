/** @format */

async function getVisitors() {
	const response = await fetch("http://localhost:8080/visitors/getVisitors", {
		method: "POST",
		headers: {
			"Content-type": "application/json; charset=UTF-8",
		},
		body: JSON.stringify({
			username: sessionStorage.getItem("login"),
			password: sessionStorage.getItem("password"),
		}),
	});

	try {
		const visitors = await response.json();
		return visitors;
	} catch (error) {
		console.warn(error);
	}
}

async function writeOutVisitors() {
	const visitors = await getVisitors();
	const tableBody = document.querySelector("#visitors > tbody");

	console.log(visitors);
	visitors.forEach((visitor) => {
		const template = document.querySelector("#row").content.cloneNode(true);
		template.querySelector(".id").textContent = visitor.id;
		template.querySelector(".name").textContent = visitor.name;
		template.querySelector(".secondName").textContent = visitor.secondName;
		template.querySelector(".surname").textContent = visitor.surname;
		template.querySelector(".pesel").textContent = visitor.pesel;
		template.querySelector(".nameOfIdentityDocument").textContent = visitor.nameOfIdentityDocument;
		template.querySelector(".numberOfIdentityDocument").textContent = visitor.numberOfIdentityDocument;
		template.querySelector(".email").textContent = visitor.email;
		template.querySelector(".phoneNumber").textContent = visitor.phoneNumber;
		template.querySelector(".school").textContent = visitor.school;
		template.querySelector(".locality").textContent = visitor.locality;
		template.querySelector(".major").textContent = visitor.major;
		template.querySelector(".choiceNumber").textContent = visitor.choiceNumber;
		tableBody.appendChild(template);
	});
}

writeOutVisitors();
