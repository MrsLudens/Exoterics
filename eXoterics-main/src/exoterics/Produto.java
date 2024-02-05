/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exoterics;

/**
 *
 * @author vdpom
 */
public class Produto {
    int id;
    String nome;
    double valor;
    int atEspecialista;

    public Produto(int id, String nome, double valor, int atEspecialista) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.atEspecialista = atEspecialista;
    }

    public Produto(String nome, double valor, int atEspecialista) {
        this.nome = nome;
        this.valor = valor;
        this.atEspecialista = atEspecialista;
    }

    public Produto(String nome, double valor) {
        this.nome = nome;
        this.valor = valor;
    }
    

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getAtEspecialista() {
        return atEspecialista;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setAtEspecialista(int atEspecialista) {
        this.atEspecialista = atEspecialista;
    }
}
