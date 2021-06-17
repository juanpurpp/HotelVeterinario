import java.time.LocalDate;
public class Reserva {
	
	private String nombre;
	private String fijo;
	private String movil;
	private String correo;
	private String direccion;
	private String mnombre;
	private String especie;
	private String raza;
	private String sexo;
	private int edad;
	private int meses;
	private String tamano;
	private String peligrosidad;
	private boolean exotico;
	private int id;
	private LocalDate desde = LocalDate.now();
	private LocalDate hasta = LocalDate.now().plusDays(1);
	private int totalfinal;
	private int linea;
	public Reserva(int linea, String nombre,String fijo,String movil,String correo,String direccion,int id,String mnombre, String especie, String raza, String sexo,int edad, int meses,LocalDate desde, LocalDate hasta,String tamano, String peligrosidad, boolean exotico, int totalfinal){
		this.linea=linea;
		this.nombre = nombre;
		this.fijo = fijo;
		this.movil = movil;
		this.correo = correo;
		this.direccion = direccion;
		this.mnombre = mnombre;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.edad = edad;
		this.meses = meses;
		this.id = id;
		this.desde = desde;
		this.hasta = hasta;
		this.tamano = tamano;
		this.peligrosidad = peligrosidad;
		this.exotico = exotico;
		this.totalfinal = totalfinal;
	}
	public int getLinea(){
		return this.linea;
	}
	public void setLinea(int linea){
		this.linea = linea;
	}
	public String getNombre(){
		return this.nombre;
	}
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	public String getFijo(){
		return this.fijo;
	}
	public void setFijo(String fijo){
		this.fijo = fijo;
	}
	public String getMovil(){
		return this.movil;
	}
	public void setMovil(String movil){
		this.movil = movil;
	}
	public String getCorreo(){
		return this.correo;
	}
	public void setCorreo(String correo){
		this.correo = correo;
	}
	public String getDireccion() {
		return this.direccion;
	}
	public void setDireccion(String direccion){
		this.direccion = direccion;
	}
	public LocalDate getDesde(){
		return desde;
	}
	public void setDesde(LocalDate desde){
		this.desde = desde;
	}
	public LocalDate getHasta(){
		return hasta;
	}
	public void setHasta(LocalDate hasta){
		this.hasta = hasta;
	}
	public int getId(){
		return this.id;
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
	public String getMnombre() {
		return this.mnombre;
	}
	public void setMnombre(String mnombre) {
		this.mnombre = mnombre;
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
	public int getTotalFinal(){
		return this.totalfinal;
	}
	public void setTotalFinal(int totalfinal){
		this.totalfinal = totalfinal;
	}
}