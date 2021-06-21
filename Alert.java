import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;

public class Alert{
	private static boolean selec = false;
	public static boolean display(String titulo, String mensaje,String izq, String der){
		Stage ventana = new Stage();
		ventana.initModality(Modality.APPLICATION_MODAL);
		ventana.setResizable(false);
		ventana.setTitle(titulo);
		Label msg = new Label(mensaje);
		Button boton1 = new Button(izq);
		Button boton2 = new Button(der);
		VBox general = new VBox();
		HBox botones = new HBox();
			botones.getChildren().addAll(boton1,boton2);
			botones.setSpacing(25);
			boton1.setOnAction(e->{
				selec = true;
				ventana.close();
			});
			boton2.setOnAction(e->{
				selec = false;
				ventana.close();
			});
		general.getChildren().addAll(msg,botones);
		general.setSpacing(15);
		general.setPadding(new Insets(5,5,5,5));
		ventana.setTitle(titulo);
		ventana.setScene(new Scene(general));
		ventana.showAndWait();
		return selec;
	}
	public static void display(String titulo, String mensaje,String boton){
		Stage ventana = new Stage();
		ventana.setTitle(titulo);
		ventana.setResizable(false);
		Label msg = new Label(mensaje);
		Button b = new Button(boton);
		b.setOnAction(e->ventana.close());
		VBox general = new VBox();
		general.getChildren().addAll(msg,b);
		general.setSpacing(15);
		general.setPadding(new Insets(5,5,5,5));
		ventana.setTitle(titulo);
		ventana.setScene(new Scene(general));
		ventana.initModality(Modality.APPLICATION_MODAL);
		ventana.showAndWait();
		
	}
}