import java.lang.Math;

public class Ingresos {
	private double sueldoMensual,
	 							 aguinaldo,
								 primaVacacional,
								 salarioMinimo;

	// Constructor
	public Ingresos(double sueldoMensual, double aguinaldo, double primaVacacional){
		this.sueldoMensual = sueldoMensual;
		this.aguinaldo = aguinaldo;
		this.primaVacacional = primaVacacional;
		this.salarioMinimo = 80.04;
	}


	 public double getSueldoAnual(){
		 return this.sueldoMensual * 12;
	 }

	 public double getAguinaldoGravado(){
		 double aguinaldoReturn = 0;
		 
		 if(this.aguinaldo > (this.sueldoMensual/30)*15){
			 aguinaldoReturn = this.aguinaldo - (this.sueldoMensual/30)*15;
		 }

		 return aguinaldoReturn;
	 }

	 public double getAguinaldoExcento(){
		 return this.aguinaldo - this.getAguinaldoGravado();
	 }

	 public double getPrimaVacacionalGravada(){
		 double primaReturn = 0;
		 if(this.primaVacacional > this.salarioMinimo*15){
			 primaReturn = Math.round((this.primaVacacional - this.salarioMinimo*15) * 1000.0)/1000.0;
		 }

		 return primaReturn;
	 }

	 public double getPrimaVacacionalExcenta(){
		 return this.primaVacacional - this.getPrimaVacacionalGravada();
	 }

	 public double getTotalIngresos(){
		 return this.getSueldoAnual() + this.aguinaldo + this.primaVacacional;
	 }

	 public double getIngresosGravados(){
		 return this.getSueldoAnual() + getAguinaldoGravado() + getPrimaVacacionalGravada();
	 }

}
