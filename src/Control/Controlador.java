package Control;

import Modelo.Model_craps;
import Modelo.Tirar_dados;

/**
 * Esta clase aplica las reglas del juego
 * */
public class Controlador {
    private final int numero_de_dados;
    int flag;

    public Controlador(int numero_de_dados) {
        this.numero_de_dados = numero_de_dados;
        inicio();
    }

    public void inicio(){
        //Creo un objeto donde tiro unos dados el cual recibe n cantidad de dados
        //creo un objeto que aplicara la regla
        Tirar_dados tirar = new Tirar_dados(numero_de_dados);
        Model_craps jugar = new Model_craps();

        //Aqui tiro el o los dados
        tirar.tirar_dado();

        //Recojo el resultado de los dados y lo capturo en la clase de regla
        jugar.setValidacion_tiro(getFlag());
        jugar.setTiro(tirar.getSumatoria());
        jugar.ronda_tiro();
        setFlag( jugar.getValidacion_tiro());



        System.out.println("estado del juego = "+jugar.getEstado()+" || El tiro fue "+tirar.getSumatoria());
        System.out.println("|Bandera|"+jugar.getValidacion_tiro());

    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}