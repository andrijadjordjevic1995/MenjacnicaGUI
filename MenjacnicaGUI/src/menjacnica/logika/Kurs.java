package menjacnica.logika;

public class Kurs {
	private int sifra;
	private String skraceniNaziv;
	private String naziv;
	private double prodajni;
	private double kupovni;
	private double srednji;
	
	public Kurs(){
		
	}
	public Kurs(int sifra, String skraceniNaziv, String naziv, double prodajni, double kupovni, double srednji) {
		this.sifra = sifra;
		this.skraceniNaziv = skraceniNaziv;
		this.naziv = naziv;
		this.prodajni = prodajni;
		this.kupovni = kupovni;
		this.srednji = srednji;
	}
	public int getSifra() {
		return sifra;
	}
	public void setSifra(int sifra) {
		this.sifra = sifra;
	}
	public String getSkraceniNaziv() {
		return skraceniNaziv;
	}
	public void setSkraceniNaziv(String skraceniNaziv) {
		this.skraceniNaziv = skraceniNaziv;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getProdajni() {
		return prodajni;
	}
	public void setProdajni(double prodajni) {
		this.prodajni = prodajni;
	}
	public double getKupovni() {
		return kupovni;
	}
	public void setKupovni(double kupovni) {
		this.kupovni = kupovni;
	}
	public double getSrednji() {
		return srednji;
	}
	public void setSrednji(double srednji) {
		this.srednji = srednji;
	}
	
	
}
