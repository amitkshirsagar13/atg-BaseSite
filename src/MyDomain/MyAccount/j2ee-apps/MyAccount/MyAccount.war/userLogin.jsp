a<%@ taglib prefix="dsp" uri="http://www.atg.com/taglibs/daf/dspjspTaglib1_0"%>
<dsp:page>
	<dsp:importbean bean="/atg/userprofiling/ProfileFormHandler" />
	<dsp:importbean bean="/atg/userprofiling/ProfileErrorMessageForEach" />
	<dsp:importbean bean="/atg/dynamo/droplet/Switch" />
	<dsp:importbean bean="/atg/dynamo/droplet/ForEach" />
<html>
<head>
<title>Login Page</title>
</head>
<body>
	<h3>Login</h3>
	<dsp:form formid="loginForm" method="post">
		<dsp:input bean="ProfileFormHandler.createSuccessURL" type="hidden" value="userLoginResult.jsp" />
		<dsp:input bean="ProfileFormHandler.loginSuccessURL" type="hidden" value="userLoginResult.jsp" />

		<table>
			<tr>
				<td valign=middle align=right>User Name:</td>
				<td><dsp:input bean="ProfileFormHandler.value.login" maxsize="20" size="20" type="text"></dsp:input></td>
			</tr>
			<tr>
				<td valign=middle align=right>Password:</td>
				<td><dsp:input bean="ProfileFormHandler.value.password" maxsize="35" size="35" type="password"></dsp:input></td>
			</tr>
			<tr>
				<td align="right"><dsp:input value="Login" type="submit" bean="ProfileFormHandler.login"></dsp:input></td>
				<td><dsp:input value="Create" type="submit" bean="ProfileFormHandler.create"></dsp:input></td>
				<td><dsp:input value="Logout" type="submit" bean="ProfileFormHandler.logout"></dsp:input></td>
			</tr>
			<tr>
				<td><dsp:input value="LoginSpecial" type="submit" bean="ProfileFormHandler.login"></dsp:input></td>
				<td><dsp:input value="TestProfile" type="submit" bean="ProfileFormHandler.userProfile"></dsp:input></td>
				<td><dsp:input value="Blah" type="submit" bean="ProfileFormHandler.blahBlah"></dsp:input></td>
			</tr>
			<tr>
				<td><a href="userForgotPassword.jsp">Forgot Password</a></td>
				<td><a href="userRegistration.jsp">Registration</a></td>
			</tr>
		</table>
	</dsp:form>

	<hr />
	<dsp:droplet name="Switch">
		<dsp:param bean="ProfileFormHandler.formError" name="value" />
		<dsp:oparam name="true">
			<UL>
				<dsp:droplet name="ProfileErrorMessageForEach">
					<dsp:param bean="ProfileFormHandler.formExceptions" name="exceptions" />
					<dsp:oparam name="output">
						<LI><dsp:valueof param="message" />
					</dsp:oparam>
				</dsp:droplet>
			</UL>
		</dsp:oparam>
	</dsp:droplet>

	<hr />
</body>
	</html>
</dsp:page>