document.querySelector('#email').addEventListener('blur', function() {
    var email = this.value;
    var data = new URLSearchParams();
    data.append('email', email);

    fetch('?controller=CheckEmailServlet', {
        method: 'POST',
        body: data
    })
    .then(response => response.json())
    .then(data => {
        if(data.emailExists) {
            // Set the text of the emailError span element
            document.querySelector('#emailError').textContent = 'Email already exists';
        } else {
            // Clear the text of the emailError span element
            document.querySelector('#emailError').textContent = '';
        }
    })
    .catch(error => {
        console.log('An error occurred while checking the email:', error);
    });
});