function redirect(button) {
    if (button.innerText == "Register") {
        window.location.href = '/register';
    } else if (button.innerText == "Log in") {
        window.location.href = '/login';
    }
}


function becomeCandidate() {
    // Get the username from the page (assuming it's inside an element with ID 'loggeduser')
    let userName = document.getElementById("loggeduser").textContent;

    // Prepare the data as a JSON object
    const data = { name: userName };

    // Send the POST request with JSON data in the body
    axios.post('/becomeCandidate', data, {
        headers: {
            'Content-Type': 'application/json'  // Ensures the server understands it's JSON data
        },
        withCredentials: true  // Include cookies (session data) if needed for authentication
    })
    .then(response => {
        console.log("Successfully sent the request!");
    })
    .catch(error => {
        console.error("There was an error with the request", error);
    });
}