package pl.agh.edu.dp.labirynth.maze.standard;

import java.util.HashSet;
import java.util.Set;

public class Maze {
    private Set<Room> rooms;

    public Maze() {
        this.rooms = new HashSet<>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public int getRoomNumbers() {
        return rooms.size();
    }
}
