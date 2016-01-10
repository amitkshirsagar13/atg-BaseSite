<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<dsp:importbean bean="/com/sample/handler/BaseCartModifierFormHandler" />
	<dsp:importbean bean="/atg/dynamo/droplet/ErrorMessageForEach" />
	<dsp:importbean bean="/atg/dynamo/droplet/ForEach" />
	<dsp:importbean bean="/atg/dynamo/droplet/Switch" />
	<html>
<head>
<title>Add Remove Item Page</title>
</head>
<body>
	<h3>Add Item</h3>
	<dsp:form formid="removeItemFromCart" id="removeItemFromCart"
		method="POST">
		<dsp:input type="text" id="itemProdIdHid"
			bean="BaseCartModifierFormHandler.productIds" />
		<br />
		<dsp:input type="text" id="itemSkuIdHid"
			bean="BaseCartModifierFormHandler.catalogRefIds" />
		<br />
		<dsp:input type="hidden" id="itemQtyHid"
			bean="BaseCartModifierFormHandler.items[0].quantity" value="1" />
		<dsp:input type="submit"
			bean="BaseCartModifierFormHandler.removeAndAddItemToOrder" />
	</dsp:form>
	<hr />
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


	<hr />

	<h3>Remove Item</h3>
	<dsp:form formid="removeItemFromCart" id="removeItemFromCart"
		method="POST">
		<dsp:input type="text" id="commerceItemIdHid"
			bean="BaseCartModifierFormHandler.removalCommerceItem" value="" />
		<dsp:input type="submit"
			bean="BaseCartModifierFormHandler.removeItemFromOrder" />
	</dsp:form>
	<hr />
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
	<hr />


	<hr />
</body>
	</html>
</dsp:page>