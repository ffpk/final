<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>

<script type="text/javascript">
    $(function () {
        $('#datagrid').edatagrid({
            updateUrl:"${pageContext.request.contextPath}/update",
            url: '${pageContext.request.contextPath}/byselectAll',
            method: "get",
            columns: [[
                {field: 'name', title: '标题', width: 100},
                {field: 'status', title: '状态', width: 100,
                    formatter: function (value,row,index) {
                        if (value == 0) {
                            return "Y";
                        } else {
                            return "N";
                        }
                    },editor: {
            type: "text",
                options: {
                required: true

            }
        }
    },
                {field: 'desc', title: '描述', width: 100, align: 'right'},
                {field: 'createDate', title: '时间', width: 100},
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15],
            toolbar: [{
                iconCls: 'icon-add',
                text: "添加",
                handler: function () {
                    $("#insertDiv").dialog("open");
                }
            }, '-', {
                iconCls: 'icon-edit',
                text: "修改",
                handler: function () {
                    var row = $("#datagrid").edatagrid("getSelected");
                   // alert(row)
                    if (row == null) {
                        alert("请先选中行")
                    } else {
                        var index = $("#datagrid").edatagrid("getRowIndex", row);

                        $("#datagrid").edatagrid("editRow", index);
                    }


                }
            }, '-', {
                iconCls: 'icon-remove',
                text: "删除",
                handler: function () {
                    //alert('删除按钮')
                    MyDelete();
                }
            }, '-', {
                iconCls: 'icon-save',
                text: "保存",
                handler: function () {
                   // alert("fvxcg")
                    //保存编辑行并发送到服务器。
                    $("#datagrid").edatagrid("saveRow")

                }
            }],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/img/' + rowData.url + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.desc + '</p>' +
                    '<p>Status: ' + rowData.createDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
        });
        //添加的对话框
        $("#insertDiv").dialog({
            closed:true,
            //对话框窗口底部按钮
            buttons:"#insert",
            width:300,
            title:"添加数据"
        });

    })
    //删除选中的
    function MyDelete(){
        //c.在函数中获取到选中的内容（通过datagrid的getSelections方法）===》id
        var myid=$("#datagrid").datagrid("getSelected");
        //alert(myid)
        if(myid.id!=0){
            //执行删除操作
            $.messager.confirm("删除确认","确定要删除选中的数据？",function(r){

                if(r){
                    $.ajax({
                        url:"${pageContext.request.contextPath}/delete",
                        data:{"id":myid.id},
                        //防止jQuery对json格式的数据做深度序列化
                        traditional:true,
                        success:function(data){
                            if(data){
                                //alert("删除成功");
                                $.messager.show({
                                    showType:"fade",
                                    showSpeed:4000,
                                    title:"删除提示",
                                    msg:"删除成功"
                                });
                            }else{
                                $.messager.show({
                                    title:"删除提示",
                                    msg:"删除失败"
                                });
                                //alert("删除失败");
                            }
                            //刷新datagrid
                            $("#datagrid").datagrid("reload");
                        }
                    });
                }
            });

        }else{
            //alert("请选中要删除的数据");
            $.messager.alert("删除提示","请选中要删除的数据","question");
        }
    }

      /*  添加*/


    function doinsert(){
        $("#insertForm").form("submit",{
            url:"${pageContext.request.contextPath}/insert",
            //接收后台响应回来的数据，关闭修改对话框、刷新datagrid（reload）
            success:function(data){
               // alert(data);
                if(data=="true"){
                    alert("添加成功");
                }else{
                    alert("添加失败");
                }
                //关闭对话框
                $("#insertDiv").dialog("close");
                //刷新datagrid
                $("#datagrid").datagrid("reload");
            }
        });

    }

</script>


<table id="datagrid"></table>
<div id="insertDiv">
    <form id="insertForm" method="post" enctype="multipart/form-data">
        用户名：<input  name="name"/><br/>
        选择图片:<input type="file" name="file"/><br/>
        状态：<input name="status"/><br/>
        描述：<input name="description"/><br/>
    </form>
</div>

<div id="insert">
    <a class="easyui-linkbutton" onclick="doinsert()">立即添加</a>
</div>


