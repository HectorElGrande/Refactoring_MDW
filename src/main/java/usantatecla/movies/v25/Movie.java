package usantatecla.movies.v25;

public abstract class Movie {

	private static final int FREQUENT_RENTER_POINTS = 1;

	private String title;
	
	public Movie(String title) {
		this.title = title;
	}

	public abstract double getCharge(int daysRented);

	public int getFrequentRenterPoints(int daysRented) {
		return FREQUENT_RENTER_POINTS;
	}
	
	public String getTitle() {
		return title;
	}
	
}
