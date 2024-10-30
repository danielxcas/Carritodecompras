$(document).ready(function () {      
    $("tr #Cantidad").click(function(){
        var idp = $(this).parent().find("#idpro").val();
        var cantidad = $(this).parent().find("#Cantidad").val();
        var url = "Controlador?accion=ActualizarCantidad";

        $.ajax({
            type: 'POST',
            url: url,  // Usa la variable url en lugar de "url"
            data: "idp=" + idp + "&Cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR) {
                // Aquí puedes manejar la respuesta de la petición si es exitosa
                console.log("Actualización exitosa");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                // Manejo de errores
                console.error("Error en la actualización:", textStatus, errorThrown);
            }
        });
    });
});




