/*
 * @Tabla Pagos
 * version:1.0
 *
 */
(function (window, document) {
    var tableCfdiPagos = {
        bandera: false,
        toprevent: "",
        objselect: { bg: "#BBB0AF", txt: "#333333" },
        objprevent: { bg: "#f9f9f9", txt: "#333333" },
        data: { uuid: "", folio: "", serie: "", metodopago: "", cambio: "", moneda: "" },
        idModal: "confirm",
        mensaje: undefined,
        evaluado: false,
        paginate: false,
        topreventrow: [],
        rowSelect: function (row, uuid, serie, folio, metodopago, tipocambio, moneda) {
            if (this.topreventrow.length > 0) {
                for (var i = 0; i < this.topreventrow.length; i++) {
                    if (document.getElementById(this.topreventrow[i]) != null) {
                        this.bgChildren(this.topreventrow[i], this.objprevent.bg, this.objprevent.txt);
                        this.topreventrow.splice(i, 1);
                    }
                }
            }
            this.data.uuid = uuid;
            this.data.serie = serie;
            this.data.folio = folio;
            this.data.metodopago = metodopago;
            this.data.cambio = tipocambio;
            this.data.moneda = moneda;
            this.evaluado = false;
            if (!this.bandera) {
                if (this.toprevent != "") {
                    this.bgChildren(this.toprevent, this.objprevent.bg, this.objprevent.txt);
                }
                this.bgChildren(row, this.objselect.bg, this.objselect.txt);
                this.toprevent = row;
                this.bandera = true;
            }
            else {
                if (this.toprevent != "") {
                    this.bgChildren(this.toprevent, this.objprevent.bg, this.objprevent.txt);
                }
                this.bgChildren(row, this.objselect.bg, this.objselect.txt);
                this.toprevent = row;
                this.bandera = false;
            }
            var jsontable = null;
            jsontable = document.getElementById("jsontable");
            if (jsontable != null) {
                jsontable.value = JSON.stringify(this.data);
            }
        },
        bgChildren: function (row, bg, txt) {
            try {
                var children = undefined;
                children = document.getElementById(row).children;
                for (var i = 0; i < children.length; i++) {
                    children[i].style = "background:" + bg + ";color:" + txt + ";border-left:0px !important;font-size: 13px;";
                }
            }
            catch (e) {
                if (this.bandera == true) {
                    if (this.toprevent != "") {
                        this.topreventrow.push(this.toprevent);
                        this.toprevent = "";
                    }
                }
                else {
                    this.topreventrow.push(this.toprevent);
                    this.toprevent = "";
                }
            }
        },
        createTable: function (data) {
            var row = 1;
            var str = "";
            $.each(data, function (i, v) {
                var status = v.estatus;
                var divstatus = "<div class=";
                if (status == 'emitido') {
                    divstatus += "'badge badge-success'>emitido</div>";
                }
                else if (status == 'En proceso') {
                    divstatus += "'badge badge-warning'>En proceso</div>";
                }
                else {
                    divstatus += "'badge badge-important'>cancelado</div>";
                }
                //validando Campos
                var uuid = "", folio = "", serie = "", iva = "", subtotal = "", total = "", metodopago = "", tipocambio = "", moneda = "";
                if (v.uuid != undefined && v.uuid != null) {
                    uuid = v.uuid;
                }
                if (v.folio != undefined && v.folio != null) {
                    folio = v.folio;
                }
                if (v.serie != undefined && v.serie != null) {
                    serie = v.serie;
                }
                if (v.iva != undefined && v.iva != null) {
                    iva = "$ " + v.iva;
                }
                if (v.subTotal != undefined && v.subTotal != null) {
                    subtotal = "$ " + v.subTotal;
                }
                if (v.total != undefined && v.total != null) {
                    total = "$ " + v.total;
                }
                var metodoPago = "", tipoCambio = "", moneda = "", complemento = undefined;
                try {
                    complemento = JSON.parse(v.json);
                }
                catch (e) { }
                if (complemento != "" && complemento != null && complemento != undefined) {
                    try {
                        tipocambio = complemento.tipoCambio;
                    }
                    catch (e) { }
                    try {
                        moneda = complemento.moneda;
                    }
                    catch (e) { }
                    try {
                        metodoPago = complemento.metodoPago;
                    }
                    catch (e) { }
                }
                var style = "style='border-left:0px;border-right:0px;line-height: 15px !important;'";
                var fecha = new Date(v.fechaDate);
                var arrayfecha = fecha.toLocaleString().split("/");
                var day = parseInt(arrayfecha[0]);
                var month = parseInt(arrayfecha[1]);
                if (day < 10) {
                    day = "0" + arrayfecha[0];
                }
                if (month < 10) {
                    month = "0" + arrayfecha[1];
                }
                str = str + "<tr style='cursor:pointer;box-shadow: 1px 2px 0px #ccc;'  onclick=\"selectRowcfdiPagos('row-" + row + "','" + uuid + "','" + serie + "','" + folio + "','" + metodoPago + "','" + tipocambio + "','" + moneda + "')\" id='row-" + row + "'><td " + style + ">" + v.tipoComprobante + "</td><td " + style + ">" + serie + "</td><td " + style + ">" + folio + "</td><td " + style + ">" + uuid + "</td><td style='display:none !important'></td><td " + style + ">" + v.rfcReceptor + "</td><td " + style + ">" + subtotal + "</td><td " + style + ">" + iva + "</td><td " + style + "'>" + total + "</td><td " + style + ">" + (day + "-" + month + "-" + arrayfecha[2]) + "</td><td " + style + ">" + divstatus + "</td><td style='display:none'></td><td style='display:none'></td><td style='display:none'></td><td style='display:none'></td><td style='display:none' ></td></tr>";
                ++row;
            });
            var filtro = '<tr style="background:transparent!" class="filterHeader"><th rowspan="1" colspan="1"><input type="hidden" name="search_platform" placeholder="Tipo" value="" class="search_init span1" /></th>' +
                '<th rowspan="1" colspan="1"><input id="1" onkeyup="tablaPagos(\'buscar\',this)" style="width:100%!important" class="span1 search_init" type="text" name="search_platform" placeholder="Serie" value="" /></th>' +
                '<th rowspan="1" colspan="1"><input id="2" onkeyup="tablaPagos(\'buscar\',this)" style="width:100%!important" class="span1 search_init" type="text" name="search_version" placeholder="Folio" value="" /></th>' +
                '<th rowspan="1" colspan="1"><input id="3" onkeyup="tablaPagos(\'buscar\',this)" style="width:100%!important" class="span1 search_init" type="text" name="search_uuid" placeholder="UUID" value="" /></th>' +
                '<th rowspan="1" colspan="1"><input id="4" onkeyup="tablaPagos(\'buscar\',this)" style="width:100%!important" class="span1 search_init" type="text" name="search_confirmacion" placeholder="Confirmacion" value="" /></th>' +
                '<th rowspan="1" colspan="1"><input id="5" onkeyup="tablaPagos(\'buscar\',this)" style="width:100%!important" class="span1 search_init" type="text" name="search_grade" placeholder="Cliente" value="" /></th>' +
                '<th rowspan="1" colspan="1"><input id="6" onkeyup="tablaPagos(\'buscar\',this)" style="width:100%!important" class="span1 search_init" type="text" name="search_engine" placeholder="Subtotal" value="" /></th>' +
                '<th rowspan="1" colspan="1"><input id="7" onkeyup="tablaPagos(\'buscar\',this)" style="width:100%!important" class="span1 search_init" type="text" name="search_browser" placeholder="iva" value="" /></th>' +
                '<th rowspan="1" colspan="1"><input id="8" onkeyup="tablaPagos(\'buscar\',this)" style="width:100%!important" class="span1 search_init" type="text" name="search_platform" placeholder="Total" value="" /></th>' +
                '<th rowspan="1" colspan="1"><input id="9" onkeyup="tablaPagos(\'buscar\',this)" style="width:100%!important" class="span1 search_init" type="text" name="search_version" placeholder="Creaci&oacute;n" value="" /></th>' +
                '<th rowspan="1" colspan="1"><input id="10" onkeyup="tablaPagos(\'buscar\',this)" style="width:100%!important" class="span1 search_init" type="text" name="search_grade" placeholder="Estatus" value="" /></th>' +
                '<th style="display:none;" rowspan="1" colspan="1"></th>' +
                '<th style="display:none;" rowspan="1" colspan="1"></th>' +
                '<th style="display:none" rowspan="1" colspan="1"></th>' +
                '<th style="display:none;" rowspan="1" colspan="1"><input class="span1 search_init" type="text" name="search_version" value="" /></th>' +
                '<th style="display:none;"  rowspan="1" colspan="1">Buscar Por <input type="hidden" name="search_platform" placeholder="Generacion" value="" class="search_init"></th></tr>';
            var head = '<tr><th class="sorting"  onclick="tablaPagos(\'clear\',this)">Tipo</th><th class="sorting" onclick="tablaPagos(\'clear\',this)">Serie</th><th class="sorting"  onclick="tablaPagos(\'clear\',this)">Folio</th>' +
                '<th class="sorting" onclick="tablaPagos(\'clear\',this)">UUID</th>' +
                '<th class="sorting" onclick="tablaPagos(\'clear\',this)">Confirmaci&oacute;n</th>' +
                '<th class="sorting" onclick="tablaPagos(\'clear\',this)">RFC Cliente</th>' +
                '<th class="sorting" onclick="tablaPagos(\'clear\',this)" class="cantidad">Subtotal</th>' +
                '<th class="sorting" onclick="tablaPagos(\'clear\',this)" class="cantidad">I.V.A.</th>' +
                '<th class="sorting" onclick="tablaPagos(\'clear\',this)" class="cantidad">Total</th>' +
                '<th class="sorting" onclick="tablaPagos(\'clear\',this)">Creaci&oacute;n</th>' +
                '<th class="sorting" onclick="tablaPagos(\'clear\',this)">Estatus</th>' +
                '<th style="display:none;">Enviado</th>' +
                '<th style="display:none;">Opciones</th>' +
                '<th style="display:none;" class="mAddenda">Addenda</th>' +
                '<th style="display:none;">Razon Social</th>' +
                '<th>F</th></tr>';
            var table = "<table id='listaCfd' style='width:100% !important' data-name=\"relacionados\" class=\"table table-striped table-bordered table-hover\" id=\"listaCfd\">" +
                "<thead>" + filtro + head + "</thead>" +
                "<tbody id=\"listaCfdbody\">" + str + "</tbody></table>";
            $('#listaCfd').DataTable({ "bDestroy": true }).fnDestroy();
            $('#listaCfd').html(table);
            var oTable = $('#listaCfd').dataTable({
                "bSort": true,
                "aoColumns": [
                    null,
                    null,
                    null,
                    { "bSearchable": true },
                    { "bVisible": false },
                    null,
                    null,
                    null,
                    { "sSortDataType": "date-euro-pre" },
                    { "sSortDataType": "date-euro-pre" },
                    { "bSearchable": true, "bSortable": false },
                    { "bVisible": false },
                    { "bVisible": false },
                    { "bVisible": false },
                    { "bVisible": false },
                    { "bVisible": false } // fecha  
                ],
                "bDestroy": true,
                "oLanguage": {
                    "sProcessing": "Procesando...",
                    "sLengthMenu": "Mostrar _MENU_ registros",
                    "sZeroRecords": "No se encontraron resultados",
                    "sInfo": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
                    "sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
                    "sInfoPostFix": "",
                    "sSearch": "Buscar:",
                    "sUrl": "",
                    "sInfoThousands": ",",
                    "sLoadingRecords": "Cargando...",
                    "oPaginate": {
                        "sFirst": "Primero",
                        "sLast": "Ultimo",
                        "sNext": "Siguiente",
                        "sPrevious": "Anterior"
                    },
                    "oAria": {
                        "sSortAscending": ": Activar para ordenar la columna de manera ascendente",
                        "sSortDescending": ": Activar para ordenar la columna de manera descendente"
                    }
                },
                "aaSorting": [[9, "date-euro-pre"]]
            });
        },
        println: function (cadena) {
            document.write(cadena);
        },
        hiddenModal: function () {
            var json = undefined;
            json = document.getElementById("jsontable");
            if (json != undefined) {
                var data = JSON.parse(json.value);
                var uuid = undefined;
                uuid = document.getElementById("idDocumento");
                if (uuid != undefined && uuid != null) {
                    uuid.value = data.uuid;
                }
                var serie = undefined;
                serie = document.getElementById("seriePagos");
                if (serie != undefined && serie != null) {
                    serie.value = data.serie;
                }
                var folio = undefined;
                folio = document.getElementById("folioPagos");
                if (folio != undefined && folio != null) {
                    folio.value = data.folio;
                }
                if (data.metodopago != null && data.metodopago != "" && data.metodopago != "null") {
                    if (data.metodopago == "PPD") {
                        var tagmetodopago = undefined;
                        tagmetodopago = document.getElementById("metodoDePagoDR");
                        if (tagmetodopago != null) {
                            tagmetodopago.selectedIndex = "2";
                        }
                    }
                    else {
                        var tagmetodopago = undefined;
                        tagmetodopago = document.getElementById("metodoDePagoDR");
                        if (tagmetodopago != null) {
                            tagmetodopago.selectedIndex = "1";
                        }
                    }
                }
                else {
                    var tagmetodopago = undefined;
                    tagmetodopago = document.getElementById("metodoDePagoDR");
                    if (tagmetodopago != null) {
                        tagmetodopago.selectedIndex = "0";
                    }
                }
                if (data.moneda != undefined && data.cambio != 'undefined') {
                    if (data.moneda != "MXN") {
                        var selectmoneda = null;
                        selectmoneda = document.getElementById("tipoCambioDR");
                        if (selectmoneda != null) {
                            selectmoneda.value = data.cambio;
                        }
                    }
                    else {
                        var selecttipocambio = null;
                        selecttipocambio = document.getElementById("tipoCambioDR");
                        if (selecttipocambio != null) {
                            selecttipocambio.value = "";
                        }
                    }
                }
                else {
                    var tipoCambioDR = undefined;
                    tipoCambioDR = document.getElementById("tipoCambioDR");
                    if (tipoCambioDR != undefined && tipoCambioDR != null) {
                        tipoCambioDR.value = "";
                    }
                }
                $("#monedaDR").children().each(function (i, v) {
                    if (data.moneda == v.value) {
                        var selectmoneda = document.getElementById("monedaDR");
                        document.getElementById("monedaDR").selectedIndex = i;
                    }
                });
            }
        },
        showModal: function () {
            try {
                var self = this, contenido = undefined;
                //Se agrega funcionalidad asincronica con las promesas axios
                axios.get("/CFDI33/rest/comprobante/listarTablaPagos", {})
                    .then(function (response) {
                    self.createTable(response.data);
                })
                    .catch(function (error) {
                    console.log(error);
                });
            }
            catch (e) {
            }
        },
        clear: function () {
            this.bandera = false;
            this.bgChildren(this.toprevent, this.objprevent.bg, this.objprevent.txt);
            this.toprevent = "";
        },
        search: function () {
            var mes = null;
            mes = document.getElementById('mes');
            var year = null;
            year = document.getElementById('anio');
            this.bandera = false;
            this.toprevent = "";
            if (this.mensaje == undefined) {
                this.mensaje = document.createElement('span');
            }
            if (mes.value.length == 0) {
                this.mensaje.setAttribute('id', 'msg-error-month');
                this.mensaje.innerHTML = "Seleccione un valor";
                var father = document.getElementById("tablepagos");
                father.appendChild(this.mensaje);
                return false;
            }
            if (year.value == "") {
                this.mensaje.setAttribute('id', 'msg-error-year');
                this.mensaje.innerHTML = "Seleccione un valor";
                var father = document.getElementById("tablepagos");
                father.appendChild(this.mensaje);
                return false;
            }
            else {
                try {
                    var d = document.getElementById("btnsearchPagos");
                    this.mensaje.setAttribute('id', 'msg-error-hidden');
                    if (d.getAttribute('data-bandera') == "true") {
                        alert("un segundo cargando datos");
                    }
                    else {
                        d.setAttribute('data-bandera', 'true');
                        var self = this;
                        //Se agrega funcionalidad asincronica con las promesas axios
                        axios.post("/CFDI33/rest/comprobante/listarCfdi/" + year.value + "/" + mes.value, {})
                            .then(function (response) {
                            self.createTable(response.data);
                            d.setAttribute('data-bandera', 'false');
                        })
                            .catch(function (error) {
                            console.log(error);
                        });
                    }
                }
                catch (e) {
                }
            }
        }
    };
    window.tablepagos = window.$$ = tableCfdiPagos;
})(window, document);
//# sourceMappingURL=object.js.map