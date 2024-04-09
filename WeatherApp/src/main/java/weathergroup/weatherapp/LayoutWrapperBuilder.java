package weathergroup.weatherapp;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
public class LayoutWrapperBuilder implements Builder<Region> {

    private final WeatherModel model;
    Region locationView;

    public LayoutWrapperBuilder(WeatherModel model) {
        this.model = model;
    }

    @Override
    public Region build() {
        BorderPane results = new BorderPane();
        Region weatherView = new WeatherViewBuilder(model, createSceneSwapper(results)).build();
        this.locationView = new LocationSearchBuilder(model, () -> results.setCenter(weatherView)).build();
        results.setCenter(weatherView);

        results.getStylesheets().add(this.getClass().getResource("/css/style.css").toExternalForm());
        return results;
    }
    // ...replaced with: "() -> results.setCenter(locationView)).build()"
    private Runnable createSceneSwapper(BorderPane wrapper){
        return () -> wrapper.setCenter(locationView);
    }
}
