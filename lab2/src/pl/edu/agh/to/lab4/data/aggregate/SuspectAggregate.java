package pl.edu.agh.to.lab4.data.aggregate;

import pl.edu.agh.to.lab4.model.Suspect;

import java.util.Iterator;

public interface SuspectAggregate {
    Iterator<? extends Suspect> iterator();
}
