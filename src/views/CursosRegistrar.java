package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arrays.ArregloCursos;
import models.Curso;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class CursosRegistrar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigo;
	private JTextField txtAsignatura;
	private JTextField txtCreditos;
	private JTextField txtHoras;

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
	public CursosRegistrar(ArregloCursos ac) {
		setBounds(100, 100, 350, 425);
		setTitle("Registrar Curso");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("C\u00D3DIGO");
		lblCodigo.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 10, 96, 13);
		contentPanel.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(10, 34, 316, 30);
		contentPanel.add(txtCodigo);
		
		JLabel lblAsignatura = new JLabel("ASIGNATURA");
		lblAsignatura.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblAsignatura.setBounds(10, 74, 96, 13);
		contentPanel.add(lblAsignatura);
		
		txtAsignatura = new JTextField();
		txtAsignatura.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtAsignatura.setBounds(10, 97, 316, 30);
		contentPanel.add(txtAsignatura);
		txtAsignatura.setColumns(10);
		
		JLabel lblCiclo = new JLabel("CICLO");
		lblCiclo.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblCiclo.setBounds(10, 137, 96, 13);
		contentPanel.add(lblCiclo);
		
		JComboBox cboCiclo = new JComboBox();
		cboCiclo.setFont(new Font("Roboto", Font.PLAIN, 14));
		cboCiclo.setModel(new DefaultComboBoxModel(new String[] {"PRIMERO", "SEGUNDO", "TERCERO", "CUARTO", "QUINTO", "SEXTO"}));
		cboCiclo.setBackground(new Color(255, 255, 255));
		cboCiclo.setBounds(10, 160, 316, 30);
		contentPanel.add(cboCiclo);
		
		JLabel lblCreditos = new JLabel("CR\u00C9DITOS");
		lblCreditos.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblCreditos.setBounds(10, 200, 96, 13);
		contentPanel.add(lblCreditos);
		
		txtCreditos = new JTextField();
		txtCreditos.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtCreditos.setColumns(10);
		txtCreditos.setBounds(10, 223, 316, 30);
		contentPanel.add(txtCreditos);
		
		JLabel lblHoras = new JLabel("HORAS");
		lblHoras.setFont(new Font("Roboto", Font.PLAIN, 14));
		lblHoras.setBounds(10, 263, 96, 13);
		contentPanel.add(lblHoras);
		
		txtHoras = new JTextField();
		txtHoras.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtHoras.setColumns(10);
		txtHoras.setBounds(10, 286, 316, 30);
		contentPanel.add(txtHoras);
		
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
						int codCurso = Integer.parseInt(txtCodigo.getText());
						String asignatura = txtAsignatura.getText();
						int ciclo = cboCiclo.getSelectedIndex();
						int creditos = Integer.parseInt(txtCreditos.getText());
						int horas = Integer.parseInt(txtHoras.getText());
						
						if (!ac.existeCurso(codCurso)) {
							Curso cursoRegistrado = new Curso(codCurso, asignatura, ciclo, creditos, horas);
							
							ac.adicionar(cursoRegistrado);
							
							setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "El código del curso ya está en uso.");
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
