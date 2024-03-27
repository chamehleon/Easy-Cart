
function validateName() {
    console.log('name validation');
    var name = document.getElementById('name').value;
    var nameError = document.getElementById('nameError');
    var regex = /^[a-zA-Z\s]+$/;

    if (!regex.test(name)) {
        nameError.textContent = 'Name must contain characters only.';
        return false;
    } else {
        nameError.textContent = '';
        return true;
    }
}

// Function to validate birthdate
function validateBirthdate() {
    var birthdate = document.getElementById('birthdate').value;
    var birthdateError = document.getElementById('birthdateError');

    if (birthdate === '') {
        birthdateError.textContent = 'Birthdate must not be empty.';
        return false;
    } else {
        birthdateError.textContent = '';
        return true;
    }
}

function validateEmail(){
    console.log('Email validation');
    var email = this.value;
    console.log("email" +email)
    var data = new URLSearchParams();
    data.append('email', email);
    console.log("data" + data)

    fetch('front?controller=CheckEmailServlet', {
        method: 'POST',
        body: data
    })
        .then(response => response.text())
        .then(data => {
            console.log(data);
            if(data==="true") {
                document.getElementById("emailError").textContent = 'Email already exists';
            } else {
                document.querySelector('#emailError').textContent = '';
            }
        })
        .catch(error => {
            console.log('An error occurred while checking the email:', error);
        });
}
// Function to validate password
function validatePassword() {
    var password = document.getElementById('password').value;
    var passwordError = document.getElementById('passwordError');
    var regex = /^(?=.*\d).{8,}$/;

    if (!regex.test(password)) {
        passwordError.textContent = 'Password must be at least 8 characters long and contain numbers.';
        return false;
    } else {
        passwordError.textContent = '';
        return true;
    }
}

// Function to validate city, country, and streetName
function validateText(id) {
    var text = document.getElementById(id).value;
    var textError = document.getElementById(id + 'Error');
    var regex = /^[a-zA-Z\s]+$/;

    if (!regex.test(text)) {
        textError.textContent = id.charAt(0).toUpperCase() + id.slice(1) + ' must contain characters only.';
        return false;
    } else {
        textError.textContent = '';
        return true;
    }
}
//create account

// Add event listeners to the form fields
document.getElementById('name').addEventListener('blur', validateName);
document.getElementById('email').addEventListener('blur', validateEmail);
document.getElementById('birthdate').addEventListener('blur', validateBirthdate);
document.getElementById('password').addEventListener('blur', validatePassword);
// document.getElementById('confirm_password').addEventListener('blur', validatePassword);
document.getElementById('city').addEventListener('blur', function() { validateText('city'); });
document.getElementById('country').addEventListener('blur', function() { validateText('country'); });
document.getElementById('streetName').addEventListener('blur', function() { validateText('streetName');});
