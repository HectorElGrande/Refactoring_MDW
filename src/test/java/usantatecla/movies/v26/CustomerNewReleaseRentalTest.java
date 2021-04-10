package usantatecla.movies.v26;

import org.junit.Before;
import org.junit.Test;
import usantatecla.movies.v24.StatementBuilder;

import static org.junit.Assert.assertEquals;

public class CustomerNewReleaseRentalTest {

    final String customerName = "customerName";
    final String movieName = "movieName";

    private String statement4;
    private String statement5;
    private String statement6;

    @Before
    public void before() {
        Movie newReleaseMovie = new NewReleaseMovie(movieName);

        Rental rental4 = new RentalBuilder().movie(newReleaseMovie).daysRented(1).build();
        Customer customer4 = new CustomerBuilder().name(customerName).rental(rental4).build();
        this.statement4 = customer4.statement();

        Rental rental5 = new RentalBuilder().movie(newReleaseMovie).daysRented(2).build();
        Customer customer5 = new CustomerBuilder().name(customerName).rental(rental5).build();
        this.statement5 = customer5.statement();

        Rental rental6 = new RentalBuilder().movie(newReleaseMovie).daysRented(3).build();
        Customer customer6 = new CustomerBuilder().name(customerName).rental(rental6).build();
        this.statement6 = customer6.statement();
    }

    @Test
    public void newReleaseRental1DayTest() {
        String result = new usantatecla.movies.v24.StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(1).build();

        assertEquals(result, this.statement4);
    }

    @Test
    public void newReleaseRental1DayTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.statement4).getTotalAmount();

        assertEquals("3.0", totalAmount);
    }

    @Test
    public void newReleaseRental1DayFrequentRenterPointsTest() {
        String frequentRenterPoints = new StatementDeserializer(this.statement4).getFrequentRenterPoints();

        assertEquals("1", frequentRenterPoints);
    }

    @Test
    public void newReleaseRental2DayTest() {
        String result = new usantatecla.movies.v24.StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(2).build();

        assertEquals(result, this.statement5);
    }

    @Test
    public void newReleaseRental2DayFrequentRenterPointsTest() {
        String frequentRenterPoints = new StatementDeserializer(this.statement5).getFrequentRenterPoints();

        assertEquals("2", frequentRenterPoints);
    }

    @Test
    public void newReleaseRental3DayTest() {
        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
                .totalAmount(3).frequentRenterPoints(2).build();

        assertEquals(result, this.statement6);
    }

    @Test
    public void newReleaseRental3DayFrequentRenterPointsTest() {
        String frequentRenterPoints = new StatementDeserializer(this.statement6).getFrequentRenterPoints();

        assertEquals("2", frequentRenterPoints);
    }

}
