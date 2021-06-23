package views;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arrays.ArregloAlumnos;
import arrays.ArregloCursos;
import models.Alumno;
import models.Curso;
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
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AlumnosCursos extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private ArregloAlumnos aa = new ArregloAlumnos();
	private ArregloCursos ac = new ArregloCursos();
	private JTextField txtBuscar;
	@SuppressWarnings("rawtypes")
	private JComboBox cboBuscar;
	private JLabel lblAlumnoCurso;
	private JLabel lblCursosAlumnos;
	private JTable table_1;
	private DefaultTableModel tableModel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			AlumnosCursos frame = new AlumnosCursos();
//			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AlumnosCursos() {
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setTitle("Alumnos y cursos");
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
		
		JLabel lblNewLabel = new JLabel("Alumnos y cursos");
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
		cboBuscar.setModel(new DefaultComboBoxModel(new String[] {"Alumno", "Curso"}));
		cboBuscar.setBounds(493, 50, 100, 40);
		getContentPane().add(cboBuscar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipoBusqueda = (String) cboBuscar.getSelectedItem();
				String busqueda = txtBuscar.getText().trim();
				
				if (!busqueda.equals("") && !busqueda.equals(null)) {
					if (tipoBusqueda.equals("Alumno")) {
						try {
							if (aa.existeAlumno(Integer.parseInt(busqueda))) {
								listarAlumno();
							} else {
								JOptionPane.showMessageDialog(null, "No existe ningún alumno con ese código.");
							}
						} catch (NumberFormatException nfe) {
							JOptionPane.showMessageDialog(null, "Solo se aceptan números en la busqueda.");
						}
					} else if (tipoBusqueda.equals("Curso")) {
						try {
							if (ac.existeCurso(Integer.parseInt(busqueda))) {
								listarCurso();
							} else {
								JOptionPane.showMessageDialog(null, "No existe ningún curso con ese código.");
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
		
		lblAlumnoCurso = new JLabel("");
		lblAlumnoCurso.setFont(new Font("Roboto", Font.BOLD, 14));
		lblAlumnoCurso.setBounds(10, 116, 85, 20);
		getContentPane().add(lblAlumnoCurso);
		
		lblCursosAlumnos = new JLabel("");
		lblCursosAlumnos.setFont(new Font("Roboto", Font.BOLD, 14));
		lblCursosAlumnos.setBounds(10, 214, 85, 20);
		getContentPane().add(lblCursosAlumnos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBackground(Color.WHITE);
		scrollPane_1.setBounds(0, 244, 838, 207);
		getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setIntercellSpacing(new Dimension(10, 1));
		table_1.setGridColor(Color.LIGHT_GRAY);
		table_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		table_1.setColumnSelectionAllowed(false);
		table_1.setCellSelectionEnabled(false);
		table_1.setBackground(Color.WHITE);
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	public void listarAlumno() {
		lblAlumnoCurso.setText("Alumno");
		lblCursosAlumnos.setText("Cursos");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("CÓDIGO");
		tableModel.addColumn("NOMBRES");
		tableModel.addColumn("APELLIDOS");
		tableModel.addColumn("DNI");
		tableModel.addColumn("EDAD");
		tableModel.addColumn("CELULAR");
		tableModel.addColumn("ESTADO");
		table.setModel(tableModel);
		table.setDefaultEditor(table.getColumnClass(0), null);
		
		TableColumnModel tcm = table.getColumnModel();
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
		
		tableModel.setRowCount(0);
		Alumno a;
		
		a = aa.buscarPorCodigo(Integer.parseInt(txtBuscar.getText().trim()));
		Object[] fila = {
					a.getCodAlumno(),
					a.getNombres(),
					a.getApellidos(),
					a.getDni(),
					a.getEdad(),
					a.getCelular(),
					a.getTipoEstado(a.getEstado()),
				  };
		tableModel.addRow(fila);
		table.setRowHeight(0, 30);
		
		listarCursos(aa.obtenerCursos(a.getCodAlumno()));
	}
	
	public void listarCurso() {
		lblAlumnoCurso.setText("Curso");
		lblCursosAlumnos.setText("Alumnos");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("CÓDIGO");
		tableModel.addColumn("ASIGNATURA");
		tableModel.addColumn("CICLO");
		tableModel.addColumn("CRÉDITOS");
		tableModel.addColumn("HORAS");
		table.setModel(tableModel);
		table.setDefaultEditor(table.getColumnClass(0), null);
		
		TableColumnModel tcm = table.getColumnModel();
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
		
		tableModel.setRowCount(0);
		Curso c;
		
		c = ac.buscarPorCodigo(Integer.parseInt(txtBuscar.getText().trim()));
		Object[] fila = {
					c.getCodCurso(),
					c.getAsignatura(),
					c.getTipoCiclo(c.getCiclo()),
					c.getCreditos(),
					c.getHoras(),
				  };
		tableModel.addRow(fila);
		table.setRowHeight(0, 30);
		
		listarAlumnos(ac.obtenerAlumnos(c.getCodCurso()));
	}
	
	public void listarAlumnos(ArrayList<Alumno> alumnos) {
		tableModel_1 = new DefaultTableModel();
		tableModel_1.addColumn("CÓDIGO");
		tableModel_1.addColumn("NOMBRES");
		tableModel_1.addColumn("APELLIDOS");
		tableModel_1.addColumn("DNI");
		tableModel_1.addColumn("EDAD");
		tableModel_1.addColumn("CELULAR");
		tableModel_1.addColumn("ESTADO");
		table_1.setModel(tableModel_1);
		table_1.setDefaultEditor(table_1.getColumnClass(0), null);
		
		TableColumnModel tcm = table_1.getColumnModel();
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
		
		int posFila = 0;
		if (tableModel_1.getRowCount() > 0)
			posFila = table_1.getSelectedRow();
		if (tableModel_1.getRowCount() == alumnos.size() - 1)
			posFila = alumnos.size() - 1;
		if (posFila == alumnos.size())
			posFila --;
		tableModel_1.setRowCount(0);
		Alumno a;
		for (int i=0; i<alumnos.size(); i++) {
			a = alumnos.get(i);
			Object[] fila = {
						a.getCodAlumno(),
						a.getNombres(),
						a.getApellidos(),
						a.getDni(),
						a.getEdad(),
						a.getCelular(),
						a.getTipoEstado(a.getEstado())
					  };
			tableModel_1.addRow(fila);
			table_1.setRowHeight(i, 30);
		}
		if (alumnos.size() > 0)
			table_1.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
	
	public void listarCursos(ArrayList<Curso> cusros) {
		tableModel_1 = new DefaultTableModel();
		tableModel_1.addColumn("CÓDIGO");
		tableModel_1.addColumn("ASIGNATURA");
		tableModel_1.addColumn("CICLO");
		tableModel_1.addColumn("CRÉDITOS");
		tableModel_1.addColumn("HORAS");
		table_1.setModel(tableModel_1);
		table_1.setDefaultEditor(table_1.getColumnClass(0), null);
		
		TableColumnModel tcm = table_1.getColumnModel();
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
		
		int posFila = 0;
		if (tableModel_1.getRowCount() > 0)
			posFila = table_1.getSelectedRow();
		if (tableModel_1.getRowCount() == cusros.size() - 1)
			posFila = cusros.size() - 1;
		if (posFila == cusros.size())
			posFila --;
		tableModel_1.setRowCount(0);
		Curso c;
		for (int i=0; i<cusros.size(); i++) {
			c = cusros.get(i);
			Object[] fila = {
						c.getCodCurso(),
						c.getAsignatura(),
						c.getTipoCiclo(c.getCiclo()),
						c.getCreditos(),
						c.getHoras()
					  };
			tableModel_1.addRow(fila);
			table_1.setRowHeight(i, 30);
		}
		if (cusros.size() > 0)
			table_1.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
}
