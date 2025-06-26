package pl.ciecierski.model;

import com.fasterxml.jackson.core.JsonFactory;

import java.io.Serializable;
import java.util.Arrays;


import static pl.ciecierski.Main.height;
import static pl.ciecierski.Main.weight;




public class MazeModel  implements Serializable {

    public static  final long serialVersionUID = 19640519L;



    private  MazeComponents[][] maze= new MazeComponents[height][weight];

    public MazeModel(MazeComponents[][] maze) {

        this.maze = maze;
    }
    public MazeModel() {
    }

    public MazeComponents[][] getMaze() {
        return maze;
    }

    public void setMaze(MazeComponents[][] maze) {
        this.maze = maze;
    }


}
