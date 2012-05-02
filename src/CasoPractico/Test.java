package CasoPractico;



import parte2.Estanteria;
import parte2.PilaDiscos;
import parte3.Tocadisco;
//import parte4.ArbolCancionesPorAnio;
//import parte4.ColeccionCanciones;

/**
 * Clase que prueba todos los metodos 
 * @author Mario Vasile Y David Simal
 *
 */
public class Test {

	ColeccionDiscos coleccionDiscos = new ColeccionDiscos();
	PilaDiscos pilaA = new PilaDiscos(); 
	PilaDiscos pilaB = new PilaDiscos();
	Estanteria ikea = new Estanteria(16);
	Tocadisco player = new Tocadisco();


	public static void main(String[] args) {
		Test test=new Test();
		test.test();
	}

	public void test(){
		/*
		ColeccionCanciones cCanciones= new ColeccionCanciones();
		ArbolCancionesPorAnio tree = new ArbolCancionesPorAnio(cCanciones);
		tree.verArbol(tree.getRoot());
		tree.dibujarArbol();
		*/
		


	
		/*******************PARATE 1*********************************/
		addDiscos();//Método que inicializa nuestra coleccion de discos
		probarBusquedas();
		/*****************FIN PARTE 1*******************************/
		/*******************PARTE 2*********************************/
		probarPilas();
		probarEstanteria();
		/*****************FIN PARTE 2*******************************/
		/*******************PARTE 3*********************************/
		probarTocadiscos();//por implementar llamadas
		/*****************FIN PARTE 3*******************************/
		/*******************PARTE 4*********************************/
		probarConsultas();//por implemtar llamadas
		/*****************FIN PARTE 4*******************************/
	}

	/**
	 * Método que incializa una coleccion de discos 
	 */
	public void addDiscos() {
		//***************************************Disco 1********************************************************************//
		Interprete interprete = new Interprete("Mozart", Interprete.tipoInterprete.Otro);
		Disco disco = new Disco(Disco.Velocidad.LENTO, interprete, "La flauta mágica (acto 1)", "2006");
		//***************************************Cara A********************************************************************//
		Cancion cancion = new Cancion(interprete, "Cuadro 1", Cancion.Genero.CLASICA, "1791", false, 1224);
		disco.addCancion(cancion, 0);
		//***************************************Cara B********************************************************************//
		cancion = new Cancion(interprete, "Cuadro 2", Cancion.Genero.CLASICA, "1791", false, 755);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "Cuadro 3", Cancion.Genero.CLASICA, "1791", false, 381);
		disco.addCancion(cancion, 1);
		//Añadimos el disco
		coleccionDiscos.addLast(new SNode<Disco>(disco));

		//***************************************Disco 2********************************************************************//
		interprete = new Interprete("Mozart", Interprete.tipoInterprete.Otro);
		disco = new Disco(Disco.Velocidad.LENTO, interprete, "La flauta mágica (acto 2)", "2006");
		//***************************************Cara A********************************************************************//
		cancion = new Cancion(interprete, "Cuadro 1", Cancion.Genero.CLASICA, "1791", false, 128);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "Cuadro 2", Cancion.Genero.CLASICA, "1791", false, 432);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "Cuadro 3", Cancion.Genero.CLASICA, "1791", false, 218);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "Cuadro 4", Cancion.Genero.CLASICA, "1791", false, 122);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "Cuadro 5", Cancion.Genero.CLASICA, "1791", false, 395);
		disco.addCancion(cancion, 0);
		//***************************************Cara B********************************************************************//
		cancion = new Cancion(interprete, "Cuadro 6", Cancion.Genero.CLASICA, "1791", false, 381);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "Cuadro 7", Cancion.Genero.CLASICA, "1791", false, 423);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "Cuadro 8", Cancion.Genero.CLASICA, "1791", false, 755);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "Cuadro 9", Cancion.Genero.CLASICA, "1791", false, 381);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "Cuadro 10", Cancion.Genero.CLASICA, "1791", false, 124);
		disco.addCancion(cancion, 1);
		//Añadimos el disco
		coleccionDiscos.addLast(new SNode<Disco>(disco));

		//***************************************Disco 3********************************************************************//
		interprete = new Interprete("The Beatles", Interprete.tipoInterprete.Grupo);
		disco = new Disco(Disco.Velocidad.LENTO, interprete, "Let it be", "1970");
		//***************************************Cara A********************************************************************//
		cancion = new Cancion(interprete, "The One After 909", Cancion.Genero.ROCK, "1969", false, 129);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "Rocker (Improvisation)", Cancion.Genero.ROCK, "1969", false, 84);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "Save the Last Dance for Me", Cancion.Genero.ROCK, "1969", false, 154);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "Don't Let Me Down", Cancion.Genero.ROCK, "1969", false, 215);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "Dig a Pony", Cancion.Genero.ROCK, "1969", false, 232);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "I've Got a Feeling", Cancion.Genero.ROCK, "1969", false, 217);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "Get Back", Cancion.Genero.ROCK, "1969", false, 194);
		disco.addCancion(cancion, 0);
		//***************************************Cara B********************************************************************//
		cancion = new Cancion(interprete, "For You Blue", Cancion.Genero.ROCK, "1969", false, 152);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "Teddy Boy", Cancion.Genero.ROCK, "1969", false, 145);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "Two of Us", Cancion.Genero.ROCK, "1969", false, 213);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "Maggie Mae", Cancion.Genero.ROCK, "1969", false, 40);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "Dig It", Cancion.Genero.ROCK, "1969", false, 51);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "Let It Be", Cancion.Genero.ROCK, "1969", false, 230);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "The Long and Winding Road", Cancion.Genero.ROCK, "1969", false, 420);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "Get Back (reprise)", Cancion.Genero.ROCK, "1969", false, 420);
		disco.addCancion(cancion, 1);
		//Añadimos el disco
		coleccionDiscos.addLast(new SNode<Disco>(disco));

		//***************************************Disco 4********************************************************************//
		interprete = new Interprete("Queen", Interprete.tipoInterprete.Grupo);
		disco = new Disco(Disco.Velocidad.MEDIO, interprete, "Bicycle race/Fat bottomed girls", "1978");
		//***************************************Cara A********************************************************************//
		cancion = new Cancion(interprete, "Bicycle race", Cancion.Genero.ROCK, "1978", true, 189);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "Fat bottomed girls", Cancion.Genero.ROCK, "1978", true, 195);
		disco.addCancion(cancion, 0);
		//Añadimos el disco
		coleccionDiscos.addLast(new SNode<Disco>(disco));

		//***************************************Disco 5********************************************************************//
		interprete = new Interprete("Mecano", Interprete.tipoInterprete.Grupo);
		disco = new Disco(Disco.Velocidad.MEDIO, interprete, "Perdido en mi habitación", "1981");
		//***************************************Cara A********************************************************************//
		cancion = new Cancion(interprete, "Perdido en mi habitación", Cancion.Genero.POP, "1981", true, 219);
		disco.addCancion(cancion, 0);
		//***************************************Cara B********************************************************************//
		cancion = new Cancion(interprete, "Viaje espacial", Cancion.Genero.POP, "1981", true, 221);
		disco.addCancion(cancion, 1);
		//Añadimos el disco
		coleccionDiscos.addLast(new SNode<Disco>(disco));

		//***************************************Disco 6********************************************************************//
		interprete = new Interprete("Mecano", Interprete.tipoInterprete.Grupo);
		disco = new Disco(Disco.Velocidad.MEDIO, interprete, "Mecano", "1982");
		//***************************************Cara A********************************************************************//
		cancion = new Cancion(interprete, "Hoy no me puedo levantar", Cancion.Genero.POP, "1981", false, 196);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "No me enseñen la lección", Cancion.Genero.POP, "1981", false, 190);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "Perdido en mi habitación", Cancion.Genero.POP, "1981", false, 223);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "Cenando en París", Cancion.Genero.POP, "1981", false, 254);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "Maquillaje", Cancion.Genero.POP, "1981", false, 149);
		disco.addCancion(cancion, 0);
		cancion = new Cancion(interprete, "Boda en Londres", Cancion.Genero.POP, "1981", false, 203);
		disco.addCancion(cancion, 0);
		//***************************************Cara B********************************************************************//
		cancion = new Cancion(interprete, "Me colé en una fiesta", Cancion.Genero.POP, "1981", false, 254);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "La máquina de vapor", Cancion.Genero.POP, "1981", false, 201);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "Me voy de casa", Cancion.Genero.POP, "1981", false, 135);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "254.13.26", Cancion.Genero.POP, "1981", false, 249);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "El fin del mundo", Cancion.Genero.POP, "1981", false, 314);
		disco.addCancion(cancion, 1);
		cancion = new Cancion(interprete, "Solo soy una persona", Cancion.Genero.POP, "1981", false, 106);
		disco.addCancion(cancion, 1);
		//Añadimos el disco
		coleccionDiscos.addLast(new SNode<Disco>(disco));

		//***************************************Disco 7********************************************************************//
		interprete = new Interprete("Varios", Interprete.tipoInterprete.Otro);
		disco = new Disco(Disco.Velocidad.LENTO, interprete, "Boom 6", "1990");
		//***************************************Cara A********************************************************************//
		interprete = new Interprete("Tina Turner", Interprete.tipoInterprete.Solista);
		cancion = new Cancion(interprete, "Foreign Affair", Cancion.Genero.ROCK, "1989", false, 247);
		disco.addCancion(cancion, 0);
		interprete = new Interprete("Héroes del silencio", Interprete.tipoInterprete.Grupo);
		cancion = new Cancion(interprete, "Entre dos tierras", Cancion.Genero.ROCK, "1990", false, 372);
		disco.addCancion(cancion, 0);
		interprete = new Interprete("Pet Shop Boys", Interprete.tipoInterprete.Grupo);
		cancion = new Cancion(interprete, "So hard", Cancion.Genero.POP, "1990", false, 238);
		disco.addCancion(cancion, 0);
		//***************************************Cara B********************************************************************//
		interprete = new Interprete("Roxette", Interprete.tipoInterprete.Grupo);
		cancion = new Cancion(interprete, "It must have been love", Cancion.Genero.POP, "1990", false, 257);
		disco.addCancion(cancion, 1);
		interprete = new Interprete("Joe Cocker", Interprete.tipoInterprete.Masculino);
		cancion = new Cancion(interprete, "What are you doing with a fool like me", Cancion.Genero.OTROS, "1989", false, 249);
		disco.addCancion(cancion, 1);
		interprete = new Interprete("Sinead O'Connor", Interprete.tipoInterprete.Femenino);
		cancion = new Cancion(interprete, "Nothing compares 2U", Cancion.Genero.ROCK, "1989", false, 310);
		disco.addCancion(cancion, 1);
		//Añadimos el disco
		coleccionDiscos.addLast(new SNode<Disco>(disco));
	}
	public void probarBusquedas() {
		SList<Disco> discos;
		SList<Cancion> cancion;

		discos = coleccionDiscos.buscarPorInterprete("Tina Turner");
		//System.out.println(discos.toString());
		discos.show();

		cancion = coleccionDiscos.buscarPorTituloCancion("Nothing compares 2U");
		cancion.show();

		Disco disc = coleccionDiscos.buscarTitulo("Bicycle race/Fat bottomed girls");
		System.out.println(disc.toString());

		cancion = coleccionDiscos.buscarPorTipoCancion(Cancion.Genero.POP);
		cancion.show();

	}
	public void probarPilas() {
		//Pasamos todos nuestros discos de la coleccion de discos a una de nuestras pilas
		apilarDiscos();
		buscarDisco("Bustamante");//Buscamos un disco y lo ponemos en la primera posicion de nuestra pila
	};
	public void probarEstanteria() {

		colocarDiscos();//Pasamos todos los dicos que podemos a nuestra estanteria
		colocarEtiquetas();//Pasamos todas las etiquetas a la estanteria
		//Este metodo esta compuesto de dos partes, 1º ordenamos las etiquetas SIN ORDENAR los discos y internamente llama a un metodo privado que saca los discos y
		//los introduce de nuevo en la estanteria segun indica las etiquetas.
		ikea.ordenar();
	};
	public void probarTocadiscos() {
		//vacio
	};
	public void probarConsultas(){
		//vacio
	}


	/**
	 * Sacamos todos los discos de nuesta coleccion y la pasamos a una de nuestas pila
	 */
	public void apilarDiscos(){
		SNode<Disco> aux = coleccionDiscos.head;
		while (aux!=null){
			pilaA.push(aux.element);
			aux=aux.next;
		}
	}
	/**
	 * 
	 * @param nombre, del disco que estamos buscando
	 * Este metodo busca el disco por el titulo y lo deja en la primera posicion 
	 * deuna de nuestras dos pilas.
	 */
	public void buscarDisco(String nombre){

		while(pilaA.size>0 && !pilaA.top().getTitulo().equalsIgnoreCase(nombre)){
			pilaB.push(pilaA.pop());
		}
		if (pilaA.size==0){
			while(pilaB.size>0 && !pilaB.top().getTitulo().equalsIgnoreCase(nombre)){
				pilaA.push(pilaB.pop());
			}

		}
	}
	/**
	 * Metodo que se encarga de pasar todos los discon de nuestas pilas 
	 * a nuesta estanteria, siempre y cuando entren.
	 */
	public void colocarDiscos( ){

		PilaDiscos auxA= new PilaDiscos();
		PilaDiscos auxB= new PilaDiscos();
		int i =0;

		while(pilaA.size>0 && ikea.size()<ikea.tamanio){
			auxA.push(pilaA.pop());
			ikea.addDisco(auxA.top(),i);
			i++;
		}
		while(pilaB.size>0 && ikea.size()<ikea.tamanio){
			auxB.push(pilaB.pop());
			ikea.addDisco(auxB.top(),i);
			i++;
		}
		//Reorganizamos la pila!
		while(auxA.size>0){
			pilaA.push(auxA.pop());
		}
		while(auxB.size>0){
			pilaB.push(auxB.pop());
		}
	}

	/**
	 * Colocamos las etiquetas en nuestra estanteria, independientemente de que coincidan con el disco que tienen debajo.
	 */
	public void colocarEtiquetas(){

		PilaDiscos auxA= new PilaDiscos();//Podemos usar pilas auxiliares?
		PilaDiscos auxB= new PilaDiscos();
		int i =0;
		while(pilaA.size>0 && ikea.size()<ikea.tamanio){
			auxA.push(pilaA.pop());
			ikea.addEtiqueta(auxA.top().getTitulo(),i);
			i++;
		}
		while(pilaB.size>0 && ikea.size()<ikea.tamanio){
			auxB.push(pilaB.pop());
			ikea.addEtiqueta(auxB.top().getTitulo(),i);
			i++;
		}
		//Reorganizamos la pila!
		while(auxA.size>0){
			pilaA.push(auxA.pop());
		}
		while(auxB.size>0){
			pilaB.push(auxB.pop());
		}
	}

	/* *************Metodos parte 3********************************/
	/**
	 * 
	 * @param disco
	 * @return devuelve un 1 si se encuentra en la pila y un 0 si lo ha dejado en la estantería
	 * Metodo que intentara colocar nuestro disco en nuestra estantería, si no encuentra el lugar o la estanteria esta llena,
	 * lo dejara en nuestra pila
	 */
	public int colocarDiscos(Disco disco){//quedas
		int p=0;
		while(p<ikea.size() && ikea.size()<ikea.tamanio ){
			if (ikea.getEtiqueta(p).equalsIgnoreCase(disco.getTitulo())){
				ikea.addDisco(disco, p);
				return 0;
			}
		}
		if (pilaA.size>pilaB.size)
			pilaB.push(disco);
		else
			pilaA.push(disco);

		return 1;
	}
	/**Este metodo 
	 * 
	 * @param disco que buscamos
	 * @return devuelve el disco si lo ha encontrado o null si no esta.
	 * En este metodo buscamos en la estanteria buscando nuesto disco, si no aprece
	 * lo vamos a buscar a nuestas pilas.
	 */
	public Disco colocarDisco(Disco disco){
		int p=0;

		while(p<ikea.size()){
			if (ikea.getDisco(p).equals(disco)){
				//ikea.remEtiqueta(p); //debemos eliminar la etiqueta? yo creo q no...
				return ikea.remDisco(p);
			}
			p++;
		}
		p=0;
		while (p<pilaA.size){
			if (pilaA.top().equals(disco)){
				return pilaA.pop();
			}
			pilaB.push(pilaA.pop());
		}
		p=0;
		while(p<pilaB.size){
			if (pilaB.top().equals(disco)){
				return pilaB.pop();
			}
			pilaA.push(pilaB.pop());
		}

		return null;
	}

	public void quitarDiscos(){
		player.pararPlato();
		SList<Disco> listaDiscos = (SList<Disco>) player.quitarDiscosDelPlato();
		if(listaDiscos != null){
			SNode<Disco> discoLista = listaDiscos.first();
			while(discoLista != null){
				colocarDisco(discoLista.element);
				discoLista = discoLista.next;
			}	
		}else{
			System.out.println("No hay discos que colocar");
		}

	}

	public void tocarCancion(String cancion){
		quitarDiscos();
		int tamEstanteria = ikea.size();
		Disco disk = null;
		boolean songFound = false;
		for(int i = 0; i < tamEstanteria; i++){
			disk = ikea.getDisco(i);
			if(disk.hasSongTitle(cancion)==true){
				songFound = true;
				i = tamEstanteria;
			}
		}

		if(songFound == false){
			int tamPila = pilaB.size;
			// Pasamos todos los discos a la pila A ya que si no mas tarde los tendriamos que consultar otra vez
			for(int i = 0; i < tamPila; i++){
				pilaA.push(pilaB.pop());	
			}

			tamPila = pilaA.size;
			for(int i = 0; i < tamPila; i++){
				if(pilaA.top().hasSongTitle(cancion)){
					songFound = true;
					i = tamPila;
					disk = pilaA.top();
				}else{
					pilaB.push(pilaA.pop());	
				}
			}
		}	

		if(songFound == true){
			int intCara = 1;
			Cancion song = disk.getCara(1).getSongByTitle(cancion);
			if(song == null){
				intCara = 2;
				song = disk.getCara(2).getSongByTitle(cancion);
			}

			player.ponerDiscoEnEje(disk, intCara);
			player.dejarCaerDiscoDeEje();
			player.fijarRpmPlato(disk.getRMP());
			player.arrancarPlato();
			player.desaparcarAguja();
			player.fijarPosicionAguja(disk.getCara(intCara).whatSong(cancion));
		}else{
			System.out.println("No se encuentra la cancion buscada");
		}
	}



}

