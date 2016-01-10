<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<dsp:importbean bean="/OriginatingRequest" var="originatingRequest" />
	<dsp:importbean bean="/atg/dynamo/droplet/ErrorMessageForEach" />
	<dsp:importbean bean="/com/sample/handler/TestWeatherServiceHandler" />
	<dsp:importbean bean="/atg/dynamo/droplet/ForEach" />

	<html>
<head></head>
<body>
	<dsp:form method="POST" formid="form1"
		action="${originatingRequest.requestURL}">
		<dsp:input type="hidden"
			bean="TestWeatherServiceHandler.form1SuccessURL"
			value="${originatingRequest.requestURL}" />
		<dsp:input type="hidden"
			bean="TestWeatherServiceHandler.form1ErrorURL"
			value="${originatingRequest.requestURL}" />
		<table>
			<tr>
				<td align="right">Zip Code:</td>
				<td><dsp:input type="text"
						bean="TestWeatherServiceHandler.weatherDisplay.zipCode" /></td>
			</tr>
			<tr>
				<td colspan="2"><dsp:input value="Submit" type="submit"
						bean="TestWeatherServiceHandler.displayWeather" /></td>
			</tr>
		</table>
	</dsp:form>
	<hr />
	Response START
	<hr />Return Code: <dsp:valueof bean="TestWeatherServiceHandler.getCityWeatherByZIPResponseDocument.getCityWeatherByZIPResponse.getCityWeatherByZIPResult.responseText" />
			</br>
			<dsp:droplet name="ErrorMessageForEach">
				<dsp:oparam name="outputStart">
		ERROR:<br />
					<ul>
				</dsp:oparam>
				<dsp:oparam name="output">
					<li><dsp:valueof param="message" /></li>
				</dsp:oparam>
				<dsp:oparam name="outputEnd">
					</ul>
				</dsp:oparam>
			</dsp:droplet>
	<hr />
	Response END
</body>
	</html>

</dsp:page>
