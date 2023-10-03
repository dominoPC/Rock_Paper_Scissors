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
    JLabel winsLbl;
    JLabel lossesLbl;
    JLabel drawsLbl;
    TextArea winsTxt;
    TextArea lossesTxt;
    TextArea drawsTxt;
    TextArea resultTxt;
    JScrollPane resultPane;
    Boolean empty = true;
    byte cpuThrow;
    int wins = 0;
    int losses = 0;
    int draws = 0;
    Toolkit kit;
    public RockPaperScissorsFrame(){
        mainPnl = new JPanel();
        mainPnl.setLayout(new GridLayout(3,1));

        btnPnl = new JPanel();
        btnPnl.setLayout(new GridLayout(1,4));
        rock = new ImageIcon(".\\src\\rock.jpg");
        paper = new ImageIcon(".\\src\\paper.jpg");
        scissors = new ImageIcon(".\\src\\scissors.jpg");
        rockBtn = new JButton(rock);
        rockBtn.addActionListener((ActionEvent ae) -> {play((byte)0);});
        paperBtn = new JButton(paper);
        paperBtn.addActionListener((ActionEvent ae) -> {play((byte)1);});
        scissorsBtn = new JButton(scissors);
        scissorsBtn.addActionListener((ActionEvent ae) -> {play((byte)2);});
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> {System.exit(0);});
        btnPnl.add(rockBtn);
        btnPnl.add(paperBtn);
        btnPnl.add(scissorsBtn);
        btnPnl.add(quitBtn);
        btnPnl.setBorder(new EtchedBorder());
        mainPnl.add(btnPnl);

        statsPnl = new JPanel();
        statsPnl.setLayout(new GridLayout(1,6));
        winsLbl = new JLabel("Player Wins: ");
        winsTxt = new TextArea("0",1,3);
        winsTxt.setEditable(false);
        lossesLbl = new JLabel("Computer Wins: ");
        lossesTxt = new TextArea("0",1,3);
        lossesTxt.setEditable(false);
        drawsLbl = new JLabel("Ties: ");
        drawsTxt = new TextArea("0",1,3);
        drawsTxt.setEditable(false);
        statsPnl.add(winsLbl);
        statsPnl.add(winsTxt);
        statsPnl.add(lossesLbl);
        statsPnl.add(lossesTxt);
        statsPnl.add(drawsLbl);
        statsPnl.add(drawsTxt);
        mainPnl.add(statsPnl);

        outPnl = new JPanel();
        resultTxt = new TextArea("",10,40);
        resultTxt.setEditable(false);
        resultPane = new JScrollPane(resultTxt);
        outPnl.add(resultPane);
        mainPnl.add(outPnl);

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

    private void play(byte gesture){
        cpuThrow = (byte)(Math.random()*3);
        if(!empty){
            resultTxt.append("\n");
        }
        else{
            empty = false;
        }
        if(gesture == 0){
            if(cpuThrow == 0){
                draws++;
                drawsTxt.setText(Integer.toString(draws));
                resultTxt.append("Rock matches Rock (Tie)");
            }
            else if(cpuThrow == 1){
                losses++;
                lossesTxt.setText(Integer.toString(losses));
                resultTxt.append("Paper covers Rock (Computer Wins)");
            }
            else{
                wins++;
                winsTxt.setText(Integer.toString(wins));
                resultTxt.append("Rock breaks Scissors (Player Wins)");
            }
        }
        else if (gesture == 1) {
            if(cpuThrow == 0){
                wins++;
                winsTxt.setText(Integer.toString(wins));
                resultTxt.append("Paper covers Rock (Player Wins)");
            }
            else if(cpuThrow == 1){
                draws++;
                drawsTxt.setText(Integer.toString(draws));
                resultTxt.append("Paper matches Paper (Tie)");
            }
            else{
                losses++;
                lossesTxt.setText(Integer.toString(losses));
                resultTxt.append("Scissors cut Paper (Computer Wins)");
            }
        }
        else{
            if(cpuThrow == 0){
                losses++;
                lossesTxt.setText(Integer.toString(losses));
                resultTxt.append("Rock breaks Scissors (Computer Wins)");
            }
            else if(cpuThrow == 1){
                wins++;
                winsTxt.setText(Integer.toString(wins));
                resultTxt.append("Scissors cut Paper (Player Wins)");
            }
            else{
                draws++;
                drawsTxt.setText(Integer.toString(draws));
                resultTxt.append("Scissors matches Scissors (Tie)");
            }
        }
    }
}
