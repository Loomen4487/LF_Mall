let count = document.querySelector("#count").value;
const plus = document.querySelector(".plus");
plus.addEventListener("click",function(){
    count++;
    document.querySelector("#count").value=count;
})
const minus = document.querySelector(".minus");
minus.addEventListener("click",function(){
    if(count>1)count--;
    document.querySelector("#count").value=count;
})
const info = document.querySelectorAll(".ProductDetail_tabList__G8yFd>li");
const infoUl = document.querySelector(".info-list");
let infoIdx=0;
info.forEach((item,index)=>{
    item.addEventListener("click",function(){
        infoUl.children[infoIdx].classList.remove("selected");
        infoUl.children[infoIdx].children[1].style.display="none";
        this.classList.add("selected");
        this.children[1].style.display="block";
        const height = this.children[1].clientHeight;
        document.querySelector("footer").style.marginTop= height+'px';
        infoIdx = index;
    })
})
function qna(id,idx){
    if(id=='undefiend' ||  id==null || id=='null'){
        if(confirm("로그인후 이용가능합니다.")){
            location.href='/login';
        }
    }else location.href='/qnaForm/'+idx;
}

function cartOk(id,idx){
    console.log(id,idx);
    if(id != null && id != 'undefiend' && id != 'null'){
        axios.post('/mypage/cartOk',{
            product:idx,
            login:id
        }).then(res=>{
            alert("쇼핑백에 담겨졌습니다.");
        }).catch(error=>{
            console.log(error);
        })
    }else{
        if(confirm("로그인후 이용가능합니다. 이동하시겠습니까?")){
            location.href="/login";
        }
    }
}