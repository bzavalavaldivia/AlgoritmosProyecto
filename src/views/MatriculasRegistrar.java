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
import arrays.ArregloCursos;
import arrays.ArregloMatriculas;
import models.Matricula;
import utils.ComboItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class MatriculasRegistrar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

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
	@SuppressWarnings({"rawtypes", "unchecked"})
	public MatriculasRegistrar(ArregloMatriculas am) {
		setBounds(100, 100, 350, 225);
		setTitle("Registrar Matr\u00EDcula");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCodAlumno = new JLabel("C\u00D3D. ALUMNO");
		lblCodAlumno.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblCodAlumno.setBounds(10, 10, 96, 13);
		contentPanel.add(lblCodAlumno);
		
		JComboBox cboCodAlumno = new JComboBox();
		cboCodAlumno.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		ArregloAlumnos aa = new ArregloAlumnos();
		for (int i = 0; i < aa.tamaño(); i++) {
			cboCodAlumno.addItem(new ComboItem(aa.obtener(i).getNombres() + " " + aa.obtener(i).getApellidos(), aa.obtener(i).getCodAlumno() + ""));
		}
		
		cboCodAlumno.setBackground(Color.WHITE);
		cboCodAlumno.setBounds(10, 33, 316, 30);
		contentPanel.add(cboCodAlumno);
		
		JLabel lblCodCurso = new JLabel("C\u00D3D. CURSO");
		lblCodCurso.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblCodCurso.setBounds(10, 73, 96, 13);
		contentPanel.add(lblCodCurso);
		
		JComboBox cboCodCurso = new JComboBox();
		cboCodCurso.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		ArregloCursos ac = new ArregloCursos();
		for (int i = 0; i < ac.tamaño(); i++) {
			cboCodCurso.addItem(new ComboItem(ac.obtener(i).getAsignatura(), ac.obtener(i).getCodCurso() + ""));
		}
		
		cboCodCurso.setBackground(new Color(255, 255, 255));
		cboCodCurso.setBounds(10, 96, 316, 30);
		contentPanel.add(cboCodCurso);
		
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
						int numMatricula = am.codigoCorrelativo();
						Object itemCboCodAlumno = cboCodAlumno.getSelectedItem();
						int codAlumno = Integer.parseInt(((ComboItem)itemCboCodAlumno).getValue());
						Object itemCboCodCurso = cboCodCurso.getSelectedItem();
						int codCurso = Integer.parseInt(((ComboItem)itemCboCodCurso).getValue());
						String fecha = "16/06/2021";
						String hora = "10:30";
						
						Matricula matriculaRegistrada = new Matricula(numMatricula, codAlumno, codCurso, fecha, hora);
						
						am.adicionar(matriculaRegistrada);
						
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
