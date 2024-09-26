$(document).ready(function() {
    // Swiper 초기화 후 실행
    document.querySelector('.mySwiper').addEventListener('init', function() {
        console.log('Swiper 초기화 완료');
        pageNumber__Init();  // Swiper 초기화 후 페이지 번호 설정
        updateCurrentPageNumber();  // 초기 페이지 번호 업데이트

        var swiperInstance = document.querySelector('.mySwiper').swiper;

        // 슬라이드 변경 시 페이지 번호 업데이트
        swiperInstance.on('slideChange', function() {
            console.log('슬라이드 변경됨');
            updateCurrentPageNumber();
        });
    });

    // Swiper 초기화
    var swiper = new Swiper('.mySwiper', {
        // Swiper의 옵션을 필요에 따라 설정
        spaceBetween: 30,
        slidesPerView: 'auto',
        pagination: {
            el: '.swiper-pagination',
            clickable: true
        },
        loop: true,
        autoplay: true
    });

    // 페이지 번호 초기화 함수
    function pageNumber__Init() {
        var swiperInstance = document.querySelector('.mySwiper').swiper;

        if (swiperInstance) {
            console.log('Swiper 인스턴스 초기화 완료:', swiperInstance);
        } else {
            console.log('Swiper 인스턴스 초기화 실패');
            return;
        }

        // 슬라이드 총 개수 가져오기
        var totalSlideNo = swiperInstance.slides.length;
        console.log('총 슬라이드 수:', totalSlideNo);

        // 총 슬라이드 수를 페이지네이션에 업데이트
        $('.swiper-pagination-total').text(totalSlideNo);

        // 각 슬라이드에 data-slide-no 속성 추가
        swiperInstance.slides.forEach(function(slide, index) {
            $(slide).attr('data-slide-no', index + 1);
            console.log(`슬라이드 ${index + 1}에 data-slide-no 속성 추가`);
        });
    }

    // 현재 페이지 번호 업데이트 함수
    function updateCurrentPageNumber() {
        var swiperInstance = document.querySelector('.mySwiper').swiper;

        if (!swiperInstance) {
            console.log('Swiper 인스턴스를 찾을 수 없음');
            return;
        }

        // 현재 활성 슬라이드 인덱스 (1부터 시작)
        var currentSlideNo = swiperInstance.activeIndex + 1;
        var totalSlideNo = swiperInstance.slides.length;

        console.log('현재 슬라이드 번호:', currentSlideNo);
        console.log('총 슬라이드 수:', totalSlideNo);

        // 현재 슬라이드 번호를 페이지네이션에 업데이트
        $('.swiper-pagination-current').text(currentSlideNo);
        $('.swiper-pagination-total').text(totalSlideNo);
    }
});
