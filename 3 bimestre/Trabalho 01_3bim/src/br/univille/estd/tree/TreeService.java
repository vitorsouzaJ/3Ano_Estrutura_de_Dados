package br.univille.estd.tree;

import java.util.Iterator;

public class TreeService {

    public static float tamanho(Tree<Diretorio> estrutura, Position<Diretorio> diretorio){
        float tamanho = diretorio.getElement().getAllocatedSize();
        Iterator<Position<Diretorio>> iterator = estrutura.children(diretorio);
        while (iterator.hasNext()){
            Position<Diretorio> child = iterator.next();
            tamanho += tamanho(estrutura, child);
        }
        return tamanho;
    }
}
