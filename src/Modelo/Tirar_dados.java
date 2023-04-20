package Modelo;

import java.util.Vector;

/**
 * Esta clase aplica las reglas del juego
 * */
public class Tirar_dados {
    private final Vector<Dado> dado;
    private int tiro;
    private final int cantidad_de_dados;
    private int sumatoria;
    //Vector donde se guarda las dos caras del dado
    private final Vector<Integer> caras;

    public Tirar_dados() {
        dado = new Vector<Dado>();
        tiro = 0;
        sumatoria = 0;
        caras = new Vector<>(0);
        cantidad_de_dados=0;
    }
    public Tirar_dados(int cantidad_de_dados) {
        dado = new Vector<Dado>();
        tiro = 0;
        sumatoria = 0;
        caras = new Vector<>(0);
        this.cantidad_de_dados=cantidad_de_dados-1;
    }

    public Vector<Dado> getDado() {
        return dado;
    }

    public int getSumatoria() {
        return sumatoria;
    }

    public void setSumatoria(int sumatoria) {
        this.sumatoria = sumatoria;
    }

    public void setDado(Dado dado) {
        dado = new Dado();
        this.dado.addElement(dado);
    }

    public int getTiro() {
        return tiro;
    }

    public void setTiro(int tiro) {
        this.tiro = tiro;
    }

    public void tirar_dado() {
        for (int i = 0; i <= cantidad_de_dados ; i++){
            //Toma un dado y lo mete a un vector de dados
            setDado(new Dado());
            //Obtiene el dado lanzado y lo mete en un vector de caras
            caras.add(dado.get(i).get_cara());
            sumatoria = caras.get(i) + sumatoria;
            System.out.println("Cara #"+(i+1)+" = "+ caras.get(i));
        }
        //devuelve la cantidad de dados
        int tamano = dado.size();
        System.out.println("|| Dados usados "+tamano+" ||");
        System.out.println("Sunatoria = "+ sumatoria);
    }
}