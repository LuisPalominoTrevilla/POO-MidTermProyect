
public class Pruebas {

	public static void main(String[] args) {
		Empresa e = new Empresa(3);
		e.addEmpleado(new Empleado("luis", "oeffperg", 6000, 3000, 1000, 5600, 50000, 25000, 40500, 1000, 25000, 100, "primaria", 4000));
		e.addEmpleado(new Empleado("luis", "oeffperg", 6000, 3000, 1000, 5600, 50000, 25000, 40500, 1000, 25000, 100, "primaria", 4000));
		e.addEmpleado(new Empleado("luis", "oeffperg", 6000, 3000, 1000, 5600, 50000, 25000, 40500, 1000, 25000, 100, "primaria", 4000));
		e.addEmpleado(new Empleado("luis", "oeffperg", 6000, 3000, 1000, 5600, 50000, 25000, 40500, 1000, 25000, 100, "primaria", 4000));
		e.addEmpleado(new Empleado("luis", "oeffperg", 6000, 3000, 1000, 5600, 50000, 25000, 40500, 1000, 25000, 100, "primaria", 4000));
		
		System.out.println(e.getEmpleados()[0].getDeduccion().getDeduccionPermitida());
		//System.out.println(e.getEmpleados().length);
	}
}
