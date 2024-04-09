package weathergroup.weatherapp;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class WeatherController {
    private Builder<Region> viewBuilder;
    private WeatherInteractor interactor;

    public WeatherController() {
        WeatherModel model = new WeatherModel();
        viewBuilder = new LayoutWrapperBuilder(model, this::fetchWeather);
        interactor = new WeatherInteractor(model);
    }
    private void fetchWeather(Runnable postFetchGuiStuff) {
        Task<Void> fetchTask = new Task<>() {
            @Override
            protected Void call() {
                interactor.checkWeather();
                return null;
            }
        };
        fetchTask.setOnSucceeded(evt -> {
            interactor.updateWeatherModel();
            postFetchGuiStuff.run();
        });
        fetchTask.setOnFailed(evt -> postFetchGuiStuff.run());
        Thread fetchThread = new Thread(fetchTask);
        fetchThread.start();
    }
    public Region getView(){
        return viewBuilder.build();
    }
}
