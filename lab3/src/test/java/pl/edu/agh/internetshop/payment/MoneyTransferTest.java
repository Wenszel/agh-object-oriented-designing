package pl.edu.agh.internetshop.payment;

import org.junit.jupiter.api.Test;
import pl.edu.agh.internetshop.payment.MoneyTransfer;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;


public class MoneyTransferTest {

	private static final BigInteger ACCOUNT_NUMBER = new BigInteger("27114020040000300201355387");
	private static final String OWNER_DETAILS = "example owner details";
	private static final String DESCRIPTION = "example description";
	private static final int AMOUNT = 5;
	
    @Test
    public void testCreation() {
    	MoneyTransfer moneyTransfer = new MoneyTransfer(ACCOUNT_NUMBER, OWNER_DETAILS, DESCRIPTION, AMOUNT);
        
    	assertEquals(ACCOUNT_NUMBER, moneyTransfer.getAccountNumber());
    	assertEquals(OWNER_DETAILS, moneyTransfer.getOwnerDetails());
    	assertEquals(DESCRIPTION, moneyTransfer.getDescription());
    	assertEquals(AMOUNT, moneyTransfer.getAmount());
    }

    @Test
    public void testCheckCommitFlagWithoutCommitting() {
    	MoneyTransfer moneyTransfer = new MoneyTransfer(ACCOUNT_NUMBER, OWNER_DETAILS, DESCRIPTION, AMOUNT);
    	
    	assertFalse(moneyTransfer.isCommitted());
    }
    
    @Test
    public void testCheckCommitFlagWithCommitting() {
    	MoneyTransfer moneyTransfer = new MoneyTransfer(ACCOUNT_NUMBER, OWNER_DETAILS, DESCRIPTION, AMOUNT);
    	
    	moneyTransfer.setCommitted(true);
    	
    	assertTrue(moneyTransfer.isCommitted());
    }
}