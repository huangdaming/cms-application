<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <link rel="stylesheet" type="text/css" href="${ctx}/library/jquery-easyui-1.4.4/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/library/jquery-easyui-1.4.4/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${ctx}/library/jquery-easyui-1.4.4/demo/demo.css">
    <script type="text/javascript" src="${ctx}/library/jquery-easyui-1.4.4/jquery.min.js"></script>
    <script type="text/javascript" src="${ctx}/library/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${ctx}/library/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<table id="dg" title="用户列表" class="easyui-datagrid" style="width:550px;height:250px"
       url="${ctx}/user/query"
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
    <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()">新增</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()">修改</a>
    <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delete()">删除</a>
</div>
</body>
</html>