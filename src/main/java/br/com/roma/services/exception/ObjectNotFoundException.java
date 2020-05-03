package br.com.roma.services.exception;

public class ObjectNotFoundException extends RuntimeException {

	public ObjectNotFoundException(String msg, Object object ) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg,cause);
	}
	
	
}
