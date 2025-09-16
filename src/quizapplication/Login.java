package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JButton rules, back;
    JTextField tfname;

    Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pics/OIP.jpeg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 600, 500);
        add(image);

        JLabel heading = new JLabel("Quiz Masters");
        heading.setBounds(810, 60, 300, 45);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 24));
        heading.setForeground(new Color(143, 209, 79));
        add(heading);

        JLabel name = new JLabel("Enter Your Name");
        name.setBounds(800, 150, 300, 20);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
        name.setForeground(new Color(0, 0, 0));
        add(name);

        tfname = new JTextField();
        tfname.setBounds(735, 200, 300, 25);
        tfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tfname);
        
        // Add an action listener to tfname to listen for Enter key press
        tfname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moveToNextPage();
            }
        });

        rules = new JButton("Next");
        rules.setBounds(735, 270, 120, 25);
        rules.setBackground(new Color(0, 0, 0));
        rules.setForeground(Color.white);
        rules.addActionListener(this);
        add(rules);

        back = new JButton("Back");
        back.setBounds(915, 270, 120, 25);
        back.setBackground(new Color(0, 0, 0));
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setSize(1200, 500);
        setLocation(200, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == rules) {
            moveToNextPage();
        } else if (e.getSource() == back) {
            setVisible(false);
        }
    }

    private void moveToNextPage() {
        String name = tfname.getText();
        if (name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter your name before proceeding.");
        } else {
            setVisible(false);
            new Rules(name);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
