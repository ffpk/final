<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">

    $(function () {
        $('#chapter').treegrid({
            url:'${pageContext.request.contextPath}/albumSelectAll',
            idField:'id',
            treeField:'name',
            columns:[[
                {title:'Task Name',field:'name',width:180},
                {field:'persons',title:'Persons',width:60,align:'right'},
                {field:'begin',title:'Begin Date',width:80},
                {field:'end',title:'End Date',width:80}
            ]],

            fit:true,
            fitColumns:true
        });


    })

</script>


<table id="chapter"></table>

<div>
    <audio src=""> </audio>
</div>

