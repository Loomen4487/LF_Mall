const av = document.querySelector(".HeaderNew_inputSearch__bCive");
av.addEventListener("keyup",function(e){
    if(e.key==='Enter'){
        location.href='/women/search/'+e.target.value;
    }
})
const vue2 = new Vue({
    el:"#recentProduct",
    data:{
        productList:[]
    }
})

axios.get('/detailItem/recentProduct')
.then(res=>{
    const data = res.data;
    console.log(data);
    vue2.productList = res.data;
}).catch(error=>console.log(error));