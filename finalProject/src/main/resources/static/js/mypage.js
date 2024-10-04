function selectedDelete(){
    const option = document.querySelectorAll(".deleteIdx");
    option.forEach(item=>{
        if(item.checked){
            const idx = item.getAttribute("alt");
            axios.delete('/orderDeleteOk?idx='+idx)
               .then(res=>{
                   alert("삭제가 완료되었습니다.");
                   location.reload();
               }).catch(error=>console.log(error));

        }
    });
}