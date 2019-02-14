<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/layout/header.jsp" />
<%@ page import="mx.xpd.cfdi.constantes.URLConstants" %>
<div class="container row-fluid">
    <div class="span10 offset1" style="border-radius: 5px;border: 2px solid #fff;">
        <h2>Instrucciones de n&oacute;mina en excel</h2>
        <p>
            <ol>
                <li>Accede a tu cuenta de facturaci&oacute;n</li>
                <li>Descarga la <a target="_blank" href="<%= URLConstants.PLANTILLA_NOMINA %>"> plantilla demo</a></li>
                <li>Selecciona las percepciones y deducciones que utilizas
                <li>Carga tus empleados, uno por fila</li>
                <li>Sube tu archivo excel completo</li>
                <li>Espera unos minutos y consulta tu n&oacute;mina</li>
            </ol>
        </p>
            <h2>Preguntas frecuentes</h2>
            <ol>
                <li>
                    <b>&iquest;Qu&eacute; datos son obligatorios?</b>
                    <ul style="list-style-type: none;">
                        <li>
                            <p>Los &uacute;nicos datos que son obligatorios, se muestran al deseleccionar la casilla "TODOS" del men&uacute; configuraci&oacute;n</p>
                        </li>
                    </ul>
                </li>
                <li>
                    <b>&iquest;Qu&eacute; pasa si subo el mismo archivo</b>
                    <ul style="list-style-type: none;">
                        <li>
                            <p>Si el archivo lo subes m&aacute;s de una vez el mismo d&iacute;a, tu n&oacute;mina no se duplicara, pues se cuenta con dicha validaci&oacute;n, sin embargo, si al d&iacute;­a siguiente subes el mismo archivo con los mismos datos, tu archivo generar&aacute; nuevos CFDIs</p>
                        </li>
                    </ul>
                </li>
                <li>
                    <b>&iquest;C&oacute;mo veo los errores?</b>
                    <ul style="list-style-type: none;">
                        <li>
                            <p>Al terminar tu carga de archivo Excel, en caso de tener alg&uacute;n error, se proporcionara una liga, para descargar un archivo nuevo, unicamente con las filas del error</p>
                        </li>
                    </ul>
                </li>
            </ol>
        </div>
    </div>
    