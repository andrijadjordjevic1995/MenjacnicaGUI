package menjacnica.logika;

import java.util.ArrayList;
import java.util.List;

public class Menjacnica {
	private List<Kurs> kursevi;

	public Menjacnica() {
		kursevi = new ArrayList<Kurs>();
	}
	public List<Kurs> getKursevi() {
		return kursevi;
	}

	public void setKursevi(List<Kurs> kursevi) {
		this.kursevi = kursevi;
	}
	
	public void dodajKurs(Kurs kurs){
		kursevi.add(kurs);
	}
	public void obrisiKurs(int index){
		kursevi.remove(index);
	}
	
	public Kurs vratiKurs(int index){
		return kursevi.get(index);
	}
}
