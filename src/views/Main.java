package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JDesktopPane;
import java.awt.BorderLayout;

public class Main {

	private JFrame frmApplication;
	public static JDesktopPane desktopPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmApplication.setVisible(true);		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmApplication = new JFrame();
		frmApplication.setResizable(false);
		frmApplication.setTitle("Application");
		frmApplication.setBounds(100, 100, 1280, 720);
		frmApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(57, 73, 171));
		frmApplication.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Mantenimiento");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		mnNewMenu.setFont(new Font("Roboto", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Alumno");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Alumnos alumnos = new Alumnos();
				mostrarFrame(alumnos);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Curso");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cursos cursos = new Cursos();
				mostrarFrame(cursos);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Registro");
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		mnNewMenu_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Matr\u00EDcula");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matriculas matriculas = new Matriculas();
				mostrarFrame(matriculas);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Retiro");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Retiros retiros = new Retiros();
				mostrarFrame(retiros);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("Consulta");
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		mnNewMenu_2.setFont(new Font("Roboto", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Alumnos y cursos");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlumnosCursos alumnosCursos = new AlumnosCursos();
				mostrarFrame(alumnosCursos);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Matr\u00EDculas y retiros");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MatriculasRetiros matriculasRetiros = new MatriculasRetiros();
				mostrarFrame(matriculasRetiros);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu("Reporte");
		mnNewMenu_3.setFont(new Font("Roboto", Font.PLAIN, 14));
		mnNewMenu_3.setForeground(Color.WHITE);
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Alumnos con matr\u00EDcula pendiente");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlumnosMatriculaPendiente alumnosMatriculaPendiente = new AlumnosMatriculaPendiente();
				mostrarFrame(alumnosMatriculaPendiente);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Alumnos con matr\u00EDcula vigente");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlumnosMatriculaVigente alumnosMatriculaVigente = new AlumnosMatriculaVigente();
				mostrarFrame(alumnosMatriculaVigente);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Alumnos matr\u00EDculados por curso");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlumnosMatriculadosCurso alumnosMatriculadosCurso = new AlumnosMatriculadosCurso();
				mostrarFrame(alumnosMatriculadosCurso);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		desktopPane = new JDesktopPane();
		frmApplication.getContentPane().add(desktopPane, BorderLayout.CENTER);
	}
	
	public void mostrarFrame(JInternalFrame frame) {
		if (desktopPane.getAllFrames().length == 0) {
			desktopPane.add(frame);
			frame.setVisible(true);
        } else {
        	desktopPane.remove(0);
        	desktopPane.add(frame);
        	frmApplication.getContentPane().revalidate();
        	frmApplication.getContentPane().repaint();
        	frame.setVisible(true);
        }
	}
}
