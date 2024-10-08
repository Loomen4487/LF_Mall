function openAddressForm() {
    // 새로운 창을 팝업으로 엶
    window.open('/addAddressForm', '배송지 추가', 'width=600,height=600');
}
function openUpdateAddressForm(idx) {
    // 새 창을 열고 서버에 분리된 데이터를 전달
    window.open('/updateAddressForm/' + idx, '배송지 수정', 'width=600,height=600');
}

function submitForm() {

    // 전화번호 필드를 합침
    const receiver = document.getElementById("receiver").value;
    const phone1 = document.getElementById("phone1").value;
    const phone2 = document.getElementById("phone2").value;
    const phone3 = document.getElementById("phone3").value;
    const postcode = document.getElementById("sample6_postcode").value;
    const address2 = document.getElementById("sample6_address").value;
    const address3 = document.getElementById("sample6_extraAddress").value;
    const detailAddress = document.getElementById("sample6_detailAddress").value;

    const address1 = "[" + postcode + "] "
    // 입력값 확인
    if(!receiver) {
        alert("받는 분에 이름을 입력해주세요")
        return
    }

    if (!phone1 || !phone2 || !phone3) {
        alert("전화번호를 정확히 입력해주세요.");
        return;  // 폼 전송 중지
    }

    const address = address1 + address2 + address3;
    const phone = phone1 + phone2 + phone3;

    if (!address) {
        alert("주소를 입력해주세요.");
        return;  // 폼 전송 중지
    }

    if (!detailAddress) {
        alert("상세주소를 입력해주세요.");
        return;  // 폼 전송 중지
    }

    // 숨겨진 필드에 합친 값을 설정
    document.getElementById("phone").value = phone;
    document.getElementById("address").value = address;
    document.getElementById("detailAddress").value = detailAddress;

    // AJAX를 통해 비동기 요청
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "/insertAddress", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    // 요청이 성공했을 때
    xhr.onload = function() {
        if (xhr.status === 200) {
            alert("배송지가 등록되었습니다");  // 알림창 띄우기
            window.close();  // 창 닫기
        } else {
            alert("오류가 발생했습니다. 다시 시도해주세요.");
        }
    };

    // 폼 데이터 전송
    const params = "phone=" + encodeURIComponent(phone) +
        "&address=" + encodeURIComponent(address) + "&detailAddress=" + encodeURIComponent(detailAddress)
    + "&receiver=" + encodeURIComponent(receiver);
    xhr.send(params);
}

function submitForm2() {

    // 전화번호 필드를 합침
    const receiver = document.getElementById("receiver").value;
    const delivery_idx = document.getElementById("delivery_idx").value;
    const phone1 = document.getElementById("phone1").value;
    const phone2 = document.getElementById("phone2").value;
    const phone3 = document.getElementById("phone3").value;
    const postcode = document.getElementById("sample6_postcode").value;
    const address2 = document.getElementById("sample6_address").value;
    const address3 = document.getElementById("sample6_extraAddress").value;
    const detailAddress = document.getElementById("sample6_detailAddress").value;

    const address1 = "[" + postcode + "] "
    // 입력값 확인
    if(!receiver) {
        alert("받는 분에 이름을 입력해주세요")
        return
    }

    if (!phone1 || !phone2 || !phone3) {
        alert("전화번호를 정확히 입력해주세요.");
        return;  // 폼 전송 중지
    }

    const address = address1 + address2 + address3;
    const phone = phone1 + phone2 + phone3;

    if (!address) {
        alert("주소를 입력해주세요.");
        return;  // 폼 전송 중지
    }

    if (!detailAddress) {
        alert("상세주소를 입력해주세요.");
        return;  // 폼 전송 중지
    }

    // 숨겨진 필드에 합친 값을 설정
    document.getElementById("phone").value = phone;
    document.getElementById("address").value = address;
    document.getElementById("detailAddress").value = detailAddress;

    /*
    *  const receiver = document.getElementById("receiver").value;
    const delivery_idx = document.getElementById("delivery_idx").value;
    const phone1 = document.getElementById("phone1").value;
    const phone2 = document.getElementById("phone2").value;
    const phone3 = document.getElementById("phone3").value;
    const postcode = document.getElementById("sample6_postcode").value;
    const address2 = document.getElementById("sample6_address").value;
    const address3 = document.getElementById("sample6_extraAddress").value;
    const detailAddress = document.getElementById("sample6_detailAddress").val
    *
    * */

    axios.post('/updateAddress',{
        receiver,
        delivery_idx,
        phone,
        address,
        detailAddress
    }).then(res=>{
        alert("배송지가 수정되었습니다.");
        window.close();
    })
        .catch(error=>{
            alert("오류가 발생했습니다. 다시 시도해주세요.");
        });
    // AJAX를 통해 비동기 요청
    // const xhr = new XMLHttpRequest();
    // xhr.open("POST", "/updateAddress", true);
    // xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    //
    // // 요청이 성공했을 때
    // xhr.onload = function() {
    //     if (xhr.status === 200) {
    //         alert("배송지가 수정되었습니다 ",delivery_idx);  // 알림창 띄우기
    //         window.close();  // 창 닫기
    //     } else {
    //         alert("오류가 발생했습니다. 다시 시도해주세요.");
    //     }
    // };
    //
    // // 폼 데이터 전송
    // const params = "phone=" + encodeURIComponent(phone) +
    //     "&address=" + encodeURIComponent(address) + "&detailAddress=" + encodeURIComponent(detailAddress)
    //     + "&receiver=" + encodeURIComponent(receiver) + "&delivery_idx" +encodeURIComponent(delivery_idx);
    // xhr.send(params);
}


function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;

            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}


