package app;

import java.sql.SQLException;

import db.InsertRecordToDB;
import util.Util;

public class Application {
	
	public static void main(String args[]) {
		InsertRecordToDB createTableExample = new InsertRecordToDB();
        try {
        	System.out.println("Data is loading...");
			createTableExample.insertStationRecords();
			for(int i = 0; i< Util.dataFiles.length; i++) {
				createTableExample.insertJourneyRecords(i);
			}
			
			System.out.println("Data loaded.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
