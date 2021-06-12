import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.scene.control.*;

import javafx.scene.text.*;
import java.io.File;
public class Hotel extends Application{
	public static Stage vprincipal;
	public static File css_pestana = Archivo.crear("CSS/pestana.txt");
	public static Button pestana1;
	public static Button pestana2;
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
		VBox botonesp = new VBox();
		GridPane panel = new GridPane();
			panel.setPadding(new Insets(50, 25, 50, 25));
			panel.setVgap(25);
			panel.setHgap(200);
			Button b1 = new Button("Reservar");
			Button b2 = new Button("Ver reservas");
			botonesp.getChildren().addAll(b1,b2);
			botonesp.minWidth(400);
			botonesp.setSpacing(10);
			Button b3 = new Button("Elemento medio");
			Button b4 = new Button("Elemento derecha");
			GridPane.setConstraints(botonesp, 0,0);
			GridPane.setConstraints(b3, 1,0);
			GridPane.setConstraints(b4, 2,0);
			GridPane.setHalignment(botonesp, HPos.LEFT);
			GridPane.setHgrow(botonesp,Priority.ALWAYS);
			panel.setAlignment(Pos.TOP_CENTER);
			panel.getChildren().addAll(botonesp,b3,b4);
		b1.setOnAction(e-> {
			try {
				datosDisplay();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} );
		box.getChildren().addAll(titulo,panel);
		box.setAlignment(Pos.TOP_CENTER);
		Scene escena = new Scene(box,854,480);
		primaryStage.setScene(escena);
		primaryStage.setTitle("Hotel Veterinario");
		primaryStage.show();
		// termino ventana principal
	}
	public static Stage datos_window = new Stage();
	public static Scene escena_mascotas;
	public static Scene escena_clientes;
	public static void datosDisplay() throws Exception {
		//Datos cliente
		datos_window.setTitle("Datos clientes");

		Button pestana1 = new Button();
		System.out.println("Insertando CSS : "+Archivo.leer(css_pestana,false));

		pestana1.getStyleClass().clear();
		pestana1.setStyle(Archivo.leer(css_pestana,false));
		pestana1.setText("Datos clientes");
		pestana1.autosize();
		pestana1.setOnAction(e->{
			datos_window.setScene(escena_mascotas);
		});
		Button pestana2 = new Button();

		pestana2.getStyleClass().clear();
		pestana2.setStyle("-fx-border-width:2px 2px 2px 2px;");
		pestana2.setText("Datos mascota");
		pestana2.autosize();

		pestana2.setOnAction(e->{
			datos_window.setScene(escena_clientes);
		});
		HBox pestanas = new HBox();
		pestanas.getChildren().addAll(pestana1,pestana2);
		HBox.setHgrow(pestana1, Priority.ALWAYS);
		pestanas.setAlignment(Pos.TOP_LEFT);
		TextField nombre = new TextField();
		TextField telefono= new TextField();
		TextField movil= new TextField();
		TextField correo= new TextField();
		TextField direccion= new TextField();

		Button guardar = new Button("Guardar");
		Button cancelar = new Button("Cancelar");
		GridPane form = new GridPane();
		Label txtnombre = new Label("Nombre: ");
		Label txttelefono  = new Label("Telefono: ");
		Label txtmovil = new Label("Telefono Movil: ");
		Label txtcorreo = new Label("Correo electronico:");
		Label txtdireccion = new Label("Direccion: ");
	
		GridPane.setConstraints(nombre,1,0);
		GridPane.setConstraints(txtnombre,0,0);
		GridPane.setConstraints(telefono,1,1);
		GridPane.setConstraints(txttelefono,0,1);
		GridPane.setConstraints(movil,1,2);
		GridPane.setConstraints(txtmovil,0,2);
		GridPane.setConstraints(correo,3,0);
		GridPane.setConstraints(txtcorreo,2,0);
		GridPane.setConstraints(direccion,3,1);
		GridPane.setConstraints(txtdireccion,2,1);
		form.setPadding(new Insets(5,5,5,5));
		form.setVgap(25);
		form.setHgap(50);
		form.getChildren().addAll(nombre,telefono,movil,correo,direccion,txtnombre,txttelefono,txtmovil,txtcorreo,txtdireccion);
		VBox general = new VBox();
		HBox botones = new HBox();
		form.setAlignment(Pos.CENTER);
		botones.getChildren().addAll(guardar,cancelar);
		botones.setAlignment(Pos.BOTTOM_RIGHT);
		botones.setSpacing(10);
		botones.setPadding(new Insets(5, 5,5,5));
		general.getChildren().addAll(pestanas,form,botones);
		VBox.setVgrow(pestanas, Priority.ALWAYS);
		VBox.setVgrow(botones,Priority.ALWAYS);
		escena_clientes= new Scene(general,700, 250);
		datos_window.setScene(escena_clientes);
		datos_window.show();
		//Datos escritorMascotas
		pestana1.setStyle("-fx-border-width: 2px 2px 2px 2px");
		pestana2.setStyle(Archivo.leer(css_pestana,false));
		pestanas.getChildren().addAll(pestana1,pestana2);
		HBox.setHgrow(pestana1, Priority.ALWAYS);
		pestanas.setAlignment(Pos.TOP_LEFT);

		TextField nombrem = new TextField();
		TextField raza = new TextField();
		TextField especie = new TextField();
		ChoiceBox<String> sexo = new ChoiceBox<String>();
		sexo.getItems().addAll("Macho","Hembra");
		Button guardar2 = new Button("Guardar");
		form = new GridPane();

	
		//constraints
		form.setPadding(new Insets(5,5,5,5));
		form.setVgap(25);
		form.setHgap(50);
		form.getChildren().addAll(nombre,telefono,movil,correo,direccion,txtnombre,txttelefono,txtmovil,txtcorreo,txtdireccion);
		general = new VBox();
		botones = new HBox();
		form.setAlignment(Pos.CENTER);
		botones.getChildren().addAll(guardar,cancelar);
		botones.setAlignment(Pos.BOTTOM_RIGHT);
		botones.setSpacing(10);
		botones.setPadding(new Insets(5, 5,5,5));
		general.getChildren().addAll(pestanas,form,botones);
		VBox.setVgrow(pestanas, Priority.ALWAYS);
		VBox.setVgrow(botones,Priority.ALWAYS);
		escena_clientes= new Scene(general,700, 250);
	}
}