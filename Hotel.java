import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.text.*;

import java.time.LocalDate;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


public class Hotel extends Application{
	public static Scene escena_mascotas;
	public static Scene escena_clientes;
	public static TextField nombre ;
	public static TextField telefono;
	public static TextField movil;
	public static TextField correo;
	public static TextField direccion;
	public static Cliente cliente;
	public static TextField mnombre;
	public static TextField raza;
	public static TextField especie;
	public static ChoiceBox<String> sexo;
	public static Spinner<Integer> edad;
	public static Spinner<Integer> meses;
	public static int agregados;
	public static Mascota[] datosp;
	public static Button agregar;
	public static Pagination paginas;
	
	public static Stage vprincipal;
	public static Stage datos_window = new Stage();
	public static Stage reserva_window = new Stage();
	public static Stage ver_window = new Stage();

	public static File css_pestana = Archivo.crear("CSS/pestana.txt");
	public static File reservas = Archivo.crear("Datos/reservas.txt");
	public static Button pestana1;
	public static Button pestana2;
	public static void main(String[] args){
		System.out.println("Iniciando interfaz grfica");
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.getIcons().add(new Image("file:Imagenes/icon.png"));
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
			try{
				agregados = 1;
				datosp = new Mascota[1];
				datosp[0] = new Mascota(0);
				datos_window.setScene(escenaDatos());
				datos_window.show();
				cliente = null;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("esta wea da problema");
			}
		} );
		b2.setOnAction(e->{
			try{
				ver_window.setScene(escenaVer());
				ver_window.show();
			}catch(Exception e1){
				e1.printStackTrace();
				System.out.println("error, causa: "+e1.getCause() + "\t Clase: "+e1.getClass()+"\nMensaje"+e1.getMessage());
			}
		});
		box.getChildren().addAll(titulo,panel);
		box.setAlignment(Pos.TOP_CENTER);
		Scene escena = new Scene(box,854,480);
		primaryStage.setScene(escena);
		primaryStage.setTitle("Hotel Veterinario");
		primaryStage.show();
		// termino ventana principal
	}
	public static Scene escenaVer(){
		VBox general = new VBox();
			HBox botones = new HBox();
				Button ok = new Button("Okey");
				Button cancelar = new Button("Cancelar");
				cancelar.setOnAction(e-> ver_window.close());
				botones.getChildren().addAll(ok,cancelar);
				botones.setSpacing(5);
				botones.setAlignment(Pos.BOTTOM_RIGHT);
				TableView tabla = new TableView();
					TableColumn<Reserva,Object> c0 = new TableColumn<>("Linea");
					c0.setCellValueFactory(new PropertyValueFactory<>("linea"));
					TableColumn<Reserva,String> c1 = new TableColumn<Reserva,String>("Nombre");
					c1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
					TableColumn<Reserva, String> c2 = new TableColumn<>("Telefono fijo");
					c2.setCellValueFactory(new PropertyValueFactory<>("fijo"));
					TableColumn<Reserva,String> c3 = new TableColumn<Reserva,String>("Telefono movil");
					c3.setCellValueFactory(new PropertyValueFactory<>("movil"));
					TableColumn<Reserva, String> c4 = new TableColumn<>("Correo electronico");
					c4.setCellValueFactory(new PropertyValueFactory<>("correo"));
					TableColumn<Reserva, String> c5 = new TableColumn<>("Direccion");
					c5.setCellValueFactory(new PropertyValueFactory<>("Direccion"));
					
					TableColumn<Reserva, Object> c6 = new TableColumn<>("ID Reserva");
					c6.setCellValueFactory(new PropertyValueFactory<>("id"));
					TableColumn<Reserva, String> c7 = new TableColumn<>("Nombre Reserva");
					c7.setCellValueFactory(new PropertyValueFactory<>("mnombre"));
					TableColumn<Reserva, String> c8 = new TableColumn<>("Especie");
					c8.setCellValueFactory(new PropertyValueFactory<>("especie"));
					TableColumn<Reserva, String> c9 = new TableColumn<>("Raza");
					c9.setCellValueFactory(new PropertyValueFactory<>("raza"));
					TableColumn<Reserva, String> c10 = new TableColumn<>("Sexo");
					c10.setCellValueFactory(new PropertyValueFactory<>("sexo"));
					TableColumn<Reserva, Object> c16 = new TableColumn<>("Edad");
					c16.setCellValueFactory(new PropertyValueFactory<>("edad"));
					TableColumn<Reserva, Object> c17 = new TableColumn<>("Meses");
					c17.setCellValueFactory(new PropertyValueFactory<>("meses"));
					TableColumn<Reserva, LocalDate> c11 = new TableColumn<>("Desde la fecha");
					c11.setCellValueFactory(new PropertyValueFactory<>("desde"));
					TableColumn<Reserva, LocalDate> c12 = new TableColumn<>("Hasta");
					c12.setCellValueFactory(new PropertyValueFactory<>("hasta"));
					TableColumn<Reserva, String> c13 = new TableColumn<>("Tamano");
					c13.setCellValueFactory(new PropertyValueFactory<>("tamano"));
					TableColumn<Reserva, String> c14 = new TableColumn<>("Peligrosidad");
					c14.setCellValueFactory(new PropertyValueFactory<>("peligrosidad"));
					TableColumn<Reserva, Object> c15 = new TableColumn<>("Es exotico");
					c15.setCellValueFactory(new PropertyValueFactory<>("exotico"));

					tabla.getColumns().addAll(c0,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17);
					
					Scanner sacar = new Scanner(Archivo.leer(reservas, true));
					int lineas = 0;
						while(!Archivo.leer(reservas, true).equals("") && sacar.hasNextLine()){
							String[] info = sacar.nextLine().split("~");
							String[] infoc= info[0].split(";");
							String[] infom= info[1].split(";");
							tabla.getItems().add(new Reserva(lineas,infoc[0], infoc[1], infoc[2], infoc[3],infoc[4],Integer.parseInt(infom[0]), infom[1], infom[2], infom[3],infom[4],Integer.parseInt(infom[5]), Integer.parseInt(infom[6]), LocalDate.parse(infom[7]), LocalDate.parse(infom[8]), infom[9],infom[10], Boolean.parseBoolean(infom[11]), Integer.parseInt(infom[12]) ));
							lineas++;
						}
					sacar.close();
					
					tabla.setMaxSize(500,400);
					
				Label txteliminarlinea = new Label("Ingrese la linea que desea eliminar: ");
				HBox eliminarlinea = new HBox();
					Spinner<Integer> lineaborrar = new Spinner<Integer>();
					SpinnerValueFactory valores = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, lineas,0);
					lineaborrar.setValueFactory(valores);
					Button eliminar = new Button("Eliminar linea");
						eliminar.setOnAction(e->{
							int l = 0;
							Scanner leyendo = new Scanner(Archivo.leer(reservas,true));
							String nuevo = "";
							while(leyendo.hasNextLine()){
								System.out.println("lineas: "+ l +"    spiner: " + lineaborrar.getValue());
								if(l!=lineaborrar.getValue()) nuevo+= leyendo.nextLine()+"\n";
								else leyendo.nextLine();
								l++;
							}
							Archivo.sobreescribir(reservas, nuevo);
							ver_window.setScene(escenaVer());
							leyendo.close();
						});

					eliminarlinea.getChildren().addAll(lineaborrar,eliminar);
				Label txtlimpiar = new Label("Presione el boton para limpiar el texto");
				Button limpiar = new Button("Limpiar");
					limpiar.setOnAction(e->{
						Archivo.sobreescribir(reservas,"");
						ver_window.setScene(escenaVer());
					});
				Label txtborrar = new Label("Presione el boton de abajo para borrar el archivo");
				Button borrar = new Button("Borrar");
					borrar.setOnAction(e->{
						if(Alert.display("Confirmacion", "¿Desea borrar el archivo de reservas?","Si","No")){
							Archivo.eleminar(reservas);
							ver_window.setScene(escenaVer());
						}
					});
				Label txtcrear = new Label("Crear un archivo nuevo");
				Button crear = new Button("Crear");
					crear.setOnAction(e->{
						Archivo.crear("Datos/reservas.txt");
						ver_window.setScene(escenaVer());
					});
			VBox opciones = new VBox();
				VBox caja1 = new VBox();
				caja1.getChildren().addAll(txteliminarlinea,eliminarlinea);
				VBox caja2 = new VBox();
				caja2.getChildren().addAll(txtlimpiar,limpiar);
				VBox caja3 = new VBox();
				caja3.getChildren().addAll(txtborrar,borrar);
				VBox caja4= new VBox();
				caja4.getChildren().addAll(txtcrear,crear);
				opciones.getChildren().addAll(caja1,caja2,caja3,caja4);
				opciones.setSpacing(50);
				txteliminarlinea.setAlignment(Pos.BOTTOM_LEFT);
				txtlimpiar.setAlignment(Pos.BOTTOM_LEFT);
				txtborrar.setAlignment(Pos.BOTTOM_LEFT);
				VBox.setVgrow(txteliminarlinea, Priority.ALWAYS);
				VBox.setVgrow(txtlimpiar, Priority.ALWAYS);
				VBox.setVgrow(txtborrar, Priority.ALWAYS);
			HBox panel = new HBox();
				panel.getChildren().addAll(tabla,opciones);
				panel.setSpacing(25);
				HBox.setHgrow(txteliminarlinea, Priority.ALWAYS);
				HBox.setHgrow(txtlimpiar, Priority.ALWAYS);
				HBox.setHgrow(txtborrar, Priority.ALWAYS);
		general.getChildren().addAll(panel,botones);
		general.setPadding(new Insets(10,10,10,10));
		return new Scene(general);
	}	
	public static Scene escenaDatos() throws Exception {
		//Datos cliente
		nombre = new TextField();
		telefono= new TextField();
		movil= new TextField();
		correo= new TextField();
		direccion= new TextField();
		Button guardar = new Button("Guardar");
		guardar.setOnAction(e->{
			if(Datos.comprobar(new Cliente(nombre.getText(),telefono.getText(),movil.getText(),correo.getText(),direccion.getText()))){
				Alert.display("Guardado", "Datos guardados","Ok");
				cliente = new Cliente(nombre.getText(),telefono.getText(),movil.getText(),correo.getText(),direccion.getText());
				if(telefono.getText().equals("")) cliente.setFijo("No especifica");
				if(movil.getText().equals("")) cliente.setMovil("No especifica");
				if(direccion.getText().equals("")) cliente.setDireccion("No especifica");
				System.out.println(cliente.toString());
			}
			else Alert.display("Error", Datos.razon, "Ok");
		});
		Button cancelar = new Button("Cancelar");
		cancelar.setOnAction(e->{
			datos_window.close();
		});
		GridPane form = new GridPane();
		Label txtnombre = new Label("Nombre: ");
		Label txttelefono  = new Label("Telefono Fijo: ");
		Label txtmovil = new Label("Telefono Movil: ");
		Label txtcorreo = new Label("Correo electronico:");
		Label txtdireccion = new Label("Direccion: ");
		nombre.setPromptText("Ingrese su nombre");
		telefono.setPromptText("Ingrese un numero de telefono fijo");
		movil.setPromptText("Ingrese un numero de telfono movil");
		correo.setPromptText("correo@dominio");
		direccion.setPromptText("opcional");
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
		paginas = new Pagination();
		paginas.setPageFactory((pageIndex) -> {
			mnombre = new TextField(datosp[pageIndex].getNombre());
			mnombre.setOnKeyTyped(e-> datosp[pageIndex].setNombre(mnombre.getText()));
			System.out.println("nombre: "+datosp[pageIndex].getNombre());
			raza = new TextField(datosp[pageIndex].getRaza());
			raza.setOnKeyTyped(e-> datosp[pageIndex].setRaza(raza.getText()));
			especie = new TextField(datosp[pageIndex].getEspecie());
			especie.setOnKeyTyped(e-> datosp[pageIndex].setEspecie(especie.getText()));

			sexo= new ChoiceBox<String>();
			sexo.getItems().addAll("Macho","Hembra","Otro");
			sexo.setValue(datosp[pageIndex].getSexo());
			sexo.setOnAction(e->datosp[pageIndex].setSexo(sexo.getValue()));

			edad = new Spinner<Integer>();
			SpinnerValueFactory<Integer> valores = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,99, datosp[pageIndex].getEdad());
			edad.setValueFactory(valores);
			edad.setEditable(true);
			edad.setOnMouseClicked(e->{
				datosp[pageIndex].setEdad(edad.getValue());
				System.out.println("XDEDAD CULIA "+ datosp[pageIndex].getEdad());
			});
			meses = new Spinner<Integer>();
			SpinnerValueFactory<Integer> vmeses = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,11, datosp[pageIndex].getMeses());
			meses.setValueFactory(vmeses);
			meses.setEditable(true);
			meses.setOnMouseClicked(e-> datosp[pageIndex].setMeses(meses.getValue()));
			meses.setOnKeyReleased(e-> datosp[pageIndex].setMeses(meses.getValue()));



			Label txtmnombre = new Label("Nombre de la mascota: ");
			Label txtraza = new Label("Raza: ");
			Label txtespecie = new Label("Especie: ");
			Label txtsexo = new Label("Sexo: "); 
			Label txtedad = new Label("Edad: ");
			Label txtmeses = new Label("Meses: ");
			GridPane form2 = new GridPane();
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
			form2.setPadding(new Insets(5,5,5,5));
			form2.setVgap(15);
			form2.setHgap(25);
			form2.getChildren().addAll(mnombre,especie,raza,sexo,edad,meses,txtmnombre,txtraza,txtsexo, txtespecie, txtedad,txtmeses);
			form2.setAlignment(Pos.CENTER);

			Button guardar2 = new Button("Guardar");
			guardar2.setOnAction(e->{
				if(cliente == null) System.out.println("Debe guardar sus datos en la otra pestaa primero");
				else if(Datos.comprobar(new Mascota(pageIndex, mnombre.getText(), especie.getText(), raza.getText(),sexo.getValue(), edad.getValue(), meses.getValue()))){
					int cont=0;
					for(Mascota revisando:cliente.getMascotas()){ 
						if(cont == cliente.getMascotas().length-1) cliente.addMascota(new Mascota(pageIndex, mnombre.getText(), especie.getText(), raza.getText(),sexo.getValue(), edad.getValue(), meses.getValue())); 
						else if(revisando.getId() == pageIndex){
							cliente.setMascota(cont, new Mascota(pageIndex, mnombre.getText(), especie.getText(), raza.getText(),sexo.getValue(), edad.getValue(), meses.getValue()));
							cont++;
						}
					}
					if (cont == 0)   cliente.addMascota(new Mascota(pageIndex, mnombre.getText(), especie.getText(), raza.getText(),sexo.getValue(), edad.getValue(), meses.getValue())); 
					System.out.println("se guardo "+ cliente.getMascotas()[cont]);
					Alert.display("Guardado", "La mascota "+ cliente.getMascotas()[cont].getNombre()+" se guardo correctamente","Ok");
				}		
				else Alert.display("Error", Datos.razon, "Ok");
			});
			Button cancelar2 = new Button("Cancelar");
			HBox derecha = new HBox();
			Button reservar = new Button("Reservar");
			reservar.setOnAction(e->{
				if(cliente == null) System.out.println("oe aweonao guarda el cliente");
				else{
					int idput = cliente.encontrarMascota(pageIndex);
					if(idput!= -1){
						reserva_window.setScene(escenaReservar(idput));
						reserva_window.show();
					}
					else System.out.println("No ha guardado la mascota");
				}
			});
			derecha.getChildren().addAll(reservar,guardar2, cancelar2);
			derecha.setSpacing(5);
			derecha.setAlignment(Pos.CENTER_RIGHT);
			agregar = new Button("Agregar Mascota");
			agregar.setAlignment(Pos.CENTER_LEFT);
			cancelar2.setOnAction(e->{
				datos_window.close();
			});
			Button quitar = new Button("Quitar mascota");
			quitar.setOnAction(e->{
			});
			
			HBox izquierda = new HBox();
				izquierda.getChildren().addAll(agregar,quitar);
				izquierda.setSpacing(5);
			VBox general2 = new VBox();
			HBox botones2 = new HBox();
			botones2.getChildren().addAll(izquierda,derecha);
			botones2.setAlignment(Pos.BOTTOM_RIGHT);
			botones2.setSpacing(10);
			botones2.setPadding(new Insets(5, 5,5,5));
			HBox.setHgrow(agregar, Priority.ALWAYS);
			HBox.setHgrow(derecha, Priority.ALWAYS);
			general2.getChildren().addAll(form2,botones2);
			agregar.setOnAction(e->{
				agregados++;
				datosp = Arrays.copyOf(datosp,agregados);
				datosp[agregados-1] = new Mascota(agregados-1);
				datosp[pageIndex].setEdad(edad.getValue());
				datosp[pageIndex].setMeses(meses.getValue());

				paginas.setPageCount(agregados);
				try {
					//datos_window.setScene(escenaDatos());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
	
				}
			});
			return general2;
        });
		paginas.setPageCount(agregados);
		paginas.setMaxPageIndicatorCount(3);
		Tab tab2 = new Tab("Datos mascota", paginas);
		tab1.setClosable(false);
		tab2.setClosable(false);
		tabs.getTabs().addAll(tab1,tab2);
		//Datos escritorMascotas
		return new Scene(tabs);
	}
	public static DatePicker desde;
	public static DatePicker hasta;
	public static ChoiceBox<String> tamano;
	public static ChoiceBox<String> peligro;
	public static CheckBox exotico;
	public static Scene escenaReservar(int id){
		Mascota mascota = cliente.getMascotas()[id];
		GridPane panel = new GridPane();
		//elementos gridpane
			VBox fechas = new VBox();
				desde = new DatePicker(mascota.getDesde());
				desde.setDayCellFactory(picker -> new DateCell() {
					public void updateItem(LocalDate date, boolean empty) {
						super.updateItem(date, empty);
						setDisable(empty || (date.compareTo(LocalDate.now()) < 0 || date.compareTo(hasta.getValue().minusDays(1)) > 0 ));
					}
				});
				desde.setOnAction(e->{
					mascota.setDesde(desde.getValue());
					cliente.setMascota(id,mascota);
					reserva_window.setScene(escenaReservar(id));
				});
				hasta= new DatePicker(mascota.getHasta());
				hasta.setDayCellFactory(picker -> new DateCell() {
					public void updateItem(LocalDate date, boolean empty) {
						super.updateItem(date, empty);
						setDisable(empty || date.compareTo(LocalDate.now().plusDays(1)) < 0 );
					}
				});
				hasta.setOnAction(e->{
					mascota.setHasta(hasta.getValue());
					cliente.setMascota(id,mascota);
					reserva_window.setScene(escenaReservar(id));
				});
				HBox desdebox = new HBox();
					Label txtdesde = new Label("Desde:\t");
					desdebox.getChildren().addAll(txtdesde,desde);
				HBox hastabox = new HBox();
					Label txthasta = new Label("Hasta:\t");
					hastabox.getChildren().addAll(txthasta,hasta);
				fechas.getChildren().addAll(desdebox,hastabox);
				fechas.setSpacing(15);
			TextArea animal_datos = new TextArea(//
			"Nombre:	"+mascota.getNombre()+//
			"\nEspecie:	"+mascota.getEspecie()+//
			"\nRaza:	"+mascota.getRaza()+//
			"\nEdad:	"+mascota.getEdad() + " años "+//
			"y "+mascota.getMeses() + " meses"+//
			"\nSexo:	"+mascota.getSexo());
			animal_datos.setEditable(false);
			animal_datos.setMinSize(50,50);
			animal_datos.setMaxSize(230,110);
			animal_datos.setStyle("-fx-background-color: grey");
			VBox ultrabox = new VBox();
				HBox tamanobox = new HBox();
					Label txttamano = new Label("Tamaño:\t\t");
					tamano = new ChoiceBox<String>();
					tamano.setValue(mascota.getTamano());
					tamano.getItems().add("Muy pequeño");
					tamano.getItems().add("Pequeño");
					tamano.getItems().add("Mediano");
					tamano.getItems().add("Grande");
					tamano.getItems().add("Muy grande");
					tamano.setOnAction(e->{
						mascota.setTamano(tamano.getValue());
						cliente.setMascota(id,mascota);
						reserva_window.setScene(escenaReservar(id));
					});
					tamanobox.getChildren().addAll(txttamano,tamano);
				VBox peligrobox = new VBox();
					Label txtpeligro = new Label("Peligrosidad:\t");
					HBox hpeligrobox = new HBox();
						peligro = new ChoiceBox<String>();
						peligro.setValue(mascota.getPeligrosidad());
						peligro.getItems().addAll("Domestico","Peligroso");
						peligro.setOnAction(e->{
							mascota.setPeligrosidad(peligro.getValue());
							cliente.setMascota(id,mascota);
							reserva_window.setScene(escenaReservar(id));
						});
						exotico = new CheckBox("Exotico");
						exotico.setSelected(mascota.getExotico());
						exotico.setOnAction(e->{
							mascota.setExotico(exotico.isSelected());
							cliente.setMascota(id,mascota);
							reserva_window.setScene(escenaReservar(id));
						});
						exotico.setAlignment(Pos.CENTER);
						hpeligrobox.getChildren().addAll(peligro,exotico);
						hpeligrobox.setSpacing(10);
					peligrobox.getChildren().addAll(txtpeligro,hpeligrobox);
					peligrobox.setSpacing(5);
				ultrabox.getChildren().addAll(tamanobox, peligrobox);
				ultrabox.setSpacing(25);
			VBox boletabox = new VBox();
				Label txtboleta = new Label("Boleta: ");
				TextArea boleta;
				if(cliente.getMascotas().length==1) boleta = new TextArea(mascota.calcularBoleta(0));
				else boleta = new TextArea(mascota.calcularBoleta(40));
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
		reservar.setOnAction(e->{
			String reservacion = cliente.toString()+"~"+cliente.getMascotas()[id].toString()+"\n";
			Archivo.escribir(reservas, reservacion);
			System.out.println("Ha reservado correctamente");
		});
		botones.getChildren().addAll(reservar);
		botones.setAlignment(Pos.BOTTOM_RIGHT);
		VBox general = new VBox();
		general.getChildren().addAll(panel,botones);
		general.setPadding(new Insets(5,5,5,5));
		return new Scene(general);
	}
}
