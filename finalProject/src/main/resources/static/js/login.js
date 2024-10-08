const li = document.querySelectorAll(".Login_loginTab__WvaCW li");
li.forEach((item,index)=>{
    const ul = document.querySelector(".Login_loginTab__WvaCW");
    item.addEventListener("click",function(){
        if(index==0){
            document.querySelector(".react-tabs__tab-panel").style.display="block";
            document.querySelector(".NonMemberLogin_loginForm__0ZEjI").style.display="none";
            ul.children[0].classList.add("Login_active__7sJr5");
            ul.children[1].classList.remove("Login_active__7sJr5");
        }else{
            document.querySelector(".react-tabs__tab-panel").style.display="none";
            document.querySelector(".NonMemberLogin_loginForm__0ZEjI").style.display="block";
            ul.children[1].classList.add("Login_active__7sJr5");
            ul.children[0].classList.remove("Login_active__7sJr5");
        }
    })
})