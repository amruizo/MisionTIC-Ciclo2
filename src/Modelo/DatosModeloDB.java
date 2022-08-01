
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DatosModeloDB {
    Conexion conexion = new Conexion();
    Connection connection;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;
    DatosSucursalPuestoTrabajo datosDB;
    
    public ArrayList<DatosSucursalPuestoTrabajo> getPuestosTrabajo(int idSucursal){
        ArrayList listaPuestosTrabajo = new ArrayList();
        String query ="SELECT idPuestoTrabajo, nombrePuestoTrabajo, salario, FK_idSucursal FROM PuestoTrabajo INNER JOIN Sucursal ON (Sucursal.idSucursal = PuestoTrabajo.FK_idSucursal) WHERE Sucursal.idSucursal= ?;";
        try{
            connection = conexion.getConnection();
            pst = connection.prepareStatement(query);
            pst.setInt(1, idSucursal);
            rs = pst.executeQuery();
            while(rs.next()){
                datosDB = new DatosSucursalPuestoTrabajo();
                int idPuestoTrabajo = rs.getInt("idPuestoTrabajo");
                String nombrePuestoTrabajo = rs.getString("nombrePuestoTrabajo");
                float salario = rs.getFloat("salario");
                datosDB.setIdPuestoTrabajo(idPuestoTrabajo);
                datosDB.setNombrePuestoTrabajo(nombrePuestoTrabajo);
                datosDB.setSalario(salario);
                listaPuestosTrabajo.add(datosDB);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        System.out.println("Puestos de trabajo: "+listaPuestosTrabajo);
        return listaPuestosTrabajo;
    }
    
    public ArrayList<DatosSucursalPuestoTrabajo> getSucursales(){
        ArrayList listaSucursales = new ArrayList();
        String query ="SELECT idSucursal, nombreSucursal FROM Sucursal;";
        try{
            connection = conexion.getConnection();
            pst = connection.prepareCall(query);
            rs = pst.executeQuery();
            while(rs.next()){
                datosDB = new DatosSucursalPuestoTrabajo();
                int idSucursalC = rs.getInt("idSucursal");
                String nombreSucursal = rs.getString("nombreSucursal");
                datosDB.setIdSucursal(idSucursalC);
                datosDB.setNombreSucursal(nombreSucursal);
                listaSucursales.add(datosDB);    
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        System.out.println("Sucursales: "+listaSucursales);
        return listaSucursales;
    }

}
