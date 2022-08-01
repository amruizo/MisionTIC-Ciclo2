
package Modelo;


public class Operario extends Empleado{
    private boolean manejaMaquinaPesada;

    public Operario(boolean manejaMaquinaPesada, float salario, String puestoTrabajo, int idPersona, String nombrePersona, String correo) {
        super(salario, puestoTrabajo, idPersona, nombrePersona, correo);
        this.manejaMaquinaPesada = manejaMaquinaPesada;
    }

    public Operario(boolean manejaMaquinaPesada) {
        this.manejaMaquinaPesada = manejaMaquinaPesada;
    }

    public boolean isManejaMaquinaPesada() {
        return manejaMaquinaPesada;
    }

    public void setManejaMaquinaPesada(boolean manejaMaquinaPesada) {
        this.manejaMaquinaPesada = manejaMaquinaPesada;
    }

    @Override
    public String toString() {
        return "Operario{" + "manejaMaquinaPesada=" + manejaMaquinaPesada + '}';
    }
  
    
}
