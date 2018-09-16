var url;
function addUser(){
    $('#dlg').dialog('open').dialog('setTitle','新建用户');
    $('#fm').form('clear');
    url = ctx + '/user/save.action';
}
function editUser(){
    var row = $('#dg').datagrid('getSelected');
    if (row){
        $('#dlg').dialog('open').dialog('setTitle','编辑用户');
        $('#fm').form('load',row);
        url = ctx + '/user/save.action';
    }
}
function saveUser(){
    $('#fm').form('submit',{
        url: url,
        onSubmit: function(){
            return $(this).form('validate');
        },
        success: function(result){
            var result = eval('('+result+')');
            if (result.success){
                $('#dlg').dialog('close');		// close the dialog
                $('#dg').datagrid('reload');	// reload the user data
            } else {
                $.messager.show({
                    title: '错误',
                    msg: result.msg
                });
            }
        }
    });
}
function deleteUser(){
    url = ctx + '/user/delete.action';
    var row = $('#dg').datagrid('getSelected');
    if (row){
        $.messager.confirm('确认','是否删除该用户?',function(r){
            if (r){
                $.post(url,{id:row.id},function(result){
                    if (result.success){
                        $('#dg').datagrid('reload');	// reload the user data
                    } else {
                        $.messager.show({	// show error message
                            title: '错误',
                            msg: result.msg
                        });
                    }
                },'json');
            }
        });
    }
}