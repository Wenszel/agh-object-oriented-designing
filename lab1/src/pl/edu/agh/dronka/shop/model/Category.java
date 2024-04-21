package pl.edu.agh.dronka.shop.model;

import pl.edu.agh.dronka.shop.model.entity.*;

import java.util.EnumSet;
import java.util.List;

public enum Category {

	BOOKS("Książki"), ELECTRONICS("Elektronika"), FOOD("Żywność"), MUSIC("Muzyka"), SPORT("Sport");

	private String displayName;

	public String getDisplayName() {
		return displayName;
	}

	private Category(String displayName) {
		this.displayName = displayName;
	}


	public EnumSet<BooleanProperty> getBooleanProperties() {
		return switch (this) {
			case BOOKS -> BookItem.getBooleanProperties();
			case ELECTRONICS -> ElectronicsItem.getBooleanProperties();
			case FOOD -> FoodItem.getBooleanProperties();
			case MUSIC -> MusicItem.getBooleanProperties();
			case SPORT -> SportItem.getBooleanProperties();
		};
	}

//	public List<String> getBooleanProperties() {
//		return switch (this) {
//			case BOOKS -> BookItem.getBooleansNames();
//			case ELECTRONICS -> ElectronicsItem.getBooleansNames();
//			case FOOD -> FoodItem.getBooleansNames();
//			case MUSIC -> MusicItem.getBooleansNames();
//			case SPORT -> SportItem.getBooleansNames();
//		};
//	}
}
