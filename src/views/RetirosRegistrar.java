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
import arrays.ArregloRetiros;
import models.Alumno;
import models.Curso;
import models.Retiro;
import utils.ComboItem;
import utils.DateTime;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class RetirosRegistrar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private ArregloAlumnos aa = new ArregloAlumnos();
	private ArregloCursos ac = new ArregloCursos();
	private ArregloMatriculas am = new ArregloMatriculas();
	
	private DateTime dt = new DateTime();

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
	public RetirosRegistrar(ArregloRetiros ar) {
		setBounds(100, 100, 350, 300);
		setTitle("Registrar Matr\u00EDcula");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNumMatricula = new JLabel("N\u00B0 MATR\u00CDCULA");
		lblNumMatricula.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblNumMatricula.setBounds(10, 10, 120, 13);
		contentPanel.add(lblNumMatricula);
		
		JComboBox cboNumMatricula = new JComboBox();
		cboNumMatricula.setFont(new Font("Roboto", Font.PLAIN, 14));
		cboNumMatricula.setBounds(100, 100, 320, 120);
		
		for (int i = 0; i < am.tamaño(); i++) {
			cboNumMatricula.addItem(new ComboItem(am.obtener(i).getNumMatricula() + "", am.obtener(i).getNumMatricula() + ""));
		}
		
		cboNumMatricula.setBackground(Color.WHITE);
		cboNumMatricula.setBounds(10, 33, 316, 30);
		contentPanel.add(cboNumMatricula);
		
		int numMatricula = Integer.parseInt(((ComboItem)cboNumMatricula.getSelectedItem()).getValue());
		Alumno a = aa.buscarPorCodigo(am.buscarPorCodigo(numMatricula).getCodAlumno());
		Curso c = ac.buscarPorCodigo(am.buscarPorCodigo(numMatricula).getCodCurso());

		JLabel lblCodAlumno = new JLabel("COD. ALUMNO");
		lblCodAlumno.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblCodAlumno.setBounds(10, 73, 120, 13);
		contentPanel.add(lblCodAlumno);
		
		JComboBox cboCodAlumno = new JComboBox();
		cboCodAlumno.setModel(new DefaultComboBoxModel(new String[] {a.getNombres() + " " + a.getApellidos()}));
		cboCodAlumno.setFont(new Font("Roboto", Font.PLAIN, 14));
		cboCodAlumno.setBackground(Color.WHITE);
		cboCodAlumno.setBounds(10, 96, 316, 30);
		contentPanel.add(cboCodAlumno);
		
		JLabel lblCodCurso = new JLabel("COD. CURSO");
		lblCodCurso.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblCodCurso.setBounds(10, 136, 120, 13);
		contentPanel.add(lblCodCurso);
		
		JComboBox cboCodCurso = new JComboBox();
		cboCodCurso.setModel(new DefaultComboBoxModel(new String[] {c.getAsignatura()}));
		cboCodCurso.setFont(new Font("Roboto", Font.PLAIN, 14));
		cboCodCurso.setBackground(Color.WHITE);
		cboCodCurso.setBounds(10, 159, 316, 30);
		contentPanel.add(cboCodCurso);
		
		cboNumMatricula.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int numMatricula = Integer.parseInt(((ComboItem)cboNumMatricula.getSelectedItem()).getValue());
				
				Alumno a = aa.buscarPorCodigo(am.buscarPorCodigo(numMatricula).getCodAlumno());
				cboCodAlumno.setModel(new DefaultComboBoxModel(new String[] {a.getNombres() + " " + a.getApellidos()}));
				
				Curso c = ac.buscarPorCodigo(am.buscarPorCodigo(numMatricula).getCodCurso());
				cboCodCurso.setModel(new DefaultComboBoxModel(new String[] {c.getAsignatura()}));
			}
		});

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
						int numRetiro = ar.codigoCorrelativo();
						Object itemCboNumMatricula = cboNumMatricula.getSelectedItem();
						int numMatricula = Integer.parseInt(((ComboItem)itemCboNumMatricula).getValue());
						String fecha = dt.fechaActual();
						String hora = dt.horaActual();
						
						if (!ar.existeMatriculaRetiro(numMatricula)) {
							Retiro retiroRegistrado = new Retiro(numRetiro, numMatricula, fecha, hora);
							ar.adicionar(retiroRegistrado);
							int codAlumno = am.buscarPorCodigo(numMatricula).getCodAlumno();
							Alumno alumnoActualizado = aa.buscarPorCodigo(codAlumno);
							alumnoActualizado.setEstado(2);
							aa.editar(aa.getIndex(codAlumno), alumnoActualizado);
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "Esta matrícula ya se encuentra en retiro.");
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
}
