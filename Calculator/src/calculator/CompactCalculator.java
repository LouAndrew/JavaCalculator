package calculator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CompactCalculator extends JFrame {
    static JFrame frame = new JFrame("Calculator...");
    private static double num1 = 0,num2 = 0;
    private static String operator = "";
    private static boolean newInput = true;
    private static String result = "0";
    
    private static final String[][] BUTTONS = {{"7","8","9","/"},{"4","5","6","*"},{"1","2","3","-"},{"0","C","=","+"}};
    
    private static class Button{
        public void ShowBackground(){
            frame.setSize(650,370);
            frame.setLayout(null);
            arrangeButtons();
        }
        public void arrangeButtons(){
            JLabel ResultButton = new JLabel(result, JLabel.CENTER);
            ResultButton.setOpaque(true);
            ResultButton.setForeground(Color.WHITE);
            ResultButton.setFont(new Font("Ariel", Font.BOLD,16));
            //ResultButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
            ResultButton.setPreferredSize(new Dimension(150,50));
                
            int WD = 480;int HT = 40;int XR = 50;int YR = 15;
            
            ResultButton.setBounds(XR,YR,WD,HT);
            int X = 2;int Y = 70;
            int n1 = 0;int n2 = 0;
            while(Y <= (70*4)){
            while(X <= (155*3)){
                final String IC = BUTTONS[n1][n2];
                JLabel labelButton = new JLabel(IC, JLabel.CENTER);
                labelButton.setOpaque(true);
                labelButton.setBackground(Color.BLUE);
                labelButton.setForeground(Color.WHITE);
                labelButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
                labelButton.setFont(new Font("Ariel", Font.BOLD,16));
                labelButton.setPreferredSize(new Dimension(150,50));
                
                int width = 150;
                int height = 50;
            
                labelButton.setBounds(X,Y,width,height);
            
                labelButton.addMouseListener(new MouseAdapter(){
                    @Override
                    public void mouseClicked(MouseEvent e){
                        //JOptionPane.showMessageDialog(frame,IC);
                        if ("0123456789".contains(IC)){
                            if (newInput){
                                ResultButton.setText(IC);
                                newInput = false;
                            }else{
                                ResultButton.setText(ResultButton.getText() + IC);
                            }
                        }
                        else if ("+-*/".contains(IC)){
                            num1 = Double.parseDouble(ResultButton.getText());
                            operator = IC;
                            newInput = true;
                        }
                        else if ("=".equals(IC)){
                            if (!operator.isEmpty()){
                                num2 = Double.parseDouble(ResultButton.getText());
                                double RESULT = calculate(num1,num2,operator);
                                ResultButton.setText(formatResult(RESULT));
                                operator = "";
                                newInput = true;
                            }
                        }
                        else if ("C".equals(IC)){
                            ResultButton.setText("0");
                            num1 = num2 = 0;
                            operator = "";
                            newInput = true;
                        }
                    }
                    @Override
                    public void mouseEntered(MouseEvent e){
                        labelButton.setBackground(Color.RED);
                    }
                    @Override
                    public void mouseExited(MouseEvent e){
                        labelButton.setBackground(Color.BLUE);
                    }
            });
            frame.add(labelButton);
            frame.setVisible(true);
            X += 153;
            n2 += 1;
            }Y += 70;X=2;
            n2 = 0;n1 += 1;
        }
            frame.add(ResultButton);
        } 
        private static double calculate(double a, double b,String op){
            return switch(op){
                case "+" -> a+b;
                case "-" -> a-b;
                case "*" -> a*b;
                case "/" -> b != 0 ? a/b:0;
                default -> 0;
            };
        }
        private static String formatResult(double result){
            return result == (long) result ? String.valueOf((long)result):String.valueOf(result);        
        }
    }
    public static void main (String[] args){
        Button bt = new Button();
        bt.ShowBackground();
    }
}