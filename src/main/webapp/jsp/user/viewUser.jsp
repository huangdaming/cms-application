<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <%@ include file="../common/meta.jsp"%>
    <script type="text/javascript" src="${ctx}/library/js/cms/user/viewUser.js"></script>

    <style type="text/css">
        #fm{
            margin:0;
            padding:10px 30px;
        }
        .ftitle{
            font-size:14px;
            font-weight:bold;
            color:#666;
            padding:5px 0;
            margin-bottom:10px;
            border-bottom:1px solid #ccc;
        }
        .fitem{
            margin-bottom:5px;
        }
        .fitem label{
            display:inline-block;
            width:80px;
        }
    </style>
</head>
<body>
<table id="dg" title="用户列表" class="easyui-datagrid" style="width:550px;height:250px"
       url="${ctx}/user/query.action"
       toolbar="#toolbar"
       rownumbers="true" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="userName" width="50">用户姓名</th>
        <th field="password" width="50">用户密码</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addUser()">新增</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteUser()">删除</a>
</div>

<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
     closed="true" buttons="#dlg-buttons">
    <div class="ftitle">用户信息</div>
    <form id="fm" method="post">
        <input name="id" class="easyui-validatebox" type="hidden" >
        <div class="fitem">
            <label>用户名:</label>
            <input name="userName" class="easyui-validatebox" required="true">
        </div>
        <div class="fitem">
            <label>密码:</label>
            <input name="password" class="easyui-validatebox" required="true">
        </div>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>
</body>
</html>