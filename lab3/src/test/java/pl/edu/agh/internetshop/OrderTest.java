package pl.edu.agh.internetshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.data.User;
import pl.edu.agh.internetshop.payment.MoneyTransfer;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderTest {
    private Order order;
    private final OrderDetails orderDetails = mock(OrderDetails.class);
    private final ShipmentManager shipmentManager = mock(ShipmentManager.class);
    private final PaymentProcessor paymentProcessor = mock(PaymentProcessor.class);
    private final User user = mock(User.class);
    private static final BigDecimal TEST_PRICE = new BigDecimal("100.00");

    @BeforeEach
    public void setUp() {
        order = new Order();
        order.setOrderDetails(orderDetails);
        order.setShipmentManager(shipmentManager);
        order.setPaymentProcessor(paymentProcessor);
        order.setUser(user);
    }

    @Test
    public void testGetPrice_DelegatesToOrderDetailsAndReturnsCorrectValue() {
        when(orderDetails.getPrice()).thenReturn(TEST_PRICE);

        BigDecimal price = order.getPrice();

        assertEquals(TEST_PRICE, price);
        verify(orderDetails).getPrice();
    }

    @Test
    public void testGetPriceWithTaxes_DelegatesToOrderDetailsAndReturnsCorrectValue() {
        when(orderDetails.getPriceWithTaxes()).thenReturn(TEST_PRICE);

        BigDecimal price = order.getPriceWithTaxes();

        assertEquals(TEST_PRICE, price);
        verify(orderDetails).getPriceWithTaxes();
    }

    @Test
    public void testGetUserLastname_DelegatesToUserAndReturnsCorrectValue() {
        String LASTNAME = "Kowalski";
        when(user.getLastname()).thenReturn(LASTNAME);

        String lastname = order.getUserLastname();

        assertEquals(LASTNAME, lastname);
        verify(user).getLastname();
    }

    @Test
    public void testGetUserLastname_whenLastnameIsNull_ReturnsNull() {
        when(user.getLastname()).thenReturn(null);

        String lastname = order.getUserLastname();

        assertNull(lastname);
        verify(user).getLastname();
    }

    @Test
    public void testSend_DelegatesToShipmentManager() {
        order.send();

        verify(shipmentManager).send();
    }

    @Test
    public void testPay_DelegatesToPaymentProcessor() {
        MoneyTransfer moneyTransfer = mock(MoneyTransfer.class);
        order.pay(moneyTransfer);

        verify(paymentProcessor).processPayment(moneyTransfer);
    }

    @Test
    public void testContainsProductByName_DelegatesToOrderDetailsAndReturnsCorrectValue() {
        String NAME = "Bread";
        when(orderDetails.containsProductByName(NAME)).thenReturn(true);

        boolean containsProduct = order.containsProductByName(NAME);

        assertTrue(containsProduct);
        verify(orderDetails).containsProductByName(NAME);
    }

    @Test
    public void testIsSent_DelegatesToShipmentManagerAndReturnsCorrectValue() {
        when(shipmentManager.isSent()).thenReturn(true);

        boolean isSent = order.isSent();

        assertTrue(isSent);
        verify(shipmentManager).isSent();
    }
}