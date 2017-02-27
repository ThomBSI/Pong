package com.thom.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Fenetre extends JFrame implements KeyListener {


	
	private Graphic graph;
	static JPanel global;
	static JPanel pan;
	private JPanel terrain;
	private JPanel barre;
	private JLabel scoreL = new JLabel("0");
	private JLabel scoreR = new JLabel("0");
	private int cmtL = 0;
	private int cmtR = 0;
	private int sens = 70;
	private int speed = 1;
	static JButton start = new JButton("Nouvelle partie");
	private boolean play = false;

	

//------------------------------------------------------------------------------------
	
	public Fenetre() {
		this.setSize(new Dimension(1100,700));
		this.setTitle("Pong !!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		graph = new Graphic();
		
		//ball default position
		graph.setPosBX(this.getWidth()/2);
		graph.setPosBY((this.getHeight()/2));
	
		//left bloc default position
		graph.setPosLX(50);
		graph.setPosLY((this.getHeight()/2)-(graph.getHeiBloc()/2));
		
		//right bloc default position
		graph.setPosRX((this.getWidth())-(50+graph.getWidBloc()));
		graph.setPosRY((this.getHeight()/2)-(graph.getHeiBloc()/2));
		
		graph.repaint();
		
		terrain = new JPanel();
		terrain.setLayout(new BorderLayout());
		terrain.add(graph, BorderLayout.CENTER);
		
		barre = new JPanel();
		barre.setLayout(new BorderLayout());
		Font police = new Font("Arial", Font.BOLD, 30);
		scoreL.setFont(police);
		scoreR.setFont(police);
		barre.add(scoreL, BorderLayout.WEST);
		barre.add(scoreR, BorderLayout.EAST);
		
		//écran de jeu
		pan = new JPanel();
		pan.setLayout(new BorderLayout());
		pan.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
		pan.add(terrain, BorderLayout.CENTER);
		pan.add(barre, BorderLayout.NORTH);
		
		//écoute évenements clavier
		this.addKeyListener(this);
		
		this.setContentPane(pan);
		this.setVisible(true);
		
		go();
		
	}
	

//------------------------------------------------------------------------------------
	
	private void go(){
		int x = graph.getPosBX(), y = graph.getPosBY();
		boolean moveX = true, moveY = true;
		
		while(true) {
		
				
				//Rebond bloc gauche
				if(x<graph.getPosLX()+graph.getWidBloc()) {
					if(y+(graph.getDiamBall()/2)>graph.getPosLY() && y+(graph.getDiamBall()/2)<graph.getPosLY()+graph.getHeiBloc()) {
						moveX = true;
					}
				}
				
				//Rebond bloc droit
				if(x+graph.getDiamBall()>graph.getPosRX()) {
					if(y+(graph.getDiamBall()/2)>graph.getPosRY() && y+(graph.getDiamBall()/2)<graph.getPosRY()+graph.getHeiBloc()) {
						moveX = false;
					}
				}
				
				//rebond murs
				if(x<1) {
					cmtR++;
					scoreR.setText(""+cmtR);
					moveX = true;
				}
				if(x+graph.getDiamBall()>graph.getWidth()) {;
					cmtL++;
					scoreL.setText(""+cmtL);
					moveX = false;
				}
				if(y<1) {
					moveY = true;
				}
				if(y+graph.getDiamBall()>graph.getHeight()) {
					moveY = false;
				}
				
				//incrémentations
				if(moveX) {
					graph.setPosBX(x++);
				} else {
					graph.setPosBX(x--);
				}
				if(moveY) {
					graph.setPosBY(y++);
				} else {
					graph.setPosBY(y--);
				}
				
				graph.repaint();
				
				try{
					Thread.sleep(speed);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
		}
	}
	
	public void keyPressed(KeyEvent e) {
		//Mouvements bloc gauche
		//haut
		if(e.getKeyCode()==65) {
			graph.setPosLY(graph.getPosLY()-sens);
		}
		//bas
		if(e.getKeyCode()==81) {
			graph.setPosLY(graph.getPosLY()+sens);
		}
		//Mouvement bloc droit
		//haut
		if(e.getKeyCode()==80) {
			graph.setPosRY(graph.getPosRY()-sens);
		}
		//bas
		if(e.getKeyCode()==77) {
			graph.setPosRY(graph.getPosRY()+sens);
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	
	
}
