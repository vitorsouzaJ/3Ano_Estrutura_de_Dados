package br.univille.estd.tree;

import br.univille.estd.tree.TreeService.*;

public class Main {
    public static void main(String[] args) {
        Diretorio c = new Diretorio("C:", 1_000_000_000);
        Diretorio windows = new Diretorio("Windows", 1_000_000_000);
        Arquivo explorer = new Arquivo(windows, "explorer.exe", 30_000);
        Diretorio documentos = new Diretorio("Documentos:", 1_000_000_000);
        Diretorio videos = new Diretorio("videos", 1_000_000_000);
        Arquivo porDoSol = new Arquivo(videos, "por_do_sol.mp4", 1_048_576_00);
        Tree<Diretorio> tree = new Tree<>();
        Position<Diretorio> root = tree.addRoot(c);

        Position<Diretorio> childWindows = tree.addChild(tree.root(), windows);
        Position<Diretorio> childDocumentos = tree.addChild(tree.root(), documentos);
        Position<Diretorio> childVideos = tree.addChild(childDocumentos, videos);


        float Tamanho = TreeService.tamanho(tree, childWindows);
        System.out.println(Tamanho);
    }
}
