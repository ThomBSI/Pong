package com.thom.game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Graphic extends JPanel {

	
	//Ball set
	private int posBX = 0;
	private int posBY = 0;
	private int diamBall = 20;
	
	//Left bloc position
	private int posLX = 0;
	private int posLY = 0;
	
	//Right bloc position
	private int posRX = 0;
	private int posRY = 0;
	
	//Blocs set
	private int widBloc = 30;
	private int heiBloc = 150;
	
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//Ball
		g.setColor(Color.BLACK);
		g.fillOval(posBX, posBY, diamBall, diamBall);
		
		//Left bloc
		g.setColor(Color.BLACK);
		g.fillRect(posLX, posLY, widBloc, heiBloc);
		
		//right bloc
		g.setColor(Color.BLACK);
		g.fillRect(posRX, posRY, widBloc, heiBloc);
		
	}

	public int getPosBX() {
		return posBX;
	}

	public void setPosBX(int posBX) {
		this.posBX = posBX;
	}

	public int getPosBY() {
		return posBY;
	}

	public void setPosBY(int posBY) {
		this.posBY = posBY;
	}

	public int getPosLX() {
		return posLX;
	}

	public void setPosLX(int posLX) {
		this.posLX = posLX;
	}

	public int getPosLY() {
		return posLY;
	}

	public void setPosLY(int posLY) {
		this.posLY = posLY;
	}

	public int getPosRX() {
		return posRX;
	}

	public void setPosRX(int posRX) {
		this.posRX = posRX;
	}

	public int getPosRY() {
		return posRY;
	}

	public void setPosRY(int posRY) {
		this.posRY = posRY;
	}

	public int getDiamBall() {
		return diamBall;
	}

	public void setDiamBall(int diamBall) {
		this.diamBall = diamBall;
	}

	public int getWidBloc() {
		return widBloc;
	}

	public void setWidBloc(int witBloc) {
		this.widBloc = witBloc;
	}

	public int getHeiBloc() {
		return heiBloc;
	}

	public void setHeiBloc(int heiBloc) {
		this.heiBloc = heiBloc;
	}
	
	
	
}
