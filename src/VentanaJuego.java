import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaJuego extends JFrame{
	
	private static JButton bAcelera;
	private static JButton bFrena;
	private static JButton bGiraI;
	private static JButton bGiraD;
	private static JPanel pPanel;
	private JPanel pBotonera;
	private JPanelBackground fondo;
	private static Thread movimiento;
	private boolean sigue = true;

	
	
	public VentanaJuego() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 600);
		setTitle("VentanaJuego");
		setResizable(false);
		fondo = new JPanelBackground();
		fondo.setBackground("juego-de-las-carreras-de-coches-visto-desde-arriba-58985924 (2).jpg");
		pPanel = new JPanel();
		pBotonera = new JPanel();
		bAcelera = new JButton("Acelera");
		bFrena = new JButton("Frena");
		bGiraI = new JButton("Gira Izq.");
		bGiraD = new JButton("Gira Der.");
		pPanel.add(fondo);
		fondo.setLayout(new BorderLayout());
		pBotonera.add(bAcelera); pBotonera.add(bFrena); pBotonera.add(bGiraI); pBotonera.add(bGiraD);
		getContentPane().add(pBotonera, BorderLayout.SOUTH);
		getContentPane().add(fondo, BorderLayout.CENTER);
		fondo.setLayout(null);
		
		Coche coche = new  Coche(0, 100, 100, 100, "Unai");
		JLabelGraficoAjustado lcoche = new JLabelGraficoAjustado("coche.png", 100, 100);
		lcoche.setLocation(coche.getPosX(), coche.getPosY());
		fondo.add(lcoche);


		

		bAcelera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(-5);
			} 	
		});
		
		bFrena.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.acelera(5);
			}
		});
		
		bGiraI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(-0.2);
				lcoche.setRotacion(coche.getMiDireccionActual());
				pPanel.repaint();
			}
		});
	
		bGiraD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				coche.gira(0.2);
				lcoche.setRotacion(coche.getMiDireccionActual());
				pPanel.repaint();
			}
		});
		
		pPanel.setFocusable(false);
		pBotonera.setFocusable(false);
		bAcelera.setFocusable(false);
		bFrena.setFocusable(false);
		bGiraD.setFocusable(false);
		bGiraI.setFocusable(false);
		
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
					coche.gira(-0.2);
					lcoche.setRotacion(coche.getMiDireccionActual());
					pPanel.repaint();	
				}if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
					coche.gira(0.2);
					lcoche.setRotacion(coche.getMiDireccionActual());
					pPanel.repaint();
				}if(ke.getKeyCode() == KeyEvent.VK_UP) {
					coche.acelera(-5);
				}if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
					coche.acelera(5);
				}
				
			}
		});
		
	
	movimiento = new Thread() {
		public void run() {
			try {
				while(sigue) {
					
						coche.mueve();
						lcoche.setLocation(coche.getPosX(), coche.getPosY());
						pPanel.repaint();
						Thread.sleep(40);
						if(coche.getPosY()<= 0 || coche.getPosY() >= 450 || coche.getPosX() <= 0 || coche.getPosX() >= 700) {
							coche.gira(Math.PI);
							lcoche.setRotacion(coche.getMiDireccionActual());
							pPanel.repaint();
						}
				}
				
			}catch (Exception e) {
				
			}
		
		}
	};
	
	addWindowListener(new WindowAdapter() {
		@Override
		public void windowClosed(WindowEvent e) {
			sigue = false;
			
		}
	});
	
}

	public static void main(String[] args) {
		
		VentanaJuego p = new VentanaJuego();
		
		

		p.setVisible(true);
		p.setLocationRelativeTo(null);
		
		movimiento.start();
		
		
		
		
		
	}

}
