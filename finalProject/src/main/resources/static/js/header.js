document.querySelector(".HeaderNew_inputSearch__bCive").addEventListener("keyup",function(e){
    if(e.key==='Enter'){
        location.href='/women/search/'+e.target.value;
    }
})
const vue = new Vue({
    el:"#recentProduct",
    data:{
        productList:[]
    }
})

axios.put('/detailItem/recentProduct')
.then(res=>{
    const data = res.data;
    vue.productList = res.data;
}).catch(error=>console.log(error));