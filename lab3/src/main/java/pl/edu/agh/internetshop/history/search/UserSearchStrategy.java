package pl.edu.agh.internetshop.history.search;

import pl.edu.agh.internetshop.Order;

public class UserSearchStrategy implements SearchStrategy{
    private final String lastname;

    public UserSearchStrategy(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean filter(Order order) {
        return order.getUserLastname().equals(lastname);
    }
}
