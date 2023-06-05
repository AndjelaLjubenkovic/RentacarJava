package test;

import org.xml.sax.InputSource;

import konekcija.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

import org.dbunit.DBTestCase;

import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.junit.jupiter.api.Test;




public class DatabaseConnectionTest extends DBTestCase {
	
	private Connection connection;
	
	/**
	 * 
	 * @param name
	 * Konstruktor DatabaseConnection postavlja sistemski svojstva kao sro su
	 * driver klasa, URL veze, korisničko ime i lozinka za povezivanje sa bazom podataka.
	 */
	public DatabaseConnectionTest(String name){
	    super(name);
	    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
	    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost/test_rentcar");
	    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
	    System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "");
	    
	    connection = DBConnection.getInstance().getConnection();
	  }
	/**
	 *   
	 * @return
	 * @throws Exception
	 * Metoda getDataSet vraca set podataka koji će se koristiti za testiranje u JSON formatu
	 */
	/*
	@Override
	protected IDataSet getDataSet() throws Exception {
	    return new JsonDataSet(new File("test_rentcar.json"));
	}
	*/
	@Override
	  protected IDataSet getDataSet() throws Exception {
	    return new FlatXmlDataSetBuilder().build(new InputSource("test_rentcar.xml"));
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
	  
	  /**
	   * 
	   * @throws SQLException
	   * Metoda testZatvoriKonekciju proverava zatvaranje konekcija
	   */
	  @Test
	    public void testZatvoriKonekciju() throws SQLException {

		  connection.close();
	        assertTrue(((DBConnection) connection).isKonekcijaZatvorena());
	    }
	
}
