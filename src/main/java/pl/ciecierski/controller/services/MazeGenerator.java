package pl.ciecierski.controller.services;

import pl.ciecierski.model.MazeComponents;
import pl.ciecierski.model.MazeModel;

import java.time.Instant;

import static pl.ciecierski.Main.*;
import static pl.ciecierski.controller.services.Passability.isPassing;
import static pl.ciecierski.model.MazeComponents.*;


/*
generuje labirynt przy niewielkich rozmiarach
labirynt wytworzony losowo, nasgępnie sprawdzana jest jego przechodniość
stosować dl laniryntów do rozmiaru odbwodu prostokąta ok 300 np. weight=40 height=110
 */
public class MazeGenerator {


    public void printMaze(MazeModel mazeModel) {

        MazeComponents[][] shape = mazeModel.getMaze();
        System.out.print("The maze is from MazeGenerator..");

        for (int h = 0; h < height; h++) {
            System.out.println();
            for (int w = 0; w < weight; w++) {

                switch (shape[h][w]) {
                    case WALL -> System.out.print((char) 9608);
                    case EMPTY -> System.out.print(' ');
                    case ITEM1 -> System.out.print('*');
                    case ITEM2 -> System.out.print('+');
                    case ITEM3 -> System.out.print('#');
                    case ITEM4 -> System.out.print('@');
                }
            }

        }

    }


    public MazeModel makeMaze(MazeModel mazeModel) {
        System.out.println(" ");
        System.out.println("\nLevel "+level+ " maze is generated.. "+"h="+height+" w="+weight+" quantity="+quantity);
        MazeComponents[][] shape = mazeModel.getMaze();
        long licznik = 0L;
        Instant instant = Instant.now();

        System.out.println("Starts at " + instant);
        do {

            Thread threadDolnaKrawedz = new Thread(() -> {

                //dolna krawedz
                for (int i = 0; i < weight; i++) {
                    //entrance
                    if (i != 5) {
                        shape[height - 1][i] = WALL;

                    } else {
                        shape[height - 1][i] = EMPTY;
                    }
                }

            });

            Thread threadGornaKrawedz = new Thread(() -> {

                //gorna krawedz
                for (int i = 0; i < weight; i++) {
                    if (i != weight - 5) {
                        shape[0][i] = WALL;

                    } else {
                        shape[0][i] = EMPTY;

                    }
                }

            });

            threadDolnaKrawedz.start();
            threadGornaKrawedz.start();


            for (int j = 1; j < height - 1; j++) {

                for (int i = 0; i < weight; i++) {

                    if (Math.random() >= level.getLevel()) {
                        shape[j][i] = EMPTY;

                        if (Math.random() <= 0.01) {
                            shape[j][i] = ITEM2;
                        } else {
                            shape[j][i] = EMPTY;
                        }
                    } else {
                        shape[j][i] = WALL;
                    }

//                    boczne ściany
                    if (i == 0 || i == weight - 1) {
                        shape[j][i] = WALL;
                    }
                }
            }

            licznik++;

        } while (!isPassing(mazeModel));

        mazeModel.setMaze(shape);
        System.out.println("Number of refused mazes: " + (licznik-1));
        Instant instant1 = Instant.now();
        System.out.println("Ends at " + instant1);
        System.out.println("Maze generated in " + (instant1.toEpochMilli() - instant.toEpochMilli()) + " ms");
        System.gc();
        System.out.println("Garbage collector activated");

        return mazeModel;

    }

}
