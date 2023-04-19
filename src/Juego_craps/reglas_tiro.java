package Juego_craps;

public class reglas_tiro {
    int estado, validacion_tiro, punto, tiro;

    public reglas_tiro(int estado) {
        this.estado = estado;
    }

    public reglas_tiro() {
        this.estado = 0;
        this.validacion_tiro = 0;
        this.punto = 0;
        this.tiro = 0;
    }
    public int getValidacion_tiro() {
        return validacion_tiro;
    }

    public void setValidacion_tiro(int validacion_tiro) {
        this.validacion_tiro = validacion_tiro;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getPunto() {
        return punto;
    }

    public void setPunto(int punto) {
        this.punto = punto;
    }

    public int getTiro() {
        return tiro;
    }

    public void setTiro(int tiro) {
        this.tiro = tiro;
    }

    public void ronda_tiro(){
        if (getValidacion_tiro() == 0) {
            if (tiro == 7 || tiro == 11) {
                setEstado(1);
            } else if (tiro == 3 || tiro == 2 || tiro == 12) {
                setEstado(2);
            }
            setEstado(3);
            setPunto(tiro);
            setValidacion_tiro(1);
        }
        else {
            ronda_punto();
        }
    }
    public void ronda_punto(){
        if (tiro == getPunto()){
            setEstado(4);
            setValidacion_tiro(0);
        }
        if (tiro == 7){

        }
    }

}
