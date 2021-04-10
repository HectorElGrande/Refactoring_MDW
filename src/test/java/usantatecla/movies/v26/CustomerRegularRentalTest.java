package usantatecla.movies.v26;

import org.junit.Before;
import org.junit.Test;
import usantatecla.movies.v24.StatementBuilder;

import static org.junit.Assert.assertEquals;

public class CustomerRegularRentalTest {

    final String customerName = "customerName";
    final String movieName = "movieName";

    private String oneDayStatement;
    private String twoDaysStatement;
    private String threeDaysStatement;

    @Before
    public void before() {
        Movie regularMovie = new RegularMovie(this.movieName);

        Rental oneDayRental = new RentalBuilder().movie(regularMovie).daysRented(1).build();
        Customer oneDayCustomer = new CustomerBuilder().name(this.customerName).rental(oneDayRental).build();
        this.oneDayStatement = oneDayCustomer.statement();

        Rental twoDaysRental = new RentalBuilder().movie(regularMovie).daysRented(2).build();
        Customer twoDaysCustomer = new CustomerBuilder().name(this.customerName).rental(twoDaysRental).build();
        this.twoDaysStatement = twoDaysCustomer.statement();

        Rental threeDaysRental = new RentalBuilder().movie(regularMovie).daysRented(3).build();
        Customer threeDaysCustomer = new CustomerBuilder().name(customerName).rental(threeDaysRental).build();
        this.threeDaysStatement = threeDaysCustomer.statement();
    }

    @Test
    public void regularRental1DayTest() {
        String result = new usantatecla.movies.v24.StatementBuilder().customerName(customerName).movie(movieName, 2)
                .totalAmount(2).frequentRenterPoints(1).build();

        assertEquals(result, this.oneDayStatement);
    }

    @Test
    public void regularRental1DayMovieNameAndMovieChargeTest() {
        String movieName = new StatementDeserializer(this.oneDayStatement).getMovies();

        assertEquals(this.movieName + "2.0", movieName);
    }

    @Test
    public void regularRental1DayTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.oneDayStatement).getTotalAmount();

        assertEquals("2.0", totalAmount);
    }

    @Test
    public void regularRental1DayFrequentRenterPointsTest() {
        String frequentRenterPoints = new StatementDeserializer(this.oneDayStatement).getFrequentRenterPoints();

        assertEquals("1", frequentRenterPoints);
    }

    @Test
    public void regularRental2DayTest() {
        String result = new usantatecla.movies.v24.StatementBuilder().customerName(customerName).movie(movieName, 2)
                .totalAmount(2).frequentRenterPoints(1).build();
        assertEquals(result, this.twoDaysStatement);
    }

    @Test
    public void regularRental2DayMovieNameAndMovieChargeTest() {
        String movieName = new StatementDeserializer(this.twoDaysStatement).getMovies();

        assertEquals(this.movieName + "2.0", movieName);
    }

    @Test
    public void regularRental2DayTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.twoDaysStatement).getTotalAmount();

        assertEquals("2.0", totalAmount);
    }

    @Test
    public void regularRental3DayTest() {
        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3.5)
                .totalAmount(3.5).frequentRenterPoints(1).build();

        assertEquals(result, this.threeDaysStatement);
    }

    @Test
    public void regularRental3DayMovieNameAndMovieChargeTest() {
        String movieName = new StatementDeserializer(this.threeDaysStatement).getMovies();

        assertEquals(this.movieName + "3.5", movieName);
    }

    @Test
    public void regularRental3DayTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.threeDaysStatement).getTotalAmount();

        assertEquals("3.5", totalAmount);
    }

}
