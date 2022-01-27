package Taschenrechner;

import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.*;


public class Rechnerfenster extends JFrame implements ActionListener{
	
	private boolean daten; 
	private String merk;  
	private char merk1;
	private double merk2;
	private JCheckBox check1 = new JCheckBox("Check 1");
	private JRadioButton rButton1 = new JRadioButton("Entwurmt");
	private JRadioButton rButton2 = new JRadioButton("");
	private ButtonGroup bgAuswahl = new ButtonGroup();
	private JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, senden, zuruecksetzen, operator1, operator2, operator3, operator4, operator5;
	private JPanel hauptPanel, northPanel, southPanel, westPanel, eastPanel, centerPanel;
	private JButton[] btnArray1 = new JButton[4];
	private JButton[] btnArray2 = new JButton[3];
	private JButton[] btnArray3 = new JButton[3];
	private JTextField eingabe;
	private JTextField ergebnisText;   //graf Elem
	private JLabel jl1 = new JLabel("Menü Tiere");
	private JLabel jl2 = new JLabel("Menü Kunden");
	private JLabel jl3 = new JLabel(" Mitarbeiter");
	
	public Rechnerfenster(String titel) {  //konstruktor              //noch in hilfsmethoden zu packen
		super(titel);
		
		this.setSize(500, 600);
		this.setVisible(true);
		
		//initialisieren();
		
		hauptPanel = new JPanel();   //neues Panel wird erzeugt
		northPanel = new JPanel();
		southPanel = new JPanel();
		westPanel = new JPanel();
		eastPanel = new JPanel();
		centerPanel = new JPanel();
				
		ergebnisText = new JTextField("");
		eingabe = new JTextField("");
		
		btn1 = new JButton(" 1");
		btn2 = new JButton(" 2");
		btn3 = new JButton(" 3");
		btn4 = new JButton(" 4");
		btn5 = new JButton(" 5");
		btn6 = new JButton(" 6");
		btn7 = new JButton(" 7");
		btn8 = new JButton(" 8");
		btn9 = new JButton(" 9");
		btn0 = new JButton(" 0");
		
		operator1 = new JButton("+");
		operator2 = new JButton("-");
		operator3 = new JButton("*");
		operator4 = new JButton("/");
		operator5 = new JButton("=");
		
		senden = new JButton("senden");
		zuruecksetzen = new JButton("zurücksetzen");
		
		for(int i = 0; i<btnArray1.length; i++) {
			btnArray1[i] = new JButton("Tiere " +i);
			}
		for(int i = 0; i<btnArray2.length; i++) {
			btnArray2[i] = new JButton("Kunden " +i);
			}
		for(int i = 0; i<btnArray3.length; i++) {
			btnArray3[i] = new JButton("MA " +i);
			}
		
		ergebnisText.setForeground(Color.WHITE);
		ergebnisText.setBackground(Color.BLACK);
		ergebnisText.setPreferredSize(new Dimension(10,10));
		eingabe.setPreferredSize(new Dimension(10,10));
		//hauptPanel.setLayout(new FlowLayout());   // flexibel/ passt sich an
		//hauptPanel.setLayout(new BoxLayout(hauptPanel, BoxLayout.Y_AXIS)); //y-achse
		//hauptPanel.setLayout(new BoxLayout(hauptPanel, BoxLayout.Y_AXIS));   x-achse
		hauptPanel.add(eingabe);
		//hauptPanel.setLayout(new GridLayout(5,5));    //raster
		hauptPanel.setLayout(new BorderLayout());
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
		northPanel.setLayout(new FlowLayout());         //weitere Panels
		southPanel.setLayout(new FlowLayout());
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		
		//zuordnen();
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
		btn9.addActionListener(this);
		btn0.addActionListener(this);
		
		operator1.addActionListener(this);
		operator2.addActionListener(this);
		operator3.addActionListener(this);
		operator4.addActionListener(this);
		operator5.addActionListener(this);
		
		senden.addActionListener(this);
		zuruecksetzen.addActionListener(this);
		
		bgAuswahl.add(rButton1);
		bgAuswahl.add(rButton2);
		
		northPanel.setBackground(Color.CYAN);
		eastPanel.setBackground(Color.YELLOW);
		westPanel.setBackground(Color.GREEN);
		southPanel.setBackground(Color.RED);
		centerPanel.setBackground(Color.PINK);
		
		centerPanel.add(eingabe);
		centerPanel.add(rButton1);
		centerPanel.add(rButton2);
		centerPanel.add(check1);
		centerPanel.add(ergebnisText);
		centerPanel.add(senden);
		centerPanel.add(zuruecksetzen);
		
		northPanel.add(btn1);
		northPanel.add(btn2);
		northPanel.add(btn3);
		northPanel.add(btn4);
		northPanel.add(btn5);
		northPanel.add(btn6);
		northPanel.add(btn7);
		northPanel.add(btn8);
		northPanel.add(btn9);
		northPanel.add(btn0);
		
		southPanel.add(operator1);
		southPanel.add(operator2);
		southPanel.add(operator3);
		southPanel.add(operator4);
		southPanel.add(operator5);
		
		westPanel.add(jl1);
		eastPanel.add(jl2);
		eastPanel.add(jl3);
		
		for(int i = 0; i<btnArray1.length; i++) {
			westPanel.add(btnArray1[i]);
		}
		for(int i = 0; i<btnArray2.length; i++) {
			eastPanel.add(btnArray2[i]);
		}
		for(int i = 0; i<btnArray3.length; i++) {
			eastPanel.add(btnArray3[i]);
		}
		
		hauptPanel.add(northPanel, BorderLayout.NORTH);
		hauptPanel.add(southPanel, BorderLayout.SOUTH);
		hauptPanel.add(westPanel, BorderLayout.WEST);
		hauptPanel.add(eastPanel, BorderLayout.EAST);
		hauptPanel.add(centerPanel, BorderLayout.CENTER);
	
		this.add(hauptPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);           //oder von ausserhalb: hauptpanel.add(hauptpanel);
		this.setVisible(true);
		
		
	}
	
//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource() == this.btn1) {
//			ergebnisText.setText("Knopf 1");
//			ergebnisText.setBackground(Color.blue);
//			if (check1.isSelected()) {
//		}
//		} else if (e.getSource() == this.btn2) {
//			ergebnisText.setText("Knopf 2");
//			ergebnisText.setBackground(Color.red);		
//		}
//		
//	}
	
	public void actionPerformed(ActionEvent a) {
		
		if(a.getSource() == this.btn1) {
			ergebnisText.setText(ergebnisText.getText() + "1");
			//ergebnisText.setBackground(Color.);
		}
		else if(a.getSource() == this.btn2) {
			ergebnisText.setText(ergebnisText.getText() + "2");
		}
		if(a.getSource() == this.btn3) {
			ergebnisText.setText(ergebnisText.getText() + "3");
		}
		else if(a.getSource() == this.btn4) {
			ergebnisText.setText(ergebnisText.getText() + "4" );
		}
		if(a.getSource() == this.btn5) {
			ergebnisText.setText(ergebnisText.getText() + "5");
		}
		else if(a.getSource() == this.btn6) {
			ergebnisText.setText(ergebnisText.getText() + "6");
		}
		if(a.getSource() == this.btn7) {
			ergebnisText.setText(ergebnisText.getText() + "7");
		}
		else if(a.getSource() == this.btn8) {
			ergebnisText.setText(ergebnisText.getText() + "8");
		}
		if(a.getSource() == this.btn9) {
			ergebnisText.setText(ergebnisText.getText() + "9");
		}
		else if(a.getSource() == this.btn0) {
			ergebnisText.setText(ergebnisText.getText() + "0");
		}
		
		
		if(a.getSource() == this.operator1) {
			merk = ergebnisText.getText();                //zahl wird gespeichert
			merk1 =  '+';                          //operatoren werden gespeichert
			ergebnisText.setText("" );
		}
		else if(a.getSource() == this.operator2) {
			merk = ergebnisText.getText();
			merk1 =  '-';
			ergebnisText.setText("" );
		}
		else if(a.getSource() == this.operator3) {
			merk = ergebnisText.getText();
			merk1 =  '*';
			ergebnisText.setText("" );
		}
		else if(a.getSource() == this.operator4) {
			merk = ergebnisText.getText();
			merk1 =  '/';
			ergebnisText.setText("" );
		}
		else if(a.getSource() == this.operator5) {
			merk = ergebnisText.getText();
		}
	
	
		
		
			switch (merk1) {
				case '+':
					merk2 = Double.parseDouble(merk) + Double.parseDouble(ergebnisText.getText());   // typecasting von string zu double
					break;
					
				case '-':
					merk2 = Double.parseDouble(merk) - Double.parseDouble(ergebnisText.getText());
					break;
					
				case '*':
					merk2 = Double.parseDouble(merk) * Double.parseDouble(ergebnisText.getText());
				break;
				
				case '/':
					merk2 = Double.parseDouble(merk) / Double.parseDouble(ergebnisText.getText());
				break;
				
			}
			
		ergebnisText.setText(String.valueOf(merk2));
			
	

	
	
			if (a.getSource() == this.btnArray1[0]) {
				ergebnisText.setText("Geben Sie folgende Daten ein: Art, Rasse, Name");
				btnArray1[0].setText("Eingabe");
	
				if (a.getSource() == this.eingabe) {
					daten = false;
					daten = eingabe.getText() != null;
				}
				if (senden.isSelected()) {
					//ergebnisText.setText("Art: "+ getArt() + "Rasse: " + getRasse() "Name:" + getName() + " wurde erfolgreich hinzugefügt.");
				}
			}
		
			if (a.getSource() == this.btnArray1[1])	{
					ergebnisText.setText("");
					btnArray1[1].setText("Anzeigen");
				}
			else if (a.getSource() == this.btnArray1[2])	{
					ergebnisText.setText("");
					btnArray1[2].setText("Hinzufügen");
				}
			 if (a.getSource() == this.btnArray1[3])	{
					ergebnisText.setText("");
				}
			
		
			if (rButton1.isSelected()){
					//ergebnisText.setText("Art: "+ getArt() + "Rasse: " + getRasse() + "Name:" + getName() + " ist entwurmt.");
				}
			else {
					//ergebnisText.setText("Art: "+ getArt() + "Rasse: " + getRasse() + "Name:" + getName() + " ist nicht entwurmt.");
				}
	
			if (zuruecksetzen.isSelected()){
				}
				//  Text/ Eingabe löschen
				
			if (a.getSource()== this.senden) {
					ergebnisText.setText(ergebnisText.getText() + "senden");
				}
				else if(a.getSource()== this.zuruecksetzen) {
					ergebnisText.setText(ergebnisText.getText() + "zurücksetzen");
				}
				
		}
	}




		
	
		
	
	


