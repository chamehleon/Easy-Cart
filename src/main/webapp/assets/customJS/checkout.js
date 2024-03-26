function proceedToCheckout(){
      fetch("front?controller=CheckoutController", {
        method: "GET"
      })
          .then((response) => response.text())
          .then((data) => {
            if (data == "Insufficient credit") {
              console.log("credit error");
    //          document.getElementById("checkoutError").innerText = data;
            } else if(data == "checkout is done bro"){
              window.location.href ="front?controller=CheckoutSuccessController";

            }
            else{
              console.log("out of stock");
    //          document.getElementById("checkoutError").innerText = data;
            }
          })
          .catch((error) => {
            console.log("An error occurred while checkout:", error);
          });
    }