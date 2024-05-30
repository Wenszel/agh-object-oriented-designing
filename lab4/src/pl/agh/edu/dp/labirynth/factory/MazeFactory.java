package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.builder.MazeBuilder;
import pl.agh.edu.dp.labirynth.maze.standard.Door;
import pl.agh.edu.dp.labirynth.maze.standard.Maze;
import pl.agh.edu.dp.labirynth.maze.standard.Room;
import pl.agh.edu.dp.labirynth.maze.standard.Wall;

public class MazeFactory {
    public static MazeFactory mazeFactory;

    protected MazeFactory() {}

    public static synchronized MazeFactory init() {
        if (mazeFactory == null) {
            mazeFactory = new MazeFactory();
        }
        return mazeFactory;
    }

    public Door createDoor(Room room1, Room room2) {
        return new Door(room1, room2);
    }

    public Wall createWall() {
        return new Wall();
    }

    public Room createRoom(int number) {
        return new Room(number);
    }

    public Maze createMaze(MazeBuilder mazeBuilder) {
        return mazeBuilder.build();
    }
}
