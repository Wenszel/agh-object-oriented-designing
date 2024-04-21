package pl.edu.agh.dronka.shop.model.entity;

import pl.edu.agh.dronka.shop.model.BooleanProperty;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class BookItem extends Item {
    private int numberOfPages;
    private boolean hardcover;

    public BookItem() {

    }

    public BookItem(String name, Category category, int price, int quantity, boolean secondhand, boolean polish, int numberOfPages, boolean hardcover) {
        super(name, category, price, quantity, polish, secondhand);
        this.numberOfPages = numberOfPages;
        this.hardcover = hardcover;
    }

    public BookItem(Item item, int numberOfPages, boolean hardcover) {
        super(item.getName(), item.getCategory(), item.getPrice(), item.getQuantity(), item.isPolish(), item.isSecondhand());
        this.numberOfPages = numberOfPages;
        this.hardcover = hardcover;
    }

    public static List<String> getBooleansNames() {
        List<String> booleansNames = Item.getBooleansNames();
        booleansNames.add("Hardcover");
        return booleansNames;
    }

    public static EnumSet<BooleanProperty> getBooleanProperties() {
        EnumSet<BooleanProperty> booleanProperties = Item.getBooleanProperties();
        booleanProperties.add(BooleanProperty.HARDCOVER);
        return booleanProperties;
    }

    public void setBoolean(BooleanProperty booleanProperty, boolean value) {
        switch (booleanProperty) {
            case HARDCOVER:
                this.hardcover = value;
                break;
            default:
                super.setBoolean(booleanProperty, value);
        }
    }

    public Map<String, Object> getProperties() {
        Map<String, Object> propertiesMap = super.getProperties();
        propertiesMap.put("numberOfPages", String.valueOf(numberOfPages));
        propertiesMap.put("hardcover", String.valueOf(hardcover));
        return propertiesMap;
    }

    public boolean booleanEquals(Item item) {
        if (!super.booleanEquals(item)) {
            return false;
        }
        if (!(item instanceof BookItem otherBook)) {
            return false;
        }
        return this.hardcover == otherBook.hardcover || !this.hardcover;
    }

}
