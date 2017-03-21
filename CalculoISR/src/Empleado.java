
public class Empleado extends Persona{
	private String rfc;
	private Deduccion deducciones;
	private Ingresos ingresos;
	private ISR impuestoISR;
	
	public Empleado(String nombre, String rfc, Deduccion deducciones, Ingresos ingresos){
		super(nombre);
		this.rfc = rfc;
		this.deducciones = deducciones;
		this.ingresos = ingresos;
	}
	
	public Ingresos getIngresos(){
		return this.ingresos;
	}
	
	public Deduccion getDeduccion(){
		return this.deducciones;
	}
	
	public String getRFC(){
		return this.rfc;
	}
	
	public ISR getISR(){
		return this.impuestoISR;
	}
	
	public void hacerDeclaracionAnual(){
		
	}
}
