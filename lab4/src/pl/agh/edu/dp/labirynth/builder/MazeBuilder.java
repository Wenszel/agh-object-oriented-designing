package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.maze.standard.Maze;
import pl.agh.edu.dp.labirynth.maze.standard.Room;
import pl.agh.edu.dp.labirynth.maze.standard.Wall;

public interface MazeBuilder {
    Maze build();
    MazeBuilder setCommonWallDirection(Direction direction);
    MazeBuilder addRoom(Room room);
    MazeBuilder addWall(Room room, Wall wall, Direction direction);
    MazeBuilder addDoor(Room room1, Room room2, Direction direction);
}