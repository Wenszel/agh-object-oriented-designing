package pl.edu.agh.internetshop.shipment;


public interface SurfaceMailBus extends ShipmentMethod {
    boolean isSent(Object shipment);
}
