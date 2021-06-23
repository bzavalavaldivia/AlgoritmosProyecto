package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arrays.ArregloRetiros;
import models.Retiro;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class RetirosEliminar extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	
	private Retiro retiro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
//			RetirosEliminar dialog = new RetirosEliminar(new ArregloRetiros(), 0);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	@SuppressWarnings({"rawtypes"})
	public RetirosEliminar(ArregloRetiros ar, int idRetiro) {
		this.retiro = ar.obtener(idRetiro);
		setBackground(new Color(255, 255, 255));
		setTitle("Eliminar Retiro - " + retiro.getNumRetiro());
		setBounds(100, 100, 450, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("\u00BFEst\u00E1s seguro que deseas eliminar este retro?");
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 16));
			lblNewLabel.setBounds(10, 10, 416, 30);
			contentPanel.add(lblNewLabel);
		}
		{
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(10, 45, 0, 0);
			contentPanel.add(comboBox);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 255, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Eliminar");
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setFocusPainted(false);
				okButton.setForeground(new Color(255, 255, 255));
				okButton.setFont(new Font("Roboto Light", Font.PLAIN, 16));
				okButton.setBorderPainted(false);
				okButton.setBackground(new Color(216, 27, 96));
				okButton.setActionCommand("Eliminar");
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ar.eliminar(idRetiro);
						
						setVisible(false);
					}
				});
				
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setFocusPainted(false);
				cancelButton.setForeground(new Color(255, 255, 255));
				cancelButton.setFont(new Font("Roboto Light", Font.PLAIN, 16));
				cancelButton.setBorderPainted(false);
				cancelButton.setBackground(new Color(128, 128, 128));
				cancelButton.setActionCommand("Cancelar");
				
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				
				buttonPane.add(cancelButton);
			}
		}
	}

}
