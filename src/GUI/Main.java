package GUI;

import Data.CSVHospital;
import Controller.DataController;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main extends Application {

    ///Uses Controller.Controller.java
    DataController c1;

    private TableView<CSVHospital> table;
    private ObservableList<CSVHospital> data;
    private TextArea logging;


    public Main(){
        c1 = new DataController();
        table = new TableView<>();
        logging = new TextArea();


        ///System.out.println("Set CSV File Location: ");
        ///c1.setCSVLocation(kbd.next());
        ///System.out.println("======Processing CSV File=======");
        ///c1.intakeCSV();
        ///data = FXCollections.observableArrayList(c1.getModifiedlHospitals());
    }




    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Software for Social Good");
        stage.setWidth(800);
        stage.setHeight(500);

        final Label label = new Label("Hospital Data Results");
        label.setFont(new Font("Arial", 20));




        TableColumn providerIDCol = new TableColumn("Provider ID");
        providerIDCol.setMinWidth(100);
        providerIDCol.setCellValueFactory(
                new PropertyValueFactory<>("providerID"));

        TableColumn NameCol = new TableColumn("Name");
        NameCol.setMinWidth(100);
        NameCol.setCellValueFactory(
                new PropertyValueFactory<>("name"));

        TableColumn addressCol = new TableColumn("Address");
        addressCol.setMinWidth(100);
        addressCol.setCellValueFactory(
                new PropertyValueFactory<>("address"));

        TableColumn cityCol = new TableColumn("City");
        cityCol.setMinWidth(100);
        cityCol.setCellValueFactory(
                new PropertyValueFactory<>("city"));

        TableColumn stateCol = new TableColumn("State");
        stateCol.setMinWidth(100);
        stateCol.setCellValueFactory(
                new PropertyValueFactory<>("state"));

        TableColumn zipCodeCol = new TableColumn("Zip Code");
        zipCodeCol.setMinWidth(200);
        zipCodeCol.setCellValueFactory(
                new PropertyValueFactory<>("zipCode"));

        TableColumn countyCol = new TableColumn("County Name");
        countyCol.setMinWidth(100);
        countyCol.setCellValueFactory(
                new PropertyValueFactory<>("county"));

        TableColumn phoneNumCol = new TableColumn("Phone Number");
        phoneNumCol.setMinWidth(100);
        phoneNumCol.setCellValueFactory(
                new PropertyValueFactory<>("phoneNum"));

        TableColumn type = new TableColumn("Hospital Type");
        type.setMinWidth(100);
        type.setCellValueFactory(
                new PropertyValueFactory<>("type"));

        TableColumn ownership = new TableColumn("Hospital Ownership");
        ownership.setMinWidth(100);
        ownership.setCellValueFactory(
                new PropertyValueFactory<>("ownership"));

        TableColumn emergency = new TableColumn("Emergency Services");
        emergency.setMinWidth(100);
        emergency.setCellValueFactory(
                new PropertyValueFactory<>("emergency"));

        TableColumn erhs = new TableColumn("Meets ERHs");
        erhs.setMinWidth(100);
        erhs.setCellValueFactory(
                new PropertyValueFactory<>("erhs"));

        TableColumn rating = new TableColumn("Hospital overall rating");
        rating.setMinWidth(100);
        rating.setCellValueFactory(
                new PropertyValueFactory<>("rating"));

        TableColumn mortality = new TableColumn("Mortality national comparison");
        mortality.setMinWidth(100);
        mortality.setCellValueFactory(
                new PropertyValueFactory<>("mortality"));

        TableColumn safety = new TableColumn("Safety of care national comparison");
        safety.setMinWidth(100);
        safety.setCellValueFactory(
                new PropertyValueFactory<>("safety"));

        TableColumn readmit = new TableColumn("Readmission national comparison");
        readmit.setMinWidth(100);
        readmit.setCellValueFactory(
                new PropertyValueFactory<>("readmit"));

        TableColumn experience = new TableColumn("Patient experience national comparison");
        experience.setMinWidth(100);
        experience.setCellValueFactory(
                new PropertyValueFactory<>("experience"));

        TableColumn effective = new TableColumn("Effectiveness of care national comparison");
        effective.setMinWidth(100);
        effective.setCellValueFactory(
                new PropertyValueFactory<>("effective"));

        TableColumn timeliness = new TableColumn("Timeliness of care national comparison");
        timeliness.setMinWidth(100);
        timeliness.setCellValueFactory(
                new PropertyValueFactory<>("timeliness"));

        TableColumn efficientImage = new TableColumn("Efficient use of medical imaging national comparison");
        efficientImage.setMinWidth(100);
        efficientImage.setCellValueFactory(
                new PropertyValueFactory<>("efficientImage"));





        ///Input CSV button handling
        TextInputDialog csvInputDialog = new TextInputDialog();
        csvInputDialog.setTitle("Open CSV File");
        csvInputDialog.setHeaderText("Enter the full file address of CSV");
        csvInputDialog.setContentText("Please enter file address here:");

        Button csvInputButton = new Button("Input CSV File");
        csvInputButton.setMaxWidth(Double.MAX_VALUE);
        csvInputButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                ///System.out.println("Testing CSVInput button");

                // Get the response value (with lambda expression).
                Optional<String> result = csvInputDialog.showAndWait();
                result.ifPresent(name -> c1.setCSVLocation(result.get()));
                c1.intakeCSV();
                data = FXCollections.observableArrayList(c1.getModifiedlHospitals());
                table.setItems(data);

                ///c1.filterOutRatingLowerOrEqual(3);
                ///data.removeAll(data);
                ///data.addAll(c1.getModifiedlHospitals());
            }
        });



        ///Clear All button handling
        Alert clearAlert = new Alert(Alert.AlertType.CONFIRMATION);
        clearAlert.setTitle("Clear All Data");
        clearAlert.setHeaderText("Are you sure you want to clear all data?");

        Button clearButton = new Button("Clear All");
        clearButton.setMaxWidth(Double.MAX_VALUE);
        clearButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Optional<ButtonType> result = clearAlert.showAndWait();
                if (result.get() == ButtonType.OK){
                    // ... user chose OK
                    if (c1.hasData())
                        data.removeAll(data);
                } else {
                    // ... user chose CANCEL or closed the dialog
                }

            }
        });



        ///Reset button handling
        Alert resetAlert = new Alert(Alert.AlertType.CONFIRMATION);
        resetAlert.setTitle("Reset All Data");
        resetAlert.setHeaderText("Are you sure you want to reset all changes to the data?");

        Button resetButton = new Button("Reset");
        resetButton.setMaxWidth(Double.MAX_VALUE);
        resetButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Optional<ButtonType> result = resetAlert.showAndWait();
                if (result.get() == ButtonType.OK){
                    // ... user chose OK
                    if (c1.hasData()) {
                        data.removeAll(data);
                        data.addAll(c1.getOriginalHospitals());
                    }
                } else {
                    // ... user chose CANCEL or closed the dialog
                }

            }
        });



        ///FilterRatings button handling
        List<String> filterRatingchoices = new ArrayList<>();
        filterRatingchoices.add("1");
        filterRatingchoices.add("2");
        filterRatingchoices.add("3");
        filterRatingchoices.add("4");
        filterRatingchoices.add("5");

        ChoiceDialog<String> filterRatingDialog = new ChoiceDialog<>("1", filterRatingchoices);
        filterRatingDialog.setTitle("Filter Out Lower Ratings");
        filterRatingDialog.setHeaderText("Filter out ratings lower or equal to a certain rating");
        filterRatingDialog.setContentText("Choose a Rating:");

        Button filterRatingButton = new Button("Filter Out <=");
        filterRatingButton.setMaxWidth(Double.MAX_VALUE);
        filterRatingButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Optional<String> result = filterRatingDialog.showAndWait();
                if (result.isPresent()) {
                    if (c1.hasData()) {
                        c1.filterOutRatingLowerOrEqual(Integer.parseInt(result.get()));
                        data.removeAll(data);
                        data.addAll(c1.getModifiedlHospitals());
                    }
                }
            }
        });



        ///FilterInExactMatch Dialog and button handling

        // Create the custom dialog.
        Dialog<Pair<String, String>> filterInExactMatchDialog = new Dialog<>();
        filterInExactMatchDialog.setTitle("Filter In Exact Match");
        filterInExactMatchDialog.setHeaderText("Filter in only exact matches of an attribute.");

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("Filter", ButtonBar.ButtonData.OK_DONE);
        filterInExactMatchDialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        ChoiceBox attribute = new ChoiceBox(FXCollections.observableArrayList(
                "Hospital Type", "Second", "Third")
        );

        TextField value = new TextField();
        value.setPromptText("Value");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(attribute, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(value, 1, 1);

        // Enable/Disable login button depending on whether a username was entered.
        Node loginButton = filterInExactMatchDialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

        // Do some validation (using the Java 8 lambda syntax).
        value.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        filterInExactMatchDialog.getDialogPane().setContent(grid);

        // Request focus on the username field by default.
        ///Platform.runLater(() -> username.requestFocus());

        // Convert the result to a username-password-pair when the login button is clicked.
        filterInExactMatchDialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(attribute.getValue().toString(), value.getText());
            }
            return null;
        });

        ///Button Handling
        Button filterInExactMatchButton = new Button("Filter in Match");
        filterInExactMatchButton.setMaxWidth(Double.MAX_VALUE);
        filterInExactMatchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                Optional<Pair<String, String>> result = filterInExactMatchDialog.showAndWait();
                if (result.isPresent()) {
                    if (c1.hasData()) {


                        c1.filterInExactMatch(result.get().getKey() , result.get().getValue() );

                        data.removeAll(data);
                        data.addAll(c1.getModifiedlHospitals());
                    }
                }
            }
        });




        ///Optional<Pair<String, String>> result = filterInExactMatchDialog.showAndWait();

        ///result.ifPresent(usernamePassword -> {
        ///    System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
        ///});





        ///VBox to hold all buttons
        VBox buttons = new VBox();
        buttons.setSpacing(10);
        buttons.getChildren().addAll(csvInputButton, resetButton, clearButton, filterRatingButton, filterInExactMatchButton);



        // Create the GridPane
        GridPane pane = new GridPane();
        // Set the horizontal and vertical gaps between children
        pane.setHgap(10);
        pane.setVgap(5);
        // Add the HBox to the GridPane at position 0
        ///pane.addColumn(0, selection);
        // Add the Buttons to the GridPane at position 1
        pane.addColumn(1, buttons);





        table.setItems(data);
        table.getColumns().addAll(providerIDCol, NameCol, addressCol, cityCol, stateCol, zipCodeCol, countyCol,
                phoneNumCol, type, ownership, emergency, erhs, rating, mortality, safety, readmit, experience,
                effective, timeliness, efficientImage
            );
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setEditable(true);


        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(50, 0, 0, 50));
        vbox.getChildren().addAll(label, table);
        vbox.prefWidthProperty().bind(stage.widthProperty().multiply(0.90));
        vbox.prefHeightProperty().bind(stage.heightProperty().multiply(0.60));
        vbox.setLayoutY(120);
        vbox.setLayoutX(7);


        ((Group) scene.getRoot()).getChildren().addAll(vbox, pane);

        stage.setScene(scene);
        stage.show();

    }


} 