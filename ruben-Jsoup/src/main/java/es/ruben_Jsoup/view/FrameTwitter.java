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
 * TODO JAVADOC FrameSearchTwitter
 *
 * @version 1.0.0
 * @author ruben.merino (ver. 1.0.0)
 */
public class FrameTwitter extends JFrame {

    /** serialVersionUID */
    private static final long serialVersionUID = -4723252410680374292L;
    /** jlabel */
    public JLabel jlabel;
    /** jlfecha1 */

    public JLabel lfecha1;

    /** lfecha2 */
    public JLabel lfecha2;
    /** taccount */
    public JTextField taccount;
    /** campo1 */
    public JTextField jfecha1;
    /** jt */
    public JTextField jfecha2;

    /** b1 */
    public JButton b1;
    /** b2 */
    public JButton b2;

    /**
     * Constructor
     */
    public FrameTwitter() {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        final JPanel panel = new JPanel(new GridLayout(8, 4, 4, 4));

        b1 = new JButton("volver");
        b1.setName("volver");
        b1.setPreferredSize(new Dimension(40, 40));

        b2 = new JButton("consultar");
        b2.setName("consultarTwitter");
        b2.setPreferredSize(new Dimension(40, 40));

        jlabel = new JLabel();

        lfecha1 = new JLabel("since: (YYYY-MM-DD format ex: 2016-02-28)");
        lfecha2 = new JLabel("until: (YYYY-MM-DD format ex: 2016-02-28)");

        taccount = new JTextField();

        jfecha2 = new JTextField();
        jfecha1 = new JTextField();

        panel.add(jlabel);
        panel.add(taccount);

        panel.add(lfecha1);
        panel.add(jfecha1);

        panel.add(lfecha2);
        panel.add(jfecha2);

        panel.add(b2);
        panel.add(b1);

        setContentPane(panel);
    }

}
