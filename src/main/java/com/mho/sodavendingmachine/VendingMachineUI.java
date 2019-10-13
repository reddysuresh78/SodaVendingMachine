package com.mho.sodavendingmachine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.mho.sodavendingmachine.domain.Coin;
import com.mho.sodavendingmachine.domain.Soda;
import com.mho.sodavendingmachine.exception.OperationFailedException;
import com.mho.sodavendingmachine.service.VendingMachineService;
import com.mho.sodavendingmachine.service.VendingMachineServiceImpl;

@SuppressWarnings("serial")
public class VendingMachineUI extends JFrame {

	private final VendingMachineService vm = new VendingMachineServiceImpl();

	public void start() { 
		
		setTitle("Soda Vending Machine");

		JLabel lblCurrentAmount = new JLabel("Current Amount: ");
		final JLabel curAmount = new JLabel("0 Quarters");

		JLabel lblSoda = new JLabel("Current Soda: ");
		final JLabel curSoda = new JLabel("No Soda Chosen");
		
		JLabel lblaction = new JLabel("Last Action: ");
		final JLabel lastAction = new JLabel("None");

		JPanel controls = new JPanel();
		// controls.setLayout(new GridLayout(3, 3));
		controls.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		int row = 0;
		
		c.gridx = 0;
		c.gridy = row;
		c.gridwidth = 3;
		c.insets = new Insets(3,3,3,3);
		
		JLabel heading = new JLabel("Welcome to Soda Vending Machine");
		heading.setHorizontalAlignment(JLabel.CENTER);
		heading.setFont(new Font("Serif", Font.PLAIN, 24));
		heading.setForeground(Color.BLUE);
	 

		controls.add(heading,c);
		
		row++;
		c.gridwidth = 1;
		JButton cokeButton = new JButton();
		try {
			Image img = ImageIO.read(getClass().getResource("/coke.png"));
			cokeButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = row;
		controls.add(cokeButton, c);

		cokeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vm.chooseProduct(Soda.COKE);
					curSoda.setText("Coke");
					curAmount.setText("" + (int) (vm.getCurrentBalance() / Coin.QUARTER.getDenomination()) + " Quarters");
					lastAction.setText("Coke Selected");
				} catch (OperationFailedException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		JButton pepsiButton = new JButton();
		try {
			Image img = ImageIO.read(getClass().getResource("/pepsi.jpg"));
			pepsiButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}

	 
		c.gridx = 1;
		 

		controls.add(pepsiButton, c);

		pepsiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vm.chooseProduct(Soda.PEPSI);
					curSoda.setText("Pepsi");
					curAmount.setText("" + (int) (vm.getCurrentBalance() / Coin.QUARTER.getDenomination()) + " Quarters");
					lastAction.setText("Pepsi Selected");
				} catch (OperationFailedException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		JButton spriteButton = new JButton();
		try {
			Image img = ImageIO.read(getClass().getResource("/sprite.jpg"));
			spriteButton.setIcon(new ImageIcon(img));
		} catch (IOException ex) {
		}

		 
		c.gridx = 2;
		 

		controls.add(spriteButton, c);

		spriteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vm.chooseProduct(Soda.SPRITE);
					curAmount.setText("" + (int) (vm.getCurrentBalance() / Coin.QUARTER.getDenomination()) + " Quarters");
					curSoda.setText("Sprite");
					lastAction.setText("Sprite Selected");
				} catch (OperationFailedException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		c.fill = GridBagConstraints.HORIZONTAL;
		 
		//Second row
		row++;
		c.gridx = 0;
		c.gridy = row;
		
		JLabel cokeCost = new JLabel("1 Quarter");
		cokeCost.setHorizontalAlignment(JLabel.CENTER);

		controls.add(cokeCost, c);
		c.gridx = 1;

		JLabel pepsiCost = new JLabel("1 Quarter");
		pepsiCost.setHorizontalAlignment(JLabel.CENTER);

		controls.add(pepsiCost, c);

		c.gridx = 2;

		JLabel spriteCost = new JLabel("2 Quarters");
		spriteCost.setHorizontalAlignment(JLabel.CENTER);

		controls.add(spriteCost, c);

		JButton insertQuarterButton = new JButton("Insert Quarter");
		insertQuarterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vm.insertCoin(Coin.QUARTER);
					curAmount.setText("" + (int) (vm.getCurrentBalance() / Coin.QUARTER.getDenomination()) + " Quarters");
					lastAction.setText("Quarter inserted");
				} catch (OperationFailedException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		//3rd Row
		row++;
		c.gridx = 0;
		c.gridy = row;

		insertQuarterButton.setSize(100, 20);
		controls.add(insertQuarterButton, c);

		JButton refundQuarterButton = new JButton("Refund Quarter");
		refundQuarterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vm.removeCoin(Coin.QUARTER);
					curAmount.setText("" + (int) (vm.getCurrentBalance() / Coin.QUARTER.getDenomination()) + " Quarters");
					lastAction.setText("Quarter refunded");
				} catch (OperationFailedException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		c.gridx = 1;
		 
		controls.add(refundQuarterButton, c);

		JButton dispenseSodaButton = new JButton("Dispense Soda");
		dispenseSodaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					vm.dispenseProduct();
					curSoda.setText("No Soda Chosen");
					lastAction.setText("Soda dispensed");
				} catch (OperationFailedException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		c.gridx = 2;
		controls.add(dispenseSodaButton, c);

		//Next row
		row++;
		
		c.gridx = 0;
		c.gridy = row;
		controls.add(lblCurrentAmount, c);

		c.gridx = 1;
		c.gridy = row;
		controls.add(curAmount, c);

		//Next row
		row++;
		c.gridx = 0;
		c.gridy = row;
		controls.add(lblSoda, c);

		c.gridx = 1;
		c.gridy = row;
		controls.add(curSoda, c);
		
		//Next row
		row++;
		c.gridx = 0;
		c.gridy = row;
		controls.add(lblaction, c);

		c.gridx = 1;
		c.gridy = row;
		controls.add(lastAction, c);
	  
		 
		add(controls);
		setSize(400, 400);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

	public static void main(String args[]) {
		new VendingMachineUI().start();
	}
}
