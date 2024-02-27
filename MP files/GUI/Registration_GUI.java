import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Registration_GUI class for the registration GUI.
 */
public class Registration_GUI extends JFrame {
    private JButton Cancel = new JButton("Cancel");
    private JButton Register = new JButton("OK");
    private String[] regisTypes = {"Farmer", "Registered Farmer", "Distinguished Farmer", "Legendary Farmer"};
    private JComboBox<String> RegistrationBox = new JComboBox<>(regisTypes);
    private JTextArea regisDesc = new JTextArea();

    /**
     * Registration_GUI constructor to create the registration GUI.
     */
    public Registration_GUI() {
        setTitle("Farming game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 300);
        setResizable(false);
        setLayout(null);
        regis_GUI();
        setVisible(false);
    }

    /**
     * regis_GUI is a method that creates the GUI to be initialized.
     */
    public void regis_GUI() {

        RegistrationBox.setBounds(20,10, 150, 30);
        regisDesc.setBounds(20, 50, 150, 170);
        regisDesc.setEditable(false);
        Cancel.setBounds(17, 230, 75, 25);
        Register.setBounds(97, 230, 75, 25);

        JScrollPane scrollRegistration = new JScrollPane(regisDesc);
        scrollRegistration.setBounds(20, 45, 150, 180);
        scrollRegistration.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollRegistration.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(RegistrationBox);
        add(scrollRegistration);
        add(Cancel);
        add(Register);
    }

    /**
     * getRegisCancel() is a method that returns the cancel button.
     * @return Cancel is the cancel button
     */
    public JButton getRegisCancel(){
        return Cancel;
    }

    /**
     * getRegister() is a method that returns the register button.
     * @return Register is the register button
     */
    public JButton getRegister(){
        return Register;
    }

    /**
     * getRegistrationBox() is a method that returns the RegistrationBox (combo box).
     * @return RegistrationBox is the combo box containing the different farmer types.
     */
    public JComboBox<String> getRegistrationBox(){
        return RegistrationBox;
    }

    /**
     * setActionListener() is a method that sets the action listeners for the interactive objects.
     * @param listener is an action listener
     */
    public void setActionListener(ActionListener listener) {
        Cancel.addActionListener(listener);
        Register.addActionListener(listener);
        RegistrationBox.addActionListener(listener);
    }

    /**
     * setRegisDesc() is a method that sets the description in regisDesc (text area).
     * @param string is a string to be passed to set the text
     */
    public void setRegisDesc(String string){
        this.regisDesc.setText(string);
    }

}