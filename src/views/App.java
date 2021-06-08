package views;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class App {

	private JFrame frmApplication;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmApplication.setVisible(true);
					
					Login loginForm = new Login();
					
					loginForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmApplication = new JFrame();
		frmApplication.setTitle("Application");
		frmApplication.setBounds(100, 100, 1280, 720);
		frmApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
