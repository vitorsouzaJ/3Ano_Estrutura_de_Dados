package br.univille.estd.tree;

import java.util.Iterator;


public class Tree<E> {
	
	private int size;
	private Position<E> root;
	

	public Position<E> root() throws EmptyTreeException{
		return root;
	}
	
	
	
	public Position<E> parent(Position<E> position) throws  BoundaryViolationException{
		if(isRoot(position)) throw  new BoundaryViolationException("Raiz nao possui pai");
		return position.getParent();
	}
	

	public Iterator<Position<E>> children(Position<E> position)  throws InvalidPositionException {
		checkIsPositionValid(position);
		return position.getChildren();
	}
	

	public boolean isInternal(Position<E> position) throws InvalidPositionException  {
		return !isExternal(position);
	}
	

	public boolean isExternal(Position<E> position)  throws InvalidPositionException {
		checkIsPositionValid(position);
		return position.size() == 0;
	}
	
	
	public boolean isRoot(Position<E> position) throws InvalidPositionException   {
		checkIsPositionValid(position);
		return root == position;
	}

	
	public int size() {
		return size;
	}
	

	public boolean isEmpty() {
		return size() == 0;
	}

	
	public Iterator<Position<E>> positions(){
		return null;
	}
	

	public E replace(Position<E> position, E element) throws InvalidPositionException {
		checkIsPositionValid(position);
		E old = position.getElement();
		position.setElement(element);
		return old;
	}
	
	
	
	
	public Position<E> addRoot(E element) throws NonEmptyTreeException {
		if(!isEmpty()){ throw  new NonEmptyTreeException("Arvore vazia");}
		root = new Position<>(element);
		size++;
		return root;
	}
	
	
	
	
	public Position<E> addChild(Position<E> parent, E element) throws InvalidPositionException{
		checkIsPositionValid(parent);
		size++;
		return parent.addChild(element);
	}
	
	

	private void checkIsPositionValid(Position<E> position) throws InvalidPositionException {
		if(position == null) throw new InvalidPositionException("A posição é invalida.");
	}
	
}
