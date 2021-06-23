package views;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class GUIAlumnoOId extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JLabel lblEdad;
	private JTextField txtEdad;
	private JTextArea textArea;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIAlumnoOId frame = new GUIAlumnoOId();
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
	public GUIAlumnoOId() {
		setTitle("Alumno");
		setBounds(100, 100, 742, 564);
		getContentPane().setLayout(null);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(12, 44, 56, 16);
		getContentPane().add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(80, 41, 116, 22);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(12, 89, 56, 16);
		getContentPane().add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(80, 86, 116, 22);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(12, 138, 56, 16);
		getContentPane().add(lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(80, 135, 116, 22);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		lblEdad = new JLabel("Edad");
		lblEdad.setBounds(261, 44, 56, 16);
		getContentPane().add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setBounds(300, 41, 116, 22);
		getContentPane().add(txtEdad);
		txtEdad.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(12, 197, 702, 318);
		getContentPane().add(textArea);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(547, 40, 97, 25);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(547, 85, 97, 25);
		getContentPane().add(btnEliminar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setBounds(547, 134, 97, 25);
		getContentPane().add(btnGrabar);

	}
}
