package pl.edu.agh.dronka.shop.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import pl.edu.agh.dronka.shop.controller.ShopController;
import pl.edu.agh.dronka.shop.model.BooleanProperty;
import pl.edu.agh.dronka.shop.model.filter.ItemFilter;

public class PropertiesPanel extends JPanel {

	private static final long serialVersionUID = -2804446079853846996L;
	private ShopController shopController;

	private ItemFilter filter;

	public PropertiesPanel(ShopController shopController) {
		this.shopController = shopController;
		filter = new ItemFilter(shopController.getCurrentCategory());
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	}

	public void fillProperties() {
		removeAll();
		filter = new ItemFilter(shopController.getCurrentCategory());
		shopController.getCurrentCategory().getBooleanProperties().forEach((property) -> {
			add(createPropertyCheckbox(property, event -> {
                filter.setBoolean(property,
                        ((JCheckBox) event.getSource()).isSelected());
                shopController.filterItems(filter);
            }));
		});
	}

	private JCheckBox createPropertyCheckbox(BooleanProperty propertyName,
											 ActionListener actionListener) {

		JCheckBox checkBox = new JCheckBox(String.valueOf(propertyName));
		checkBox.setSelected(false);
		checkBox.addActionListener(actionListener);

		return checkBox;
	}

}
