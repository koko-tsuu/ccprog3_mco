import javax.swing.*;
        import java.awt.event.ActionListener;

/**
 * Planting_GUI class for planting GUI.
 */
public class Planting_GUI extends JFrame {
    private JButton Cancel = new JButton("Cancel");
    private JButton Plant = new JButton("Plant!");
    private String[] crops = {"Turnip", "Carrot", "Potato", "Rose", "Tulips", "Sunflower", "Mango", "Apple"};
    private JComboBox<String> cropBox = new JComboBox<>(crops);
    private JTextArea cropDesc = new JTextArea();
    private JPanel contentPane = new JPanel();

    /**
     * Planting_GUI constructor that creates the GUI for planting.
     */
    public Planting_GUI() {
        setTitle("Farming game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 300);
        setResizable(false);
        setLayout(null);
        Crops();
        setVisible(false);
    }

    /**
     * Crops() is a method that setups the GUI for Planting_GUI.
     */
    public void Crops() {
        cropBox.setBounds(20,10, 150, 30);
        cropDesc.setBounds(20, 50, 150, 170);
        cropDesc.setEditable(false);
        Cancel.setBounds(17, 230, 75, 25);
        Plant.setBounds(97, 230, 75, 25);
        JScrollPane scrollCrop = new JScrollPane(cropDesc);
        scrollCrop.setBounds(20, 45, 150, 180);
        scrollCrop.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(cropBox);
        add(scrollCrop);
        add(Cancel);
        add(Plant);
    }

    /**
     * setActionListener() is a method that setups action listeners for the interactive objects.
     * @param listener is an action listener
     */
    public void setActionListener(ActionListener listener){
        Cancel.addActionListener(listener);
        Plant.addActionListener(listener);
        cropBox.addActionListener(listener);
    }

    /**
     * getCropBox() is a method that gets the cropBox (a combo box).
     * @return cropBox is a combo box containing the crops
     */
    public JComboBox<String> getCropBox(){
        return cropBox;
    }

    /**
     * getPlant() is a method that gets the Plant button.
     * @return Plant is the plant button
     */
    public JButton getPlant(){
        return Plant;
    }

    /**
     * getCancel() is a method that gets the Cancel button.
     * @return Cancel is the cancel button
     */
    public JButton getCancel(){
        return Cancel;
    }

    /**
     * setCropDesc() is a method that sets cropDesc (a text area).
     * @param string is the string to be passed to the cropDesc
     */
    public void setCropDesc(String string){
        this.cropDesc.setText(string);
    }
}