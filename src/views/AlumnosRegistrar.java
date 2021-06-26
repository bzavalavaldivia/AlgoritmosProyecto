package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arrays.ArregloAlumnos;
import models.Alumno;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class AlumnosRegistrar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtDni;
	private JTextField txtEdad;
	private JTextField txtCelular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			AlumnosRegistrar dialog = new AlumnosRegistrar();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({"rawtypes"})
	public AlumnosRegistrar(ArregloAlumnos aa) {
		setBounds(100, 100, 350, 425);
		setTitle("Registrar Alumno");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombres = new JLabel("NOMBRES");
		lblNombres.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNombres.setBounds(10, 10, 96, 13);
		contentPanel.add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtNombres.setBounds(10, 33, 316, 30);
		contentPanel.add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblApellidos.setBounds(10, 73, 96, 13);
		contentPanel.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(10, 96, 316, 30);
		contentPanel.add(txtApellidos);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblDni.setBounds(10, 136, 96, 13);
		contentPanel.add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtDni.setColumns(10);
		txtDni.setBounds(10, 159, 316, 30);
		contentPanel.add(txtDni);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEdad.setBounds(10, 199, 96, 13);
		contentPanel.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtEdad.setColumns(10);
		txtEdad.setBounds(10, 222, 316, 30);
		contentPanel.add(txtEdad);
		
		JLabel lblCelular = new JLabel("CELULAR");
		lblCelular.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblCelular.setBounds(10, 262, 96, 13);
		contentPanel.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtCelular.setColumns(10);
		txtCelular.setBounds(10, 285, 316, 30);
		contentPanel.add(txtCelular);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 325, 0, 0);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setFocusPainted(false);
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setFont(new Font("Roboto Light", Font.PLAIN, 16));
				okButton.setBorderPainted(false);
				okButton.setBackground(new Color(57, 73, 171));
				okButton.setActionCommand("Guardar");
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (validarCampos()) {
							int codAlumno = aa.codigoCorrelativo();
							String nombres = txtNombres.getText();
							String apellidos = txtApellidos.getText();
							String dni = txtDni.getText();
							int edad = Integer.parseInt(txtEdad.getText());
							int celular = Integer.parseInt(txtCelular.getText());
							int estado = 0;
							if (!aa.existeAlumnoDni(dni)) {
								Alumno alumnoRegistrado = new Alumno(codAlumno, nombres, apellidos, dni, edad, celular, estado);
								aa.adicionar(alumnoRegistrado);
								setVisible(false);
							} else {
								JOptionPane.showMessageDialog(null, "El campo DNI ya está en uso.");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
						}
					}
				});
				
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setFocusPainted(false);
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setFont(new Font("Roboto Light", Font.PLAIN, 16));
				cancelButton.setBorderPainted(false);
				cancelButton.setBackground(new Color(128, 128, 128));
				cancelButton.setActionCommand("Cancelar");
				
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private boolean validarCampos() {
		String nombres = txtNombres.getText();
		String apellidos = txtApellidos.getText();
		String dni = txtDni.getText();
		String edad = txtEdad.getText();
		String celular = txtCelular.getText();
		if (nombres.equals("") && apellidos.equals("") && dni.equals("") && edad.equals("") && celular.equals("")) {
			return false;
		}
		return true;
	}
}
