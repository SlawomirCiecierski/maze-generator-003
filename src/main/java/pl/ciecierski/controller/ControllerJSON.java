package pl.ciecierski.controller;

import pl.ciecierski.controller.services.FileServices;
import pl.ciecierski.controller.services.JSONFileServices;
import pl.ciecierski.controller.services.MazeGenerator;
import pl.ciecierski.model.MazeModel;

import java.time.Instant;

import static pl.ciecierski.Main.*;

public class ControllerJSON implements ControllerInterface {

    MazeModel mazeModel;
    MazeGenerator mazeGenerator = new MazeGenerator();
    FileServices fileServices = new FileServices();
    JSONFileServices jsonFileServices = new JSONFileServices();

    public ControllerJSON(MazeModel mazeModel) {
        this.mazeModel = mazeModel;
    }

    @Override
    public void act(MazeModel mazeModel) {
        System.out.println("controllerJSON");

        String fileName = "";
        for (int i = 0; i < quantity; i++) {
            Instant instant=Instant.now();
            instant.toEpochMilli();
//            nazwa pliku JSON powinna zawierać dodatkowo rozmiar labiryntu i level
            fileName ="d:\\ciecierski\\projects\\maze-json\\" +level+"-"+i+"-maze-h"+height+"-w"+weight+"-"+instant.toString().substring(20)+".json";

            jsonFileServices.serializeJSONMaze((mazeGenerator.makeMaze(mazeModel)), fileName);

//        deserializuje z pliku JSON i pokazuje na ekranie

            mazeGenerator.printMaze(jsonFileServices.deserializeJSONMaze(fileName));

        }
    }
}
