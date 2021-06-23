package views;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arrays.ArregloCursos;
import models.Curso;
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

public class Cursos extends JInternalFrame implements MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private ArregloCursos ac = new ArregloCursos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			Cursos frame = new Cursos();
//			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cursos() {
		setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setTitle("Cursos");
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
		tableModel.addColumn("ASIGNATURA");
		tableModel.addColumn("CICLO");
		tableModel.addColumn("CRÉDITOS");
		tableModel.addColumn("HORAS");
		tableModel.addColumn("");
		tableModel.addColumn("");
		tableModel.addColumn("");
		
		table.setIntercellSpacing(new Dimension(10, 1));
		table.addMouseListener(this);
		table.setModel(tableModel);
		
		ajustarAnchoColumnas();
		table.setDefaultEditor(table.getColumnClass(0), null);
		
		listar();
		
		JLabel lblNewLabel = new JLabel("Cursos");
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 48));
		lblNewLabel.setBounds(25, 20, 214, 75);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Registrar curso");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(57, 73, 171));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CursosRegistrar cr = new CursosRegistrar(ac);
				refresh(cr);
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
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10));  // CÓDIGO
		tcm.getColumn(1).setPreferredWidth(anchoColumna(15));  // ASIGNATURA
		tcm.getColumn(2).setPreferredWidth(anchoColumna(15));  // CICLO
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10));  // CRÉDITOS
		tcm.getColumn(4).setPreferredWidth(anchoColumna(5));  // HORAS
		tcm.getColumn(5).setPreferredWidth(anchoColumna(3));  // CONSULTAR
		tcm.getColumn(6).setPreferredWidth(anchoColumna(3));  // EDITAR
		tcm.getColumn(7).setPreferredWidth(anchoColumna(3));  // ELIMINAR
		
		tcm.getColumn(0).setCellRenderer(new GestionCeldas("texto"));	// CÓDIGO
		tcm.getColumn(1).setCellRenderer(new GestionCeldas("texto"));	// ASIGNATURA
		tcm.getColumn(2).setCellRenderer(new GestionCeldas("texto"));	// CICLO
		tcm.getColumn(3).setCellRenderer(new GestionCeldas("texto"));	// CRÉDITOS
		tcm.getColumn(4).setCellRenderer(new GestionCeldas("texto"));	// HORAS
		tcm.getColumn(5).setCellRenderer(new GestionCeldas("icono"));	// CONSULTAR
		tcm.getColumn(6).setCellRenderer(new GestionCeldas("icono"));	// EDITAR
		tcm.getColumn(7).setCellRenderer(new GestionCeldas("icono"));	// ELIMINAR
	}

	public void listar() {
		int posFila = 0;
		if (tableModel.getRowCount() > 0)
			posFila = table.getSelectedRow();
		if (tableModel.getRowCount() == ac.tamaño() - 1)
			posFila = ac.tamaño() - 1;
		if (posFila == ac.tamaño())
			posFila --;
		tableModel.setRowCount(0);
		Curso c;
		for (int i=0; i<ac.tamaño(); i++) {
			c = ac.obtener(i);
			Object[] fila = {
						c.getCodCurso(),
						c.getAsignatura(),
						c.getTipoCiclo(c.getCiclo()),
						c.getCreditos(),
						c.getHoras(),
						"Consultar",
						"Editar",
						"Eliminar"
					  };
			tableModel.addRow(fila);
			table.setRowHeight(i, 30);
		}
		if (ac.tamaño() > 0)
			table.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int fila = table.rowAtPoint(e.getPoint());
		int columna = table.columnAtPoint(e.getPoint());
		
		if (columna == 5) {
			Curso curso = ac.obtener(fila);
			mostrarInformacion(curso);
		} else if (columna == 6) {
			CursosEditar ce = new CursosEditar(ac, fila);
			refresh(ce);
		} else if (columna == 7) {
			CursosEliminar cel = new CursosEliminar(ac, fila);
			refresh(cel);
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
	
	public void mostrarInformacion(Curso c) {
		String info = "INFORMACIÓN DEL CURSO\n";
		info += "-------------------------------------\n";
		info += "CÓDIGO:\n" + c.getCodCurso() + "\n";
		info += "\n";
		info += "ASIGNATURA:\n" + c.getAsignatura() + "\n";
		info += "\n";
		info += "CICLO:\n" + c.getTipoCiclo(c.getCiclo()) + "\n";
		info += "\n";
		info += "CRÉDITOS:\n" + c.getCreditos() + "\n";
		info += "\n";
		info += "HORAS:\n" + c.getHoras() + "\n";
		
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
