/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exoterics;

/**
 *
 * @author vdpom
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultaDAO {
    public void associarUsuarioEspecialista(int id, int idE){
        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO consulta (atUsuario, atEspecialista) VALUES (?, ?)");
            ps.setInt(1, id);
            ps.setInt(2, idE);

            ps.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void desassociarUsuarioEspecialista(int id, int idE){
        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM consulta WHERE atUsuario=? AND atEspecialista=?");
            ps.setInt(1, id);
            ps.setInt(2, idE);

            ps.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Usuarios> buscarUsuariosPorEspecialista(int idE){
        ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();

        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT usuarios.*, consulta.atespecialista FROM Consulta"
                    + "JOIN usuarios ON Consulta.atUsuario = Usuarios.id WHERE Consulta.atEspecialista=?");

            ps.setInt(1, idE);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Usuarios u = new Usuarios(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                usuarios.add(u);
            }
        } catch (SQLException ex){
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }

    public ArrayList<Especialista> buscarEspecialistaPorUsuario(int id){
        ArrayList<Especialista> livros = new ArrayList<Especialista>();

        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT especialista.*, Consulta.atUsuario FROM Consulta"
                    + "JOIN especialista ON Consulta.atEspecialista = Especialista.id WHERE Consulta.atUsuario=?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Especialista t = new Especialista(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                livros.add(t);
            }
        } catch (SQLException ex){
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return livros;
    }
}

