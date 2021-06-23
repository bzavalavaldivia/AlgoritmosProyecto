package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


/**
 * Esta clase permite gestionar la tabla y los eventos realizados sobre ella
 * cada celda seria un objeto personalizable
 * @author CHENAO
 *
 */
public class GestionCeldas extends DefaultTableCellRenderer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tipo="text";

	//se definen por defecto los tipos de datos a usar
	
	private Font normal = new Font( "Roboto",Font.PLAIN ,14 );
	private Font bold = new Font( "Roboto",Font.BOLD ,14 );
	//etiqueta que almacenará el icono a mostrar
	private JLabel label = new JLabel();
	//iconos disponibles para ser mostrados en la etiqueta dependiendo de la columna que lo contenga
	private ImageIcon iconoConsultar = new ImageIcon(getClass().getResource("/resources/icons/search.png"));
	private ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/resources/icons/edit.png"));
	private ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/resources/icons/delete.png"));
	   
	
	
	public GestionCeldas(){
		
	}

	/**
	 * Constructor explicito con el tipo de dato que tendrá la celda
	 * @param tipo
	 */
	public GestionCeldas(String tipo){
		this.tipo=tipo;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
		
		/*
		 * Este metodo controla toda la tabla, podemos obtener el valor que contiene
		 * definir que celda está seleccionada, la fila y columna al tener el foco en ella.
		 * 
		 * cada evento sobre la tabla invocará a este metodo
		 */
		
		//definimos colores por defecto
        Color colorFondo = null;
        Color colorFondoPorDefecto=new Color( 192, 192, 192);
        Color colorFondoSeleccion=new Color( 140, 140 , 140);
    	
        /*
         * Si la celda del evento es la seleccionada se asigna el fondo por defecto para la selección
         */
        if (selected) {                
            this.setBackground(colorFondoPorDefecto );   
        }
        else
        {
        	//Para las que no están seleccionadas se pinta el fondo de las celdas de blanco
            this.setBackground(Color.white);
        }
                
        /*
         * Se definen los tipos de datos que contendrán las celdas basado en la instancia que
         * se hace en la ventana de la tabla al momento de construirla
         */
        if( tipo.equals("texto"))
        {
        	//si es tipo texto define el color de fondo del texto y de la celda así como la alineación
            if (focused) {
    			colorFondo=colorFondoSeleccion;
    		}else{
    			colorFondo= colorFondoPorDefecto;
    		}
            this.setHorizontalAlignment( JLabel.LEFT );
            this.setText( (String) value.toString() );
            //this.setForeground( (selected)? new Color(255,255,255) :new Color(0,0,0) );   
            //this.setForeground( (selected)? new Color(255,255,255) :new Color(32,117,32) );
            this.setBackground( (selected)? colorFondo :Color.WHITE);	
            this.setFont(normal);   
            //this.setFont(bold);
            return this;
        }
         
        //si el tipo es icono entonces valida cual icono asignar a la etiqueta.
        if( tipo.equals("icono"))
        {
            if( String.valueOf(value).equals("Consultar") )
            {
            	label.setIcon(iconoConsultar);
            	label.setToolTipText("Consultar");
            }
            else if( String.valueOf(value).equals("Editar") )
            {
            	label.setIcon(iconoEditar);
            	label.setToolTipText("Editar");
            }
            else if( String.valueOf(value).equals("Eliminar") )
            {
            	label.setIcon(iconoEliminar);
            	label.setToolTipText("Eliminar");
            }
            label.setHorizontalAlignment( JLabel.CENTER );
//            label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

            return label;
        }
		
		return this;
		
		
	}
	
	
	
}
