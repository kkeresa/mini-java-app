import java.awt.BorderLayout;
import java.io.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.html.ParagraphView;



import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class ZvijezdePjevaju extends JFrame {

	private JPanel contentPane;
	private JTextField par;
	private JTextField bodovi;
	private JTextField search;
	private JTable tablica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZvijezdePjevaju frame = new ZvijezdePjevaju();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ZvijezdePjevaju() {
		setTitle("Evidencija pobjednika showa Zvijezde pjevaju");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EVIDENCIJA POBJEDNIKA SHOWA");
		lblNewLabel.setForeground(new Color(51, 51, 51));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(10, 11, 561, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ZVIJEZDE PJEVAJU");
		lblNewLabel_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 33, 561, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Imena pobjednickog para:");
		lblNewLabel_2.setForeground(new Color(51, 51, 51));
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2.setBounds(42, 65, 193, 21);
		contentPane.add(lblNewLabel_2);
		
		par = new JTextField();
		par.setFont(new Font("Arial", Font.PLAIN, 12));
		par.setBackground(new Color(245, 245, 245));
		par.setBounds(245, 65, 184, 20);
		contentPane.add(par);
		par.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Godina emitiranja emisija:");
		lblNewLabel_2_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(42, 97, 193, 21);
		contentPane.add(lblNewLabel_2_1);
		
		bodovi = new JTextField();
		bodovi.setFont(new Font("Arial", Font.PLAIN, 12));
		bodovi.setColumns(10);
		bodovi.setBackground(new Color(245, 245, 245));
		bodovi.setBounds(245, 130, 77, 20);
		contentPane.add(bodovi);
		
		bodovi.addKeyListener(new KeyAdapter() {
	         public void keyTyped(KeyEvent e) {
	             char c = e.getKeyChar();
	             if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
	                  e.consume();
	             }
	         }
	      });
		
		JComboBox godinaCombo = new JComboBox();
		godinaCombo.setModel(new DefaultComboBoxModel(new String[] {"2007.", "2008.", "2009.", "2010.", "2011.", "2012.", "2014.", "2019.", "2020.", "2022."}));
		godinaCombo.setFont(new Font("Arial", Font.PLAIN, 13));
		godinaCombo.setBounds(245, 97, 77, 22);
		contentPane.add(godinaCombo);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Broj bodova u finalu:");
		lblNewLabel_2_1_1.setForeground(new Color(51, 51, 51));
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(42, 129, 193, 21);
		contentPane.add(lblNewLabel_2_1_1);
		
		JButton UPIS = new JButton("UPIS");
		UPIS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(par.getText().equals("") || bodovi.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Molim popunite sva polja!");
					}
				else {
					JOptionPane.showMessageDialog(null, "Uspjesan upis.");
					String data[]= {par.getText(), godinaCombo.getSelectedItem().toString(),  bodovi.getText()};
					DefaultTableModel table=(DefaultTableModel) tablica.getModel();
					table.addRow(data);}
					}}
		
		);
		UPIS.setForeground(new Color(51, 51, 51));
		UPIS.setBackground(UIManager.getColor("Button.background"));
		UPIS.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		UPIS.setBounds(439, 97, 89, 53);
		contentPane.add(UPIS);
		
		JButton BRISANJE = new JButton("BRISANJE");
		BRISANJE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel table=(DefaultTableModel)tablica.getModel();
				
				if(tablica.getSelectedRowCount()==1)
					table.removeRow(tablica.getSelectedRow());
				else if(table.getRowCount()==0)
					JOptionPane.showMessageDialog(null, "Nema podataka za brisanje.");
				else
					JOptionPane.showMessageDialog(null, "Molim oznacite sto zelite obrisati!");
				
			}
		});
		BRISANJE.setForeground(new Color(51, 51, 51));
		BRISANJE.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		BRISANJE.setBackground(UIManager.getColor("Button.background"));
		BRISANJE.setBounds(415, 314, 113, 53);
		contentPane.add(BRISANJE);
		
		JButton SEARCH = new JButton("TRAZI");
		SEARCH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				{
					 DefaultTableModel model=(DefaultTableModel)tablica.getModel();
					 TableRowSorter<DefaultTableModel> tr= new TableRowSorter<DefaultTableModel>(model);
					 tablica.setRowSorter(tr);
					 tr.setRowFilter(RowFilter.regexFilter(search.getText().trim()));
					}
				
			}
		});
		SEARCH.setForeground(new Color(51, 51, 51));
		SEARCH.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		SEARCH.setBackground(UIManager.getColor("Button.background"));
		SEARCH.setBounds(42, 340, 127, 27);
		contentPane.add(SEARCH);
		
		search = new JTextField();
		search.setFont(new Font("Arial", Font.PLAIN, 12));
		search.setColumns(10);
		search.setBackground(new Color(245, 245, 245));
		search.setBounds(42, 314, 127, 20);
		contentPane.add(search);
		
		JButton uDatoteku = new JButton("UPIS U DATOTEKU");
		uDatoteku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					File datoteka = new File("C:\\Users\\Katarina\\try-2\\Projekt_KatarinaKeresa\\pobjednici.txt");
					
					if(datoteka.createNewFile())
						JOptionPane.showMessageDialog(null, "Uspjesan upis u novu datoteku.");
					else
						JOptionPane.showMessageDialog(null, "Uspjesan upis u datoteku.");
					
					FileWriter dat = new FileWriter(datoteka.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(dat);
		               
		            for(int i = 0; i < tablica.getRowCount(); i++) {
		            	for(int j = 0; j < tablica.getColumnCount(); j++){
		            		bw.write(tablica.getModel().getValueAt(i, j)+";");
		            	}
		            	bw.write("\n");
		               }
		               	bw.close();
		        
				}
				catch(IOException e1){
					JOptionPane.showMessageDialog(null, "Dogodila se greska.");
				}
				
			}
		});
		uDatoteku.setForeground(new Color(51, 51, 51));
		uDatoteku.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		uDatoteku.setBackground(UIManager.getColor("Button.background"));
		uDatoteku.setBounds(42, 378, 486, 27);
		contentPane.add(uDatoteku);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 164, 486, 139);
		contentPane.add(scrollPane);
		
		tablica = new JTable();
		scrollPane.setViewportView(tablica);
		tablica.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Imena para", "Godina", "Bodovi"
			}
		));
		
		JButton izDatoteke = new JButton("POVUCI PODATKE IZ DATOTEKE");
		izDatoteke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser odabir = new JFileChooser();
			      	odabir.showOpenDialog(null);
			      	File fileImport = odabir.getSelectedFile();
			      	String datoteka = fileImport.getAbsolutePath();
			      	DefaultTableModel tablicas = (DefaultTableModel)tablica.getModel();
				
				
				try {
					BufferedReader br = new BufferedReader(new FileReader (datoteka));
					String prviRedak=br.readLine();
					
					if(prviRedak!=null) {
					String columns[]=prviRedak.split(";");
				
					Object [] retci = br.lines().toArray();
					
					for(int i=0; i<retci.length; i++) {
						String redak=retci[i].toString();
						String [] redakTablice=redak.split(";");
						tablicas.addRow(redakTablice);
					}}
					else {
						JOptionPane.showMessageDialog(null, "Odabrana datoteka je prazna.");
					}
						}
					
					catch(IOException e2) {
						JOptionPane.showMessageDialog(null, "Dogodila se greska.");					}
				}
				
			
		});
		izDatoteke.setForeground(new Color(51, 51, 51));
		izDatoteke.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		izDatoteke.setBackground(UIManager.getColor("Button.background"));
		izDatoteke.setBounds(42, 416, 486, 27);
		contentPane.add(izDatoteke);
		tablica.getColumnModel().getColumn(0).setPreferredWidth(200);
		tablica.getColumnModel().getColumn(0).setMinWidth(100);
	}
}
