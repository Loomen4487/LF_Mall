

//const swiper = new Swiper('.swiper', {
//    direction: 'horizontal', // 수평 슬라이드
//    loop: true, // 마지막 슬라이드에서 첫 번째 슬라이드로 순환
//    slidesPerView: 2, // 화면에 한 번에 보일 슬라이드 개수 (610px씩 두 개 보이도록 설정)
//    spaceBetween: 20, // 슬라이드 간의 간격
//    pagination: {
//        el: '.swiper-pagination', // 페이지네이션 요소
//        clickable: true, // 페이지네이션을 클릭하여 슬라이드 이동 가능
//    },
//    navigation: {
//        nextEl: '.swiper-button-next', // 다음 슬라이드 버튼
//        prevEl: '.swiper-button-prev', // 이전 슬라이드 버튼
//    },
//});

// 첫 번째 슬라이더 (2개씩 보이게 설정)
const swiper1 = new Swiper('.swiper1', {
    direction: 'horizontal', // 수평 슬라이드
    loop: true, // 마지막 슬라이드에서 첫 번째 슬라이드로 순환
    slidesPerView: 2, // 한 번에 2개 보이도록 설정
    spaceBetween: 20, // 슬라이드 간의 간격
    pagination: {
        el: '.swiper1 .swiper-pagination', // 페이지네이션 요소
        clickable: true, // 페이지네이션을 클릭하여 슬라이드 이동 가능
    },
    navigation: {
        nextEl: '.swiper1 .swiper-button-next', // 다음 슬라이드 버튼
        prevEl: '.swiper1 .swiper-button-prev', // 이전 슬라이드 버튼
    },
});

// 두 번째 슬라이더 (4개씩 보이게 설정)
const swiper2 = new Swiper('.swiper2', {
    direction: 'horizontal', // 수평 슬라이드
    loop: true, // 마지막 슬라이드에서 첫 번째 슬라이드로 순환
    slidesPerView: 4, // 한 번에 4개 보이도록 설정
    spaceBetween: 20, // 슬라이드 간의 간격
    pagination: {
        el: '.swiper2 .swiper-pagination', // 페이지네이션 요소
        clickable: true, // 페이지네이션을 클릭하여 슬라이드 이동 가능
    },
    navigation: {
        nextEl: '.swiper2 .swiper-button-next', // 다음 슬라이드 버튼
        prevEl: '.swiper2 .swiper-button-prev', // 이전 슬라이드 버튼
    },
});
const cloth = document.querySelectorAll(".CardTab_item__3Ze14");
let clothIdx = 0;
let idx = document.querySelector("#idx").value;
cloth.forEach((item,index)=>{
    item.addEventListener("click",function(){
        cloth[clothIdx].classList.remove("CardTab_on__sgS2b");
        this.classList.add("CardTab_on__sgS2b");
        clothIdx = index;
        if(index==0)getData(idx);
        else getData(idx*1000+index*100+1);
        console.log("idx ",idx*1000+index*100+1);
    })
})

const clothVue = new Vue({
    el:"#clothList",
    data:{
        productClothList:[]
    }
})
getData(idx);
function getData(idx){
    axios.get("/woman_cloth/selectAll/"+idx)
    .then(res=>{
        console.log(res.data);
        clothVue.productClothList = res.data;
    }).catch(error=>console.log(error));
}