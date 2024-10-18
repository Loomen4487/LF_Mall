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
    prevEl: ".swiper-button-prev",<<<<<<< HEAD
                                  <link
                                    rel="stylesheet"
                                    href="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.css"
                                  />

                                  <script src="https://cdn.jsdelivr.net/npm/swiper@11/swiper-bundle.min.js"></script>
                                  <!-- Swiper JS -->
                                  <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

                                  <script>
                                    const swiper = new Swiper('.swiper', {
                                      // Optional parameters
                                      direction: 'vertical',
                                      loop: true,
                                      slidesPerGroup: 4,

                                      // If we need pagination
                                      pagination: {
                                        el: '.swiper-pagination',
                                      },

                                      // Navigation arrows
                                      navigation: {
                                        nextEl: '.swiper-button-next',
                                        prevEl: '.swiper-button-prev',
                                      },

                                      // And if we need scrollbar
                                      scrollbar: {
                                        el: '.swiper-scrollbar',
                                      },
                                    });
                                  </script>
                                  =======
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
                                  >>>>>>> 4c9655d5c22b4a23d4a977e9864d4e027987f07b

  },
});