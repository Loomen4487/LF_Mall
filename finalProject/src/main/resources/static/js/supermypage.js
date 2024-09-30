const list = new Vue({
    el:"#listAll",
    data:{
        itemList:[]
    }
})
getData(0);
function getData(idx){
    const startNo = idx>0?(idx-1)*16:0;
    axios.get('/superMyPage/selectOrderListAll/'+startNo)
    .then(res=>{
        console.log(res.data);
        list.itemList = res.data;
    }).catch(error=>console.log(error));
}