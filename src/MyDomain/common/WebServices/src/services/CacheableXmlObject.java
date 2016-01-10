package services;

import java.nio.charset.Charset;

import org.apache.xmlbeans.XmlObject;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class CacheableXmlObject {

	/** The constant MIN_HASH_BITS. */
	private static final int MIN_HASH_BITS = 64;

	/** The constant DEFAULT_CHARSET. */
	private static final Charset DEFAULT_CHARSET = Charsets.UTF_8;

	/** The xml object. */
	private XmlObject mXmlObject;

	/** The hash code. */
	private int mHashCode;

	/**
	 * Instantiates a new cacheable xml object.
	 * 
	 * @param pXmlObject
	 *            the xml object
	 */
	public CacheableXmlObject(XmlObject pXmlObject) {
		super();
		mXmlObject = pXmlObject;
		mHashCode = hash(pXmlObject);
	}

	/**
	 * Hash code.
	 * 
	 * @return the int
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return mHashCode;
	}

	/**
	 * Equals.
	 * 
	 * @param pObj
	 *            the obj
	 * @return true, if successful
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object pObj) {
		if (pObj instanceof CacheableXmlObject) {
			return mHashCode == ((CacheableXmlObject) pObj).hashCode();
		} else if (pObj instanceof XmlObject) {
			return mHashCode == hash((XmlObject) pObj);
		}
		return false;
	}

	/**
	 * Hash.
	 * 
	 * @param pXmlObject
	 *            the xml object
	 * @return the hash code
	 */
	private static int hash(XmlObject pXmlObject) {
		return Hashing.goodFastHash(MIN_HASH_BITS).newHasher().putString(pXmlObject.xmlText(), DEFAULT_CHARSET).hash()
				.asInt();
	}

	/**
	 * Gets the xml object.
	 * 
	 * @return the xml object
	 */
	public XmlObject getXmlObject() {
		return mXmlObject;
	}

}
