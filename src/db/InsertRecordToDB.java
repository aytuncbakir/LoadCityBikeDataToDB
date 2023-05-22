package db;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import entity.Journey;
import entity.Station;
import file.ReadCSV;
import util.LoadProperties;
import util.Util;

public class InsertRecordToDB {
	
	LoadProperties loaded = new LoadProperties();
	Properties prop = loaded.getProperties();

	public void insertJourneyRecords(int index)  {

		ReadCSV read = new ReadCSV();
		List<Journey> journeys = read.getJourneys(Util.dataFiles[index]);
		
		
		try (Connection connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(Util.INSERT_JOURNEYS_SQL)) {
			connection.setAutoCommit(false);
			
			// journeys.size()
			for (int i = 0; i < journeys.size(); i++) {
				if (journeys.get(i).getCovered_distance() > 10 && journeys.get(i).getDuration() > 10) {
					preparedStatement.setLong(1, Util.JOURNEY_ID++);
					preparedStatement.setString(2, journeys.get(i).getDeparture());
					preparedStatement.setString(3, journeys.get(i).getReturnn());
					preparedStatement.setString(4, journeys.get(i).getDeparture_station_id());
					preparedStatement.setString(5, journeys.get(i).getDeparture_station_name());
					preparedStatement.setString(6, journeys.get(i).getReturn_station_id());
					preparedStatement.setString(7, journeys.get(i).getReturn_station_name());
					preparedStatement.setDouble(8, journeys.get(i).getCovered_distance());
					preparedStatement.setInt(9, journeys.get(i).getDuration());
					// Step 3: Execute the query or update query
					preparedStatement.addBatch();
				}
			}
			int[] updateCounts = preparedStatement.executeBatch();
//			System.out.println(updateCounts[0]);
			 connection.commit();
	         connection.setAutoCommit(true);

		}catch (BatchUpdateException e) {
			printSQLException(e);
	        
		} catch (SQLException e) {
			// print SQL exception information
			printSQLException(e);
		}
		// Step 4: try-with-resource statement will auto close the connection.
	}

	public void insertStationRecords() throws SQLException {

		ReadCSV read = new ReadCSV();
		List<Station> stations = read.getStations();
		// Step 1: Establishing a Connection
		try (Connection connection = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
				prop.getProperty("password"));
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(Util.INSERT_STATIONS_SQL)) 
		{
			
			 connection.setAutoCommit(false);
			for (int i = 0; i < stations.size(); i++) {
				preparedStatement.setLong(1, stations.get(i).getFid());
				preparedStatement.setString(2, stations.get(i).getId());
				preparedStatement.setString(3, stations.get(i).getNimi());
				preparedStatement.setString(4, stations.get(i).getNamn());
				preparedStatement.setString(5, stations.get(i).getName());
				preparedStatement.setString(6, stations.get(i).getOsoite());
				preparedStatement.setString(7, stations.get(i).getAddress());	
				
				if(stations.get(i).getKaupunki().isEmpty())
					preparedStatement.setString(8, "Espoo");
				else
					preparedStatement.setString(8, stations.get(i).getKaupunki());
				
				if(stations.get(i).getStad().isEmpty())
					preparedStatement.setString(9, "Esbo");
				else
					preparedStatement.setString(9, stations.get(i).getStad());
				
				if(stations.get(i).getOperaattori().isEmpty())
					preparedStatement.setString(10, "CityBike Finland");
				else
					preparedStatement.setString(10, stations.get(i).getOperaattori());
				
				preparedStatement.setInt(11, stations.get(i).getKapasiteet());
				preparedStatement.setDouble(12, stations.get(i).getLongitude());
				preparedStatement.setDouble(13, stations.get(i).getLatitude());
				// System.out.println(preparedStatement);
				// Step 3: Execute the query or update query
				preparedStatement.addBatch();
			}
			int[] updateCounts = preparedStatement.executeBatch();
//			System.out.println(updateCounts);
			 connection.commit();
	         connection.setAutoCommit(true);
		}catch (BatchUpdateException e) {
			printSQLException(e);
	        
		} catch (SQLException e) {
			// print SQL exception information
			printSQLException(e);
		}

		// Step 4: try-with-resource statement will auto close the connection.
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}