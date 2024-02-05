/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exoterics;

/**
 *
 * @author vdpom
 */
public class Consulta {
    String hora;
    String dat;
    int atUsuario;
    int atEspecialista;

    public Consulta(String hora, String dat, int atUsuario, int atEspecialista) {
        this.hora = hora;
        this.dat = dat;
        this.atUsuario = atUsuario;
        this.atEspecialista = atEspecialista;
    }

    public String getHora() {
        return hora;
    }

    public String getDat() {
        return dat;
    }

    public int getAtUsuario() {
        return atUsuario;
    }

    public int getAtEspecialista() {
        return atEspecialista;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public void setAtUsuario(int atUsuario) {
        this.atUsuario = atUsuario;
    }

    public void setAtEspecialista(int atEspecialista) {
        this.atEspecialista = atEspecialista;
    }
}

