package br.univille.estd.tree;

public class Arquivo {

    private Diretorio parent;
    private String name;
    private float size;

    public Arquivo(Diretorio parent, String name, float size) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        parent.addArquivo(this);
    }

    public Diretorio getParent() {
        return parent;
    }

    public void setParent(Diretorio parent) {
        this.parent = parent;
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
}
