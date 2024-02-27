import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * MainGUI class that creates the main GUI of the game.
 */
public class MainGUI extends JFrame {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private JPanel contentPane;
    private JLabel days = new JLabel("Day 1");
    private JButton[][] buttonGrid = new JButton[10][5];
    private String[] tools = {"Plow", "Watering Can", "Fertilizer", "Pickaxe",
            "Shovel", "Plant", "Harvest", "Register", "Advance a Day", "Check a Tile"};
    private JComboBox<String> comboBox = new JComboBox<>(tools);
    private JButton btnOKButton = new JButton("OK");
    private JButton statsButton = new JButton("Status");
    private JTextArea textAreaDesc = new JTextArea(20, 5);
    private JTextArea textAreaHistory = new JTextArea();
    private Border blackBorder = BorderFactory.createLineBorder(Color.black, 2);
    private Border selectedBorder = BorderFactory.createLineBorder(Color.white, 2);

    /**
     * MainGUI constructor to create the frame.
     */
    public MainGUI() {
        setTitle("Farming game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 480);
        contentPane();
        titlePanel();
        panel_1();
        panel_2();
        setResizable(false);
        setVisible(false);
    }

    /**
     * contentPane() is a method that contains the main JPanel.
     */
    private void contentPane() {
        contentPane = new JPanel();
        contentPane.setBackground(Color.black);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }

    /**
     * panel() is a method that displays the title
     */
    private void titlePanel() {
        JLabel lblNewLabel = new JLabel("| Farming |");
        JPanel otherPanel = new JPanel();
        otherPanel.setBounds(535, 11, 135, 47);
        lblNewLabel.setBounds(40, 15, 460, 47);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBorder(BorderFactory.createLineBorder(Color.white));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Helvetica", Font.BOLD, 28));

        days.setFont(new Font("Taloma", Font.BOLD, 22));
        otherPanel.add(days);
        contentPane.add(otherPanel);
        contentPane.add(lblNewLabel);
    }

    /**
     * panel_1() is a method that displays the elements on the east panel
     */
    private void panel_1() {
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(535, 63, 135, 367);

        panel_1.setLayout(null);

        statsButton.setBounds(10, 300, 115, 23);
        panel_1.add(statsButton);

        btnOKButton.setBounds(10, 333, 115, 23);
        panel_1.add(btnOKButton);

        comboBox.setBounds(10, 11, 115, 22);
        panel_1.add(comboBox);


        textAreaDesc.setEditable(false);
        textAreaDesc.setLineWrap(true);
        textAreaDesc.setWrapStyleWord(true);
        JScrollPane scrollDesc = new JScrollPane(textAreaDesc);
        scrollDesc.setBounds(10, 40, 115, 250);
        scrollDesc.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDesc.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel_1.add(scrollDesc);

        contentPane.add(panel_1);

    }

    /**
     * panel_2() is a method that displays the west panel.
     */
    private void panel_2() {
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(20, 63, 500, 367);
        panel_2.setBackground(Color.black);
        panel_2.setLayout(null);


        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(10, 5));
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                buttonGrid[i][j] = new JButton(" ");
                buttonGrid[i][j].setBackground(Color.decode("#46CB8E"));
                buttonGrid[i][j].setBorder(blackBorder);
                panelGrid.add(buttonGrid[i][j]);
            }
        }

        textAreaHistory.setEditable(false);

        JScrollPane scroll = new JScrollPane(textAreaHistory);
        scroll.setBounds(20, 220, 460, 150);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel_2.add(scroll);

        panelGrid.setBounds(20, 20, 460, 180);
        panel_2.add(panelGrid);
        contentPane.add(panel_2);
    }

    /**
     * setActionListener() is a method that creates an action listener for the interactive objects
     * @param listener is an action listener
     */
    public void setActionListener(ActionListener listener) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {
                buttonGrid[i][j].addActionListener(listener);
            }
        }
        btnOKButton.addActionListener(listener);
        statsButton.addActionListener(listener);
        comboBox.addActionListener(listener);
    }

    /**
     * setColorTile() sets the color of the tile on the tile board.
     * @param tile is a tile on the board
     * @param x is the row coordinate
     * @param y is the column coordinate
     */
    public void setColorTile(Tile[][] tile, int x, int y){

        // tile has withered
        if (tile[x][y].getWither())
            buttonGrid[x][y].setBackground(Color.RED);

        // tile has a rock on it
        else if (tile[x][y].getRock())
            buttonGrid[x][y].setBackground(Color.DARK_GRAY);

        // tile is ready for harvest
        else if (tile[x][y].getHarvest())
            buttonGrid[x][y].setBackground(Color.yellow);

        // tile has a crop planted on it
        else if (!tile[x][y].getCrop().getName().equals("null"))
            buttonGrid[x][y].setBackground(Color.cyan);

        // tile is unplowed
        else if (tile[x][y].getUnplowed())
            buttonGrid[x][y].setBackground(Color.decode("#46CB8E"));

        // tile is plowed
        else if (tile[x][y].getPlowed())
            buttonGrid[x][y].setBackground(Color.ORANGE);



    }

    /**
     * setBorderTile() is a method that sets the border of the selected tile.
     * @param x is the row coordinate
     * @param y is the column coordinate
     */
    public void setBorderTile(int x, int y){
        buttonGrid[x][y].setBorder(selectedBorder);
    }

    /**
     * resetBorderTile() is a method that removes the border of the selected tile.
     * @param x is the row coordinate
     * @param y is the column coordinate
     */
    public void resetBorderTile(int x, int y){
        buttonGrid[x][y].setBorder(blackBorder);
    }


    /**
     * setTextAreaDesc() is a method that sets the text in the TextAreaDesc.
     * @param textAreaDesc is a text area for the description
     */
    public void setTextAreaDesc(String textAreaDesc){
       this.textAreaDesc.setText(textAreaDesc);
    }

    /**
     * setTextAreaHistory() is a method that sets the text in the TextAreaHistory
     * @param string is a string passed to be set
     */
    public void setTextAreaHistory(String string){
        Date date = new Date();
        this.textAreaHistory.append("[" + dateFormat.format(date) + "] " + string + "\n");
    }

    /**
     * resetTextAreaHistory() is a method that removes all text in the TextAreaHistory.
     */
    public void resetTextAreaHistory(){
        this.textAreaHistory.selectAll();
        this.textAreaHistory.setText("");
    }

    /**
     * getOKButton() is a method that returns the OK button.
     * @return JButton is the OK button.
     */
    public JButton getOKButton(){
        return btnOKButton;
    }

    /**
     * getStatsButton() is a method that returns the Status button.
     * @return JButton is the Status button
     */
    public JButton getStatsButton(){
        return statsButton;
    }

    /**
     * getButtonFromGrid() is a method that returns a button from the grid.
     * @param i is the row coordinate
     * @param j is the column coordinate
     * @return JButton is a button from the grid
     */
    public JButton getButtonFromGrid(int i, int j){
        return buttonGrid[i][j];
    }

    /**
     * getToolBox() is a method that returns the combo box containing actions the Player can do.
     * @return JComboBox is a combo box.
     */
    public JComboBox<String> getToolBox(){
        return comboBox;
    }

    /**
     * setDays() is a method that sets the day.
     * @param days is an integer determining the day.
     */
    public void setDays(int days){
        this.days.setText("Day " + days);
    }

}