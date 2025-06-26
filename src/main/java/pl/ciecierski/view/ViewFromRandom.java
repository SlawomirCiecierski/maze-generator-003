package pl.ciecierski.view;



import pl.ciecierski.Main;
import pl.ciecierski.controller.ControllerRandom;
import pl.ciecierski.model.MazeComponents;
import pl.ciecierski.model.MazeModel;

public class ViewFromRandom implements ViewInterface{



    @Override
    public void show() {

MazeModel mazeModel = new MazeModel(
        new MazeComponents[Main.height][Main.weight]);

        ControllerRandom controllerRandom =new ControllerRandom(mazeModel);
        controllerRandom.act(mazeModel);



    }
}
