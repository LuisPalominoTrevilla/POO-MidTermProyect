
public class Deduccion {
	private final int MAXIMO_PRIMARIA = 12900;
	private final int MAXIMO_SECUNDARIA = 19900;
	private final int MAXIMO_PREPARATORIA = 24500;
	
	private Empleado empleado;
	private double medicosHospitales;
	private double gastosFunerarios;
	private double sgmm;
	private double gastosHipotecarios;
	private double donativos;
	private double retiro;
	private double transporteEscolar;
	private String nivelEducativo;
	private double colegiatura;
	
	
	public Deduccion(Empleado empleado, double medicosHospitales, double gastosFunerarios, double sgmm, double gastosHipotecarios, double donativos, double retiro, double transporteEscolar, String nivelEducativo, double colegiatura){
		this.empleado = empleado;
		this.medicosHospitales = medicosHospitales;
		this.gastosFunerarios = gastosFunerarios;
		this.sgmm = sgmm;
		this.gastosHipotecarios = gastosHipotecarios;
		this.donativos = donativos;
		this.retiro = retiro;
		this.transporteEscolar = transporteEscolar;
		this.nivelEducativo = nivelEducativo;
		this.colegiatura = colegiatura;
	}
	
	public Deduccion(Empleado empleado){
		this.empleado = empleado;
	}

	public double getMaximoDeducirColegiatura(){
		/*
		 *  Regresa el maximo a deducir de colegiatura considerando la colegiatura y el nivel educativo
		 */
		switch(this.nivelEducativo.toLowerCase()){
		case "primaria":
			return (this.MAXIMO_PRIMARIA < this.colegiatura)? this.MAXIMO_PRIMARIA: this.colegiatura;
		case "secundaria":
			return (this.MAXIMO_SECUNDARIA < this.colegiatura)? this.MAXIMO_SECUNDARIA: this.colegiatura;
		case "preparatoria":
			return (this.MAXIMO_PREPARATORIA < this.colegiatura)? this.MAXIMO_PREPARATORIA: this.colegiatura;
		default:
			return 0.0;
		}
	}
	
	public double getTotalDeducciones(){
		/*
		 * Regresa el total de deducciones SIN incluir el retiro
		 */
		return this.medicosHospitales + this.gastosFunerarios + this.sgmm + this.gastosHipotecarios + this.donativos + this.transporteEscolar + this.getMaximoDeducirColegiatura();
	}
	
	public double getDeduccionPermitida(){
		double deduccionRetiro = 0;
		double deduccionNormal = 0;
		final double MAXIMO_DEDUCIR = this.empleado.getIngresos().getTotalIngresos()*.10;
		
		deduccionRetiro = (this.retiro > MAXIMO_DEDUCIR)? MAXIMO_DEDUCIR:this.retiro;
		deduccionNormal = (this.getTotalDeducciones() > MAXIMO_DEDUCIR)? MAXIMO_DEDUCIR: this.getTotalDeducciones();
		return deduccionRetiro + deduccionNormal;
	}
	
	
}
