/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javafxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author 6305020
 */
public class JavaFXDemo extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    public void calcTotals(GridPane container, int totalExpenses, int totalAllowable, int excessOrSaved) {
        Label totalExpensesTitle = new Label("Total expenses:");
        container.add(totalExpensesTitle, 0, 0);
        Label totalExpensesAmount = new Label("" + totalExpenses);
        container.add(totalExpensesAmount, 1, 0);
        
        Label totalAllowableTitle = new Label("Total allowable:");
        container.add(totalAllowableTitle, 0, 1);
        Label totalAllowableAmount = new Label("" + totalAllowable);
        container.add(totalAllowableAmount, 1, 1);
        
        Label differenceTitle = new Label((excessOrSaved >= 0) ? "Amount saved:": "Excess to pay:");
        container.add(differenceTitle, 0, 2);
        Label differenceAmount = new Label((excessOrSaved >= 0) ? "" + excessOrSaved:"" + (excessOrSaved * -1));
        container.add(differenceAmount, 1, 2);
    }
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Travel Expense Calculator");
        
        int maxFieldSize = 75;
        
        Label tripDaysLabel = new Label("Number of days on the trip:");
        tripDaysLabel.setWrapText(true);
        TextField tripDaysField = new TextField();
        tripDaysField.setMaxWidth(maxFieldSize);
        
        Label airfareLabel = new Label("Amount of airfare:");
        airfareLabel.setWrapText(true);
        TextField airfareField = new TextField();
        airfareField.setMaxWidth(maxFieldSize);
        
        Label carRentalFeesLabel = new Label("Amount of car rental fees");
        carRentalFeesLabel.setWrapText(true);
        TextField carRentalFeesField = new TextField();
        carRentalFeesField.setMaxWidth(maxFieldSize);
        
        Label milesDrivenLabel = new Label("Number of miles driven:");
        milesDrivenLabel.setWrapText(true);
        TextField milesDrivenField = new TextField();
        milesDrivenField.setMaxWidth(maxFieldSize);
        
        Label parkingFeesLabel = new Label("Amount of parking fees:");
        parkingFeesLabel.setWrapText(true);
        TextField parkingFeesField = new TextField();
        parkingFeesField.setMaxWidth(maxFieldSize);
        
        Label taxiChargesLabel = new Label("Amount of taxi charges:");
        taxiChargesLabel.setWrapText(true);
        TextField taxiChargesField = new TextField();
        taxiChargesField.setMaxWidth(maxFieldSize);
        
        Label seminarFeesLabel = new Label("Conference or seminar registration fees:");
        seminarFeesLabel.setWrapText(true);
        TextField seminarFeesField = new TextField();
        seminarFeesField.setMaxWidth(maxFieldSize);
        
        Label lodgingChargesLabel = new Label("Lodging charges (per night):");
        lodgingChargesLabel.setWrapText(true);
        TextField lodgingChargesField = new TextField();
        lodgingChargesField.setMaxWidth(maxFieldSize);
        
        Label[] labels = {tripDaysLabel,
            airfareLabel,
            carRentalFeesLabel,
            milesDrivenLabel,
            parkingFeesLabel,
            taxiChargesLabel,
            seminarFeesLabel,
            lodgingChargesLabel
        };
        
        TextField[] fields = {tripDaysField,
            airfareField,
            carRentalFeesField,
            milesDrivenField,
            parkingFeesField,
            taxiChargesField,
            seminarFeesField,
            lodgingChargesField
        };
        
        GridPane grid = new GridPane();
        grid.setVgap(10);
        
        grid.add(tripDaysLabel, 0, 0);
        grid.add(tripDaysField, 1, 0);
        
        grid.add(airfareLabel, 0, 1);
        grid.add(airfareField, 1, 1);
        
        grid.add(carRentalFeesLabel, 0, 2);
        grid.add(carRentalFeesField, 1, 2);
        
        grid.add(milesDrivenLabel, 0, 3);
        grid.add(milesDrivenField, 1, 3);
        
        grid.add(parkingFeesLabel, 2, 0);
        grid.add(parkingFeesField, 3, 0);
        
        grid.add(taxiChargesLabel, 2, 1);
        grid.add(taxiChargesField, 3, 1);
        
        grid.add(seminarFeesLabel, 2, 2);
        grid.add(seminarFeesField, 3, 2);
        
        grid.add(lodgingChargesLabel, 2, 3);
        grid.add(lodgingChargesField, 3, 3);
        
        grid.setHgap(15);
        
        GridPane finalData = new GridPane();
        finalData.setId("final-data-container");
        finalData.setHgap(100);
        finalData.setVgap(15);
        BorderPane finalDataContainer = new BorderPane(finalData);
        
        finalDataContainer.prefWidth(600);
        finalDataContainer.setPadding(new Insets(150));
//        finalData.setStyle("-fx-border-color: black; -fx-border-size: 1px; -fx-border-style: solid;");

        Button calcButton = new Button("Calculate Total");
        
        Button clearButton = new Button("Reset");
        
        HBox buttonsContainer = new HBox(calcButton, clearButton);
        buttonsContainer.setAlignment(Pos.CENTER);
        
        calcButton.setOnAction((ActionEvent e) -> {
            try {
                int daysAmount = Integer.parseInt(tripDaysField.getText());
            } catch (Exception err) {
                System.err.println("Error: " + err.getMessage());
            }
            
            calcTotals(finalData, 0, 0, 0);
            finalData.setVisible(true);
        });
        
        clearButton.setOnAction((ActionEvent e) -> {
            tripDaysField.setText("");
            airfareField.setText("");
            carRentalFeesField.setText("");
            milesDrivenField.setText("");
            parkingFeesField.setText("");
            taxiChargesField.setText("");
            seminarFeesField.setText("");
            lodgingChargesField.setText("");
            
            finalData.setVisible(false);
        });
        
        VBox root = new VBox(grid, buttonsContainer, finalDataContainer);
        root.setSpacing(15);
        root.setPadding(new Insets(10));
        
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add("file:src/styles.css");
        
        stage.setScene(scene);
        stage.show();
    }
    
}
