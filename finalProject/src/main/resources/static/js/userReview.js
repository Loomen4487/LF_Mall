const button = document.querySelectorAll(".ProductReview_tabButton__b-uRp button");
const review = document.querySelectorAll(".review-container>div");
let buttonIdx = 0;
button.forEach((item,index)=>{
    item.addEventListener("click",function(){
        button[buttonIdx].classList.remove("ProductReview_on__GXXfd");
        review[buttonIdx].style.display="none";
        this.classList.add("ProductReview_on__GXXfd");
        buttonIdx=index;
        review[buttonIdx].style.display="block";
    })
})
