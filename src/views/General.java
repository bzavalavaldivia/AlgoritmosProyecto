package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class General extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					General frame = new General();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public General() {
		setTitle("Proyecto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 549);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		JMenuItem mntmAlumno = new JMenuItem("Alumno");
		mntmAlumno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnMantenimiento.add(mntmAlumno);
		
		JMenuItem mntmCurso = new JMenuItem("Curso");
		mntmCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnMantenimiento.add(mntmCurso);
		
		JMenu mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		JMenuItem mntmMatricula = new JMenuItem("Matricula");
		mntmMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnRegistro.add(mntmMatricula);
		
		JMenuItem mntmRetiro = new JMenuItem("Retiro");
		mntmRetiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnRegistro.add(mntmRetiro);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		JMenuItem mntmAlumnosYCursos = new JMenuItem("Alumnos y cursos");
		mntmAlumnosYCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnConsulta.add(mntmAlumnosYCursos);
		
		JMenuItem mntmMatriculasYRetiros = new JMenuItem("Matriculas y retiros");
		mntmMatriculasYRetiros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnConsulta.add(mntmMatriculasYRetiros);
		
		JMenu mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		JMenuItem mntmAlumnosConMatricula = new JMenuItem("Alumnos con matricula pendiente");
		mnReporte.add(mntmAlumnosConMatricula);
		
		JMenuItem mntmAlumnosConMatricula_1 = new JMenuItem("Alumnos con matricula vigente");
		mnReporte.add(mntmAlumnosConMatricula_1);
		
		JMenuItem mntmAlumnosMatriculadosPor = new JMenuItem("Alumnos matriculados por curso");
		mnReporte.add(mntmAlumnosMatriculadosPor);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
