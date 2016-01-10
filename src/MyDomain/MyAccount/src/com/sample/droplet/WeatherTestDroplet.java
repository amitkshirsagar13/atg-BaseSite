package com.sample.droplet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;

import com.sample.ui.bean.test.MyAccountTest;
import com.sample.ui.bean.test.TestDemo;

import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.servlet.DynamoServlet;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName BaseSite
 * Creation date: Sep 21, 2015
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
public class WeatherTestDroplet extends DynamoServlet {

	@Override
	public void service(DynamoHttpServletRequest pRequest, DynamoHttpServletResponse pResponse)
			throws ServletException, IOException {

		logInfo(pRequest.getParameter("zipCode"));
		testDemo.setName(pRequest.getParameter("name"));
		testDemo.setAge(pRequest.getParameter("age"));
		testDemo.setRole(pRequest.getParameter("role"));

		TestDemo testDemo1 = new TestDemo();
		testDemo1.setName("Amit");
		testDemo1.setAge("30");
		testDemo1.setRole("Admin");

		myAccountTest.setDemoMap(new HashMap<String, TestDemo>());
		myAccountTest.getDemoMap().put(testDemo.getName(), testDemo);
		myAccountTest.getDemoMap().put(testDemo1.getName(), testDemo1);

		pRequest.setParameter("myAccount", testDemo);
		pRequest.setParameter("myAccountHash", myAccountTest);
		pRequest.serviceParameter("output", pRequest, pResponse);
		return;
	}

	public TestDemo testDemo;
	public MyAccountTest myAccountTest;

	public MyAccountTest getMyAccountTest() {
		return myAccountTest;
	}

	public void setMyAccountTest(MyAccountTest myAccountTest) {
		this.myAccountTest = myAccountTest;
	}

	public TestDemo getTestDemo() {
		return testDemo;
	}

	public void setTestDemo(TestDemo testDemo) {
		this.testDemo = testDemo;
	}
}