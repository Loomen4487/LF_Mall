function productDelete(idx){
    axios.delete('/mypage/mybag/delete/'+idx)
    .then((res)=>{
        alert(res.data);
        location.reload();
    }).catch(error=>console.log(error));
}