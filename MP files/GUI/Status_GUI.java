import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Status_GUI is a class that contains the status GUI.
 */
public class Status_GUI extends JFrame {

    private JLabel description = new JLabel("Player Status");
    private JButton back = new JButton("Back");
    private JTextArea textAreaStats = new JTextArea(10, 5);

    /**
     * Status_GUI constructor to create the status GUI.
     */
    public Status_GUI(){
        setTitle("Farming game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 200, 300);
        setLayout(null);
        Desc();
        setResizable(false);
        setVisible(false);

    }

    /**
     * Desc() is a method that creates the GUI inside the status GUI.
     */
    public void Desc(){
        description.setBorder(new EmptyBorder(10, 10, 10, 10));
        description.setBounds(-7, 20, 200, 20);
        description.setHorizontalAlignment(JLabel.CENTER);
        back.setBounds(20,230, 150, 20);

        JScrollPane scrollStatus = new JScrollPane(textAreaStats);
        scrollStatus.setBounds(20, 45, 150, 180);
        scrollStatus.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollStatus.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        textAreaStats.setEditable(false);

        add(description);
        add(back);
        add(scrollStatus);
    }
    /**
     * setActionListener() is a method that creates an action listener for the button.
     */
    public void setActionListener(ActionListener listener){
        back.addActionListener(listener);
    }

    /**
     * setTextAreaStats() is a method that sets the text in textAreaStats (a text area).
     * @param string to be passed to set the text
     */
    public void setTextAreaStats(String string){
        this.textAreaStats.setText(string);
    }

}
