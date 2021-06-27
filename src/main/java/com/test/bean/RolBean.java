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
public class RolBean {
    //creacion de atributos para conectar con la base de datos
    private VariablesConexion variable;
    private Connection conexion;
    private PreparedStatement insertRol;
    //constructor e iniciar la conexion
    public RolBean() throws SQLException
    {
        variable=new VariablesConexion();
        variable.inicioConexion();
        conexion=variable.getConnection();
    }
    //cerrar la conexion
    @PreDestroy
    public void CerrarConexion()
    {
        variable.cerrarConexion();
    }
    //mostrar los roles
    public String mostrarRol()
    {
        StringBuilder salidaTabla=new StringBuilder();
        StringBuilder query=new StringBuilder();
        try{
            query.append("SELECT cod_rol, nombre_rol FROM rol;");
            PreparedStatement pst=conexion.prepareStatement(query.toString());
            ResultSet result=pst.executeQuery();
            while(result.next())
            {
                salidaTabla.append("<option value='"+result.getInt(1)+"'>");
                salidaTabla.append(result.getString(2));
                salidaTabla.append("</option>");
            }
        }catch(Exception e){
            System.out.println(e);
            salidaTabla.append("ERROR EN LA CONSULTA");
        }
        return salidaTabla.toString();
    }
}
