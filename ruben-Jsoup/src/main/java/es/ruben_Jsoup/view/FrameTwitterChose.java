/*******************************************************************************
 * Copyright (c) 2017, - All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential
 *
 * Contributors: <a href="mailto:ruben.merino@altia.es">Rubén Merino</a>
 *******************************************************************************/
package es.ruben_Jsoup.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * TODO JAVADOC FrameTwitterChose
 *
 * @version 1.0.0
 * @author ruben.merino (ver. 1.0.0)
 */
public class FrameTwitterChose extends JFrame {

    /** serialVersionUID */
    private static final long serialVersionUID = -337394336997731737L;
    /** b1 */
    public JButton b1;
    /** b2 */
    public JButton b2;
    /** b3 */
    public JButton b3;
    /** b4 */
    public JButton b4;
    /** b4 */
    public JButton b5;

    /**
     * Constructor
     */
    public FrameTwitterChose() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        final JPanel panel = new JPanel(new GridLayout(8, 4, 4, 4));

        b1 = new JButton("Busqueda por nombre");
        b1.setName("twitterName");

        b2 = new JButton("Buscar cuenta entre fechas");
        b2.setName("twitterNameDate");
        b2.setContentAreaFilled(true);

        b3 = new JButton("Buscar por palabra entre fechas");
        b3.setName("twitterWordDate");
        b3.setContentAreaFilled(true);

        b4 = new JButton("Buscar alguna de las palabras enre fechas");
        b4.setName("twitterWordsDate");
        b4.setContentAreaFilled(true);

        b5 = new JButton("Busqueda avanzada");
        b5.setName("twitterAdvance");
        b5.setContentAreaFilled(true);

        panel.add(b5);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);

        setContentPane(panel);
    }

}
