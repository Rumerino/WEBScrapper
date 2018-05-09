/*******************************************************************************
 * Copyright (c) 2017, - All Rights Reserved Unauthorized copying of this file,
 * via any medium is strictly prohibited Proprietary and confidential
 *
 * Contributors: <a href="mailto:ruben.merino@altia.es">Rubén Merino</a>
 *******************************************************************************/
package es.ruben_Jsoup.view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * TODO JAVADOC FrameInicio
 *
 * @version 1.0.0
 * @author ruben.merino (ver. 1.0.0)
 */
public class FrameInicio extends JFrame {

    /** serialVersionUID */
    private static final long serialVersionUID = -2372995424063997661L;

    /** b1 */
    public JButton b1;
    /** b2 */
    public JButton b2;
    /** b3 */
    public JButton b3;
    /** b4 */
    public JButton b4;

    /**
     * Constructor
     */
    public FrameInicio() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        final JPanel panel = new JPanel(new GridLayout(2, 4, 4, 4));
        ImageIcon start = new ImageIcon(getClass().getClassLoader().getResource("images/logoelmundo_rrss.png"));
        b1 = new JButton(start);
        b1.setName("mundo");

        start = new ImageIcon(getClass().getClassLoader().getResource("images/twitter.png"));
        b2 = new JButton(start);
        b2.setName("twitter");
        b2.setContentAreaFilled(true);

        start = new ImageIcon(getClass().getClassLoader().getResource("images/pais.png"));
        b3 = new JButton(start);
        b3.setName("pais");
        b3.setContentAreaFilled(true);

        start = new ImageIcon(getClass().getClassLoader().getResource("images/html.png"));
        b4 = new JButton(start);
        b4.setName("html");
        b4.setContentAreaFilled(true);

        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        setContentPane(panel);

    }

}
