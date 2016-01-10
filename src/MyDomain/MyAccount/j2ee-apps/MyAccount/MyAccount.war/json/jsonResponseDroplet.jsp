<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<dsp:importbean bean="/com/sample/droplet/JsonResponseDroplet" />
	<dsp:droplet name="JsonResponseDroplet">
		<dsp:param name="cityName" value="${param.cityName}" />
		<dsp:oparam name="output">
		</dsp:oparam>
	</dsp:droplet>
</dsp:page>