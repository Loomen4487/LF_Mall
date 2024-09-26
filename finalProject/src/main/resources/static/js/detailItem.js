et count = document.querySelector("#count").value;
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
const info = document.querySelectorAll(".ProductDetail_tabList__G8yFd>li");
const infoUl = document.querySelector(".info-list");
let infoIdx=0;
info.forEach((item,index)=>{
    item.addEventListener("click",function(){
        infoUl.children[infoIdx].classList.remove("selected");
        infoUl.children[infoIdx].children[1].style.display="none";
        this.classList.add("selected");
        this.children[1].style.display="block";
        infoIdx = index;
    })
})
