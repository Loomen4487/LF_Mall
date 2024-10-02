const list = new Vue({
    el:"#listAll",
    data:{
        itemList:[]
    }
})
const selectMajor = new Vue({
    el:".middle",
    data:{
        major_list:[]
    }
})
const selectSub2 = new Vue({
    el:"#sub",
    data:{
        item:1,
        idx:101
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
const searchItem = document.querySelector("#searchItem");
searchItem.addEventListener("keyup",function(e){
    if(e.keyCode == 13){
        const name = this.value;
        console.log(name);
        axios.get('/superMyPage/selectByName/'+name)
        .then(res=>{
            console.log(res.data);
            list.itemList = res.data;
            selectSub2.item=res.data.length-1;
        }).catch(error=>console.log(error));
    }
})

const major = document.querySelector("#major");
major.addEventListener("change",function(){
    const idx = this.value;
    getSelectMiddle(idx);
});
getSelectMiddle(1);
function getSelectMiddle(idx){
    axios.get('/selectMiddle/'+idx)
    .then(res=>{
        console.log(res.data);

        selectMajor.major_list = res.data;
    }).catch(error=>console.log(error));
}
const middle = document.querySelector(".middle");
middle.addEventListener("change",function(){
    selectSub2.idx = this.value;
    selectSub(this.value,0);
})
function selectSub(idx,startNo){
    axios.get(`/selectSub/${idx}/${startNo}`)
    .then(res=>{
        console.log(res.data);
        list.itemList = res.data;
        selectSub2.item=res.data.length-1;
    }).catch(error=>console.log(error));
}