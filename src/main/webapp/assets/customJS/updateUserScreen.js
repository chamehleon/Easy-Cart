$(".js-select2").each(function () {
    $(this).select2({
      minimumResultsForSearch: 20,
      dropdownParent: $(this).next(".dropDownSelect2"),
    });
  });

  $(".js-pscroll").each(function () {
    $(this).css("position", "relative");
    $(this).css("overflow", "hidden");
    var ps = new PerfectScrollbar(this, {
      wheelSpeed: 1,
      scrollingThreshold: 1000,
      wheelPropagation: false,
    });

    $(window).on("resize", function () {
      ps.update();
    });
  });
let pageNumber = 1 ; 
function showOrders() {
    let orderElement  = document.getElementById("orders");
    let  userD = document.getElementById("userData");
    let  MyProfileButton = document.getElementById("MyProfileButton");
    let  MyOrderButton = document.getElementById("MyOrderButton");
    
    userD.style.display = "none";
    orderElement.style.display = "block";
    MyProfileButton.style.color = "grey";
    MyOrderButton.style.color = "";
    $.ajax({
        type: 'POST',
        url: '?controller=UserOrdersController',
        data: { page: pageNumber },
        success: function(response) {
          pageNumber  = pageNumber + 1 ;
          populateOrders(response);
        },
        error: function(xhr, status, error) {
            // Handle errors that occur during the AJAX request
            console.error('Failed to submit form. Status:', status);
        }
    });
    
  }
  function populateOrders(response) {
    var ordersDiv = document.getElementById('orders');
    var reloadButton = document.getElementById('reloadButton');
    var flag =false;
    if (reloadButton) {
        reloadButton.remove();
    }
    for (var order in response) {
      flag = true;
        if (response.hasOwnProperty(order)) {
            var orderItems = response[order];
            var orderId = "#" + order.substring(order.indexOf("(") + 4, order.indexOf(","));
            var orderDate = order.substring(order.indexOf("orderedAt=") + 10, order.indexOf(")"));

           
            var orderCard = document.createElement('div');
            orderCard.id = 'order-' + orderId;
            orderCard.className = 'card m-4';
            
            var cardHeader = document.createElement('h5');
            cardHeader.className = 'card-header';
            cardHeader.textContent = 'Order ID: ' + orderId + ', Ordered At: ' + orderDate;
            
            var cardBody = document.createElement('div');
            cardBody.className = 'card-body';
            
            orderItems.forEach(function(item) {
                var title = document.createElement('h5');
                title.className = 'card-title';
                title.textContent = item.productName;
                
                var text = document.createElement('p');
                text.className = 'card-text';
                text.textContent = 'Price: ' + item.productPrice + ', Quantity: ' + item.quantity;
                
                // var removeButton = document.createElement('a');
                // removeButton.href = '#';
                // removeButton.className = 'btn btn-primary';
                // removeButton.textContent = 'Remove';
                
                cardBody.appendChild(title);
                cardBody.appendChild(text);
                // cardBody.appendChild(removeButton);
            });
            
            orderCard.appendChild(cardHeader);
            orderCard.appendChild(cardBody);
            
            ordersDiv.appendChild(orderCard);
        }
    }
    if(flag){
      var reloadButton = document.createElement('button');
      reloadButton.textContent = 'Reload Orders';
      reloadButton.id = 'reloadButton';
      reloadButton.className = 'flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer';
      reloadButton.addEventListener('click', function() {
          // Reload orders
          showOrders();
      });
      
      ordersDiv.appendChild(reloadButton);
    }
    
}

  function showUserData() {
    
    let orderElement  = document.getElementById("orders");
    let  userD = document.getElementById("userData");
    let  MyProfileButton = document.getElementById("MyProfileButton");
    let  MyOrderButton = document.getElementById("MyOrderButton");

    userD.style.display = "flex";
    orderElement.style.display = "none";
    MyOrderButton.style.color = "grey";
    MyProfileButton.style.color = "";
    console.log("predss");
  }

  $(document).ready(function() {
  $('#customerForm').submit(function(event) {
      // Prevent the default form submission
      event.preventDefault();
      
      // Serialize the form data
      var formData = $(this).serialize();
      
      // Send the form data asynchronously using AJAX
      $.ajax({
          type: 'POST',
          url: '?controller=UpdateUserInfoController',
          data: formData,
          success: function(response) {
            if(response.text == true ){
                  console.log("true")
                }else{
                  console.log("false")
                }
          },
          error: function(xhr, status, error) {
              // Handle errors that occur during the AJAX request
              console.error('Failed to submit form. Status:', status);
          }
      });
  });
});

function createOrderComponent(orderTitle, orderText) {
    // Create elements
    var orderDiv = document.createElement("div");
    orderDiv.className = "card m-4";

    var header = document.createElement("h5");
    header.className = "card-header";
    header.textContent = "Order : ";

    var bodyDiv = document.createElement("div");
    bodyDiv.className = "card-body";

    var title = document.createElement("h5");
    title.className = "card-title";
    title.textContent = orderTitle;

    var text = document.createElement("p");
    text.className = "card-text";
    text.textContent = orderText;
    //
    // var removeBtn = document.createElement("a");
    // removeBtn.href = "#";
    // removeBtn.className = "btn btn-primary";
    // removeBtn.textContent = "Remove";
    // removeBtn.addEventListener("click", function() {
    //     orderDiv.remove(); // Remove this order when the button is clicked
    // });

    // Assemble elements
    bodyDiv.appendChild(title);
    bodyDiv.appendChild(text);
    // bodyDiv.appendChild(removeBtn);

    orderDiv.appendChild(header);
    orderDiv.appendChild(bodyDiv);

    // Append the order component to the #orders element
    document.getElementById("orders").appendChild(orderDiv);
}

// Example usage:
