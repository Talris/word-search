package wordSearch;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: talry
 * Date: 14.10.20
 * Time: 16:54
 * To change this template use File | Settings | File Templates.
 */
class CreateComponents {
    String labelPrefix = "";     //Num of words:
    JTextArea textArea;
    JTextField textField;
    JScrollPane scrollPane;
    JToolBar toolBar;
    JButton searchButton;
    JButton searchToolBar;
    JButton nextButton;
    JButton prevButton;
    JLabel infoLabel;
    JPanel searchPane, rootPane;

    Component createComponents() {
        textArea = new JTextArea("if you gonna Ride, don`t ride on white horse. if you gonna Ride, ride on white pony.");  //30, 50
        textField = new JTextField("ride");
        scrollPane = new JScrollPane(textArea);
        toolBar = new JToolBar();
        // Явное объявление переменной
        //ImageIcon searchToolIcon = new ImageIcon("src/com/talris/bookvy/wordSearch/searchIcon.png");

        ImageIcon searchToolIcon = createImageIcon("images/searchIcon.png");
        searchToolBar = new JButton(searchToolIcon);
        searchButton = new JButton("Search");
        nextButton = new JButton("Next");
        prevButton = new JButton("Prev");
        infoLabel = new JLabel();           //labelPrefix + "0"

        // корневая панель для приложения
        // в CENTER расположен textArea и scrollPane,
        // а в EAST панель searchPane
        rootPane = new JPanel();
        BorderLayout rootLayout = new BorderLayout();
        rootPane.setLayout(rootLayout);

        // панель для компонентов textField
        // searchButton
        // nextButton
        // prevButton
        // infoLabel
        searchPane = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        searchPane.setLayout(gridbag);

        toolBar.setLayout(gridbag);
        toolBar.setFloatable(false); // фиксирует toolbar
        toolBar.setRollover(true); // подсвечивает кнопку при наведении курсора

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        // deriveFont - Creates a new Font object by replicating this Font object
        // and applying a new style and size.
        textArea.setFont(textArea.getFont().deriveFont(Font.PLAIN, 16));


        scrollPane.setPreferredSize(new Dimension(700, 450));

        rootPane.add(scrollPane, BorderLayout.CENTER);






        // scrollPane
        /*
        GridBagConstraints scrollPaneConstrains = new GridBagConstraints();
        scrollPaneConstrains.gridx = 0;
        scrollPaneConstrains.gridy = 0;
        scrollPaneConstrains.gridwidth = 10;
        scrollPaneConstrains.gridheight = 10;
        scrollPaneConstrains.weightx = 1.0;
        scrollPaneConstrains.weighty = 1.0;
        */
        //scrollPaneConstrains.fill = GridBagConstraints.BOTH;

         /*13 november
         scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
         searchPane.add(scrollPane, scrollPaneConstrains);
         */
        //searchPane.add(scrollPane);

        //searchToolBar
        GridBagConstraints searchToolConstrains = new GridBagConstraints();
        searchToolConstrains.gridx = 14;
        searchToolConstrains.gridy = 0;
        searchToolConstrains.gridwidth = 1;
        searchToolConstrains.gridheight = 1;
        searchToolConstrains.weightx = 1.0;
        searchToolConstrains.weighty = 1.0;
        searchToolConstrains.anchor = GridBagConstraints.LINE_END;
        // устанавливаем размер кнопки
        searchToolBar.setPreferredSize(new Dimension(26, 26));
        // присваиваем кнопке подсказку
        searchToolBar.setToolTipText("Поиск");

        toolBar.add(searchToolBar, searchToolConstrains);

        // textField
        GridBagConstraints textFieldConstrains = new GridBagConstraints();
        textFieldConstrains.gridx = 0;
        textFieldConstrains.gridy = 0;
        textFieldConstrains.gridwidth = 2;
        textFieldConstrains.gridheight = 1;
        textFieldConstrains.weightx = 1.0;
        textFieldConstrains.weighty = 1.0;
        textFieldConstrains.fill = GridBagConstraints.HORIZONTAL;
        textField.setFont(textField.getFont().deriveFont(Font.PLAIN, 16));
        searchPane.add(textField, textFieldConstrains);


        //searchButton
        GridBagConstraints searchButtonConstrains = new GridBagConstraints();
        searchButtonConstrains.gridx = 2;
        searchButtonConstrains.gridy = 0;
        searchButtonConstrains.gridwidth = 1;
        searchButtonConstrains.gridheight = 1;
        searchButtonConstrains.weightx = 1.0;
        searchButtonConstrains.weighty = 1.0;
        //searchButtonConstrains.anchor = GridBagConstraints.LINE_END;
        // устанавливаем размер кнопки
        //searchButton.setPreferredSize(new Dimension(26, 26));
        // присваиваем кнопке подсказку
        //searchButton.setToolTipText("Поиск");

        //searchButtonConstrains.fill = GridBagConstraints.HORIZONTAL;
        searchPane.add(searchButton, searchButtonConstrains);


        // nextButton
        GridBagConstraints nextButtonConstrains = new GridBagConstraints();
        nextButtonConstrains.gridx = 2;
        nextButtonConstrains.gridy = 1;
        nextButtonConstrains.gridwidth = 1;
        nextButtonConstrains.gridheight = 1;
        nextButtonConstrains.weightx = 1.0;
        nextButtonConstrains.weighty = 1.0;
        nextButtonConstrains.fill = GridBagConstraints.HORIZONTAL;
        // делаем размер nextButton такойже как и у searchButton
        nextButton.setPreferredSize(searchButton.getPreferredSize());
        searchPane.add(nextButton, nextButtonConstrains);

        // prevButton
        GridBagConstraints prevButtonConstrains = new GridBagConstraints();
        prevButtonConstrains.gridx = 0;
        prevButtonConstrains.gridy = 1;
        prevButtonConstrains.gridwidth = 1;
        prevButtonConstrains.gridheight = 1;
        prevButtonConstrains.weightx = 1.0;
        prevButtonConstrains.weighty = 1.0;
        prevButtonConstrains.fill = GridBagConstraints.HORIZONTAL;
        // делаем размер prevButton такойже как и у searchButton
        prevButton.setPreferredSize(searchButton.getPreferredSize());
        searchPane.add(prevButton, prevButtonConstrains);

        // infoLabel
        GridBagConstraints infoLabelConstrains = new GridBagConstraints();
        infoLabelConstrains.gridx = 1;
        infoLabelConstrains.gridy = 1;
        infoLabelConstrains.gridwidth = 1;
        infoLabelConstrains.gridheight = 1;
        infoLabelConstrains.weightx = 1.0;
        infoLabelConstrains.weighty = 1.0;
        infoLabelConstrains.insets = new Insets(0, 10, 0, 10);
        //infoLabelConstrains.anchor = GridBagConstraints.NORTHWEST;
        searchPane.add(infoLabel, infoLabelConstrains);

        searchPane.setBorder(BorderFactory.createEmptyBorder(
                15, //top
                5, //left
                10, //bottom
                5) //right
        );

        searchPane.setVisible(false);
        searchPane.setEnabled(true);
        rootPane.add(toolBar, BorderLayout.NORTH);
        rootPane.add(searchPane, BorderLayout.EAST);




        return rootPane;
    }

    void listeners() {
        SearchEngine se = new SearchEngine(this);

        searchToolBar.addActionListener(se);
        searchButton.addActionListener(se);
        nextButton.addActionListener(se);
        prevButton.addActionListener(se);

    }

    private static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = CreateComponents.class.getResource(path);

        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("File not found: " + path);
            return null;
        }

    }
}
