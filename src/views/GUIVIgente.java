package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

public class GUIVIgente extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIVIgente frame = new GUIVIgente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIVIgente() {
		setTitle("Matricula Vigente");
		setBounds(100, 100, 660, 402);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 13, 620, 340);
		getContentPane().add(textArea);

	}

}
