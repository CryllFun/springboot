var userId = "";
$(function () {
    userId = $("#userId").val();
    loadJqGrid();
});
function loadJqGrid() {
    $("#users_table").jqGrid({
       caption:"所有用户信息",
       width:1000,
       height:100,
       url:"/getUserInfo",
       postData:{"id":userId,"action":"allUser"},
       dataType:"json",
       colNames:['id','名字','密码','邮箱','别名'],
       colModel:[
           {name:"id",index:"id",width:0,align:"center"},
           {name:"userName",index:"userName",width:200,align:"center"},
           {name:"passWord",index:"passWord",width:200,align:"center"},
           {name:"email",index:"email",width:200,align:"center"},
           {name:"nickName",index:"nickName",width:200,align:"center"},
           // {name:"regTime",index:"regTime",width:"20%",align:"center"},
       ],
       autowidth:"true",
       rowNum:10,
       pager:"#pager"
       // sortname:"id",
       // sortorder:"desc"
   })
}