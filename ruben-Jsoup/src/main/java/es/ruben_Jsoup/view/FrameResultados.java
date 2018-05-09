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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * TODO JAVADOC FrameResultados
 *
 * @version 1.0.0
 * @author ruben.merino (ver. 1.0.0)
 */
public class FrameResultados extends JFrame {

    /** serialVersionUID */
    private static final long serialVersionUID = 814480269314021964L;
    /** b1 */
    public JButton b1;
    /** b2 */
    public JButton b2;

    /** b3 */
    public JButton b3;

    /** b3 */
    public JButton b4;
    /** b3 */
    public JButton b5;

    /** campo1 */
    public JLabel campo1;
    /** jt */
    public JTextField jt;

    /**
     * Constructor
     */
    public FrameResultados() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        final JPanel panel = new JPanel(new GridLayout(8, 4, 4, 4));
        jt = new JTextField();

        b1 = new JButton("back");
        b1.setName("volver");
        b2 = new JButton("start");
        b2.setName("empezarMundo");
        b3 = new JButton("start");
        b3.setName("empezarTwitter");
        b4 = new JButton("start");
        b4.setName("empezarPais");
        b5 = new JButton("start");
        b5.setName("empezarTwitterAdvance");

        campo1 = new JLabel("Esta operacion puede tardar unos minutos, introduce la ruta (se va a crear un fichero)");

        panel.add(campo1);
        panel.add(jt);

        panel.add(b2);
        panel.add(b3);
        panel.add(b5);
        panel.add(b4);
        panel.add(b1);

        setContentPane(panel);
    }
}
