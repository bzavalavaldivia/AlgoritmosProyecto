package views;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arrays.ArregloCursos;
import models.Alumno;
import models.Curso;
import utils.ComboItem;
import utils.GestionCeldas;

import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class AlumnosMatriculadosCurso extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private ArregloCursos ac = new ArregloCursos();
	@SuppressWarnings("rawtypes")
	private JComboBox cboCurso;
	private JLabel lblCurso;
	private JLabel lblAlumnos;
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
	public AlumnosMatriculadosCurso() {
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setTitle("Alumnos matr\u00EDculados por curso");
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
		
		JLabel lblNewLabel = new JLabel("Alumnos matr\u00EDculados por curso");
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 48));
		lblNewLabel.setBounds(25, 20, 804, 75);
		getContentPane().add(lblNewLabel);
		
		cboCurso = new JComboBox();
		cboCurso.setFont(new Font("Roboto", Font.PLAIN, 14));

		ArregloCursos ac = new ArregloCursos();
		for (int i = 0; i < ac.tamaño(); i++) {
			cboCurso.addItem(new ComboItem(ac.obtener(i).getAsignatura(), ac.obtener(i).getCodCurso() + ""));
		}
		
		cboCurso.setBounds(494, 96, 240, 40);
		getContentPane().add(cboCurso);
		
//		Object itemCboCurso = cboCurso.getSelectedItem();
//		int codCurso = Integer.parseInt(((ComboItem)itemCboCurso).getValue());
//		System.out.println(codCurso + "");
//		listarCurso(ac.buscarPorCodigo(codCurso));
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object itemCboCurso = cboCurso.getSelectedItem();
				int codCurso = Integer.parseInt(((ComboItem)itemCboCurso).getValue());
				listarCurso(ac.buscarPorCodigo(codCurso));
			}
		});
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setBorderPainted(false);
		btnBuscar.setBackground(new Color(57, 73, 171));
		btnBuscar.setFont(new Font("Roboto", Font.PLAIN, 14));
		btnBuscar.setBounds(744, 96, 85, 40);
		getContentPane().add(btnBuscar);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Roboto", Font.BOLD, 14));
		lblCurso.setBounds(10, 116, 85, 20);
		getContentPane().add(lblCurso);
		
		lblAlumnos = new JLabel("Alumnos");
		lblAlumnos.setFont(new Font("Roboto", Font.BOLD, 14));
		lblAlumnos.setBounds(10, 214, 85, 20);
		getContentPane().add(lblAlumnos);
		
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
	
	public void listarCurso(Curso c) {
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
}
