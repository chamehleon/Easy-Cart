    // Get the JSON data from the request attribute
    var productsJson = '${requestScope.productsJson}';

    // Parse the JSON data
    var products = JSON.parse(productsJson);

    // Get the container that will contain the product divs
    var productContainer = document.querySelector('.row.isotope-grid');

    // Clear the container
    productContainer.innerHTML = '';

    // Create a new div for each product
    products.forEach(function(product) {
        var productDiv = `
            <div class="col-sm-6 col-md-4 col-lg-3 p-b-35 isotope-item women">
                <div class="block2">
                    <div class="block2-pic hov-img0">
                        <img src="${product.productImage}" alt="IMG-PRODUCT">
                        <a href="#" class="block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1">
                            Quick View
                        </a>
                    </div>
                    <div class="block2-txt flex-w flex-t p-t-14">
                        <div class="block2-txt-child1 flex-col-l ">
                            <a href="product-detail.html" class="stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6">
                                ${product.productName}
                            </a>
                            <span class="stext-105 cl3">
                                $${product.productPrice}
                            </span>
                        </div>
                        <div class="block2-txt-child2 flex-r p-t-3">
                            <a href="#" class="btn-addwish-b2 dis-block pos-relative js-addwish-b2">
                                <img class="icon-heart1 dis-block trans-04" src="../assets/images/icons/icon-heart-01.png" alt="ICON">
                                <img class="icon-heart2 dis-block trans-04 ab-t-l" src="../assets/images/icons/icon-heart-02.png" alt="ICON">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        `;

        // Append the product div to the container
        productContainer.innerHTML += productDiv;
    });
