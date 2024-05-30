package pl.agh.edu.dp.labirynth.factory;

import pl.agh.edu.dp.labirynth.maze.enchanted.EnchantedRoom;
import pl.agh.edu.dp.labirynth.maze.enchanted.EnchantedWall;

public class EnchantedMazeFactory extends MazeFactory{
    @Override
    public EnchantedWall createWall() {
        return new EnchantedWall();
    }

    @Override
    public EnchantedRoom createRoom(int number) {
        return new EnchantedRoom(number);
    }
}
