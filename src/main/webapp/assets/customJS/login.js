function goToHomePage() {

  window.location.href = "front?controller=HomeController";
}

function login(event) {
  event.preventDefault();
  validateLogin().then(isValid => {
    if(isValid) {
      goToHomePage();
      var email = document.getElementById("email").value;
      var password = document.getElementById("password").value;
      var data = new URLSearchParams();
      var cartItems = JSON.parse(localStorage.getItem("cartItems")) || [];
      var productIds = cartItems.map((item) => item.productId);
      var quantities = cartItems.map((item) => item.quantity);
      data.append("email", email);
      data.append("password", password);
      data.append("productIds", JSON.stringify(productIds)); // Convert to JSON string before sending
      data.append("quantities", JSON.stringify(quantities)); // Convert to JSON string before sending
      fetch("front?controller=LoginController", {
        method: "POST",
        body: data,
        headers: {
          "Content-Type": "application/x-www-form-urlencoded",
        },
      })
          .then((response) => response.json())
          .then((data) => {

            data.forEach((productData) => {
              // Create a product object from the response
              var product = {
                productId: productData.productId,
                productName: productData.productName,
                productPrice: productData.productPrice,
                productDescription: productData.productDescription,
                productImage: productData.productImage,
                quantity: productData.productQuantity, // You may adjust the quantity as needed
              };

              // Add the product to cartItems
              cartItems.push(product);

              // console.log("Product added to cart:", product);
            });
            // Update cartItems in localStorage
            localStorage.setItem("cartItems", JSON.stringify(cartItems));
          })

          .catch((error) => {
            console.log(
                "An error occurred while adding the product to the cart:",
                error
            );
          })
          .finally(() => {
            document.getElementById("freezeDiv").style.display = "none"; // Hide the freeze div
          });
    }
    else{
      document.querySelector('#loginError').textContent = 'Invalid email or password. Please try again.';
    }
  });


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
        if(data==="false") {
          document.querySelector('#loginError').textContent = 'Invalid email or password. Please try again.';
        } else {
          document.getElementById("loginError").textContent = '';

        }
      })
      .catch(error => {
        console.log('An error occurred while checking the email:', error);
      });
}
function validateLogin(){
  console.log('pass validation');
  var email = document.getElementById("email").value;
  var password = document.getElementById("password").value;
  console.log("password" +password)
  var data = new URLSearchParams();
  data.append('email', email);
  data.append('password', password);

  console.log("data" + data);

  return fetch('front?controller=CheckLoginServlet', {
    method: 'POST',
    body: data
  })
      .then(response => response.text())
      .then(data => {
        console.log(data);
        if(data==="false") {
          document.querySelector('#loginError').textContent = 'Invalid email or password. Please try again.';
          return false;
        } else {
          document.getElementById("loginError").textContent = '';
          return true;

        }
      })
      .catch(error => {
        console.log('An error occurred while checking the email:', error);
        return false;
      });
}
document.getElementById('email').addEventListener('blur', validateEmail);
document.getElementById('password').addEventListener('blur', validateLogin);

