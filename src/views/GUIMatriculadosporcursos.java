package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextArea;

public class GUIMatriculadosporcursos extends JInternalFrame {

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
					GUIMatriculadosporcursos frame = new GUIMatriculadosporcursos();
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
	public GUIMatriculadosporcursos() {
		setTitle("Matriculados por cursos");
		setBounds(100, 100, 721, 423);
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 13, 681, 361);
		getContentPane().add(textArea);

	}

}
