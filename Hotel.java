import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.text.*;

import java.time.LocalDate;

import javax.security.auth.callback.Callback;

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
		
		TextField nombre = new TextField();
		TextField telefono= new TextField();
		TextField movil= new TextField();
		TextField correo= new TextField();
		TextField direccion= new TextField();

		Button guardar = new Button("Guardar");
		Button cancelar = new Button("Cancelar");
		cancelar.setOnAction(e->{
			datos_window.close();
		});
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
		form.setVgap(15);
		form.setHgap(25);
		form.getChildren().addAll(nombre,telefono,movil,correo,direccion,txtnombre,txttelefono,txtmovil,txtcorreo,txtdireccion);
		VBox general = new VBox();
		HBox botones = new HBox();
		form.setAlignment(Pos.CENTER);
		botones.getChildren().addAll(guardar,cancelar);
		botones.setAlignment(Pos.BOTTOM_RIGHT);
		botones.setSpacing(5);
		botones.setPadding(new Insets(5, 5,5,5));
		general.getChildren().addAll(form,botones);
		VBox.setVgrow(botones,Priority.ALWAYS);

		TabPane tabs = new TabPane();
		Tab tab1 = new Tab("Datos Cliente", general);
		TextField mnombre = new TextField();
		TextField raza = new TextField();
		TextField especie = new TextField();

		ChoiceBox<String> sexo= new ChoiceBox<String>();
		sexo.getItems().addAll("Macho","Hembra","Otro");

		Spinner<Integer> edad = new Spinner<Integer>();
		SpinnerValueFactory<Integer> valores = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,99, 0);
		edad.setValueFactory(valores);
		edad.setEditable(true);
		Spinner<Integer> meses = new Spinner<Integer>();
		SpinnerValueFactory<Integer> vmeses = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,11, 0);
		meses.setValueFactory(vmeses);
		meses.setEditable(true);


		Label txtmnombre = new Label("Nombre de la mascota: ");
		Label txtraza = new Label("Raza: ");
		Label txtespecie = new Label("Especie: ");
		Label txtsexo = new Label("Sexo: "); 
		Label txtedad = new Label("Edad: ");
		Label txtmeses = new Label("Meses: ");
		form = new GridPane();
		GridPane.setConstraints(txtmnombre, 0,0);
		GridPane.setConstraints(mnombre, 1,0);
		GridPane.setConstraints(txtraza, 0,1);
		GridPane.setConstraints(raza, 1,1);
		GridPane.setConstraints(txtespecie, 2,0);
		GridPane.setConstraints(especie, 3,0);
		GridPane.setConstraints(txtsexo, 0,2);
		GridPane.setConstraints(sexo, 1,2);
		GridPane.setConstraints(txtedad, 2,1);
		GridPane.setConstraints(edad, 3,1);
		GridPane.setConstraints(txtmeses,2,2);
		GridPane.setConstraints(meses, 3,2);
		form.setPadding(new Insets(5,5,5,5));
		form.setVgap(15);
		form.setHgap(25);
		form.getChildren().addAll(mnombre,raza,especie,sexo,edad,meses,txtmnombre,txtraza,txtsexo, txtespecie, txtedad,txtmeses);
		form.setAlignment(Pos.CENTER);

		Button guardar2 = new Button("Guardar");
		Button cancelar2 = new Button("Cancelar");
		HBox derecha = new HBox();
		Button reservar = new Button("Reservar");
		reservar.setOnAction(e-> reservarDisplay());
		derecha.getChildren().addAll(reservar,guardar2, cancelar2);
		derecha.setSpacing(5);
		derecha.setAlignment(Pos.CENTER_RIGHT);
		Button agregar = new Button("Agregar Mascota");
		agregar.setAlignment(Pos.CENTER_LEFT);
		cancelar2.setOnAction(e->{
			datos_window.close();
		});
		general = new VBox();
		botones = new HBox();
		botones.getChildren().addAll(agregar,derecha);
		botones.setAlignment(Pos.BOTTOM_RIGHT);
		botones.setSpacing(10);
		botones.setPadding(new Insets(5, 5,5,5));
		HBox.setHgrow(agregar, Priority.ALWAYS);
		HBox.setHgrow(derecha, Priority.ALWAYS);
		general.getChildren().addAll(form,botones);
		
		Tab tab2 = new Tab("Datos mascota", general); 
		tab1.setClosable(false);
		tab2.setClosable(false);
		tabs.getTabs().addAll(tab1,tab2);
		datos_window.setScene(new Scene(tabs));
		datos_window.show();
		//Datos escritorMascotas

	}
	public static Stage reserva_window = new Stage();

	public static void reservarDisplay(){
		GridPane panel = new GridPane();
		//elementos gridpane
			VBox fechas = new VBox();
				DatePicker desde = new DatePicker(LocalDate.now());
				desde.setDayCellFactory(picker -> new DateCell() {
					public void updateItem(LocalDate date, boolean empty) {
						super.updateItem(date, empty);
						setDisable(empty || date.compareTo(LocalDate.now()) < 0 );
					}
				});
				DatePicker hasta = new DatePicker(LocalDate.now().plusDays(1));
				hasta.setDayCellFactory(picker -> new DateCell() {
					public void updateItem(LocalDate date, boolean empty) {
						super.updateItem(date, empty);
						setDisable(empty || date.compareTo(LocalDate.now().plusDays(1)) < 0 );
					}
				});
				HBox desdebox = new HBox();
					Label txtdesde = new Label("Desde:\t");
					desdebox.getChildren().addAll(txtdesde,desde);
				HBox hastabox = new HBox();
					Label txthasta = new Label("Hasta:\t");
					hastabox.getChildren().addAll(txthasta,hasta);
				fechas.getChildren().addAll(desdebox,hastabox);
				fechas.setSpacing(15);
			TextArea animal_datos = new TextArea("Nombre: \nEspecie: \nRaza: \nEdad: \nSexo: ");
			animal_datos.setEditable(false);
			animal_datos.setMinSize(50,50);
			animal_datos.setMaxSize(230,110);
			animal_datos.setStyle("-fx-background-color: grey");
			VBox ultrabox = new VBox();
				HBox tamanobox = new HBox();
					Label txttamano = new Label("Tamaño:\t\t");
					ChoiceBox<String> tamano = new ChoiceBox<String>();
					tamano.getItems().add("Muy pequeño");
					tamano.getItems().add("Pequeño");
					tamano.getItems().add("Mediano");
					tamano.getItems().add("Grande");
					tamano.getItems().add("Muy grande");
					tamanobox.getChildren().addAll(txttamano,tamano);
				VBox peligrobox = new VBox();
					Label txtpeligro = new Label("Peligrosidad:\t");
					HBox hpeligrobox = new HBox();
						ChoiceBox<String> peligro = new ChoiceBox<String>();
						peligro.getItems().addAll("Domestico","Peligroso");
						CheckBox exotico = new CheckBox("Exotico");
						exotico.setAlignment(Pos.CENTER);
						hpeligrobox.getChildren().addAll(peligro,exotico);
						hpeligrobox.setSpacing(10);
					peligrobox.getChildren().addAll(txtpeligro,hpeligrobox);
					peligrobox.setSpacing(5);
				ultrabox.getChildren().addAll(tamanobox, peligrobox);
				ultrabox.setSpacing(25);
			VBox boletabox = new VBox();
				Label txtboleta = new Label("Boleta: ");
				TextArea boleta = new TextArea("Habitacion: \nEstancia: \nComida \nDescuento: \nTotal: ");
				boleta.setEditable(false);
				boleta.setMinSize(50,50);
				boleta.setMaxSize(150,110);
				boleta.setStyle("-fx-background-color: grey; -fx-font-family: consolas;");
				boletabox.getChildren().addAll(txtboleta,boleta);
				boletabox.setSpacing(5);
			GridPane.setConstraints(animal_datos,0,0);
			GridPane.setConstraints(fechas,0,1);
			GridPane.setConstraints(ultrabox,1,0);
			GridPane.setConstraints(boletabox,1,1,1,1,HPos.LEFT,VPos.BOTTOM);
			panel.getChildren().addAll(animal_datos,fechas,ultrabox,boletabox);
			panel.setPadding(new Insets(5,5,5,5));
			panel.setVgap(15);
			panel.setHgap(25);
		HBox botones = new HBox();
		Button reservar = new Button("Reservar");
		botones.getChildren().addAll(reservar);
		botones.setAlignment(Pos.BOTTOM_RIGHT);
		VBox general = new VBox();
		general.getChildren().addAll(panel,botones);
		general.setPadding(new Insets(5,5,5,5));
		reserva_window.setScene(new Scene(general));
		reserva_window.show();
	}
}