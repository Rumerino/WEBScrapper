/*******************************************************************************
 * Copyright (c) 2017, - All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential
 *
 * Contributors: <a href="mailto:ruben.merino@altia.es">Rubén Merino</a>
 *******************************************************************************/
package es.ruben_Jsoup.modelo;

import es.ruben_Jsoup.arq.model.es.ruben_Jsoup.arq.model.IModel;

/**
 * TODO JAVADOC NoticiaMundo
 *
 * @version 1.0.0
 * @author ruben.merino (ver. 1.0.0)
 */
public class NoticiaMundo extends DocumentoJsoup implements IModel<Long> {

    /** serialVersionUID */
    private static final long serialVersionUID = 7535514532953182204L;

    private Long id;
    private String fecha;
    private String titular;
    private String URL;
    private String noticia;

    /**
     * Constructor
     */
    public NoticiaMundo() {

    }

    /**
     * TODO JAVADOC METODO
     *
     * @return fecha
     */
    public String getFecha() {
        return this.fecha;
    }

    /**
     * TODO JAVADOC METODO
     *
     * @param fecha
     */
    public void setFecha(final String fecha) {
        this.fecha = fecha;
    }

    /**
     * TODO JAVADOC METODO
     *
     * @return titular noticia
     */
    public String getTitular() {
        return this.titular;
    }

    /**
     * TODO JAVADOC METODO
     *
     * @param titular
     */
    public void setTitular(final String titular) {
        this.titular = titular;
    }

    /**
     * TODO JAVADOC METODO
     *
     * @return url noticia
     */
    public String getURL() {
        return this.URL;
    }

    /**
     * TODO JAVADOC METODO
     *
     * @param uRL
     */
    public void setURL(final String uRL) {
        this.URL = uRL;
    }

    /**
     * TODO JAVADOC METODO
     *
     * @return cuerpo noticia
     */
    public String getNoticia() {
        return this.noticia;
    }

    /**
     * TODO JAVADOC METODO
     *
     * @param noticia
     */
    public void setNoticia(final String noticia) {
        this.noticia = noticia;
    }

    /**
     * {@inheritDoc}
     */
    public Long getPk() {

        return id;
    }

    /**
     * {@inheritDoc}
     */
    public void setPK(final Long pk) {

        id = pk;
    }

}
