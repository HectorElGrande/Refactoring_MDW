package usantatecla.movies.v25;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import usantatecla.movies.v24.StatementBuilder;

public class CustomerTest {

	final String customerName = "customerName";
	final String movieName = "movieName";
	final String regularMovieName = "regularMovieName";
	final String newReleaseMovieName = "newReleaseMovieName";
	final String childrenMovieName = "childrenMovieName";
	private String statement0;
	private String statement1;
	private String statement2;
	private String statement3;
	private String statement4;
	private String statement5;
	private String statement6;
	private String statement7;
	private String statement8;
	private String statement9;
	private String statement10;

	@Before
	public void before(){
		Customer customer0 = new CustomerBuilder().name(this.customerName).build();
		this.statement0 = customer0.statement();

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

		Movie regularMovie2 = new RegularMovie(regularMovieName);
		Rental regularRental = new RentalBuilder().movie(regularMovie2).daysRented(10).build();
		Movie newReleaseMovie2 = new NewReleaseMovie(newReleaseMovieName);
		Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie2).daysRented(10).build();
		Movie childrenMovie2 = new ChildrenMovie(childrenMovieName);
		Rental childrenRental = new RentalBuilder().movie(childrenMovie2).daysRented(10).build();
		Customer customer10 = new CustomerBuilder().name(customerName)
				.rental(regularRental).rental(newReleaseRental).rental(childrenRental).build();
		this.statement10 = customer10.statement();
	}

	@Test
	public void withoutRentalsTest() {
		String result = new StatementBuilder().customerName(this.customerName)
				.totalAmount(0).frequentRenterPoints(0).build();

		assertEquals(result, this.statement0);
	}

	@Test
	public void withoutRentalsCustomerNameTest() {
		String customerName = new StatementDeserializer(this.statement0).getCustomerName();

		assertEquals(this.customerName, customerName);
	}

	@Test
	public void withoutRentalsTotalAmountTest() {
		String totalAmount = new StatementDeserializer(this.statement0).getTotalAmount();

		assertEquals("0.0", totalAmount);
	}

	@Test
	public void withoutRentalsFrequentRenterPointsTest() {
		String frequentRenterPoints = new StatementDeserializer(this.statement0).getFrequentRenterPoints();

		assertEquals("0", frequentRenterPoints);
	}

	@Test
	public void regularRental1DayTest() {
		String result = new StatementBuilder().customerName(customerName).movie(movieName, 2)
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
		String result = new StatementBuilder().customerName(customerName).movie(movieName, 2)
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
	
	@Test
	public void newReleaseRental1DayTest() {
		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
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
		String result = new StatementBuilder().customerName(customerName).movie(movieName, 3)
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
	
	@Test
	public void childrenRental1DayTest() {
		String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5)
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
		String result = new StatementBuilder().customerName(customerName).movie(movieName, 1.5)
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
	
	@Test
	public void rentalTest() {
		String result = new StatementBuilder().customerName(customerName)
				.movie(this.regularMovieName, 14).movie(this.newReleaseMovieName, 3).movie(this.childrenMovieName, 15)
				.totalAmount(32).frequentRenterPoints(4).build();
		assertEquals(result, this.statement10);
	}

	@Test
	public void rentalMovieNameAndMovieChargeTest() {
		String movieName = new StatementDeserializer(this.statement10).getMovies();

		assertEquals(this.regularMovieName + "14.0"+this.newReleaseMovieName +
				"3.0"+this.childrenMovieName + "15.0", movieName);
	}

	@Test
	public void rentalTotalAmountTest() {
		String totalAmount = new StatementDeserializer(this.statement10).getTotalAmount();

		assertEquals("32.0", totalAmount);
	}

	@Test
	public void rentalFrequentRenterPointsTest() {
		String frequentRenterPoints = new StatementDeserializer(this.statement10).getFrequentRenterPoints();

		assertEquals("4", frequentRenterPoints);
	}

}
