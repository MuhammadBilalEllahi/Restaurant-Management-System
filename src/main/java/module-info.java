module com.example.restaurantsystem {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.restaurantsystem to javafx.fxml;
    exports com.example.restaurantsystem;
}