const footer = new Vue({
    el:"#result",
    data:{
        noticeList:[]
    }
})

axios.get('/notice/select/0')
.then(res=>{
    footer.noticeList = res.data;
})
.catch(error=>console.log(error));