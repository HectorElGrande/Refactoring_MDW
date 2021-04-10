package usantatecla.movies.v26;

import org.junit.Before;
import org.junit.Test;
import usantatecla.movies.v24.StatementBuilder;

import static org.junit.Assert.assertEquals;

public class CustomerWithoutRentalTest {

    final String customerName = "customerName";

    private String statement;

    @Before
    public void before() {
        Customer customer = new CustomerBuilder().name(this.customerName).build();
        this.statement = customer.statement();
    }

    @Test
    public void withoutRentalsTest() {
        String result = new StatementBuilder().customerName(this.customerName)
                .totalAmount(0).frequentRenterPoints(0).build();

        assertEquals(result, this.statement);
    }

    @Test
    public void withoutRentalsCustomerNameTest() {
        String customerName = new StatementDeserializer(this.statement).getCustomerName();

        assertEquals(this.customerName, customerName);
    }

    @Test
    public void withoutRentalsTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.statement).getTotalAmount();

        assertEquals("0.0", totalAmount);
    }

    @Test
    public void withoutRentalsFrequentRenterPointsTest() {
        String frequentRenterPoints = new StatementDeserializer(this.statement).getFrequentRenterPoints();

        assertEquals("0", frequentRenterPoints);
    }

}
