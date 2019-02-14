var context = "/CFDI33/";

function usuarioGratuito() {
	$('#myModal2').modal({ 
		 backdrop: "static",
	  keyboard: false
	});
	$('.modal-backdrop').css('margin-top', '1px');
	$('#myModal2').show(0);
	$("#backFreeUser").on('click', function(){ window.location.href = "/CFDI33/login/inicio"; });
}

function bloquearFormulario() {
	var inputs = $('input,select,textarea,checkbox,radio');
	inputs.attr('readonly', 'readonly');
}

function redirect(url) {
	document.location.href = url;
}

function eliminar(modulo, id) {
	if (confirm("Desea eliminar ")) {
		$.get(context + "/rest/" + modulo + "/eliminar/" + id, function(borrado) {
			if (borrado) {
				$('#row-' + id + ' td').css('background', '#b94a48').hide('slow');
			} else {
				alert('No se pudo borrar.');
			}
		});
	}
}

function cleanStringPipe(str) {
	if(/\|/.test(str)) {
		return str.replace(/\|/g, "");
	}
}
function cancelKeyPipe(input) {
	$(input).on('keydown', function(e) {
		if(e.key == '|') {
			return false;
		}
	});
	$(input).on('change',function(e) {
		if(/\|/.test($(this).val())) {
			$(this).val(cleanStringPipe($(this).val()));
		}
	});
}
$.validator.addMethod("clave", function(value, element, modulo) { 
	if ($('#claveAnterior').val() == $('#clave').val()) {
		$('#clave').css('border','1px solid #cccccc');
		return true;
	}
	$.get(context + "/rest/" + modulo +"/existe/" + $('#clave').val(), function(existe) {
		if (existe == true) {
				$('#clave').css('border','1px solid red');
				$('#clave').tooltip().attr("data-original-title", "Clave duplicada.").focus();
				return false;
		}
	});
	$('#clave').css('border','1px solid #cccccc');
	return true;
}, jQuery.format("Clave duplicada. Por favor ingrese una nueva"));

$.validator.setDefaults({
    showErrors: function (errorMap, errorList) {                         
       /*
         
        $("." + this.settings.validClass).tooltip("destroy");            
        for (var i = 0; i < errorList.length; i++) {
            var error = errorList[i];
            $("#" + error.element.id).tooltip().attr("data-original-title", error.message)
            $("#" + error.element.id).tooltip('show')
            $("#" + error.element.id).addClass('errorBorder');
            if (!$(error.element).is('select') && !$(error.element).hasClass('contrasena')) {
            	$("#" + error.element.id).focus(); // $(value.element).focus();   
			   }
            
        }
        */
        
    	
    	$.each( this.successList , function(index, value) {
			  $(value).popover('hide');
		  });
		  
		
		  $.each( errorList , function(index, value) {
		  		// value = errorList.shift();
			  // console.log(value);
			  
			   var _popover = $(value.element).popover({
					trigger: 'manual',
					placement: 'top',
					content: value.message,
					container:($(value.element).parents("div.modal-body").length > 0)?'div.modal-body':'body',
					template: '<div class="popover errorPopover"><div class="arrow"></div><div class="popover-inner"><div class="popover-content"><p></p></div></div></div>'
				});
		
			   _popover.data('popover').options.content = value.message;
			   if (!$(value.element).is('select') && !$(value.element).hasClass('contrasena')) {
				   $(value.element).focus();   
			   }
			   $(value.element).popover('show');

		  });
		  
    }
});

jQuery.extend( jQuery.fn.dataTableExt.oSort, {
    "date-euro-pre": function ( a ) {
        if ($.trim(a) != '') {
            var frDatea = $.trim(a).split(' ');
            var frTimea = frDatea[1].split(':');
            var frDatea2 = frDatea[0].split('/');
            var x = (frDatea2[2] + frDatea2[1] + frDatea2[0] + frTimea[0] + frTimea[1] + frTimea[2]) * 1;
        } else {
            var x = 10000000000000; // = l'an 1000 ...
        }
         
        return x;
    },
 
    "date-euro-asc": function ( a, b ) {
        return a - b;
    },
 
    "date-euro-desc": function ( a, b ) {
        return b - a;
    }
} );