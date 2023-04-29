package file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import entity.Journey;
import entity.Station;
import util.Util;
import java.util.ArrayList;

public class ReadCSV {

	private List<Journey> journeys = new ArrayList<Journey>();
	private List<Station> stations = new ArrayList<Station>();

	public List<Journey> getJourneys(String file) {

		String csvFile = file;
		BufferedReader br = null;
		String line = "";
		String seperator = ",";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			Journey journey = null;
			int i = 0;
			while ((line = br.readLine()) != null) {
				if (i != 0) {
					if (!line.isEmpty()) {
						line = Util.clearLine(line);
						String[] data = line.split(seperator);
						data = Util.clearData(data);
						if (data.length == 9 && !Util.isEmptyData(data)) {
							if (!Util.isNumeric(data[4]))
								journey = new Journey(data[0], data[1], data[2], data[3] + " " + data[4], data[5],
										data[6], Double.valueOf(data[7]), Integer.parseInt(data[8]));
							else if (!Util.isNumeric(data[6]))
								journey = new Journey(data[0], data[1], data[2], data[3], data[4],
										data[5] + " " + data[6], Double.valueOf(data[7]), Integer.parseInt(data[8]));
						}
						if (data.length == 10 && !Util.isEmptyData(data)) {
							journey = new Journey(data[0], data[1], data[2], data[3] + " " + data[4], data[5],
									data[6] + " " + data[7], Double.valueOf(data[8]), Integer.parseInt(data[9]));
						}
						if (data.length == 8 && !Util.isEmptyData(data))
							journey = new Journey(data[0], data[1], data[2], data[3], data[4], data[5],
									Double.valueOf(data[6]), Integer.parseInt(data[7]));
						journeys.add(journey);
					}
				}
				i++;
			}
			return journeys;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return journeys;
	}

	public List<Station> getStations() {

		String csvFile = "C:/Users/aytun/Solita/Helsingin_ja_Espoon_kaupunki_pyora_asemat_avoin.csv";
		BufferedReader br = null;
		String line = "";
		String seperator = ",";

		try {
			br = new BufferedReader(new FileReader(csvFile));
			Station station = null;
			while ((line = br.readLine()) != null) {
				line = Util.clearLine(line);
				String[] data = line.split(seperator);
				data = Util.clearData(data);
				if (!line.contains("FID")) {
					station = new Station(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], data[5],
							data[6], data[7], data[8], data[9], Integer.parseInt(data[10]),
							Double.valueOf(data[11]), Double.valueOf(data[12])
						);
						stations.add(station);
				}
			}
			return stations;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return stations;
	}
}