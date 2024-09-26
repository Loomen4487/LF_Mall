function findPost(){
    new daum.Postcode({
        oncomplete: function(data) {
           console.log(data);
           const address = data.address;
           document.querySelector("#address").value=address;
        }
    }).open();
}