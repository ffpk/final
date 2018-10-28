<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.etree.js"></script>

<script type="text/javascript">
    $(function () {
        $('#datagrid').treegrid({
            onDblClickRow:function (row) {
                $("#audio_dd").dialog("open")
                $("#audio_id").prop("src","${pageContext.request.contextPath}/img/"+row.url);
            },
            url: '${pageContext.request.contextPath}/albumSelectAll',
            fit: true,
            fitColumns: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15],
            idField: 'id',
            treeField: 'name',
            columns: [[
                {field: 'name', title: '名字', width: 180},
                {field: 'url', title: '下载路径', width: 60, align: 'right'},
                {field: 'size', title: '大小', width: 80},
                {field: 'duration', title: '章节时长', width: 80}
            ]],

            toolbar: [{
                iconCls: 'icon-tip',
                text: "专辑详情",
                handler: function () {
                    {
                        var row = $("#datagrid").treegrid("getSelected");
                        if (row != null) {
                            if (row.url == null) {
                                /*选中的是专辑*/
                                $("#chater_dd").dialog("open")
                                $("#chapter_ff").form("load", row);
                                $("#coverImg").prop("src", row.coverImg);
                            }
                        }
                    }

                }
            },
                {
                    iconCls: 'icon-save',
                    text: "添加专辑",
                    handler: function () {
                        $("#insertDiv").dialog("open");


                    }
                },
                {
                    iconCls: 'icon-save',
                    text: "添加章节",
                    handler: function () {
                        $("#chapterinsertDiv").dialog("open");
                    }
                },
                {
                    iconCls: 'icon-undo',
                    text: "下载音频",
                    handler: function () {

                        var row = $("#datagrid").treegrid("getSelected");
               alert(row)
              // 先判断用户选中没有  如果没有选中给用户一个提醒
               if(row !=null){
                   //判断是专辑还是章节，选择二个类型没  特殊的属性
                   if(row.url!=null){
                       location.href="${pageContext.request.contextPath}/down?name="+row.name+"&url="+row.url;
                   }

               }else{
                   alert("请选中音频");
               }
                    }
                }],
        });
        //添加专辑
        $("#insertDiv").dialog({
            closed: true,
            //对话框窗口底部按钮
            buttons: "#insert",
            width: 300,
            title: "添加数据"
        });
        //添加章节
        $("#chapterinsertDiv").dialog({
            closed: true,
            //对话框窗口底部按钮
            buttons: "#chapterinsert",
            width: 300,
            title: "添加数据"
        })

    })

    /*  添加专辑*/

    function doinsert() {
        $("#insertForm").form("submit", {
            url: "${pageContext.request.contextPath}/albuminsert",
            //接收后台响应回来的数据，关闭修改对话框、刷新datagrid（reload）
            success: function (data) {
                // alert(data);
                if (data == "true") {
                    alert("添加成功");
                } else {
                    alert("添加失败");
                }
                //关闭对话框
                $("#insertDiv").dialog("close");
                //刷新datagrid
                $("#datagrid").treegrid("reload");
            }
        });

    }
    //添加章节
    function chapterinsert() {

        var myid = $("#datagrid").datagrid("getSelected");
        alert(myid.id)
        $("#chapterinsertForm").form("submit", {
            url: "${pageContext.request.contextPath}/chapTerinsert",
            queryParams: {Albumid: myid.id},
            success: function (data) {
                // alert(data);
                if (data == "true") {
                    alert("添加成功");
                } else {
                    alert("添加失败");
                }
                //关闭对话框
                $("#chapterinsertDiv").dialog("close");
                //刷新datagrid
                $("#datagrid").treegrid("reload");
            }
        });
    }


</script>


<table id="datagrid"></table>
<div id="insertDiv">
    <form id="insertForm" method="post" enctype="multipart/form-data">
        专辑名字：<input name="name"/><br/>
        选择图片:<input type="file" name="file"/><br/>
        音频集数：<input name="count"/><br/>
        专辑的评分：<input name="score"/><br/>
        作者：<input name="author"/><br/>
        音频播音人：<input name="broadCat"/><br/>
        简介：<input name="brief"/><br/>
    </form>
</div>

<div id="insert">
    <a class="easyui-linkbutton" onclick="doinsert()">立即添加</a>
</div>

<div id="chapterinsertDiv">
    <form id="chapterinsertForm" method="post" enctype="multipart/form-data">
        章节名字：<input name="name"/><br/>
        下载路径:<input type="file" name="file"/><br/>

    </form>
</div>

<div id="chapterinsert">
    <a class="easyui-linkbutton" onclick="chapterinsert()">立即添加</a>
</div>
<div id="chater_dd" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="chapter_ff" method="post">
        <div>
            <label for="name">名字:</label>
            <input id="name" class="easyui-validatebox" type="text" name="name" data-options="required:true"/>
        </div>
        <div>
            <label for="count">数量:</label>
            <input id="count" class="easyui-validatebox" type="text" name="count" data-options="required:true"/>
        </div>
        <div>
            <label for="createDate">时间:</label>
            <input id="createDate" class="easyui-validatebox" type="text" name="publicDate"
                   data-options="required:true"/>
        </div>
        <div>
            封面：<img id="coverImg" src="">
        </div>
    </form>
</div>
<div id="audio_dd" class="easyui-dialog" title="播放音频" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <audio src="" id="audio_id" autoplay="autoplay" controls="controls"></audio>
</div>