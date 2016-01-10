package com.sample.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.mydomain.common.utils.IMessageUtils;

import atg.commerce.order.CommerceItem;
import atg.commerce.order.purchase.CartModifierFormHandler;
import atg.droplet.DropletException;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.userprofiling.Profile;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName BaseSite
 * Creation date: Jan 7, 2016
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
public class BaseCartModifierFormHandler extends CartModifierFormHandler {
	/**
	 * profile
	 */
	private Profile mUserProfile;
	/**
	 * The response details.
	 */
	private String mResponseDetails = null;

	private String mRemovalCommerceItem;
	private IMessageUtils mMessageUtils;

	@Override
	public boolean handleRemoveItemFromOrder(DynamoHttpServletRequest pArg0, DynamoHttpServletResponse pArg1)
			throws IOException, ServletException {
		logInfo("Remove Items: " + getRemovalCommerceItem());
		String[] pRemovalCommerceIds = { getRemovalCommerceItem() };
		boolean foundInCart = false;
		for (CommerceItem itemId : (List<CommerceItem>) getOrder().getCommerceItems()) {
			if (itemId.getId().equalsIgnoreCase(getRemovalCommerceItem())) {
				foundInCart = true;
				break;
			}
		}
		if (foundInCart) {
			setRemovalCommerceIds(pRemovalCommerceIds);
		} else {
			addFormException(new DropletException(getMessageUtils().getMessage("GENERAL_DEBUG")));
		}
		for (CommerceItem commerceItem : (List<CommerceItem>) getOrder().getCommerceItems()) {
			logInfo(commerceItem.getId() + "|" + commerceItem.getCatalogId() + "|" + getProductId());
		}
		return super.handleRemoveItemFromOrder(pArg0, pArg1);

	}

	@Override
	public boolean handleRemoveAndAddItemToOrder(DynamoHttpServletRequest pRequest, DynamoHttpServletResponse pResponse)
			throws ServletException, IOException {
		// getOrder().removeAllCommerceItems();
		logInfo("Add Items: " + getProductIds() + " || " + getCatalogRefIds() + "++" + getQuantity());
		super.handleRemoveAndAddItemToOrder(pRequest, pResponse);
		for (CommerceItem commerceItem : (List<CommerceItem>) getOrder().getCommerceItems()) {
			logInfo(commerceItem.getId() + "|" + commerceItem.getCatalogId() + "|" + getProductId() + "||"
					+ commerceItem.getAuxiliaryData().getCatalogRef());
		}
		return checkFormRedirect(null, null, pRequest, pResponse);
	}

	/**
	 * @return the userProfile
	 */
	public Profile getUserProfile() {
		return mUserProfile;
	}

	/**
	 * @param userProfile
	 *            the userProfile to set
	 */
	public void setUserProfile(Profile userProfile) {
		mUserProfile = userProfile;
	}

	/**
	 * @return the responseDetails
	 */
	public String getResponseDetails() {
		return mResponseDetails;
	}

	/**
	 * @param responseDetails
	 *            the responseDetails to set
	 */
	public void setResponseDetails(String responseDetails) {
		mResponseDetails = responseDetails;
	}

	/**
	 * @return the removalCommerceItem
	 */
	public String getRemovalCommerceItem() {
		return mRemovalCommerceItem;
	}

	/**
	 * @param removalCommerceItem
	 *            the removalCommerceItem to set
	 */
	public void setRemovalCommerceItem(String removalCommerceItem) {
		mRemovalCommerceItem = removalCommerceItem;
	}

	/**
	 * @return the messageUtils
	 */
	public IMessageUtils getMessageUtils() {
		return mMessageUtils;
	}

	/**
	 * @param messageUtils
	 *            the messageUtils to set
	 */
	public void setMessageUtils(IMessageUtils messageUtils) {
		mMessageUtils = messageUtils;
	}

}
