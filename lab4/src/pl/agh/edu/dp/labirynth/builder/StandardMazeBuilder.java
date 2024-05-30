package pl.agh.edu.dp.labirynth.builder;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.factory.MazeFactory;
import pl.agh.edu.dp.labirynth.maze.standard.Door;
import pl.agh.edu.dp.labirynth.maze.standard.Maze;
import pl.agh.edu.dp.labirynth.maze.standard.Room;
import pl.agh.edu.dp.labirynth.maze.standard.Wall;

public class StandardMazeBuilder implements MazeBuilder {
    private final Maze maze;
    private Direction commonWallDirection;

    public StandardMazeBuilder() {
        maze = new Maze();
    }

    @Override
    public Maze build() {
        return maze;
    }

    @Override
    public StandardMazeBuilder addRoom(Room room) {
        room.setSide(Direction.North, new Wall());
        room.setSide(Direction.East, new Wall());
        room.setSide(Direction.South, new Wall());
        room.setSide(Direction.West, new Wall());
        maze.addRoom(room);
        return this;
    }

    @Override
    public StandardMazeBuilder setCommonWallDirection(Direction direction) {
        commonWallDirection = direction;
        return this;
    }

    @Override
    public StandardMazeBuilder addWall(Room room, Wall wall, Direction direction) {
        room.setSide(direction, wall);
        return this;
    }

    @Override
    public StandardMazeBuilder addDoor(Room room1, Room room2, Direction direction) {
        Door door = new Door(room1, room2);
        room1.setSide(direction, door);
        room2.setSide(direction.getOpposite(), door);
        return this;
    }
}
