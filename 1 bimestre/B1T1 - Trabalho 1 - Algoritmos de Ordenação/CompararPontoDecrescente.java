package Sort;

import java.util.Comparator;

public class CompararPontoDecrescente
        implements Comparator<Ponto> {

    @Override
    public int compare(Ponto a, Ponto b) {
        int resultado = b.getX() - a.getX();
        if(resultado != 0){
            return resultado;
        }
        return b.getY() - a.getY();
    }
}
