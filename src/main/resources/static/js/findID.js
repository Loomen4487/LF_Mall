function verify(){
    const data = document.cookie.split(";");
    const codeInput = document.querySelector("#code").value;
    data.forEach(item=>{
        const str = item.split("=");
        if(str[0]==="code"){
            if(str[1]===codeInput)location.href="/login/successFindID";
            else alert("인증번호가 다릅니다.");
            return;
        }
    })
}

function receiveCode(){
    const phone = document.querySelector("#phone").value;
    axios.post('/findID',{
        phone
    }).then(res=>{
        console.log(res);
        alert("요청되었습니다.");
        const data = res.data;
    })
    .catch((error)=>{
        console.log(error);
    })
}