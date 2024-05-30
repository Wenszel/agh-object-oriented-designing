package pl.agh.edu.dp.labirynth.builder;


import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.maze.standard.Room;

public class CountingMazeBuilder extends StandardMazeBuilder {
    private int count;

    @Override
    public StandardMazeBuilder addRoom(Room room) {
        count += 1;
        return super.addRoom(room);
    }

    @Override
    public StandardMazeBuilder addWall(Room room, Direction direction) {
        count += 1;
        return super.addWall(room, direction);
    }

    @Override
    public StandardMazeBuilder addDoor(Room room1, Room room2, Direction direction) {
        count += 1;
        return super.addDoor(room1, room2, direction);
    }

    public int getCount() {
        return count;
    }
}
