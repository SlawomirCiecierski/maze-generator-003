package pl.ciecierski.view;

import pl.ciecierski.Main;
import pl.ciecierski.controller.ControllerFile;

import pl.ciecierski.model.MazeComponents;
import pl.ciecierski.model.MazeModel;
/*
18.04.2022
kod wyjściowy
 */
public class ViewFromFile implements ViewInterface{
    @Override
    public void show() {
        MazeModel mazeModel = new MazeModel(
                new MazeComponents[Main.height][Main.weight]);

        ControllerFile controllerFile =new ControllerFile(mazeModel);
        controllerFile.act(mazeModel);

    }
}
