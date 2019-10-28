/** To Do List:
    (1) Comment
    (2) Get Answer Frame to call for and display answer function
    (3) Fix screen size not increase with size of RollList
    (4) Fix Trailing newline in Rollist
**/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame{
    public static void main(String[] args) {

    String[] DiceRoll = {"D4","D6","D8","D10","D12","D20","D20 Advantage","D20 Disadvantage","D50","D100"};

    JFrame Frame = new JFrame("DnD Dice Roller");

    JComboBox<String> DiceBox = new JComboBox<>(DiceRoll);
    JPanel DicePanel = new JPanel(new FlowLayout());
    JLabel DiceLabel = new JLabel("Select Dice to Roll:");
    JPanel RollPanel = new JPanel(new FlowLayout());
    JLabel RollLabel = new JLabel("Input Number of Rolls");
    JTextArea RollList = new JTextArea(2,12);
    JTextField RollText = new JTextField(3);
    JButton AddButton = new JButton("Add");
    JButton RollButton = new JButton("Roll");

    RollText.addKeyListener(new KeyAdapter() {
         public void keyPressed(KeyEvent key) {
            String value = RollText.getText();
            if ((key.getKeyChar() >= '0' && key.getKeyChar() <= '9') || key.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
               RollText.setEditable(true);
            } else {
               RollText.setEditable(false);
            }
         }
      });

    AddButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          RollList.append(String.valueOf(DiceBox.getSelectedItem()) + " X " + RollText.getText() + " \n");
        }
    });

    RollButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          JFrame AnswerFrame = new JFrame("Results");
          JTextArea RollResult = new JTextArea(RollList.getText());

          RollResult.setLineWrap(true);
          RollResult.setEditable(false);

          AnswerFrame.setLayout(new FlowLayout());
          AnswerFrame.setSize(300,300);
          AnswerFrame.add(RollResult);
          AnswerFrame.setVisible(true);
          AnswerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    });

    JButton ResetButton = new JButton("Reset");
    ResetButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
          RollList.setText("");
        }
    });

    DicePanel.add(DiceLabel);
    DicePanel.add(DiceBox);

    RollPanel.add(RollLabel);
    RollPanel.add(RollText);
    RollPanel.add(AddButton);

    RollList.setBackground(Color.WHITE);
    RollList.setLineWrap(true);
    RollList.setEditable(false);

    Frame.setLayout(new FlowLayout());
    Frame.add(DicePanel);
    Frame.add(RollPanel);
    Frame.add(RollList);
    Frame.add(RollButton);
    Frame.add(ResetButton);
    Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Frame.setSize(300,300);
    Frame.setVisible(true);
    }
}
