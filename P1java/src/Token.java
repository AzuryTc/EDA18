// 77009175T JENIFER BOENTE PEREIRA
public class Token {
	
	private int frec;
	private String pal;
	
	public Token() {
		 pal="";
		 frec=0;
	}
	
	public Token(String p) {
		if (p!=null) {
			pal=p;
			frec=1;
		}else {
			 pal="";
			 frec=0;	
		}
	}
	public Token(Token t) {
		frec=t.getFrecuencia();
		pal=t.getPalabra();
	}
	
	public String getPalabra() {
		return pal;
	}
	
	public int getFrecuencia(){
		return frec;
	}
	
	public Token masMas() {
		frec++;
		return this;
		
	}
	public String toString() {
		String linea = pal + " " + frec +"\n";
		return linea;
	}
	

}
