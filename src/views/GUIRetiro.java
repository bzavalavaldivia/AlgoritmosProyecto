package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class GUIRetiro extends JInternalFrame {
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
					GUIRetiro frame = new GUIRetiro();
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
	public GUIRetiro() {
		setTitle("Retiro");
		setBounds(100, 100, 761, 488);
		getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(12, 27, 56, 16);
		getContentPane().add(lblCodigo);
		
		textField = new JTextField();
		textField.setBounds(94, 24, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora");
		lblFechaYHora.setBounds(12, 80, 88, 16);
		getContentPane().add(lblFechaYHora);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 77, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(12, 140, 56, 16);
		getContentPane().add(lblEstado);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(94, 137, 116, 22);
		getContentPane().add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 182, 721, 257);
		getContentPane().add(textArea);
		
		JButton btnCambiarCurso = new JButton("Cambiar curso");
		btnCambiarCurso.setBounds(564, 23, 136, 25);
		getContentPane().add(btnCambiarCurso);
		
		JButton btnCancelarRetiro = new JButton("Cancelar retiro");
		btnCancelarRetiro.setBounds(564, 76, 136, 25);
		getContentPane().add(btnCancelarRetiro);
		
		JButton btnGrabarCambios = new JButton("Grabar cambios");
		btnGrabarCambios.setBounds(564, 136, 136, 25);
		getContentPane().add(btnGrabarCambios);

	}

}
