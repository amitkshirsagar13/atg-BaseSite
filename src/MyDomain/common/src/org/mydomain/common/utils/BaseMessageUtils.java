package org.mydomain.common.utils;

import java.text.MessageFormat;
import java.util.Locale;

import javax.transaction.TransactionManager;

import atg.dtm.TransactionDemarcation;
import atg.nucleus.GenericService;
import atg.repository.Repository;
import atg.repository.RepositoryItem;
import atg.repository.RepositoryView;
import atg.repository.rql.RqlStatement;

/**
 * The Class RepositoryMessageUtils implements IMessageUtils.
 * RepositoryMessageUtils gets messages from message repository.
 * 
 */
public class BaseMessageUtils extends GenericService implements IMessageUtils {

	/** The Constant EMPTY. */
	private static final String EMPTY = "";

	/** The Constant QUERY_KEY_MESSAGE. */
	private static final String QUERY_MESSAGE_KEY = "message_key = ?0";

	/** The message repository. */
	private Repository mMessageRepository;

	/**
	 * Gets the message repository.
	 *
	 * @return the message repository
	 */
	public Repository getMessageRepository() {
		return mMessageRepository;
	}

	/**
	 * Sets the message repository.
	 *
	 * @param messageRepository
	 *            the new message repository
	 */
	public void setMessageRepository(Repository messageRepository) {
		mMessageRepository = messageRepository;
	}

	/**
	 * Gets the bundle. Now it returns message repository.
	 * 
	 * @see vsg.message.IMessageUtils#getBundle(java.lang.String,
	 *      java.util.Locale)
	 *
	 * @param pBaseName
	 *            the base name
	 * @param pLocale
	 *            the locale
	 * @return the message repository.
	 */
	@Override
	public Object getBundle(final String pBaseName, final Locale pLocale) {
		return getMessageRepository();
	}

	/** The transaction manager. */
	private TransactionManager mTransactionManager;

	/**
	 * Sets the transaction manager.
	 *
	 * @param pTransactionManager
	 *            the new transaction manager
	 */
	public void setTransactionManager(TransactionManager pTransactionManager) {
		mTransactionManager = pTransactionManager;
	}

	/**
	 * Get TransactionManager.
	 * 
	 * @return TransactionManager.
	 */
	protected TransactionManager getTransactionManager() {
		return mTransactionManager;
	}

	/**
	 * Gets the exact key matched message.
	 * 
	 * @see vsg.message.IMessageUtils#getKeyMessage(java.lang.String)
	 *
	 * @param pLookUpKey
	 *            the look up key
	 * @return the key message
	 */
	@Override
	public String getMessage(final String pLookUpKey) {
		return getMessage(pLookUpKey, null);
	}

	/**
	 * Gets the exact key matched message.
	 * 
	 * @see vsg.message.IMessageUtils#getKeyMessage(java.lang.String,
	 *      java.util.Locale)
	 *
	 * @param pLookUpKey
	 *            the look up key
	 * @param pLocale
	 *            the locale
	 * @return the key message
	 */
	@Override
	public String getMessage(final String pLookUpKey, final Locale pLocale) {
		return EMPTY.equals(pLookUpKey) ? EMPTY : getMessageText(pLookUpKey);
	}

	/**
	 * Gets the formatted exact key matched message.
	 * 
	 * @see vsg.message.IMessageUtils#getFormattedKeyMessage(java.lang.String,
	 *      java.util.Locale, java.lang.Object[])
	 *
	 * @param pLookUpKey
	 *            the look up key
	 * @param pLocale
	 *            the locale
	 * @param pParams
	 *            the params
	 * @return the formatted key message
	 */
	@Override
	public String getFormattedMessage(final String pLookUpKey, final Locale pLocale, final Object[] pParams) {
		return (EMPTY.equals(pLookUpKey)) ? EMPTY : format(getMessageText(pLookUpKey), pParams);
	}

	/**
	 * Gets the key message text.
	 *
	 * @param pLookUpKey
	 *            the look up key
	 * @return the key message text
	 */
	private String getMessageText(final String pLookUpKey) {
		String result = pLookUpKey;
		TransactionDemarcation td = null;
		try {
			td = new TransactionDemarcation();
			td.begin(getTransactionManager(), TransactionDemarcation.REQUIRES_NEW);
			final RepositoryView view = mMessageRepository.getView("userMessage");
			final RqlStatement statement = RqlStatement.parseRqlStatement(QUERY_MESSAGE_KEY);
			vlogDebug("Message Repository query: message_key = {0}", pLookUpKey);
			final RepositoryItem[] items = statement.executeQuery(view, new Object[] { pLookUpKey });
			if (null != items && 0 < items.length) {
				result = (String) items[0].getPropertyValue("message");
				vlogDebug("Message Repository query result: {0}", result);
			} else {
				vlogDebug("Message Repository query result empty.");
			}
		} catch (Exception e) {
			vlogError(e, "Repository error occurs.");
		} finally {
			if (null != td) {
				try {
					td.end(false);
				} catch (Exception e) {
				}
			}
		}
		return result;
	}

	/**
	 * Creates a MessageFormat with the given pattern and uses it to format the
	 * given arguments.
	 *
	 * @param pMessage
	 *            the message
	 * @param pParams
	 *            the params
	 * @return the string
	 */
	private String format(final String pMessage, final Object[] pParams) {
		return MessageFormat.format(pMessage, pParams);
	}

}
