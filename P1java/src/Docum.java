// 77009175T JENIFER BOENTE PEREIRA

import java.util.ArrayList;

public class Docum {

	private int id;//id del documento
	private String cat; //Categoria del documento
	private ArrayList <Token> general; // palabras que aparecen en un documento con su frecuencia.
	private ArrayList <Token> basico; // palabras sin Stop words
	private Token defecto;
	
	//Constructores:
	
	public Docum() {
		id=0;
		cat="";
		general= new ArrayList<Token> ();
		basico= new ArrayList<Token> ();
		defecto= new Token();
	}
	
	public Docum( int identificador , String cadena) {
		id=identificador;
		cat=cadena;
		general= new ArrayList<Token> ();
		basico= new ArrayList<Token> ();
		defecto= new Token();
	}
	
	// metodo que sirve para ver que token tiene mas frecuendia (getToken()) y devolver el que mas frecuencia tenga
	public Token masFrec() {
		Token palabra=new Token();
		int longitud = general.size();
		int cantidadfrec =0;
		
		if (general!=null) {
			
			this.comprobarDuplicado(general, 1);
			
			for (int i=0 ; i<longitud; i ++) {
				
				int frecuencia=general.get(i).getFrecuencia();
			
				if (frecuencia > cantidadfrec) {
					
					palabra=general.get(i);
					cantidadfrec=frecuencia;
					
				}
			}
			
			
			
		}else {
			return defecto;
		}
		
		return palabra;
	}
	
	
	public int generaBasico(ArrayList<Token> diccionario) {
		int cantidad=0;
	
		for( int  i =0 ;i<general.size();i++) {
			for (int j=0; j< diccionario.size();j++) {
				if(general.get(i).equals(diccionario.get(j))==false) {
					basico.add(diccionario.get(j));
				}else {
					cantidad++;
				}
			}
		}
		return cantidad;
	}
	
	public void addToken(String cadena) {
		if (cadena!=null && cadena!="") {
			for (int i = 0; i< general.size(); i ++) {
				 if(general.get(i).getPalabra().equalsIgnoreCase(cadena)== true) {
					general.get(i).masMas() ;
				 }else {
					 general.add(new Token(cadena.toLowerCase()));
				 }
			}
		}
	}
	
	
	
	//Metodo que comprueba si hay duplicados en general y en basico de modo que se pasa el arraylist que quieras comprobar y si quieres comprobar general pone 1 y si es basico 2
	public void comprobarDuplicado(ArrayList<Token> arl, int a) {
		ArrayList<Token> duplicado=new ArrayList<Token>();
		
		for (int dup=0; dup<general.size(); dup++) {
			duplicado.add(dup,general.get(dup));
		}
		
		switch(a){
		case 1: //General
			
			
				
			
			for(int i=0; i<general.size();i++) {
				
				for(int j=i+1; j<duplicado.size();j++) {
					if(general.get(i)==duplicado.get(j)) {
						general.get(i).masMas();
						duplicado.add(j,null);
					}
				}
			}
			
			break;
			
		case 2://Basico
				
			
			for(int i=0; i<basico.size();i++) {
				
				for(int j=i+1; j<duplicado.size();j++) {
					if(basico.get(i)==duplicado.get(j)) {
						basico.get(i).masMas();
						duplicado.add(j,null);
					}
				}
			}
			
			
			break;
		}
		
	}
	public String toString() {
		String linea=id + "-"+cat+"\n";
		
		for( int i=0; i<basico.size();i++) {
			linea+=basico.get(i).getPalabra();
		}
		
		
		return linea;
	}
	
	
	
	
	//metodos de devolucion de datos:
	public int getId() {
		return id;
	}
	public String getCat() {
		return cat;
	}
	public ArrayList<Token> getVecGeneral(){
		return general;
	}
	public ArrayList<Token> getVecBasico(){
		return basico;
	}
	
}
