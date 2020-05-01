package DataReader;

import java.sql.SQLException;
import org.testng.annotations.DataProvider;

public class ReadData {
	
	@DataProvider(name="AmazonData")
	public Object[][] getData() throws ClassNotFoundException, SQLException {
	return new Object[][] {
		
	{"8884741673","omsairam777","Rice Bag"},
//	{"6648743999", "satyasree@123", "65 inch tv"},
	};
	}

	
}
