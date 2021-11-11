import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
public class GS extends JPanel{
	//=====Panels in the GasPanel====
	JPanel GasPanel;
	JPanel LeftGasPanel;
	JPanel PumpPanel;
	JPanel BuyGasPanel;
	JLabel pump1;
	JLabel pump2;
	JLabel pump3;
	JLabel pump4;
	JButton p1Start;
	JButton p2Start;
	JButton p3Start;
	JButton p4Start;
	JButton p1End;
	JButton p2End;
	JButton p3End;
	JButton p4End;
	JTextField p1total;
	JTextField p2total;
	JTextField p3total;
	JTextField p4total;
	JButton p1addCart;
	JButton p2addCart;
	JButton p3addCart;
	JButton p4addCart;
	JButton p1clear;
	JButton p2clear;
	JButton p3clear;
	JButton p4clear;
	JLabel TotalLeftGas;
	JTextField leftGasTf;
	JLabel GallonLB;
	JButton Buy50G;
	JButton Buy100G;
	JButton Buy150G;
	JLabel p1;
	JLabel p2;
	JLabel p3;
	JLabel p4;
	JLabel chart;
	//=====Components in the StorePanel====
	JPanel StorePanel;
	JPanel ItemPanel;
	JPanel CounterPanel;
	JPanel MoneyPanel;
	JPanel CbuttonsPanel;
	JTextArea cart;
	JLabel totalCounter;
	JTextField price;
	JButton noReceipt;
	JButton receipt;
	JButton clear;
	JLabel moneyInCounter;
	JTextField counterPrice;
	JPanel waterPanel;
	JPanel cokePanel;
	JPanel cigarPanel;
	JPanel cheeotsPanel;
	JButton waterBT;
	JButton cokeBT;
	JButton cheetosBT;
	JButton cigarettesBT;
	JButton waterPlus;
	JButton cokePlus;
	JButton cheetosPlus;
	JButton cigarettesPlus;
	JLabel waterLeft;
	JTextField waterTF;
	JLabel cokeLeft;
	JTextField cokeTF;
	JLabel cigarLeft;
	JTextField cigarTF;
	JLabel cheetosLeft;
	JTextField cheetosTF;
	Font bigfont;
	double cartTotal = 0;
	double totalCounterMny = 0;
	double regGasPrice = 3.56;
	double Gas50gal = 50 * (regGasPrice-1.50);
	double Gas100gal = 100 * (regGasPrice-1.50);
	double Gas150gal = 150 * (regGasPrice-1.50);
	double leftGasGal = 700;
	//width of rectangles 
	int w1 = 200;
	int w2 = 150;
	int w3 = 180;
	int w4 = 200;
	GS(){
		createComp();
		writeComp();
	}
	void createComp() {
		setLayout(new BorderLayout());
		//=====Create Components======
		StorePanel = new JPanel();
		GasPanel = new JPanel();
		LeftGasPanel = new JPanel();
		PumpPanel = new JPanel();
		BuyGasPanel = new JPanel();
		ItemPanel = new JPanel();
		CounterPanel = new JPanel();
		waterPanel = new JPanel();
		cokePanel = new JPanel();
		cigarPanel = new JPanel();
		cheeotsPanel = new JPanel();
		MoneyPanel = new JPanel();
		CbuttonsPanel = new JPanel();
		//components in the GasPanel
		chart = new JLabel("         |0|=======|100|=======|200|"
				+ "=======|300|=======|400|=======|500|");
		p1 = new JLabel("P1: ");
		p2 = new JLabel("P2: ");
		p3 = new JLabel("P3: ");
		p4 = new JLabel("P4: ");
		pump1 = new JLabel("pump1: ");
		pump2 = new JLabel("pump2: ");
		pump3 = new JLabel("pump3: ");
		pump4 = new JLabel("pump4: ");
		p1Start = new JButton("Start");
		p2Start = new JButton("Start");
		p3Start = new JButton("Start");
		p4Start = new JButton("Start");
		p1End = new JButton("End");
		p2End = new JButton("End");
		p3End = new JButton("End");
		p4End = new JButton("End");
		p1total = new JTextField("0.00");
		p2total = new JTextField("0.00");
		p3total = new JTextField("0.00");
		p4total = new JTextField("0.00");
		p1total.setEditable(false);
		p2total.setEditable(false);
		p3total.setEditable(false);
		p4total.setEditable(false);
		p1addCart = new JButton("Add Cart");
		p2addCart = new JButton("Add Cart");
		p3addCart = new JButton("Add Cart");
		p4addCart = new JButton("Add Cart");
		p1clear = new JButton("Clear");
		p2clear = new JButton("Clear");
		p3clear = new JButton("Clear");
		p4clear = new JButton("Clear");
		bigfont = new Font("Consolas", Font.PLAIN, 18);
		//components in the StorePanel
		cart = new JTextArea(8,50);
		cart.setEditable(false);
		cart.setFont(bigfont);
		totalCounter = new JLabel("Total: $");
		totalCounter.setFont(bigfont);
		moneyInCounter = new JLabel("    Counter: $");	
		moneyInCounter.setFont(bigfont);
		price = new JTextField("0.00");
		price.setFont(bigfont);
		price.setColumns(7);	//set width
		price.setEditable(false);
		counterPrice = new JTextField("0.00");
		counterPrice.setFont(bigfont);
		counterPrice.setColumns(10);	//set width
		counterPrice.setEnabled(false);
		MoneyPanel.add(totalCounter);
		MoneyPanel.add(price);
		MoneyPanel.add(moneyInCounter);
		MoneyPanel.add(counterPrice);
		noReceipt = new JButton("No Receipt");
		receipt = new JButton("Receipt");
		clear = new JButton("Clear");
		CbuttonsPanel.setLayout(new GridLayout(1,3));
		CbuttonsPanel.add(noReceipt);
		CbuttonsPanel.add(receipt);
		CbuttonsPanel.add(clear);
		JScrollPane scrollPane = new JScrollPane(cart);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.
				VERTICAL_SCROLLBAR_ALWAYS);
		CounterPanel.add(scrollPane);
		CounterPanel.add(MoneyPanel);
		CounterPanel.add(CbuttonsPanel);
		TotalLeftGas = new JLabel("Total left gas:");
		leftGasTf = new JTextField(String.valueOf(leftGasGal));
		leftGasTf.setEditable(false);
		GallonLB = new JLabel("gallon");
		Buy50G = new JButton("+50 Gallon: $"+ Gas50gal);
		Buy100G = new JButton("+100 Gallon: $" + Gas100gal);
		Buy150G = new JButton("+150 Gallon: $" + Gas150gal);
		//GasPanel: LeftGasPanel, PumpPanel and BuyGas panel
		GasPanel.setLayout(new GridLayout(3,1));
		GasPanel.setBorder(BorderFactory.createTitledBorder("Gas"));
		LeftGasPanel.setBorder(BorderFactory.createTitledBorder(
				"The Amount of Left Gas  / "+ "  Regualr price: $3.56 "));
		LeftGasPanel.setLayout(new GridLayout(5,1));
		LeftGasPanel.add(chart);
		LeftGasPanel.add(p1);
		LeftGasPanel.add(p2);
		LeftGasPanel.add(p3);
		LeftGasPanel.add(p4);
		PumpPanel.setBorder(BorderFactory.createTitledBorder("Pumps"));
		BuyGasPanel.setBorder(BorderFactory.createTitledBorder(
				"Buy More Gas"));
		BuyGasPanel.setLayout(new GridLayout(2,3));
		//Components in the PumpPanel
		PumpPanel.setLayout(new GridLayout(4,1));
		PumpPanel.add(pump1);
		PumpPanel.add(p1Start);
		PumpPanel.add(p1End);	
		PumpPanel.add(p1total);
		PumpPanel.add(p1addCart);
		PumpPanel.add(p1clear);
		PumpPanel.add(pump2);
		PumpPanel.add(p2Start);
		PumpPanel.add(p2End);
		PumpPanel.add(p2total);
		PumpPanel.add(p2addCart);
		PumpPanel.add(p2clear);
		PumpPanel.add(pump3);
		PumpPanel.add(p3Start);
		PumpPanel.add(p3End);
		PumpPanel.add(p3total);
		PumpPanel.add(p3addCart);
		PumpPanel.add(p3clear);
		PumpPanel.add(pump4);
		PumpPanel.add(p4Start);
		PumpPanel.add(p4End);
		PumpPanel.add(p4total);
		PumpPanel.add(p4addCart);
		PumpPanel.add(p4clear);
		BuyGasPanel.add(TotalLeftGas);
		BuyGasPanel.add(leftGasTf);
		BuyGasPanel.add(GallonLB);
		BuyGasPanel.add(Buy50G);
		BuyGasPanel.add(Buy100G);
		BuyGasPanel.add(Buy150G);
		GasPanel.add(LeftGasPanel);
		GasPanel.add(PumpPanel);
		GasPanel.add(BuyGasPanel);
		//==========ItemPanel=========
		StorePanel.setLayout(new GridLayout(2,1));
		StorePanel.setBorder(BorderFactory.createTitledBorder("Store"));
		ItemPanel.setBorder(BorderFactory.createTitledBorder("Items"));
		ItemPanel.setLayout(new GridLayout(2,2));
		CounterPanel.setBorder(BorderFactory.createTitledBorder("Counter"));
		CounterPanel.setLayout(new GridLayout(3,1));
		waterPanel.setBorder(BorderFactory.createTitledBorder("Water"));
		cokePanel.setBorder(BorderFactory.createTitledBorder("Coke"));
		cigarPanel.setBorder(BorderFactory.createTitledBorder("Cigarettes"));
		cheeotsPanel.setBorder(BorderFactory.createTitledBorder("Cheetos")); 
		Image water = null;
		String urlstr = "https://i.imgur.com/uaYXNP9.jpg";
		water = readImage(water,urlstr);
		//add image to the item buttons
		waterBT = new JButton(new ImageIcon(water));
		waterLeft = new JLabel("Left: ");	
		waterTF = new JTextField("5");
		waterTF.setColumns(2);
		waterTF.setEditable(false);
		waterPlus = new JButton("+");
		waterPanel.add(waterBT);
		waterPanel.add(waterLeft);
		waterPanel.add(waterTF);
		waterPanel.add(waterPlus);
		Image coke = null;
		urlstr = "https://i.imgur.com/52vHUrp.jpg";
		coke = readImage(coke,urlstr);
		cokeBT = new JButton(new ImageIcon(coke));
		cokeLeft = new JLabel("Left: ");	
		cokeTF = new JTextField("5");
		cokeTF.setEditable(false);
		cokeTF.setColumns(2);
		cokePlus = new JButton("+");
		cokePanel.add(cokeBT);
		cokePanel.add(cokeLeft);
		cokePanel.add(cokeTF);
		cokePanel.add(cokePlus);
		Image cigar = null;
		urlstr = "https://i.imgur.com/uOUKX8U.jpg";
		cigar = readImage(cigar,urlstr);
		cigarettesBT = new JButton(new ImageIcon(cigar));
		cigarLeft = new JLabel("Left: ");	
		cigarTF = new JTextField("10");
		cigarTF.setEditable(false);
		cigarTF.setColumns(2);
		cigarettesPlus = new JButton("+");
		cigarPanel.add(cigarettesBT);
		cigarPanel.add(cigarLeft);
		cigarPanel.add(cigarTF);
		cigarPanel.add(cigarettesPlus);
		Image cheetos = null;
		urlstr = "https://i.imgur.com/2GvlP4M.jpg";
		cheetos = readImage(cheetos,urlstr);
		cheetosBT = new JButton(new ImageIcon(cheetos));
		cheetosLeft = new JLabel("Left: ");	
		cheetosTF = new JTextField("10");
		cheetosTF.setEditable(false);
		cheetosTF.setColumns(2);
		cheetosPlus = new JButton("+");
		cheeotsPanel.add(cheetosBT);
		cheeotsPanel.add(cheetosLeft);
		cheeotsPanel.add(cheetosTF);
		cheeotsPanel.add(cheetosPlus);
		ItemPanel.add(waterPanel);
		ItemPanel.add(cokePanel);
		ItemPanel.add(cigarPanel);
		ItemPanel.add(cheeotsPanel);
		StorePanel.add(ItemPanel);
		StorePanel.add(CounterPanel);
		add(StorePanel,BorderLayout.WEST);
		add(GasPanel,BorderLayout.EAST);
		this.setLayout(new GridLayout(1,2));
	}
	void writeComp() {
		//=========== button Listener==============
		class MyPlusListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				//plus button for water
				if(e.getSource() == waterPlus) {
					if(buyMoreItem("Water")) {
						addStock(waterTF,waterBT);
					}
				}
				//plus button for coke
				else if(e.getSource() == cokePlus) {
					if(buyMoreItem("Coke")) {
						addStock(cokeTF,cokeBT);
					}
				}
				//plus button for cigar
				else if(e.getSource() == cigarettesPlus) {
					if(buyMoreItem("Cigarettes")) {
						addStock(cigarTF,cigarettesBT);
					}
				}
				//plus button for Cheetos
				else {
					if(buyMoreItem("Cheetos")) {
						addStock(cheetosTF,cheetosBT);
					}
				}	
			}
		}
		MyPlusListener BTLis = new MyPlusListener();
		waterPlus.addActionListener(BTLis);
		cokePlus.addActionListener(BTLis);
		cigarettesPlus.addActionListener(BTLis);
		cheetosPlus.addActionListener(BTLis);
		//=========Image Button==========
		class ImageButtonListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				//water image button is clicked
				if(e.getSource()==waterBT) {
					sellItem("Water",waterTF,waterBT);
				}
				//coke image button is clicked
				else if(e.getSource() == cokeBT) {
					sellItem("Coke",cokeTF,cokeBT);
				}
				//cigar image button is clicked
				else if(e.getSource() == cigarettesBT) {
					sellItem("Cigarettes",cigarTF,cigarettesBT);
				}
				//cheetos image button is clicked
				else if(e.getSource() == cheetosBT) {
					sellItem("Cheetos",cheetosTF,cheetosBT);		
				}
			}
		}
		ImageButtonListener imageLis = new ImageButtonListener();
		waterBT.addActionListener(imageLis);
		cokeBT.addActionListener(imageLis);
		cigarettesBT.addActionListener(imageLis);
		cheetosBT.addActionListener(imageLis);
		//======ClearBT in Counter=======
		class CounterClearBTLister implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				clearCounter();
			}
		}
		CounterClearBTLister clearLis = new CounterClearBTLister();
		clear.addActionListener(clearLis);
		//======Receipt =======
		class ReceiptBTLister implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				//if receipt button is clicked
				if(e.getSource() == receipt) {
					outReceipt();
				}
				//add cartTotal to counter total money
				totalCounterMny += cartTotal;
				counterPrice.setText(String.format
						("%.2f",totalCounterMny));
				clearCounter();
			}
		}
		ReceiptBTLister recLis = new ReceiptBTLister();
		receipt.addActionListener(recLis);
		noReceipt.addActionListener(recLis);
		//======Buy more Gas =======
		class BuyGasBTLister implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				//buying 50 more gallons
				if(e.getSource() == Buy50G) {
					buyMoreGas(Gas50gal);
				}
				//buying 100 more gallons
				else if(e.getSource() == Buy100G) {
					buyMoreGas(Gas100gal);
				}
				//buying 150 more gallons
				else {
					buyMoreGas(Gas150gal);
				}
			}
		}
		BuyGasBTLister buyGasLis = new BuyGasBTLister();
		Buy50G.addActionListener(buyGasLis);
		Buy100G.addActionListener(buyGasLis);
		Buy150G.addActionListener(buyGasLis);
		//======Start&End Button======
		class P1Listner implements ActionListener{
			long p1start;	//start time
			long p1end;		//end time
			boolean startTimerTask = false;
			@Override
			public void actionPerformed(ActionEvent e){
				Timer m_timer = new Timer();
				TimerTask m_task = new TimerTask() {
					@Override
					public void run() {
						if(startTimerTask == true) {
							//if there's no left gas / width is 0
							if(w1 == 0) {
								m_timer.cancel();	//stop timer
								//show pop up box
								JOptionPane.showMessageDialog(null, 
										"no more gas to fuel");
								//get fueled gas price
								calculateGasPrice(p1total,p1start,p1end);
								setEnabled(p1Start,p1End);
								p1start = 0;
								p1end = 0;
								return;
							}
							else {
								w1--;		//gas(width) is decreasing 
								repaint();	//drawing amount of left gas
							}
						}
					}
				};
				//start button && when it is not fueling already
				if(e.getSource() == p1Start && p1end == 0 && p1total.getText().equals("0.00")) {
					startTimerTask = true;
					p1start = System.currentTimeMillis();
					//gas decreases 1 gallon per 1 second
					m_timer.schedule(m_task,0,1000);
				}
				//end button && when it started to fuel
				else if(e.getSource() == p1End && p1start!=0) {
					startTimerTask = false;
					calculateGasPrice(p1total,p1start,p1end);
					p1start = 0;
					p1end = 0;
				}
				//end add Cart
				else if(e.getSource() == p1addCart) {
					//add it to cart and total if it's not 0.00
					if(Double.parseDouble(p1total.getText()) > 0.00) {
						cart.append("P1: " + p1total.getText() + '\n');
						addTotal(p1total);
					}
				}
			}
		}
		P1Listner p1Lis = new P1Listner();
		p1Start.addActionListener(p1Lis);
		p1End.addActionListener(p1Lis);
		p1addCart.addActionListener(p1Lis);
		//Pump2
		class P2BTLister implements ActionListener{
			long p2start;
			long p2end;
			boolean startTimerTask = false;
			@Override
			public void actionPerformed(ActionEvent e){
				Timer m_timer = new Timer();
				TimerTask m_task = new TimerTask() {
					@Override
					public void run() {
						if(startTimerTask == true) {
							if(w2 == 0) {
								m_timer.cancel();
								JOptionPane.showMessageDialog(null, 
										"no more gas to fuel");
								calculateGasPrice(p2total,p2start,p2end);
								setEnabled(p2Start,p2End);
								p2start = 0;
								p2end = 0;
								return;
							}else {
								w2--;
								repaint();
							}
						}
					}
				};
				if(e.getSource() == p2Start && p2end ==0&& p2total.getText().equals("0.00")) {
					startTimerTask = true;
					p2start = System.currentTimeMillis();
					m_timer.schedule(m_task,0,1000);
				}
				if(e.getSource()==p2End&& p2start!=0) {
					startTimerTask = false;
					calculateGasPrice(p2total,p2start,p2end);
					p2start = 0;
					p2end = 0;
				}
				else if(e.getSource() == p2addCart) {
					if(Double.parseDouble(p2total.getText()) > 0.00) {
						cart.append("P2: " + p2total.getText() + '\n');
						addTotal(p2total);
					}
				}
			}
		}
		P2BTLister p2Lis = new P2BTLister();
		p2Start.addActionListener(p2Lis);
		p2End.addActionListener(p2Lis);
		p2addCart.addActionListener(p2Lis);
		//Pump 3
		class P3BTLister implements ActionListener{
			long p3start;
			long p3end;
			boolean startTimerTask = false;
			@Override
			public void actionPerformed(ActionEvent e){
				Timer m_timer = new Timer();
				TimerTask m_task = new TimerTask() {
					@Override
					public void run() {
						if(startTimerTask == true) {
							if(w3 == 0) {
								m_timer.cancel();
								JOptionPane.showMessageDialog(null, 
										"no more gas to fuel");
								calculateGasPrice(p3total,p3start,p3end);
								setEnabled(p3Start,p3End);
								p3start = 0;
								p3end = 0;
								return;
							}else {
								w3--;
								repaint();
							}
						}
					}
				};
				if(e.getSource()==p3Start&& p3end ==0&& p3total.getText().equals("0.00")) {
					startTimerTask = true;
					p3start = System.currentTimeMillis();
					m_timer.schedule(m_task,0,1000);
				}
				if(e.getSource()==p3End&& p3start!=0) {
					startTimerTask = false;
					calculateGasPrice(p3total,p3start,p3end);
					p3start = 0;
					p3end = 0;
				}
				else if(e.getSource() == p3addCart) {
					if(Double.parseDouble(p3total.getText()) > 0.00) {
						cart.append("P3: " + p3total.getText() + '\n');
						addTotal(p3total);
					}
				}
			}
		}
		P3BTLister p3Lis = new P3BTLister();
		p3Start.addActionListener(p3Lis);
		p3End.addActionListener(p3Lis);
		p3addCart.addActionListener(p3Lis);
		//Pump4
		class P4BTLister implements ActionListener{
			long p4start;
			long p4end;
			boolean startTimerTask = false;
			@Override
			public void actionPerformed(ActionEvent e){
				Timer m_timer = new Timer();
				TimerTask m_task = new TimerTask() {
					@Override
					public void run() {
						if(startTimerTask == true) {
							if(w4 == 0) {
								m_timer.cancel();
								JOptionPane.showMessageDialog(null, 
										"no more gas to fuel");
								calculateGasPrice(p4total,p4start,p4end);
								setEnabled(p4Start,p4End);
								return;
							}else {
								w4--;
								repaint();
							}
						}
					}
				};
				if(e.getSource()==p4Start&& p4end ==0&& p4total.getText().equals("0.00")) {
					startTimerTask = true;
					p4start = System.currentTimeMillis();
					m_timer.schedule(m_task,0,1000);
				}
				if(e.getSource()==p4End&& p4start!=0) {
					startTimerTask = false;
					calculateGasPrice(p4total,p4start,p4end);
					p4start = 0;
					p4end = 0;
				}
				else if(e.getSource() == p4addCart) {
					if(Double.parseDouble(p4total.getText()) > 0.00) {
						cart.append("P4: " + p4total.getText() + '\n');
						addTotal(p4total);
					}
				}
			}
		}
		P4BTLister p4Lis = new P4BTLister();
		p4Start.addActionListener(p4Lis);
		p4End.addActionListener(p4Lis);
		p4addCart.addActionListener(p4Lis);
		//====Clear Gas=====
		class ClearBTLister implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e){
				if(e.getSource() == p1clear) {
					p1total.setText("0.00");
				}
				else if(e.getSource() == p2clear) {
					p2total.setText("0.00");
				}
				else if(e.getSource() == p3clear) {
					p3total.setText("0.00");
				}
				else {
					p4total.setText("0.00");
				}
			}
		}
		ClearBTLister clearBTLis = new ClearBTLister();
		p1clear.addActionListener(clearBTLis);
		p2clear.addActionListener(clearBTLis);
		p3clear.addActionListener(clearBTLis);
		p4clear.addActionListener(clearBTLis);
	}
	void outReceipt() {
		try {
			PrintWriter out = new PrintWriter("Receipt.txt");
			try {
				String cartText = cart.getText();
				//print receipt with items in teh cart and total
				out.printf(cartText);
				out.println("------------");
				out.print("total: " + cartTotal);
			}
			finally {
				out.close();
			}
		}
		catch(IOException exception) {
			exception.printStackTrace();
		}
	}
	double getItemPrice(String item) {
		double itemPrice = 0;
		try {
			File inputFile = new File("PriceList.txt");
			Scanner in = new Scanner(inputFile);
			try {
				while(in.hasNextLine()) {
					//delete existed text in the text area
					String line = in.nextLine();
					boolean found = false;
					//go through each character in line
					for (int i = 0; !found && i < line.length(); i++)
					{
						char ch = line.charAt(i);
						if (ch == ':')
						{	//found item with price after :
							if(item.equals(line.substring(0, i))){
								found = true;
								//get a price
								itemPrice = Double.parseDouble(line.
										substring(i + 1).trim());
							}
						}
					}
				}
			}
			finally {
				in.close();
			}
		}
		catch(IOException exception) {
			exception.printStackTrace();
		}
		return itemPrice;
	}
	void calculateGasPrice(JTextField totalTF, long start, long end) {	
		//get time of end button clicked
		end = System.currentTimeMillis();
		//1sec => 1gallon
		double galPerSec = (end-start)/1000;
		double price = galPerSec*regGasPrice;
		//set text with price in the total text field 
		totalTF.setText(String.format("%.2f", price));
		//deduct the amount gas calculated based on time fueling 
		leftGasGal -= galPerSec;
		leftGasTf.setText(String.valueOf(leftGasGal));

	}
	void addTotal(JTextField totalTF) {
		//add total price to the cart total
		cartTotal += Double.parseDouble(totalTF.getText());
		price.setText(String.format("%.2f",cartTotal));
		totalTF.setText("0.00");
	}
	void buyMoreGas(double howManyGal) {
		//if there is enough money to buy gas
		if(totalCounterMny >= howManyGal) {
			totalCounterMny -= howManyGal;
			leftGasGal += howManyGal;
			leftGasTf.setText(String.valueOf(leftGasGal));
			//distribute gas to four pumps 
			double distribution = howManyGal/4;
			w1+=distribution;
			w2+=distribution;
			w3+=distribution;
			w4+=distribution;
			repaint();
		}
		else {
			JOptionPane.showMessageDialog(null, 
					" Not enough money in Counter");
		}
		counterPrice.setText(String.format("%.2f",totalCounterMny));
	}
	void setEnabled(JButton start,JButton end) {
		start.setEnabled(false);
		end.setEnabled(false);
	}
	boolean buyMoreItem(String itemName) {
		boolean buy = false;
		//if there is enough money to buy items 
		if(getItemPrice(itemName) <= totalCounterMny) {
			totalCounterMny-=getItemPrice(itemName);
			buy = true;
		}
		else {
			JOptionPane.showMessageDialog(null, 
					" Not enough money in Counter");
		}
		counterPrice.setText(String.format("%.2f",totalCounterMny));
		return buy;
	}
	@Override
	public void paint(Graphics g)
	{  
		//Draw the gas bars with changing width
		super.paint(g);
		g.setColor(Color.RED);
		g.fillRect(700, 90, w1, 25);
		g.fillRect(700, 135, w2, 25);
		g.fillRect(700, 185, w3, 25);
		g.fillRect(700, 235, w4, 25);
	}
	Image readImage(Image i, String urlName) {
		try {
			URL url = new URL(urlName);
			i = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
	static void windowClose() {
		//show two buttons 
		String ObjButtons[] = {"OK","Cancel"};
		//getting a result from the options
		int PromptResult = JOptionPane.showOptionDialog(null,
				"Are you sure you want to close this application?",
				"Confirm Exit",
				JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE,null,
				ObjButtons,ObjButtons[1]);
		//when Yes option is clicked
		if(PromptResult == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
	void clearCounter() {
		cart.setText("");
		price.setText("0.00");
		cartTotal = 0;
	}
	void sellItem(String itemName, JTextField itemTF, JButton itemBT) {
		String Item = itemName;
		double priceToCart = getItemPrice(Item);
		//if there is enough items to sell
		if(Integer.parseInt(itemTF.getText()) > 0) {
			//add item with it's price into the cart
			cart.append(Item+": " + priceToCart + '\n');
			//deduct the amount of left items
			itemTF.setText(String.valueOf(Integer.parseInt(itemTF.getText())-1));
			cartTotal += priceToCart;	//add to item price to cartTotal
			price.setText(String.format("%.2f",cartTotal));
		}
		//if there is no stock to sell
		else {
			itemBT.setEnabled(false);
			JOptionPane.showMessageDialog(null, 
					" Not enough stock");
		}
	}
	void addStock(JTextField itemTF, JButton itemBT) {
		String curVal = "";
		curVal = itemTF.getText();
		//if there is enough stock to sell
		if(Integer.parseInt(curVal)>=0) {
			//make button able to click 
			itemBT.setEnabled(true);
		}
		itemTF.setText(String.valueOf(Integer.parseInt(curVal)
				+ 1));
	}
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setTitle("Jenny's Gas Station");
		GS panel = new GS();
		panel.setPreferredSize(new Dimension(1300,800)); 
		f.add(panel);		
		f.pack();
		f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setVisible(true);
		//========= Add Exit Confirmation box===========
		f.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent win)
			{ 
				windowClose();
			}
		});
	}
}