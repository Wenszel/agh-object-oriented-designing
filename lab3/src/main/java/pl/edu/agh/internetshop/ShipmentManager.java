package pl.edu.agh.internetshop;

import pl.edu.agh.internetshop.shipment.Shipment;
import pl.edu.agh.internetshop.shipment.ShipmentMethod;

public class ShipmentManager {
    private final Shipment shipment;
    private final ShipmentMethod shipmentMethod;

    public ShipmentManager(Shipment shipment, ShipmentMethod shipmentMethod) {
        this.shipment = shipment;
        this.shipmentMethod = shipmentMethod;
    }

    public void send() {
        boolean sentSuccessfully = shipmentMethod.send(shipment, shipment.getSenderAddress(), shipment.getRecipientAddress());
        shipment.setShipped(sentSuccessfully);
    }

    public boolean isSent() {
        return shipment != null && shipment.isShipped();
    }
}
