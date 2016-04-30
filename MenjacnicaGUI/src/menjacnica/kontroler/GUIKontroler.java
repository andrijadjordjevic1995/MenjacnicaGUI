package menjacnica.kontroler;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import menjacnica.gui.MenjacnicaGUI;
import menjacnica.logika.Kurs;
import menjacnica.logika.Menjacnica;

public class GUIKontroler {
	private static Menjacnica menjacnica;
	private static MenjacnicaGUI glavniProzor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menjacnica = new Menjacnica();
					List<Kurs> kursevi = new ArrayList<>();
					kursevi.add(new Kurs(1, "eur", "euro", 1, 1, 1));
					menjacnica.setKursevi(kursevi);
					glavniProzor = new MenjacnicaGUI();
					glavniProzor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static List<Kurs> getListaKurseva() {
		// TODO Auto-generated method stub
		return menjacnica.getKursevi();
	}
	
}
