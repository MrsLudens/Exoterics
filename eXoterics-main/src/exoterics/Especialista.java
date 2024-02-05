/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exoterics;

/**
 *
 * @author vdpom
 */
public class Especialista {
    int id;
    String nome;
    String sobrenome;
    String especialidade;
    int idade;

    public Especialista(int id, String nome, String sobrenome, String especialidade, int idade) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.especialidade = especialidade;
        this.idade = idade;
    }

    public Especialista(String nome, String sobrenome, String especialidade, int idade) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.especialidade = especialidade;
        this.idade = idade;
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

    public String getEspecialidade() {
        return especialidade;
    }

    public int getIdade() {
        return idade;
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

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

