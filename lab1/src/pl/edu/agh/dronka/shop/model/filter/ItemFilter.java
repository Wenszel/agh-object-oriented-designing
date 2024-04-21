package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.BooleanProperty;
import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.entity.BookItem;
import pl.edu.agh.dronka.shop.model.factory.ItemFactory;

public class ItemFilter {
	private Item itemSpec;

	public ItemFilter(Category category) {
		itemSpec = ItemFactory.createItem(category);
	}

	public Item getItemSpec() {
		return itemSpec;
	}
	public boolean appliesTo(Item item) {
		if (itemSpec.getName() != null
				&& !itemSpec.getName().equals(item.getName())) {
			return false;
		}
		if (itemSpec.getCategory() != null
				&& !itemSpec.getCategory().equals(item.getCategory())) {
			return false;
		}
		return itemSpec.booleanEquals(item);
	}

	public void setBoolean(BooleanProperty property, boolean selected) {
		itemSpec.setBoolean(property, selected);
	}
}