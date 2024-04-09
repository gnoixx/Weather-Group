package weathergroup.weatherapp;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

import java.util.function.Consumer;

public class LocationSearchBuilder implements Builder<Region> {

    private final WeatherModel model;
    private final Runnable sceneSwapper;
    private final StringProperty city = new SimpleStringProperty();
    private final StringProperty state = new SimpleStringProperty();
    private final Consumer<Runnable> weatherFetcher;

    public LocationSearchBuilder(WeatherModel model, Consumer<Runnable> weatherFetcher, Runnable sceneSwapper) {
        this.model = model;
        this.weatherFetcher = weatherFetcher;
        this.sceneSwapper = sceneSwapper;
    }

    @Override
    public Region build() {
        BooleanProperty saving = new SimpleBooleanProperty(false);
        Button button = new Button("View Weather");
        button.disableProperty().bind(saving);
        button.setOnAction(evt -> sceneSwapper.run());
        VBox results = new VBox(20, button,
                new Label("Change Location"),
                buildSearchTools(saving)
        );
        results.setAlignment(Pos.TOP_CENTER);
        results.setPadding(new Insets(20));
        return results;
    }

    private Node buildSearchTools(BooleanProperty saving){
        ComboBox<String> stateCB = new ComboBox<>();
        stateCB.getItems().setAll(model.getStates());
        state.bind(stateCB.valueProperty());

        TextField cityTF = new TextField();
        city.bind(cityTF.textProperty());

        // state and city fields
        HBox fields = new HBox(10, buildLabeledTool("State", stateCB),
                buildLabeledTool("City:", cityTF));

        // Location history or favorites
        TabPane locationViews = new TabPane();
        locationViews.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        Tab history = new Tab("History");
        Tab favorites = new Tab("Favorites");
        locationViews.getTabs().addAll(history, favorites);
        ListView<Location> locationHistory = new ListView<>();
        history.setContent(locationHistory);

        // Confirm button
        Button confirmButton = buildConfirmButton(weatherFetcher, saving);

        VBox results = new VBox(10, fields, locationViews, confirmButton);
        results.setPadding(new Insets(24));
        return results;
    }

    private Button buildConfirmButton(Consumer<Runnable> weatherFetcher, BooleanProperty saving){
        // Confirm button
        Button confirmButton = new Button("Confirm");

        // Confirm button is disabled if city/state fields are empty OR if we are saving weather data
        confirmButton.disableProperty().bind(
                city.isEmpty()
                        .or(state.isEmpty()
                                .or(saving))
        );

        confirmButton.setOnAction(evt -> {
            saving.set(true);
            weatherFetcher.accept(() -> {
                model.setCity(city.get());
                saving.set(false);
            });
        });

        return confirmButton;
    }

    private VBox buildLabeledTool(String labelText, Node item){
        return new VBox(new Label(labelText), item);
    }
}
