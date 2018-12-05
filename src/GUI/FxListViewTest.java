package GUI;

import Controller.DataController;
import java.util.ArrayList;
import java.util.Scanner;

import Data.CSVHospital;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxListViewTest extends Application {



	///Uses Controller.Controller.java
	DataController c1;
	///TextArea for results
	TextArea logging;
	///Scanner for input
	Scanner kbd = new Scanner(System.in);



	public FxListViewTest(){
		c1 = new DataController();
		System.out.println("Set CSV File Location: ");
		c1.setCSVLocation(kbd.next());
		System.out.println("======Processing CSV File=======");
		c1.intakeCSV();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		///Creating and Setting TextArea
		logging = new TextArea();
		logging.setMaxWidth(300);
		logging.setMaxHeight(300);

		///Top Label
		Label monthsLbl = new Label("Select Month: ");

		///Create ListView
		final ListView<CSVHospital> hospitals = new ListView<>();
		///Add the items to the List
		hospitals.getItems().addAll(c1.getOriginalHospitals());
		// Set the size of the ListView
		hospitals.setPrefSize(120, 120);


		// Enable multiple selection
		/// *** May not be needed *** hospitals.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


		// Create the HBox for the Months
		HBox monthsSelection = new HBox();
		// Set Spacing to 10 pixels
		monthsSelection.setSpacing(10);
		// Add the Label and the List to the HBox
		monthsSelection.getChildren().addAll(monthsLbl, hospitals);









/*
		// Update the message Label when the selected item changes
		hospitals.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>()
		{
		    public void changed(ObservableValue<? extends String> ov,
		            final String oldvalue, final String newvalue)
		    {
		    	monthChanged(ov, oldvalue, newvalue);
        }});
*/



		// Create some buttons to assist in selection
		Button selectAllBtn = new Button("Select All");
		Button clearAllBtn = new Button("Clear All");
		Button selectFirstBtn = new Button("Select First");
		Button selectLastBtn = new Button("Select Last");
		Button selectNextBtn = new Button("Select Next");
		Button selectPreviousBtn = new Button("Select Previous");

		// Let all buttons expand as needed
		selectAllBtn.setMaxWidth(Double.MAX_VALUE);
		clearAllBtn.setMaxWidth(Double.MAX_VALUE);
		selectFirstBtn.setMaxWidth(Double.MAX_VALUE);
		selectLastBtn.setMaxWidth(Double.MAX_VALUE);
		selectNextBtn.setMaxWidth(Double.MAX_VALUE);
		selectPreviousBtn.setMaxWidth(Double.MAX_VALUE);

		// Update the TextArea when all items will be selected
		selectAllBtn.setOnAction(new EventHandler<ActionEvent>()
		{
            @Override public void handle(ActionEvent e)
            {
				///hospitals.getSelectionModel().selectAll();
				System.out.println("Testing select all");
				logging.appendText(c1.makeTextViewPrintable().toString());


            }
        });

		// Update the TextArea when the selection will be deleted
		clearAllBtn.setOnAction(new EventHandler<ActionEvent>()
		{
            @Override public void handle(ActionEvent e)
            {
				logging.clear();
            }
        });

		// Update the TextArea when the first item will be selected
		selectFirstBtn.setOnAction(new EventHandler<ActionEvent>()
		{
            @Override public void handle(ActionEvent e)
            {
            	c1.sortByHighRating();
				logging.appendText(c1.makeTextViewPrintable().toString());
            }
        });

		// Update the TextArea when the last item will be selected
		selectLastBtn.setOnAction(new EventHandler<ActionEvent>()
		{
            @Override public void handle(ActionEvent e)
            {
				hospitals.getSelectionModel().selectLast();
            }
        });

		// Update the TextArea when the next item will be selected
		selectNextBtn.setOnAction(new EventHandler<ActionEvent>()
		{
            @Override public void handle(ActionEvent e)
            {
				hospitals.getSelectionModel().selectNext();
            }
        });

		// Update the TextArea when the previous item will be selected
		selectPreviousBtn.setOnAction(new EventHandler<ActionEvent>()
		{
            @Override public void handle(ActionEvent e)
            {
				hospitals.getSelectionModel().selectPrevious();
            }
        });

		// Create the VBox for the Buttons
		VBox buttons = new VBox();
		// Add the Buttons to the VBox
		buttons.getChildren().addAll(selectFirstBtn,selectLastBtn,selectNextBtn,
				selectPreviousBtn,selectAllBtn,clearAllBtn);

		// Create the Selection HBox
		HBox selection = new HBox();
		// Set Spacing to 10 pixels
		selection.setSpacing(10);
		// Add the List and the Buttons to the HBox
		selection.getChildren().addAll(monthsSelection,buttons);

		// Create the GridPane
		GridPane pane = new GridPane();
		// Set the horizontal and vertical gaps between children
		pane.setHgap(10);
		pane.setVgap(5);
		// Add the HBox to the GridPane at position 0
		pane.addColumn(0, selection);
		// Add the Buttons to the GridPane at position 1
		pane.addColumn(1, buttons);

		// Create the VBox
		VBox root = new VBox();
		// Set Spacing to 10 pixels
		root.setSpacing(10);
		// Add the GridPane and the TextArea to the VBox
		root.getChildren().addAll(pane,logging);

		// Set the Style-properties of the VBox
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");

		// Create the Scene
		Scene scene = new Scene(root);
		// Add the Scene to the Stage
		stage.setScene(scene);
		// Set the Title
		stage.setTitle("A ListView Example with a Selection Model");
		// Display the Stage
		stage.show();
	}



	protected void printHospitalsToLog(){
		for (CSVHospital hospital : c1.getModifiedlHospitals()){
			logging.appendText( hospital.toString() + "\n");
		}
	}




	// Method to display the Data, which has been changed
	public void monthChanged(ObservableValue<? extends String> observable,String oldValue,String newValue)
	{
		String oldText = oldValue == null ? "null" : oldValue.toString();
		String newText = newValue == null ? "null" : newValue.toString();

		logging.appendText("Itemchanged: old = " + oldText + ", new = " + newText + "\n");
	}

}
