package wordSearch;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: talry
 * Date: 05.10.20
 * Time: 20:35
 * To change this template use File | Settings | File Templates.
 */
class WordsSearch extends JPanel {
    // create LOOKandFEEL
    private static void initLookAndFeel() {
        try {

            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    public void initGUI() {

    }

    public static void createAndShowGUI() {
        initLookAndFeel();

        JFrame frame = new JFrame("Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(1000, 700);

        CreateComponents create = new CreateComponents();
        Component contents = create.createComponents();
        create.listeners();

        frame.getContentPane().add(contents);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }


    public static void main(String [] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
