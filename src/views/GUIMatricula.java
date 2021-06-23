package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class GUIMatricula extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMatricula frame = new GUIMatricula();
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
	public GUIMatricula() {
		setTitle("Matricula");
		setBounds(100, 100, 713, 518);
		getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(12, 25, 56, 16);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(93, 22, 116, 22);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblFechaYHora = new JLabel("Fecha y hora");
		lblFechaYHora.setBounds(12, 80, 74, 16);
		getContentPane().add(lblFechaYHora);
		
		textField = new JTextField();
		textField.setBounds(93, 77, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnGenerar = new JButton("Generar");
		btnGenerar.setBounds(238, 131, 97, 25);
		getContentPane().add(btnGenerar);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(12, 135, 56, 16);
		getContentPane().add(lblEstado);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 207, 673, 262);
		getContentPane().add(textArea);
		
		JButton btnCamniarCurso = new JButton("Camniar curso");
		btnCamniarCurso.setBounds(505, 21, 127, 25);
		getContentPane().add(btnCamniarCurso);
		
		JButton btnCancelarMatricula = new JButton("Cancelar Matricula");
		btnCancelarMatricula.setBounds(505, 76, 127, 25);
		getContentPane().add(btnCancelarMatricula);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(520, 131, 97, 25);
		getContentPane().add(btnGrabar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(97, 132, 112, 22);
		getContentPane().add(comboBox);

	}
}
