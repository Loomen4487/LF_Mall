<!-- Swiper JS -->
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

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

const swiper = new Swiper('.swiper-item', {
  // Optional parameters
  direction: 'vertical',
  loop: true,
  slidesPerGroup: 4,

  // If we need pagination
  pagination: {
    el: '.swiper-pagination-item',
  },

  // Navigation arrows
  navigation: {
    nextEl: '.swiper-button-next-item',
    prevEl: '.swiper-button-prev-item',
  },

  // And if we need scrollbar
  scrollbar: {
    el: '.swiper-scrollbar-item',
  },
});