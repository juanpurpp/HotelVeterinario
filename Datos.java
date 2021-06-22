public class Datos{
	public static String razon;
	public static boolean comprobar(Cliente comprobando){
		//Field[] variables = comprobando.getClass().getFields();
		if(comprobando.getNombre().trim().length()==0){
			razon = "No puede dejar vacio el campo nombre";
			return false;
		}
		for(char c: comprobando.getNombre().toCharArray()){
			if(!Character.isLetter(c) && c!=' '){
				razon = "El nombre no puede tener numeros";
				return false;
			}
		}
		if(comprobando.getFijo().trim().length() == 0 && comprobando.getMovil().trim().length() ==0){
			razon = "Debe proporcionar al menos un numero de contacto";
			return false;
		}
		for(char c: comprobando.getFijo().toCharArray()){
			if(!Character.isDigit(c) && c!='+'){
				razon= "El numero de telefono fijo no puede tener letras o simbolos raros (solo +)";
				return false;
			}
		}
		for(char c: comprobando.getMovil().toCharArray()){
			if(!Character.isDigit(c) && c!='+'){
				razon= "El numero de telefono movil no puede tener letras o simbolos raros (solo +)";
				return false;
			}
		}
		if(comprobando.getCorreo().contains("@")){
			if(comprobando.getCorreo().indexOf("@")== 0 ||comprobando.getCorreo().indexOf("@") == comprobando.getCorreo().length()-1){
				razon = "Ingrese un correo valido (correo@dominio)";
				return false;
			}
		}
		else{
			razon = "Ingrese un correo valido (correo@dominio)";
			return false;
		}
		return true;
	}
	public static boolean comprobar(Mascota comprobando){
		if(comprobando.getNombre().trim().length()==0){
			razon = "No puede dejar vacio el campo nombre";
			return false;
		}
		if(comprobando.getEspecie().trim().length()==0){
			razon = "No puede dejar vacio el campo especie";
			return false;
		}
		for(char c: comprobando.getEspecie().toCharArray()){
			if(!Character.isLetter(c) && c!=' '){
				razon = "La especie no puede tener numeros";
				return false;
			}
		}
		if(comprobando.getRaza().trim().length()==0){
			razon = "No puede dejar vacio el campo raza";
			return false;
		}
		for(char c: comprobando.getRaza().toCharArray()){
			if(!Character.isLetter(c) && c!=' '){
				razon = "La raza no puede tener numeros";
				return false;
			}
		}
		if(comprobando.getSexo().trim().length()==0){
			razon = "No puede dejar vacio el campo sexo";
			return false;
		}
		return true;
	}
	
	public static boolean disponibilidad(Mascota comprobando){
		if(Archivo.leer(Hotel.habitaciones,true).contains(""+comprobando.getTamano()+";"+comprobando.getPeligrosidad()+";"+false)){
			Archivo.sobreescribir(Hotel.habitaciones,Archivo.leer(Hotel.habitaciones,true).replaceFirst(//
				comprobando.getTamano()+";"+comprobando.getPeligrosidad()+";"+false,comprobando.getTamano()+";"+comprobando.getPeligrosidad()+";"+true));
			return true;
		}
		else{
			razon = "Lo sentimos!, no hay habitaciones disponibles \npara "+comprobando.getPeligrosidad()+" y "+comprobando.getTamano() +"vayase.";
			return false;
		}
	}
}
