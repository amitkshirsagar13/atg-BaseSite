<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<html>
<head>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript" src="/static-domain/resources/js/base.js"></script>
</head>

<body>
	sdfsd
	<div id="cityWeatherRequestDiv">
		<input type="text" alt="City Name" id="cityName" /><br /> <input
			type="button" id="getWeatherButton" value="Get Weather For City" />
	</div>

<hr/>
	<div id="cityWeatherResponse"></div>

	<script type="text/javascript">
		$(document).ready(myFunctionOnReady);
	</script>

</body>
	</html>
</dsp:page>
