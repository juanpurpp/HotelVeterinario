import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.*;

public class Hotel extends Application{
	public static Stage vprincipal;
	public static void main(String[] args){
		System.out.println("Iniciando interfaz gráfica");
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
		vprincipal = primaryStage;
		VBox box = new VBox();
		Label titulo = new Label("Hotel Veterinario");
		titulo.setFont(new Font("Calibri", 35));
		GridPane panel = new GridPane();
			panel.setPadding(new Insets(25, 25, 25, 25));
			panel.setVgap(50);
			panel.setHgap(50);
			Button b1 = new Button("Boton 1");
			Button b2 = new Button("Boton 2");
			Button b3 = new Button("Boton 3");
			Button b4 = new Button("Boton 4");
			GridPane.setConstraints(b1, 0,0);
			GridPane.setConstraints(b2, 0,1);
			GridPane.setConstraints(b3, 1,0);
			GridPane.setConstraints(b4, 1,1);
			panel.getChildren().addAll(b1,b2,b3,b4);
		box.getChildren().addAll(titulo,panel);
		Scene escena = new Scene(box);
		primaryStage.setScene(escena);
		primaryStage.show();
	}
}