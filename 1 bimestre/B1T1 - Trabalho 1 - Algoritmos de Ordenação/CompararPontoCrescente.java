package Sort;

import java.util.Comparator;

public class CompararPontoCrescente
        implements Comparator<Ponto> {

    @Override
    public int compare(Ponto a, Ponto b) {
        int resultado = a.getX() - b.getX();
        if(resultado != 0){
            return resultado;
        }
        return a.getY() - b.getY();
    }
}
