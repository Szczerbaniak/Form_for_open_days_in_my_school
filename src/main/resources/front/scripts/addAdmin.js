/** @format */

fetch("http://localhost:8080/visitors/addAdmin", {
	method: "POST",
	body: JSON.stringify({
		currentAdmin: admin,
		adminToTakeActionOn: {
			username: "test",
			password: "test",
		},
	}),
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
