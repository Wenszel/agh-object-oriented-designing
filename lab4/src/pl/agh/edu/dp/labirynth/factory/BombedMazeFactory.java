package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.maze.bombed.BombedRoom;
import pl.agh.edu.dp.labirynth.maze.bombed.BombedWall;
import pl.agh.edu.dp.labirynth.maze.standard.Room;

public class BombedMazeFactory extends MazeFactory {
    public static synchronized MazeFactory init() {
        if (mazeFactory == null) {
            mazeFactory = new BombedMazeFactory();
        }
        return mazeFactory;
    }

    @Override
    public BombedWall createWall() {
        return new BombedWall();
    }

    @Override
    public Room createRoom(int number) {
        return new BombedRoom(number);
    }
}
