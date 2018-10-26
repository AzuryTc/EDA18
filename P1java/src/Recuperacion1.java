// 77009175T JENIFER BOENTE PEREIRA

import java.io.IOException;
public class Recuperacion1 {
	
	
	public static void main(String[] texto){
		
		Coleccion colecciones= new Coleccion();
		Token sinNombre=new Token();
		Token elGranToken=new Token();
		Docum documento = new Docum();
		
		int id=-1;
		String categoria="";
		String palabra="";
		int frecuencia=-1;
		int auxFrec=-99;
		
		
		try{
			for(int i=0; i <texto.length;i++) {
				colecciones.leeDoc(texto[i]);
			}

			for(int j = 0 ; j< colecciones.getTexto().size(); j++) {
					
				//Conseguimos el token con mas frecuencia
				sinNombre=colecciones.getTexto().get(j).masFrec();
				
				if(sinNombre.getFrecuencia()>auxFrec) {
			
					auxFrec=sinNombre.getFrecuencia();
					elGranToken=sinNombre;
					documento=colecciones.getTexto().get(j);
					
				}
			}
			
			id=documento.getId();
			categoria=documento.getCat();
			palabra=elGranToken.getPalabra();
			frecuencia=elGranToken.getFrecuencia();

			System.out.println(id + categoria);
			System.out.println(palabra +frecuencia );

		}catch(IOException e){
			System.err.println("Error con"+texto);
			System.exit(0);
		}
	}//Fin main
}//Fin clase

// Id categoria
//palabra Frecuencia