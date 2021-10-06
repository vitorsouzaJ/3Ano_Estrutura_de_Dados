package br.univille.estd.tree;

import java.util.ArrayList;

public class Diretorio {

    private String name;
    private float size;
    private float allocatedSize = 1;
    private ArrayList<Arquivo> arquivos;

    public Diretorio(String name, float size) {
        this.name = name;
        this.size = size;
        this.arquivos = new ArrayList<Arquivo>();
    }

    public void addArquivo(Arquivo arquivo){
        arquivos.add(arquivo);
        allocatedSize += arquivo.getSize();
    }

    public ArrayList<Arquivo> getArquivos() {
        return arquivos;
    }

    public void setArquivos(ArrayList<Arquivo> arquivos) {
        this.arquivos = arquivos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getAllocatedSize() {
        return allocatedSize;
    }

    public void setAllocatedSize(float allocatedSize) {
        this.allocatedSize = allocatedSize;
    }
}
