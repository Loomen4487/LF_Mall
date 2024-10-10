const menu = document.querySelectorAll(".menu-list");
console.log(menu);
let menuIdx = 0;
menu.forEach((item,index)=>{
    item.addEventListener("click",function(){
        menu[menuIdx].classList.remove("CardTab_on__sgS2b");
        this.classList.add("CardTab_on__sgS2b");
        menuIdx = index;
    })
})
 const swiper = new Swiper(".swiper.swiper-initialized.swiper-horizontal.mySwiper", {
  slidesPerView:4,
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
});