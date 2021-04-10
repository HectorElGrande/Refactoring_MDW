package usantatecla.movies.v26;

import org.junit.Before;
import org.junit.Test;
import usantatecla.movies.v24.StatementBuilder;

import static org.junit.Assert.assertEquals;

public class CustomerChildrenRentalTest {

    final String customerName = "customerName";
    final String movieName = "movieName";

    private String oneDayStatement;
    private String threeDaysStatement;
    private String fourDaysStatement;

    @Before
    public void before() {
        Movie childrenMovie = new ChildrenMovie(movieName);

        Rental oneDayRental = new RentalBuilder().movie(childrenMovie).daysRented(1).build();
        Customer oneDayCustomer = new CustomerBuilder().name(customerName).rental(oneDayRental).build();
        this.oneDayStatement = oneDayCustomer.statement();

        Rental threeDaysRental = new RentalBuilder().movie(childrenMovie).daysRented(3).build();
        Customer threeDaysCustomer = new CustomerBuilder().name(customerName).rental(threeDaysRental).build();
        this.threeDaysStatement = threeDaysCustomer.statement();

        Rental fourDaysRental = new RentalBuilder().movie(childrenMovie).daysRented(4).build();
        Customer fourDaysCustomer = new CustomerBuilder().name(customerName).rental(fourDaysRental).build();
        this.fourDaysStatement = fourDaysCustomer.statement();
    }

    @Test
    public void childrenRental1DayTest() {
        String result = new usantatecla.movies.v24.StatementBuilder().customerName(customerName).movie(movieName, 1.5)
                .totalAmount(1.5).frequentRenterPoints(1).build();

        assertEquals(result, this.oneDayStatement);
    }

    @Test
    public void childrenRental1DayMovieNameAndMovieChargeTest() {
        String movieName = new StatementDeserializer(this.oneDayStatement).getMovies();

        assertEquals(this.movieName + "1.5", movieName);
    }

    @Test
    public void childrenRental1DayTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.oneDayStatement).getTotalAmount();

        assertEquals("1.5", totalAmount);
    }

    @Test
    public void childrenRental1DayFrequentRenterPointsTest() {
        String frequentRenterPoints = new StatementDeserializer(this.oneDayStatement).getFrequentRenterPoints();

        assertEquals("1", frequentRenterPoints);
    }

    @Test
    public void childrenRental3DayTest() {
        String result = new usantatecla.movies.v24.StatementBuilder().customerName(customerName).movie(movieName, 1.5)
                .totalAmount(1.5).frequentRenterPoints(1).build();

        assertEquals(result, this.threeDaysStatement);
    }

    @Test
    public void childrenRental3DayMovieNameAndMovieChargeTest() {
        String movieName = new StatementDeserializer(this.threeDaysStatement).getMovies();

        assertEquals(this.movieName + "1.5", movieName);
    }

    @Test
    public void childrenRental3DayTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.threeDaysStatement).getTotalAmount();

        assertEquals("1.5", totalAmount);
    }

    @Test
    public void childrenRental4DayTest() {
        String result = new StatementBuilder().customerName(customerName).movie(movieName, 6.0)
                .totalAmount(6.0).frequentRenterPoints(1).build();

        assertEquals(result, this.fourDaysStatement);
    }

    @Test
    public void childrenRental4DayMovieNameAndMovieChargeTest() {
        String movieName = new StatementDeserializer(this.fourDaysStatement).getMovies();

        assertEquals(this.movieName + "6.0", movieName);
    }

    @Test
    public void childrenRental4DayTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.fourDaysStatement).getTotalAmount();

        assertEquals("6.0", totalAmount);
    }
}
