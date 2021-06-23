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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AlumnosEditar extends JDialog {

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
	
	private Alumno alumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			AlumnosEditar dialog = new AlumnosEditar(new ArregloAlumnos(), 0);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AlumnosEditar(ArregloAlumnos aa, int idAlumno) {
		this.alumno = aa.obtener(idAlumno);
		setBounds(100, 100, 350, 475);
		setTitle("Editar Alumno - " + alumno.getCodAlumno());
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
		
		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblEstado.setBounds(10, 325, 96, 13);
		contentPanel.add(lblEstado);
		
		JComboBox cboEstado = new JComboBox();
		cboEstado.setEnabled(false);
		cboEstado.setFont(new Font("Roboto", Font.PLAIN, 14));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"REGISTRADO", "MATRICULADO", "RETIRADO"}));
		cboEstado.setBackground(new Color(255, 255, 255));
		cboEstado.setBounds(10, 348, 316, 30);
		contentPanel.add(cboEstado);
		
		txtNombres.setText(alumno.getNombres());
		txtApellidos.setText(alumno.getApellidos());
		txtDni.setText(alumno.getDni());
		txtEdad.setText(alumno.getEdad() + "");
		txtCelular.setText(alumno.getCelular() + "");
		cboEstado.setSelectedIndex(alumno.getEstado());
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar cambios");
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setFocusPainted(false);
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setFont(new Font("Roboto Light", Font.PLAIN, 16));
				okButton.setBorderPainted(false);
				okButton.setBackground(new Color(57, 73, 171));
				okButton.setActionCommand("Guardar");
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int codigo = alumno.getCodAlumno();
						String nombres = txtNombres.getText();
						String apellidos = txtApellidos.getText();
						String dni = txtDni.getText();
						int edad = Integer.parseInt(txtEdad.getText());
						int celular = Integer.parseInt(txtCelular.getText());
						int estado = cboEstado.getSelectedIndex();
						
						Alumno alumnoActualizado = new Alumno(codigo, nombres, apellidos, dni, edad, celular, estado);
						
						aa.editar(idAlumno, alumnoActualizado);
						
						setVisible(false);
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
}
