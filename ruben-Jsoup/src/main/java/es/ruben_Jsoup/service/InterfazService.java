/*******************************************************************************
 * Copyright (c) 2017, - All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential
 *
 * Contributors: <a href="mailto:ruben.merino@altia.es">Rubén Merino</a>
 *******************************************************************************/
package es.ruben_Jsoup.service;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import es.ruben_Jsoup.arq.JsoupConnectionPool;
import es.ruben_Jsoup.view.FrameHTML;
import es.ruben_Jsoup.view.FrameInicio;
import es.ruben_Jsoup.view.FrameMundo;
import es.ruben_Jsoup.view.FrameResultados;
import es.ruben_Jsoup.view.FrameTwitter;
import es.ruben_Jsoup.view.FrameTwitterAdvance;
import es.ruben_Jsoup.view.FrameTwitterChose;

/**
 * TODO JAVADOC InterfazService
 *
 * @version 1.0.0
 * @author ruben.merino (ver. 1.0.0)
 */
public class InterfazService implements ActionListener {

    /** fi */
    public FrameInicio fi;
    /** fm */
    public FrameMundo fm;
    /** fh */
    public FrameHTML fh;
    /** fr */
    public FrameResultados fr;

    /** tc */
    public FrameTwitterChose tc;

    /** ft */
    public FrameTwitter ft;

    /** fta */
    public FrameTwitterAdvance fta;

    /**
     * Constructor
     */
    public InterfazService() {

        fi = new FrameInicio();
        fi.b1.addActionListener(this);
        fi.b2.addActionListener(this);
        fi.b3.addActionListener(this);
        fi.b4.addActionListener(this);
        fi.setBounds(300, 100, 150, 250);
        fi.setPreferredSize(new Dimension(950, 600));
        fi.pack();

        fm = new FrameMundo();
        fm.b1.addActionListener(this);
        fm.b2.addActionListener(this);
        fm.b3.addActionListener(this);
        fm.setBounds(600, 200, 300, 500);

        fh = new FrameHTML();
        fh.b1.addActionListener(this);
        fh.b2.addActionListener(this);
        fh.b3.addActionListener(this);
        fh.setBounds(600, 200, 300, 500);

        fr = new FrameResultados();
        fr.b1.addActionListener(this);
        fr.b2.addActionListener(this);
        fr.b3.addActionListener(this);
        fr.b4.addActionListener(this);
        fr.b5.addActionListener(this);
        fr.setBounds(300, 100, 150, 250);
        fr.setPreferredSize(new Dimension(700, 520));
        fr.pack();

        tc = new FrameTwitterChose();
        tc.b1.addActionListener(this);
        tc.b2.addActionListener(this);
        tc.b3.addActionListener(this);
        tc.b4.addActionListener(this);
        tc.b5.addActionListener(this);
        tc.setBounds(300, 100, 150, 250);
        tc.setPreferredSize(new Dimension(700, 520));
        tc.pack();

        ft = new FrameTwitter();
        ft.b1.addActionListener(this);
        ft.b2.addActionListener(this);
        ft.setBounds(500, 150, 250, 450);
        ft.setPreferredSize(new Dimension(450, 500));
        ft.pack();

        fta = new FrameTwitterAdvance();
        fta.b1.addActionListener(this);
        fta.b2.addActionListener(this);
        fta.setBounds(300, 100, 200, 400);
        fta.setPreferredSize(new Dimension(850, 600));
        fta.pack();

    }

    /**
     * TODO JAVADOC METODO
     */
    public void mostrarInicio() {
        hide();
        fi.setVisible(true);

    }

    /**
     * TODO JAVADOC METODO
     */
    public void mostrarMundo() {

        hide();
        fm.setVisible(true);
        fm.b3.setVisible(false);
        fm.b2.setVisible(true);
    }

    public void mostrarHTML() {

        hide();
        fh.setVisible(true);
        fh.b3.setVisible(false);
        fh.b2.setVisible(true);
    }

    /**
     * TODO JAVADOC METODO
     */
    public void mostrarPais() {

        hide();
        fm.setVisible(true);
        fm.b3.setVisible(true);
        fm.b2.setVisible(false);
    }

    /**
     * TODO JAVADOC METODO
     *
     *
     */
    public void mostrarResultadoMundo() {

        hide();
        fr.campo1.setText("Esta operacion puede tardar unos minutos, introduce la ruta (se va a crear un fichero)");
        fr.setVisible(true);
        fr.b3.setVisible(false);
        fr.b4.setVisible(false);
        fr.b2.setVisible(true);
        fr.b5.setVisible(false);
    }

    /**
     * TODO JAVADOC METODO
     *
     *
     */
    public void mostrarResultadoPais() {

        hide();
        fr.campo1.setText("Esta operacion puede tardar unos minutos, introduce la ruta (se va a crear un fichero)");
        fr.setVisible(true);
        fr.b3.setVisible(false);
        fr.b4.setVisible(true);
        fr.b2.setVisible(false);
        fr.b5.setVisible(false);
    }

    /**
     * TODO JAVADOC METODO
     */
    public void mostrarResultadoTwitter() {

        hide();

        fr.setVisible(true);
        fr.b3.setVisible(true);
        fr.b4.setVisible(false);
        fr.b2.setVisible(false);
        fr.b5.setVisible(false);
    }

    /**
     * TODO JAVADOC METODO
     */
    public void mostrarResultadoTwitterAdvance() {

        hide();

        fr.setVisible(true);
        fr.b2.setVisible(false);
        fr.b3.setVisible(false);
        fr.b4.setVisible(false);
        fr.b5.setVisible(true);
    }

    /**
     * TODO JAVADOC METODO
     */
    public void mostrarTwitterChose() {

        hide();
        tc.setVisible(true);

    }

    /**
     * TODO JAVADOC METODO
     */
    public void mostrarTwitterAdvanceSearch() {

        hide();
        fr.campo1.setText("1: Esta operacion puede tardar unos minutos, introduce la ruta (se va a crear un fichero)");
        fta.setVisible(true);

    }

    /**
     * TODO JAVADOC METODO
     */
    public void mostrarTwitterAccount() {

        hide();
        fr.campo1.setText("2: Esta operacion puede tardar unos minutos, introduce la ruta (se va a crear un fichero)");
        ft.setVisible(true);
        ft.jlabel.setText("Name Account (without @)");
        ft.jlabel.setVisible(true);
        ft.taccount.setVisible(true);
    }

    /**
     * TODO JAVADOC METODO
     */
    public void mostrarTwitterAccountDate() {

        hide();
        ft.setVisible(true);
        fr.campo1.setText("3: Esta operacion puede tardar unos minutos, introduce la ruta (se va a crear un fichero)");
        tweetDate();
        ft.jlabel.setText("Name Account (without @)");
        ft.jlabel.setVisible(true);
        ft.taccount.setVisible(true);

    }

    /**
     * TODO JAVADOC METODO
     */
    public void mostrarTwitterWordtDate() {

        hide();
        ft.setVisible(true);
        tweetDate();
        ft.jlabel.setText("Word to search on tweets (use spacefar for each word)");
        fr.campo1.setText("4: Esta operacion puede tardar unos minutos, introduce la ruta (se va a crear un fichero)");
        ft.jlabel.setVisible(true);
        ft.taccount.setVisible(true);

    }

    /**
     * TODO JAVADOC METODO
     */
    public void mostrarTwitterWordstDate() {

        hide();
        ft.setVisible(true);
        tweetDate();
        ft.jlabel.setText("Words to search on tweets And Accounts (use spacefar for each word)");
        fr.campo1.setText("5: Esta operacion puede tardar unos minutos, introduce la ruta (se va a crear un fichero)");
        ft.jlabel.setVisible(true);
        ft.taccount.setVisible(true);

    }

    /**
     * TODO JAVADOC METODO
     */
    public void tweetDate() {
        ft.jfecha1.setVisible(true);
        ft.jfecha2.setVisible(true);
        ft.lfecha1.setVisible(true);
        ft.lfecha2.setVisible(true);
    }

    /**
     * TODO JAVADOC METODO
     */
    public void hide() {

        fi.setVisible(false);
        fr.setVisible(false);
        fm.setVisible(false);
        tc.setVisible(false);
        ft.setVisible(false);
        ft.jlabel.setVisible(false);
        ft.taccount.setVisible(false);
        ft.jfecha1.setVisible(false);
        ft.jfecha2.setVisible(false);
        ft.lfecha1.setVisible(false);
        ft.lfecha2.setVisible(false);
        fta.setVisible(false);

    }

    /**
     * TODO JAVADOC METODO
     *
     * @return temporalidad Mañana tarde o noche dentro de los periodicos
     * @throws ServiceException
     */
    public String getTemporalidad() throws ServiceException {
        String temporalidad = JsoupConnectionPool.MUNDOTIRADA[0];
        try {
            final int cual = new Integer(fm.ttanda.getText());
            switch (cual) {
            case 1:
                temporalidad = JsoupConnectionPool.MUNDOTIRADA[1];
                break;
            case 2:
                temporalidad = JsoupConnectionPool.MUNDOTIRADA[2];
                break;

            }
        } catch (final Exception e) {
            throw new ServiceException(e.getMessage(), e);
        }

        return temporalidad;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        // TODO Auto-generated method stub
        final JButton button = (JButton) e.getSource();
        final String n = button.getName();
        if (n == "mundo") {
            mostrarMundo();
        } else if (n == "volver") {
            mostrarInicio();
        } else if (n == "consultar") {

            mostrarResultadoMundo();

        } else if (n == "empezarMundo") {

            try {
                final String temporalidad = getTemporalidad();
                MundoService.ConsultarJsoup(fm.tfecha1.getText(), fm.tpalabras.getText().split(","), temporalidad, fr.jt.getText());
                fr.campo1.setText("finalizado");
            } catch (final ServiceException ex) {
                // TODO Auto-generated catch block
                System.out.println(ex.getMessage());

                ex.printStackTrace();
            } catch (final Exception ex) {
                fr.campo1.setText("error con el documento");
            }
        } else if (n == "twitter") {
            mostrarTwitterChose();
        } else if (n == "empezarTwitter") {

            try {
                final String splited = fr.campo1.getText().split(":")[0];

                SeleniumService.SearchTwitterName(ft.taccount.getText(), ft.jfecha1.getText(), ft.jfecha2.getText(), fr.jt.getText(), splited);

            } catch (final ServiceException ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }

        } else if (n == "consultarTwitter") {

            mostrarResultadoTwitter();
        } else if (n == "twitterName") {
            mostrarTwitterAccount();
        } else if (n == "twitterNameDate") {
            mostrarTwitterAccountDate();
        } else if (n == "twitterWordDate") {
            mostrarTwitterWordtDate();
        } else if (n == "twitterWordsDate") {
            mostrarTwitterWordstDate();
        } else if (n == "consultarPais") {
            mostrarResultadoPais();
        } else if (n == "empezarPais") {

            try {
                final String temporalidad = getTemporalidad();
                PaisService.ConsultarJsoup(fm.tfecha1.getText(), fm.tpalabras.getText().split(","), temporalidad, fr.jt.getText());
                fr.campo1.setText("finalizado");
            } catch (final ServiceException ex) {
                // TODO Auto-generated catch block
                System.out.println(ex.getMessage());

                ex.printStackTrace();
            } catch (final Exception ex) {
                fr.campo1.setText("error con el documento");
            }
        } else if (n == "pais") {
            mostrarPais();
        } else if (n == "twitterAdvance") {
            mostrarTwitterAdvanceSearch();
        } else if (n == "consultarTwitterAdvance") {
            mostrarResultadoTwitterAdvance();
        } else if (n == "empezarTwitterAdvance") {

            try {
                SeleniumService.SearchTwitterName(fta.jwords.getText(), fta.jwordsMaybe.getText(), fta.jnoWord.getText(), fta.jhastag.getText(), fta.jaccountFrom.getText(),
                        fta.jaccountTo.getText(), fta.jmention.getText(), fta.jnear.getText(), fta.jsince.getText(), fta.jfrom.getText(), fr.jt.getText(), "1",
                        fta.jvueltas.getText());
            } catch (final ServiceException ex) {
                // TODO Auto-generated catch block
                ex.printStackTrace();
            }

        } else if (n == "html") {
            mostrarHTML();
        }

    }

}
