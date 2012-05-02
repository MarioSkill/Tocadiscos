package CasoPractico;

public class Interprete {
	public enum tipoInterprete{Solista, Grupo, Otro,Masculino,Femenino}
	private String nombre;
	private tipoInterprete tipo;
	
	public Interprete(String name, tipoInterprete t){
		this.nombre = name;
		this.tipo = t;
	}

	public String getNombre(){
		return this.nombre;
	}
	
	public tipoInterprete getTipo(){
		return this.tipo;
	}
	
	public void setNombre(String name){
		this.nombre = name;
	}
	
	public void setTipo(tipoInterprete type){
		this.tipo = type;
	}
	
	public String toString(){
		return nombre + " " + tipo.toString();
	}
	

}
