package usantatecla.movies.v25;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

	final String customerName = "customerName";
	final String movieName = "movieName";
	private Movie regularMovie1;
	private Rental rental1;
	private Customer customer1;
	
	@Before
	public void before(){
		this.regularMovie1 = new RegularMovie(this.movieName);
		this.rental1 = new RentalBuilder().movie(regularMovie1).daysRented(1).build();
		this.customer1 = new CustomerBuilder().name(this.customerName).rental(rental1).build();
		
		
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
	public void regularRental1DayCustomerNameTest() {
		String customerNameStatement = StatementBuilder.CUSTOMER_NAME_MESSAGE + this.customer1.getName() + "\n";

		String result = new StatementBuilder().customerName(this.customerName).build();
		assertEquals(result, customerNameStatement);
	}

	@Test
	public void regularRental1DayMovieNameTest() {
		String movieStatement = "\t" + this.regularMovie1.getTitle() + "\t" + this.rental1.getCharge() + "\n";;

		String result = new StatementBuilder().movie(this.movieName, 2).build();
		assertEquals(result, movieStatement);
	}

	@Test
	public void regularRental1DayTotalAmountTest() {
		String totalAmountStatement = StatementBuilder.TOTAL_AMOUNT_MESSAGE + this.rental1.getCharge() + "\n";

		String result = new StatementBuilder().totalAmount(2).build();
		assertEquals(result, totalAmountStatement);
	}

	@Test
	public void regularRental1DayFrequentRenterPointsTest() {
		String FrequentRenterPointsStatement = StatementBuilder.FREQUENT_RENTER_POINTS_FIRST_MESSAGE +
				this.rental1.getFrequentRenterPoints() + StatementBuilder.FREQUENT_RENTER_POINTS_SECOND_MESSAGE;

		String result = new StatementBuilder().frequentRenterPoints(1).build();
		assertEquals(result, FrequentRenterPointsStatement);
	}
	
	@Test
	public void regularRental2DayTest() {
		String movieName = "movieName";
		Movie movie = new RegularMovie(movieName);
		Rental rental = new RentalBuilder().movie(movie).daysRented(2).build();
		String customerName = "customerName";
		Customer customer = new CustomerBuilder().name(customerName).rental(rental).build();

		String statement = customer.statement();

		String result = new StatementBuilder().customerName(customerName).movie(movieName, 2)
				.totalAmount(2).frequentRenterPoints(1).build();
		assertEquals(result, statement);
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
