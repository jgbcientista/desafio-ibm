package br.com.ibm.api.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    /**
	 * ResourceNotFoundException: Lanca excecao
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
        super(message);
    }
}
