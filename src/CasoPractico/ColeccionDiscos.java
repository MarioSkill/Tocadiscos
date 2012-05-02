package CasoPractico;


public class ColeccionDiscos extends SList<Disco> {
	
	 public ColeccionDiscos(){
		//Disco SDisco = new Disco();
	}
	
	
	public SList<Disco> buscarPorInterprete(String interprete){
				

		SList<Disco> returnDiscos = new SList<Disco>();
		SNode<Disco> aux = head;
		 while(aux != null){
			 if(aux.element.getInterprete().getNombre().equals(interprete)){
				 returnDiscos.addFirst(new SNode<Disco>(new Disco(aux.element.getRMP(),aux.element.getInterprete(),aux.element.getTitulo(),aux.element.getFecha()),null));
			}
			 aux = aux.next;
		 }
		 
		return returnDiscos;
	}
	
	public SList<Cancion> buscarPorTipoCancion(Cancion.Genero tipo){
		
		SNode<Disco> aux = head;
		
		//Cara auxCara;
		SNode <Cancion> auxCancion;
		
		SList<Cancion> returnCanciones = new SList<Cancion>();
		// Recorremos la lista de discos
		while(aux != null){
			auxCancion = aux.element.getCara(0).first();
			// Recorremos la lista de canciones de la cara A
			while(auxCancion != null){
				if(auxCancion.element.getGenero() == tipo){
					//auxCancion.element.getInterprete(),auxCancion.element.getTitulo(),auxCancion.element.getGenero(),auxCancion.element.getFecha(),auxCancion.element.getDirecto(),auxCancion.element.getDuracion())
					SNode<Cancion> song=new SNode<Cancion>(auxCancion.element,null);
					returnCanciones.addFirst(song);
				}
				auxCancion = auxCancion.next;
			}
			aux = aux.next;
		}
		return returnCanciones;
	}
	
	public SList<Cancion> buscarPorTituloCancion(String titulo){
		SNode<Disco> aux = head;
		
		//Cara auxCara;
		SNode <Cancion> auxCancion;
		
		SList<Cancion> returnCanciones = new SList<Cancion>();
		// Recorremos la lista de discos
		while(aux != null){
			
			for(int i = 0; i < 2; i++){
				auxCancion = aux.element.getCara(i).first();
				// Recorremos la lista de canciones de la cara A
				while(auxCancion != null){
					if(auxCancion.element.getTitulo().equals(titulo)){
						SNode<Cancion> song=new SNode<Cancion>(auxCancion.element,null);
						returnCanciones.addFirst(song);
					}
					auxCancion = auxCancion.next;
				}
			}
			aux = aux.next;
		}
		return returnCanciones;
	}
	
	public Disco buscarTitulo(String titulo){
		SNode<Disco> aux = head;
		SNode<Disco> disc = null;
		
		 while(aux != null && disc == null){
			 if(aux.element.getTitulo().equalsIgnoreCase(titulo) == true){
				 disc =  new SNode<Disco>(aux.element,null);
			 }
			 aux = aux.next;
		 }
		return disc.element;	
	}
}
