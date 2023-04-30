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
	console.log(visitors);
}
writeOutVisitors();
