
$(function(){
	$.getJSON('http://localhost:8080/FitnessTracker/activities.json', {
		ajax : 'true',
		contentType: "application/json; charset=utf-8"
	}, function(data){
		var html = '<option value="">--Please select one activity--</option>';
		var len = data.length;
		for (var i = 0; i < len; i++) {
			html += '<option value="' + data[i].name + '">'
					+ data[i].name + '</option>';
		}
		html += '</option>';
		
		$('#activities').html(html);
	}); 
});


	 
			
				
