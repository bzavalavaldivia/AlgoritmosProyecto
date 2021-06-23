package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class GUICurso extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTextField txtAsignatura;
	private JTextField textField;
	private JTextField txtCreditos;
	private JTextField txtHoras;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICurso frame = new GUICurso();
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
	public GUICurso() {
		setTitle("Curso");
		setBounds(100, 100, 662, 522);
		getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(12, 28, 56, 16);
		getContentPane().add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(94, 25, 116, 22);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblAsignatura = new JLabel("Asignatura");
		lblAsignatura.setBounds(12, 63, 70, 16);
		getContentPane().add(lblAsignatura);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setBounds(94, 60, 116, 22);
		getContentPane().add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		JLabel lblCiclo = new JLabel("Ciclo");
		lblCiclo.setBounds(12, 98, 56, 16);
		getContentPane().add(lblCiclo);
		
		textField = new JTextField();
		textField.setBounds(94, 95, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNroDeCreditos = new JLabel("Nro. creditos");
		lblNroDeCreditos.setBounds(12, 133, 85, 16);
		getContentPane().add(lblNroDeCreditos);
		
		txtCreditos = new JTextField();
		txtCreditos.setBounds(94, 130, 116, 22);
		getContentPane().add(txtCreditos);
		txtCreditos.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Horas");
		lblNewLabel.setBounds(12, 171, 56, 16);
		getContentPane().add(lblNewLabel);
		
		txtHoras = new JTextField();
		txtHoras.setBounds(94, 168, 116, 22);
		getContentPane().add(txtHoras);
		txtHoras.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(12, 210, 607, 263);
		getContentPane().add(textArea);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(470, 24, 97, 25);
		getContentPane().add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(470, 89, 97, 25);
		getContentPane().add(btnEliminar);
		
		JButton btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(470, 162, 97, 25);
		getContentPane().add(btnGrabar);

	}

}
