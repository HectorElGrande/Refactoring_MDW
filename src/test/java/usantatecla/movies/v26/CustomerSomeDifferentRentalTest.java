package usantatecla.movies.v26;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import usantatecla.movies.v24.StatementBuilder;

public class CustomerSomeDifferentRentalTest {

	final String customerName = "customerName";
	final String regularMovieName = "regularMovieName";
	final String newReleaseMovieName = "newReleaseMovieName";
	final String childrenMovieName = "childrenMovieName";

	private String statement10;

	@Before
	public void before(){
		Movie regularMovie2 = new RegularMovie(regularMovieName);
		Movie newReleaseMovie2 = new NewReleaseMovie(newReleaseMovieName);
		Movie childrenMovie2 = new ChildrenMovie(childrenMovieName);

		Rental regularRental = new RentalBuilder().movie(regularMovie2).daysRented(10).build();
		Rental newReleaseRental = new RentalBuilder().movie(newReleaseMovie2).daysRented(10).build();
		Rental childrenRental = new RentalBuilder().movie(childrenMovie2).daysRented(10).build();

		Customer customer10 = new CustomerBuilder().name(customerName)
				.rental(regularRental).rental(newReleaseRental).rental(childrenRental).build();

		this.statement10 = customer10.statement();
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
