package calculator;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator {
    protected static double number1 = 0;
    protected static double number2 = 0;
    protected static char operator;
    private static class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CalculateNum(operator,number1,number2);
        }
        public static void CalculateNum(char Operator,double num1,double num2){
            double result = 0;
            result = num1+Operator+num2;
        }
    }
    private static class CalculatorView extends JPanel {
        @Override
        public void paintComponent(Graphics Feilds) {
            super.paintComponent(Feilds);
            Feilds.drawString("Hello ", 20, 30 );
        }
    }
    private static class CalculatorProcess {
        protected static JFrame window = new JFrame("FOOD ORDERING SYSTEM..");
        protected static JPanel content = new JPanel();
        protected static JButton CustomerButton = new JButton("=");
        public void ShowCalculator(){
            ButtonHandler listen = new ButtonHandler();
            CustomerButton.addActionListener(listen);
            
            CalculatorView displayPanel = new CalculatorView();
            JButton CalculateButton = new JButton("=");
            
            CalculateButton.addActionListener(listen);
            
            content.add(new Button("K"),20,20);
            content.setLayout(new GridLayout(3,3));
            content.setLayout(new BorderLayout());
            content.add(displayPanel, BorderLayout.CENTER);
            content.add(CalculateButton, BorderLayout.SOUTH);
     
            window.setContentPane(content);
            window.setContentPane(content);
            window.setSize(500,400);
            window.setLocation(400,300);
            window.setVisible(true);
        }
    }
    public static void main(String[] args) {
        CalculatorProcess CP = new CalculatorProcess();
        CP.ShowCalculator();
    }
    }   
