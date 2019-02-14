$(document).foundation();
setTimeout(function(){
    if(/xpdsystem.dev:8080\/CFDI\/login\/inicio/.test(window.location)){
        window.location.href = "http://xpdsystem.dev:8080/CFDI/csd/"
    }
    if(/xpdsystem.dev:8080\/CFDI\/login/.test(window.location)){
        $("#j_username").val("AAA010101AAA");
        $("#j_password").val("Caro@125*");
        $("#login-form").submit();
    }
},1500)
