package menjacnica.kontroler;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

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
				//	kursevi.add(new Kurs(1, "eur", "euro", 1, 1, 1));
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
	public static String ucitajFajl() {
		JFileChooser jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
		int povratnaVrednost = jfc.showOpenDialog(glavniProzor.getContentPane());
		
		if(povratnaVrednost == JFileChooser.APPROVE_OPTION){
			String putanja = jfc.getSelectedFile().getAbsolutePath();
			return putanja;
		}
		return null;
	}
	public static String ucitajUFajl() {
		JFileChooser jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File(System.getProperty("user.home")));
		int povratnaVrednost = jfc.showSaveDialog(glavniProzor.getContentPane());
		
		if(povratnaVrednost == JFileChooser.APPROVE_OPTION){
			String putanja = jfc.getSelectedFile().getAbsolutePath();
			return putanja;
		}
		return null;
	}
	
	public static void izadji() {
		int povratna = JOptionPane.showConfirmDialog(glavniProzor.getContentPane(),
				"Da li zelite da izadjete iz programa?", "Izlazak", JOptionPane.YES_NO_CANCEL_OPTION);

		if (povratna == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	public static void prikaziPodatkeOAutoru() {
		JDialog dialog = new JDialog(glavniProzor, "O Autoru", true);
		dialog.setResizable(false);
		
		JTextPane txt = new JTextPane();
		txt.setText("Autor: Andrija Djordjevic\n03.05.2016.");
		txt.setEditable(false);
		
		dialog.add(txt);
		dialog.setLocationRelativeTo(null);
		dialog.pack();
		dialog.setVisible(true);
	}
	
}
