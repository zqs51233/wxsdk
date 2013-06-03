package com.wxsdk.bean;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;


public abstract class BaseObject implements Serializable {

	private static final long serialVersionUID = 9086260249685856820L;


	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
