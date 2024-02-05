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

public class CompraDAO {
    public Compra readCompra(int id) {
        try {
            Connection conn = ConexaoSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM compra WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                int idUs = rs.getInt(2);
                int idPr = rs.getInt(3);
                Compra c = new Compra(id, idUs, idPr);
                return c;
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Compra> listCompra(){
        ArrayList<Compra> minhaListaC = new ArrayList<Compra>();

        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM compra");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt(1);
                int atUs = rs.getInt(2);
                int atPr = rs.getInt(3);
                Compra c = new Compra(id, atUs, atPr);
                minhaListaC.add(c);
            }
            conn.close();
        }catch (SQLException ex){
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return minhaListaC;
    }
    
    public void associarUsuarioProduto(int id, int idP){
        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO compra (atUsuario, atProduto) VALUES (?, ?)");
            ps.setInt(1, id);
            ps.setInt(2, idP);

            ps.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void desassociarUsuarioProduto(int id, int idP){
        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM compra WHERE atUsuario=? AND atProduto=?");
            ps.setInt(1, id);
            ps.setInt(2, idP);

            ps.executeUpdate();
        } catch(SQLException ex){
            Logger.getLogger(CompraDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

