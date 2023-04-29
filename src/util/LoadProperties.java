package util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
	
	private Properties prop = null;
	
	public LoadProperties() {
		loadProperties();
	}
	
	private void loadProperties() {
		
		FileReader reader = null;
		try {
			prop = new Properties();
			reader = new FileReader("resources/config.properties");
			prop.load(reader);
//			String user = prop.getProperty("user");
//	    	String password =  prop.getProperty("password");
//	    	String url  = prop.getProperty("url");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    
	}
	
	public Properties getProperties() {
		return this.prop;
	}

}
