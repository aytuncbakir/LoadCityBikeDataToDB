package entity;

public class Station {
	
//	FID,ID,Nimi,Namn,Name,Osoite,Adress,Kaupunki,Stad,Operaattor,Kapasiteet,x,y
	private int fid;
	private String id;
	private String nimi;
	private String namn;
	private String name;
	private String osoite;
	private String address;
	private String kaupunki;
	private String stad;
	private String operaattor;
	private int kapasiteet;
	private double x;
	private double y;
	public Station(int fid, String id, String nimi, String namn, String name, String osoite, String address,
			String kaupunki, String stad, String operaattor, int kapasiteet, double x, double y) {
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
		this.operaattor = operaattor;
		this.kapasiteet = kapasiteet;
		this.x = x;
		this.y = y;
	}
	public int getFid() {
		return fid;
	}
	public String getId() {
		return id;
	}
	public String getNimi() {
		return nimi;
	}
	public String getNamn() {
		return namn;
	}
	public String getName() {
		return name;
	}
	public String getOsoite() {
		return osoite;
	}
	public String getAddress() {
		return address;
	}
	public String getKaupunki() {
		return kaupunki;
	}
	public String getStad() {
		return stad;
	}
	public String getOperaattor() {
		return operaattor;
	}
	public int getKapasiteet() {
		return kapasiteet;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	

}
