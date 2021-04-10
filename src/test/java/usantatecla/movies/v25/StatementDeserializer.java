package usantatecla.movies.v25;

public class StatementDeserializer {

	private String statement;
	
	public StatementDeserializer(String statement) {
		this.statement = statement;
	}
	
	public String getCustomerName() {
		return this.statement.split("Rental Record for ")[1].split("\n")[0];
	}

	public String getMovies() {
		String[] statementLines = this.statement.split("\n");
		String movieList = "";
		for(int i = 1; i < statementLines.length - 2; i++){
			String[] movieLine = statementLines[i].split("\t");
			movieList += movieLine[1] + movieLine[2];
		}
		return movieList;
	}

	public String getTotalAmount() {
		return this.statement.split("Amount owed is ")[1].split("\n")[0];
	}

	public String getFrequentRenterPoints() {
		return this.statement.split("You earned ")[1].split(" frequent renter points")[0];
	}

}
