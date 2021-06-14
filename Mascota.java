public class Mascota{
	private String nombre;
	private String especie;
	private String raza;
	private String sexo;
	private int edad;
	private int meses;
	private String tamano;
	private String peligrosidad;
	private boolean exotico;
	public Mascota(String nombre, String especie, String raza, String sexo,int edad, int meses){
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.edad = edad;
		this.meses = meses;
	}
	public String getSexo(){
		return sexo;
	}
	public void setSexo(String sexo){
		this.sexo = sexo;
	}
	public int getEdad(){
		return this.edad;
	}
	public void setEdad(int edad){
		this.edad = edad;
	}
	public int getMeses(){
		return this.meses;
	}
	public void setMeses(int meses){
		this.meses = meses;
	}
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecie() {
		return this.especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaza() {
		return this.raza;
	}
	public void setRaza(String raza){
		this.raza = raza;
	}
	public String getTamano() {
		return this.tamano;
	}
	public void setTamano(String tamano){
		this.tamano = tamano;
	}
	public String getPeligrosidad() {
		return this.peligrosidad;
	}
	public void setPeligrosidad(String peligrosidad){
		this.peligrosidad = peligrosidad;
	}
	public boolean getExotico() {
		return this.exotico;
	}
	public void setExotico(boolean exotico){
		this.exotico = exotico;
	}
	public String toString(){
		String s = this.nombre;
		s+= ";"+this.especie;
		s+=";"+this.raza;
		s+=";"+this.sexo;
		s+=";"+this.edad;
		s+=";"+this.meses;
		return s;
	}
}