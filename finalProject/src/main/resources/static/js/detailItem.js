let count = document.querySelector("#count").value;
const plus = document.querySelector(".plus");
plus.addEventListener("click",function(){
    count++;
    document.querySelector("#count").value=count;
})
const minus = document.querySelector(".minus");
minus.addEventListener("click",function(){
    if(count>1)count--;
    document.querySelector("#count").value=count;
})
