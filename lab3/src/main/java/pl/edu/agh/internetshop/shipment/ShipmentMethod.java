package pl.edu.agh.internetshop.shipment;


import pl.edu.agh.internetshop.data.Address;

public interface ShipmentMethod {
    boolean send(Object shipment, Address sender, Address recipient);
}
