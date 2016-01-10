<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<dsp:importbean bean="/com/sample/droplet/MyAccountDroplet" />
	<dsp:importbean bean="/atg/dynamo/droplet/ForEach" />
	<dsp:droplet name="MyAccountDroplet">
		<dsp:param name="name" value="Poonam" />
		<dsp:param name="age" value="29" />
		<dsp:param name="role" value="NEWUSER" />
		<dsp:oparam name="output">
			<dsp:valueof param="myAccount.name" />
			<dsp:droplet name="ForEach">
				<dsp:param name="array" param="myAccountHash.demoMap" />
				<dsp:setvalue param="user" paramvalue="element" />
				<dsp:oparam name="output">
					<dsp:valueof param="key" /> - <dsp:valueof param="user.age" /> -- <dsp:valueof
						param="user.role" />
				</dsp:oparam>
			</dsp:droplet>
		</dsp:oparam>
	</dsp:droplet>
</dsp:page>