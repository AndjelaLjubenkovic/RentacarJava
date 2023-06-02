import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.dbunit.DBTestCase;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.dataset.json.JsonDataSet;




public class DatabaseConnectionTest extends DBTestCase {
	
	/**
	 * 
	 * @param name
	 * Konstruktor DatabaseConnection postavlja sistemski svojstva kao sro su
	 * driver klasa, URL veze, korisničko ime i lozinka za povezivanje sa bazom podataka.
	 */
	public MyDatabaseTest(String name) {
	    super(name);
	    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
	    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/test_rentcar");
	    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
	    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "");
	  }
	/**
	 *   
	 * @return
	 * @throws Exception
	 * Metoda getDataSet vraca set podataka koji će se koristiti za testiranje u JSON formatu
	 */
	@Override
	protected IDataSet getDataSet() throws Exception {
	    return new JsonDataSet(new File("test_rentcar.json"));
	}

	 /**
	  *  
	  * @param config
	  * Metoda setUpDatabaseConfig dodatno konfigurise bazu kako bi bila prilagodjena za MySQL
	  */
	  @Override
	  protected void setUpDatabaseConfig(DatabaseConfig config) {
	    config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
	  }
	  
	
}
