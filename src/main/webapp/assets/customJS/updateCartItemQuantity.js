async function updateQuantity(cartItemId, newQuantity) {
    const response = await fetch('?controller=UpdateCartItemQuantityController', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `cartItemId=${cartItemId}&newQuantity=${newQuantity}`,
    });

    if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
    }

    const updatedCartItem = await response.json();

    document.querySelector(`#totalAmount .num-product`).value = updatedCartItem.quantity;
    document.querySelector(`#totalAmount .column-5`).textContent = '$ ' 
    + (updatedCartItem.product.productPrice * updatedCartItem.quantity);
}