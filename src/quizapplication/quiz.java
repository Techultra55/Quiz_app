package quizapplication;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String user_answers[][] = new String[10][1];
    String clues[] = new String[10]; // Array to store clues for each question

    JLabel qno, question, clueLabel;
    ButtonGroup groupopt;
    JButton next, submit, lifeline, clueButton, stopTimerButton,guessAnswerButton;
    JRadioButton opt1, opt2, opt3, opt4;
    
    public static int Timer = 20;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
    boolean timerStopped = false; // Flag for "Stop Timer" lifeline
    String name;

    quiz(String name) {
        this.name = name;
        setBounds(0, 0, 1520, 1000);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pics/kio.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1520, 329);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 450, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 450, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);

        // Define questions, answers, and clues
        questions[0][0] = "Which is used to find and fix bugs in the Java programs?";
        questions[0][1] = "JVM";
        questions[0][2] = "JDB";
        questions[0][3] = "JDK";
        questions[0][4] = "JRE";
        clues[0] = "It's a debugger tool for Java.";

        questions[1][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[1][1] = "int";
        questions[1][2] = "Object";
        questions[1][3] = "long";
        questions[1][4] = "void";
        clues[1] = "Think about the unique ID.";
        
        questions[2][0] = "Which package contains the Random class?";
        questions[2][1] = "java.util package";
        questions[2][2] = "java.lang package";
        questions[2][3] = "java.awt package";
        questions[2][4] = "java.io package";
        clues[2] = "Think about the unique ID.";

        questions[3][0] = "An interface with no fields or methods is known as?";
        questions[3][1] = "Runnable Interface";
        questions[3][2] = "Abstract Interface";
        questions[3][3] = "Marker Interface";
        questions[3][4] = "CharSequence Interface";
        clues[3] = "Think about the unique ID.";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";
        clues[4] = "Think about the unique ID.";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";
        clues[5] = "Think about the unique ID.";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";
        clues[6] = "Think about the unique ID.";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";
        clues[7] = "Think about the unique ID.";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";
        clues[8] = "Think about the unique ID.";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";
        clues[9] = "Think about the unique ID.";


        
       

        // (Continue initializing questions, answers, and clues for all entries...)

        answers[0][1] = "JDB";
        answers[1][1] = "int";
        answers[2][1] = "java.util package";
        answers[3][1] = "Marker Interface";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
        
        // (Continue initializing answers...)

        opt1 = new JRadioButton();
        opt1.setBounds(170, 520, 700, 30);
        opt1.setBackground(Color.white);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 560, 700, 30);
        opt2.setBackground(Color.white);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 600, 700, 30);
        opt3.setBackground(Color.white);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 640, 700, 30);
        opt4.setBackground(Color.white);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        groupopt = new ButtonGroup();
        groupopt.add(opt1);
        groupopt.add(opt2);
        groupopt.add(opt3);
        groupopt.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 400, 200, 50);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(30, 144, 255));
        next.addActionListener(this);
        next.setForeground(Color.white);
        add(next);

        lifeline = new JButton("50-50 lifeline");
        lifeline.setBounds(1100, 550, 200, 50);
        lifeline.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lifeline.setBackground(new Color(30, 144, 255));
        lifeline.addActionListener(this);
        lifeline.setForeground(Color.white);
        add(lifeline);

        submit = new JButton("Submit");
        submit.setBounds(800, 710, 200, 50);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(30, 144, 255));
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        guessAnswerButton = new JButton("Guess Answer");
        guessAnswerButton.setBounds(1100, 470, 200, 50);
        guessAnswerButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        guessAnswerButton.setBackground(new Color(30, 144, 255));
        guessAnswerButton.setForeground(Color.white);
        guessAnswerButton.addActionListener(this);
        add(guessAnswerButton);


        // Add "Get a Clue" button
        clueButton = new JButton("Get a Clue");
        clueButton.setBounds(1100, 630, 200, 50);
        clueButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        clueButton.setBackground(new Color(30, 144, 255));
        clueButton.setForeground(Color.white);
        clueButton.addActionListener(this);
        add(clueButton);

        // Add "Stop Timer" button
        stopTimerButton = new JButton("Stop Timer");
        stopTimerButton.setBounds(1100, 710, 200, 50);
        stopTimerButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        stopTimerButton.setBackground(new Color(30, 144, 255));
        stopTimerButton.setForeground(Color.white);
        stopTimerButton.addActionListener(this);
        add(stopTimerButton);
        
        

        // Label to display clue
        clueLabel = new JLabel();
        clueLabel.setBounds(100, 680, 900, 30);
        clueLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        clueLabel.setForeground(Color.red);
        add(clueLabel);

        start(count);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == next) {
            repaint();
            ans_given = 1;
            if (groupopt.getSelection() == null) {
                user_answers[count][0] = "";
            } else {
                user_answers[count][0] = groupopt.getSelection().getActionCommand();
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            start(count);
        } else if (e.getSource() == lifeline) {
            if (count == 2 || count == 4 || count == 6 || count == 8) {
                opt2.setEnabled(false);
                opt3.setEnabled(false);
            } else {
                opt1.setEnabled(false);
                opt4.setEnabled(false);
            }
            lifeline.setEnabled(false);
        } else if (e.getSource() == clueButton) {
            clueLabel.setText("Clue: " + clues[count]);
            clueButton.setEnabled(false);
        } else if (e.getSource() == stopTimerButton) {
            timerStopped = true;
            stopTimerButton.setEnabled(false);
        }else if (e.getSource() == guessAnswerButton) {
            guessAnswerButton.setEnabled(false);
            String correctAnswer = answers[count][1];
            if (!opt1.getText().equals(correctAnswer)) opt1.setEnabled(false);
            if (!opt2.getText().equals(correctAnswer)) opt2.setEnabled(false);
            if (!opt3.getText().equals(correctAnswer)) opt3.setEnabled(false);
            if (!opt4.getText().equals(correctAnswer)) opt4.setEnabled(false);
        }  else {
            ans_given = 1;
            if (groupopt.getSelection() == null) {
                user_answers[count][0] = "";
            } else {
                user_answers[count][0] = groupopt.getSelection().getActionCommand();
            }
            for (int i = 0; i < user_answers.length; i++) {
                if (user_answers[i][0].equals(answers[i][1])) {
                    score += 10;
                }
            }
            setVisible(false);
            new score(name, score);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        String time = "Time left - " + Timer + " seconds";
        g.setColor(Color.red);
        g.setFont(new Font("Tahoma", Font.BOLD, 25));

        if (!timerStopped) {
            if (Timer > 0) {
                g.drawString(time, 1100, 400);
            } else {
                g.drawString("Times UP!!", 1100, 400);
            }
            Timer--;
        } else {
            g.drawString("Timer Stopped", 1100, 400);
        }

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ans_given == 1) {
            ans_given = 0;
            Timer = 20;
            timerStopped = false;
        } else if (Timer < 0) {
            Timer = 20;
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {
                if (groupopt.getSelection() == null) {
                    user_answers[count][0] = "";
                } else {
                    user_answers[count][0] = groupopt.getSelection().getActionCommand();
                }
                for (int i = 0; i < user_answers.length; i++) {
                    if (user_answers[i][0].equals(answers[i][1])) {
                        score += 10;
                    }
                }
                setVisible(false);
                new score(name, score);
            } else {
                if (groupopt.getSelection() == null) {
                    user_answers[count][0] = "";
                } else {
                    user_answers[count][0] = groupopt.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }
    }

    public void start(int count) {
    	opt1.setEnabled(true);
        opt2.setEnabled(true);
        opt3.setEnabled(true);
        opt4.setEnabled(true);
        
        qno.setText("" + (count + 1) + ". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);
        groupopt.clearSelection();
        clueLabel.setText(""); // Reset clue label when question changes
    }

    public static void main(String[] args) {
        new quiz("User");
    }
}
