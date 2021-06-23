package views;

import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arrays.ArregloAlumnos;
import models.Alumno;
import utils.GestionCeldas;

import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class AlumnosMatriculaPendiente extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private ArregloAlumnos aa = new ArregloAlumnos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			AlumnosMatriculaPendiente frame = new AlumnosMatriculaPendiente();
//			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AlumnosMatriculaPendiente() {
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setTitle("Alumnos con matr\u00EDcula pendiente");
		setResizable(false);
		setBounds(100, 100, 850, 480);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setBounds(0, 118, 838, 333);
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
		
		tableModel = new DefaultTableModel();
		tableModel.addColumn("CÓDIGO");
		tableModel.addColumn("NOMBRES");
		tableModel.addColumn("APELLIDOS");
		tableModel.addColumn("DNI");
		tableModel.addColumn("EDAD");
		tableModel.addColumn("CELULAR");
		tableModel.addColumn("ESTADO");
		
		table.setIntercellSpacing(new Dimension(10, 1));
		table.setModel(tableModel);
		
		ajustarAnchoColumnas();
		table.setDefaultEditor(table.getColumnClass(0), null);
		
		listar();
		
		JLabel lblNewLabel = new JLabel("Alumnos con matr\u00EDcula pendiente");
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 48));
		lblNewLabel.setBounds(25, 20, 803, 75);
		getContentPane().add(lblNewLabel);
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	void ajustarAnchoColumnas() {
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
	}

	public void listar() {
		int posFila = 0;
		if (tableModel.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (tableModel.getRowCount() == aa.tamaño() - 1)
			posFila = aa.tamaño() - 1;
		if (posFila == aa.tamaño())
			posFila --;
		tableModel.setRowCount(0);
		Alumno a;
		for (int i=0; i<aa.tamaño(); i++) {
			a = aa.obtener(i);
			if (!aa.existeMatricula(a.getCodAlumno())) {
				Object[] fila = {
						a.getCodAlumno(),
						a.getNombres(),
						a.getApellidos(),
						a.getDni(),
						a.getEdad(),
						a.getCelular(),
						a.getTipoEstado(a.getEstado())
					  };
			tableModel.addRow(fila);
			}
			table.setRowHeight(0, 30);
		}
		if (aa.tamaño() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}
}
