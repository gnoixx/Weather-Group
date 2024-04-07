package weathergroup.weatherapp;

import java.util.Arrays;

// TODO: Sort States array
public class WeatherInteractor {
    private WeatherModel model;

    public WeatherInteractor(WeatherModel model) {
        this.model = model;
        model.setStates(Arrays.asList(
                "AL", "KY", "OH",
                "AK", "LA", "OK",
                "AZ", "ME", "OR",
                "AR", "MD", "PA",
                "AS", "MA", "PR",
                "CA", "MI", "RI",
                "CO", "MN", "SC",
                "CT", "MS", "SD",
                "DE", "MO", "TN",
                "MT", "TX", "FL",
                "NE", "GA", "NV",
                "UT", "NH", "VT",
                "HI", "NJ", "VA",
                "ID", "NM",
                "IL", "NY", "WA",
                "IN", "NC", "WV",
                "IA", "ND", "WI",
                "KS", "WY"));
    }
}
