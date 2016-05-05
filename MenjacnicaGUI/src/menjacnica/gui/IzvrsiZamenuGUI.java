package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import menjacnica.kontroler.GUIKontroler;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JButton;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField txtKupovni;
	private JComboBox comboBox;
	private JTextField txtProdajni;
	private JLabel lblIznos;
	private JLabel lblVrstaTransakcije;
	private JTextField txtIznos;
	private JRadioButton rdbtnKupovina;
	private JRadioButton rdbtnProdaja;
	private ButtonGroup vrstaTransakcije;
	private JSlider slider;
	private JButton btnIzvrsiZamenu;
	private JButton btnOdustani;

	public IzvrsiZamenuGUI() {
		setResizable(false);
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getTxtKupovni());
		contentPane.add(getComboBox());
		contentPane.add(getTxtProdajni());
		contentPane.add(getLblIznos());
		contentPane.add(getLblVrstaTransakcije());
		contentPane.add(getTxtIznos());
		contentPane.add(getRdbtnKupovina());
		contentPane.add(getRdbtnProdaja());
		contentPane.add(getSlider());
		contentPane.add(getBtnIzvrsiZamenu());
		contentPane.add(getBtnOdustani());
		getVrstaTransakcije();
		setVisible(true);
	}

	private ButtonGroup getVrstaTransakcije() {
		if (vrstaTransakcije == null) {
			vrstaTransakcije = new ButtonGroup();
			vrstaTransakcije.add(getRdbtnKupovina());
			vrstaTransakcije.add(getRdbtnProdaja());
		}
		return vrstaTransakcije;
	}

	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(305, 11, 83, 14);
		}
		return lblProdajniKurs;
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(30, 11, 92, 14);
		}
		return lblKupovniKurs;
	}

	private JTextField getTxtKupovni() {
		if (txtKupovni == null) {
			txtKupovni = new JTextField();
			txtKupovni.setEditable(false);
			txtKupovni.setBounds(30, 38, 115, 20);
			txtKupovni.setColumns(10);
		}
		return txtKupovni;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.addItem("EUR");
			comboBox.addItem("USD");
			comboBox.addItem("CHF");
			// comboBox.setSelectedItem("EUR");
			// comboBox.setSelectedIndex(0);
			comboBox.setBounds(188, 38, 63, 20);
		}
		return comboBox;
	}

	private JTextField getTxtProdajni() {
		if (txtProdajni == null) {
			txtProdajni = new JTextField();
			txtProdajni.setEditable(false);
			txtProdajni.setBounds(305, 38, 115, 20);
			txtProdajni.setColumns(10);
		}
		return txtProdajni;
	}

	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setBounds(30, 79, 46, 14);
		}
		return lblIznos;
	}

	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
			lblVrstaTransakcije.setBounds(305, 79, 115, 14);
		}
		return lblVrstaTransakcije;
	}

	private JTextField getTxtIznos() {
		if (txtIznos == null) {
			txtIznos = new JTextField();
			txtIznos.setBounds(30, 105, 141, 20);
			txtIznos.setColumns(10);
		}
		return txtIznos;
	}

	private JRadioButton getRdbtnKupovina() {
		if (rdbtnKupovina == null) {
			rdbtnKupovina = new JRadioButton("Kupovina");
			rdbtnKupovina.setBounds(305, 104, 109, 23);
			// vrstaTransakcije.add(rdbtnKupovina);
		}
		return rdbtnKupovina;
	}

	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			rdbtnProdaja.setBounds(305, 139, 109, 23);
			// vrstaTransakcije.add(rdbtnProdaja);
		}
		return rdbtnProdaja;
	}

	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent arg0) {
					JSlider source = (JSlider)arg0.getSource();
					txtIznos.setText("" + source.getValue());

				}
			});
			slider.setPaintLabels(true);
			slider.setPaintTicks(true);
			slider.setMinorTickSpacing(5);
			slider.setMajorTickSpacing(10);
			slider.setBounds(97, 182, 243, 34);
			slider.setMaximum(100);
			slider.setMinimum(0);

		}
		return slider;
	}

	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String vrstaTrans = "";
					if(rdbtnKupovina.isSelected())
						vrstaTrans = vrstaTrans + "Kupovina";
					else if(rdbtnProdaja.isSelected())
						vrstaTrans = vrstaTrans + "Prodaja";
					else{
						//moguc je i slucaj da nista nije selektovano
					}	
					GUIKontroler.dodajTekstStatus(vrstaTrans+" valute " + comboBox.getSelectedItem()+" u iznosu od : "+txtIznos.getText());
				}
			});
			btnIzvrsiZamenu.setBounds(30, 237, 115, 23);
		}
		return btnIzvrsiZamenu;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.setBounds(305, 237, 115, 23);
			btnOdustani.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					dispose();

				}
			});
		}
		return btnOdustani;
	}
}
