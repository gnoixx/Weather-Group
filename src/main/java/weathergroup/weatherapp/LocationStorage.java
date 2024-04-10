package weathergroup.weatherapp;

import java.util.ArrayList;
import java.util.List;

public class LocationStorage
{
    private List<Location> storedLocations;

    public LocationStorage()
    {
        storedLocations = new ArrayList<>();
    }

    public void addLocation(Location location)
    {
        storedLocations.add(location);
    }

    public void removeLocation(Location location)
    {
        storedLocations.remove(location);
    }

    public List<Location> getStoredLocations()
    {
        return storedLocations;
    }
}
