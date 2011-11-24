package Banksystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui {
	
	private JFrame frame = new JFrame("Bank");
	private Bank banken = new Bank();
	private Account konton;
	private JOptionPane pane = new JOptionPane();
	private JLabel l_text1, l_text2, l_text3, l_text4, l_text5;
	private JTextField tf_field1, tf_field2, tf_field3, tf_field4, tf_field5;
	private JButton b_button1, b_button2, b_button3, b_button4, b_button5, b_button6;
	private JPanel p_background, p_center, p_south, p_north, p_west, p_east;
	
	public Gui(){
		
		// H�r skapar jag objekt av allt som ska anv�ndas i framen!
		
		l_text1 = new JLabel("Namn");
		l_text2 = new JLabel("Kontonummer");
		l_text3 = new JLabel("Ins�ttning");
		l_text4 = new JLabel("Uttag");
		l_text5 = new JLabel("Saldo");
		
		tf_field1 = new JTextField();
		tf_field2 = new JTextField();
		tf_field3 = new JTextField();
		tf_field4 = new JTextField();
		tf_field5 = new JTextField();
		
		b_button1 = new JButton("Skapa Konto");
		b_button2 = new JButton("Ta bort Konto");
		b_button3 = new JButton("S�k");
		b_button4 = new JButton("Ta Ut");
		b_button5 = new JButton("S�tt in");
		b_button6 = new JButton("Rensa f�lt");
		
		// H�r skapar jag alla paneler!
		
		p_background = new JPanel();
		p_north = new JPanel();
		p_center = new JPanel();
		p_south = new JPanel();
		
		// H�r s�ttar jag vilket layoutmanager som panelerna ska anv�nda!
		
		p_background.setLayout(new BorderLayout());
		p_center.setLayout(new GridLayout(5, 2));
		p_south.setLayout(new GridLayout(2, 3));
		p_north.setLayout(new FlowLayout());
		
		// h�r l�gger jag in alla paneler i bakgrundspaneler (huvudpanelen)!
		
		p_background.add(p_north, BorderLayout.NORTH);
		p_background.add(p_center, BorderLayout.CENTER);
		p_background.add(p_south, BorderLayout.SOUTH);
		
		// h�r l�gger jag in alla komponenter i panelerna!
		
		p_center.add(l_text1);
		p_center.add(tf_field1);
		p_center.add(l_text2);
		p_center.add(tf_field2);
		p_center.add(l_text3);
		p_center.add(tf_field3);
		p_center.add(l_text4);
		p_center.add(tf_field4);
		p_center.add(l_text5);
		p_center.add(tf_field5);
		
		p_south.add(b_button1);
		p_south.add(b_button2);
		p_south.add(b_button3);
		p_south.add(b_button4);
		p_south.add(b_button5);
		p_south.add(b_button6);
		
		//ActionListeners
		
		b_button1.addActionListener(new ActionListener()  //skapa
		{  
		   public void actionPerformed(ActionEvent e)  
		   {  
			   String name = tf_field1.getText();
			   double insattning = 0;
			   
			   if(tf_field3.getText().isEmpty() == false){
				   insattning = Double.parseDouble(tf_field3.getText());
			   }
			   
			   Account a = null;
			   
			   if (name.isEmpty() == true){
				   a = new Account();
			   }
			   else if(name.isEmpty() == false && insattning == 0){
				   a = new Account(name);
			   }
			   else if(name.isEmpty() == false && insattning != 0){
				   a = new Account(name, insattning);
			   }
			   
			   banken.add(a);
			   JOptionPane.showMessageDialog(pane, "Grattis " + a.getHolder() + ", Ditt kontonmr: " + a.getAccnumb());
			   banken.print();
			   
		   }  
		});
		
		b_button2.addActionListener(new ActionListener()  //ta bort
		{  
		   public void actionPerformed(ActionEvent e)  
		   {  
			   int Kontonmr = Integer.parseInt(tf_field2.getText());
			   Account deleteAccount = banken.find(Kontonmr);
			   banken.remove(deleteAccount);
			   
			   
			   banken.print();
			  
		   }  
		}); 
		
		b_button3.addActionListener(new ActionListener()  //s�k
		{  
		   public void actionPerformed(ActionEvent e)  
		   {  
			   try{
				   int Kontonr = Integer.parseInt(tf_field2.getText());
				   Account findAccount = banken.find(Kontonr);
				   JOptionPane.showMessageDialog(pane,"Namn: " + findAccount.getHolder() + " Balans: " + findAccount.getBalance());
			   }
			   
			   catch(NumberFormatException e1){
				   JOptionPane.showMessageDialog(pane, "Du m�ste skriva in ett kontonummer!");
			   }
			   
			   catch(NullPointerException e2){
				   JOptionPane.showMessageDialog(pane, "Kontot finns inte!");
			   }
		   }  
		}); 
		
		b_button4.addActionListener(new ActionListener()  //ta ut
		{  
		   public void actionPerformed(ActionEvent e)  
		   {  
		      // do something for this button press  
		   }  
		}); 
		
		b_button5.addActionListener(new ActionListener()  //s�tt in
		{  
		   public void actionPerformed(ActionEvent e)  
		   {  
		      // do something for this button press  
		   }  
		}); 
		
		b_button6.addActionListener(new ActionListener()  //rensa f�lt
		{  
		   public void actionPerformed(ActionEvent e)  
		   {  
		      // do something for this button press  
		   }  
		}); 
		
		
		// �vriga viktiga inst�llningar!
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setContentPane(p_background);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
			
		}
	
	public static void main(String[] args){
		new Gui();
	}

}
