/*******************************************************************************
 * Copyright (c) 2017, - All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential
 *
 * Contributors: <a href="mailto:ruben.merino@altia.es">Rubén Merino</a>
 *******************************************************************************/
package es.ruben_Jsoup.arq;

/**
 * TODO JAVADOC ConnectionException
 *
 * @version 1.0.0
 * @author ruben.merino (ver. 1.0.0)
 */
public class ConnectionException extends Exception {

    /** serialVersionUID */
    private static final long serialVersionUID = -1273573411079399629L;

    /**
     * Constructs a new exception with {@code null} as its detail message. The
     * cause is not initialized, and may subsequently be initialized by a call
     * to {@link #initCause}.
     */
    public ConnectionException() {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message. The cause
     * is not initialized, and may subsequently be initialized by a call to
     * {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later
     *            retrieval by the {@link #getMessage()} method.
     */
    public ConnectionException(final String message) {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and cause.
     * <p>
     * Note that the detail message associated with {@code cause} is <i>not</i>
     * automatically incorporated in this exception's detail message.
     *
     * @param message the detail message (which is saved for later retrieval by
     *            the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     *            {@link #getCause()} method). (A <tt>null</tt> value is
     *            permitted, and indicates that the cause is nonexistent or
     *            unknown.)
     * @since 1.4
     */
    public ConnectionException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
