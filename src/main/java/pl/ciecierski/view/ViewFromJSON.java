package pl.ciecierski.view;

import pl.ciecierski.Main;
import pl.ciecierski.controller.ControllerFile;
import pl.ciecierski.controller.ControllerJSON;
import pl.ciecierski.model.MazeComponents;
import pl.ciecierski.model.MazeModel;

public class ViewFromJSON implements ViewInterface{
    @Override
    public void show() {

        MazeModel mazeModel = new MazeModel(
                new MazeComponents[Main.height][Main.weight]);

        ControllerJSON controllerJSON =new ControllerJSON(mazeModel);
        controllerJSON.act(mazeModel);

    }
}
