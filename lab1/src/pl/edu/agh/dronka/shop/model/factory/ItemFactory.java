package pl.edu.agh.dronka.shop.model.factory;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.entity.*;

import java.time.LocalDate;
import java.util.Map;

public class ItemFactory {
    public static Item createItem(Category category, Map<String, String> properties) {
        return switch (category) {
            case BOOKS -> new BookItem(
                    properties.get("Nazwa"),
                    category,
                    Integer.parseInt(properties.get("Cena")),
                    Integer.parseInt(properties.get("Ilość")),
                    Boolean.parseBoolean(properties.get("Używany")),
                    Boolean.parseBoolean(properties.get("Tanie bo polskie")),
                    Integer.parseInt(properties.get("Liczba stron")),
                    Boolean.parseBoolean(properties.get("Twarda oprawa"))
            );
            case ELECTRONICS -> new ElectronicsItem( properties.get("Nazwa"),
                    category,
                    Integer.parseInt(properties.get("Cena")),
                    Integer.parseInt(properties.get("Ilość")),
                    Boolean.parseBoolean(properties.get("Używany")),
                    Boolean.parseBoolean(properties.get("Tanie bo polskie")), Boolean.parseBoolean(properties.get("Mobile")));
            case FOOD -> new FoodItem(properties.get("Nazwa"),
                    category,
                    Integer.parseInt(properties.get("Cena")),
                    Integer.parseInt(properties.get("Ilość")),
                    Boolean.parseBoolean(properties.get("Używany")),
                    Boolean.parseBoolean(properties.get("Tanie bo polskie")), LocalDate.parse(properties.get("Data przydatności do spożycia")));
            case MUSIC -> new MusicItem(properties.get("Nazwa"),
                    category,
                    Integer.parseInt(properties.get("Cena")),
                    Integer.parseInt(properties.get("Ilość")),
                    Boolean.parseBoolean(properties.get("Używany")),
                    Boolean.parseBoolean(properties.get("Tanie bo polskie")),
                    properties.get("Gatunek muzyczny"),
                    Boolean.parseBoolean(properties.get("Dołączone video")));
            case SPORT -> new SportItem(properties.get("Nazwa"),
                    category,
                    Integer.parseInt(properties.get("Cena")),
                    Integer.parseInt(properties.get("Ilość")),
                    Boolean.parseBoolean(properties.get("Używany")),
                    Boolean.parseBoolean(properties.get("Tanie bo polskie")));
        };
    }
    public static Item createItem(Category category) {
        if (category == null) {
            return null;
        }
        return switch (category) {
            case BOOKS -> new BookItem();
            case ELECTRONICS -> new ElectronicsItem();
            case FOOD -> new FoodItem();
            case MUSIC -> new MusicItem();
            case SPORT -> new SportItem();
        };
    }
}
