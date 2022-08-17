import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.GridLayout;

public class GameUI {

    JFrame Screen;
    JPanel titlePanel;
    JPanel inventoryTitlePanel;
    JPanel playButtonPanel;
    JPanel storyPanel;
    JPanel optionsPanel;
    JPanel playerStatusPanel;
    JPanel coinsPanel;
    JPanel inventoryPanel;
    JPanel closeInventoryPanel;
    JLabel titleLabel, healthLabel, healthNumberLabel, locationLabel, locationNameLabel, coinsLabel, coinsNumberLabel, inventoryTitleLabel;
    JButton playButton, option1, option2, option3, option4, openInventory, closeInventory;
    JTextArea storyTextArea;
    final int WIDTH = 1000; 
    final int HEIGHT = 600;
    Font titleFontStyle = new Font(Font.MONOSPACED, Font.BOLD, 64);
    Font standardTextFont = new Font(Font.MONOSPACED, Font.PLAIN, 22);
    
    public void createGameUI(OptionsManager choiceManager) { // Creates game UI
        
        // Screen

        Screen = new JFrame();
        Screen.setSize(WIDTH, HEIGHT);
        Screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Screen.getContentPane().setBackground(Color.DARK_GRAY);
        Screen.setLayout(null);
        Screen.setTitle("Hero's Journey");

        // Title screen

        titlePanel = new JPanel();
        titlePanel.setBounds(125, 100, 750, 500); 
        titlePanel.setBackground(Color.DARK_GRAY);

        titleLabel = new JLabel("Hero's Journey");
        titleLabel.setForeground(Color.green);
        titleLabel.setFont(titleFontStyle);
        titlePanel.add(titleLabel);

        // Play button

        playButtonPanel = new JPanel();
        playButtonPanel.setBounds(375, 400, 250, 300);
        playButtonPanel.setBackground(Color.DARK_GRAY);
        playButton = new JButton("PLAY");
        playButton.setBackground(Color.orange);
        playButton.setForeground(Color.black);
        playButton.setFont(standardTextFont);
        playButton.setFocusPainted(false);
        playButton.addActionListener(choiceManager);
        playButton.setActionCommand("clickedPlay");
        playButtonPanel.add(playButton);

        Screen.add(titlePanel);
        Screen.add(playButtonPanel);

        // Game screen
        storyPanel = new JPanel();
        storyPanel.setBounds(125, 100, 750, 250);
        storyPanel.setBackground(Color.DARK_GRAY);
        Screen.add(storyPanel);

        storyTextArea = new JTextArea();
        storyTextArea.setBounds(125, 100, 750, 300);
        storyTextArea.setBackground(Color.DARK_GRAY);
        storyTextArea.setForeground(Color.ORANGE);
        storyTextArea.setFont(standardTextFont);
        storyTextArea.setLineWrap(true);
        storyTextArea.setWrapStyleWord(true);
        storyTextArea.setEditable(false);
        storyPanel.add(storyTextArea);

        // Inventory title

        inventoryTitlePanel = new JPanel();
        inventoryTitlePanel.setBounds(163, 0, 750, 100); 
        inventoryTitlePanel.setBackground(Color.DARK_GRAY);
        


        inventoryTitleLabel = new JLabel("Inventory");
        inventoryTitleLabel.setForeground(Color.GREEN);
        inventoryTitleLabel.setFont(titleFontStyle);
        inventoryTitlePanel.add(inventoryTitleLabel);
        Screen.add(inventoryTitlePanel);



        // Inventory button

        inventoryPanel = new JPanel();
        inventoryPanel.setBounds(750, 45, 190, 150);
        inventoryPanel.setBackground(Color.DARK_GRAY);
        inventoryPanel.setLayout(new GridLayout(4,1));
        Screen.add(inventoryPanel);

        openInventory = new JButton("Inventory");
        openInventory.setBackground(Color.DARK_GRAY);
        openInventory.setForeground(Color.green);
        openInventory.setFont(standardTextFont);
        openInventory.setFocusPainted(false);
        openInventory.addActionListener(choiceManager);
        openInventory.setActionCommand("clickedOpenInventory");
        inventoryPanel.add(openInventory);

        closeInventoryPanel = new JPanel();
        closeInventoryPanel.setBounds(400, 450, 250, 150);
        closeInventoryPanel.setBackground(Color.DARK_GRAY);
        closeInventoryPanel.setLayout(new GridLayout(4,1));
        Screen.add(closeInventoryPanel);

        closeInventory = new JButton("Close");
        closeInventory.setBackground(Color.DARK_GRAY);
        closeInventory.setForeground(Color.green);
        closeInventory.setFont(standardTextFont);
        closeInventory.setFocusPainted(false);
        closeInventory.addActionListener(choiceManager);
        closeInventory.setActionCommand("clickedCloseInventory");
        closeInventoryPanel.add(closeInventory);



        // Option buttons

        optionsPanel = new JPanel();
        optionsPanel.setBounds(310, 350, 375, 150);
        optionsPanel.setBackground(Color.DARK_GRAY);
        optionsPanel.setLayout(new GridLayout(4,1));
        Screen.add(optionsPanel);

        option1 = new JButton();
        option1.setBackground(Color.DARK_GRAY);
        option1.setForeground(Color.green);
        option1.setFont(standardTextFont);
        option1.setFocusPainted(false);
        option1.addActionListener(choiceManager);
        option1.setActionCommand("clickedOption1");
        optionsPanel.add(option1);

        option2 = new JButton();
        option2.setBackground(Color.DARK_GRAY);
        option2.setForeground(Color.green);
        option2.setFont(standardTextFont);
        option2.setFocusPainted(false);
        option2.addActionListener(choiceManager);
        option2.setActionCommand("clickedOption2");
        optionsPanel.add(option2);

        option3 = new JButton();
        option3.setBackground(Color.DARK_GRAY);
        option3.setForeground(Color.green);
        option3.setFont(standardTextFont);
        option3.setFocusPainted(false);
        option3.addActionListener(choiceManager);
        option3.setActionCommand("clickedOption3");
        optionsPanel.add(option3);

        option4 = new JButton();
        option4.setBackground(Color.DARK_GRAY);
        option4.setForeground(Color.green);
        option4.setFont(standardTextFont);
        option4.setFocusPainted(false);
        option4.addActionListener(choiceManager);
        option4.setActionCommand("clickedOption4");
        optionsPanel.add(option4);

        playerStatusPanel = new JPanel();
        playerStatusPanel.setBounds(25, 15, 750, 45);
        playerStatusPanel.setBackground(Color.DARK_GRAY);
        playerStatusPanel.setLayout(new GridLayout(1,1));
        Screen.add(playerStatusPanel);

        healthLabel = new JLabel("Health:");
        healthLabel.setFont(standardTextFont);
        healthLabel.setForeground(Color.PINK);
        playerStatusPanel.add(healthLabel);

        healthNumberLabel = new JLabel();
        healthNumberLabel.setForeground(Color.pink);
        healthNumberLabel.setFont(standardTextFont);
        playerStatusPanel.add(healthNumberLabel);

        locationLabel = new JLabel("Location:");
        locationLabel.setForeground(Color.pink);
        locationLabel.setFont(standardTextFont);
        playerStatusPanel.add(locationLabel);

        locationNameLabel = new JLabel();
        locationNameLabel.setForeground(Color.pink);
        locationNameLabel.setFont(standardTextFont);
        playerStatusPanel.add(locationNameLabel);


        coinsPanel = new JPanel();
        coinsPanel.setBounds(25, 50, 340, 45);
        coinsPanel.setBackground(Color.DARK_GRAY);
        coinsPanel.setLayout(new GridLayout(1,1));
        Screen.add(coinsPanel);

        coinsLabel = new JLabel("Coins:");
        coinsLabel.setForeground(Color.pink);
        coinsLabel.setFont(standardTextFont);
        coinsPanel.add(coinsLabel);

        coinsNumberLabel = new JLabel();
        coinsNumberLabel.setForeground(Color.pink);
        coinsNumberLabel.setFont(standardTextFont);
        coinsPanel.add(coinsNumberLabel);

        Screen.setVisible(true);
    }


}