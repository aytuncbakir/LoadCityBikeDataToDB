package entity;

public class Station {
	
//	FID,ID,Nimi,Namn,Name,Osoite,Adress,Kaupunki,Stad,Operaattor,Kapasiteet,x,y
	private long fid;
	private String id;
	private String nimi;
	private String namn;
	private String name;
	private String osoite;
	private String address;
	private String kaupunki;
	private String stad;
	private String operaattori;
	private int kapasiteet;
	private double longitude;
	private double latitude;
	public Station(long fid, String id, String nimi, String namn, String name, String osoite, String address,
			String kaupunki, String stad, String operaattori, int kapasiteet, double longitude, double latitude) {
		super();
		this.fid = fid;
		this.id = id;
		this.nimi = nimi;
		this.namn = namn;
		this.name = name;
		this.osoite = osoite;
		this.address = address;
		this.kaupunki = kaupunki;
		this.stad = stad;
		this.operaattori = operaattori;
		this.kapasiteet = kapasiteet;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public long getFid() {
		return fid;
	}
	public void setFid(long fid) {
		this.fid = fid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNimi() {
		return nimi;
	}
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	public String getNamn() {
		return namn;
	}
	public void setNamn(String namn) {
		this.namn = namn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOsoite() {
		return osoite;
	}
	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getKaupunki() {
		return kaupunki;
	}
	public void setKaupunki(String kaupunki) {
		this.kaupunki = kaupunki;
	}
	public String getStad() {
		return stad;
	}
	public void setStad(String stad) {
		this.stad = stad;
	}
	public String getOperaattori() {
		return operaattori;
	}
	public void setOperaattori(String operaattori) {
		this.operaattori = operaattori;
	}
	public int getKapasiteet() {
		return kapasiteet;
	}
	public void setKapasiteet(int kapasiteet) {
		this.kapasiteet = kapasiteet;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	

}
