import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Suborder extends JFrame{
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;

	private JLabel label; //Label to welcome the user to the frame 
	private JButton button; //Button to click to calculate total
	private JLabel result; //Label that holds the total price of the sub ordered
	private double total; //variable that holds the price of the sub
	private JCheckBox lettuce; 
	private JCheckBox tomatoes;
	private JCheckBox onions;
	private JCheckBox green;
	private JRadioButton sub6;
	private JRadioButton sub12;
	private JRadioButton cheeseYes;
	private JRadioButton cheeseNo;
	private JRadioButton mayo;
	private JRadioButton honey;
	private JCheckBox chicken;
	private JCheckBox turkey;
	private JCheckBox ham;
	private JComboBox<String>breadCombo;
	private ActionListener listener; 


	/**
		Constructs the frame.
	*/
	public Suborder(){
		label = new JLabel("WELCOME! Please order your sub sandwich below.");
		add(label, BorderLayout.NORTH);
		setBackground(Color.BLACK);
		createControlPanel();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}

 
	/**
		Creates a control panel to organize the layout of the different 
				elements
	*/
	public void createControlPanel(){ 
		JPanel toppingsPanel = createCheckBoxes();
		JPanel breadPanel = createComboBox1();
		JPanel subPanel = createRadioButtons2();
		JPanel cheesePanel = createRadioButtons3();
		JPanel saucePanel = createRadioButtons4();
		JPanel meatPanel = createCheckBox();

		JPanel controlPanel = new JPanel(); //Creates a panel to store all the elements of the sub
		controlPanel.setLayout(new GridLayout(2, 3)); //creates a grid layout
		controlPanel.add(breadPanel);
		controlPanel.add(subPanel);
		controlPanel.add(cheesePanel);
		controlPanel.add(meatPanel);
		controlPanel.add(toppingsPanel);
		controlPanel.add(saucePanel);

		listener = new ChoiceListener(); 
		button = new JButton("Calculate Total"); //button to calculate total 
		button.addActionListener(listener); 
		result = new JLabel("Your Price: $" +total);
		JPanel controlP = new JPanel();
		controlP.setLayout(new GridLayout(1, 2)); // creates a grid layout to store the button and result label
		controlP.add(button);
		controlP.add(result);
		add(controlP, BorderLayout.SOUTH);
		add(controlPanel, BorderLayout.CENTER);
	}  

	//Creates a new check box for the meat options
	public JPanel createCheckBox(){
		chicken = new JCheckBox("Chicken");
		turkey = new JCheckBox("Turkey");
		ham = new JCheckBox("Ham");

		JPanel panel = new JPanel();
		panel.add(chicken);
		panel.add(turkey);
		panel.add(ham);

		panel.setBorder(new TitledBorder(new EtchedBorder(), "Meat Options")); //Creates a border to label the meat options section
		return panel;
	} 

	//Creates a new check box for the toppings option
	public JPanel createCheckBoxes(){
		lettuce = new JCheckBox("Lettuce");
		tomatoes = new JCheckBox("Tomatoes");
		onions = new JCheckBox("Onions");
		green = new JCheckBox("Green Pepper");

		JPanel panel = new JPanel();
		panel.add(lettuce);
		panel.add(tomatoes);
		panel.add(onions);
		panel.add(green);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Toppings")); //Creates a border to label the toppings options section

		return panel;
	}

	//Creates a bew combo box for the bread options
	public JPanel createComboBox1(){
		breadCombo = new JComboBox<String>();
		breadCombo.addItem("White Bread");
		breadCombo.addItem("Wheat Bread");
		breadCombo.addItem("Multigrain");
		

		JPanel panel = new JPanel();
		panel.add(breadCombo);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Bread Type")); //Creates a border to label the bread options section
	

		return panel;
	}

	//Creates a radio button for the bread size options
	public JPanel createRadioButtons2(){
		sub6 = new JRadioButton("6 Inches");
		//sub6.addActionListener(listener);
		sub12 = new JRadioButton("12 Inches");
		//sub12.addActionListener(listener);
		sub6.setSelected(true);

		ButtonGroup group = new ButtonGroup(); //Creates a nnew button group to make sure only one radio button can be selected
		group.add(sub6);
		group.add(sub12);

		JPanel panel = new JPanel();
		panel.add(sub6);
		panel.add(sub12);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Bread Size")); //Creates a border to label the bread size options section

		return panel;
	}

	//Creates a radio button for the cheese options
	public JPanel createRadioButtons3(){
		cheeseYes = new JRadioButton("Yes");
		//cheeseYes.addActionListener(listener);
		cheeseNo = new JRadioButton("No");
		//cheeseNo.addActionListener(listener);
		cheeseYes.setSelected(true);

		ButtonGroup group = new ButtonGroup();
		group.add(cheeseYes);
		group.add(cheeseNo);

		JPanel panel = new JPanel();
		panel.add(cheeseYes);
		panel.add(cheeseNo);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Cheese?")); //Creates a border to label the cheese options section

		return panel;
	
	}

	//Creates a radio button for the sauce options 
	public JPanel createRadioButtons4(){
		mayo = new JRadioButton("Mayonnaise");
		mayo.addActionListener(listener);
		honey = new JRadioButton("Honey Mustard");
		honey.addActionListener(listener);
		honey.setSelected(true);

		ButtonGroup group = new ButtonGroup();
		group.add(mayo);
		group.add(honey);

		JPanel panel = new JPanel();
		panel.add(mayo);
		panel.add(honey);
		panel.setBorder(new TitledBorder(new EtchedBorder(), "Sauce")); //Creates a border to label the sauce options section

		return panel;
		
	}

	/**
	Each time the button is clicked the following codes are executed
	*/
	class ChoiceListener implements ActionListener{

		public void actionPerformed(ActionEvent event){
			if(sub6.isSelected()){ //Loop continues if the sub6 radio button is selected 
				if(cheeseYes.isSelected()){ //Loop continues if the cheeseYes radio button is selected
					total = (6*0.15)+6;
					result.setText("Your Price: $" + total); //Sets the new label text to the calculated price 
				}
				else{
					total = (5*0.15)+5;
					result.setText("Your Price: $" + total);
				}
			}
			else{
				if(cheeseYes.isSelected()){ //Loop continues if the cheeseYes radio button is selected
					total = (9*0.15)+9;
					result.setText("Your Price: $" + total);
				}
				else{
					total = (8*0.15)+8;
					result.setText("Your Price: $" + total);
				}

			}

		}

	}

}	

