function addAllLocalStorageItemsToDB() {
  console.log("addAllLocalStorageItemsToDB called");

  // Retrieve cartItems from localStorage or define it if needed
  const cartItems = JSON.parse(localStorage.getItem('cartItems')) || [];
   console.log("cartItems", cartItems);

  // Convert cartItems to JSON
  const jsonData = JSON.stringify(cartItems);

  // Send JSON data to backend using fetch
  fetch("front?controller=CheckoutController", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: jsonData
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Failed to send checkout request');
    }
    console.log("Checkout request sent successfully");
    // Assuming the checkout request was sent successfully
  })
  .catch(error => {
    console.error("Error sending checkout request:", error);
    // Optionally, handle the case where checkout fails
  });
}
