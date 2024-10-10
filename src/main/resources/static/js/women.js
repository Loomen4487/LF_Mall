
// 모든 타이틀을 배열로 가져옴
const filterTitles = document.querySelectorAll('.SearchFilter_listTitArea__Y8Lav');

// 각 타이틀에 클릭 이벤트 추가
filterTitles.forEach(function(filterTitle) {
    filterTitle.addEventListener('click', function (event) {
        event.preventDefault();  // 링크 이동 방지
        const filterWrap = filterTitle.closest('.SearchFilter_filterWrap__aZhv8');
        filterWrap.classList.toggle('active');  // 하위 목록 토글
    });
});
function throttle(func, limit) {
   let lastRan = 0; // 마지막 실행 시간을 저장

   return function(...args) {
       const context = this;
       const now = Date.now();

       if (now - lastRan >= limit) {
           func.apply(context, args);
           lastRan = now; // 마지막 실행 시간을 현재 시간으로 업데이트
       }
   };
}
const vue = new Vue({
    el:"#womenList",
    data:{
        vueWomenList:[]
    }
})
let prev = 1;
let max=1;
const idx = document.querySelector("#idx").value;
const major_idx=idx;
const middle_idx=idx;
const ref=idx;
axios.get('/womenSelectAll',{
            params:{
                major_idx,
                middle_idx,
                ref,
                pageSize:max
            }
        })
        .then(res=>{
            console.log(res.data);
            vue.vueWomenList = res.data;
        }).catch(error=>console.log(error));
window.addEventListener('scroll', throttle(function() {
    const pageSize = (parseInt)((window.scrollY-1)/1250)+1;
    if(pageSize!=prev){
        console.log(pageSize);
        prev=pageSize;
        if(pageSize>max){
            max=pageSize;
        }
        axios.get('/womenSelectAll',{
            params:{
                major_idx,
                middle_idx,
                ref,
                pageSize:max
            }
        })
        .then(res=>{
            console.log(res.data);
            vue.vueWomenList = res.data;
        }).catch(error=>console.log(error));
    }
}, 500));
function viewProduct(idx){
    const data = localStorage.getItem("list");
    const li = [];
    console.log(li);
    axios.get('/viewProduct/'+idx)
    .then(res=>{
        li.push([data,res.data.idx]);
        localStorage.setItem("list",li);
        location.href="/detailItem/"+idx;
    })
}