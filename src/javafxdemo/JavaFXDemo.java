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
import javafx.stage.Stage;

/**
 *
 * @author 6305020
 */
public class JavaFXDemo extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    Label totalExpensesTitle;
    Label totalExpensesAmount;
    Label totalAllowableTitle;
    Label totalAllowableAmount;
    Label differenceTitle;
    Label differenceAmount;
    
    public void calcTotals(GridPane container, double totalExpenses, double totalAllowable, double excessOrSaved) {
        excessOrSaved = Math.round(excessOrSaved * 100) / 100;
        
        totalExpensesAmount.setText(String.format("%.2f", totalExpenses));
        
        totalAllowableAmount.setText(String.format("%.2f", totalAllowable));
        
        differenceTitle.setText((excessOrSaved >= 0) ? "Amount saved:": "Excess to pay:");
        
        differenceAmount.setText(String.format("%.2f", (excessOrSaved >= 0) ? excessOrSaved:(excessOrSaved * -1)));
        differenceAmount.setStyle((excessOrSaved >= 0) ? "-fx-text-fill: green;": "-fx-text-fill: red;");
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
        
//        Label[] labels = {tripDaysLabel,
//            airfareLabel,
//            carRentalFeesLabel,
//            milesDrivenLabel,
//            parkingFeesLabel,
//            taxiChargesLabel,
//            seminarFeesLabel,
//            lodgingChargesLabel
//        };
//        
//        TextField[] fields = {tripDaysField,
//            airfareField,
//            carRentalFeesField,
//            milesDrivenField,
//            parkingFeesField,
//            taxiChargesField,
//            seminarFeesField,
//            lodgingChargesField
//        };
        
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
        finalData.setVisible(false);
        finalData.setId("final-data-container");
        finalData.setHgap(100);
        finalData.setVgap(15);
        BorderPane finalDataContainer = new BorderPane(finalData);
        
        finalDataContainer.prefWidth(600);
        finalDataContainer.setPadding(new Insets(150));

        Button calcButton = new Button("Calculate Total");
        
        Button clearButton = new Button("Reset");
        
        HBox buttonsContainer = new HBox(calcButton, clearButton);
        buttonsContainer.setSpacing(10);
        buttonsContainer.setAlignment(Pos.CENTER);
        
        totalExpensesTitle = new Label("Total expenses:");
        finalData.add(totalExpensesTitle, 0, 0);
        totalExpensesAmount = new Label();
        totalExpensesAmount.setMaxWidth(2000);
        finalData.add(totalExpensesAmount, 1, 0);

        totalAllowableTitle = new Label("Total allowable:");
        finalData.add(totalAllowableTitle, 0, 1);
        totalAllowableAmount = new Label();
        totalAllowableAmount.setMaxWidth(2000);
        finalData.add(totalAllowableAmount, 1, 1);

        differenceTitle = new Label();
        finalData.add(differenceTitle, 0, 2);
        differenceAmount = new Label();
        differenceAmount.setMaxWidth(2000);
        finalData.add(differenceAmount, 1, 2);
        
        calcButton.setOnAction((ActionEvent e) -> {
            double price = 0;
            double totalAllowable = 0;
            
            int daysAmount = 0;
            
            try {
                daysAmount = !tripDaysField.getText().isEmpty() ? Integer.parseInt(tripDaysField.getText()) : 0;
                
                double airfare = !airfareField.getText().isEmpty() ? Double.parseDouble(airfareField.getText()): 0;
                price += airfare;
                
                double carRentalFees = !carRentalFeesField.getText().isEmpty() ? Double.parseDouble(carRentalFeesField.getText()): 0;
                price += carRentalFees;
                
                double milesDriven = !milesDrivenField.getText().isEmpty() ? Double.parseDouble(milesDrivenField.getText()): 0;
                
                double parkingFees = !parkingFeesField.getText().isEmpty() ? Double.parseDouble(parkingFeesField.getText()): 0;
                price += parkingFees;
                
                double taxiCharges = !taxiChargesField.getText().isEmpty() ? Double.parseDouble(taxiChargesField.getText()): 0;
                price += taxiCharges;
                
                double seminarFees = !seminarFeesField.getText().isEmpty() ? Double.parseDouble(seminarFeesField.getText()): 0;
                price += seminarFees;
                
                double lodgingCharges = !lodgingChargesField.getText().isEmpty() ? Double.parseDouble(lodgingChargesField.getText()): 0;
                price += lodgingCharges * daysAmount;
                
                totalAllowable += 37 * daysAmount;
                totalAllowable += Math.min(parkingFees, 10 * daysAmount);
                totalAllowable += Math.min(taxiCharges, 20 * daysAmount);
                totalAllowable += Math.min(lodgingCharges, 95 * daysAmount);
                totalAllowable += 0.27 * milesDriven;
                
            } catch (Exception err) {
                System.err.println("Error: " + err.getMessage());
            }
            
            calcTotals(finalData, price, totalAllowable, totalAllowable - price);
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
