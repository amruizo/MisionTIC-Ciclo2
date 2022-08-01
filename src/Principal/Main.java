//Autor: Angela Ruiz Osorno (1/07/2022) MusionTIC2022
package Principal;

//Importación de todas las vistasde usuario
import Vistas.*;  
import Modelo.*;

public class Main {

    public static void main(String[] args) {
    //Crear instancia de la clase Conexión
    Conexion conexion = new Conexion();
    DatosModeloDB datos = new DatosModeloDB();
    datos.getPuestosTrabajo(1);
    datos.getSucursales();
    //Verificar conexion exitosa 
    conexion.getConnection();
    //Instanciación del JFrame Login
    Login login = new Login();
     //Hacer visible la lista login
    login.setVisible(true);
    
    }
}
