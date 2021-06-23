package views;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arrays.ArregloAlumnos;
import arrays.ArregloCursos;
import arrays.ArregloMatriculas;
import arrays.ArregloRetiros;
import models.Alumno;
import models.Curso;
import models.Matricula;
import models.Retiro;
import utils.GestionCeldas;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MatriculasRetiros extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private ArregloAlumnos aa = new ArregloAlumnos();
	private ArregloCursos ac = new ArregloCursos();
	private ArregloMatriculas am = new ArregloMatriculas();
	private ArregloRetiros ar = new ArregloRetiros();
	private JTextField txtBuscar;
	@SuppressWarnings("rawtypes")
	private JComboBox cboBuscar;
	private JLabel lblMatriculaRetiro;
	private JLabel lblAlumno;
	private JTable table_alumno;
	private DefaultTableModel tableModel_alumno;
	private JLabel lblCurso;
	private JScrollPane scrollPane_2;
	private JTable table_curso;
	private DefaultTableModel tableModel_curso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			MatriculasRetiros frame = new MatriculasRetiros();
//			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MatriculasRetiros() {
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setTitle("Matrículas y retiros");
		setResizable(false);
		setBounds(100, 100, 850, 480);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(0, 146, 838, 53);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(false);
		table.setCellSelectionEnabled(false);
		table.setGridColor(new Color(192, 192, 192));
		table.setFont(new Font("Roboto", Font.PLAIN, 14));
		table.setBackground(new Color(255, 255, 255));
		table.setBounds(100, 100, 1280, 720);
		table.getTableHeader().setBackground(new Color(57, 73, 171));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		
		table.setIntercellSpacing(new Dimension(10, 1));
		
		JLabel lblNewLabel = new JLabel("Matrículas y retiros");
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 48));
		lblNewLabel.setBounds(25, 20, 409, 75);
		getContentPane().add(lblNewLabel);
		
		txtBuscar = new JTextField();
		txtBuscar.setFont(new Font("Roboto", Font.PLAIN, 14));
		txtBuscar.setBounds(603, 51, 130, 40);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		cboBuscar = new JComboBox();
		cboBuscar.setFont(new Font("Roboto", Font.PLAIN, 14));
		cboBuscar.setModel(new DefaultComboBoxModel(new String[] {"Matricula", "Retiro"}));
		cboBuscar.setBounds(493, 50, 100, 40);
		getContentPane().add(cboBuscar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoBusqueda = (String) cboBuscar.getSelectedItem();
				String busqueda = txtBuscar.getText().trim();
				
				if (!busqueda.equals("") && !busqueda.equals(null)) {
					if (tipoBusqueda.equals("Matricula")) {
						try {
							if (am.existeMatricula(Integer.parseInt(busqueda))) {
								listarMatricula();
							} else {
								JOptionPane.showMessageDialog(null, "No existe ninguna matrícula con ese código.");
							}
						} catch (NumberFormatException nfe) {
							JOptionPane.showMessageDialog(null, "Solo se aceptan números en la busqueda.");
						}
					} else if (tipoBusqueda.equals("Retiro")) {
						try {
							if (ar.existeRetiro(Integer.parseInt(busqueda))) {
								listarRetiro();
							} else {
								JOptionPane.showMessageDialog(null, "No existe ningún retiro con ese código.");
							}
						} catch (NumberFormatException nfe) {
							JOptionPane.showMessageDialog(null, "Solo se aceptan números en la busqueda.");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "El campo de busqueda es obligatorio.");
				}
			}
		});
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBackground(new Color(57, 73, 171));
		btnBuscar.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnBuscar.setBounds(743, 51, 85, 40);
		getContentPane().add(btnBuscar);
		
		lblMatriculaRetiro = new JLabel("");
		lblMatriculaRetiro.setFont(new Font("Roboto", Font.BOLD, 14));
		lblMatriculaRetiro.setBounds(10, 116, 85, 20);
		getContentPane().add(lblMatriculaRetiro);
		
		lblAlumno = new JLabel("Alumno");
		lblAlumno.setFont(new Font("Roboto", Font.BOLD, 14));
		lblAlumno.setBounds(10, 214, 85, 20);
		getContentPane().add(lblAlumno);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBounds(0, 244, 838, 53);
		getContentPane().add(scrollPane_1);
		
		table_alumno = new JTable();
		scrollPane_1.setViewportView(table_alumno);
		table_alumno.setIntercellSpacing(new Dimension(10, 1));
		table_alumno.setGridColor(Color.LIGHT_GRAY);
		table_alumno.setFont(new Font("Roboto", Font.PLAIN, 14));
		table_alumno.setColumnSelectionAllowed(false);
		table_alumno.setCellSelectionEnabled(false);
		table_alumno.setBackground(Color.WHITE);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Roboto", Font.BOLD, 14));
		lblCurso.setBounds(10, 307, 85, 20);
		getContentPane().add(lblCurso);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBackground(Color.WHITE);
		scrollPane_2.setBounds(0, 337, 838, 53);
		getContentPane().add(scrollPane_2);
		
		table_curso = new JTable();
		scrollPane_2.setViewportView(table_curso);
		table_curso.setIntercellSpacing(new Dimension(10, 1));
		table_curso.setGridColor(Color.LIGHT_GRAY);
		table_curso.setFont(new Font("Roboto", Font.PLAIN, 14));
		table_curso.setColumnSelectionAllowed(false);
		table_curso.setCellSelectionEnabled(false);
		table_curso.setBackground(Color.WHITE);
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	public void listarMatricula() {
		lblMatriculaRetiro.setText("Matrícula");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("NÚMERO");
		tableModel.addColumn("CÓD. ALUMNO");
		tableModel.addColumn("CÓD. CURSO");
		tableModel.addColumn("FECHA");
		tableModel.addColumn("HORA");
		table.setModel(tableModel);
		table.setDefaultEditor(table.getColumnClass(0), null);
		
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(6));  // NÚMERO
		tcm.getColumn(1).setPreferredWidth(anchoColumna(32));  // CÓD. ALUMNO
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25));  // CÓD. CURSO
		tcm.getColumn(3).setPreferredWidth(anchoColumna(8));  // FECHA
		tcm.getColumn(4).setPreferredWidth(anchoColumna(6));  // HORA

		tcm.getColumn(0).setCellRenderer(new GestionCeldas("texto"));	// NÚMERO
		tcm.getColumn(1).setCellRenderer(new GestionCeldas("texto"));	// CÓD. ALUMNO
		tcm.getColumn(2).setCellRenderer(new GestionCeldas("texto"));	// CÓD. CURSO
		tcm.getColumn(3).setCellRenderer(new GestionCeldas("texto"));	// FECHA
		tcm.getColumn(4).setCellRenderer(new GestionCeldas("texto"));	// HORA
		
		tableModel.setRowCount(0);
		Matricula m;
		
		m = am.buscarPorCodigo(Integer.parseInt(txtBuscar.getText().trim()));
		Alumno a = aa.buscarPorCodigo(m.getCodAlumno());
		Curso c = ac.buscarPorCodigo(m.getCodCurso());
		Object[] fila = {
					m.getNumMatricula(),
					a.getCodAlumno() + " - " + a.getNombres() + " " + a.getApellidos(),
					c.getCodCurso() + " - " + c.getAsignatura(),
					m.getFecha(),
					m.getHora(),
				  };
		tableModel.addRow(fila);
		table.setRowHeight(0, 30);
		
		listarAlumno(a);
		listarCurso(c);
	}
	
	public void listarRetiro() {
		lblMatriculaRetiro.setText("Retiro");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("NÚMERO");
		tableModel.addColumn("N° MATRÍCULA");
		tableModel.addColumn("CÓD. ALUMNO");
		tableModel.addColumn("CÓD. CURSO");
		tableModel.addColumn("FECHA");
		tableModel.addColumn("HORA");
		table.setModel(tableModel);
		table.setDefaultEditor(table.getColumnClass(0), null);
		
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(6));  // NÚMERO
		tcm.getColumn(1).setPreferredWidth(anchoColumna(6));  // N° MATRÍCULA
		tcm.getColumn(2).setPreferredWidth(anchoColumna(28));  // CÓD. ALUMNO
		tcm.getColumn(3).setPreferredWidth(anchoColumna(20));  // CÓD. CURSO
		tcm.getColumn(4).setPreferredWidth(anchoColumna(8));  // FECHA
		tcm.getColumn(5).setPreferredWidth(anchoColumna(6));  // HORA

		tcm.getColumn(0).setCellRenderer(new GestionCeldas("texto"));	// NÚMERO
		tcm.getColumn(1).setCellRenderer(new GestionCeldas("texto"));	// N° MATRÍCULA
		tcm.getColumn(2).setCellRenderer(new GestionCeldas("texto"));	// CÓD. ALUMNO
		tcm.getColumn(3).setCellRenderer(new GestionCeldas("texto"));	// CÓD. CURSO
		tcm.getColumn(4).setCellRenderer(new GestionCeldas("texto"));	// FECHA
		tcm.getColumn(5).setCellRenderer(new GestionCeldas("texto"));	// HORA
		
		tableModel.setRowCount(0);
		Retiro r;
		
		r = ar.buscarPorCodigo(Integer.parseInt(txtBuscar.getText().trim()));
		Matricula m = am.buscarPorCodigo(r.getNumMatricula());
		Alumno a = aa.buscarPorCodigo(m.getCodAlumno());
		Curso c = ac.buscarPorCodigo(m.getCodCurso());
		Object[] fila = {
					r.getNumRetiro(),
					r.getNumMatricula(),
					a.getCodAlumno() + " - " + a.getNombres() + " " + a.getApellidos(),
					c.getCodCurso() + " - " + c.getAsignatura(),
					r.getFecha(),
					r.getHora()
				  };
		tableModel.addRow(fila);
		table.setRowHeight(0, 30);
		
		listarAlumno(a);
		listarCurso(c);
	}
	
	public void listarAlumno(Alumno a) {
		tableModel_alumno = new DefaultTableModel();
		tableModel_alumno.addColumn("CÓDIGO");
		tableModel_alumno.addColumn("NOMBRES");
		tableModel_alumno.addColumn("APELLIDOS");
		tableModel_alumno.addColumn("DNI");
		tableModel_alumno.addColumn("EDAD");
		tableModel_alumno.addColumn("CELULAR");
		tableModel_alumno.addColumn("ESTADO");
		table_alumno.setModel(tableModel_alumno);
		table_alumno.setDefaultEditor(table_alumno.getColumnClass(0), null);
		
		TableColumnModel tcm = table_alumno.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));  // CÓDIGO
		tcm.getColumn(1).setPreferredWidth(anchoColumna(15));  // NOMBRES
		tcm.getColumn(2).setPreferredWidth(anchoColumna(15));  // APELLIDOS
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // DNI
		tcm.getColumn(4).setPreferredWidth(anchoColumna(5));  // EDAD
		tcm.getColumn(5).setPreferredWidth(anchoColumna(10));  // CELULAR
		tcm.getColumn(6).setPreferredWidth(anchoColumna(15));  // ESTADO
		
		tcm.getColumn(0).setCellRenderer(new GestionCeldas("texto"));	// CÓDIGO
		tcm.getColumn(1).setCellRenderer(new GestionCeldas("texto"));	// NOMBRES
		tcm.getColumn(2).setCellRenderer(new GestionCeldas("texto"));	// APELLIDOS
		tcm.getColumn(3).setCellRenderer(new GestionCeldas("texto"));	// DNI
		tcm.getColumn(4).setCellRenderer(new GestionCeldas("texto"));	// EDAD
		tcm.getColumn(5).setCellRenderer(new GestionCeldas("texto"));	// CELULAR
		tcm.getColumn(6).setCellRenderer(new GestionCeldas("texto"));	// ESTADO
		
		tableModel_alumno.setRowCount(0);

		Object[] fila = {
					a.getCodAlumno(),
					a.getNombres(),
					a.getApellidos(),
					a.getDni(),
					a.getEdad(),
					a.getCelular(),
					a.getTipoEstado(a.getEstado())
				  };
		tableModel_alumno.addRow(fila);
		table_alumno.setRowHeight(0, 30);
	}
	
	public void listarCurso(Curso c) {
		tableModel_curso = new DefaultTableModel();
		tableModel_curso.addColumn("CÓDIGO");
		tableModel_curso.addColumn("ASIGNATURA");
		tableModel_curso.addColumn("CICLO");
		tableModel_curso.addColumn("CRÉDITOS");
		tableModel_curso.addColumn("HORAS");
		table_curso.setModel(tableModel_curso);
		table_curso.setDefaultEditor(table_alumno.getColumnClass(0), null);
		
		TableColumnModel tcm = table_curso.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));  // CÓDIGO
		tcm.getColumn(1).setPreferredWidth(anchoColumna(15));  // ASIGNATURA
		tcm.getColumn(2).setPreferredWidth(anchoColumna(15));  // CICLO
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // CRÉDITOS
		tcm.getColumn(4).setPreferredWidth(anchoColumna(5));  // HORAS
		
		tcm.getColumn(0).setCellRenderer(new GestionCeldas("texto"));	// CÓDIGO
		tcm.getColumn(1).setCellRenderer(new GestionCeldas("texto"));	// ASIGNATURA
		tcm.getColumn(2).setCellRenderer(new GestionCeldas("texto"));	// CICLO
		tcm.getColumn(3).setCellRenderer(new GestionCeldas("texto"));	// CRÉDITOS
		tcm.getColumn(4).setCellRenderer(new GestionCeldas("texto"));	// HORAS
		
		tableModel_curso.setRowCount(0);

		Object[] fila = {
					c.getCodCurso(),
					c.getAsignatura(),
					c.getTipoCiclo(c.getCiclo()),
					c.getCreditos(),
					c.getHoras()
				  };
		tableModel_curso.addRow(fila);
		table_curso.setRowHeight(0, 30);
	}
}
