package Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

	 public static void main(String[] args) {
	        List<Ponto> lista = new ArrayList<>();
	        lista.add(new Ponto(4,2));
	        lista.add(new Ponto(5,2));
	        lista.add(new Ponto(2,1));
	        lista.add(new Ponto(4,0));
	        lista.add(new Ponto(2,2));
	        lista.add(new Ponto(3,1));
	        lista.add(new Ponto(0,2));

	      Comparator<Ponto> cresc = new CompararPontoCrescente();
	      Comparator<Ponto> decresc = new CompararPontoDecrescente();
	     ;

	     Sort<Ponto> algoritmo = new BubbleSort<>();
	        
	     System.out.print("Crescente =");
	     
	        algoritmo.sort(lista, cresc);
	        toString(lista);
	        
	        
	    System.out.print("Decrescente =  ");

	        algoritmo.sort(lista, decresc);
	        toString(lista);
	        
	 }
	        public static void toString(List lista){
	        	System.out.print("(");
	            for(Object o : lista){
	                System.out.print(o);
	            }
	        	System.out.println(")");
	        }}

	      
