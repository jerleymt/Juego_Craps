package Juego_craps;
/**
 * Esta clase aplica las reglas del juego
 * */
public class Model_craps {
    private System estado_to_string;


    public Model_craps() {

    }

    public void tiro_regla(int tiro){
        reglas_tiro tirar_dados = new reglas_tiro();
        tirar_dados.setTiro(tiro);
    }
}