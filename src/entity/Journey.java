package entity;

public class Journey {
	
	private String departure;
	private String returnn;
	private String departure_station_id;
	private String departure_station_name;
	private String return_station_id;
	private String return_station_name;
	private double covered_distance;
	private int duration;
	
	public Journey(String departure, String returnn, String departure_station_id, String departure_station_name,
			String return_station_id, String return_station_name, double covered_distance, int duration) {
		super();
		this.departure = departure;
		this.returnn = returnn;
		this.departure_station_id = departure_station_id;
		this.departure_station_name = departure_station_name;
		this.return_station_id = return_station_id;
		this.return_station_name = return_station_name;
		this.covered_distance = covered_distance;
		this.duration = duration;
	}
	
	public String getDeparture() {
		return departure;
	}
	public String getReturnn() {
		return returnn;
	}
	public String getDeparture_station_id() {
		return departure_station_id;
	}
	public String getDeparture_station_name() {
		return departure_station_name;
	}
	public String getReturn_station_id() {
		return return_station_id;
	}
	public String getReturn_station_name() {
		return return_station_name;
	}
	public double getCovered_distance() {
		return covered_distance;
	}
	public int getDuration() {
		return duration;
	}

}
