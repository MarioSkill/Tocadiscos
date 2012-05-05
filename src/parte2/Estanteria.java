package parte2;
import CasoPractico.Disco;
//import CasoPractico.Interprete;

/**
 * 
 * @author Mario Vasile y David Simal
 * Clase donde se almacenarán los Discos con sus etiquetas.
 *
 */
public class Estanteria implements IEstanteria<Disco>  {
	
	private String[] etiqueta;	//Definimos el array para las etiquetas
	private Disco[] casilla;	//Definimos el array para los discos
	private int size=0; 		//Nos dira el numero de discos en la estantería
	final public int tamanio;	//Tenemos el mañana maximo de discos y etiquetas que podemoas guardar
	
	/**
	 * Constructor de la Clase
	 * @param n, tamaño que tendrá nuestra estantería para almacenar discos y sus correspondientes etiquetas.
	 */
	public Estanteria (int n){
		etiqueta= new String[n];
		casilla = new Disco[n];
		this.tamanio=n;
		
	}
	/**
	 * Metodo que obtiene el numero de discos
	 * @return integer
	 */
	public int size(){
		return size;
	}
	public Disco getDisco(int p){
		if (p>size)
			return null;
		
		return this.casilla[p];
	}
	public String getEtiqueta(int p){
		if (p>size)
			return null;
		
		return this.etiqueta[p];
	}
	
	/**
	 * Método que recíbe dos parametros, un disco y la posicion donde queremos agregarlo
	 */
	public void addDisco(Disco disco,int n) {
		this.casilla[n]=disco;
		size++;
	}
	/**
	 * Método que recíbe dos parametros, una etiqueta (String) y una posicion
	 */
	public void addEtiqueta(String eti, int n) {
		this.etiqueta[n] = eti;
		
	}
	/**
	 * Método que elimina la etiqueta de una posición pasada como parametro, y reordena el array, todo ello de forma recursiva 
	 * Una vez eliminado nos devuelve el disco eliminado
	 */
	public String remEtiqueta(int n) {
		String aux=etiqueta[n];
		if (n==(etiqueta.length-1) || etiqueta[n+1]==null ){
			etiqueta[n]=null;
			size--;
		}else{
			String aux1 = etiqueta[n];
			etiqueta[n]=etiqueta[n+1];
			etiqueta[n+1]=aux1;
			remEtiqueta(n+1);
		}
		return aux;
	}
	/**
	 * Método que elimina un disco de una posición pasada como parametro, y reordena el array, todo ello de forma recursiva 
	 * Una vez eliminado nos devuelve el disco eliminado
	 */
	public Disco remDisco(int n) {
		Disco aux=casilla[n];
		if (n==(casilla.length-1) || casilla[n+1]==null ){
			casilla[n]=null;
			size--;
		}else{
			Disco aux1 = casilla[n];
			casilla[n]=casilla[n+1];
			casilla[n+1]=aux1;
			remDisco(n+1);
		}
		return aux;
	}
	/**
	 * Método que ordena los discos y las etiquetas en dos pasos, primero ordenamos el array de etiquetas por el interprete y/o fecha y despues llama el metodo 
	 * privado ordenarDiscos que saca los discos de la estanteria y los introduce en la estantera segun indique las etiquetas.
	 * El algorimo de ordenanico es la Burbuja
	 */
	public void ordenar() {
	    int n = this.etiqueta.length;
	    for (int pass=1; pass < n && etiqueta[pass]!=null; pass++) { 
	        for (int i=0; i < n-pass && etiqueta[i+1]!=null; i++) {
 	        	if (compararNombres(etiqueta[i] , etiqueta[i+1])==0) {//Si los nombres de los interpretes son iguales
 	        		
	        		if(compararFechas(etiqueta[i] , etiqueta[i+1])){//Ordenamos por fecha
	        			String tempE=etiqueta[i]; etiqueta[i]=etiqueta[i+1]; ; etiqueta[i+1]=tempE;
	        		}	        		
	            }else if(compararNombres(etiqueta[i], etiqueta[i+1])==1) {//ordenamos por por los nombre del interprete
	               	String tempE=etiqueta[i]; 
	            	etiqueta[i]=etiqueta[i+1]; 
	            	etiqueta[i+1]=tempE; 
	            }
	        }
	    }

	    ordenarDiscos();//Ahora ordenaremos los discos
	   
	}
	/**
	 * Metodo privado que ordenara nuestros discos de la estantería segun indiquen las etiquetas
	 */
	private void ordenarDiscos(){
		//Creamos dos pilas auxiliares donde pondremos nuestros discos.
		PilaDiscos p1=new PilaDiscos();
		PilaDiscos p2=new PilaDiscos();
		int s=this.size;//Obtenemos el numero de discos de nuestra estaneria 
		for(int i =0; i<s ;i++){ //sacamos todos nuestros discos
			p1.push(this.remDisco(0));
		}
		int i=0;
		while (p1.size!=0 || p2.size!=0){ //mientras las dos pilas tengan algún disco 
			
			if (i>=s){ // con esto controlamos el indice de nuestro array
				i=0;
			}
			//Si nuestra etiqueta es igual al disco lo insertamos
			if (this.etiqueta[i].equalsIgnoreCase(p1.top().getTitulo())){
				this.addDisco(p1.pop(), i);
			}else{// si no lo pasaos a la segunda pila
			//	p2.push(p1.pop());
			}
			//Si nuestra pila 1 se queda vacia pasams los disco de la pila 2 a la 1
			if (p1.size==0 && p2.size>0){
				int size=p2.size;
				for(int j =0; j<size;j++){
					p1.push(p2.pop());
				}
			}
			i++;
		}
		for(i=0;i<size;i++)
			System.out.println(i+" "+etiqueta[i]+" "+casilla[i].getTitulo());
		
		


	}
	/**
	 * Metodo Que compara dos fechas y nos dice cual es mayor
	 * @param f1 Nombre del disco numero 1
	 * @param f2 Nombre del disco numero 2
	 * @return devuelve true si la f1 es mayor a f2 y false en caso contrario
	 */
	public boolean compararFechas(String fecha1, String fecha2){
		fecha1=fecha(fecha1);	//Buscamos la feha asociada con el nombre del disco pasado como parametro
		fecha2=fecha(fecha2);	//Buscamos la feha asociada con el nombre del disco pasado como parametro
		
		//Partimos las fechas para comporar el dia mes y año de las dos fechas
		//String[] fecha1=f1.split("/"); 
		//String[] fecha2=f2.split("/");
		if (fecha1.equals(fecha2) ){
			if (fecha1.equals(fecha2)){
				if((Integer.parseInt(fecha1)> Integer.parseInt(fecha2))){//dia
					return true;
				}else{
					return false;
				}
			}else if (Integer.parseInt(fecha1)> Integer.parseInt(fecha2) ){//mes
				return true;
			}else{
				return false;
			}
		}else if (Integer.parseInt(fecha1)> Integer.parseInt(fecha2)){//año
			return true;
		}else{
			return false;
		}
	
	}
	/**
	 * Metodo que compara los nombres del interprete y nos dice si son iguales o cual el mayor
	 * @param Aux Nombre del primer disco
	 * @param Aux2 Nombre del segundo disco
	 * @return entero 0--> igaules, 1 --> aux > aux2 , 2 --> aux2 > aux
	 */
	public int compararNombres(String Aux, String Aux2){
		
		//obtenemos el nombre del interprete que corresponde con el disco
		Aux=interprete(Aux);
		Aux2=interprete(Aux2);
		
		if( Aux.equalsIgnoreCase(Aux2) ){//iguales
			return 0;
		}else{
			int i=0;
			while(i<Aux2.length() && i<Aux.length() ){
				if ((int)Aux.charAt(i) >(int)Aux2.charAt(i)){//cadena 1 mayor que la 2
					
					return 1;
					
				}else if  ((int)Aux2.charAt(i)>(int)Aux.charAt(i) ){//cadena 2 mayor que la 1
					return 2;
				}
				i++;
			}
		}
		// si salimos del bucle es por que las cadenas eran iguales en la longuitud que hemos podido comparar por eso 
		//La que sea mas larga sera la cadena mas grande
		//Ejemplo: aaaa y aaaab la grande seria la segunda cadena
		if (Aux.length()>Aux2.length())
			return 1;
		else
			return 2;
		
	}
	/**
	 * Metodo privado que busca en el array de discos y nos devuelve el nombre del interprete de und disco
	 * @param nombre del disco disco 
	 * @return String 
	 */
	private String interprete(String disco){
		int i=0;
		while (i<casilla.length){
			if(casilla[i].getTitulo().toLowerCase().equals(disco.toLowerCase())){
				return casilla[i].getInterprete().getNombre().toLowerCase();
			}
			i++;
		}
		return null;
	}
	/**
	 * Metodo privado que de forma analoga a interprete pero nos devuelve la fecha de un disco
	 * @param nombre del disco disco 
	 * @return String 
	 */
	private String fecha (String disco){
		int i=0;
		while (i<casilla.length){
			if(casilla[i].getTitulo().toLowerCase().equals(disco.toLowerCase())){
				return casilla[i].getFecha();
			}
			i++;
		}
		return null;
	}

	
}
