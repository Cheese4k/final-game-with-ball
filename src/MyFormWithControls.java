import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// ################ код ниже вам интересен ##################
class MyFormWithControls extends JFrame implements ActionListener {

    int attemptsCount = 0;

    // запуск программы
    public static void main(String[] args) throws Exception {
        MyFormWithControls f = new MyFormWithControls();
    }

    // действие по кнопке - здесь вы будете писать код
    public void actionPerformed(ActionEvent e) {
        String answer = field1.getText(); // то, что пользователь ввел в первое текстовое поле
        String correctAnswer = "Kotlin"; // наш предполагаемый секретный ответ на вопрос
        String result; // текст, который мы покажем пользователю

        if (attemptsCount == 5) {
            result = "Все попытки исчерпаны, перезапустите программу";
        } else {
            if (answer.equalsIgnoreCase(correctAnswer)) { // сравнение независимо от регистра - Россия, россия, РоСсИя
                result = "Поздравляем! Правильный ответ";
            } else {
                attemptsCount = attemptsCount + 1; // увеличиваем счетчик попыток
                result = "Неверно, у вас осталось " + (5 - attemptsCount) + "    попыток";
            }
        }

        resadd.setText(String.valueOf(attemptsCount)); // выводим счетчик попыток направо
        res.setText(result); // выводим результат вниз
    }



    // ################ код ниже пока не трогаем. Только если вы уже чувствуете свою Силу :) ##################

    private int parseNum(String enteredText1) {
        try {
            return Integer.parseInt(enteredText1);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private JTextField field1;
    private JTextField field2;
    private JButton left;
    private JButton right;
    private JLabel res;
    private JTextArea resadd;

    public MyFormWithControls() {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Components of the Form
        Container c = getContentPane();
        c.setLayout(null);

        JLabel title = new JLabel("Какой язык программирования лучший в мире?");
        title.setFont(new Font("Arial", Font.PLAIN, 12));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        JLabel name = new JLabel("Ввод 1");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        field1 = new JTextField();
        field1.setFont(new Font("Arial", Font.PLAIN, 15));
        field1.setSize(190, 20);
        field1.setLocation(200, 100);
        c.add(field1);

        JLabel name2 = new JLabel("Ввод 2");
        name2.setFont(new Font("Arial", Font.PLAIN, 20));
        name2.setSize(100, 20);
        name2.setLocation(100, 200);
        c.add(name2);

        field2 = new JTextField();
        field2.setFont(new Font("Arial", Font.PLAIN, 15));
        field2.setSize(190, 20);
        field2.setLocation(200, 200);
        c.add(field2);

        left = new JButton("Левой");
        left.setFont(new Font("Arial", Font.PLAIN, 17));
        left.setSize(100, 20);
        left.setLocation(150, 450);
        left.addActionListener(this);
        c.add(left);

        right = new JButton("Правой");
        right.setFont(new Font("Arial", Font.PLAIN, 15));
        right.setSize(100, 20);
        right.setLocation(270, 450);
        right.addActionListener(this);
        c.add(right);

        JTextArea tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(false);
        resadd.setRows(100);
        c.add(resadd);

        setVisible(true);
    }
}