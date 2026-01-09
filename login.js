alert("welcome");

function validate(event) {
    event.preventDefault(); 


    let name = document.getElementById("name").value.trim();
    if (name === "") {
        document.getElementById("errorname").innerText = "Enter valid name";
        return;
    }

    let phone = document.getElementsByClassName("phone")[0].value.trim();
    let p = /^\d{10}$/;
    if (!p.test(phone)) {
        document.getElementById("errorphone").innerText = "Enter valid phone number";
        return;
    }

    let email = document.getElementById("email").value.trim();
    let e = /^[^@]+@gmail\.com$/;
    if (!e.test(email)) {
        document.getElementById("erroremail").innerText = "Enter valid email!";
        return;
    }


    let pass = document.getElementById("pass").value.trim();
    if (pass.length < 6) {
        document.getElementById("errorpass").innerText = "Password should contain minimum 6 characters!";
        return;
    }

    alert("Form submitted successfully!");
}
