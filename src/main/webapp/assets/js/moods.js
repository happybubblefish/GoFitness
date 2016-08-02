/**
 * 
 */
$(function() {
	$.getJSON('http://localhost:8080/FitnessTracker/moods.json', {
		ajax : 'true'
	}, function(data) {
		var html = '<option value="">--Please select your mood--</option>';
		var len = data.length;
		for (var i = 0; i < len; i++) {
			html += '<option value="' + data[i] + '">' + data[i] + '</option>';
		}
		html += '</option>';

		$('#moods').html(html);
	});

	$("#datepicker").datepicker();

	$('.message a').click(function() {
		$('form').animate({
			height : "toggle",
			opacity : "toggle"
		}, "slow");
	});
});