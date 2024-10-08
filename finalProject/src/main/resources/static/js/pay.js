function payOk(){
    const form = new FormData();
    console.log(document.querySelector("#idx").value);
    console.log(document.querySelector("#phone").value);
    form.set("product_idx",document.querySelector("#idx").value);
    form.set("phone",document.querySelector("#phone").value);
    form.set("address",document.querySelector("#address").value);
    form.set("login_id",document.querySelector("#login_id").value);
    form.set("detailAddress",document.querySelector("#detailAddress").value);
    form.set("price",document.querySelector("#price").textContent);
    form.set("count",document.querySelector("#count").textContent);
    console.log(form);
     axios.post('/payOk',form).then(res=>{
            console.log(res.data);
            alert("주문이 성공적으로 완료되었습니다.");
            location.href="/";
        }).catch(error=>console.log(error));
}

function findPost(){
    new daum.Postcode({
        oncomplete: function(data) {
           console.log(data);
           const address = data.address;
           document.querySelector("#address").value=address;
        }
    }).open();
}
function requestPay(){
    IMP.init('imp87545385'); // 가맹점 식별코드 입력
    IMP.request_pay({
        pg: "inicis",           // 등록된 pg사 (적용된 pg사는 KG이니시스)
        pay_method: "card",           // 결제방식: card(신용카드), trans(실시간계좌이체), vbank(가상계좌), phone(소액결제)
        merchant_uid : 'merchant_'+new Date().getTime(),
        name : '결제테스트',
        amount : 100,
        buyer_email : 'iamport@siot.do',
        buyer_name : '구매자',
        buyer_tel : '010-1234-5678',
        buyer_addr : '서울특별시 강남구 삼성동',
        buyer_postcode : '123-456'    // 우편번호
    }, function (rsp) {
        if (rsp.success) {
            var mesg = '결제가 완료되었습니다.';

            // 겅증 후 결제 정보 & 주문 정보 DB 저장

        } else {
            var msg = '결제를 실패하였습니다.';
            alert(msg);
            console.log(rsp);
        }
    }
    );
}