/*******************************************************************************
 * Copyright (c) 2017, - All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential
 *
 * Contributors: <a href="mailto:ruben.merino@altia.es">Rubén Merino</a>
 *******************************************************************************/
package es.ruben_Jsoup.arq;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * TODO JAVADOC JsoupConnectionPool
 *
 * @version 1.0.0
 * @author ruben.merino (ver. 1.0.0)
 */
public class JsoupConnectionPool {

    // url connection
    // selenium

    /** MUNDOTIRADA */
    public final static String MUNDOTIRADA[] = { "/m/", "/t/", "/n/" };
    /** MUNDO */
    public final static String MUNDO[] = { "http://www.elmundo.es/elmundo/hemeroteca/", "index.html" };
    /** PAIS */
    public final static String PAIS[] = { "http://elpais.com/hemeroteca/elpais/", "portada.html" };
    /** AÑO14 */
    public final static String AÑO14 = "2014";
    /** AÑO15 */
    public final static String AÑO15 = "2015";
    /** AÑO16 */
    public final static String AÑO16 = "2016";
    /** AÑO17 */
    public final static String AÑO17 = "2017";

    /**
     * TODO JAVADOC METODO
     *
     * @param url
     * @return a document with the url choosed
     * @throws ConnectionException
     */
    public static Document getDocument(final String url) throws ConnectionException {

        Document doc = null;

        try {
            doc = Jsoup.connect(url).get();
        } catch (final IOException ex) {
            // TODO Auto-generated catch block
            throw new ConnectionException("error al abrir la URL", ex);
        }

        return doc;
    }

    /**
     * TODO JAVADOC METODO
     *
     * @param año
     * @param mesFin
     * @param diaFin
     * @param tirada
     * @return Devuelve el documento abierto para recorrer con Jsoup
     * @throws ConnectionException
     */
    public static Document getDocumentMundo(final String año, final String mesFin, final String diaFin, final String tirada) throws ConnectionException {

        Document doc = null;

        final StringBuffer url = new StringBuffer();
        url.append(MUNDO[0]);
        url.append(año);
        url.append("/");
        url.append(mesFin);
        url.append("/");
        url.append(diaFin);
        url.append(tirada);
        url.append(MUNDO[1]);
        try {
            doc = Jsoup.connect(url.toString()).get();
        } catch (final IOException ex) {
            // TODO Auto-generated catch block
            throw new ConnectionException("error al abrir la URL del Mundo", ex);
        }

        return doc;
    }

    /**
     * TODO JAVADOC METODO
     *
     * @param año
     * @param mesFin
     * @param diaFin
     * @param tirada
     * @return Document jsoup pais
     * @throws ConnectionException
     */
    public static Document getDocumentPais(final String año, final String mesFin, final String diaFin, final String tirada) throws ConnectionException {

        Document doc = null;

        final StringBuffer url = new StringBuffer();
        url.append(PAIS[0]);
        url.append(año);
        url.append("/");
        url.append(mesFin);
        url.append("/");
        url.append(diaFin);
        url.append(tirada);
        url.append(PAIS[1]);
        try {
            doc = Jsoup.connect(url.toString()).get();
        } catch (final IOException ex) {
            // TODO Auto-generated catch block
            throw new ConnectionException("error al abrir la URL del Pais", ex);
        }

        return doc;
    }

}
