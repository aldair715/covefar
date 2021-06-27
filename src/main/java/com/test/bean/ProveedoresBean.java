/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.bean;

import com.test.conexion.VariablesConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.PreDestroy;

/**
 *
 * @author hp
 */
public class ProveedoresBean {
    private VariablesConexion variable;
    private Connection conexion;
    private PreparedStatement insertarProveedor;
    //iniciando la conexion
    public ProveedoresBean() throws SQLException{
        variable=new VariablesConexion();
        variable.inicioConexion();
        conexion=variable.getConnection();
    }
    //eliminando la conexion
    @PreDestroy
    public void cerrarConexion()
    {
        variable.cerrarConexion();
    }
    //mostrando la lista de proveedores
    public String mostrarProveedores()
    {
        StringBuilder SalidaTabla=new StringBuilder();
        StringBuilder query=new StringBuilder();
        try{
            query.append("SELECT cod_prov, razon_social, direccion, telefono, email FROM proveedor;");
            PreparedStatement pst=conexion.prepareStatement(query.toString());
            ResultSet resultado=pst.executeQuery();
            int $i=1;
            while(resultado.next())
            {
                SalidaTabla.append("<tr>");
                    SalidaTabla.append("<td>"+$i+"</td>");
                    SalidaTabla.append("<td>"+resultado.getString(2)+"</td>");
                    SalidaTabla.append("<td>"+resultado.getString(3)+"</td>");
                    SalidaTabla.append("<td>"+resultado.getInt(4)+"</td>");
                    SalidaTabla.append("<td>"+resultado.getString(5)+"</td>");
                    SalidaTabla.append("<td class='btn btn-danger' data-eliminar="+resultado.getInt(1)+">ELIMINAR</td>");
                     SalidaTabla.append("<td class='btn btn-primary' data-editar="+resultado.getInt(1)+">MODIFICAR</td>");
                SalidaTabla.append("</tr>");
                $i++;
            }
        }catch(SQLException e)
        {
            SalidaTabla.append("ERROR EN LA CONEXION");
        }
        return SalidaTabla.toString();
    }
    
}
