/*******************************************************************************
 * panel.add(b3); * Copyright (c) 2017, - All Rights Reserved Unauthorized
 * copying of this file, via any medium is strictly prohibited Proprietary and
 * confidential
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
 * TODO JAVADOC FrameMundo
 *
 * @version 1.0.0
 * @author ruben.merino (ver. 1.0.0)
 */
public class FrameMundo extends JFrame {

    /** serialVersionUID */
    private static final long serialVersionUID = 7219692229458142961L;

    /** jlabel */
    public JLabel jlabel;
    /** jlfecha1 */
    public JLabel jlfecha1;
    /** jtanda */
    public JLabel jtanda;

    /** palabras */
    public JTextField tpalabras;
    /** fecha1 */
    public JTextField tfecha1;
    /** ttanda */
    public JTextField ttanda;

    /** b1 */
    public JButton b1;
    /** b2 */
    public JButton b2;
    /** b2 */
    public JButton b3;

    /**
     * Constructor
     */
    public FrameMundo() {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        final JPanel panel = new JPanel(new GridLayout(10, 8, 8, 8));

        b1 = new JButton("volver");
        b1.setName("volver");
        b1.setPreferredSize(new Dimension(40, 40));

        b2 = new JButton("consultar");
        b2.setName("consultar");
        b2.setPreferredSize(new Dimension(40, 40));

        b3 = new JButton("consultar");
        b3.setName("consultarPais");
        b3.setPreferredSize(new Dimension(40, 40));

        jlabel = new JLabel();
        jlabel.setText("palabras (,) separadas por , tienen que aparecer todas en la noticia");

        jlfecha1 = new JLabel();
        jlfecha1.setText("año,usa este formato YYYY ex: 2016 *");

        jtanda = new JLabel();
        jtanda.setText("|mañana = 0| |tarde = 1| |noche = 2|)");

        tpalabras = new JTextField();

        tfecha1 = new JTextField();

        ttanda = new JTextField();

        panel.add(jlabel);
        panel.add(tpalabras);

        panel.add(jlfecha1);
        panel.add(tfecha1);

        panel.add(jtanda);
        panel.add(ttanda);

        panel.add(b2);
        panel.add(b3);
        panel.add(b1);

        setContentPane(panel);
    }
}
