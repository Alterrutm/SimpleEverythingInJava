import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

public class GUI extends JFrame {
    private static JButton buttonSearch = new JButton("Search");
    private static JTextArea textArea = new JTextArea();
    private static JLabel labelQuestion = new JLabel("Which file do you want to search for?");

    public GUI() {
        super("Simple Everything");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(labelQuestion);
        container.add(textArea);

        buttonSearch.addActionListener(new ButtonEventListener());
        container.add(buttonSearch);
    }

    private class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            List<File> searched = Search.getFilesFromADirectory(new File(System.getProperty("user.home")), new File(textArea.getText()));
            StringBuilder message = new StringBuilder("");
            for (File file : searched) {
                message.append(file.getAbsolutePath() + "\n");
            }
            System.out.println(System.getProperty("user.home"));
            JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
