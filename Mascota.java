import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Mascota{
	private String nombre;
	private String especie;
	private String raza;
	private String sexo;
	private int edad;
	private int meses;
	private String tamano = "Muy pequeño";
	private String peligrosidad = "Domestico";
	private boolean exotico = false;
	private int id;
	private LocalDate desde = LocalDate.now();
	private LocalDate hasta = LocalDate.now().plusDays(1);
	private int totalfinal;
	public Mascota(int id,String nombre, String especie, String raza, String sexo,int edad, int meses,LocalDate desde, LocalDate hasta,String tamano, String peligrosidad, boolean exotico, int totalfinal){
		this.nombre = nombre;
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
	public Mascota(int id,String nombre, String especie, String raza, String sexo,int edad, int meses){
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.edad = edad;
		this.meses = meses;
		this.id = id;
	}
	public Mascota(int id){
		this.nombre = "";
		this.especie = "";
		this.raza = "";
		this.sexo = "";
		this.edad = 0;
		this.meses = 0;
		this.id = id;
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
		String s = ""+this.id;
		s+=";"+this.nombre;
		s+=";"+this.especie;
		s+=";"+this.raza;
		s+=";"+this.sexo;
		s+=";"+this.edad;
		s+=";"+this.meses;
		s+=";"+this.desde;
		s+=";"+this.hasta;
		s+=";"+this.tamano;
		s+=";"+this.peligrosidad;
		s+=";"+this.exotico;
		s+=";"+this.totalfinal;
		return s;
	}
	public String calcularBoleta(int descuentoinicial){
		int habitacion = 0;
		if(this.peligrosidad!=null){
			if(this.peligrosidad.equals("Domestico")) habitacion+= 5000;
			else if(this.peligrosidad.equals("Peligroso")) habitacion+= 15000;
		}
		if(this.tamano!=null){
			if(this.tamano.equals("Muy pequeño")) habitacion+= 500;
			if(this.tamano.equals("Pequeño"))	habitacion+= 2000;
			if(this.tamano.equals("Mediano"))	habitacion+= 5000;
			if(this.tamano.equals("Grande"))	habitacion+= 7500;
			if(this.tamano.equals("Muy grande")) habitacion+= 10000;
		}
		if(this.exotico)habitacion+=3000;
		int estancia = 0;
		int comida = 0;
		int descuento = descuentoinicial;
		if(this.desde != null && this.hasta != null){
			estancia = (int)ChronoUnit.DAYS.between(this.desde, this.hasta) * 1000;
			comida = (int)ChronoUnit.DAYS.between(this.desde, this.hasta) * 500;
			if(ChronoUnit.DAYS.between(this.desde, this.hasta)>7) descuento +=30;
		}
		int total= (habitacion+estancia+comida);
		total-= Math.round((total/100) * descuento);
		String boleta = "";
		boleta+=//
		"Habitacion:	"+habitacion+//
		"\nEstancia:	"+estancia+//
		"\nComida:		"+comida+//
		"\nDescuento:	"+descuento+"%"+//
		"\nTotal:		"+total;
		this.totalfinal=total;
		return boleta;
	}
}