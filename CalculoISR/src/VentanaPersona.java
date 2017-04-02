import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import javax.swing.*;
import java.awt.*;

public class VentanaPersona extends JFrame implements ActionListener{
	
	private JPanel columnaIzquiera, columnaDerecha, columnaResultados;
	private JRadioButton primaria, secundaria, bachiller, ninguno;
	private	JTextField tfNombre, tfRFC, tfSueldoMensual, tfAguinaldo,tfPrimaVacacional, tfHospitales, tfFuneral, tfSGMM, tfHipotecarios, tfDonativos, tfSubRetiro, tfTransporte, tfColegiatura;
	private JLabel lbNombre, lbRFC, lbSueldoMensual, lbAguinaldo, lbPrimaVacacional, lbHospitales, lbFuneral, lbSGMM, lbHipotecarios, lbDonativos, lbSubRetiro, lbTransporte, lbNivelEscolar, lbColegiatura, saltoDeLinea, lbResultados, lbResultados2, lbResultados3;
	private JButton calcular, regresar, limpiar, guardar;
	private String nivelEducativo, printString;
	//private Component[] components; this.components = new Component[11];

	public VentanaPersona(){
		super("Calcular ISR Individual");
		this.setSize(800, 650);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);

        // Las siguientes 2 lineas de codigo fueron tomadas de http://stackoverflow.com/questions/2442599/how-to-set-jframe-to-appear-centered-regardless-of-monitor-resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        // Inicializar Componentes
        this.columnaIzquiera = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Linea de codigo recuperada de http://stackoverflow.com/questions/2714663/how-can-i-align-all-elements-to-the-left-in-jpanel
        this.columnaIzquiera.setPreferredSize(new Dimension(250,600));
        this.columnaIzquiera.setBorder(BorderFactory.createEmptyBorder(20,30,20,20));
        this.add(this.columnaIzquiera,BorderLayout.WEST);
        
        this.columnaDerecha = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Linea de codigo recuperada de http://stackoverflow.com/questions/2714663/how-can-i-align-all-elements-to-the-left-in-jpanel
        this.columnaDerecha.setPreferredSize(new Dimension(250,600));
        this.columnaDerecha.setBorder(BorderFactory.createEmptyBorder(20,20,20,30));
        this.add(this.columnaDerecha,BorderLayout.CENTER);
        
        this.columnaResultados = new JPanel(new FlowLayout(FlowLayout.LEFT));
        this.columnaResultados.setPreferredSize(new Dimension(300,650));
        this.columnaResultados.setBorder(BorderFactory.createEmptyBorder(20,20,20,30));
        this.add(this.columnaResultados,BorderLayout.EAST);
        
        this.lbNombre = new JLabel("Nombre: ");
        this.tfNombre = new JTextField(15);
        
        this.lbRFC = new JLabel("RFC: ");
        this.tfRFC = new JTextField(15);
        
        this.lbSueldoMensual = new JLabel("Sueldo mensual: ");
        this.tfSueldoMensual = new JTextField(15);
        
        this.lbAguinaldo = new JLabel("Aguinaldo: ");
        this.tfAguinaldo = new JTextField(15);
        
        this.lbPrimaVacacional = new JLabel("Prima Vacacional: ");
        this.tfPrimaVacacional = new JTextField(15);
        
        this.lbHospitales = new JLabel("Medicos y Hopsitales: ");
        this.tfHospitales = new JTextField(15);
        
        this.lbFuneral = new JLabel("Gastos Funerarios: ");
        this.tfFuneral = new JTextField(15);
        
        this.lbSGMM = new JLabel("S. Gastos Medicos Mayores: ");
        this.tfSGMM = new JTextField(15);
        
        this.lbHipotecarios = new JLabel("Hipotecarios: ");
        this.tfHipotecarios = new JTextField(15);
        
        this.lbDonativos = new JLabel("Donativos: ");
        this.tfDonativos = new JTextField(15);
        
        this.lbSubRetiro = new JLabel("Subuenta de Retiro: ");
        this.tfSubRetiro = new JTextField(15);
        
        this.lbTransporte = new JLabel("Transporte Escolar: ");
        this.tfTransporte = new JTextField(15);
        
        this.lbColegiatura = new JLabel("Colegiatura: ");
        this.tfColegiatura = new JTextField(15);
        
        this.lbNivelEscolar = new JLabel("Nivel Escolar: ");
        this.ninguno = new JRadioButton("Ninguno", true);
        this.ninguno.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        this.primaria = new JRadioButton("Primaria");
        this.primaria.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        this.secundaria = new JRadioButton("Secundaria");
        this.secundaria.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        this.bachiller = new JRadioButton("Preparatoria");
        this.bachiller.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0)); 
        
        this.primaria.addActionListener(this);
        this.secundaria.addActionListener(this);
        this.bachiller.addActionListener(this);
        
        ButtonGroup nivelEducativo = new ButtonGroup();        
        nivelEducativo.add(this.ninguno);
        nivelEducativo.add(this.primaria);
        nivelEducativo.add(this.secundaria);
        nivelEducativo.add(this.bachiller);
        
        this.calcular = new JButton("Calcular");
        this.calcular.setPreferredSize(new Dimension(150,30));
        this.calcular.addActionListener(this);
        
        this.guardar = new JButton("Guardar");
        this.guardar.setPreferredSize(new Dimension(150,30));
        
        this.guardar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
								
				try{
					FileWriter fw = new FileWriter("deduccion.html");
					PrintWriter pw = new PrintWriter(fw);
					pw.println(VentanaPersona.this.printString);
					pw.close();
					Desktop.getDesktop().open(new File("deduccion.html"));
				}
				catch (IOException e2) {}
				
			}
        });
        
        this.limpiar = new JButton("Limpiar");
        this.limpiar.setPreferredSize(new Dimension(150,30));
        this.limpiar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				VentanaPersona.this.dispose();
				new VentanaPersona();
			}
        });
        
        this.regresar = new JButton("Regresar");
        this.regresar.setPreferredSize(new Dimension(150,30));
        this.regresar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				VentanaPersona.this.dispose();
				new Home();
			}
        });
        
        this.lbResultados = new JLabel("");
        this.lbResultados2 = new JLabel("");
        this.lbResultados3 = new JLabel("");
        
        // Anadir componentes al panel
        this.columnaIzquiera.add(lbNombre);
        this.columnaIzquiera.add(tfNombre);
        this.columnaIzquiera.add(lbRFC);
        this.columnaIzquiera.add(tfRFC);
        this.columnaIzquiera.add(lbSueldoMensual);
        this.columnaIzquiera.add(tfSueldoMensual);
        this.columnaIzquiera.add(lbAguinaldo);
        this.columnaIzquiera.add(tfAguinaldo);
        this.columnaIzquiera.add(lbPrimaVacacional);
        this.columnaIzquiera.add(tfPrimaVacacional);
        this.columnaIzquiera.add(lbHospitales);
        this.columnaIzquiera.add(tfHospitales);
        this.columnaIzquiera.add(lbFuneral);
        this.columnaIzquiera.add(tfFuneral);
        this.columnaIzquiera.add(lbSGMM);
        this.columnaIzquiera.add(tfSGMM);
        this.columnaDerecha.add(lbHipotecarios);
        this.columnaDerecha.add(tfHipotecarios);
        this.columnaDerecha.add(lbDonativos);
        this.columnaDerecha.add(tfDonativos);
        this.columnaDerecha.add(lbSubRetiro);
        this.columnaDerecha.add(tfSubRetiro);
        this.columnaDerecha.add(lbTransporte);
        this.columnaDerecha.add(tfTransporte);
        this.columnaDerecha.add(lbColegiatura);
        this.columnaDerecha.add(tfColegiatura);
        this.columnaDerecha.add(lbNivelEscolar);
        this.columnaDerecha.add(saltoDeLinea = new JLabel("⠀⠀⠀⠀⠀⠀⠀⠀⠀"));
        this.columnaDerecha.add(this.ninguno);
        this.columnaDerecha.add(saltoDeLinea = new JLabel("⠀⠀⠀⠀⠀⠀⠀⠀⠀"));
        this.columnaDerecha.add(this.primaria);
        this.columnaDerecha.add(saltoDeLinea = new JLabel("⠀⠀⠀⠀⠀⠀⠀⠀⠀"));
        this.columnaDerecha.add(this.secundaria);
        this.columnaDerecha.add(saltoDeLinea = new JLabel("⠀⠀⠀⠀⠀⠀⠀⠀⠀"));
        this.columnaDerecha.add(this.bachiller);
        this.columnaDerecha.add(saltoDeLinea = new JLabel("⠀⠀⠀⠀⠀⠀⠀⠀⠀"));
        this.columnaDerecha.add(saltoDeLinea = new JLabel("⠀⠀⠀⠀⠀⠀⠀⠀⠀"));
        this.columnaDerecha.add(saltoDeLinea = new JLabel("⠀⠀⠀⠀⠀⠀⠀⠀⠀"));
        this.columnaDerecha.add(calcular);
        this.columnaDerecha.add(guardar);
        this.columnaDerecha.add(limpiar);
        this.columnaDerecha.add(regresar);
        
        this.columnaResultados.add(this.lbResultados);
        this.columnaResultados.add(this.lbResultados2);
        this.columnaResultados.add(this.lbResultados3);
    
        this.setVisible(true);
	}
	
//	public void setAllEnabled(JPanel panel, boolean enabled){
//		JTextField[] components = new JTextField[] {this.tfNombre, this.tfRFC, this.tfSueldoMensual, this.tfAguinaldo, this.tfPrimaVacacional, this.tfHospitales};
//		for(int i=0; i<components.length; i++){
//			components[i].setEditable(enabled);
//		}
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == this.primaria){
			this.nivelEducativo = "primaria";
		}
		else if (e.getSource() == this.secundaria){
			this.nivelEducativo = "secundaria";
		}
		else if (e.getSource() == this.bachiller){
			this.nivelEducativo = "preparatoria";
		}
		else if (e.getSource() == this.ninguno){
			this.nivelEducativo = "";
		}
		else {
			
		String nombre = this.tfNombre.getText(),
			   rfc = this.tfRFC.getText();
		Double sueldo = Double.parseDouble(this.tfSueldoMensual.getText()),
			   aguinaldo = Double.parseDouble(this.tfAguinaldo.getText()),
			   prima = Double.parseDouble(this.tfPrimaVacacional.getText()),
			   medicos = Double.parseDouble(this.tfHospitales.getText()),
			   funeral = Double.parseDouble(this.tfFuneral.getText()),
			   sgmm = Double.parseDouble(this.tfSGMM.getText()),
			   hipoteca = Double.parseDouble(this.tfHipotecarios.getText()),
			   donativos = Double.parseDouble(this.tfDonativos.getText()),
			   retiro = Double.parseDouble(this.tfSubRetiro.getText()),
			   transporte = Double.parseDouble(this.tfTransporte.getText()),
			   colegiatura = Double.parseDouble(this.tfColegiatura.getText());
		
		Empleado persona = new Empleado(nombre,rfc,sueldo,aguinaldo,prima,medicos,funeral,sgmm,hipoteca,donativos,retiro,transporte,this.nivelEducativo,colegiatura);
		persona.hacerDeclaracionAnual();
		
		this.printString = "<html><b>Nombre: </b>" + this.tfNombre.getText() + "<br><b>RFC: </b>" + this.tfRFC.getText() + "<br></html>";
		
		String resultados = persona.getIngresos().ingresosToString();
		this.lbResultados.setText(resultados);
		this.printString += resultados;
		resultados = persona.getDeduccion().deduccionToString();
		this.lbResultados2.setText(resultados);
		this.printString += resultados;
		resultados = persona.getISR().isrToString();
		this.lbResultados3.setText(resultados);
		this.printString += resultados;
		
		// Desactivar todos los campos
		this.tfNombre.setEditable(false);
		this.tfRFC.setEditable(false);
		this.tfSueldoMensual.setEditable(false);
		this.tfAguinaldo.setEditable(false);
		this.tfPrimaVacacional.setEditable(false);
		this.tfHospitales.setEditable(false);
		this.tfFuneral.setEditable(false);
		this.tfHipotecarios.setEditable(false);
		this.tfSGMM.setEditable(false);
		this.tfDonativos.setEditable(false);
		this.tfTransporte.setEditable(false);
		this.tfSubRetiro.setEditable(false);
		this.tfColegiatura.setEditable(false);
		}
	}
}
