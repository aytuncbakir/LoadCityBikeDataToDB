package util;

public class Util {
	
    public static final String INSERT_JOURNEYS_SQL = "INSERT INTO journeys" +
            "  (departure, return, departure_station_id, departure_station_name, return_station_id, "
            + "return_station_name, covered_distance, duration) VALUES " +
            " (?, ?, ?, ?, ? , ? , ? , ?);";
        
    public static final String INSERT_STATIONS_SQL = "INSERT INTO stations" +
                "  (fid, id, nimi, namn, name, "
                + "osoite, address, kaupunki, stad, operaattor, kapasiteet, x , y) VALUES " +
                " (?, ?, ?, ?, ? , ? , ? , ?, ?, ?, ? ,? ,?);";
    
    public static final String[] dataFiles = {
              "C:/Users/aytun/Solita/2021-05.csv",
              "C:/Users/aytun/Solita/2021-06.csv",
              "C:/Users/aytun/Solita/2021-07.csv"};

	public static boolean isNumeric(String str) {
		try {
			Double.valueOf(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isEmptyData(String[] data) {

		for (int i = 0; i < data.length; i++) {
			if (data[i].isEmpty()) {
				return true;
			}
		}
		return false;

	}
	
	public static String clearLine(String line) {
		line = line.replace("\"", "");
		return line;
	}
	
	public static String[] clearData(String[] data) {
		for(int i = 0; i<data.length; i++) {
			data[i] = data[i].trim();
		}
		return data;
	}

}
