import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RockPaperScissorsFrame extends JFrame {
    JPanel mainPnl;
    JPanel btnPnl;
    JPanel statsPnl;
    JPanel outPnl;
    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;
    ImageIcon rock;
    ImageIcon paper;
    ImageIcon scissors;
    Toolkit kit;
    public RockPaperScissorsFrame(){
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        btnPnl = new JPanel();
        btnPnl.setLayout(new GridLayout(1,4));
        rock = new ImageIcon(".\\src\\rock.jpg");
        paper = new ImageIcon(".\\src\\paper.jpg");
        scissors = new ImageIcon(".\\src\\scissors.jpg");
        rockBtn = new JButton(rock);
        paperBtn = new JButton(paper);
        scissorsBtn = new JButton(scissors);
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
        btnPnl.add(rockBtn);
        btnPnl.add(paperBtn);
        btnPnl.add(scissorsBtn);
        btnPnl.add(quitBtn);
        btnPnl.setBorder(new EtchedBorder());
        mainPnl.add(btnPnl,BorderLayout.NORTH);



        add(mainPnl);

        setTitle("Rock Paper Scissors");

        kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(3*screenWidth / 4, 3*screenHeight / 4); //0.75 width and height
        setLocation(screenWidth / 8, screenHeight / 8); //centered when the above is true

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    //private
}
