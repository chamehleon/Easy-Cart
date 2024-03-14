$(document).ready(function() {
    $.ajax({
        url: '/ecommerce/LoginStatusServlet',
        type: 'POST',
        success: function(response) {
            if(response.isLoggedIn) {
                // User is logged in
                $('#accountLink').text('My Account');
                // $('#accountLink').attr('href', 'front/?controller=MyAccountController');
            } else {
                // User is not logged in
                $('#accountLink').text('Register');
                $('#accountLink').attr('href', 'front/?controller=RegisterController');
            }
        },
        error: function() {
            console.log('An error occurred while checking the login status.');
        }
    });
});