document.querySelector('#btn').onclick = function(){
    callapi();
}
function callapi(){
    const apiPath = 'https://fakestoreapi.com/products1121';
    fetch(apiPath);
    var res = fetch(apiPath);
    console.log(res);
    
}