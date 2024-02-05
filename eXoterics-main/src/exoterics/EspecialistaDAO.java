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
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EspecialistaDAO {
    public Especialista readEspecialista(int id) {
        try {
            Connection conn = ConexaoSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM especialista WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                String nome = rs.getString(2);
                String sobrenome = rs.getString(3);
                String especialidade = rs.getString(4);
                int idade = rs.getInt(5);
                Especialista e = new Especialista(id, nome, sobrenome, especialidade, idade);
                return e;
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(EspecialistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } // ok
    public ArrayList<Especialista> listEspecialista(){
        ArrayList<Especialista> minhaListaTitles = new ArrayList<Especialista>();

        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM especialista");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String sobrenome = rs.getString(3);
                String especialidade = rs.getString(4);
                int idade = rs.getInt(5);
                Especialista e = new Especialista(id, nome, sobrenome, especialidade, idade);
                minhaListaTitles.add(e);
            }
            conn.close();
        }catch (SQLException ex){
            Logger.getLogger(EspecialistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return minhaListaTitles;
    }
    public int insertEspecialista(Especialista E) {
        try {
            Scanner teclado = new Scanner(System.in);
            Connection conn = ConexaoSQL.getConexaoMySQL();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO especialista(nome, sobrenome, especialidade, idade) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, E.getNome());
            ps.setString(2, E.getSobrenome());
            ps.setString(3, E.getEspecialidade());
            ps.setInt(4, E.getIdade());

            int retorno = ps.executeUpdate();
            conn.close();
            return retorno;

        } catch (SQLException ex) {
            Logger.getLogger(EspecialistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0; // inserção falhou
    } // ok
    public static int updateEspecialista(Especialista e) {
        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();

            PreparedStatement ps = conn.prepareStatement("UPDATE especialista SET nome=?, sobrenome=?, especialidade=?, idade=? WHERE id=?");
            ps.setString(1, e.getNome());
            ps.setString(2, e.getSobrenome());
            ps.setString(3, e.getEspecialidade());
            ps.setInt(4, e.getIdade());
            ps.setInt(5, e.getId());

            int rowCount = ps.executeUpdate();

            conn.close();

            return rowCount;
        }catch (SQLException ex){
            Logger.getLogger(EspecialistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static int deleteEspecialista(int id) {
        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM especialista WHERE id=?");
            ps.setInt(1, id);

            int rowCount = ps.executeUpdate();

            conn.close();

            return rowCount;
        }catch (SQLException ex){
            Logger.getLogger(EspecialistaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}

