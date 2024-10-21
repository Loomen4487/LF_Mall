document.addEventListener('DOMContentLoaded', function () {
    var swipers = document.querySelectorAll('.swiper');

    // 첫 번째 Swiper 초기화
    var swiperOne = new Swiper(swipers[0], {
        direction: 'horizontal',
        loop: true,
        pagination: {
            el: swipers[0].querySelector('.swiper-pagination'),
            clickable: true,
        },
        slidesPerView: 1,
        spaceBetween: 20,
    });

    // 두 번째 Swiper 초기화 (2개씩 보이기)
    var swiperTwo = new Swiper(swipers[1], {
        direction: 'horizontal',
        loop: false, //
        pagination: {
            el: swipers[1].querySelector('.swiper-pagination'),
            clickable: true,
        },
        slidesPerView: 3, // 두 개씩 보이기
        spaceBetween: 10,
    });

    var swiperTwo = new Swiper(swipers[2], {
            direction: 'horizontal',
            loop: true, // 루프하지 않음
            pagination: {
                el: swipers[1].querySelector('.swiper-pagination'),
                clickable: true,
            },
            slidesPerView: 4, // 두 개씩 보이기
            spaceBetween: 10,
        });

        var swiperTwo = new Swiper(swipers[3], {
                    direction: 'horizontal',
                    loop: true, // 루프하지 않음
                    pagination: {
                        el: swipers[1].querySelector('.swiper-pagination'),
                        clickable: true,
                    },
                    slidesPerView: 2, // 두 개씩 보이기
                    spaceBetween: 10,
                });
});