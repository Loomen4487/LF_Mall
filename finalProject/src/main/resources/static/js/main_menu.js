function fetchNames() {
            const name = document.getElementById('nameInput').value; // 입력 필드에서 값 가져오기
            const url = `/main_menu?name=${encodeURIComponent(name)}`; // API URL 생성

            // AJAX 요청
            fetch(url)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json(); // JSON으로 변환
                })
                .then(data => {
                    const resultDiv = document.getElementById('result');
                    resultDiv.innerHTML = ''; // 이전 결과 지우기
                    data.forEach(item => {
                        const para = document.createElement('p'); // 새로운 문단 요소 생성
                        para.textContent = item; // 이름 설정
                        resultDiv.appendChild(para); // 결과 DIV에 추가
                    });
                })
                .catch(error => {
                    console.error('Error fetching data:', error);
                });
        }