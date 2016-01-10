<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<dsp:importbean bean="/com/sample/droplet/MyAccountDroplet" />
	<dsp:importbean bean="/atg/dynamo/droplet/ForEach" />sl
	<dsp:droplet name="MyAccountDroplet">
		<dsp:param name="name" value="Poonam" />
		<dsp:param name="age" value="27" />
		<dsp:param name="role" value="NEWUSER" />
		<dsp:oparam name="output">
		++<dsp:valueof param="myAccount.name" />|<dsp:valueof param="myAccount.age" />|<dsp:valueof param="myAccount.role" />++
			<dsp:droplet name="ForEach">
				<dsp:param name="array"
					param="myAccountHash.demoMap" />
				<dsp:setvalue param="user" paramvalue="element" />
				<dsp:oparam name="output">
					-- <dsp:valueof param="user.name" />|<dsp:valueof param="user.age" />|<dsp:valueof param="user.role" />
				</dsp:oparam>
			</dsp:droplet>
		</dsp:oparam>
	</dsp:droplet>
</dsp:page>