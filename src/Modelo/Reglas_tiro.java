package Modelo;

public class Reglas_tiro {
    int estado, validacion_tiro, punto, tiro;
    String estado_string;

    public Reglas_tiro(int estado) {
        this.estado = estado;
    }

    public Reglas_tiro() {
        estado = 0;
        validacion_tiro = 0;
        punto = 0;
        tiro = 0;
        estado_string = "";
    }

    public int getValidacion_tiro() {
        return validacion_tiro;
    }

    public String getEstado_string() {
        switch (getEstado()){
            case 1: estado_string = "|!GANASTE¡|";
                break;
            case 2: estado_string = "|!CRAPS¡|";
                break;
            case 3: estado_string = "|!PUNTO¡|";
                break;
            case 4: estado_string = "|!GANASTE EN RONDA PUNTO¡|";
                break;
            case 5: estado_string = "|CRAPS EN RONDA PUNTO|";
                break;
        }
        return estado_string;
    }

    public void setEstado_string(String estado_string) {
        this.estado_string = estado_string;
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
        System.out.println("|Inicia la ronda tiro|");
        int ronda = getValidacion_tiro();
        if ( ronda== 0) {
            if (getTiro() == 7 || getTiro() == 11) {
                setEstado(1);
                System.out.println("|!GANASTE¡|");
            } else if (getTiro() == 3 || getTiro() == 2 || getTiro() == 12) {
                setEstado(2);
                System.out.println("|!¡CRAPS|");
            }else {
                setEstado(3);
                setPunto(getTiro());
                setValidacion_tiro(1);
                System.out.println("|!PUNTO¡|");
            }
        }
        else {
            System.out.println("va ausar ronda punto|");
            ronda_punto();
        }
    }
    public void ronda_punto(){
        System.out.println("|entro a ronda punto|");
        if (getTiro() == getPunto()){
            setEstado(4);
            setValidacion_tiro(0);
            System.out.println("|!GANASTE EN RONDA PUNTO¡|");
        }
        else if (getTiro() == 7){
            setEstado(5);
            setValidacion_tiro(0);
            System.out.println("|CRAPS EN RONDA PUNTO|");
        }
    }

}
