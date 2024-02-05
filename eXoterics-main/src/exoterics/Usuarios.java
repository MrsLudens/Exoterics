/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exoterics;

/**
 *
 * @author vdpom
 */
public class Usuarios {
    int id;
    String nome;
    String sobrenome;
    int idade;
    String signo;
    int atCompra;

    public Usuarios(int id, String nome, String sobrenome, int idade, String signo, int atCompra) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.signo = signo;
        this.atCompra = atCompra;
    }

    public Usuarios(String nome, String sobrenome, String signo, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.signo = signo;
        this.idade = idade;
    }

    public int getAtCompra() {
        return atCompra;
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public String getSigno() {
        return signo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSigno(String signo) {
        this.signo = signo;
    }

    public void setAtCompra(int atCompra) {
        this.atCompra = atCompra;
    }
    
}

