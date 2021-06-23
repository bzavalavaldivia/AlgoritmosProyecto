package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class GUIMatriculasyRetiros extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMatriculasyRetiros frame = new GUIMatriculasyRetiros();
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
	public GUIMatriculasyRetiros() {
		setTitle("Matriculas y Retiros");
		setBounds(100, 100, 682, 338);
		getContentPane().setLayout(null);
		
		JLabel lblNroMatricula = new JLabel("Nro. de Matricula");
		lblNroMatricula.setBounds(12, 25, 98, 16);
		getContentPane().add(lblNroMatricula);
		
		textField = new JTextField();
		textField.setBounds(129, 22, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNroDeRetiro = new JLabel("Nro. de Retiro");
		lblNroDeRetiro.setBounds(12, 78, 98, 16);
		getContentPane().add(lblNroDeRetiro);
		
		textField_1 = new JTextField();
		textField_1.setBounds(129, 75, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(500, 21, 97, 25);
		getContentPane().add(btnMostrar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 128, 642, 146);
		getContentPane().add(textArea);

	}

}
