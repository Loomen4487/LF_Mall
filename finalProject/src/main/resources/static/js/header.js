document.querySelector(".HeaderNew_inputSearch__bCive").addEventListener("keyup",function(e){
    if(e.key==='Enter'){
        location.href='/women/search/'+e.target.value;
    }
})