package com.thom.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main /* implements  ActionListener*/ {
	
	private static Fenetre fen;
	
	public static void main(String[] args){
		fen = new Fenetre();
	}
//	
//	public void actionPerformed(ActionEvent e) {
//		if(e.getSource()==Fenetre.start) {
//			Fenetre.global.removeAll();
//			Fenetre.global.add(Fenetre.pan);
//			Fenetre.global.revalidate();
//			Fenetre.global.repaint();
//			fen.setPlay(true);
//			
//		}
//		if(e.getSource()==Fenetre.retour) {
//			Fenetre.global.removeAll();
//			Fenetre.global.add(Fenetre.menu);
//			Fenetre.global.revalidate();
//			Fenetre.global.repaint();
//			fen.setPlay(false);
//		}
//	}
	
}
