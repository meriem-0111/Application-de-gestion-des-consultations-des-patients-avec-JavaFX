import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PatientConsultationApp extends Application {

    private ArrayList<String> consultations = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Patient Consultation Management");

        ListView<String> listView = new ListView<>();
        TextField patientInput = new TextField();
        patientInput.setPromptText("Enter patient name");
        Button addButton = new Button("Add Consultation");

        // Add validation and clear the input field on successful addition
        addButton.setOnAction(e -> {
            String patientName = patientInput.getText().trim(); // trimming to avoid spaces
            if (!patientName.isEmpty()) {
                consultations.add(patientName);
                listView.getItems().add(patientName);
                patientInput.clear();
            } else {
                // Optionally show a message on invalid input
                System.out.println("Please enter a valid patient name.");
            }
        });

        // Set padding for layout
        VBox vbox = new VBox(10); // Set spacing of the VBox
        vbox.setPadding(new Insets(10)); // Set padding
        vbox.getChildren().addAll(patientInput, addButton, listView);

        Scene scene = new Scene(vbox, 400, 300); // Increased width for better visibility
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
