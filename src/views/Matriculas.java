package views;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arrays.ArregloAlumnos;
import arrays.ArregloCursos;
import arrays.ArregloMatriculas;
import models.Alumno;
import models.Curso;
import models.Matricula;
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

public class Matriculas extends JInternalFrame implements MouseListener {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			Matriculas frame = new Matriculas();
//			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Matriculas() {
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setTitle("Matr\u00EDculas");
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
		tableModel.addColumn("NÚMERO");
		tableModel.addColumn("CÓD. ALUMNO");
		tableModel.addColumn("CÓD. CURSO");
		tableModel.addColumn("FECHA");
		tableModel.addColumn("HORA");
		tableModel.addColumn("");
		tableModel.addColumn("");
		tableModel.addColumn("");
		
		table.setIntercellSpacing(new Dimension(10, 1));
		table.addMouseListener(this);
		table.setModel(tableModel);
		
		ajustarAnchoColumnas();
		table.setDefaultEditor(table.getColumnClass(0), null);
		
		listar();
		
		JLabel lblNewLabel = new JLabel("Matr\u00EDculas");
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 48));
		lblNewLabel.setBounds(25, 20, 300, 75);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Registrar matr\u00EDcula");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(57, 73, 171));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MatriculasRegistrar mr = new MatriculasRegistrar(am);
				refresh(mr);
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
		tcm.getColumn(0).setPreferredWidth(anchoColumna(6));  // NÚMERO
		tcm.getColumn(1).setPreferredWidth(anchoColumna(32));  // CÓD. ALUMNO
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25));  // CÓD. CURSO
		tcm.getColumn(3).setPreferredWidth(anchoColumna(8));  // FECHA
		tcm.getColumn(4).setPreferredWidth(anchoColumna(6));  // HORA
		tcm.getColumn(5).setPreferredWidth(anchoColumna(1));  // CONSULTAR
		tcm.getColumn(6).setPreferredWidth(anchoColumna(1));  // EDITAR
		tcm.getColumn(7).setPreferredWidth(anchoColumna(1));  // ELIMINAR
		
		tcm.getColumn(0).setCellRenderer(new GestionCeldas("texto"));	// NÚMERO
		tcm.getColumn(1).setCellRenderer(new GestionCeldas("texto"));	// CÓD. ALUMNO
		tcm.getColumn(2).setCellRenderer(new GestionCeldas("texto"));	// CÓD. CURSO
		tcm.getColumn(3).setCellRenderer(new GestionCeldas("texto"));	// FECHA
		tcm.getColumn(4).setCellRenderer(new GestionCeldas("texto"));	// HORA
		tcm.getColumn(5).setCellRenderer(new GestionCeldas("icono"));	// CONSULTAR
		tcm.getColumn(6).setCellRenderer(new GestionCeldas("icono"));	// EDITAR
		tcm.getColumn(7).setCellRenderer(new GestionCeldas("icono"));	// ELIMINAR
	}

	public void listar() {
		int posFila = 0;
		if (tableModel.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (tableModel.getRowCount() == am.tamaño() - 1)
			posFila = am.tamaño() - 1;
		if (posFila == am.tamaño())
			posFila --;
		tableModel.setRowCount(0);
		Matricula m;
		for (int i=0; i<am.tamaño(); i++) {
			m = am.obtener(i);
			Alumno a = aa.buscarPorCodigo(m.getCodAlumno());
			Curso c = ac.buscarPorCodigo(m.getCodCurso());
			Object[] fila = {
						m.getNumMatricula(),
						a.getCodAlumno() + " - " + a.getNombres() + " " + a.getApellidos(),
						c.getCodCurso() + " - " + c.getAsignatura(),
						m.getFecha(),
						m.getHora(),
						"Consultar",
						"Editar",
						"Eliminar"
					  };
			tableModel.addRow(fila);
			table.setRowHeight(i, 30);
		}
		if (aa.tamaño() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int fila = table.rowAtPoint(e.getPoint());
		int columna = table.columnAtPoint(e.getPoint());
		
		if (columna == 5) {
			Matricula matricula = am.obtener(fila);
			mostrarInformacion(matricula);
		} else if (columna == 6) {
			MatriculasEditar me = new MatriculasEditar(am, fila);
			refresh(me);
		} else if (columna == 7) {
			MatriculasEliminar mel = new MatriculasEliminar(am, fila);
			refresh(mel);
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
	
	public void mostrarInformacion(Matricula m) {
		Alumno a = aa.buscarPorCodigo(m.getCodAlumno());
		Curso c = ac.buscarPorCodigo(m.getCodCurso());
		String info = "INFORMACIÓN DE LA MATRÍCULA\n";
		info += "-------------------------------------\n";
		info += "NÚMERO:\n" + m.getNumMatricula() + "\n";
		info += "\n";
		info += "CÓD. ALUMNO:\n" + a.getCodAlumno() + " - " + a.getNombres() + " " + a.getApellidos() + "\n";
		info += "\n";
		info += "CÓD. CURSO:\n" + c.getCodCurso() + " - " + c.getAsignatura() + "\n";
		info += "\n";
		info += "FECHA:\n" + m.getFecha() + "\n";
		info += "\n";
		info += "HORA:\n" + m.getHora() + "\n";
		
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
