// cart.js
function loadProductsToCart() {
  var cartProducts = localStorage.getItem("cartProducts");
  if (cartProducts) {
    var products = JSON.parse(cartProducts);
    var cartList = document.querySelector(".header-cart-wrapitem");
    cartList.innerHTML = "";
    products.forEach(function(product) {
      console.log("first", product)
      var productHTML = `
        <li class="header-cart-item flex-w flex-t m-b-12">
          <div class="header-cart-item-img">
            <img src=https://i.postimg.cc/KjYxNhTR/gallery-08.jpg alt="Product Image">
          </div>
          <div class="header-cart-item-txt p-t-8">
            <a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">${product.name}</a>
            <span class="header-cart-item-info">${product.quantity} x ${product.price}</span>
          </div>
        </li>
      `;
      cartList.insertAdjacentHTML("beforeend", productHTML);
    });
  }
}
