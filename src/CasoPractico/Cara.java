package CasoPractico;

public class Cara extends SList<Cancion> {
	
	public Cancion getSongByTitle(String name){
		SNode<Cancion> song = head;
		while(song!=null){
			if (song.element.getTitulo().equalsIgnoreCase(name))
				return new Cancion(song.element);
			
				song=song.next;
		}
		
		return null;
	}
	
	public int getDuration(){
		int t=0;
		SNode<Cancion> song = head;
		while(song!=null){
			t+=song.element.getDuracion(); 
			song=song.next;
		}
		return t;
	}
	public Cancion needlePlaced(int seek){//Posicionar Aguja
		int duracion =this.getDuration();
		float seekF=seek/100;
		int p = (int) ((int)duracion*(seekF));
		
		int t=0;
		boolean sw=true;
		SNode<Cancion> song = head;
		Cancion aux=null;
		while(song!=null && sw){
			t+=song.element.getDuracion();
			if(p>=t){
				sw=false;
				aux=new Cancion(song.element);
			}
			song=song.next;
		}
		return aux;
	}
	public float whatSong(String name){//Que cancion suena
		float t=0;
		boolean sw=true;
		SNode<Cancion> song = head;
	
		while(song!=null && sw){
			if(song.element.getTitulo().equalsIgnoreCase(name)){
				sw=false;
			}else{
				t+=song.element.getDuracion();
			}
				
			song=song.next;
		}
		return t;
	}
}
