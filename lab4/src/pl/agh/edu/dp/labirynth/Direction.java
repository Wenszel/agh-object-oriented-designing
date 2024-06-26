package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;
    public Direction getOpposite() {
        return switch (this) {
            case North -> South;
            case South -> North;
            case East -> West;
            case West -> East;
        };
    }
}