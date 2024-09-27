
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