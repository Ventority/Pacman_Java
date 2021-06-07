package de.hansen.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Kreis_Game extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JLabel titleLB = new JLabel("Wilkommen zum Kreis Game...");
	Canvas canvas = new Canvas();
	Kreis k = new Kreis(10, 10, Color.CYAN, canvas);
	
	char aktRichtung = 'a';
	
	Timer t = new Timer(100, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			k.koordinatenAktualisieren(aktRichtung);
		}
	}) {
		private static final long serialVersionUID = 1L;
	};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kreis_Game frame = new Kreis_Game();
					frame.setVisible(true);
					frame.ini();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Kreis_Game() {
		setTitle("Kreis Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 714);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		titleLB.setBounds(30, 23, 608, 52);
		contentPane.add(titleLB);
		
		canvas.setBackground(Color.BLACK);
		canvas.setBounds(30, 81, 775, 568);
		contentPane.add(canvas);
		
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				k.koordinatenAktualisieren(arg0.getKeyChar());
				aktRichtung = arg0.getKeyChar();
			}
		});
	}
	void ini() {
		t.start();
	}
}
