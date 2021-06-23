package views;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arrays.ArregloAlumnos;
import models.Alumno;
import utils.GestionCeldas;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

public class Alumnos extends JInternalFrame implements MouseListener {

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
//			Alumnos frame = new Alumnos();
//			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Alumnos() {
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setTitle("Alumnos");
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
		tableModel.addColumn("C�DIGO");
		tableModel.addColumn("NOMBRES");
		tableModel.addColumn("APELLIDOS");
		tableModel.addColumn("DNI");
		tableModel.addColumn("EDAD");
		tableModel.addColumn("CELULAR");
		tableModel.addColumn("ESTADO");
		tableModel.addColumn("");
		tableModel.addColumn("");
		tableModel.addColumn("");
		
		table.setIntercellSpacing(new Dimension(10, 1));
		table.addMouseListener(this);
		table.setModel(tableModel);
		
		ajustarAnchoColumnas();
		table.setDefaultEditor(table.getColumnClass(0), null);
		
		listar();
		
		JLabel lblNewLabel = new JLabel("Alumnos");
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 48));
		lblNewLabel.setBounds(25, 20, 214, 75);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Registrar alumno");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(57, 73, 171));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlumnosRegistrar ar = new AlumnosRegistrar(aa);
				refresh(ar);
			}
		});
		btnNewButton.setBounds(653, 43, 175, 50);
		getContentPane().add(btnNewButton);
	}
	
	int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}
	
	void ajustarAnchoColumnas() {
		TableColumnModel tcm = table.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));  // C�DIGO
		tcm.getColumn(1).setPreferredWidth(anchoColumna(15));  // NOMBRES
		tcm.getColumn(2).setPreferredWidth(anchoColumna(15));  // APELLIDOS
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // DNI
		tcm.getColumn(4).setPreferredWidth(anchoColumna(5));  // EDAD
		tcm.getColumn(5).setPreferredWidth(anchoColumna(10));  // CELULAR
		tcm.getColumn(6).setPreferredWidth(anchoColumna(15));  // ESTADO
		tcm.getColumn(7).setPreferredWidth(anchoColumna(3));  // CONSULTAR
		tcm.getColumn(8).setPreferredWidth(anchoColumna(3));  // EDITAR
		tcm.getColumn(9).setPreferredWidth(anchoColumna(3));  // ELIMINAR
		
		tcm.getColumn(0).setCellRenderer(new GestionCeldas("texto"));	// C�DIGO
		tcm.getColumn(1).setCellRenderer(new GestionCeldas("texto"));	// NOMBRES
		tcm.getColumn(2).setCellRenderer(new GestionCeldas("texto"));	// APELLIDOS
		tcm.getColumn(3).setCellRenderer(new GestionCeldas("texto"));	// DNI
		tcm.getColumn(4).setCellRenderer(new GestionCeldas("texto"));	// EDAD
		tcm.getColumn(5).setCellRenderer(new GestionCeldas("texto"));	// CELULAR
		tcm.getColumn(6).setCellRenderer(new GestionCeldas("texto"));	// ESTADO
		tcm.getColumn(7).setCellRenderer(new GestionCeldas("icono"));	// CONSULTAR
		tcm.getColumn(8).setCellRenderer(new GestionCeldas("icono"));	// EDITAR
		tcm.getColumn(9).setCellRenderer(new GestionCeldas("icono"));	// ELIMINAR
	}

	public void listar() {
		int posFila = 0;
		if (tableModel.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (tableModel.getRowCount() == aa.tama�o() - 1)
			posFila = aa.tama�o() - 1;
		if (posFila == aa.tama�o())
			posFila --;
		tableModel.setRowCount(0);
		Alumno a;
		for (int i=0; i<aa.tama�o(); i++) {
			a = aa.obtener(i);
			Object[] fila = {
						a.getCodAlumno(),
						a.getNombres(),
						a.getApellidos(),
						a.getDni(),
						a.getEdad(),
						a.getCelular(),
						a.getTipoEstado(a.getEstado()),
						"Consultar",
						"Editar",
						"Eliminar"
					  };
			tableModel.addRow(fila);
			table.setRowHeight(i, 30);
		}
		if (aa.tama�o() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int fila = table.rowAtPoint(e.getPoint());
		int columna = table.columnAtPoint(e.getPoint());
		
		if (columna == 7) {
			Alumno alumno = aa.obtener(fila);
			mostrarInformacion(alumno);
		} else if (columna == 8) {
			AlumnosEditar ae = new AlumnosEditar(aa, fila);
			refresh(ae);
		} else if (columna == 9) {
			AlumnosEliminar ael = new AlumnosEliminar(aa, fila);
			refresh(ael);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mostrarInformacion(Alumno alumno) {
		String info = "INFORMACI�N DE ALUMNO\n";
		info += "-------------------------------------\n";
		info += "C�DIGO:\n" + alumno.getCodAlumno() + "\n";
		info += "\n";
		info += "NOMBRES:\n" + alumno.getNombres() + "\n";
		info += "\n";
		info += "APELLIDOS:\n" + alumno.getApellidos() + "\n";
		info += "\n";
		info += "DNI:\n" + alumno.getDni() + "\n";
		info += "\n";
		info += "EDAD:\n" + alumno.getEdad() + "\n";
		info += "\n";
		info += "CELULAR:\n" + alumno.getCelular() + "\n";
		info += "\n";
		info += "ESTADO:\n" + alumno.getTipoEstado(alumno.getEstado()) + "\n";
		
		JOptionPane.showMessageDialog(null, info);
	}

	public void refresh(JDialog dialog) {
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setModal(true);
		dialog.setVisible(true);
		dialog.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
				listar();
			}
		});
	}
}