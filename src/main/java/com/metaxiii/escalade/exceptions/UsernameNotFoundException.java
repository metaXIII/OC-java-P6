package com.metaxiii.escalade.exceptions;

public class UsernameNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1364692247984402321L;

    public UsernameNotFoundException() {
        super();
    }

    public UsernameNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UsernameNotFoundException(final String message) {
        super(message);
    }

    public UsernameNotFoundException(final Throwable cause) {
        super(cause);
    }
}
