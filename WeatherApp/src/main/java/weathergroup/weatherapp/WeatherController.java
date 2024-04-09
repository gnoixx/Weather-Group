package weathergroup.weatherapp;

import javafx.scene.layout.Region;
import javafx.util.Builder;

public class WeatherController {
    private Builder<Region> viewBuilder;
    private WeatherInteractor interactor;

    public WeatherController() {
        WeatherModel model = new WeatherModel();
        viewBuilder = new LayoutWrapperBuilder(model);
        interactor = new WeatherInteractor(model);
    }
    public Region getView(){
        return viewBuilder.build();
    }
}

