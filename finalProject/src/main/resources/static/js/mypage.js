function selectedDelete(){
    const option = document.querySelectorAll(".deleteIdx");
    option.forEach(item=>{
        if(item.checked){
            const idx = item.getAttribute("alt");
            axios.delete('/orderDeleteOk?idx='+idx)
               .then(res=>{
                   alert("삭제가 완료되었습니다.");
                   location.reload();
               }).catch(error=>console.log(error));

        }
    });
}
const vue = new Vue({
    el:".orderList",
    data:{
        orderDateList:[]
    }
})
let date = 1;
function orderSearch(){
    axios.get('/mypage/orderDateList/'+date)
    .then(res=>{
        console.log(res.data.length);
        vue.orderDateList=res.data;
    }).catch(error=>console.log(error));
}
orderSearch(12);
const tbtn = document.querySelectorAll(".tbtn");
let tbtnIdx=0;
tbtn.forEach((item,index)=>{
    item.addEventListener("click",function(){
        tbtn[tbtnIdx].classList.remove("sel");
        this.classList.add("sel");
        date = this.getAttribute("about");
        tbtnIdx=index;
    })
})