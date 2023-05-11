import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField textField;
    private JButton[] functions;
    private JButton[] numbers;
    private double num1, num2, result;
    private char operator;
    private Font font;

    Calculator(){
        font = new Font("Ink Free", Font.PLAIN, 30);
        num1 = 0;
        num2 = 0;
        result = 0;
        operator = ' ';

        functions = new JButton[9];
        functions[0] = new JButton("+");
        functions[1] = new JButton("-");
        functions[2] = new JButton("*");
        functions[3] = new JButton("/");
        functions[4] = new JButton("=");
        functions[5] = new JButton(".");
        functions[6] = new JButton("Del");
        functions[7] = new JButton("Clear");
        functions[8] = new JButton("(+/-)");

        for (int i = 0; i < functions.length; i++){
            functions[i].addActionListener(this);
            functions[i].setFont(font);
            functions[i].setFocusable(false);
        }
        functions[6].setBounds(150,430, 100, 50);
        functions[7].setBounds(250,430,100,50);
        functions[8].setBounds(50,430,100,50);

        numbers = new JButton[10];
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = new JButton(Integer.toString(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(font);
            numbers[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(functions[0]);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(functions[1]);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(functions[2]);
        panel.add(functions[5]);
        panel.add(numbers[0]);
        panel.add(functions[4]);
        panel.add(functions[3]);

        textField = new JTextField();
        textField.setFont(font);
        textField.setBounds(50,25,300,50);
        textField.setEditable(false);

        this.add(textField);
        this.add(panel);
        this.add(functions[6]);
        this.add(functions[7]);
        this.add(functions[8]);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setSize(420,550);
        this.setLayout(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < numbers.length; i++){
            if (e.getSource() == numbers[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == functions[0]) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        else if (e.getSource() == functions[1]){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        else if (e.getSource() == functions[2]){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        else if (e.getSource() == functions[3]){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        else if (e.getSource() == functions[4]){
            num2 = Double.parseDouble(textField.getText());

            switch(operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
        }
        else if (e.getSource() == functions[5]){
            textField.setText(textField.getText().concat("."));
        }
        else if (e.getSource() == functions[6]){
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length() - 1; i++){
                textField.setText(textField.getText() + string.charAt(i));
            }

        }
        else if (e.getSource() == functions[7]){
            textField.setText("");
        }
        else if (e.getSource() == functions[8]){
            double temp = Double.parseDouble(textField.getText()) * -1;
            textField.setText(String.valueOf(temp));
        }
    }
}
