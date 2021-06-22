public class Habitacion{
	private int n;
	private String tamano;
	private String peligrosidad;
	private boolean ocupada;
	public Habitacion(int n ,String tamano, String peligrosidad, boolean ocupada){
		this.n = n;
		this.tamano = tamano;
		this.peligrosidad = peligrosidad;
		this.ocupada = ocupada;
	}	
	public int getN(){
		return this.n;
	}
	public void setId(int id){
		this.n = id;
	}
	public String getTamano(){
		return this.tamano;
	}
	public void setTamano(String tamano){
		this.tamano = tamano;
	}
	public String getPeligrosidad(){
		return this.peligrosidad;
	}
	public void setPeligrosidad(String peligrosidad){
		this.peligrosidad = peligrosidad;
	}
	public boolean isOcupada(){
		return this.ocupada;
	}
	public void setOcupada(boolean ocupada){
		this.ocupada = ocupada;
	}
}