function paging(idx){
    const startNo = (idx-1)*5;
    axios.get('/notice/select/'+startNo)
    .then(res=>{
        notice.notice_data=res.data;
    })
    .catch(error=>console.log(error));
}
axios.get('/notice/select/'+0)
    .then(res=>{
        notice.notice_data=res.data;
    })
    .catch(error=>console.log(error));
const notice = new Vue({
    el:"#result2",
    data:{
        notice_data:[]
    },
    filters:{
        yyyyMMdd:function(value){
          const date = new Date(value);
          const year = date.getFullYear();
          const month = date.getMonth() + 1;
          const day = date.getDate();
          return year+'-'+month+'-'+day;
        }
    }
})