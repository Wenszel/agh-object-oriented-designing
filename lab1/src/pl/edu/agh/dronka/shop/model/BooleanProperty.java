package pl.edu.agh.dronka.shop.model;

public enum BooleanProperty {
    POLISH("Polski"),
    SECONDHAND("Używany"),
    MOBILE("Mobile"),
    HARDCOVER("Twarda oprawa"),
    ELECTRONIC("Elektroniczna"),
    VIDEO ("Wideo");

    private String displayName;

    BooleanProperty(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
