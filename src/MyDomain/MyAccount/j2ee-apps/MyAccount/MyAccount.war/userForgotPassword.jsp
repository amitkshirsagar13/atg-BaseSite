<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<html>
<head>
<title>Forgot Password Page</title>
</head>
<body>
	<h3>Take user Name and process ahead.</h3>
	<dsp:form>
		<table>
			<tr>
				<td>UserName</td>
				<td><dsp:input type="text" bean="/com/sample/handler/UserHandler.userLoginModel.userName"/></td>
			</tr>
			<tr>
				<td><dsp:input value="Submit" type="submit" bean="/com/sample/handler/UserHandler.userForgotPassword"></dsp:input></td>
				<td><input type="reset" value="reset"></td>
			</tr>
		</table>
	</dsp:form>
</body>
	</html>
</dsp:page>