package de.hansen.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Kreis {
	private int x;
	private int y;
	
	private Color col;
	
	private int width = 30;
	
	private Canvas c;
	
	public Kreis(int xPos, int yPos, Color color, Canvas canvas) {
		setX(xPos);
		setY(yPos);
		setC(canvas);
		setCol(color);
	}
	
	public void paint() {
		Graphics g = getC().getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getC().getWidth(), getC().getHeight());
		g.setColor(getCol());
		g.fillOval(getX(), getY(), width, width);
	}
	
	public void koordinatenAktualisieren(char aktRichtung) {
		switch (aktRichtung) {
		case 'a':
			this.left();
			break;
		case 'd':
			this.right();
			break;
		case 'w':
			this.up();
			break;
		case 's':
			this.down();
			break;
		}
		this.paint();
	}
	
	public void down() {
		int i = getY() + 2;
		if (c.getHeight() <= i) {
			i = c.getHeight();
		}
		setY(i);
	}
	
	public void up() {
		int i = getY() - 2;
		if (0 >= i) {
			i = 0;
		}
		setY(i);
	}
	
	public void right() {
		int i = getX() + 2;
		if (c.getWidth() <= i) {
			i = c.getWidth();
		}
		setX(i);
	}
	
	public void left() {
		int i = getX() - 2;
		if (0 >= i) {
			i = 0;
		}
		setX(i);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getCol() {
		return col;
	}

	public void setCol(Color col) {
		this.col = col;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Canvas getC() {
		return c;
	}

	public void setC(Canvas c) {
		this.c = c;
	}
}
