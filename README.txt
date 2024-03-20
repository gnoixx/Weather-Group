===== Code Structure =====
The structure of our program is based largely off of PregmaticCoding's blog posts. He uses a framework called Model-View-Controller-Interactor (MVC-I).
You can view those posts here: https://www.pragmaticcoding.ca/
-- Main:
Main.java implements main() and starts the program. 
Main.java instantiates a WeatherController object and calls its getView() method, which returns a Region type object.
The region object is passed to the scene, which is passed to the stage. The stage's show() method is then called.

-- WeatherController:
WeatherController instantiates all the other elements of our program and passes them the WeatherModel.
The WeatherController class contains a reference to a Builder<Region> object called viewBuilder.
In the constructor, viewBuilder is assigned to a new WeatherViewBuilder object and the WeatherModel is passed into it.

note: The interactor will be used later to interface with our WeatherData and other business objects, but is left barebones for now.

-- WeatherViewBuilder:
The WeatherViewBuilder is what constructs the GUI of our app's main screen.
The GUI is essentially several Nodes placed into a VBox that spans the entire window. Once built, it is returned to Main as a Region.

-- WeatherModel:
WeatherModel contains Properties of the data we're using for the GUI. Right now, that is just a single city's name and its current temperature.


===== "Code Implementation" requirements =====
The classes that satisfy these requirements can be found in the project's src folder (WeatherApp/src/main/java/weathergroup/weatherapp)
At the moment these classes are not being used. Everything is currently hard-coded into the GUI code itself.


===== How to run the application =====
This project is meant to be used with IntelliJ and uses Gradle.
Extract the zip folder to a location.
Open IntelliJ.
Go to File > Open and select the WeatherApp folder from the location you extracted it to.
Run Main.java