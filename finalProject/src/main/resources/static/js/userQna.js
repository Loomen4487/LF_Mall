function selectedDelete(){
    const input = document.querySelectorAll(".delynChkAll");
    input.forEach(item=>{
        if(item.checked){
            const idx = item.getAttribute("alt");
            if(confirm("삭제하시겠습니까?")){
                axios.delete("/mypage/qna/delete/"+idx)
                .then(res=>{
                    alert("삭제가 완료되었습니다.");
                    location.href="/mypage/qna";
                })
                .catch(error=>console.log(error));
            }
        }
    })
}