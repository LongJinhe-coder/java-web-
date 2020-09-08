var httpRequest=null;
function createXHR(){
 if(window.XMLHttpRequest){ //Mozilla,Safari,Opera,IE7等
  httpRequest = new XMLHttpRequest();
 }else if(window.ActiveXObject){
  try{
   httpRequest = new ActiveXObject("Msxml2.XMLHTTP"); //IE较新版本
  }catch(e){
   try {
    httpRequest = new ActiveXObject("Microsoft.XMLHTTP");//IE较老版本
   }catch(e){
    httpRequest = null;
   } 
   } 
  }
 if(!httpRequest){ 
  alert("fail to create httpRequest");
 } 
}
//发送请求
function sendRequest(url,params,method,handler){
 //调用XMLHttpRequest对象的创建方法
 createXHR();
 if(!httpRequest) return false;
 httpRequest.onreadystatechange=handler;
 //判断get or post
 if(method=="GET"){
  httpRequest.open(method, url+'?'+params,true);
  httpRequest.send(null);
 }if(method=="POST"){
  httpRequest.open(method, url,true);
  //该方法在发送请求前，先设置请求头。
  httpRequest.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  httpRequest.send(params);
 }
}