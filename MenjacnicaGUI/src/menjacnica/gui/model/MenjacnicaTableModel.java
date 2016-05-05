package menjacnica.gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import menjacnica.logika.Kurs;

public class MenjacnicaTableModel extends AbstractTableModel {
	private final String[] kolone = new String[]{"Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni", "Naziv"};
	private List<Kurs> kursevi;
	
	public MenjacnicaTableModel(List<Kurs> kursevi) {
		this.kursevi = kursevi;
	}
	
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return kursevi.size();
	}

	@Override
	public Object getValueAt(int red, int kolona) {
		Kurs povratna = kursevi.get(red);
		
		switch(kolona){
		case 0:
			return new Integer(povratna.getSifra());
		case 1:
			return povratna.getSkraceniNaziv();
		case 2:
			return new Double(povratna.getProdajni());
		case 3:
			return new Double(povratna.getSrednji());
		case 4:
			return new Double(povratna.getKupovni());
		case 5:
			return povratna.getNaziv();
		default:
			return "";
		
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}
	
	public void osveziTabelu(List<Kurs> kursevi){
		this.kursevi = kursevi;
		fireTableDataChanged();
	}
	
	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Kurs vratiKurs(int red){
		return kursevi.get(red);
		
	}
	
}
