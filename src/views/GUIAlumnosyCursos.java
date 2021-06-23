package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class GUIAlumnosyCursos extends JInternalFrame {
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
					GUIAlumnosyCursos frame = new GUIAlumnosyCursos();
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
	public GUIAlumnosyCursos() {
		setTitle("Alumnos y cursos");
		setBounds(100, 100, 782, 378);
		getContentPane().setLayout(null);
		
		JLabel lblCodigoDeAlumno = new JLabel("Codigo de Alumno");
		lblCodigoDeAlumno.setBounds(12, 32, 127, 16);
		getContentPane().add(lblCodigoDeAlumno);
		
		textField = new JTextField();
		textField.setBounds(151, 29, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCodigoDeCurso = new JLabel("Codigo de Curso");
		lblCodigoDeCurso.setBounds(12, 78, 127, 16);
		getContentPane().add(lblCodigoDeCurso);
		
		textField_1 = new JTextField();
		textField_1.setBounds(151, 75, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(12, 127, 744, 161);
		getContentPane().add(textArea_1);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(575, 23, 97, 25);
		getContentPane().add(btnMostrar);

	}

}
