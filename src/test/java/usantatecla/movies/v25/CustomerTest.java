package usantatecla.movies.v25;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import usantatecla.movies.v24.StatementBuilder;

public class CustomerTest {

	final String customerName = "customerName";
	final String movieName = "movieName";
	private String statement1;
	private String statement2;

	@Before
	public void before(){
		Movie regularMovie = new RegularMovie(this.movieName);

		Rental rental1 = new RentalBuilder().movie(regularMovie).daysRented(1).build();
		Customer customer1 = new CustomerBuilder().name(this.customerName).rental(rental1).build();
		this.statement1 = customer1.statement();

		Rental rental2 = new RentalBuilder().movie(regularMovie).daysRented(2).build();
		Customer customer2 = new CustomerBuilder().name(this.customerName).rental(rental2).build();
		this.statement2 = customer2.statement();
		
	}

	@Test
	public void withoutRentalsTest() {
		Customer customer = new CustomerBuilder().name(this.customerName).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(this.customerName)
				.totalAmount(0).frequentRenterPoints(0).build();
		assertEquals(result, statement);
	}

	@Test
	public void regularRental1DayTest() {
		String result = new StatementBuilder().customerName(customerName).movie(movieName, 2)
				.totalAmount(2).frequentRenterPoints(1).build();

		assertEquals(result, this.statement1);
	}

	@Test
	public void regularRental1DayCustomerNameTest() {
		String customerName = new StatementDeserializer(this.statement1).getCustomerName();

		assertEquals(this.customerName, customerName);
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
		String result = new StatementBuilder().customerName(customerName).movie(movieName, 2)
				.totalAmount(2).frequentRenterPoints(1).build();
		assertEquals(result, this.statement2);
	}

	@Test
	public void regularRental2DayTotalAmountTest() {
		String totalAmount = new StatementDeserializer(this.statement2).getTotalAmount();

		assertEquals("2.0", totalAmount);
	}

	@Test
	public void regularRental2DayFrequentRenterPointsTest() {
		String frequentRenterPoints = new StatementDeserializer(this.statement2).getFrequentRenterPoints();

		assertEquals("1", frequentRenterPoints);
	}

	@Test
	public void regularRental3DayTest() {
		String movieName = "movieName";
		Movie movie = new RegularMovie(movieName);
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3.5)
				.totalAmount(3.5).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void newReleaseRental1DayTest() {
		String movieName = "movieName";
		Movie movie = new NewReleaseMovie(movieName);
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
				.totalAmount(3).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void newReleaseRental2DayTest() {
		String movieName = "movieName";
		Movie movie = new NewReleaseMovie(movieName);
		Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
				.totalAmount(3).frequentRenterPoints(2).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void newReleaseRental3DayTest() {
		String movieName = "movieName";
		Movie movie = new NewReleaseMovie(movieName);
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
				.totalAmount(3).frequentRenterPoints(2).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void childrensRental1DayTest() {
		String movieName = "movieName";
		Movie movie = new ChildrenMovie(movieName);
		Rental rental = new RentalBuilder().movie(movie).daysRented(1).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5)
				.totalAmount(1.5).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void childrensRental3DayTest() {
		String movieName = "movieName";
		Movie movie = new ChildrenMovie(movieName);
		Rental rental = new RentalBuilder().movie(movie).daysRented(3).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5)
				.totalAmount(1.5).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void childrensRental4DayTest() {
		String movieName = "movieName";
		Movie movie = new ChildrenMovie(movieName);
		Rental rental = new RentalBuilder().movie(movie).daysRented(4).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 6)
				.totalAmount(6).frequentRenterPoints(1).build();
		assertEquals(result, statement);
	}
	
	@Test
	public void rentalTest() {
		String regularMovieName = "regularMovieName";
		Movie regularMovie = new RegularMovie(regularMovieName);
		Rental regularRental = new RentalBuilder().movie(regularMovie).daysRented(10).build();
		
		String newReleaseMovieName = "newReleaseMovieName";
		Movie newReleaseMovie = new NewReleaseMovie(newReleaseMovieName);
		Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie).daysRented(10).build();
		
		String childrensMovieName = "childrensMovieName";
		Movie childrensMovie = new ChildrenMovie(childrensMovieName);
		Rental childrensRental = new RentalBuilder().movie(childrensMovie).daysRented(10).build();
		
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName)
				.rental(regularRental).rental(newReleaseRental).rental(childrensRental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName)
				.movie(regularMovieName, 14).movie(newReleaseMovieName, 3).movie(childrensMovieName, 15)
				.totalAmount(32).frequentRenterPoints(4).build();
		assertEquals(result, statement);
	}
	
	
}
