package warehouse;

import java.util.ArrayList;
import java.util.List;

public class Category implements Component {
    private String name;
    private final List<Component> components;

    public Category(String name) {
        this.name = name;
        components = new ArrayList<>();
    }

    public void addComponent(Component component) {
        components.add(component);
    }

    public void removeComponent(Component component) {
        components.remove(component);
    }

    @Override
    public void print(int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println("Category: " + name);
        components.forEach(c -> c.print(level + 1));
    }
}
