package pl.edu.agh.dronka.shop.model.entity;

import pl.edu.agh.dronka.shop.model.BooleanProperty;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

import java.util.EnumSet;
import java.util.Map;

public class MusicItem extends Item {
    private String genre;
    private boolean video;
    public MusicItem() {

    }

    public MusicItem(String name, Category category, int price, int quantity, boolean secondhand, boolean polish, String genre, boolean video) {
        super(name, category, price, quantity, polish, secondhand);
        this.genre = genre;
        this.video = video;
    }

    public MusicItem(Item item, String genre, boolean video) {
        super(item.getName(), item.getCategory(), item.getPrice(), item.getQuantity(), item.isPolish(), item.isSecondhand());
        this.genre = genre;
        this.video = video;
    }

    public Map<String, Object> getProperties() {
        Map<String, Object> propertiesMap = super.getProperties();
        propertiesMap.put("genre", genre);
        propertiesMap.put("video", video);
        return propertiesMap;
    }

    public static EnumSet<BooleanProperty> getBooleanProperties() {
        EnumSet<BooleanProperty> booleanProperties = Item.getBooleanProperties();
        booleanProperties.add(BooleanProperty.VIDEO);
        return booleanProperties;
    }
    public void setBoolean(BooleanProperty booleanProperty, boolean value) {
        switch (booleanProperty) {
            case VIDEO:
                this.video = value;
                break;
            default:
                super.setBoolean(booleanProperty, value);
        }
    }


    public boolean booleanEquals(Item item) {
        if (!super.booleanEquals(item)) {
            return false;
        }
        if (!(item instanceof MusicItem otherMusic)) {
            return false;
        }
        return this.video == otherMusic.video || !this.video;
    }
}
