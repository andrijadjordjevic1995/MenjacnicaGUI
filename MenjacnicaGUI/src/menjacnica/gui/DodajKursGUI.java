package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import menjacnica.kontroler.GUIKontroler;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSifra;
	private JLabel lblNaziv;
	private JTextField txtSifra;
	private JTextField txtNaziv;
	private JLabel lblProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField txtProdajni;
	private JTextField txtKupovni;
	private JLabel lblSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField txtSrednji;
	private JTextField txtSkraceni;
	private JButton btnOdustani;
	private JButton btnDodaj;
	
	public DodajKursGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 230);
		setTitle("Dodaj kurs");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(getLblSifra());
		contentPane.add(getLblNaziv());
		contentPane.add(getTxtSifra());
		contentPane.add(getTxtNaziv());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getTxtProdajni());
		contentPane.add(getTxtKupovni());
		contentPane.add(getLblSrednjiKurs());
		contentPane.add(getLblSkraceniNaziv());
		contentPane.add(getTxtSrednji());
		contentPane.add(getTxtSkraceni());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
		setResizable(false);
		setVisible(true);
	}
	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
			lblSifra.setPreferredSize(new Dimension(130, 14));
		}
		return lblSifra;
	}
	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
			lblNaziv.setPreferredSize(new Dimension(130, 14));
		}
		return lblNaziv;
	}
	private JTextField getTxtSifra() {
		if (txtSifra == null) {
			txtSifra = new JTextField();
			txtSifra.setPreferredSize(new Dimension(130, 20));
			txtSifra.setColumns(16);
		}
		return txtSifra;
	}
	private JTextField getTxtNaziv() {
		if (txtNaziv == null) {
			txtNaziv = new JTextField();
			txtNaziv.setPreferredSize(new Dimension(130, 20));
			txtNaziv.setColumns(16);
		}
		return txtNaziv;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni Kurs");
			lblProdajniKurs.setPreferredSize(new Dimension(130, 14));
		}
		return lblProdajniKurs;
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni Kurs");
			lblKupovniKurs.setPreferredSize(new Dimension(130, 14));
		}
		return lblKupovniKurs;
	}
	private JTextField getTxtProdajni() {
		if (txtProdajni == null) {
			txtProdajni = new JTextField();
			txtProdajni.setColumns(16);
		}
		return txtProdajni;
	}
	private JTextField getTxtKupovni() {
		if (txtKupovni == null) {
			txtKupovni = new JTextField();
			txtKupovni.setColumns(16);
		}
		return txtKupovni;
	}
	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji Kurs");
			lblSrednjiKurs.setPreferredSize(new Dimension(130, 14));
		}
		return lblSrednjiKurs;
	}
	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni Naziv");
			lblSkraceniNaziv.setPreferredSize(new Dimension(130, 14));
		}
		return lblSkraceniNaziv;
	}
	private JTextField getTxtSrednji() {
		if (txtSrednji == null) {
			txtSrednji = new JTextField();
			txtSrednji.setColumns(16);
		}
		return txtSrednji;
	}
	private JTextField getTxtSkraceni() {
		if (txtSkraceni == null) {
			txtSkraceni = new JTextField();
			txtSkraceni.setColumns(16);
		}
		return txtSkraceni;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnOdustani.setPreferredSize(new Dimension(135, 30));
		}
		return btnOdustani;
	}
	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!GUIKontroler.dodajKurs(txtNaziv.getText(), txtSifra.getText(), txtSkraceni.getText(), txtProdajni.getText(), txtSrednji.getText(), txtKupovni.getText())){
						JOptionPane.showMessageDialog(null, "Neispravno popunjena forma!", "Greska", JOptionPane.ERROR_MESSAGE);
					}else{
						String status = txtSifra.getText() + " "+ txtNaziv.getText() +" "+ txtSkraceni.getText() +" "+ txtProdajni.getText() +" "+ txtSrednji.getText() +" "+ txtKupovni.getText();
						GUIKontroler.dodajTekstStatus(status);
						JOptionPane.showMessageDialog(null, "Uspesno dodat kurs!", "Dodavanje", JOptionPane.INFORMATION_MESSAGE );
						txtNaziv.setText("");
						txtSifra.setText("");
						txtSkraceni.setText(""); 
						txtProdajni.setText("");
						txtSrednji.setText("");
						txtKupovni.setText("");
						GUIKontroler.osveziTabelu();
					}
				}
			});
			btnDodaj.setPreferredSize(new Dimension(135, 30));
		}
		return btnDodaj;
	}
}
