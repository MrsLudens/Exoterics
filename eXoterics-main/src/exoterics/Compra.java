/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exoterics;

/**
 *
 * @author vdpom
 */
public class Compra {
    int id;
    int atUsuario;
    int atProduto;

    public Compra(int id, int atUsuario, int atProduto) {
        this.id = id;
        this.atUsuario = atUsuario;
        this.atProduto = atProduto;
    }

    public Compra(int atUsuario, int atProduto) {
        this.atUsuario = atUsuario;
        this.atProduto = atProduto;
    }
    

    public int getId() {
        return id;
    }

    public int getAtUsuario() {
        return atUsuario;
    }

    public int getAtProduto() {
        return atProduto;
    }

    public void setAtUsuario(int atUsuario) {
        this.atUsuario = atUsuario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAtProduto(int atProduto) {
        this.atProduto = atProduto;
    }
}
