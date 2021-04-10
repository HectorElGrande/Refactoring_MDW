package usantatecla.movies.v26;

import org.junit.Before;
import org.junit.Test;
import usantatecla.movies.v24.StatementBuilder;

import static org.junit.Assert.assertEquals;

public class CustomerChildrenRentalTest {

    final String customerName = "customerName";
    final String movieName = "movieName";

    private String statement7;
    private String statement8;
    private String statement9;

    @Before
    public void before() {
        Movie childrenMovie = new ChildrenMovie(movieName);

        Rental rental7 = new RentalBuilder().movie(childrenMovie).daysRented(1).build();
        Customer customer7 = new CustomerBuilder().name(customerName).rental(rental7).build();
        this.statement7 = customer7.statement();

        Rental rental8 = new RentalBuilder().movie(childrenMovie).daysRented(3).build();
        Customer customer8 = new CustomerBuilder().name(customerName).rental(rental8).build();
        this.statement8 = customer8.statement();

        Rental rental9 = new RentalBuilder().movie(childrenMovie).daysRented(4).build();
        Customer customer9 = new CustomerBuilder().name(customerName).rental(rental9).build();
        this.statement9 = customer9.statement();
    }

    @Test
    public void childrenRental1DayTest() {
        String result = new usantatecla.movies.v24.StatementBuilder().customerName(customerName).movie(movieName, 1.5)
                .totalAmount(1.5).frequentRenterPoints(1).build();

        assertEquals(result, this.statement7);
    }

    @Test
    public void childrenRental1DayMovieNameAndMovieChargeTest() {
        String movieName = new StatementDeserializer(this.statement7).getMovies();

        assertEquals(this.movieName + "1.5", movieName);
    }

    @Test
    public void childrenRental1DayTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.statement7).getTotalAmount();

        assertEquals("1.5", totalAmount);
    }

    @Test
    public void childrenRental1DayFrequentRenterPointsTest() {
        String frequentRenterPoints = new StatementDeserializer(this.statement7).getFrequentRenterPoints();

        assertEquals("1", frequentRenterPoints);
    }

    @Test
    public void childrenRental3DayTest() {
        String result = new usantatecla.movies.v24.StatementBuilder().customerName(customerName).movie(movieName, 1.5)
                .totalAmount(1.5).frequentRenterPoints(1).build();

        assertEquals(result, this.statement8);
    }

    @Test
    public void childrenRental3DayMovieNameAndMovieChargeTest() {
        String movieName = new StatementDeserializer(this.statement8).getMovies();

        assertEquals(this.movieName + "1.5", movieName);
    }

    @Test
    public void childrenRental3DayTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.statement8).getTotalAmount();

        assertEquals("1.5", totalAmount);
    }

    @Test
    public void childrenRental4DayTest() {
        String result = new StatementBuilder().customerName(customerName).movie(movieName, 6.0)
                .totalAmount(6.0).frequentRenterPoints(1).build();

        assertEquals(result, this.statement9);
    }

    @Test
    public void childrenRental4DayMovieNameAndMovieChargeTest() {
        String movieName = new StatementDeserializer(this.statement9).getMovies();

        assertEquals(this.movieName + "6.0", movieName);
    }

    @Test
    public void childrenRental4DayTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.statement9).getTotalAmount();

        assertEquals("6.0", totalAmount);
    }
}
