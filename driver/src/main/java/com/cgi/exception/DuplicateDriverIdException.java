package com.cgi.exception;

public class DuplicateDriverIdException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DuplicateDriverIdException (String msg) {
		super(msg);
	}

}
