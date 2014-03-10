function abritela(url){ 
	$.ajax({
        url: url,
        global: "false",
        type: "POST",
        data: {
        },
        async: true,
        beforeSend: function(){
            $("#tela").html('<div align="center"><img src="image/ampulheta_animada.gif" align="absmiddle" /></div>');
        },
        error: function(){
            alert("Erro com a requisição");
        },
        success: function(responseText){
            $("#tela").html(responseText);
        }
    });
}