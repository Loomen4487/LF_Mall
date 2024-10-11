function selectedDelete(){
    const option = document.querySelectorAll(".deleteIdx");
    option.forEach(item=>{
        if(item.checked){
            const idx = item.getAttribute("alt");
            axios.delete('/orderDeleteOk?idx='+idx)
               .then(res=>{
                   location.reload();
               }).catch(error=>console.log(error));

        }
    });
}
const vue = new Vue({
    el:"#orderList",
    data:{
        orderDateList:[]
    }
})
const vue2 = new Vue({
    el:"#orderList2",
    data:{
        count:0
    }
})

let date = 1;
function orderSearch(){
    axios.get('/mypage/orderDateList/'+date)
    .then(res=>{
        console.log(res.data.length);
        vue.orderDateList=res.data;
        vue2.count = res.data.length;
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