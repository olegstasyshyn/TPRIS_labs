package SimpleCalculate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.LinkedList;

public class ControllerSimpleCalculate {
    @FXML
    private TextField display;
    public void input(ActionEvent actionEvent) {
        Button source = (Button) actionEvent.getSource();
        display.setText(display.getText() + source.getText());
    }

    public void clear(ActionEvent actionEvent) {
        display.setText("");
    }

    DataBaseSimpleCalculate dataBaseSimpleCalculate = new DataBaseSimpleCalculate();
    public void calc(ActionEvent actionEvent) throws Exception {
        String s = display.getText();
        display.setText("" + eval(s));
        //dataBaseSimpleCalculate.addDataBase(s , eval(s));

    }



    static boolean isDelim(char c) {
        return c == ' ';
    }
    static void print(){
        System.out.print("5353**+");
    }
    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }
    static int priority(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            default:
                return -1;
        }
    }
    static void processOperator(LinkedList<Double> st, char op) {
        double r = st.removeLast();
        double l = st.removeLast();
        switch (op) {
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                st.add(l / r);
                break;
            case '%':
                st.add(l % r);
                break;
        }
    }
    public static double eval(String s) {
        LinkedList<Double> st = new LinkedList<Double>();
        LinkedList<Character> op = new LinkedList<Character>();
        LinkedList<Object> newOp = new LinkedList<Object>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isDelim(c))
                continue;
            if (c == '(') {
                op.add('(');
                newOp.add('(');
            }
            else if (c == ')') {
                while (op.getLast() != '(')
                    processOperator(st,op.removeLast());
                op.removeLast();
            } else if (isOperator(c)) {
                while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                    processOperator(st, op.removeLast());
                op.add(c);
                newOp.add(c);
            } else {
                String operand = "";
                while (i < s.length() && Character.isDigit(s.charAt(i)))
                    operand += s.charAt(i++);
                --i;
                st.add(Double.parseDouble(operand));
                newOp.add(Double.parseDouble(operand));
            }
        }
        while (!op.isEmpty())
            processOperator(st, op.removeLast());
            print();
        return st.get(0);
    }

    private double tempResult;

    public void memoryClear(ActionEvent actionEvent) {
        dataBaseSimpleCalculate.clearDataBase(Double.parseDouble(tempResult + ""));
    }

    public void mamorySave(ActionEvent actionEvent) {
        String s = display.getText();
        dataBaseSimpleCalculate.addDataBase(s , eval(s));
        tempResult = Double.parseDouble(display.getText());
    }

    public void mPlus(ActionEvent actionEvent) {
        dataBaseSimpleCalculate.addDataBase(display.getText() , tempResult + Double.parseDouble(display.getText()));
    }

    public void mMinus(ActionEvent actionEvent) {
        dataBaseSimpleCalculate.addDataBase(display.getText() , tempResult - Double.parseDouble(display.getText()));
    }
}
