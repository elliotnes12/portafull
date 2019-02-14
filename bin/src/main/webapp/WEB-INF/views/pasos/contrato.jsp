<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/static/resources/js/jquery.js"/>"></script>

<title>Aceptar Contrato</title>
<style>
#mContrato {
	width: 900px;
	margin: 0 auto;
	text-align: justify;
	height: 600px;
	overflow: auto;
	padding: 5px;
}
</style>
<script>
$(document.ready(function() {

	$('form').submit(function() {
		if ($('input[name=acepto]').is(':checked')) {
			return true;
		}
		return false;
	});
	
}))
</script>
</head>
<body>

Para continuar, debe leer y aceptar el presente contrato:

${pageContext.request.remoteAddr}
<form action="/CFDI/login/inicio">
<p>
Especialmente el Contribuyente manifiesta su conocimiento y presta su autorización para que XPD entregue al SAT, copia de los comprobantes certificados a través de este servicio.
</p>
	<input type="checkbox" name="acepto">
	<input type="submit" value="He leido, y acepto">
</form>
<pre id="mContrato">
CONTRATO DE PRESTACIÓN DE SERVICIOS PARA GENERACIÓN DE CFDIS CON CPA CONTROL DE
COMPROBANTES DIGITALES S DE RL DE CV
POR FAVOR LEA CUIDADOSAMENTE EL CONTRATO DE PRESTACIÓN DE SERVICIOS PARA
GENERACIÓN DE CFDIS USANDO LOS SERVICIOS EXPIDETUFACTURA.COM.MX O DE CUALQUIER
SUB-DOMINIO CON TERMINACIÓN EXPIDETUFACTURA.COM.MX (EN ADELANTE LOS SITIOS) QUE
SON OPERADOS POR CPA CONTROL DE COMPROBANTES DIGITALES S DE RL DE CV .
SI USTED NO ESTÁ DE ACUERDO CON TODOS Y CADA UNO DE LOS PUNTOS DEL CONTRATO Y SUS
CONDICIONES DE USO AQUÍ DETALLADOS, USTED NO TENDRÁ EL DERECHO DE USAR LOS
SERVICIOS DE CPA CONTROL DE COMPROBANTES DIGITALES S DE RL DE CV.
-------------------------------------------------------------------------------
CONTRATO DE PRESTACION DE SERVICIOS PARA GENERACION, ALMACENAMIENTO, RESPALDO Y
ENVÍO ELECTRÓNICO DE COMPROBANTES FISCALES DIGITALES (EL CONTRATO ) QUE CELEBRAN
POR UNA PARTE CPA CONTROL DE COMPROBANTES DIGITALES S DE RL DE CV., REPRESENTADA EN
ESTE ACTO POR EL SEÑOR JULIO CESAR CAPDEVIELLE TRIANA, A QUIEN EN LO SUCESIVO SE LE
DENOMINARA EXPIDETUFACTURA Y POR LA OTRA PARTE ${emisor.razonSocial}, A QUIEN EN LO
SUCESIVO SE LE DENOMINARA EL SUSCRIPTOR (PARA EFECTOS DEL PRESENTE CONTRATO A
EXPIDETUFACTURA Y AL SUSCRIPTOR SE LES REFERIRA DE MANERA CONJUNTA E
INDISTINTAMENTE COMO LAS PARTES), QUIENES SE SUJETAN AL TENOR DE LAS SIGUIENTES
DEFINICIONES, DECLARACIONES Y CLÁUSULAS:
-------------------------------------------------------------------------------
DEFINICIONES
Afiliada y/o Parte Relacionada: Significa cualquier sociedad, sociedad de responsabilidad
limitada, sociedad en nombre colectivo, sociedad anónima, asociación en participación,
asociación, compañía, fideicomiso, o cualquier tipo de organización, ya sea que la misma se
encuentre constituida como una persona moral o no, en lo sucesivo Persona, que controle a, sea
controlada por, o se encuentre bajo el Control común de algún accionista de las Partes. Para
efectos de lo anterior, el término Control significa la posesión directa o indirecta de más del
50% (cincuenta por ciento) de las acciones o partes sociales representativas del capital social con
derecho a voto de cualquier Persona y la facultad de dirigir o controlar la administración o políticas
de una Persona, ya sea a través de acciones o de partes sociales, con derecho a voto, a través del
consejo de administración, por medio de algún contrato o por cualesquier otra razón.
Autoridad Gubernamental: Son los gobiernos federales, estatales, delegacionales o municipales,
sus administraciones, dependencias, u oficinas ya sean centralizadas, paraestatales,
descentralizadas, desconcentradas y/o cualesquier autoridad que tenga o pronuncie competencia
o cualquier otro cuerpo que ejerza funciones similares.Contrato: El contrato de prestación de SERVICIOS que celebran las Partes en este acto.
México: Son los Estados Unidos Mexicanos.
Partes: Se entenderá conjunta e Indistintamente, para efectos del presente Contrato al
SUSCRIPTOR y EXPIDETUFACTURA
Proyecto: Es aquel plan cuya descripción, programa, alcance y metas serán definidas por el
SUSCRIPTOR en la solicitud de SERVICIOS Adicionales que de tiempo en tiempo emita, Proyecto
que EXPIDETUFACTURA implementará y operará conforme a lo previsto en este Contrato y
Anexos.
Requerimientos Legales: Son todos los presentes y futuros estatutos, leyes, decretos,
requerimientos, órdenes, instrucciones, reglas, reglamentos, normas, preceptos y regulaciones de
cualquier índole, ya sean establecidos por la ley, la jurisprudencia o de derecho consuetudinario,
incluyendo sin limitación, todas las leyes de protección al consumidor, emitidas u obligatorias por
parte de alguna Autoridad Gubernamental, que gobierne o corresponda de alguna forma al
presente Contrato.
SAT: Servicio de Administración Tributaria en México
PAC: Proveedor Autorizado de Certificación
CSD: Certificado de Sello Digital que el SUSCRIPTOR tramita usando los sistemas y portales de
Internet del SAT
FIEL: Firma Electrónica que el SUSCRIPTOR tramita ante el SAT
CFD: Comprobante Fiscal Digital
CFDIS: Comprobantes Fiscales Digitales a través de Internet
SISTEMA EXPIDETUFACTURA: Sistemas y tecnología integral de EXPIDETUFACTURA Web 2.0 para
la emisión, almacenamiento, resguardo, consulta, validación de CFDIS.
Paro Técnico Programado: Es aquel período de tiempo en el cual se suspende el Servicio por un
tiempo definido y es utilizado por EXPIDETUFACTURA para la instalación de nuevas versiones del
SISTEMA EXPIDETUFACTURA en modalidad PAC, adecuaciones a la Base de Datos y
mantenimiento.
EXPIDETUFACTURA: CPA CONTROL DE COMPROBANTES DIGITALES S DE RL DE CV
SUSCRIPTOR: ${emisor.razonSocial}
Primero. Las Partes previo a la celebración del presente Contrato han sostenido diversas reuniones
de negocio mediante las cuales se ha analizado la posibilidad de que el SUSCRIPTOR use los
SERVICIOS de EXPIDETUFACTURA en modalidad PAC para que el SUSCRIPTOR pueda emitir,
almacenar, resguardar y enviar electrónicamente CFDIS
Segundo. Las Partes han acordado la celebración del presente Contrato, a fin de establecer los
términos, condiciones y demás características conforme a los cuales EXPIDETUFACTURA prestará
al SUSCRIPTOR los SERVICIOS objeto de este Contrato.
DECLARACIONES
Declara EXPIDETUFACTURA, por conducto de su representante:
1. Es una sociedad legalmente constituida conforme a las leyes de México, según consta en la
escritura pública número 18534 dieciocho mil quinientos treinta y cuatro - de fecha 29 de julio
de 2010, pasada ante la fe del licenciado José Germán Soto Adams, notario público número 16 de
la ciudad de Puebla, Puebla, e inscrito en el Registro Público de Comercio de la ciudad de Puebla,
Puebla, bajo el folio electrónico mercantil número 43894 * 2, de fecha 29 de septiembre de 2010.
2. Que es una sociedad de responsabilidad limitada de capital variable legalmente constituida,
como acredita mediante la Escritura Pública Número 18534 dieciocho mil quinientos treinta y
cuatro - de fecha 29 de julio de 2010, otorgada ante la fe del licenciado José Germán Soto Adams,
e inscrita en el Registro Público de la Propiedad y del Comercio de dicha entidad bajo el folio
electrónico mercantil número 43894 * 2, de fecha 29 de septiembre de 2010.
3. Que su Registro Federal de Contribuyentes es: CCC-100729-3K0 y que para efectos del presente
contrato señala como su domicilio el ubicado en Privada 29 B Sur 3306, Col El Vergel, Puebla,
Puebla, C. P. 72400.
4. Que su Representante Legal cuenta con las facultades suficientes para la celebración del
presente Contrato, lo cual acredita en términos de la escritura pública indicada en el inciso 1)
anterior, quien manifiesta bajo protesta de decir verdad que dichas facultades no le han sido
disminuidas ni revocadas en forma alguna.
5. Que manifiesta bajo protesta de decir verdad que el presente Contrato, no lo limita a prestar
sus SERVICIOS a personas físicas o morales ajenas al SUSCRIPTOR.
6. Que manifiesta bajo protesta de decir verdad que dentro de su actividad, se encuentra la
prestación de productos y SERVICIOS de promoción, comercialización y administración demensajes electrónicos, así como organización inteligente de información generada por vías
electrónica u óptica y que cuenta con los elementos humanos y materiales y experiencia
necesaria, para cumplir con las obligaciones contraídas en el presente Contrato; que el personal
humano que emplea para proporcionar los SERVICIOS de Mensajería, está debidamente
capacitado y posee los elementos necesarios para cumplir con los trabajos y funciones objeto del
mismo.
7. Que es titular de las marcas registradas, patentes y logotipo corporativo bajo el signo distintivo
EXPIDETUFACTURA (en adelante las Marcas EXPIDETUFACTURA ).
8. Que cuenta con las autorizaciones necesarias conforme a los Requerimientos Legales aplicables
para la prestación del Servicio y otorgamiento de licencias de uso de EXPIDETUFACTURA.
9. Que la celebración del presente Contrato y la consumación de las operaciones que en el mismo
se contemplan: (I) No resultarán en ningún incumplimiento de los términos o condiciones
establecidos en su escritura constitutiva o estatutos sociales, ni de ningún contrato, convenio,
compromiso u otro instrumento u obligación del que sea parte o por la que cualquiera de sus
bienes pueda ser afectado, (II) No constituirán un incumplimiento de ninguna ley o reglamento u
orden de autoridad competente que le pueda afectar y (III) Han sido debidamente autorizados por
sus órganos corporativos internos competentes.
Declara el SUSCRIPTOR, por conducto de su representante legal:
1. Que es una Sociedad constituida conforme a las leyes de los Estados Unidos Mexicanos
( México ).
2. Que su Registro Federal de Contribuyentes es: ${emisor.rfc}.
3. Que su representante legal cuenta con todas las facultades necesarias para obligarla en los
términos del presente contrato, las cuales a la fecha de celebración del mismo no le han sido
revocadas ni modificadas de manera alguna.
4. Que la celebración del presente Contrato y la consumación de las operaciones que en el mismo
se contemplan: (I) No resultarán en ningún incumplimiento de los términos o condiciones
establecidos en su escritura constitutiva o estatutos sociales, ni de ningún contrato, convenio,
compromiso u otro instrumento u obligación del que sea parte o por la que cualquiera de sus
bienes pueda ser afectado, (II) No constituirán un incumplimiento de ninguna ley o reglamento u
orden de autoridad competente que le pueda afectar y (III) Han sido debidamente autorizados por
sus órganos corporativos internos competentes.
5. Que es voluntad de su representada contratar los SERVICIOS que ofrece EXPIDETUFACTURA.
Conformes que estuvieron las Partes con las anteriores declaraciones, convienen en obligarse
conforme a las siguientes:CLÁUSULAS
PRIMERA. OBJETO.-
SUSCRIPTOR encomienda a EXPIDETUFACTURA y éste acepta y se obliga a prestarle en forma no
exclusiva los SERVICIOS generación, almacenamiento, respaldo y envío electrónico de CFDIS a
terceros usando la tecnología del SISTEMA EXPIDETUFACTURA en modalidad PAC, por medios
electrónicos que incluye la recolección, entrega y accesos de documentos en formato digital a
través del licenciamiento de uso del SISTEMA EXPIDETUFACTURA en un modelo de PAC (en lo
sucesivo el SISTEMA EXPIDETUFACTURA ). El SUSCRIPTOR determinará y seleccionará de tiempo
en tiempo cualquiera de los módulos, que el SISTEMA EXPIDETUFACTURA ofrece.
SEGUNDA. RESPONSABILIDADES EN LA PRESTACION DE LOS SERVICIOS.-
Ambas Partes acuerdan establecer los siguientes términos y condiciones para la prestación de los
SERVICIOS:
a) Es responsabilidad del SUSCRIPTOR:
1. Tramitar ante el SAT, la FIEL y CSD necesarios para la operación de emisión de CFDIS
2. Tramitar ante el SAT su alta de inicio de operaciones con el PAC EXPIDETUFACTURA con RFC:
CCC-100729-3K0
3. Aceptar y estar de Acuerdo con TODOS los Términos y Condiciones Generales de Uso de todos
los sitios de EXPIDETUFACTURA. La última versión de dicho documento se puede encontrar en:
http://www.expidetufactura.com.mx/ATCUM.html
4. Aceptar y estar de Acuerdo con TODAS las Políticas de Privacidad de EXPIDETUFACTURA,
incluyendo cómo se maneja la información de nuestros SUSCRIPTORES. La última versión de dicho
documento se puede encontrar en: http://www.expidetufactura.com.mx/PPM.html
5. Sujetarse a las condiciones y formas de pago (en caso de existir) de cada uno de los SERVICIOS
ofrecidos por EXPIDETUFACTURA
6. Firmar con su FIEL de forma electrónica el presente CONTRATO, reconociendo que tiene el
mismo poder y alcances que su firma autógrafa.
b) Es responsabilidad de EXPIDETUFACTURA:
1. Cotejar con el SAT el alta de inicio de operaciones del SUSCRIPTOR
2. Orientar al SUSCRIPTOR para la correcta implementación de la facturación electrónica del
SUSCRIPTOR3. EXPIDETUFACTURA dará servicio de asesoría y soporte técnico bajo las condiciones y horarios
establecidos para cada tipo de SERVICIO y de acuerdo a las modalidades de contacto para dichos
SERVICIOS (Por Email, Teléfono, Ticket, etc.)
El SUSCRIPTOR tendrá el derecho de utilizar, mediante una conexión vía Internet y bajo un SLA
(SERVICE LEVEL AGREEMENT Ó DISPONIBILIDAD DEL SERVICIO) del 99.9% (Noventa y Nueve punto
Nueve por ciento) exceptuando los días de Paro Técnico Programado, el SISTEMA
EXPIDETUFACTURA en modalidad PAC así como ejecutar los procesos contenidos en dicho
Sistema, en el entendido que el SUSCRIPTOR tendrá acceso al Servicio de Asesoría y Soporte
Técnico conforme a lo previsto en cada tipo de servicios. Las Partes aceptan y acuerdan que
EXPIDETUFACTURA es el único responsable de suministrar y proporcionar el mantenimiento
continuo al SISTEMA EXPIDETUFACTURA y sus elementos. EXPIDETUFACTURA será responsable de
salvaguardar los CFDIS del SUSCRIPTOR al menos por cinco años (60 meses) para cada uno de los
CFDIS a partir de la fecha de recepción de los mismos, permitiéndole al SUSCRIPTOR mecanismos
para respaldar cada uno de los CFDIS en los equipos del SUSCRIPTOR. Sera responsabilidad del
SUSCRIPTOR el implementar y respaldar de forma adicional a la de EXPIDETUFACTURA sus CFDIS.
Las Partes aceptan y acuerdan que todos los SERVICIOS que el SUSCRIPTOR contrate en términos
de este Contrato tendrán acceso a:
i.
Actualización de nuevas versiones del SISTEMA EXPIDETUFACTURA, cuando se tengan
disponibles y liberadas.
ii.
Servicio de asistencia por Internet y/o Servicio de Asesoría y Soporte Técnico sobre el
manejo del SISTEMA EXPIDETUFACTURA exclusivamente en horario para cada tipo de servicio.
Dicho SERVICIOS, alcances, costos, vías de atención y horarios se definen en la página:
http://www.expidetufactura.com.mx/felectronica.php de acuerdo al servicio contratado.
Las Partes aceptan y acuerdan que EXPIDETUFACTURA será el único responsable en mantener
durante la vigencia de este Contrato los:
Respaldos de información y demás aspectos relacionados con la Base de Datos por al menos
cinco años (60 meses) para cada CFDI desde el momento de su generación en el SISTEMA
EXPIDETUFACTURA
La Administración de la seguridad de información y demás aspectos relacionados con la Base de
Datos.
Implementación de los planes de contingencia en caso de desastre, con pérdidas de información
menores a 1 (un) día en caso de sufrir un desastre mayor en el SISTEMA EXPIDETUFACTURA.
TERCERA. CONTRAPRESTACIÓN Y DEVOLUCIONES.-El SUSCRIPTOR pagará a EXPIDETUFACTURA por la prestación de los SERVICIOS (SERVICIOS DE
PAGA), las cantidades que se acuerden para cada tipo de servicio.
EXPIDETUFACTURA puede cambiar la modalidad de SERVICIO, o suspender o descontinuar los
SERVICIOS (o el acceso del SUSCRIPTOR a los mismos) en cualquier momento incluyendo la
disponibilidad de cualquier funcionalidad con las responsabilidades de (a) generar una nota en LOS
SITIOS o a través de una notificación por correo electrónico o correo postal (b) devolver al usuario
cualquier parte proporcional pagada y no utilizada por el SUSCRIPTOR (en adelante PRIMA NO
DEVENGADA) que pudiera existir en caso de que el SUSCRIPTOR haya realizado el pago de algún
SERVICIO y dicho SERVICIO sea CANCELADO o se deje de ofrecer sin sustitución alguna por
EXPIDETUFACTURA siempre y cuando la causa de CANCELACIÓN o SUSPENSIÓN NO SEA
IMPUTABLE al SUSCRIPTOR. La violación a los términos y condiciones de uso de LOS SITIOS de
EXPIDETUFACTURA o la violación por parte del SUSCRIPTOR a cualquiera de las cláusulas de este
contrato le da derecho a EXPIDETUFACTURA a no devolver la PRIMA NO DEVENGADA al
SUSCRIPTOR en caso de que ésta exista. EXPIDETUFACTURA se reserva el derecho a su propia
discreción de negar el acceso a cualquier posible SUSCRIPTOR a LOS SITIOS en cualquier
momento.
EXPIDETUFACTURA se reserva el derecho de cambiar su lista de precios y/o de agregar nuevos
SERVICIOS a discreción, previa notificación al SUSCRIPTOR y respetando el plazo contratado de
dicho SERVICIO al precio pactado entre el SUSCRIPTOR y EXPIDETUFACTURA. Cada SERVICIO puede
contar con diferentes políticas o condiciones de pago. Favor de revisar las condiciones particulares
de cada SERVICIO en LOS SITIOS de EXPIDETUFACTURA.
Las cantidades serán pagaderas en moneda nacional mas el correspondiente Impuesto al Valor
Agregado, previa entrega de la factura electrónica (CFDI) de EXPIDETUFACTURA que cumpla con
todos los requisitos fiscales vigentes, factura que contendrá la descripción de los SERVICIOS
prestados y su fecha límite de pago. En caso de que el SUSCRIPTOR no cumpla con la
contraprestación correspondiente amparada por la factura electrónica de EXPIDETUFACTURA en
su fecha límite de pago, EXPIDETUFACTURA podrá restringir el acceso al SUSCRIPTOR a todos sus
SERVICIOS. Además EXPIDETUFACTURA podrá cobrar un interés moratorio del 2% mensual por las
cantidades NO pagadas a EXPIDETUFACTURA.
Los pagos serán cubiertos a EXPIDETUFACTURA por medio de las formas que tenga
EXPIDETUFACTURA para recibirlos, pudiendo ser a través de tarjeta de crédito, depósito
referenciado o algún servicio de cobro por terceros como PayPal o Google Checkout. Toda la
información pertinente a los SERVICIOS y vías de pago correspondientes serán anunciada en LOS
SITIOS de EXPIDETUFACTURA. Las Partes acuerdan que en caso de existir variaciones o
modificaciones en el alcance y concepto de los SERVICIOS aquí regulados, la contraprestación se
sujetará a lo acordado de caso en caso por escrito entre las Partes.
CUARTA. OBLIGACIONES DE EXPIDETUFACTURA.-Son obligaciones de EXPIDETUFACTURA de manera enunciativa y no limitativa, las siguientes:
1. Realizar de manera puntal y eficiente la prestación de los SERVICIOS materia del presente
Contrato.
2. Prestar los SERVICIOS con personal capacitado y con aquellos recursos propios que al efecto
sean necesarios para el debido cumplimiento de las obligaciones a su cargo en términos de este
Contrato.
3. Remitir al SUSCRIPTOR la o las facturas electrónicas comerciales con todos los requisitos que
prevé el Código Fiscal de la Federación vigente.
4. Entregar al SAT información relativa a los comprobantes fiscales digitales emitidos en cualquier
momento que éste lo requiera incluyendo la generación de los reportes mensuales de nuestros
SUSCRIPTORES así como cumplir con todas las obligaciones que tiene EXPIDETUFACTURA para con
el SAT por contar con la autorización número 70022 como se detalla en el siguiente hipervínculo:
http://www.sat.gob.mx/sitio_internet/e_sat/comprobantes_fiscales/15_19748.html
QUINTA. OBLIGACIONES DEL SUSCRIPTOR.-
Son obligaciones del SUSCRIPTOR de manera enunciativa y no limitativa, las siguientes:
1. Proporcionar a EXPIDETUFACTURA toda la información necesaria, útil y conveniente para que
pueda realizar de manera puntual y eficiente la prestación de los SERVICIOS objeto del presente
Contrato.
2. Cubrir a EXPIDETUFACTURA la contraprestación correspondiente para la contratación de
SERVICIOS en los tiempos y términos establecidos en el presente Contrato o de forma puntual y
específica de acuerdo a las condiciones particulares de cada SERVICIO.
SEXTA.- LA BASE DE DATOS.-
EXPIDETUFACTURA salvaguardará la información de la Base de Datos utilizando tecnología de
punta en Internet como SSL (Secure Socket Layers), criptografía, accesos biométricos y equipos de
detección de intrusos y demás mecanismos necesarios de autenticación y no repudio.
EXPIDETUFACTURA llevará prácticas de respaldos de información en los centros de datos de alta
disponibilidad de EXPIDETUFACTURA para aumentar la confidencialidad y la integridad de la Base
de Datos.
Sin perjuicio de lo anterior, EXPIDETUFACTURA se obliga a custodiar la Base de Datos que para
efectos del presente, en el entendido que EXPIDETUFACTURA acepta, acuerda verificar y custodiar
el uso de dichos registros, uso que EXPIDETUFACTURA entiende y acepta se encuentra delimitado
para el objeto y alcance descrito en este Contrato. En virtud de lo anterior, EXPIDETUFACTURA se
obliga a custodiar la Base de Datos como propia y a utilizarla exclusivamente para los finesconvenidos en este Contrato y de acuerdo a los términos y condiciones de uso de LOS SITIOS de
EXPIDETUFACTURA, respetando de igual forma las políticas de privacidad de EXPIDETUFACTURA.
El SUSCRIPTOR se obliga a dejar en paz y a salvo a EXPIDETUFACTURA de cualquier responsabilidad
por cualquier reclamo o acción legal ejercida en contra de EXPIDETUFACTURA por parte de los
Usuarios Finales.
SÉPTIMA. LICENCIAS Y AUTORIZACIONES, REQUERIMIENTOS LEGALES.-
EXPIDETUFACTURA acepta, reconoce, confirma y declara que tiene los conocimientos
profesionales suficientes, necesarios, y dispone de los elementos propios y suficientes para
proporcionar al SUSCRIPTOR los SERVICIOS objeto del presente Contrato, obligándose en todo
momento y durante la vigencia del mismo a ejecutar sus actividades profesionalmente.
EXPIDETUFACTURA garantiza que los SERVICIOS serán prestados de acuerdo a las especificaciones,
estándares y requerimientos legales y operativos establecidos en el presente Contrato y que la ley
aplicable establezca para tales efectos.
OCTAVA. ESCALACION.-
El proceso de escalación iniciara en los casos que haya afectaciones al proceso de suministro de
SERVICIOS, entendiendo por afectaciones al proceso de suministro la falta de disponibilidad,
incumplimiento en la fecha de entrega, incumplimiento o definición de tiempos de respuesta o
suspensión del servicio y/o entrega temporal o permanente de los SERVICIOS, o en aquellos casos
en que los objetivos preestablecidos por el SUSCRIPTOR puedan verse afectados por cualesquiera
de los incumplimientos antes descritos y que no hayan sido posible resolver mediante el Servicio
de Asesoría y Soporte Técnico.
NOVENA. ÁREAS DE PUBLICIDAD DEL PROYECTO.-
El SUSCRIPTOR reconoce y acuerda que las áreas destinadas para publicidad que se presentan
dentro de LOS SITIOS de EXPIDETUFACTURA así como los envíos de los CFDIS y en general en y
durante la prestación del SERVICIOS son de uso exclusivo de EXPIDETUFACTURA y que esta última
puede comercializar dichos espacios de acuerdo a su mejor conveniencia, en el entendido que
EXPIDETUFACTURA se compromete a no contratar publicidad negativa o publicidad que afecte al
SUSCRIPTOR.
DECIMA. ADMINISTRACIÓN Y CONTROL.-
El SUSCRIPTOR será el único responsable de la administración y uso de los datos para generar los
CFDIS, siendo EXPIDETUFACTURA el único responsable de la prestación del Servicio, la operación y
ejecución de los procesos en tiempo y del debido cumplimiento de los Requerimientos Legalesaplicables para tal efecto. El SUSCRIPTOR acepta que no podrá realizar ninguna alteración o
modificación al SISTEMA EXPIDETUFACTURA y que EXPIDETUFACTURA no será responsable por
problemas que se presenten al momento de operar el Proyecto cuando obedezcan al mal
funcionamiento del equipo, software y entorno de comunicaciones a Internet que utilice el
SUSCRIPTOR. En virtud de que este contrato constituye únicamente una licencia de uso y un
contrato de prestación de SERVICIOS en los términos especificados en este Contrato, y no de
compraventa de bienes o de cualquier otra naturaleza, y salvo lo antes dispuesto en este,
EXPIDETUFACTURA no otorga ninguna otra garantía expresa o implícita.
DECIMA PRIMERA. VIGENCIA Y TERMINACION ANTICIPADA.-
Las Partes en este acto convienen que la vigencia inicial del presente Contrato será por 1 (un) año
a partir de su fecha de firma electrónica con renovaciones automáticas por períodos subsecuentes
de 1 (un) año a menos que alguna de las Partes manifieste su deseo de dar por terminado el
presente Contrato. El SUSCRIPTOR tendrá la posibilidad de cerrar su cuenta dentro de
EXPIDETUFACTURA en el momento que el lo desee y sin obligación alguna para EXPIDETUFACTURA
para seguir salvaguardando su información personal, esto será responsabilidad única y
exclusivamente del SUSCRIPTOR el respaldar su información y CFDIS correspondientes así como
tramitar ante el SAT la baja de uso del PAC de EXPIDETUFACTURA.
En caso de que EXPIDETUFACTURA manifieste su deseo de dar por terminado el presente contrato
con el SUSCRIPTOR, EXPIDETUFACTURA notificará al SUSCRIPTOR por lo menos con 30 (treinta)
días de anticipación a la fecha de terminación del período inicial o renovación correspondiente
para que el SUSCRIPTOR tome sus medidas correspondientes, incluyendo el respaldo de su
información y CFDIS correspondientes. En caso de terminación del presente Contrato, sin importar
la causa que genere tal terminación, las Partes acuerdan que en caso de darse la terminación
anticipada del Contrato, éstas realizarán la liquidación correspondiente en caso de existir, a sus
obligaciones pendientes a la fecha de terminación de la relación contractual.
DECIMO SEGUNDA. INFORMACIÓN CONFIDENCIAL.-
Cada una de las Partes reconoce que con relación al presente Contrato, la otra Parte le ha
proporcionado o le puede proporcionar información confidencial. Ambas Partes reconocen que
toda la información y/o documentación a que tenga acceso, que le sea revelada y/o entregue la
otra Parte relacionada o no con el presente Contrato, en todo tiempo y aún terminado el mismo,
es de naturaleza confidencial y que representa un activo valioso y secreto comercial e industrial de
dicha otra Parte para todo propósito. En consecuencia, ambas Partes se comprometen a limitar el
acceso de toda dicha información y documentos proporcionándolos únicamente a aquellas
personas que necesiten tener conocimiento de ello para el cumplimiento del presente Contrato.Al firmar electrónicamente este contrato, el SUSCRIPTOR estará de acuerdo y se sujetará a todas
las políticas de privacidad de EXPIDETUFACTURA. La última versión de las mismas se encuentra en
http://www.expidetufactura.com.mx/PPM.html
DECIMO TERCERA. RESTRICCION DE USO DE MARCAS Y LOGOTIPO.-
Ambas Partes reconocen que la otra Parte es titular de ciertas marcas y signos distintivos que son
las marcas registradas principales de los SERVICIOS prestados por dichas Partes. Los contratantes
se obligan a no utilizar en ninguna forma dichas marcas, signos distintivos, nombres comerciales
(los Signos Distintivos ) y, en general, derechos de propiedad industrial de la otra Parte o
cualquier abreviación o variante de las mismas, o cualquier signo distintivo similar en grado de
confusión con los anteriores, para usarla como parte de su nombre comercial.
Asimismo las Partes acuerdan que para la prestación del Servicio objeto del presente Contrato, el
SUSCRIPTOR otorga en este acto su consentimiento y autorización a favor de EXPIDETUFACTURA
del uso de Las Marcas del SUSCRIPTOR y/o Signos Distintivos de su propiedad, uso que únicamente
podrá realizarse para el debido cumplimiento de las obligaciones a su cargo, en los términos y
alcances previstos en este el Contrato. El presente Contrato, en ningún caso se entenderá como
licencia, autorización o cesión de alguno de los derechos de propiedad industrial del SUSCRIPTOR.
Las Partes aceptan y acuerdan que en caso que alguna de las Partes reciba cualquier reclamo de
terceros por el hecho que la otra Parte haya utilizado sin autorización los derechos intelectuales, o
de cualquier naturaleza propiedad de terceros, los cuales, por cualquier razón o circunstancia
estén o hayan sido utilizados para el cumplimiento de sus obligaciones objeto del presente
Contrato, la Parte que incumpla y que haya violado los derechos de terceros asumirá la obligación
de resolver el conflicto, siendo responsable de indemnizar a cualquier demandante legítimo y
liberando y manteniendo en paz y a salvo a la otra Parte de toda responsabilidad y contingencia.
Lo anterior, incluye asimismo, cualquier daño o perjuicio que algún tercero o la Parte demandada
o afectada llegaren a sufrir en sus propiedades, bienes o personas por causas derivadas, entre
otros y sin limitación, de una utilización negligente, dolosa o incorrecta de la Parte culpable, y/o de
información incompleta, insuficiente, incorrecta o falsa relacionada con el presente Contrato. Esta
obligación continuará aún después de haber terminado este Contrato.
DECIMO CUARTA. CONTRATANTES INDEPENDIENTES.-
Para la prestación, ejecución y desempeño del objeto del presente Contrato, ambas Partes
aceptan y reconocen que actuarán como entidades independientes y en ningún momento se
entenderá que han celebrado este Contrato concediendo el carácter de SUSCRIPTOR exclusivo,
quedando ambas Partes facultadas en todo momento de contratar por éste y otros SERVICIOS, con
cualquier otra entidad o persona que libremente elija.
En virtud de lo establecido en el párrafo que antecede, las Partes aceptan que cada una de ellas
actúa por cuenta y a nombre propio y no como empleado, agente, representante o distribuidor dela otra parte, no siendo el presente instrumento, sujeto de las disposiciones de la Ley Federal del
Trabajo. En consecuencia, las Partes en ningún momento tendrán la facultad de comprometer a la
otra en Contrato laboral alguno, ni a contratar empleados en nombre o representación de aquella.
Asimismo, las Partes reconocen que no existe relación laboral alguna entre los empleados del
SUSCRIPTOR y EXPIDETUFACTURA ni entre los empleados de EXPIDETUFACTURA y del
SUSCRIPTOR. Las Partes reconocen expresamente la relación laboral que las mismas tienen con
sus respectivos empleados, por lo que cada una de ellas es el patrón de sus empleados, mismo
que reúne los requisitos a que se refiere la Ley Federal del Trabajo; por lo tanto, cada una de las
Partes será la única responsable y principal obligado para con sus respectivos empleados, de todas
y cada una de las obligaciones laborales, entre las que destacan de forma enunciativa más no
limitativa, el pago de salarios, vacaciones, tiempo extra, aportaciones al Instituto del Fondo
Nacional para la Vivienda de los Trabajadores (INFONAVIT), cuotas obrero patronales ante el
Instituto Mexicano del Seguro Social (IMSS) y demás prestaciones laborales, así como de los
conflictos que puedan surgir con el citado personal derivados de accidentes, despido, enfermedad,
muerte y demás obligaciones a cargo del patrón, según lo dispuesto en la Ley Federal del Trabajo.
Cada parte se obliga a liberar a la otra, de cualquier responsabilidad laboral que pudiere surgir en
términos de lo dispuesto por los artículos 13 y 15 de la citada ley, así como por las demás
disposiciones que resulten aplicables, respecto de sus empleados, agentes y comisionistas.
En virtud de lo anterior queda expresamente pactado que este documento no atribuye al
SUSCRIPTOR o sus empleados, el cargo de agentes o empleados de EXPIDETUFACTURA; asimismo,
tampoco atribuye EXPIDETUFACTURA, ni a sus empleados el cargo de agentes o empleados del
SUSCRIPTOR, por lo que las Partes se obligan a sacar en paz y a salvo a la otra parte, en caso de
cualquier reclamación, conflicto, controversia o litigio que pudiera llegar a surgir respecto de sus
empleados, agentes o comisionistas en relación con este Contrato.
DECIMO QUINTA.- LIMITACIÓN DE CONTRATACIONES.-
Las Partes convienen que durante la vigencia del presente Contrato y por un plazo de un (1) año
posterior a la terminación o vencimiento del mismo, ninguna Parte, salvo con el consentimiento
previo por escrito de la otra Parte, solicitará u ofrecerá empleo a un empleado de la otra Parte que
hubiera participado durante la prestación de los SERVICIOS de manera directa e importante. Esta
disposición no limitará el derecho de las Partes de solicitar o contratar de forma general a través
de los medios, y no prohibirá a las Partes contratar a un empleado de la otra Parte quien responda
a cualquier anuncio, o quien de otra forma solicite voluntariamente el empleo sin haber recibido
inicial y personalmente una oferta de empleo de la Parte contratante.
DECIMO SEXTA. AVISOS, NOTIFICACIONES Y COMUNICACIONES.-Para todo lo relativo al presente Contrato, para todos los efectos legales correspondientes y para
efectuar los avisos y comunicaciones que tuvieren necesidad de darse en relación con este
Contrato, las Partes señalan como sus domicilios:
SUSCRIPTOR:${emisor.razonSocial} -----------------
Correo Electrónico: ${emisor.email} -------------
EXPIDETUFACTURA
Correo Electrónico: replegal@expidetufactura.com.mx
DECIMA SÉPTIMA. CAUSAS DE RESCISIÓN.-
Serán causales de rescisión del presente Contrato sin necesidad de declaración o resolución
judicial las siguientes:
1. Que cualquiera de las partes falsee información a la otra parte durante la supervisión del
cumplimiento del presente Contrato.
2. El incumplimiento de alguna de las Partes a cualquiera de las obligaciones contraídas en este
Contrato o al acuerdo de términos y condiciones generales de uso de EXPIDETUFACTURA
(http://www.expidetufactura.com.mx/ATCUM.html)
3. En caso que el SUSCRIPTOR sin causa no realice los pagos o contraprestaciones de los SERVICIOS
en caso de contratarlos.
4. En caso que el SUSCRIPTOR injustificadamente no permita a los empleados de
EXPIDETUFACTURA la realización de los SERVICIOS o entorpezca la realización de los mismos.
DECIMA OCTAVA. DE LAS CAUSAS DE FUERZA MAYOR.-
Ninguna de las Partes será responsable del incumplimiento o del cumplimiento puntual de
cualquiera de sus obligaciones derivadas del presente Contrato y estas obligaciones se ampliarán
durante un período razonable a la vista de las circunstancias, si el cumplimiento es impedido o
retrasado por causas de fuerza mayor, entendiéndose como tales, de manera enunciativa mas no
limitativa las siguientes: disputas industriales, actos de la naturaleza, epidemias, tumultos,
guerras, accidentes, embargos (actos del gobierno) o por cualquier causa que vaya más allá del
control de las Partes afectadas.Sin perjuicio de lo antes mencionado, EXPIDETUFACTURA no será responsable de los daños o
perjuicios ocasionados al SUSCRIPTOR o a los Usuarios Finales para la entrega de CFDIS, por causas
imputables al proveedor de Internet tanto de cualquiera de las Partes como de los Usuarios
Finales ó por fallas en el hardware propiedad de cada una de las Partes o de los Usuarios Finales ó
por fallas en los proveedores de las cuentas de correo electrónico destino contenidas en la Base de
Datos.
DECIMA NOVENA. CESIÓN DE DERECHOS.-
Las Partes no podrán ceder, gravar o traspasar en todo o en parte los derechos y las obligaciones a
su cargo consignadas en este Contrato sin autorización previa y por escrito, en el entendido que el
acto, contrato o hecho que se realice en contravención a lo establecido en la presente Cláusula no
producirá efecto legal alguno.
Sin perjuicio de lo anterior, cualquiera de las Partes podrá, sin requerir previo consentimiento de
la otra Parte, ceder o transferir los derechos y obligaciones que asume conforme a este Contrato,
a cualquier entidad que sea Parte Relacionada (como dicho término se define más adelante) a una
de las Partes que realice la cesión de dichos derechos y obligaciones conforme de este Contrato,
bastando en tal caso un simple aviso a la otra Parte que conste por escrito.
Las Partes acuerdan que para efectos del presente Contrato se entenderá por Partes Relacionadas,
cualquier sociedad, sociedad de responsabilidad limitada, sociedad en nombre colectivo, sociedad
anónima, asociación en participación, asociación, compañía, fideicomiso, o cualquier tipo de
organización, ya sea que la misma se encuentre constituida como una persona moral o no, en lo
sucesivo Persona, que controle a, sea controlada por, o se encuentre bajo el Control común de
algún accionista de cualquiera de las Partes. Para efectos de lo anterior, el término Control
significa la posesión directa o indirecta de más del 50% (cincuenta por ciento) de las acciones o
partes sociales representativas del capital social con derecho a voto de cualquier persona física o
moral y la facultad de dirigir o controlar la administración o políticas de una persona física o moral,
ya sea a través de acciones o de partes sociales, con derecho a voto, a través del consejo de
administración, por medio de algún contrato o por cualesquier otra razón
VIGÉSIMA. IMPUESTOS.-
Todos los impuestos cargas y contribuciones fiscales que, en su caso, se generen con motivo de la
prestación del Servicio correrán por cuenta y a cargo de la Parte que de acuerdo con las
disposiciones fiscales vigentes deba cubrirlas.
VIGÉSIMA PRIMERA. GASTOS Y HONORARIOS PARA LA NEGOCIACIÓN CELEBRACIÓN Y FIRMA DEL
CONTRATO.-Todas las erogaciones por honorarios y gastos de asesores relacionados con la elaboración,
negociación y firma electrónica del presente Contrato deberán ser pagados por la Parte que
contrató los mismos.
VIGÉSIMA SEGUNDA. DIVISIBILIDAD.-
La nulidad o invalidez de cualquiera de las Cláusulas de este Contrato no afectará la validez de
cualquier otra. En caso de ser declarada nula o inválida por un tribunal competente alguna
Cláusula de este Contrato, la misma será considerada como independiente y dividida del resto de
las disposiciones del propio Contrato, las cuales continuarán en pleno vigor conforme a sus
términos.
VIGÉSIMA TERCERA. DERECHOS NO RENUNCIADOS.-
La omisión o negligencia de las Partes en cualquier tiempo para ejercitar sus derechos al
cumplimiento de los términos y obligaciones que el Contrato impone, no podrá por ningún
concepto interpretarse como renuncia al ejercicio de tales derechos y no podrá tampoco cambiar
o afectar los términos del Contrato. Las Partes conservarán, de conformidad a la ley aplicable al
caso concreto, en cualquier tiempo pleno derecho de ejercicio de todas las acciones que le
corresponda sin limitación alguna.
VIGÉSIMA CUARTA. DEL REQUERIMIENTO O INTERPELACIÓN JUDICIAL O EXTRAJUDICIAL.-
Las Partes convienen en que cada una de ellas cumplirá voluntariamente con todas y cada una de
las obligaciones que a su cargo derivan de este Contrato y que no se requerirá para que cumplan
que la otra Parte le interpele o le requiera de cualquier forma el cumplimiento.
En consecuencia, cada una de las Partes renuncia al derecho que le pudiera corresponder,
derivado de la ley, este Contrato y/o cualquier otra causa para exigir ser requerida o interpelada
por la otra Parte como requisito previo al cumplimiento de sus obligaciones.
VIGÉSIMA QUINTA. ENCABEZADOS.-
Los encabezados de las Cláusulas del presente Contrato han sido insertados por simple
conveniencia, por lo que no podrán ni deberán ser utilizadas para la interpretación de dicho
Contrato o de su contenido obligatorio.
VIGÉSIMA SEXTA. CONTRADICCIÓN ENTRE DOCUMENTOS.-
En caso de que llegare a existir alguna contradicción entre los términos del presente Contrato y
alguno de sus Anexos, las disposiciones contenidas en este Contrato prevalecerán y regirán la
relación entre las Partes en todo lo relacionado con la prestación del Servicio y, en general, la
relación entre las Partes conforme al Contrato.
VIGÉSIMA SÉPTIMA.- CONTROVERSIA.-En caso de existir controversia suscitada entre las Partes en el presente Contrato en cuanto a la
interpretación o el sentido que alguna Cláusula en particular de este Contrato se le hubiere
pretendido dar, ambas estarán y aceptarán, como si a la letra se hubiese insertado, el mejor
sentido que así convenga a este Contrato.
VIGESIMA OCTAVA. JURISDICCIÓN.-
Para la interpretación, cumplimiento y ejecución de lo estipulado en el presente Contrato, las
Partes se someten a lo dispuesto por las Leyes y a la Jurisdicción de los Tribunales competentes en
la ciudad de Puebla, Puebla, renunciando expresamente a cualquier otro fuero que pudiera
corresponderles en razón de sus domicilios presentes o futuros.
VIGESIMA NOVENA. ACUERDO TOTAL.-
El presente Contrato constituye el único y total acuerdo entre las Partes en relación con la
prestación del Servicio, por lo que supera y deja sin efecto cualquier otra negociación, obligación
comunicación o documento, ya sea verbal o por escrito, realizada o contraída de cualquier forma
con anterioridad a la fecha de firma electrónica de este Contrato.
Leído que fue por las Partes el presente Contrato y no habiendo dolo, engaño, enriquecimiento
ilegitimo y por contener los términos y condiciones en que cada una desea obligarse, lo firman
electrónicamente y ratifican por duplicado el -----------------

</pre>

</body>
</html>