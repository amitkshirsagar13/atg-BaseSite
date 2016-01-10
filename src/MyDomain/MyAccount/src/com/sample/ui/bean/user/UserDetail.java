package com.sample.ui.bean.user;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName BaseSite
 * Creation date: Sep 22, 2015
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public class UserDetail {

	private String mName;
	private String mAge;
	private String mRelation;

	public String getName() {
		return mName;
	}

	public void setName(String pName) {
		mName = pName;
	}

	public String getAge() {
		return mAge;
	}

	public void setAge(String pAge) {
		mAge = pAge;
	}

	public String getRelation() {
		return mRelation;
	}

	public void setRelation(String pRelation) {
		mRelation = pRelation;
	}

}
