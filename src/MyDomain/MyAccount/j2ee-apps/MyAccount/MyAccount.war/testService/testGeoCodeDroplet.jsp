<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<dsp:importbean var="originatingRequest" bean="/OriginatingRequest" />
	<dsp:importbean bean="/com/sample/droplet/TestGeoCodeDroplet" />
	<dsp:importbean bean="/atg/dynamo/droplet/ForEach" />
	<dsp:getvalueof var="requestUrl"
		value="${originatingRequest.requestURI}" />

	<html>
<head></head>
<body>
	<dsp:form action="${requestUrl}" method="GET" formid="form1">
		<table>
			<tr>
				<td align="right">CityName:</td>
				<td><input type="Text" name="usCity" /></td>
			</tr>
			<tr />
			<td colspan="2"><input type="Submit" /></td>
			</tr>
		</table>
	</dsp:form>
	<hr />
	DROPLET START
	<hr />
	<dsp:droplet name="TestGeoCodeDroplet">
		<dsp:oparam name="output">
		Return Code: <dsp:setvalue param="citys"
				paramvalue="cityInfo.getInfoByCityResponse.getInfoByCityResult.domNode.firstChild" />

			<dsp:droplet name="ForEach">
				<dsp:param name="array" param="citys" />
				<dsp:setvalue param="table" paramvalue="element" />
				<dsp:oparam name="outputStart">
					<ul>
				</dsp:oparam>
				<dsp:oparam name="output">
					<li><dsp:valueof param="table.city" />|<dsp:valueof
							param="table.zip" /></li>
				</dsp:oparam>
				<dsp:oparam name="outputEnd">
					</ul>
				</dsp:oparam>
			</dsp:droplet>
			</br>
		</dsp:oparam>
		<dsp:oparam name="error">
		ERROR:<br />
			<dsp:droplet name="ForEach">
				<dsp:param name="array" param="errorMessages" />
				<dsp:setvalue param="errorMessage" paramvalue="element" />
				<dsp:oparam name="outputStart">
					<ul>
				</dsp:oparam>
				<dsp:oparam name="output">
					<li><dsp:valueof param="errorMessage" /></li>
				</dsp:oparam>
				<dsp:oparam name="outputEnd">
					</ul>
				</dsp:oparam>
			</dsp:droplet>
		</dsp:oparam>
	</dsp:droplet>
	<hr />
	DROPLET END
</body>
	</html>

</dsp:page>
