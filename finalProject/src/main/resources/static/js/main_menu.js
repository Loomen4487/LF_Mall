document.addEventListener('DOMContentLoaded', function () {
    var swipers = document.querySelectorAll('.swiper');
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


    var swiperTwo = new Swiper(swipers[1], {
        direction: 'horizontal',
        loop: false,
        pagination: {
            el: swipers[1].querySelector('.swiper-pagination'),
            clickable: true,
        },
        slidesPerView: 3,
        spaceBetween: 10,
    });

    var swiperThree = new Swiper(swipers[2], {
            direction: 'horizontal',
            loop: true,
            pagination: {
                el: swipers[2].querySelector('.swiper-pagination'),
                clickable: true,
            },
            slidesPerView: 4,
            spaceBetween: 10,
        });

        var swiperFour = new Swiper(swipers[3], {
            direction: 'horizontal',
            loop: true,
            pagination: {
                el: swipers[3].querySelector('.swiper-pagination'),
                clickable: true,
            },
            slidesPerView: 2,
            spaceBetween: 10,
        });

        var swiperFive = new Swiper(swipers[8], {
            direction: 'horizontal',
            loop: true,
            pagination: {
                el: swipers[8].querySelector('.swiper-pagination'),
                clickable: true,
            },
            slidesPerView: 4,
            spaceBetween: 10,
        });

        const tabs = document.querySelectorAll("#tabs li");

                tabs.forEach(tab => {
                    tab.addEventListener("click", function() {

                        tabs.forEach(item => item.classList.remove("CardTab_on__sgS2b"));


                        this.classList.add("CardTab_on__sgS2b");

                        // 필요하다면 여기에 내용 전환 로직 추가 가능
                    });
                });
});