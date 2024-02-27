
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

/**
 * Game_Over_GUI displays GUI when the Player gets a game over.
 */
public class Game_Over_GUI extends JFrame {
    private JLabel GameOver = new JLabel("Game over!");
    private JLabel Reason = new JLabel("Reason: ");
    private JButton TitleButton = new JButton("Aw shucks");
    private JTextArea textAreaStatus = new JTextArea();
    private JTextField textFieldReason = new JTextField(10);


    /**
     * Game_Over_GUI constructor.
     */
    public Game_Over_GUI(){
        setTitle("Farming game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 300);
        setLayout(null);
        setGameOver();
        setResizable(true);
        setVisible(false);
    }

    /**
     * setGameOver() is a method that creates the GUI in Game_Over_GUI.
     */
    public void setGameOver() {
        GameOver.setBorder(new EmptyBorder(10, 10, 10, 10));
        GameOver.setHorizontalAlignment(JLabel.CENTER);
        GameOver.setBounds(-7, 20, 200, 20);
        Reason.setBorder(new EmptyBorder(10, 10, 10, 10));
        Reason.setBounds(-4, 40, 200, 20);
        Reason.setHorizontalAlignment(JLabel.CENTER);

        textFieldReason.setBounds(20, 65, 150, 20);
        textFieldReason.setHorizontalAlignment(JLabel.CENTER);
        textFieldReason.setEditable(false);

        JScrollPane scrollReason = new JScrollPane(textAreaStatus);
        scrollReason.setBounds(20, 90, 150, 130);
        scrollReason.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollReason.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textAreaStatus.setEditable(false);

        TitleButton.setBounds(20,230, 150, 20);

        add(GameOver);
        add(Reason);
        add(textFieldReason);
        add(scrollReason);
        add(TitleButton);
    }

    /**
     * getTitleButton returns the back button.
     * @return TitleButton is the back button.
     */
    public JButton getTitleButton(){
        return TitleButton;
    }

    /**
     * setActionListener() is a method that creates an action listener for the button.
     * @param listener is an action listener
     */
    public void setActionListener(ActionListener listener){
        this.TitleButton.addActionListener(listener);
    }

    /**
     * setTextFieldReason() is a method that sets the text in textFieldReason.
     * @param string is the string to be passed to the textFieldReason
     */
    public void setTextFieldReason(String string){
        this.textFieldReason.setText(string);
    }

    /**
     * setTextAreaStatus() is a method that sets the text in textAreaStatus.
     * @param string is the string to be passed to the textAreaStatus
     */
    public void setTextAreaStatus(String string){
        this.textAreaStatus.setText(string);
    }



}


