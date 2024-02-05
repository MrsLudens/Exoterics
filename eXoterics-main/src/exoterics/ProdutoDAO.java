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

public class ProdutoDAO {

    public Produto readProduto(int id) {
        try {
            Connection conn = ConexaoSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM produtos WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                String nome = rs.getString(2);
                double valor = rs.getDouble(3);
                int idEsp = rs.getInt(4);
                Produto p = new Produto(id, nome, valor, idEsp);
                return p;
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } // ok
    public ArrayList<Produto> listProduto(){
        ArrayList<Produto> minhaListaP = new ArrayList<Produto>();

        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM produtos");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                double valor = rs.getDouble(3);
                int idEsp = rs.getInt(4);
                Produto p = new Produto(id, nome, valor, idEsp);
                minhaListaP.add(p);
            }
            conn.close();
        }catch (SQLException ex){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return minhaListaP;
    }
    public int insertProduto(Produto P) {
        try {
            Scanner teclado = new Scanner(System.in);
            Connection conn = ConexaoSQL.getConexaoMySQL();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO produtos (nome, valor) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, P.getNome());
            ps.setDouble(2, P.getValor());

            int retorno = ps.executeUpdate();
            conn.close();
            return retorno;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0; // inserção falhou
    } // ok
    public static int updateProduto(Produto p) {
        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();

            PreparedStatement ps = conn.prepareStatement("UPDATE produtos SET nome=?, valor=? WHERE id=?");
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getValor());
            ps.setInt(3, p.getId());

            int rowCount = ps.executeUpdate();

            conn.close();

            return rowCount;
        }catch (SQLException ex){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static int deleteProduto(int id) {
        try{
            Connection conn = ConexaoSQL.getConexaoMySQL();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM produtos WHERE id=?");
            ps.setInt(1, id);

            int rowCount = ps.executeUpdate();

            conn.close();

            return rowCount;
        }catch (SQLException ex){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public static int associarProdutoComEspecialista(Produto p){
         try{
            Connection conn = ConexaoSQL.getConexaoMySQL();
           
            PreparedStatement ps = conn.prepareStatement("UPDATE produtos SET atEspecialista=? WHERE id=?");
            ps.setInt(1, p.getAtEspecialista());
            ps.setInt(2, p.getId());

            int rowCount = ps.executeUpdate();

            conn.close();

            return rowCount;
            
        } catch(SQLException ex){
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return 0;
    }
}