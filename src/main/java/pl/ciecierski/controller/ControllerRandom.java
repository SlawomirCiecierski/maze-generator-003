package pl.ciecierski.controller;


import pl.ciecierski.controller.services.MazeGenerator;
import pl.ciecierski.model.MazeComponents;
import pl.ciecierski.model.MazeModel;

import static pl.ciecierski.Main.height;
import static pl.ciecierski.Main.weight;

import static pl.ciecierski.model.MazeComponents.*;


public class ControllerRandom implements ControllerInterface {

    public ControllerRandom(MazeModel mazeModel) {
        this.mazeModel = mazeModel;
    }

    MazeModel mazeModel;
    MazeGenerator mazeGenerator = new MazeGenerator();

    @Override
    public void act(MazeModel mazeModel) {

        System.out.println("ControllerRandom");

        mazeGenerator.printMaze(mazeGenerator.makeMaze(mazeModel));

    }

}
