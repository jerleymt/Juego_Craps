package Modelo;

import java.util.Vector;

/**
 * Esta clase aplica las reglas del juego
 * */
public class Tirar_dados {
    private Vector<Dado> dado;
    private int tiro;
    //Vector donde se guarda las dos caras del dado
    private int[] caras;

    public Tirar_dados() {
        dado = new Vector<Dado>();
        caras = new int[2];
        tiro = 0;
    }

    public Vector<Dado> getDado() {
        return dado;
    }

    public void setDado(Dado dado) {
        dado = new Dado();
        this.dado.addElement(dado);
    }

    public void tirar_dado() {
        setDado(new Dado());
        setDado(new Dado());
        setDado(new Dado());
        caras[0] = dado.get(0).get_cara();
        caras[1] = dado.get(1).get_cara();
        tiro = caras[0] + caras[1];
        int tamano = dado.size();
        System.out.println("Cara #1/"+ caras[0]+", Cara #2/ "+caras[1]+" tamaño vector "+tamano);
    }
}