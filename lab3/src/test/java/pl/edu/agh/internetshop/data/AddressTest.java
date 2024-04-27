package pl.edu.agh.internetshop.data;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.data.Address;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {
    
    @Test
    public void testCreation() {
    	String name = "Adam Smith";
        String streetAndHomeNr = "1234 Main Street";
        String postalCode = "01003";
        String city = "New York";
        
        Address address = new Address(name, streetAndHomeNr, postalCode, city);

        assertEquals(name, address.getName());
        assertEquals(streetAndHomeNr, address.getStreetAndHomeNr());
        assertEquals(postalCode, address.getPostalCode());
        assertEquals(city, address.getCity());
    }
}