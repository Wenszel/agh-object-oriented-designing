package pl.edu.agh.dronka.shop.model.entity;

import pl.edu.agh.dronka.shop.model.BooleanProperty;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.Map;

public class FoodItem extends Item {
    private LocalDate expireDate;
    public FoodItem() {

    }
    public FoodItem(String name, Category category, int price, int quantity, boolean secondhand, boolean polish, LocalDate expireDate) {
        super(name, category, price, quantity, polish, secondhand);
        this.expireDate = expireDate;
    }

    public FoodItem(Item item, LocalDate expireDate) {
        super(item.getName(), item.getCategory(), item.getPrice(), item.getQuantity(), item.isPolish(), item.isSecondhand());
        this.expireDate = expireDate;
    }

    public Map<String, Object> getProperties() {
        Map<String, Object> propertiesMap = super.getProperties();
        propertiesMap.put("expireDate", String.valueOf(expireDate));
        return propertiesMap;
    }

    public static EnumSet<BooleanProperty> getBooleanProperties() {
        return Item.getBooleanProperties();
    }

    public void setBoolean(BooleanProperty booleanProperty, boolean value) {
        super.setBoolean(booleanProperty, value);
    }

}
