package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import menjacnica.gui.model.MenjacnicaTableModel;
import menjacnica.kontroler.GUIKontroler;
import menjacnica.logika.Kurs;

import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class MenjacnicaGUI extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JScrollPane panelCenter;
	private JTable table;
	private JPanel panelEast;
	private JMenuItem mntmAbout;
	private JScrollPane scrollPaneSouth;
	private JTextArea textAreaSouth;
	private JButton btnDodajKurs;
	private JButton btnIzbrisiKurs;
	private JButton btnIzvrsiZamenu;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmIzbrisiKurs;
	private JMenuItem mntmIzvrsiZamenu;
	private JPopupMenu tablePopup;
	

	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.izadji();
			}

		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenjacnicaGUI.class.getResource("/menjacnica/gui/shiny-gold-dollar-sign.jpg")));
		setTitle("Menjacnica");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 516, 361);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelCenter(), BorderLayout.CENTER);
		contentPane.add(getPanelEast(), BorderLayout.EAST);
		contentPane.add(getScrollPaneSouth(), BorderLayout.SOUTH);
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}
	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}
	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.ucitajFajl();
				}
			});
			mntmOpen.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		}
		return mntmOpen;
	}
	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.setIcon(new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.ucitajUFajl();
					
				}
			});
		}
		return mntmSave;
	}
	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
			
			mntmExit.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.izadji();
					
				}
			});
		}
		return mntmExit;
	}
	private JScrollPane getPanelCenter() {
		if (panelCenter == null) {
			panelCenter = new JScrollPane();
			panelCenter.setViewportView(getTable());
		}
		return panelCenter;
	}
	private JTable getTable() {
		if (table == null) {
			MenjacnicaTableModel model = new MenjacnicaTableModel(GUIKontroler.getListaKurseva());
			table = new JTable(model);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					tablePopup.show(table, 0, 0);
				}
			});
			table.setShowGrid(true);
			table.setShowVerticalLines(true);
			table.setModel(model);
			table.setVisible(true);
			table.getTableHeader().setVisible(true);
			
			tablePopup = getTablePopup();
			table.setComponentPopupMenu(tablePopup);
		}
		return table;
	}
	private JPopupMenu getTablePopup() {
		if(tablePopup == null){
			tablePopup = new JPopupMenu();
			
			tablePopup.setVisible(true);
			tablePopup.add(getMntmDodajKurs());
			tablePopup.add(getMntmIzbrisiKurs());
			tablePopup.add(getMntmIzvrsiZamenu());
			
		}
		return tablePopup;
	}

	private JPanel getPanelEast() {
		if (panelEast == null) {
			panelEast = new JPanel();
			panelEast.setPreferredSize(new Dimension(125, 10));
			panelEast.add(getBtnDodajKurs());
			panelEast.add(getBtnIzbrisiKurs());
			panelEast.add(getBtnIzvrsiZamenu());
		}
		return panelEast;
	}
	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.prikaziPodatkeOAutoru();
					
				}
			});
		}
		return mntmAbout;
	}
	private JScrollPane getScrollPaneSouth() {
		if (scrollPaneSouth == null) {
			scrollPaneSouth = new JScrollPane();
			scrollPaneSouth.setPreferredSize(new Dimension(2, 60));
			scrollPaneSouth.setViewportView(getTextAreaSouth());
			
		}
		return scrollPaneSouth;
	}
	private JTextArea getTextAreaSouth() {
		if (textAreaSouth == null) {
			textAreaSouth = new JTextArea();
			textAreaSouth.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Status", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
			
		}
		return textAreaSouth;
	}
	private JButton getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj Kurs");
			btnDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					DodajKursGUI prozor = new DodajKursGUI();
//					prozor.setPreferredSize(new Dimension(300, 220));
//					prozor.setVisible(true);
					
				}
			});
			btnDodajKurs.setMinimumSize(new Dimension(99, 23));
			btnDodajKurs.setMaximumSize(new Dimension(99, 23));
			btnDodajKurs.setPreferredSize(new Dimension(110, 23));
		}
		return btnDodajKurs;
	}
	private JButton getBtnIzbrisiKurs() {
		if (btnIzbrisiKurs == null) {
			btnIzbrisiKurs = new JButton("Izbrisi Kurs");
			btnIzbrisiKurs.setMinimumSize(new Dimension(99, 23));
			btnIzbrisiKurs.setMaximumSize(new Dimension(99, 23));
			btnIzbrisiKurs.setPreferredSize(new Dimension(110, 23));
		}
		return btnIzbrisiKurs;
	}
	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi Zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnIzvrsiZamenu.setPreferredSize(new Dimension(110, 23));
			btnIzvrsiZamenu.setMinimumSize(new Dimension(99, 23));
			btnIzvrsiZamenu.setMaximumSize(new Dimension(99, 23));
		}
		return btnIzvrsiZamenu;
	}
	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj Kurs");
			mntmDodajKurs.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					mntmDodajKurs.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							DodajKursGUI prozor = new DodajKursGUI();
//							table.getSelectionModel().clearSelection();
//							GUIKontroler.dodajKursOtvoriProzor();

						}
					});
					
				}
			});
		}
		return mntmDodajKurs;
	}
	private JMenuItem getMntmIzbrisiKurs() {
		if (mntmIzbrisiKurs == null) {
			mntmIzbrisiKurs = new JMenuItem("Izbrisi Kurs");
			mntmIzbrisiKurs.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		return mntmIzbrisiKurs;
	}
	private JMenuItem getMntmIzvrsiZamenu() {
		if (mntmIzvrsiZamenu == null) {
			mntmIzvrsiZamenu = new JMenuItem("Izvrsi Zamenu");
			mntmIzvrsiZamenu.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		}
		return mntmIzvrsiZamenu;
	}
	
	public void dodajTekstStatus(String txt){
		if(txt != null)
			textAreaSouth.setText(textAreaSouth.getText()+txt+"\n");
	}

	public void osveziTabelu(List<Kurs> kursevi) {
		MenjacnicaTableModel model = (MenjacnicaTableModel)table.getModel();
		model.osveziTabelu(kursevi);
	}
}
