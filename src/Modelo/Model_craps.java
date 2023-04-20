package Modelo;
/**
 * Esta clase aplica las reglas del juego
 * */
public class Model_craps {
    private System estado_to_string;


    public Model_craps() {

    }

    public void tiro_regla(int tiro){
        Reglas_tiro tirar_dados = new Reglas_tiro();
        tirar_dados.setTiro(tiro);
    }
}