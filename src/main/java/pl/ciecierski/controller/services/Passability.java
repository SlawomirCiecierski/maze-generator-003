package pl.ciecierski.controller.services;

import pl.ciecierski.Main;
import pl.ciecierski.model.Azimuth;
import pl.ciecierski.model.Coordinates;
import pl.ciecierski.model.MazeComponents;
import pl.ciecierski.model.MazeModel;

import static pl.ciecierski.model.Azimuth.*;


public class Passability {

    static boolean isPassing(MazeModel mazeModel) {
        final Coordinates initialCoordinates = new Coordinates(Main.height - 1, 5, Azimuth.NORTH);
        final Coordinates finalCoordinates = new Coordinates(0, Main.weight - 5, Azimuth.NORTH);
        final Coordinates failCoordinates = new Coordinates(Main.height - 1, 5, Azimuth.SOUTH);

        Coordinates currentCoordinates = initialCoordinates;

        currentCoordinates = singleStep(mazeModel, initialCoordinates);

        do {
            if (currentCoordinates.getH() == finalCoordinates.getH() &&
                    currentCoordinates.getW() == finalCoordinates.getW() &&
                    currentCoordinates.getAzimuth() == finalCoordinates.getAzimuth()) {
                return true;
            }
            if (currentCoordinates.getH() == failCoordinates.getH() &&
                    currentCoordinates.getW() == failCoordinates.getW() &&
                    currentCoordinates.getAzimuth() == failCoordinates.getAzimuth()) {
                return false;
            }
            currentCoordinates = singleStep(mazeModel, currentCoordinates);
        } while (currentCoordinates != finalCoordinates || currentCoordinates != failCoordinates);
        return true;
    }


    private static Coordinates singleStep(MazeModel mazeModel, Coordinates coordinates) {

        if (rightHandTouchWall(mazeModel, coordinates)) {
            if (straightAheadIsFree(mazeModel, coordinates)) {
                coordinates = goOneStepForward(mazeModel, coordinates);
                return coordinates;
            } else {
                coordinates = turnLeft(mazeModel, coordinates);
                return coordinates;
            }
        } else {
            coordinates = turnRight(mazeModel, coordinates);
            coordinates = goOneStepForward(mazeModel, coordinates);
            return coordinates;
        }
    }


    private static boolean rightHandTouchWall(MazeModel mazeModel, Coordinates coordinates) {
        MazeComponents[][] shape = mazeModel.getMaze();
        switch (coordinates.getAzimuth()) {
            case NORTH -> {
                return shape[coordinates.getH()][coordinates.getW() + 1] == MazeComponents.WALL;
            }
            case EAST -> {

                return shape[coordinates.getH() + 1][coordinates.getW()] == MazeComponents.WALL;
            }
            case SOUTH -> {
                return shape[coordinates.getH()][coordinates.getW() - 1] == MazeComponents.WALL;
            }
            case WEST -> {
                return shape[coordinates.getH() - 1][coordinates.getW()] == MazeComponents.WALL;
            }
            default -> {
                return true;
            }
        }
    }

    private static boolean straightAheadIsFree(MazeModel mazeModel, Coordinates coordinates) {

        MazeComponents[][] shape = mazeModel.getMaze();

        switch (coordinates.getAzimuth()) {
            case NORTH -> {
                return shape[coordinates.getH() - 1][coordinates.getW()] == MazeComponents.EMPTY;
            }
            case EAST -> {

                return shape[coordinates.getH()][coordinates.getW() + 1] == MazeComponents.EMPTY;
            }
            case SOUTH -> {

                return shape[coordinates.getH() + 1][coordinates.getW()] == MazeComponents.EMPTY;
            }
            case WEST -> {

                return shape[coordinates.getH()][coordinates.getW() - 1] == MazeComponents.EMPTY;
            }
            default -> {
            }
        }
        return false;
    }


    private static Coordinates turnLeft(MazeModel mazeModel, Coordinates coordinates) {

        MazeComponents[][] shape = mazeModel.getMaze();
        Coordinates newCoordinates = coordinates;

        switch (coordinates.getAzimuth()) {
            case NORTH -> newCoordinates.setAzimuth(WEST);
            case EAST -> newCoordinates.setAzimuth(NORTH);
            case SOUTH -> newCoordinates.setAzimuth(EAST);
            case WEST -> newCoordinates.setAzimuth(SOUTH);
            default -> {
                return newCoordinates;
            }
        }

        return newCoordinates;
    }

    private static Coordinates turnRight(MazeModel mazeModel, Coordinates coordinates) {


        MazeComponents[][] shape = mazeModel.getMaze();
        Coordinates newCoordinates = coordinates;

        switch (coordinates.getAzimuth()) {
            case NORTH -> newCoordinates.setAzimuth(EAST);
            case EAST -> newCoordinates.setAzimuth(SOUTH);
            case SOUTH -> newCoordinates.setAzimuth(WEST);
            case WEST -> newCoordinates.setAzimuth(NORTH);
            default -> {

            }
        }

        return newCoordinates;
    }


    private static Coordinates goOneStepForward(MazeModel mazeModel, Coordinates coordinates) {

        MazeComponents[][] shape = mazeModel.getMaze();
        Coordinates newCoordinates = coordinates;

        switch (coordinates.getAzimuth()) {
            case NORTH -> newCoordinates.setH(coordinates.getH() - 1);
            case EAST -> newCoordinates.setW(coordinates.getW() + 1);
            case SOUTH -> newCoordinates.setH(coordinates.getH() + 1);
            case WEST -> newCoordinates.setW(coordinates.getW() - 1);
            default -> {

            }
        }

        return newCoordinates;

    }


}
