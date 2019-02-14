<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=Edge">
        <meta name="title" content="Sistema de autofacturaci&oacute;n XPD">
        <meta name="description" content="Sistema de Facturación Electrónica XPD">
        <meta name="keywords" content="Facturación Electrónica, Timbrado, Expide Tu Factura, Folios, Timbrado Masivo, Facturación en linea, paquetes de facturación, planes de facturacion, Distribucuion de Facturación Electrónica, XPD">
        <link rel="shortcut icon" href="<c:url value="/static/resources/img/favicon.ico"/>" type="image/x-icon">
        <link rel="icon" href="<c:url value="/static/resources/img/favicon.ico"/>" type="image/x-icon">

        <link rel="stylesheet" href="<c:url value="/static/resources/css/foundation.min.css"/>">
        <link rel="stylesheet" href="<c:url value="/static/resources/css/estilos.css"/>">
        <link rel="stylesheet" href="<c:url value="/static/resources/css/layout.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/bootstrap.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/bootstrap-responsive.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/resources/css/bootstrap-dataTable.css"/>"/>
        <title>Sistema de facturaci&oacute;n Electr&oacute;nica</title>
        <!--[if lt IE 9]>
            <script src="js/html5shiv.min.js"></script>
            <script src="js/html5shiv-printshiv.min.js"></script>
        <![endif]-->
        <style type="text/css">
            body {
                background-color: #f5f5f5;
                padding-bottom: 40px;
                padding-top: 40px;
            }
            .form-signin {
                background-color: #E8E8E8;
                border: 1px solid #e5e5e5;
                -webkit-border-radius: 5px;
                -moz-border-radius: 5px;
                border-radius: 5px;
                -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
                color: #202C6C;
                margin: 0 auto 20px;
                max-width: 360px;
                padding: 19px 29px 29px;
            }
            .form-signin .form-signin-heading,
            .form-signin .checkbox {
                margin-bottom: 10px;
            }
            .form-signin input[type="text"],
            .form-signin input[type="password"] {
                font-size: 16px;
                height: auto;
                margin-bottom: 15px;
                padding: 7px 9px;
            }
        </style>
        <script type="text/javascript">
        /*
            $(document).ready(function() {
                $('#login').submit(function() {
                    var usuario =  $('#j_username').val();
                    var rfc = $('#rfc').val();
                    var bandera = false;
                    var mensaje = '';
                    $.ajax({
                    url : '/CFDI/rest/usuario/bloqueado/' + usuario +'/' + rfc,
                    async : false
                    }).done(function ( data ) {
                    if (data == 'correcto') {
                        bandera = true;
                    } else {
                    mensaje = data;
                    bandera = false;
                    }
                    })
                    if(mensaje=='bloqueado'){
                        alert('Su cuenta ha sido bloqueda. Favor de esperar 15 min.');
                    }
                    if(mensaje=='noExiste'){
                        alert('El nombre de usuario que ingreso no existe.');
                    }
                    return bandera;
                    })
            });
            */
        </script>
    </head>
    <body onload='document.login.rfc.focus();'>
        <div class="container">

            ${mensaje}

            <form id="login" name='login' class="form-signin" action="/CFDI33/usuario/generaCodigoRescate2" method='POST'>
                <h2 class="form-signin-heading">
                <img src="/CFDI33/static/resources/img/logo.png" /><br><br>
                </h2>
                <label>El C&oacute;digo de Rescate llegar&aacute; autom&aacute;ticamente al correo del Emisor.<br></label>
                <label>Clave de cliente:</label>
                <input type="text" class="input-block-level" id="rfc" name="rfc" placeholder="Clave de Cliente">
                <label>Usuario:</label>
                <input type="text" class="input-block-level" name='usuario' id="usuario"/>
                <div style="width: 100%">
                    <input class="btn btn-large btn-primary" name="submit" type="submit" value="Generar Código de Rescate" style="width: inherit;" />
                </div>
            </form>
        </div>
    </body>
</html>
