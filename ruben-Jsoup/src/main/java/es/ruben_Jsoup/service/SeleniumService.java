/*******************************************************************************
 * Copyright (c) 2017, - All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential
 *
 * Contributors: <a href="mailto:ruben.merino@altia.es">Rubén Merino</a>
 *******************************************************************************/
package es.ruben_Jsoup.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;

/**
 * Search Google example.
 *
 * @author Rahul
 */
public class SeleniumService {
    /** driver */
    public static WebDriver driver;
    /** wait */
    public static Wait<WebDriver> wait;

    /** SEARCHNAME */
    public final static String[] SEARCHNAME = { "https://twitter.com/search?l=&q=from%3A", "&src=typd" };
    /** SEARCHNAMEDATE */
    public final static String[] SEARCHNAMEDATE = { "https://twitter.com/search?l=&q=from%3A", "%20since%3A", "%20until%3A", "&src=typd" };
    /** SEARCHWORDDATE */
    public final static String[] SEARCHWORDDATE = { "https://twitter.com/search?l=&q=", "%20since%3A", "%20until%3A", "&src=typd" };
    /** SEATCHNWORDDATE */
    public final static String[] SEATCHNWORDDATE = { "https://twitter.com/search?l=&q=", "%20OR%20", "%20since%3A", "%20until%3A", "&src=typd" };
    /** SEARCHADVANCE */
    public final static String[] SEARCHADVANCE = { "https://twitter.com/search?l=&q=", "%20", "OR", "%23", "from%3A", "to%3A", "%40", "near%3A", "%2C", "within%3A15mi&",
            "%20since%3A", "%20until%3A", "&src=typd" };
    // perro y mascota, gato o animal, no pez ni vaca, hastag animales o hastag
    // pruebas, de pruebas 1 o pruebas 2, a pruebas 1 o a pruebas 2, que
    // mencionen a 1 o a 2 , cerca de Ciudad, Comunidad, desde, hasta
    // https://twitter.com/search?l=&q=perro%20mascota%20gato%20OR%20animal%20-pez%20-vaca%20%23animales%20OR%20%23pruebas%20from%3Apruebadesde1%20OR%20from%3Apruebadesde2%20to%3Apruebapara1%20OR%20to%3Apruebapara2%20%40mencion1%20OR%20%40mencion2%20near%3A%22Madrid%2C%20Comunidad%20de%20Madrid%22%20within%3A15mi%20since%3A2017-04-03%20until%3A2017-04-06&src=typd

    private static String getBaseUrl(final String n, final String who, final String fecha1, final String fecha2) {

        System.out.println(n);
        final Integer compare = new Integer(n);

        final StringBuffer sb = new StringBuffer("");
        switch (compare) {
        case 2:

            sb.append(SEARCHNAME[0]);
            sb.append(who);
            sb.append(SEARCHNAME[1]);
            return sb.toString();

        case 3:

            sb.append(SEARCHNAMEDATE[0]);
            sb.append(who);
            sb.append(SEARCHNAMEDATE[1]);
            sb.append(fecha1);
            sb.append(SEARCHNAMEDATE[2]);
            sb.append(fecha2);
            sb.append(SEARCHNAMEDATE[3]);

            return sb.toString();

        case 4:
            // SEARCHWORDDATE[]
            sb.append(SEARCHWORDDATE[0]);
            sb.append(who);
            sb.append(SEARCHWORDDATE[1]);
            sb.append(fecha1);
            sb.append(SEARCHWORDDATE[2]);
            sb.append(fecha2);
            sb.append(SEARCHWORDDATE[3]);

            return sb.toString();

        case 5:
            // SEARCHWORDDATE[]
            final String[] palabras = who.split(" ");
            sb.append(SEATCHNWORDDATE[0]);
            sb.append(palabras[0]);
            for (int i = 1; i < palabras.length; i++) {
                sb.append(SEATCHNWORDDATE[1]);
                sb.append(palabras[i]);
            }

            sb.append(SEATCHNWORDDATE[2]);
            sb.append(fecha1);
            sb.append(SEATCHNWORDDATE[3]);
            sb.append(fecha2);
            sb.append(SEATCHNWORDDATE[4]);

            return sb.toString();
        }

        return "";
    }

    /**
     * TODO JAVADOC METODO
     *
     * @param word
     * @param optionalWord
     * @param notWord
     * @param hastag
     * @param from
     * @param to
     * @param mention
     * @param near
     * @param fecha1
     * @param fecha2
     * @param ruta
     * @return
     */
    private static String getBaseUrl(final String word, final String optionalWord, final String notWord, final String hastag, final String from, final String to,
            final String mention, final String near, final String fecha1, final String fecha2, final String ruta) {

        final StringBuffer sb = new StringBuffer("");
        sb.append(SEARCHADVANCE[0]);

        String[] auxiliares;
        boolean anterior = false;
        if (word.compareTo("") != 0) {
            auxiliares = word.split(" ");

            for (int i = 0; i < auxiliares.length; i++) {
                if (i == 0) {
                    anterior = true;
                    sb.append(auxiliares[i]);
                } else {
                    sb.append(SEARCHADVANCE[1]);
                    sb.append(auxiliares[i]);
                }

            }
        }

        if (optionalWord.compareTo("") != 0) {
            auxiliares = optionalWord.split(" ");

            for (int i = 0; i < auxiliares.length; i++) {
                if (i == 0) {
                    if (anterior) {
                        sb.append(SEARCHADVANCE[1]);
                        sb.append(auxiliares[i]);
                    } else {
                        sb.append(auxiliares[i]);
                        anterior = true;
                    }

                } else {
                    sb.append(SEARCHADVANCE[1]);
                    sb.append(SEARCHADVANCE[2]);
                    sb.append(SEARCHADVANCE[1]);
                    sb.append(auxiliares[i]);
                }

            }
        }

        if (notWord.compareTo("") != 0) {
            auxiliares = notWord.split(" ");

            for (int i = 0; i < auxiliares.length; i++) {
                if (i == 0) {
                    if (anterior) {
                        sb.append(SEARCHADVANCE[1]);
                        sb.append("-".concat(auxiliares[i]));
                    } else {
                        sb.append("-".concat(auxiliares[i]));
                        anterior = true;
                    }

                } else {
                    sb.append(SEARCHADVANCE[1]);
                    sb.append("-".concat(auxiliares[i]));
                }

            }
        }

        if (hastag.compareTo("") != 0) {
            auxiliares = hastag.split(" ");

            for (int i = 0; i < auxiliares.length; i++) {
                if (i == 0) {
                    sb.append(SEARCHADVANCE[1]);
                    sb.append(SEARCHADVANCE[3]);
                    sb.append(auxiliares[i]);
                    if (!anterior) {
                        anterior = true;
                    }

                } else {
                    sb.append(SEARCHADVANCE[1]);
                    sb.append(SEARCHADVANCE[2]);
                    sb.append(SEARCHADVANCE[1]);
                    sb.append(SEARCHADVANCE[3]);
                    sb.append(auxiliares[i]);
                }

            }
        }

        if (from.compareTo("") != 0) {
            auxiliares = from.split(" ");

            for (int i = 0; i < auxiliares.length; i++) {
                if (i == 0) {
                    if (anterior) {
                        sb.append(SEARCHADVANCE[1]);
                        sb.append(SEARCHADVANCE[4]);
                        sb.append(auxiliares[i]);
                    } else {
                        sb.append(SEARCHADVANCE[4]);
                        sb.append(auxiliares[i]);
                        anterior = true;
                    }

                } else {
                    sb.append(SEARCHADVANCE[1]);
                    sb.append(SEARCHADVANCE[2]);
                    sb.append(SEARCHADVANCE[1]);
                    sb.append(SEARCHADVANCE[4]);
                    sb.append(auxiliares[i]);
                }

            }
        }

        if (to.compareTo("") != 0) {
            auxiliares = to.split(" ");

            for (int i = 0; i < auxiliares.length; i++) {
                if (i == 0) {
                    if (anterior) {
                        sb.append(SEARCHADVANCE[1]);

                    } else {

                        anterior = true;
                    }
                    sb.append(SEARCHADVANCE[5]);
                    sb.append(auxiliares[i]);

                } else {
                    sb.append(SEARCHADVANCE[1]);
                    sb.append(SEARCHADVANCE[2]);
                    sb.append(SEARCHADVANCE[1]);
                    sb.append(SEARCHADVANCE[5]);
                    sb.append(auxiliares[i]);
                }

            }
        }

        if (mention.compareTo("") != 0) {
            auxiliares = mention.split(" ");

            for (int i = 0; i < auxiliares.length; i++) {
                if (i == 0) {
                    if (anterior) {
                        sb.append(SEARCHADVANCE[1]);

                    } else {

                        anterior = true;
                    }
                    sb.append(SEARCHADVANCE[6]);
                    sb.append(auxiliares[i]);

                } else {
                    sb.append(SEARCHADVANCE[1]);
                    sb.append(SEARCHADVANCE[2]);
                    sb.append(SEARCHADVANCE[1]);
                    sb.append(SEARCHADVANCE[6]);
                    sb.append(auxiliares[i]);
                }

            }
        }

        if (near.compareTo("") != 0) {
            sb.append(SEARCHADVANCE[1]);
            sb.append(SEARCHADVANCE[7]);
            sb.append("\"");
            sb.append(near);
            sb.append("\"");
            sb.append(SEARCHADVANCE[9]);
            // near%3A"France" within%3A15mi&

        }

        if (fecha1.compareTo("") != 0) {
            sb.append(SEARCHADVANCE[10]);

            sb.append(fecha1);

        }
        if (fecha2.compareTo("") != 0) {
            sb.append(SEARCHADVANCE[11]);
            sb.append(fecha2);
        }

        sb.append(SEARCHADVANCE[12]);

        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * TODO JAVADOC METODO
     *
     * @param who
     * @param fecha1
     * @param fecha2
     * @param ruta
     * @param query
     * @throws ServiceException
     */
    public static void SearchTwitterName(final String who, final String fecha1, final String fecha2, final String ruta, final String query) throws ServiceException {
        // declaration and instantiation of objects/variables

        final String baseUrl = getBaseUrl(query, who, fecha1, fecha2);
        try {
            driver.get(baseUrl);
        } catch (final Exception e) {
            driver = new FirefoxDriver();
            driver.get(baseUrl);
        }
        // launch Fire fox and direct it to the Base URL

        final JavascriptExecutor jse = (JavascriptExecutor) driver;

        boolean seguir = true;
        Integer contador = 0;
        while (seguir) {
            jse.executeScript("window.scrollBy(0,250)", "");

            contador++;
            if (contador > 10000) {
                seguir = false;
            }
        }

        try {
            Thread.sleep(3000);
        } catch (final InterruptedException ex) {
            // TODO Auto-generated catch block
            throw new ServiceException("an error occurried during the extraction", ex);
        }

        final List<String> listTweets = new ArrayList<String>();
        final List<String> listAccounts = new ArrayList<String>();
        final List<String> listDates = new ArrayList<String>();

        for (final WebElement e : driver.findElements(By.tagName("p"))) {

            listTweets.add(e.getText());

        }

        for (final WebElement e : driver.findElements(By.className("username"))) {

            listAccounts.add(e.getText());

        }

        for (final WebElement e : driver.findElements(By.className("_timestamp"))) {

            listDates.add(e.getText());

        }

        final String aux = "twitter" + who + ".txt";
        final File fichero = new File(ruta, aux);
        System.out.println(aux);
        FileOutputStream fo = null;

        PrintWriter out = null;
        try {
            fo = new FileOutputStream(fichero);

            out = new PrintWriter(fo);
            // OutputStream buffered fileinputstream
            // outputstream
            for (int i = 0; i < listTweets.size(); i++) {
                final StringBuffer sb = new StringBuffer("");
                try {
                    sb.append(listAccounts.get(i));
                    sb.append(";");
                } catch (final Exception e) {
                    sb.append("unkwon");
                    sb.append(";");
                }
                System.out.println(listTweets.get(i));
                sb.append(listTweets.get(i));
                sb.append(";");

                try {
                    sb.append(listDates.get(i));
                } catch (final Exception e) {
                    sb.append("noDate");
                    sb.append(";");
                }

                out.println(sb.toString());

            }
        } catch (final Exception e) {

            throw new ServiceException(e.getMessage(), e);
        } finally {
            out.flush();

            try {
                out.close();
            } catch (final Exception ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }
            try {
                fo.close();
            } catch (final IOException ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }
        }

        // close Fire fox
        driver.close();
    }

    /**
     * TODO JAVADOC METODO
     *
     * @param word
     * @param optionalWord
     * @param notWord
     * @param hastag
     * @param from
     * @param to
     * @param mention
     * @param near
     * @param fecha1
     * @param fecha2
     * @param ruta
     * @param query
     * @param vueltas
     * @throws ServiceException
     */
    public static void SearchTwitterName(final String word, final String optionalWord, final String notWord, final String hastag, final String from, final String to,
            final String mention, final String near, final String fecha1, final String fecha2, final String ruta, final String query, final String vueltas)
            throws ServiceException {
        // declaration and instantiation of objects/variables

        final String baseUrl = getBaseUrl(word, optionalWord, notWord, hastag, from, to, mention, near, fecha1, fecha2, ruta);
        try {
            driver.get(baseUrl);
        } catch (final Exception e) {
            driver = new FirefoxDriver();
            driver.get(baseUrl);
        }
        // launch Fire fox and direct it to the Base URL

        final JavascriptExecutor jse = (JavascriptExecutor) driver;

        boolean seguir = true;
        Integer contador = 0;
        Integer iteraciones;
        try {
            iteraciones = Integer.parseInt(vueltas);
        } catch (final Exception e) {
            iteraciones = 100;
        }
        while (seguir) {
            jse.executeScript("window.scrollBy(0,250)", "");

            contador++;
            if (contador > iteraciones) {
                seguir = false;
            }
        }

        try {
            Thread.sleep(3000);
        } catch (final InterruptedException ex) {
            // TODO Auto-generated catch block
            throw new ServiceException("an error occurried during the extraction", ex);
        }

        final List<String> listTweets = new ArrayList<String>();
        final List<String> listAccounts = new ArrayList<String>();
        final List<String> listDates = new ArrayList<String>();

        for (final WebElement e : driver.findElements(By.tagName("p"))) {

            listTweets.add(e.getText());

        }

        for (final WebElement e : driver.findElements(By.className("username"))) {

            listAccounts.add(e.getText());

        }

        for (final WebElement e : driver.findElements(By.className("_timestamp"))) {

            listDates.add(e.getText());

        }

        final String aux = "twitter" + word + ".txt";
        final File fichero = new File(ruta, aux);
        System.out.println(aux);
        FileOutputStream fo = null;

        PrintWriter out = null;
        try {
            fo = new FileOutputStream(fichero);

            out = new PrintWriter(fo);
            // OutputStream buffered fileinputstream
            // outputstream
            for (int i = 0; i < listTweets.size(); i++) {
                final StringBuffer sb = new StringBuffer("");
                try {
                    sb.append(listAccounts.get(i));
                    sb.append(";");
                } catch (final Exception e) {
                    sb.append("unkwon");
                    sb.append(";");
                }
                System.out.println(listTweets.get(i));
                sb.append(listTweets.get(i));
                sb.append(";");

                try {
                    sb.append(listDates.get(i));
                } catch (final Exception e) {
                    sb.append("noDate");
                    sb.append(";");
                }

                out.println(sb.toString());

            }
        } catch (final Exception e) {

            throw new ServiceException(e.getMessage(), e);
        } finally {
            out.flush();

            try {
                out.close();
            } catch (final Exception ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }
            try {
                fo.close();
            } catch (final IOException ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }
        }

        // close Fire fox
        driver.close();
    }

}
