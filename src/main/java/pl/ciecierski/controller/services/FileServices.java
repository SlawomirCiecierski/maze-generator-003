package pl.ciecierski.controller.services;

import pl.ciecierski.model.MazeModel;

import java.io.*;

public class FileServices {

    MazeModel mazeModel;
    MazeGenerator mazeGenerator = new MazeGenerator();


    public void serializeMaze(MazeModel mazeModel, String fileName) {
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            fileOut = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fileOut);
            out.writeObject(mazeModel);
            out.close();
            fileOut.close();
            System.out.println("Obiekt zapisany do pliku");

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public MazeModel deserializeMaze(String fileName) {
        try {
            FileInputStream fileIn = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            MazeModel mazeModel = (MazeModel) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Obiekt wczytany z pliku");
            return mazeModel;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("nie znaleziono");
            e.printStackTrace();
            return null;
        }
    }


}
