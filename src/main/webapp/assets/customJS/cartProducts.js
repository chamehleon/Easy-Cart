// cart.js
//function loadProductsToCart() {
//  var cartProducts = localStorage.getItem("cartProducts");
//  if (cartProducts) {
//    var products = JSON.parse(cartProducts);
//    var cartList = document.querySelector(".header-cart-wrapitem");
//    cartList.innerHTML = "";
//    products.forEach(function(product) {
//      console.log("first", product)
//      var productHTML = `
//        <li class="header-cart-item flex-w flex-t m-b-12">
//          <div class="header-cart-item-img">
//            <img src=https://i.postimg.cc/KjYxNhTR/gallery-08.jpg alt="Product Image">
//          </div>
//          <div class="header-cart-item-txt p-t-8">
//            <a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">${product.name}</a>
//            <span class="header-cart-item-info">${product.quantity} x ${product.price}</span>
//          </div>
//        </li>
//      `;
//      cartList.insertAdjacentHTML("beforeend", productHTML);
//    });
//  }
//}

function loadProductsToCart() {
  var cartProducts = localStorage.getItem("cartItems");
  if (cartProducts) {
    var products = JSON.parse(cartProducts);
    var cartList = document.querySelector(".header-cart-wrapitem");
    cartList.innerHTML = ""; // Clear existing content
    var totalPrice = 0;
    products.forEach(function (product) {
      var listItem = document.createElement("li");
      listItem.classList.add("header-cart-item", "flex-w", "flex-t", "m-b-12");

      var itemImage = document.createElement("div");
      itemImage.classList.add("header-cart-item-img");
      var img = document.createElement("img");
      img.src = product.productImage;
      img.alt = "Product Image";
      itemImage.appendChild(img);

      var itemText = document.createElement("div");
      itemText.classList.add("header-cart-item-txt", "p-t-8");
      var itemName = document.createElement("a");
      itemName.href = "#";
      itemName.classList.add(
        "header-cart-item-name",
        "m-b-18",
        "hov-cl1",
        "trans-04"
      );
      itemName.textContent = product.productName;
      var itemInfo = document.createElement("span");
      itemInfo.classList.add("header-cart-item-info");
      itemInfo.textContent = product.quantity + " x " + product.productPrice;
      totalPrice += product.quantity * product.productPrice;

      // Event listener for removing item when clicking on the image
      itemImage.addEventListener("click", function (event) {
        event.stopPropagation(); // Preventing the click event from bubbling up to the parent list item
        removeItem(product.productId);
      });

      // Event listener for redirecting to product detail page when clicking on the product name
      itemName.addEventListener("click", function (event) {
        event.preventDefault(); // Preventing the default link behavior
        var productId = product.productId;
        var url =
          "front?controller=ProductDetailController&productId=" + productId;
        console.log("url " + url);
        window.location.href = url;
      });

      itemText.appendChild(itemName);
      itemText.appendChild(itemInfo);

      listItem.appendChild(itemImage);
      listItem.appendChild(itemText);

      cartList.appendChild(listItem);
    });
    // Update total price element
    var totalPriceElement = document.querySelector(".header-cart-total");
    totalPriceElement.textContent = "Total: $" + totalPrice.toFixed(2); // Format total price to 2 decimal places
  }
}

document.addEventListener("DOMContentLoaded", function () {
  loadProductsToCart();
});

function removeItem(productId) {
  var cartItems = JSON.parse(localStorage.getItem("cartItems"));
  var updatedCartItems = cartItems.filter(
    (item) => item.productId !== productId
  );
  localStorage.setItem("cartItems", JSON.stringify(updatedCartItems));
  loadProductsToCart(); // Refresh cart display after removing item
  updateCount(); // header.js
  removeCartItemFromDB(productId); // cartHandler.js
}

function removeCartItemFromDB(id) {
 var data = new URLSearchParams();
 data.append("productId", id);
 console.log("Inside remove from db method js");
 fetch("front?controller=AddToCartController&productId=" + id, {
   method: "GET"
 })
   .then(() => {
    swal("Item removed from cart", "", "success");
     console.log("Item removal request sent successfully");
     // Assuming the removal request was sent successfully
     console.log("Item removed from cart (assumed)");
   })
   .catch((error) => {
     console.log(
       "An error occurred while removing the product from the cart:",
       error
     );
     console.log("Failed to remove item from cart (assumed)");
     // Optionally, handle the case where item removal fails
   });
}
