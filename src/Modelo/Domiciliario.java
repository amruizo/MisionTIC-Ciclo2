
package Modelo;

public class Domiciliario extends Empleado {
    private String tipoTransporte;

    public Domiciliario(String tipoTransporte, float salario, String puestoTrabajo, int idPersona, String nombrePersona, String correo) {
        super(salario, puestoTrabajo, idPersona, nombrePersona, correo);
        this.tipoTransporte = tipoTransporte;
    }

    public Domiciliario() {
    }
    
    public Domiciliario(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public String getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(String tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    @Override
    public String toString() {
        return "Domiciliario{" + "tipoTransporte=" + tipoTransporte + '}';
    }
    
    
    
}
