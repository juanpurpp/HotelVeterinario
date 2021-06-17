import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;//-fx-border-top: 5pt solid #9e9e9e; -fx-border-right: 5pt solid #9e9e9e; -fx-border-bottom: 0pt solid #9e9e9e; -fx-border-left: 5pt solid #9e9e9e;
public class Archivo{
    static String texto;
	public static String leer(File archivo,boolean salto) {
        try{
            Scanner lector = new Scanner(archivo);
            texto = "";
            while(lector.hasNextLine()){
                texto += lector.nextLine();
                if(salto) texto+= "\n";
            }
            lector.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error al leer el archivo");
        }
        return texto;
    }
    public static File crear(String ruta){
        File archivo = new File(ruta);
        try{
            if(archivo.createNewFile()) System.out.println("Archivo Creado: " + archivo.getName());
            else System.out.println("El archivo descrito ya existe");
        }
        catch(Exception e){
            System.out.println("Hubo un error en la creacion");
        }
        return archivo;
    }
    public static File eleminar(File eliminar){
        File archivo = eliminar;
        try{
            if(archivo.delete())System.out.println("Archivo eleminado " + archivo.getName());
            else System.out.println("El archivo no existe");
        }
        catch(Exception e){
            System.out.println("Hubo un error en la eliminacion");
        }
        return archivo;
    }
	public static void escribir(File archivo, String add){
		try{
			FileWriter escritor = new FileWriter(archivo,true);
			escritor.append(add);
			escritor.close();
			System.out.println("ha terminado de escribir " + archivo.getName());
		}catch(Exception e){
			System.out.println("Error escribiendo datos en "+ archivo.getName());       
		}
	}
    public static void sobreescribir(File archivo, String add){
		try{
			FileWriter escritor = new FileWriter(archivo,false);
			escritor.append(add);
			escritor.close();
			System.out.println("ha terminado de escribir " + archivo.getName());
		}catch(Exception e){
			System.out.println("Error escribiendo datos en "+ archivo.getName());       
		}
    }
}