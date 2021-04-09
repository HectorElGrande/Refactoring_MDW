package usantatecla.movies.v25;

public class StatementBuilder {

	final static String CUSTOMER_NAME_MESSAGE = "Rental Record for ";
	final static String TOTAL_AMOUNT_MESSAGE = "Amount owed is ";
	final static String FREQUENT_RENTER_POINTS_FIRST_MESSAGE = "You earned ";
	final static String FREQUENT_RENTER_POINTS_SECOND_MESSAGE = " frequent renter points";

	private String result;
	
	public StatementBuilder() {
		this.result = "";
	}
	
	public StatementBuilder customerName(String customerName) {
		this.result += CUSTOMER_NAME_MESSAGE + customerName + "\n";
		return this;
	}
	
	public StatementBuilder movie(String movieName, double amount) {
			this.result += "\t" + movieName + "\t" + amount + "\n";
		return this;
	}
	
	public StatementBuilder totalAmount(double totalAmount) {
		this.result += TOTAL_AMOUNT_MESSAGE + totalAmount + "\n";
		return this;
	} 
	
	public StatementBuilder frequentRenterPoints(int frequentRenterPoints) {
		this.result += FREQUENT_RENTER_POINTS_FIRST_MESSAGE + frequentRenterPoints
				+ FREQUENT_RENTER_POINTS_SECOND_MESSAGE;
		return this;
	}
	
	public String build() {
		return this.result;
	}
	

}
