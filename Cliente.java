import java.util.Arrays;
public class Cliente{
	private String nombre;
	private String fijo;
	private String movil;
	private String correo;
	private String direccion;
	private Mascota[] mascotas;
	public Cliente(String nombre,String fijo,String movil,String correo,String direccion){
		this.nombre = nombre;
		this.fijo = fijo;
		this.movil = movil;
		this.correo = correo;
		this.direccion = direccion;
	}
	public void setMascotas(Mascota[] mascotas){
		this.mascotas = new Mascota[mascotas.length];
	}
	public void addMascota(Mascota mascota){
		if(this.mascotas == null){
			this.mascotas = new Mascota[1];
			this.mascotas[0] = mascota; 
		}
		else{
			this.mascotas = Arrays.copyOf(this.mascotas, this.mascotas.length);
			this.mascotas[this.mascotas.length-1] = mascota;
		}
	}
	public int encontrarMascota(int id){
		int cont = 0;
		if(this.mascotas == null) return -1;
		for(int i = 0; i <this.mascotas.length;i++) if( this.mascotas[i].getId() == id) return cont;
		return -1;
	}
	public Mascota[] getMascotas(){
		if(this.mascotas == null) return new Mascota[0];
		return this.mascotas;
	}
	public void setMascota(int id,Mascota mascota){
		this.mascotas[id] = mascota;
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
	public String toString(){
		String s = this.nombre;
		s+= ";"+this.fijo;
		s+=";"+this.movil;
		s+=";"+this.correo;
		s+=";"+this.direccion;
		return s;
	}
}