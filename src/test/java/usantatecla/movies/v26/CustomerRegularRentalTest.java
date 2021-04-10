package usantatecla.movies.v26;

import org.junit.Before;
import org.junit.Test;
import usantatecla.movies.v24.StatementBuilder;

import static org.junit.Assert.assertEquals;

public class CustomerRegularRentalTest {

    final String customerName = "customerName";
    final String movieName = "movieName";

    private String statement1;
    private String statement2;
    private String statement3;

    @Before
    public void before() {
        Movie regularMovie = new RegularMovie(this.movieName);

        Rental rental1 = new RentalBuilder().movie(regularMovie).daysRented(1).build();
        Customer customer1 = new CustomerBuilder().name(this.customerName).rental(rental1).build();
        this.statement1 = customer1.statement();

        Rental rental2 = new RentalBuilder().movie(regularMovie).daysRented(2).build();
        Customer customer2 = new CustomerBuilder().name(this.customerName).rental(rental2).build();
        this.statement2 = customer2.statement();

        Rental rental3 = new RentalBuilder().movie(regularMovie).daysRented(3).build();
        Customer customer3 = new CustomerBuilder().name(customerName).rental(rental3).build();
        this.statement3 = customer3.statement();
    }

    @Test
    public void regularRental1DayTest() {
        String result = new usantatecla.movies.v24.StatementBuilder().customerName(customerName).movie(movieName, 2)
                .totalAmount(2).frequentRenterPoints(1).build();

        assertEquals(result, this.statement1);
    }

    @Test
    public void regularRental1DayMovieNameAndMovieChargeTest() {
        String movieName = new StatementDeserializer(this.statement1).getMovies();

        assertEquals(this.movieName + "2.0", movieName);
    }

    @Test
    public void regularRental1DayTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.statement1).getTotalAmount();

        assertEquals("2.0", totalAmount);
    }

    @Test
    public void regularRental1DayFrequentRenterPointsTest() {
        String frequentRenterPoints = new StatementDeserializer(this.statement1).getFrequentRenterPoints();

        assertEquals("1", frequentRenterPoints);
    }

    @Test
    public void regularRental2DayTest() {
        String result = new usantatecla.movies.v24.StatementBuilder().customerName(customerName).movie(movieName, 2)
                .totalAmount(2).frequentRenterPoints(1).build();
        assertEquals(result, this.statement2);
    }

    @Test
    public void regularRental2DayMovieNameAndMovieChargeTest() {
        String movieName = new StatementDeserializer(this.statement2).getMovies();

        assertEquals(this.movieName + "2.0", movieName);
    }

    @Test
    public void regularRental2DayTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.statement2).getTotalAmount();

        assertEquals("2.0", totalAmount);
    }

    @Test
    public void regularRental3DayTest() {
        String result = new StatementBuilder().customerName(customerName).movie(movieName, 3.5)
                .totalAmount(3.5).frequentRenterPoints(1).build();

        assertEquals(result, this.statement3);
    }

    @Test
    public void regularRental3DayMovieNameAndMovieChargeTest() {
        String movieName = new StatementDeserializer(this.statement3).getMovies();

        assertEquals(this.movieName + "3.5", movieName);
    }

    @Test
    public void regularRental3DayTotalAmountTest() {
        String totalAmount = new StatementDeserializer(this.statement3).getTotalAmount();

        assertEquals("3.5", totalAmount);
    }

}
