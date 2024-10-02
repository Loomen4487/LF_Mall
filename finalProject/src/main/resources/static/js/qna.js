const vue = new Vue({
    el:"#qna",
    data:{
        qnaList:[]
    },filters:{
      yyyyMMdd:function(value){
        const date = new Date(value);
        const year = date.getFullYear();
        const month = date.getMonth() + 1;
        const day = date.getDate();
        return year+'-'+month+'-'+day;
      }
  }
})
function getData(){
    axios.get('/superMyPage/qnaAll')
    .then(res=>{
        console.log(res.data);
        vue.qnaList = res.data;
    }).catch(error=>console.log(error));
}
getData();