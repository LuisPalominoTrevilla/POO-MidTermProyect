import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Home extends JFrame{
	private JPanel panel;
	private JRadioButton opcion1, opcion2;
	private JButton continuar;
	
	public Home(){
		super("Bienvenido");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.panel = new JPanel();
		this.panel.setPreferredSize(new Dimension(400, 200));
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.PAGE_AXIS));
		this.add(this.panel);
		this.pack();
		
        // Las siguientes 2 l�neas de c�digo fueron tomadas de http://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        // Inicializar Componentes
        this.opcion1 = new JRadioButton("Input manual", true);
        this.opcion1.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.opcion2 = new JRadioButton("Subir archivo con varios trabajadores");
        this.opcion2.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.opcion2.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(this.opcion1);
        grupo1.add(this.opcion2);
        this.continuar = new JButton("Continuar");
        this.continuar.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.continuar.addActionListener(new Action(this));
        JLabel title = new JLabel("Seleccione la opci�n deseada para el c�lculo del ISR");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(10, 5, 20, 5));	// A�adir borde al componente de titulo
        
        // A�adir componentes al panel
        this.panel.add(title);
        this.panel.add(this.opcion1);
        this.panel.add(this.opcion2);
        this.panel.add(this.continuar);
        
        this.setVisible(true);
	}
	
	static class Action implements ActionListener{
		Home home;
		public Action(Home h){
			this.home = h;
		}

		public void actionPerformed(ActionEvent event) {
			if(this.home.opcion1.isSelected()){
				// Codigo opcion 1
			}else{
				// Codigo opcion 2
			}
			this.home.dispose();
		}
	}

	public static void main(String[] args){
		Home homw = new Home();
		System.out.println("hey");
	}

}
