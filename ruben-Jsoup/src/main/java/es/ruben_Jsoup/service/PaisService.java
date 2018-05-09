/*******************************************************************************
 * Copyright (c) 2017, - All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential
 *
 * Contributors: <a href="mailto:ruben.merino@altia.es">Rubén Merino</a>
 *******************************************************************************/
package es.ruben_Jsoup.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import es.ruben_Jsoup.arq.ConnectionException;
import es.ruben_Jsoup.arq.JsoupConnectionPool;

/**
 * TODO JAVADOC PaisService
 *
 * @version 1.0.0
 * @author ruben.merino (ver. 1.0.0)
 */
public class PaisService {

    /** DAY_PREFIX */
    final static String DAY_PREFIX = "0";

    /**
     * TODO JAVADOC METODO
     *
     * @param año
     * @param args
     * @param temporalidad
     * @param ruta
     * @throws ServiceException
     */
    public static void ConsultarJsoup(final String año, final String[] args, final String temporalidad, final String ruta) throws ServiceException {

        Document doc;
        Document docNoticia;
        Integer maxdia;
        final StringBuffer buffer = new StringBuffer("");
        buffer.append("elPais");
        buffer.append(args[0]);
        buffer.append(temporalidad.split("/")[1]);
        buffer.append(".txt");

        final File fichero = new File(ruta, buffer.toString());
        System.out.println(buffer.toString());
        FileOutputStream fo = null;
        PrintWriter out = null;
        try {
            fo = new FileOutputStream(fichero);

            out = new PrintWriter(fo);

            for (int mes = 1; mes < 12; mes++) {
                switch (mes) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:

                    maxdia = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    maxdia = 30;
                    break;
                default:
                    maxdia = 28;
                }

                for (int dia = 1; dia < maxdia; dia++) {
                    final String diaFin = (dia < 10) ? DAY_PREFIX.concat(Integer.toString(dia)) : Integer.toString(dia);
                    final String mesFin = (mes < 10) ? DAY_PREFIX.concat(Integer.toString(mes)) : Integer.toString(mes);

                    doc = JsoupConnectionPool.getDocumentPais(año, mesFin, diaFin, temporalidad);

                    for (final Element c : doc.getElementsByTag("a")) {
                        boolean mostrar = false;
                        for (final String str : args) {
                            if (c.text().contains(str)) {
                                mostrar = true;
                            }
                        }
                        if (mostrar) {
                            final StringBuffer sb = new StringBuffer("");
                            sb.append(diaFin);
                            sb.append("/");
                            sb.append(mesFin);
                            sb.append("/");
                            sb.append(año);
                            sb.append("@");
                            sb.append(c.getElementsByTag("a").text());

                            sb.append("|");
                            final String enlace = c.getElementsByTag("a").attr("href");
                            System.out.println(enlace);
                            if (enlace.contains("elpais.com")) {
                                docNoticia = JsoupConnectionPool.getDocument(enlace);

                                for (final Element cuerpo : docNoticia.getElementsByClass("articulo-cuerpo")) {
                                    for (final Element c2 : cuerpo.getElementsByTag("p")) {
                                        sb.append(c2.text());
                                    }

                                }

                            }

                            sb.append("\n");

                            out.println(sb.toString());

                            System.out.println(sb.toString());
                        }
                    }

                }
            }
        } catch (final ConnectionException ex) {

            throw new ServiceException(ex.getMessage(), ex);
        } catch (final FileNotFoundException ex1) {
            // TODO Auto-generated catch block
            throw new ServiceException(ex1.getMessage(), ex1);
        } finally {
            out.flush();
            try {
                out.close();
            } catch (final Exception ex) {
                // TODO Auto-generated catch block
                throw new ServiceException(ex.getMessage(), ex);
            }
            try {
                fo.close();
            } catch (final IOException ex) {
                // TODO Auto-generated catch block
                throw new ServiceException(ex.getMessage(), ex);
            }

        }
    }
}
