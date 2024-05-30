package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.builder.MazeBuilder;
import pl.agh.edu.dp.labirynth.builder.StandardMazeBuilder;
import pl.agh.edu.dp.labirynth.factory.BombedMazeFactory;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.maze.standard.Maze;
import pl.agh.edu.dp.labirynth.maze.standard.Room;

public class Main {

    public static void main(String[] args) {

        MazeGame mazeGame = new MazeGame();
        MazeFactory mazeFactory = BombedMazeFactory.init();

        MazeBuilder mazeBuilder = new StandardMazeBuilder();
        Room room1 = mazeFactory.createRoom(0);
        Room room2 = mazeFactory.createRoom(1);
        mazeBuilder.addRoom(room1);
        mazeBuilder.addRoom(room2);
        mazeBuilder.setCommonWallDirection(Direction.South);
        mazeBuilder.addWall(room1, Direction.West);
        mazeBuilder.addWall(room1, Direction.South);
        mazeBuilder.addDoor(room1, room2, Direction.East);
        Maze maze = mazeGame.createMaze();

        System.out.println(maze.getRoomNumbers());
    }
}