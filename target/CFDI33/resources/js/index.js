
$(function() {
	$('.ventpop').hide();
	$('.ventpop').fadeIn(1000);
	$('.botoncerrarv').click(function (e) {
	$('.ventpop').fadeOut(700);
	$('#overlay').removeClass('blur-in');
	$('#overlay').addClass('blur-out');
	e.stopPropagation();
	});
	$('.botonform').click(function (e) {
		$('.ventpop').fadeOut(700);
		$('#overlay').removeClass('blur-in');
		$('#overlay').addClass('blur-out');
		e.stopPropagation();
		});
});