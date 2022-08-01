
package Controlador;

import Modelo.*;
import Vistas.AddUserForm;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import java.awt.event.*;

public class ControllerSucursalesPuestoTrabajo implements ActionListener{
    private final AddUserForm view;
    ArrayList<DatosSucursalPuestoTrabajo> list;
    DatosModeloDB model = new DatosModeloDB();
    
    public ControllerSucursalesPuestoTrabajo(AddUserForm view){
        this.view = view;
        this.getListaSucursales();
        Sucursal sucursal = (Sucursal)view.CbSucursal.getSelectedItem();
        getListaPuestosTrabajo(sucursal.getIdSucursal());
        events();
    }
    
    public final void events(){
        view.CbSucursal.addActionListener(this);
    }
    
    public final void getListaSucursales(){
        list = model.getSucursales();
        if(list.size() > 0){
            for(int i = 0; i<list.size();i++){
                int idSucursal = list.get(i).getIdSucursal();
                String nombreSucursal = list.get(i).getNombreSucursal();
                view.CbSucursal.addItem(new Sucursal(idSucursal, nombreSucursal));
            }
        }else{
            JOptionPane.showMessageDialog(null, "No Existen Sucursales Aún.","Sucursales",JOptionPane.WARNING_MESSAGE);
        }
    }
   
    public final void getListaPuestosTrabajo(int idSucursal){
        list = model.getPuestosTrabajo(idSucursal);
         if(list.size() > 0){
            for(int i = 0; i< list.size();i++){
                DefaultComboBoxModel model = (DefaultComboBoxModel)view.CbPuestoTrabajo.getModel();
                Object[] puestoTrabajo = new Object[2];
                puestoTrabajo[0]=list.get(i).getIdPuestoTrabajo();
                puestoTrabajo[1]=list.get(i).getNombrePuestoTrabajo();
                model.addElement(puestoTrabajo[1]);
                view.CbPuestoTrabajo.setModel(model);
                System.out.println(model);
            }
        }
    }


     
    @Override
    public void actionPerformed(ActionEvent ae){
        Object evento = ae.getSource();
        if(evento.equals(view.CbSucursal)){
            view.CbPuestoTrabajo.removeAllItems();
            Sucursal sucursal = (Sucursal)view.CbSucursal.getSelectedItem();
            getListaPuestosTrabajo(sucursal.getIdSucursal());
        }
    }
    

}
