package pl.edu.agh.dronka.shop.model.entity;

import pl.edu.agh.dronka.shop.model.BooleanProperty;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public class ElectronicsItem extends Item {
    private boolean mobile;
    public ElectronicsItem() {

    }
    public ElectronicsItem(String name, Category category, int price, int quantity, boolean secondhand, boolean polish, boolean mobile) {
        super(name, category, price, quantity, polish, secondhand);
        this.mobile = mobile;
    }

    public ElectronicsItem(Item item, boolean mobile) {
        super(item.getName(), item.getCategory(), item.getPrice(), item.getQuantity(), item.isPolish(), item.isSecondhand());
        this.mobile = mobile;
    }

    public static EnumSet<BooleanProperty> getBooleanProperties() {
        EnumSet<BooleanProperty> booleanProperties = Item.getBooleanProperties();
        booleanProperties.add(BooleanProperty.MOBILE);
        return booleanProperties;
    }

    public Map<String, Object> getProperties() {
        Map<String, Object> propertiesMap = super.getProperties();
        propertiesMap.put("mobile", String.valueOf(mobile));
        return propertiesMap;
    }

    public void setBoolean(BooleanProperty booleanProperty, boolean value) {
        switch (booleanProperty) {
            case MOBILE:
                this.mobile = value;
                break;
            default:
                super.setBoolean(booleanProperty, value);
        }
    }

    public boolean booleanEquals(Item item) {
        if (!super.booleanEquals(item)) {
            return false;
        }
        if (!(item instanceof  ElectronicsItem otherElectronics)) {
            return false;
        }
        return this.mobile == otherElectronics.mobile || !this.mobile;
    }
}
