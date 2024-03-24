function updateCount() {
    // Retrieve cart items from local storage
    const cartItems = JSON.parse(localStorage.getItem("cartItems"));
  
    // Get the length of the cartItems array
    const cartItemCount = cartItems ? cartItems.length : 0;
  
    // Update data-notify attribute of the div element
    const cartIcons = document.querySelectorAll(".cart-count");
  
    // Loop through each element and update the data-notify attribute
    cartIcons.forEach((cartIcon) => {
      cartIcon.setAttribute("data-notify", cartItemCount);
    });
  }
  
  
  window.onload = updateCount();