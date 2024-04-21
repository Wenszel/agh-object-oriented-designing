package pl.edu.agh.dronka.shop.model.entity;

import pl.edu.agh.dronka.shop.model.BooleanProperty;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

import java.util.EnumSet;

public class SportItem extends Item {
    public SportItem() {

    }

    public SportItem(String name, Category category, int price, int quantity, boolean secondhand, boolean polish) {
        super(name, category, price, quantity, polish, secondhand);
    }

    public void setBoolean(BooleanProperty booleanProperty, boolean value) {
        super.setBoolean(booleanProperty, value);
    }
    public boolean booleanEquals(Item item) {
        return super.booleanEquals(item);
    }

    public static EnumSet<BooleanProperty> getBooleanProperties() {
        return Item.getBooleanProperties();
    }
}
