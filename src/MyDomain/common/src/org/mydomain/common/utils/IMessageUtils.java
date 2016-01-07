package org.mydomain.common.utils;

import java.util.Locale;

public interface IMessageUtils {

	/**
	 * Gets the bundle.
	 *
	 * @param pBaseName
	 *            the base name
	 * @param pLocale
	 *            the locale
	 * @return the bundle
	 */
	Object getBundle(String pBaseName, Locale pLocale);

	/**
	 * Gets the message.
	 *
	 * @param pLookUpKey
	 *            the look up key
	 * @return the message
	 */
	String getMessage(String pLookUpKey);

	/**
	 * Gets the message.
	 *
	 * @param pLookUpKey
	 *            the look up key
	 * @param pLocale
	 *            the locale
	 * @return the message
	 */
	String getMessage(String pLookUpKey, Locale pLocale);

	/**
	 * Gets the formatted message.
	 *
	 * @param pLookUpKey
	 *            the look up key
	 * @param pLocale
	 *            the locale
	 * @param pParams
	 *            the params
	 * @return the formatted message
	 */
	String getFormattedMessage(String pLookUpKey, Locale pLocale, Object[] pParams);

}
