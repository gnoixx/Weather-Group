module weathergroup.weatherapp
{
    requires javafx.controls;
    //requires javafx.fxml;
    requires java.net.http;
    requires org.json;


    //opens weathergroup.weatherapp to javafx.fxml;
    exports weathergroup.weatherapp;
}