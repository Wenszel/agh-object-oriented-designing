package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.builder.MazeBuilder;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.maze.standard.Door;
import pl.agh.edu.dp.labirynth.maze.standard.Maze;
import pl.agh.edu.dp.labirynth.maze.standard.Room;
import pl.agh.edu.dp.labirynth.maze.standard.Wall;

public class MazeGame {
    public Maze createMaze(){
        Maze maze = new Maze();

        Room r1 = new Room(1);
        Room r2 = new Room(2);

        Door door = new Door(r1, r2);

        maze.addRoom(r1);
        maze.addRoom(r2);

        r1.setSide(Direction.North, new Wall());
        r1.setSide(Direction.East, new Wall());
        r1.setSide(Direction.South, new Wall());
        r1.setSide(Direction.West, new Wall());

        r2.setSide(Direction.North, new Wall());
        r2.setSide(Direction.East, new Wall());
        r2.setSide(Direction.South, new Wall());
        r2.setSide(Direction.West, new Wall());

        return maze;
    }

    //Adding this method delegates responsibility of creating a new maze to MazeBuilder object
    public Maze createMaze(MazeBuilder builder) {
        return builder.build();
    }


}
