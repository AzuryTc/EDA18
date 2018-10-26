// 77009175T JENIFER BOENTE PEREIRA
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Coleccion {
	
	private ArrayList <Docum> documentos;
	private ArrayList <String> diccionarios;
	
	public Coleccion() {
		documentos= new ArrayList <Docum> ();
		diccionarios= new ArrayList <String> ();
	}
	
	public void leeDoc(String nFichero){
		

		String categoria = null;
		int id;
		String linea="";
		File archivo=null;
		Docum documento=null;
		String separador="[,:;¿?¡!\\.() ]+";
		String[] palabras=null;
 		if(nFichero != null && nFichero.equals("")==false)  {
			archivo= new File(nFichero);
			

			try (BufferedReader bf = new BufferedReader(new FileReader(archivo))){
				linea=bf.readLine();
			
				while (linea !=null) {
					
					if(linea.equalsIgnoreCase("<CAT>")) {
						if((linea = bf.readLine())!=null){
							categoria=linea;
							id=documentos.size()+1;
							documento= new Docum(id, categoria);
						
						}
					}else  {
						if((linea = bf.readLine())!=null && linea.equalsIgnoreCase("<TEXTO>")){
							while((linea = bf.readLine())!=null && linea.equalsIgnoreCase("<CAT>")==false){
								
								palabras=linea.split(separador);
								 for(int x=0;x<palabras.length;x++) {
								documento.addToken(palabras[x]);
								 }
							}
							if(documento!=null) {
							documentos.add(documento);
							}
						}
					}	
				}
			} catch (IOException e) {
			    e.printStackTrace();
			}  
			
		}	
	}// Fin de lee Doc
	
	public void leeDic(String nTexto) {
		String linea="";
		File archivo=null;
		 if ( nTexto!=null && nTexto.equals("")==false) {
			 archivo= new File(nTexto);
				try (BufferedReader bf = new BufferedReader(new FileReader(archivo))){
					while ((linea = bf.readLine())!=null) {
						diccionarios.add(linea.toLowerCase());
						}	
					
				} catch (IOException e) {
				    e.printStackTrace();
				}  
			 
	
			 
		 }		
	}// fin de lee dic
	
	public String toString() {
		String linea="";
		
		for(int i=0; i<documentos.size();i++) {
			linea+=documentos.get(i).toString();
		}
		for(int i=0; i<diccionarios.size();i++) {
			if(i==0) {
				linea+=diccionarios.get(i).toString();
			}else {
			linea+=" "+diccionarios.get(i).toString();
			}
		}
		
		
		return linea;
	}
	
	
	// metodos de devolucion
	
	public ArrayList <Docum> getTexto(){
		return documentos;
	}
	public ArrayList <String> getDiccionario(){
		return diccionarios;
	}
	

}// Fin de clase 
