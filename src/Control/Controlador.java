package Control;

import Modelo.Model_craps;
import Modelo.Tirar_dados;

import java.util.Vector;

/**
 * Esta clase aplica las reglas del juego
 * */
public class Controlador {
    private int numero_de_dados;
    Vector<Integer> cara;
    int flag;

    public Controlador() {
        this.numero_de_dados = numero_de_dados;
    }

    public Controlador(int numero_de_dados) {
        this.numero_de_dados = numero_de_dados;
        inicio(numero_de_dados);
    }

    public void inicio(int numero_de_dados){
        //Creo un objeto donde tiro unos dados el cual recibe n cantidad de dados
        //creo un objeto que aplicara la regla
        Tirar_dados tirar = new Tirar_dados();
        Model_craps jugar = new Model_craps();

        //Aqui tiro el o los dados
        tirar.tirar_dado(numero_de_dados);
        setCara(tirar.getCaras());

        //Recojo el resultado de los dados y lo capturo en la clase de regla
        jugar.setValidacion_tiro(getFlag());
        jugar.setTiro(tirar.getSumatoria());
        jugar.ronda_tiro();
        setFlag( jugar.getValidacion_tiro());



        System.out.println("estado del juego = "+jugar.getEstado()+" || El tiro fue "+tirar.getSumatoria());
        System.out.println("\n|Bandera|"+jugar.getValidacion_tiro()+"\n");

    }

    public int getNumero_de_dados() {
        return numero_de_dados;
    }

    public void setNumero_de_dados(int numero_de_dados) {
        this.numero_de_dados = numero_de_dados;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Vector<Integer> getCara() {
        return cara;
    }

    public void setCara(Vector<Integer> cara) {
        this.cara = cara;
    }
}