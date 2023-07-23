import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class MenuFrame extends JInternalFrame implements ActionListener
{
	private JPanel left_panel, right_panel, left_p1, left_p2, right_p1, right_p2, right_p3;
	private JPanel right_p2_1, right_p2_2, right_p2_3, right_p2_4, right_p2_5;
	private JSplitPane jsp;
	private JScrollPane sp;
	private JList <String> dish_list;
	private JLabel lbl, lbl_msg;
	private JButton b;
	private Vector <String> dish_vector;
	private JTextField txt_search, txt_dish_num, txt_dish_name, txt_dish_price;
	private MenuFrame me;

	public MenuFrame()
	{
		super("MENU FRAME", true, true, true, true);


		// left panel

		left_panel = new JPanel();
		left_panel.setLayout(null);

		left_p1 = new JPanel();
		left_panel.add(left_p1);

		left_p1.setBounds(10, 10, 250, 50);

		left_p1.setLayout(new GridLayout(2, 1, 2, 0));

		left_p1.add(new JLabel("Search: "));
		txt_search = new JTextField(25);
		left_p1.add(txt_search);


		left_p2 = new JPanel();
		left_panel.add(left_p2);


		left_p2.setBounds(10, 70, 250, 450);

		dish_vector = new Vector <String>();
		dish_list = new JList <String>(dish_vector);
		dish_list.setVisibleRowCount(30);

		sp = new JScrollPane(dish_list);
		left_p2.add(sp);

		//right panel

		right_panel = new JPanel();
		right_panel.setLayout(null);

		right_p1 = new JPanel();

		lbl = new JLabel("MENU SECTION");
		right_p1.add(lbl, JLabel.CENTER);
		lbl.setFont(new Font("calibri", Font.BOLD, 25));



		right_p2 = new JPanel();

		right_p2.setLayout(new GridLayout(5, 2));

		right_p2_1 = new JPanel();
		right_p2_1.add(new JLabel("Dish Number: "));
		txt_dish_num = new JTextField(20);
		right_p2_1.add(txt_dish_num);
		txt_dish_num.setEditable(false);

		right_p2.add(right_p2_1);

		right_p2_2 = new JPanel();
		right_p2_2.add(new JLabel("Dish Name: "));
		txt_dish_name = new JTextField(20);
		right_p2_2.add(txt_dish_name);

		right_p2.add(right_p2_2);

		right_p2_3 = new JPanel();

		right_p2_3.add(new JLabel("Dish Price: "));
		txt_dish_price = new JTextField(20);
		right_p2_3.add(txt_dish_price);

		right_p2.add(right_p2_3);



		right_p2_4 = new JPanel();

		b = new JButton("INSERT");
		right_p2_4.add(b);
		b.addActionListener(this);

		b = new JButton("UPDATE");
		right_p2_4.add(b);
		b.addActionListener(this);

		right_p2_5 = new JPanel();
		
		right_p2.add(right_p2_4);

		b = new JButton("DELETE");
		right_p2_5.add(b);
		b.addActionListener(this);

		b = new JButton("CLEAR");
		right_p2_5.add(b);
		b.addActionListener(this);

		right_p2.add(right_p2_5);
		
		right_p3 = new JPanel();

		right_panel.setLayout(null);

		right_panel.add(right_p1);
		right_p1.setBounds(10, 10, 350, 45);

		right_panel.add(right_p2);
		right_p2.setBounds(10, 55, 350, 250);


		right_panel.add(right_p3);
		right_p3.add(new JLabel("hi"));
		right_p3.setBounds(10, 310, 350, 45);



		// JSplitPane

		jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left_panel, right_panel);
		this.add(jsp);

		jsp.setDividerSize(2);
		jsp.setDividerLocation(300);
		

		this.setVisible(true);
		this.setSize(800, 580);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String text = e.getActionCommand();

		switch(text)
		{

		}
	}
}

class MyFrame extends JFrame implements ActionListener
{

	private JToolBar jt;
	private JDesktopPane jdp;
	private JInternalFrame menu_frame, billing_frame; 
	private JButton b;

	public MyFrame()
	{
		jt = new JToolBar();
		this.add(jt, BorderLayout.NORTH);

		jt.setLayout(new GridLayout(1,2,5,0));

		b = new JButton("MENU SECTION");
		jt.add(b);
		b.addActionListener(this);

		b = new JButton("BILLING SECTION");
		jt.add(b);
		b.addActionListener(this);

		jdp = new JDesktopPane();
		this.add(jdp, BorderLayout.CENTER);


		this.setVisible(true);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String text = e.getActionCommand();

		switch(text)
		{
			case "MENU SECTION":
				if(menu_frame == null)
				{

					menu_frame = new MenuFrame();
					jdp.add(menu_frame);
				}
				break;
				
			case "BILLING SECTION":
				break;

		}
	}
}


class MyHotel
{
	public static void main(String[] args) 
	{
		new MyFrame();	
	}
}