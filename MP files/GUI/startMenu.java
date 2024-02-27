import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * startMenu class for the start menu GUI.
 */
public class startMenu extends JFrame{
    private JFrame startMenu = new JFrame();
    private JButton Start = new JButton("Start");
    private JButton Quit = new JButton("Quit");

    /**
     * startMenu constructor to create the GUI for the start menu.
     */
    public startMenu(){
        setTitle("Farming game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 200);
        mainMenu();
        setResizable(false);
        setVisible(true);
    }

    /**
     * mainMenu() is a method that creates the GUI inside the start menu.
     */
    private void mainMenu(){
        JPanel mainMenu = new JPanel();
        JLabel Farming = new JLabel("Farming");
        Farming.setForeground(Color.WHITE);
        Farming.setBounds(45, 20, 200, 30);
        Farming.setHorizontalAlignment(SwingConstants.CENTER);
        Farming.setFont(new Font("Helvetica", Font.BOLD, 20));
        mainMenu.setBackground(Color.black);
        mainMenu.setLayout(null);
        mainMenu.setBorder(new EmptyBorder(5, 5, 5, 5));
        Start.setBounds(45, 70, 200, 20);
        Quit.setBounds(45, 100, 200, 20);
        setContentPane(mainMenu);
        mainMenu.add(Farming);
        mainMenu.add(Start);
        mainMenu.add(Quit);

    }

    /**
     * getStart() is a method that returns the start button.
     * @return Start is the start button
     */
    public JButton getStart(){
        return Start;
    }

    /**
     * getQuit() is a method that returns the quit button.
     * @return Quit is the quit button
     */
    public JButton getQuit(){
        return Quit;
    }

    /**
     * setActionListener() is a method that create action listeners to interactive objects.
     * @param listener is an action listener
     */
   public void setActionListener(ActionListener listener) {
       Start.addActionListener(listener);
       Quit.addActionListener(listener);
   }
}
