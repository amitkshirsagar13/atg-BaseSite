package com.sample.handler;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * @projectName MyAccount
 * Creation date: Apr 17, 2015
 * @author Amit Kshirsagar
 * @version 1.0
 * @since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.transaction.TransactionManager;

import atg.dtm.TransactionDemarcation;
import atg.dtm.TransactionDemarcationException;
import atg.repository.Query;
import atg.repository.QueryBuilder;
import atg.repository.QueryExpression;
import atg.repository.Repository;
import atg.repository.RepositoryItem;
import atg.repository.RepositoryItemDescriptor;
import atg.repository.RepositoryView;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.servlet.ServletUtil;
import atg.userprofiling.ProfileFormHandler;

public class LoginProfileFormHandler extends ProfileFormHandler {

	@Override
	public boolean beforeSet(DynamoHttpServletRequest request, DynamoHttpServletResponse response) {
		logInfo("started work in beforeSet...");
		return true;
	}

	@Override
	public boolean afterSet(DynamoHttpServletRequest request, DynamoHttpServletResponse response) {
		logInfo("started work in afterSet...");
		return true;
	}

	@Override
	public void beforeGet(DynamoHttpServletRequest request, DynamoHttpServletResponse response) {
		logInfo("started work in beforeGet...");
	}

	@Override
	public void afterGet(DynamoHttpServletRequest request, DynamoHttpServletResponse response) {
		logInfo("started work in afterGet...");
	}

	@Override
	public boolean handleLogin(DynamoHttpServletRequest pRequest, DynamoHttpServletResponse pResponse)
			throws IOException, ServletException {
		logInfo("started work in handleLogin...");
		return super.handleLogin(pRequest, pResponse);
	}

	@Override
	public boolean handleCreate(DynamoHttpServletRequest pRequest, DynamoHttpServletResponse pResponse)
			throws IOException, ServletException {
		logInfo("started work in handleCreate...");
		boolean createdSuccessfully = false;
		final TransactionManager tManager = getTransactionManager();
		final TransactionDemarcation tDemarcation = getTransactionDemarcation();
		try {
			createdSuccessfully = super.handleCreate(pRequest, pResponse);
		} catch (ServletException e) {
			throw new ServletException(e);
		} finally {
			try {
				if (tManager != null) {
					tDemarcation.end();
				}
			} catch (TransactionDemarcationException e) {

			}
		}
		return createdSuccessfully;
	}

	public boolean handleUserProfile(DynamoHttpServletRequest pRequest, DynamoHttpServletResponse pResponse)
			throws ServletException, IOException {

		logInfo("started work in handleUserProfile...");

		/**
		 * Here you have the UserName and Password from the login page from use
		 * Use it to validate and log him in the Site.
		 */

		logInfo((String) ServletUtil.getCurrentUserProfile().getPropertyValue("login"));

		if (ServletUtil.getCurrentUserProfile().getPropertyValue("login") == null) {
			return false;
		}
		try {

			Repository profileRepository = getProfileTools().getProfileRepository();

			RepositoryItemDescriptor userItem = profileRepository.getItemDescriptor("user");

			RepositoryView userView = userItem.getRepositoryView();

			QueryBuilder userQueryBuilder = userView.getQueryBuilder();

			QueryExpression firstName = userQueryBuilder.createPropertyQueryExpression("login");

			QueryExpression firstNameBill = userQueryBuilder
					.createConstantQueryExpression(ServletUtil.getCurrentUserProfile().getPropertyValue("login"));

			Query firstNameBillQuery = userQueryBuilder.createComparisonQuery(firstName, firstNameBill,
					QueryBuilder.EQUALS);

			Query[] queryPieces = { firstNameBillQuery };

			Query firstNameQuery = userQueryBuilder.createOrQuery(queryPieces);

			RepositoryItem[] results = userView.executeQuery(firstNameQuery);

			Query allUsersQuery = userQueryBuilder.createUnconstrainedQuery();

			RepositoryItem[] allUsers = userView.executeQuery(allUsersQuery);

			logInfo("Start rending profile details:");
			logInfo("User Count:" + results.length);
			logInfo("Total User Count:" + results.length + "/" + allUsers.length);
			for (int i = 0; i < results.length; i++) {
				logInfo("UserDetails:userRole:" + results[i].getPropertyValue("userRole"));

				for (RepositoryItem customer : (Set<RepositoryItem>) results[i].getPropertyValue("customers")) {
					logInfo("UserDetails:customerNumber:" + customer.getPropertyValue("customernumber"));
				}
				for (RepositoryItem phone : (Set<RepositoryItem>) results[i].getPropertyValue("phones")) {
					logInfo("UserDetails:phoneNumber:" + phone.getPropertyValue("phoneType") + "::"
							+ phone.getPropertyValue("phoneNumber"));
				}

			}

		} catch (Exception e) {

			logInfo("Exception while getting UserProfiles:" + e.getMessage());

			e.printStackTrace();
		}
		return true;
	};

	public boolean handleUserForgotPassword(DynamoHttpServletRequest request, DynamoHttpServletResponse response)
			throws IOException {

		logInfo("started work in handleUserForgotPassword...");

		/**
		 * Here you have the UserName from the forgetPassword page from use Use
		 * it to validate and process request to retrive password.
		 */

		response.sendRedirect("userForgotPasswordResult.jsp");

		return true;
	}

	public boolean handleUserRegistration(DynamoHttpServletRequest request, DynamoHttpServletResponse response)
			throws IOException {

		logInfo("started work in handleUserRegistration...");

		/**
		 * Here you have the UserDetails to create new User Registration
		 * account. Validate and process.
		 */

		response.sendRedirect("userRegistrationResult.jsp");

		return true;
	}

}
