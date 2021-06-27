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
 * @author Miriam Lopez
 */
public class ProductoBean {

    //atributos
    private VariablesConexion variable;
    private Connection connection;
    private PreparedStatement insertCategoria;
    //constructores
    public ProductoBean() throws SQLException {
        variable = new VariablesConexion();
        variable.inicioConexion();
        connection = variable.getConnection();
        System.out.println("Iniciando la conexion");
    }

    @PreDestroy
    public void cerrarConexion() {
        variable.cerrarConexion();
    }

    //metodos
    public String listarProducto() {
        StringBuilder salidaTabla = new StringBuilder();
        StringBuilder query = new StringBuilder();
        query.append(" select  p.nom_pro, p.des_pro, p.costo_uc, p.costo_uv, p.stock , prov.razon_social, c.nom_cat ");
        query.append(" from producto  p ");
        query.append(" inner join proveedor prov ON p.cod_prov = prov.cod_prov ");
        query.append(" inner join categoria c ON c.cod_cat=p.cod_cat ");
        try {
            PreparedStatement pst = connection.prepareStatement(query.toString());
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                salidaTabla.append("<tr>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(1));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(2));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getDouble(3));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getDouble(4));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getInt(5));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(6));
                salidaTabla.append("</td>");
                salidaTabla.append("<td>");
                salidaTabla.append(resultado.getString(7));
                salidaTabla.append("</td>");
                salidaTabla.append("</tr>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error de conexion");
        }
        return salidaTabla.toString();
    }
    //buscar todos los producto de una determinada categoria
    public String buscarProductosPorCategoria(int nroCategoria)
    {
        StringBuilder salidaTabla=new StringBuilder();
        StringBuilder query=new StringBuilder();
        query.append(" select p.nom_pro,p.des_pro,p.costo_uc,p.costo_uv,p.stock,pr.razon_social ");
        query.append(" from producto as p ");
        query.append(" inner join proveedor as pr on pr.cod_prov=p.cod_prov");
        query.append(" where p.cod_cat="+nroCategoria);
        try{
            PreparedStatement pst=connection.prepareStatement(query.toString());
            ResultSet resultado=pst.executeQuery();
            while(resultado.next())
            {
                salidaTabla.append("<tr>");
                    salidaTabla.append("<td>"+resultado.getString(1)+"</td>");
                    salidaTabla.append("<td>"+resultado.getString(2)+"</td>");
                    salidaTabla.append("<td>"+resultado.getDouble(3)+"</td>");
                    salidaTabla.append("<td>"+resultado.getDouble(4)+"</td>");
                    salidaTabla.append("<td>"+resultado.getInt(5)+"</td>");
                    salidaTabla.append("<td>"+resultado.getString(6)+"</td>");
                salidaTabla.append("</tr>");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return salidaTabla.toString();
    }
    //getter y setter

}
