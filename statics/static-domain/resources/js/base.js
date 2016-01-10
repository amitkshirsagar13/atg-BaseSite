var weatherResponse;

function myFunctionOnReady() {
	console.log("is ready?");

	$("#getWeatherButton").click(function() {
		getWeatherDetailsForCity();
	});

	console.log("ready!!!");

}

function getWeatherDetailsForCity() {

	var cityName = $("#cityName").val();

	$.ajax({
		type : "POST",
		url : "/MyAccount/json/jsonResponseDroplet.jsp?cityName=" + cityName,
		dataType : 'json',
		success : function(data) {

			$('#cityWeatherResponse').empty();
			//alert(data.weatherDetails);
			for (var i = 0; i < data.weatherDetails.length; i++) {
				$('#cityWeatherResponse').append(
						'<li>' + data.weatherDetails[i].mName+":"+data.weatherDetails[i].mAge+"::"+data.weatherDetails[i].mRelation
								+ '</li>');
			}
		}
	});
}