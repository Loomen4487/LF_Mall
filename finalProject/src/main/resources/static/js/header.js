document.querySelector(".HeaderNew_inputSearch__bCive").addEventListener("keyup",function(e){
    if(e.key==='Enter'){
        location.href='/women/search/'+e.target.value;
    }
})
const recentProduct = document.querySelector(".RecentHistory_noRecent__wvj1J");
const item = localStorage.getItem("list").split(",");
item.forEach(it=>{
    console.log(it);
})
