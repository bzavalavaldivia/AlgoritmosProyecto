package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class GestionCeldas extends DefaultTableCellRenderer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tipo="text";
	
	private Font normal = new Font( "Roboto",Font.PLAIN ,14 );

	private JLabel label = new JLabel();

	private ImageIcon iconoConsultar = new ImageIcon(getClass().getResource("/resources/icons/search.png"));
	private ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/resources/icons/edit.png"));
	private ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/resources/icons/delete.png"));
	   
	public GestionCeldas(){
		
	}

	public GestionCeldas(String tipo){
		this.tipo=tipo;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        Color colorFondo = null;
        Color colorFondoPorDefecto=new Color( 192, 192, 192);
        Color colorFondoSeleccion=new Color( 140, 140 , 140);
    	
        if (selected) {                
            this.setBackground(colorFondoPorDefecto );   
        } else {
            this.setBackground(Color.white);
        }

        if(tipo.equals("texto")) {
            if (focused) {
    			colorFondo=colorFondoSeleccion;
    		} else {
    			colorFondo= colorFondoPorDefecto;
    		}
            this.setHorizontalAlignment( JLabel.LEFT );
            this.setText((String) value.toString());
            this.setBackground( (selected)? colorFondo :Color.WHITE);	
            this.setFont(normal);
            return this;
        }
         
        if( tipo.equals("icono"))
        {
            if(String.valueOf(value).equals("Consultar"))
            {
            	label.setIcon(iconoConsultar);
            	label.setToolTipText("Consultar");
            } else if (String.valueOf(value).equals("Editar")) {
            	label.setIcon(iconoEditar);
            	label.setToolTipText("Editar");
            } else if (String.valueOf(value).equals("Eliminar")) {
            	label.setIcon(iconoEliminar);
            	label.setToolTipText("Eliminar");
            }
            label.setHorizontalAlignment( JLabel.CENTER );

            return label;
        }
		
		return this;
	}
}
