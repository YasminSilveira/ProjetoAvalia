/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author s.lucas
 */
public class UsuarioDao {
    Connection con;
    
    public UsuarioDao() throws SQLException {
       con = ConnectionFactory.getConnection();
       
    }
    
    public boolean checkLogin(String email, String senha){
       
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tbusuario"
            + "where email = ? AND senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                check = true;
            }
            
        }catch (SQLException e){
            JOptionPane.showConfirmDialog(null, "Erro: "
            +e.getLocalizedMessage());
        }
        return check;
    }
    
    public void create (Usuario u) {
    PreparedStatement stmt = null;
    try {
        stmt = con.prepareStatment ("INSERT INTO tbusuario (id, nome,"+
                "email, senha, tipo) VALUE (?,?,?,?)");
        stmt.setString (1, u.getNome());
        stmt.setString (2, u.getEmail());
        stmt.setString (3, u.getSenha ());
        stmt.setString (4, u.getTipo());
        
    }
    }
    
}