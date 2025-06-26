package pl.ciecierski.controller;

import pl.ciecierski.controller.services.FileServices;
import pl.ciecierski.controller.services.MazeGenerator;
import pl.ciecierski.model.MazeComponents;
import pl.ciecierski.model.MazeModel;

import java.io.*;
import java.time.Instant;
import java.util.Calendar;

import static pl.ciecierski.Main.quantity;



public class ControllerFile implements ControllerInterface {

    public ControllerFile(MazeModel mazeModel) {
        this.mazeModel = mazeModel;
    }

    MazeModel mazeModel;
    MazeGenerator mazeGenerator = new MazeGenerator();
    FileServices fileServices = new FileServices();

    @Override
    public void act(MazeModel mazeModel) {
        System.out.println("ControllerFile");

        String fileName = "";
// tworzy nowy labirynt i serializuje do pliku
        for (int i = 0; i < quantity; i++) {
            Instant instant=Instant.now();
            instant.toEpochMilli();
//            nazwa pliku powinna zawierać dodatkowo rozmiar labiryntu i level
            fileName ="f:" +i+"maze"+instant.toString().substring(20)+".txt";
            fileServices.serializeMaze(mazeGenerator.makeMaze(mazeModel), fileName);
//        deserializuje z pliku i pokazuje na ekranie
            mazeGenerator.printMaze(fileServices.deserializeMaze(fileName));
        }

    }

}
