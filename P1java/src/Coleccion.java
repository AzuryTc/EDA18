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
	
	public void leeDoc(String nFichero) throws IOException{
		String categoria = null;
		int id;
		String linea="";
		File archivo=null;
		if(nFichero != null && nFichero.equals("")==false)  {
			archivo= new File(nFichero+".txt");
			try (BufferedReader bf = new BufferedReader(new FileReader(archivo))){
				
				while ((linea = bf.readLine())!=null) {
					
					if(linea.equalsIgnoreCase("<CAT>")) {
						if((linea = bf.readLine())!=null){
							categoria=linea;
						}
					}else if(linea.equalsIgnoreCase("<TEXTO>")) {
						if((linea = bf.readLine())!=null){
							while((linea = bf.readLine())!=null && linea.equalsIgnoreCase("<CAT>")==false){
								id=documentos.size();
								Docum documento= new Docum(id, categoria);
								documentos.add(documento);
								documento.addToken(linea);
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
			 archivo= new File(nTexto+".txt");
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
			linea+=diccionarios.get(i).toString();
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
