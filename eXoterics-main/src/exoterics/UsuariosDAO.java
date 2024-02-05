/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exoterics;

/**
 *
 * @author vdpom
 */
import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosDAO {

    public Usuarios read(int id) {
        try {
            Connection conn = ConexaoSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuarios WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                String nome = rs.getString(2);
                String sobrenome = rs.getString(3);
                int idade = rs.getInt(4);
                String signo = rs.getString(5);
                int atP = rs.getInt(6);
                Usuarios u = new Usuarios(id, nome, sobrenome, idade, signo, atP);
                return u;
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } // ok
    public ArrayList<Usuarios> list(){
        ArrayList<Usuarios> minhaLista = new ArrayList<Usuarios>();

        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String sobrenome = rs.getString(3);
                int idade = rs.getInt(4);
                String signo = rs.getString(5);
                int atP = rs.getInt(6);
                Usuarios u = new Usuarios(id, nome, sobrenome, idade, signo, atP);
                minhaLista.add(u);
            }
            conn.close();
        }catch (SQLException ex){
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return minhaLista;
    }
    public int insert(Usuarios U) {
        try {
            Scanner teclado = new Scanner(System.in);
            Connection conn = ConexaoSQL.getConexaoMySQL();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO usuarios (nome, sobrenome, signo, idade) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, U.getNome());
            ps.setString(2, U.getSobrenome());
            ps.setString(3, U.getSigno());
            ps.setInt(4, U.getIdade());

            int retorno = ps.executeUpdate();
            conn.close();
            return retorno;

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0; // inserção falhou
    } // ok
    public static int update(Usuarios u) {
        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();

            PreparedStatement ps = conn.prepareStatement("UPDATE usuarios SET nome=?, sobrenome=?, idade=?, signo=? WHERE id=?");
            ps.setString(1, u.getNome());
            ps.setString(2, u.getSobrenome());
            ps.setInt(3, u.getIdade());
            ps.setString(4, u.getSigno());
            ps.setInt(5, u.getId());

            int rowCount = ps.executeUpdate();

            conn.close();

            return rowCount;
        }catch (SQLException ex){
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static int delete(int id) {
        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM usuarios WHERE id=?");
            ps.setInt(1, id);

            int rowCount = ps.executeUpdate();

            conn.close();

            return rowCount;
        }catch (SQLException ex){
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static int associarCompraComUsuario(Usuarios u){
         try{
            Connection conn = ConexaoSQL.getConexaoMySQL();
           
            PreparedStatement ps = conn.prepareStatement("UPDATE usuarios SET atCompra=? WHERE id=?");
            ps.setInt(1, u.getAtCompra());
            ps.setInt(2, u.getId());

            int rowCount = ps.executeUpdate();

            conn.close();

            return rowCount;
            
        } catch(SQLException ex){
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return 0;
    }
}

