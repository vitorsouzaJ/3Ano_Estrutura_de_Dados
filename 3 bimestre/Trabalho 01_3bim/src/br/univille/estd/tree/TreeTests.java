package br.univille.estd.tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Test;

public class TreeTests {


	@Test
	public void arvoreVazia() {
		Tree<Integer> tree = new Tree<>();

		assertEquals("Arvore vazia", true, tree.isEmpty());
		assertEquals("Arvore vazia nao tem root", null, tree.root());
		assertEquals(" com tamanho 0", 0, tree.size());
	}
	


	@Test
	public void arvoreComRoot() {
		Tree<Integer> tree = new Tree<>();
		Position<Integer> root = tree.addRoot(1);
		
		assertEquals("Arvore com root", false, tree.isEmpty());
		assertEquals("Arvore taamanho 1",1,tree.size());
		assertEquals("Root com o elemento 1",new Integer(1),root.getElement());
		assertEquals("Root com o elemento 1",new Integer(1),tree.root().getElement());
	}
	

	
	@Test
	public void arvoreComRootNaoPodeSerAdicionadoNovoRoot() {
		Tree<Integer> tree = new Tree<>();
		Position<Integer> root = tree.addRoot(1);
		
		
		try {
			tree.addRoot(2);
			fail("Nao pode ser adicionado novo root.");
		}catch(NonEmptyTreeException e) {
			
		}
	}
	

	@Test
	public void noERoot() {
		Tree<Integer> tree = new Tree<>();
		Position<Integer> root = tree.addRoot(1);
		
		assertEquals("O no e root", true, tree.isRoot(root));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void rootComFilhos() {
		Tree<Integer> tree = new Tree<>();
		Position<Integer> root = tree.addRoot(1);
		
		Position<Integer>  child = tree.addChild(root, 2);
		
		try {
			tree.addChild(null,null);
			fail("Posicao invalida.");
		}catch(InvalidPositionException e) {
			
		}
		
		assertEquals("Arvore tamanho 2",2,tree.size());
		assertEquals("Filho com o elemento 2",new Integer(2),child.getElement());
		
		assertEquals("Root com filho e elemento 2",new Integer(2),tree.root().getChildren().next().getElement());
	}
	
	
	@Test
	public void noExterno() {
		Tree<Integer> tree = new Tree<>();
		Position<Integer> root = tree.addRoot(1);
		
		Position<Integer>  child = tree.addChild(root, 2);

		try {
			tree.isExternal(null);
			fail("Posicao invalida.");
		}catch(InvalidPositionException e) {
			
		}
		
		assertEquals("Não deve ser externo",true,tree.isExternal(child));
		assertEquals("Root nao deve ser externo",false,tree.isExternal(root));
	
	}
	
	
	@Test
	public void noInterno() {
		Tree<Integer> tree = new Tree<>();
		Position<Integer> root = tree.addRoot(1);
		
		Position<Integer>  child = tree.addChild(root, 2);

		try {
			tree.isInternal(null);
			fail("Posicao invalida.");
		}catch(InvalidPositionException e) {
			
		}
		
		assertEquals("Não nao deve ser interno",false,tree.isInternal(child));
		assertEquals("Root deve ser interno",true,tree.isInternal(root));
	
	}
	
	
	
	@Test
	public void replace() {
		Tree<Integer> tree = new Tree<>();
		Position<Integer> root = tree.addRoot(1);
		
		Position<Integer>  child = tree.addChild(root, 2);
		
		int valorAntigo = tree.replace(child, 3);
		
		assertEquals("Arvore tamanho 2",2,tree.size());
		assertEquals("Filho com o elemento 3",new Integer(3),child.getElement());
		assertEquals("Valor substituido",2,valorAntigo);
		
		assertEquals("Root com filho e elemento 3",new Integer(3),tree.root().getChildren().next().getElement());
	}
	
	
	@Test
	public void parent() {
		Tree<Integer> tree = new Tree<>();
		Position<Integer> root = tree.addRoot(1);
		
		Position<Integer>  child = tree.addChild(root, 2);
		
		Position<Integer> parent = tree.parent(child);
		
		try {
			tree.parent(root);
			fail("Root nao tem pai.");
		}catch(BoundaryViolationException e) {
			
		}
		
		assertEquals("Arvore tamanho 2",2,tree.size());
		assertEquals("Parent com root", true, tree.isRoot(parent));
		
		assertEquals("Parent do filho com elemento 1",new Integer(1),parent.getElement());
	}
	

	@Test
	public void children() {
		Tree<Integer> tree = new Tree<>();
		Position<Integer> root = tree.addRoot(1);
		tree.addChild(root, 2);
		tree.addChild(root, 3);
		
		try {
			tree.children(null);
			fail("Posicao invalida.");
		}catch(InvalidPositionException e) {
			
		}
		Iterator<Position<Integer>> iterator = tree.children(root);
		
		assertEquals("Filho com elemento 2",new Integer(2),iterator.next().getElement());
		assertEquals("Filho com elemento 3",new Integer(3),iterator.next().getElement());
	}
	
	
		
	
}
