package quizapplication;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class score extends JFrame implements ActionListener{
	
	JLabel heading,skore;
	JButton submit;

	public score(String name , int score ) {
		
		setBounds(400,150,750,550);
		getContentPane().setBackground(Color.white);
		setLayout(null);
		

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pics/quiz.jpg"));
		Image i2 = i1.getImage().getScaledInstance(300,250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,200,300,250);
		add(image);
		
	    heading = new JLabel("Thank You "+name+" for playing Quiz Masters");
		heading.setBounds(45,30,700 ,30);
		heading.setFont(new Font("Viner Hand ITC", Font.PLAIN,26));
		add(heading);
		
		 skore = new JLabel("Your score is "+score);
		 skore.setBounds(350,200,300 ,30);
		 skore.setFont(new Font("Tahoma", Font.PLAIN,26));
		 add(skore);
		 

			submit =  new JButton("Submit");
			submit.setBounds(380,270,120,30);
			submit.setBackground(new Color(30,144,255));
			submit.setForeground(Color.white);
			submit.addActionListener(this);
            add(submit);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		setVisible(false);
		new Login();
	}
	
	public static void main(String[] args) {
		new score("user",0);
	}
}
