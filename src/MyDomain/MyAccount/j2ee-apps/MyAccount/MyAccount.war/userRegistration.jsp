<%@ taglib prefix="dsp"
	uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<html>
<head>
<title>Login Page</title>
</head>
<body>
	<h3>Login</h3>
	<dsp:form>
		<table>
			<tr>
				<td>First Name</td>
				<td><dsp:input type="text"
						bean="/com/sample/handler/UserHandler.userRegistrationModel.firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><dsp:input type="text"
						bean="/com/sample/handler/UserHandler.userRegistrationModel.lastName" /></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><dsp:input type="text"
						bean="/com/sample/handler/UserHandler.userRegistrationModel.userName" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><dsp:input type="text"
						bean="/com/sample/handler/UserHandler.userRegistrationModel.password" /></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><dsp:input type="text"
						bean="/com/sample/handler/UserHandler.userRegistrationModel.confirmPassword" /></td>
			</tr>
			<tr>
				<td><dsp:input value="Submit" type="submit"
						bean="/com/sample/handler/UserHandler.userRegistration"></dsp:input></td>
				<td><input type="reset" value="reset"></td>
			</tr>
		</table>
	</dsp:form>
</body>
	</html>
</dsp:page>