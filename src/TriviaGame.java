import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class TriviaGame extends JFrame implements ActionListener, KeyListener {
    private String chosenCategory;
    private JPanel gamePanel;
    private JLabel picture;
    private JLabel tempText;
    private JTextField Guessbox;
    private JLabel CorrectLabel;
    private JTextArea tempTitle;
    private int temp;
    private tempParser gameAns;//not sure
    private static String answer;

    public TriviaGame(String chosenCategory) {
        this.chosenCategory = chosenCategory;
        gamePanel();
        this.temp = 0;
        gameAns = null;

    }

    public static String getAnswer() {
        return answer;
    }

    private void gamePanel() {
        setContentPane(gamePanel);
        setTitle("pls work");
        setSize(1000, 1000);
        setLocation(250 , 100);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(this);
        Guessbox.addActionListener(this);
    }


// link: https://stackoverflow.com/questions/4419667/detect-enter-press-in-jtextfield

    Action action = new AbstractAction() //don't know if
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source instanceof JTextField) {
                String temp = Guessbox.toString();
                if (temp.equals(answer)) {
                    System.out.println("CORRECT");
                }
                System.out.println("some action");
            }
            JTextField textField = new JTextField(10);
            textField.addActionListener(action);

        }
    };

        public void updateScreen(){
        String currentGuess = Guessbox.getText();
        CorrectLabel.append("\nYou guessed: " + currentGuess + "\n");
        //if(//need smth to store answers.processGuess(currentGuess))

    }




    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 192) {
//          int temp = (int) (Math.random() * tempParser.animeList.size());
            tempText.setText(tempParser.animeList.get(temp) + " number in list: " + temp);
            try {
                URL imageURL = new URL(tempParser.animePicture.get(temp));
                BufferedImage image = ImageIO.read(imageURL);
                ImageIcon icon = new ImageIcon(image);
                picture.setIcon(icon);
            } catch (IOException ignored) { }
            temp++;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

}
