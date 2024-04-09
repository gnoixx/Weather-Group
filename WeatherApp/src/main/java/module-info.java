module weathergroup.weatherapp {
    requires javafx.controls;
    requires okhttp3;
    requires com.google.gson;
    //requires javafx.fxml;


    //opens weathergroup.weatherapp to javafx.fxml;
    exports weathergroup.weatherapp;
}