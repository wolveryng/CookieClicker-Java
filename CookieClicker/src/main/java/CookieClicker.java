import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.InputStream;

public class CookieClicker extends JFrame {
    public CookieClicker() {
        super("Cookie Clicker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setPreferredSize(new Dimension(660, 800));
        pack();

        addGuiComponents();
    }

    private void addGuiComponents() {
        // Load the banner image
        ImageIcon imageIcon = new ImageIcon("banner.jpeg");
        JLabel label = new JLabel(imageIcon);

        // Load the button image
        ImageIcon buttonImage = new ImageIcon("cookie.png");
        JButton button = new JButton(buttonImage);

        // Score text area
        JTextArea textArea = new JTextArea("Score: 0");
        textArea.setFont(new Font("Times New Roman", Font.BOLD, 15));
        textArea.setEditable(false);
        textArea.setBackground(null);

        // Create a panel for the score and button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        // Add padding around components
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Center align the text area
        textArea.setAlignmentX(JTextField.CENTER);
        JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        scorePanel.add(textArea);

        // Center the button in its panel
        JPanel centerButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        centerButtonPanel.add(button);

        // Add components to the button panel
        buttonPanel.add(scorePanel, BorderLayout.NORTH);
        buttonPanel.add(centerButtonPanel, BorderLayout.CENTER);

        // Set the main layout
        setLayout(new BorderLayout());
        add(label, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                button.setIcon(new ImageIcon("cookieHappy.png"));

                new Timer(500, new ActionListener() {  // 300 milliseconds delay
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button.setIcon(new ImageIcon("cookie.png"));  // Restore original image
                    }
                }).start();


                int currentScore = Integer.parseInt(textArea.getText().split(": ")[1]);
                textArea.setText("Score: " + (currentScore + 1));  // Increment the score
            }
        });
        pack();
    }



}
