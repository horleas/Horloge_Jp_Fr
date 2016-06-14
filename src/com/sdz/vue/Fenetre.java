package com.sdz.vue;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sdz.model.Horloge;
import com.sdz.observer.Observateur;

@SuppressWarnings("serial")
public class Fenetre extends JFrame{
  private JLabel labelFrancehour = new JLabel();
  private JLabel labelFrance = new JLabel("Heure Française");
  private JLabel labelJapon = new JLabel("Heure Japonaise");
  private JLabel labelJaponhour = new JLabel();
  private Horloge horloge;
  int decalagehoraire = 7;
	
  public Fenetre(){
    //On initialise la JFrame
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
	this.setAlwaysOnTop(true);
    this.setResizable(false);
    this.setSize(200, 250);
    //On initialise l'horloge
    this.horloge = new Horloge();
    
    //Classe anonyme de implementant l'observateur et la redefinition de la méthode update
    this.horloge.addObservateur(new Observateur(){
    	@Override
    	public void update(String hour) {
    		labelFrancehour.setText(hour);
    		if(Integer.parseInt( hour.substring(0, 2)) + decalagehoraire >= 24){
    			labelJaponhour.setText(Integer.toString((Integer.parseInt( hour.substring(0, 2)))+decalagehoraire - 24) + hour.substring(2));
    		}
    		else{
    		labelJaponhour.setText(Integer.toString((Integer.parseInt( hour.substring(0, 2)))+decalagehoraire) + hour.substring(2));	
    		}
    	}	
    	
    });
    
    //On initialise le JLabel labelFrance
    Font police = new Font("Courrier", Font.BOLD, 20);
    this.labelFrance.setFont(police);
    this.labelFrance.setHorizontalAlignment(JLabel.CENTER);
    
    //On initialise le JLabel FranceHour
    Font policehour = new Font("Courrier", Font.BOLD, 30);
    this.labelFrancehour.setFont(policehour);
    this.labelFrancehour.setHorizontalAlignment(JLabel.CENTER);
    

    //On initialise le JLabel labelJapon
    this.labelJapon.setFont(police);
    this.labelJapon.setHorizontalAlignment(JLabel.CENTER);
    
    //On initialise le JLabel labelJaponhour
    this.labelJaponhour.setFont(policehour);
    this.labelJaponhour.setHorizontalAlignment(JLabel.CENTER);
    
    this.setLayout(new GridLayout(4,0));
    this.getContentPane().add(this.labelFrance);
    this.getContentPane().add(this.labelFrancehour);
    this.getContentPane().add(this.labelJapon);
    this.getContentPane().add(this.labelJaponhour);
    
    //On ajoute le JLabel à la JFrame
   // this.getContentPane().add(this.label, BorderLayout.CENTER);		
    this.setVisible(true);
    this.horloge.run();
  }

  //Méthode main() lançant le programme
  public static void main(String[] args){
    @SuppressWarnings("unused")
	Fenetre fen = new Fenetre();

  }

}