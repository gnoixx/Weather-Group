package weathergroup.weatherapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class LocationSearchBuilder implements Builder<Region> {

    private final WeatherModel model;
    private final Runnable sceneSwapper;

    public LocationSearchBuilder(WeatherModel model, Runnable sceneSwapper) {
        this.model = model;
        this.sceneSwapper = sceneSwapper;
    }

    @Override
    public Region build() {
        Button button = new Button("View Weather");
        button.setOnAction(evt -> sceneSwapper.run());
        VBox results = new VBox(20, new Label("asdf"), button);
        results.setAlignment(Pos.CENTER);
        return results;
    }
}
