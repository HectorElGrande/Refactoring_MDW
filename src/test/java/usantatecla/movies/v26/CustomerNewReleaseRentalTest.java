package usantatecla.movies.v26;

import org.junit.Before;
import org.junit.Test;
import usantatecla.movies.v24.StatementBuilder;

import static org.junit.Assert.assertEquals;

public class CustomerNewReleaseRentalTest {

    final String customerName = "customerName";
    final String movieName = "movieName";

    private String oneDayStatement;
    private String twoDaysStatement;
    private String threeDaysStatement;

    @Before
    public void before() {
        Movie newReleaseMovie = new NewReleaseMovie(movieName);

        Rental oneDayRental = new RentalBuilder().movie(newReleaseMovie).daysRented(1).build();
        Customer oneDayCustomer = new CustomerBuilder().name(customerName).rental(oneDayRental).build();
        this.oneDayStatement = oneDayCustomer.statement();

        Rental twoDaysRental = new RentalBuilder().movie(newReleaseMovie).daysRented(2).build();
        Customer twoDaysCustomer = new CustomerBuilder().name(customerName).rental(twoDaysRental).build();
        this.twoDaysStatement = twoDaysCustomer.statement();

        Rental threeDaysRental = new RentalBuilder().movie(newReleaseMovie).daysRented(3).build();
        Customer threeDaysCustomer = new CustomerBuilder().name(customerName).rental(threeDaysRental).build();
        this.threeDaysStatement = threeDaysCustomer.statement();
    }

    @Test
    public void newReleaseRental1DayTest() {
        String result = new usantatecla.movies.v24.StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(1).build();

        assertEquals(result, this.oneDayStatement);
    }

    @Test
    public void newReleaseRental1DayTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.oneDayStatement).getTotalAmount();

        assertEquals("3.0", totalAmount);
    }

    @Test
    public void newReleaseRental1DayFrequentRenterPointsTest() {
        String frequentRenterPoints = new StatementDeserializer(this.oneDayStatement).getFrequentRenterPoints();

        assertEquals("1", frequentRenterPoints);
    }

    @Test
    public void newReleaseRental2DayTest() {
        String result = new usantatecla.movies.v24.StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(2).build();

        assertEquals(result, this.twoDaysStatement);
    }

    @Test
    public void newReleaseRental2DayFrequentRenterPointsTest() {
        String frequentRenterPoints = new StatementDeserializer(this.twoDaysStatement).getFrequentRenterPoints();

        assertEquals("2", frequentRenterPoints);
    }

    @Test
    public void newReleaseRental3DayTest() {
        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(2).build();

        assertEquals(result, this.threeDaysStatement);
    }

    @Test
    public void newReleaseRental3DayFrequentRenterPointsTest() {
        String frequentRenterPoints = new StatementDeserializer(this.threeDaysStatement).getFrequentRenterPoints();

        assertEquals("2", frequentRenterPoints);
    }

}
