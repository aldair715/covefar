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
public class UsuarioBean {
    private VariablesConexion variable;
    private Connection conexion;
    private PreparedStatement insertRol;
    //constructor e iniciar la conexion
    public UsuarioBean() throws SQLException
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
    public String buscarUsuarioPorRol(int id_rol)
    {
        StringBuilder salidaTabla=new StringBuilder();
        StringBuilder query=new StringBuilder();
        try{
            query.append("select concat(us.ap_pat,' ',us.ap_mat,' ',us.nombres) as nombreCompleto,us.cedula,us.codigo,rol.nombre_rol from usuario as us inner join rol on rol.cod_rol=us.cod_rol where us.cod_rol="+id_rol);
            PreparedStatement pst=conexion.prepareStatement(query.toString());
            ResultSet result=pst.executeQuery();
            int $i=1;
            while(result.next())
            {
                salidaTabla.append("<tr>");
                salidaTabla.append("<td>"+$i+"</td>");
                salidaTabla.append("<td>"+result.getString(1)+"</td>");
                salidaTabla.append("<td>"+result.getInt(2)+"</td>");
                salidaTabla.append("<td>"+result.getString(3)+"</td>");
                salidaTabla.append("<td>"+result.getString(4)+"</td>");
                salidaTabla.append("</tr>");
                $i++;
            }
        }catch(Exception e){
            System.out.println(e);
            salidaTabla.append("ERROR EN LA CONSULTA");
        }
        return salidaTabla.toString();
    }
}
