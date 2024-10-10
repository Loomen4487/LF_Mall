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
function reviewDelete(idx){
    if(confirm("삭제하시겠습니까? ")){
        axios.delete('/mypage/review/delete/'+idx)
        .then(()=>{
            alert("삭제가 완료되었습니다.");
            location.reload();
        }).catch((error)=>{
            console.log(error);
            alert("삭제가 취소되었습니다.");
        })
    }
}