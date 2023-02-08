
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class UI {
    public static void main(String[] args) {
        createWindow();
    }

    private static void createWindow() {
        JFrame frame = new JFrame("Choose File");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createUI(frame);
        frame.setSize(560, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createUI(final JFrame frame) {
        JPanel panel = new JPanel();
        LayoutManager layout = new FlowLayout();
        panel.setLayout(layout);

        String filepath = JOptionPane.showInputDialog(
                frame,
                "Input path to file containing prospects",
                "Select a file",
                JOptionPane.PLAIN_MESSAGE
        );


        //JButton button = new JButton("Click Me!");


        Parser p = new Parser();



        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            JOptionPane.showMessageDialog(frame, createMessage(p.parse(reader)));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "File cannot be read");
        }

        //JTextField tf = new JTextField(c.calculateInterest(filepath));
        //JTextArea area=new JTextArea();

        //panel.add(button);
        //panel.add(area);
        //area.setFont(new Font("Serif", Font.PLAIN, 12));
        //area.setText(tf.getText());
        /*try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            area.setText(c.calculateInterest(reader));
        } catch (IOException e) {
            area.setText("Could not read file");
        } catch (NullPointerException ignored) {}*/

        frame.getContentPane().add(panel, BorderLayout.CENTER);
    }

    private static String createMessage(ArrayList<ArrayList<String>> prospects) {
        StringBuilder sb = new StringBuilder();
        Calculator c = new Calculator();

        int i = 1;
        for (ArrayList<String> l: prospects) {
            sb.append("Prospect ").append(i).append(": ").append(c.calculate(l)).append("\n");
        }

        return sb.toString();

    }
}
