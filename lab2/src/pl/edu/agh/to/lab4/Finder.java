package pl.edu.agh.to.lab4;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Finder {
    private final Collection<Person> allPersons;

    private final Map<String, Collection<Prisoner>> allPrisoners;

    public Finder(Collection<Person> allPersons, Map<String, Collection<Prisoner>> allPrisoners) {
        this.allPersons = allPersons;
        this.allPrisoners = allPrisoners;
    }

    public Finder(PersonDataProvider personDataProvider, PrisonersDatabase prisonersDatabase) {
        this(personDataProvider.getAllCracovCitizens(), prisonersDatabase.findAll());
    }

    public void displayAllSuspectsWithName(String name, int limit) {
        Collection<Suspect> suspects =
            Stream.concat(getFilteredPrisoners(name), getFilteredPersons(name))
                    .limit(limit)
                    .collect(Collectors.toList());
        System.out.println("I have found " + suspects.size() + " suspects:");
        suspects.forEach((s)-> System.out.println(s.display()));
    }

    private Stream<Prisoner> getFilteredPrisoners(String searchedName) {
        return allPrisoners
                    .values()
                    .stream()
                    .flatMap(Collection::stream)
                    .filter(prisoner -> prisoner.getName().equals(searchedName) && !prisoner.isInJail());
    }

    private Stream<Person> getFilteredPersons(String searchedName) {
        return allPersons
                    .stream()
                    .filter(person -> person.getName().equals(searchedName) && person.getAge() > 18);
    }
}
