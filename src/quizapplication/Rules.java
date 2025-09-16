package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame implements ActionListener {
	
	String name;
	JButton start,back;
	
     Rules(String name) {
		
    	 this.name = name;
    	 getContentPane().setBackground(Color.white);
    	 setLayout(null);
    	 
    	JLabel heading = new JLabel("Welcome "+ name + " to KBT");
 		heading.setBounds(50,20,700,30);
 		heading.setFont(new Font("Viner Hand ITC", Font.BOLD,24));
 		heading.setForeground(new Color(143, 209, 79));
 		add(heading);
 		
 		JLabel rules = new JLabel();
 		rules.setBounds(20,90,700,350);
 		rules.setFont(new Font("Roboto", Font.PLAIN,16));
 		rules.setText(
 				"<html>"+ 
 		                
 		                "1. Users must log in with their name to start the quiz." + "<br><br>" +
 		                "2.Each question will have four options , Users must select only one option as the answer. " + "<br><br>" +
 		                "3. Each question will have a time limit of 20 seconds." +"<br><br>"+
 		                "4. Each correct answer will be awarded 1 point." + "<br>" +"Incorrect answers and unanswered questions will not be awarded any points."+"<br><br>"+
 		                "5. Users will have access to four lifelines as (50-50,guess the answer,get a clue,stop timer) , will have to use them accordingly." + "<br><br>" +
 		                "6. Lifelines can be used only once per quiz." + "<br><br>" +
 		                "7. Once all 10 questions are answered or the time for a question expires, the quiz will end. User's final score will be displayed at end" + "<br><br>" +
 		            "<html>"
 				);
 		
 		add(rules);
 		
		
		back = new JButton("Back");
		back.setBounds(250,500,100,30);
		back.setBackground(new Color(0,0,0));
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		

 		start = new JButton("start");
		start.setBounds(400,500, 100,30);
		start.setBackground(new Color(0,0,0));
		start.setForeground(Color.white);
		start.addActionListener(this);
		add(start);
 		
 		
    	 setSize(800,650);
    	 setLocation(350,100);
    	 setVisible(true);
	}
     
     public void actionPerformed(ActionEvent e)
     {
    	 if(e.getSource() == start) {
    		 setVisible(false);
			new quiz(name);
			
		 } else if (e.getSource()==back) {
			setVisible(false);
			new Login();
		}
     }
     
     public static void main(String[] args) {
 		new Rules("Player");
 	}

}