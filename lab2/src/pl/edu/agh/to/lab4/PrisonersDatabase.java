package pl.edu.agh.to.lab4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PrisonersDatabase {

  private final Map<String, Collection<Prisoner>> prisonWithPrisoners = new HashMap<String, Collection<Prisoner>>();

  public PrisonersDatabase() {
    addPrisoner("Wiezienie krakowskie", new Prisoner("Jan", "Kowalski", "87080452357", 2005, 7));
    addPrisoner("Wiezienie krakowskie", new Prisoner("Anita", "Wiercipieta", "84080452357", 2009, 3));
    addPrisoner("Wiezienie krakowskie", new Prisoner("Janusz", "Zlowieszczy", "92080445657", 2001, 10));
    addPrisoner("Wiezienie przedmiejskie", new Prisoner("Janusz", "Zamkniety", "802104543357", 2010, 5));
    addPrisoner("Wiezienie przedmiejskie", new Prisoner("Adam", "Future", "880216043357", 2020, 5));
    addPrisoner("Wiezienie przedmiejskie", new Prisoner("Zbigniew", "Nienajedzony", "90051452335", 2011, 1));
    addPrisoner("Wiezienie centralne", new Prisoner("Jan", "Przedziwny", "91103145223", 2009, 4));
    addPrisoner("Wiezienie centralne", new Prisoner("Janusz", "Podejrzany", "85121212456", 2012, 1));
  }

  public Map<String, Collection<Prisoner>> findAll() {
    return prisonWithPrisoners;
  }

  public Collection<String> getAllPrisons() {
    return prisonWithPrisoners.keySet();
  }

  public Collection<Prisoner> getAllPrisoners() {
    return prisonWithPrisoners.values().stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
  }

  private void addPrisoner(String category, Prisoner prisoner) {
    if (!prisonWithPrisoners.containsKey(category))
      prisonWithPrisoners.put(category, new ArrayList<>());
    prisonWithPrisoners.get(category).add(prisoner);
  }
}
