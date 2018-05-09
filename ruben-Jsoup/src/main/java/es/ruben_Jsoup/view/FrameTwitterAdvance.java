/*******************************************************************************
 * Copyright (c) 2017, - All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential
 *
 * Contributors: <a href="mailto:ruben.merino@altia.es">Rubén Merino</a>
 *******************************************************************************/
package es.ruben_Jsoup.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * TODO JAVADOC FrameTwitterAdvance
 *
 * @version 1.0.0
 * @author ruben.merino (ver. 1.0.0)
 */
public class FrameTwitterAdvance extends JFrame {

    /** serialVersionUID */
    private static final long serialVersionUID = -4723252410680374292L;

    /** lwords */
    public JLabel lwords;
    /** jwords */
    public JTextField jwords;

    /** lfecha1 */
    public JLabel lfecha1;
    /** jsince */
    public JTextField jsince;

    /** lfecha2 */
    public JLabel lfecha2;
    /** jfrom */
    public JTextField jfrom;

    /** lwordsMaybe */
    public JLabel lwordsMaybe;
    /** jwordsMaybe */
    public JTextField jwordsMaybe;

    /** lnoWord */
    public JLabel lnoWord;
    /** jnoWord */
    public JTextField jnoWord;

    /** lhastag */
    public JLabel lhastag;
    /** jhastag */
    public JTextField jhastag;

    /** laccountFrom */
    public JLabel laccountFrom;
    /** jaccountFrom */
    public JTextField jaccountFrom;

    /** laccountTo */
    public JLabel laccountTo;
    /** jaccountTo */
    public JTextField jaccountTo;

    /** lmention */
    public JLabel lmention;
    /** jmention */
    public JTextField jmention;

    /** lnear */
    public JLabel lnear;
    /** jnear */
    public JTextField jnear;

    /** lnear */
    public JLabel lvueltas;
    /** jnear */
    public JTextField jvueltas;

    /** space */
    public JLabel space;
    /** space2 */
    public JLabel space2;

    /** b1 */
    public JButton b1;
    /** b2 */
    public JButton b2;

    /**
     * Constructor
     */
    public FrameTwitterAdvance() {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        final JPanel panel = new JPanel(new GridLayout(13, 0));

        b1 = new JButton("volver");
        b1.setName("volver");
        b1.setPreferredSize(new Dimension(40, 40));

        b2 = new JButton("consultar");
        b2.setName("consultarTwitterAdvance");
        b2.setPreferredSize(new Dimension(40, 40));

        lwords = new JLabel("Todas estas palabras deben aparecer (separadas por espacios)");
        jwords = new JTextField();

        lwordsMaybe = new JLabel("1 de estas palabras debe aparecer (separadas por espacios)");
        jwordsMaybe = new JTextField();

        lnoWord = new JLabel("Estas palabras no pueden aparecer (separadas por espacios)");
        jnoWord = new JTextField();

        lhastag = new JLabel("Con estos hastags (separadas por espacios)");
        jhastag = new JTextField();

        laccountFrom = new JLabel("De estas cuentas (separadas por espacios)");
        jaccountFrom = new JTextField();

        laccountTo = new JLabel("Para estas cuentas (separadas por espacios)");
        jaccountTo = new JTextField();

        lmention = new JLabel("Que mencionen estas cuentas (separadas por espacios)");
        jmention = new JTextField();

        lnear = new JLabel("Cerca de esta localizacion ex: Madrid (separadas por espacios)");
        jnear = new JTextField();

        lfecha1 = new JLabel("Desde: (YYYY-MM-DD format ex: 2016-02-28)");
        jsince = new JTextField();

        lfecha2 = new JLabel("Hasta: (YYYY-MM-DD format ex: 2016-02-28)");
        jfrom = new JTextField();

        lvueltas = new JLabel("Numero de blucles -> scroll (por defecto 100)");
        jvueltas = new JTextField();

        space = new JLabel();
        space.setVisible(false);

        space2 = new JLabel();
        space2.setVisible(false);

        panel.add(lwords);
        panel.add(jwords);

        panel.add(lwordsMaybe);
        panel.add(jwordsMaybe);

        panel.add(lnoWord);
        panel.add(jnoWord);

        panel.add(lhastag);
        panel.add(jhastag);

        panel.add(laccountFrom);
        panel.add(jaccountFrom);

        panel.add(laccountTo);
        panel.add(jaccountTo);

        panel.add(lmention);
        panel.add(jmention);

        panel.add(lnear);
        panel.add(jnear);

        panel.add(lfecha1);
        panel.add(jsince);

        panel.add(lfecha2);
        panel.add(jfrom);

        panel.add(lvueltas);
        panel.add(jvueltas);

        panel.add(space);
        panel.add(space2);

        panel.add(b2);
        panel.add(b1);

        setContentPane(panel);
    }
}
