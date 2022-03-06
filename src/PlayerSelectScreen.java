import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

//needs massive aesthetic rewrites

public class PlayerSelectScreen extends JPanel {
	JButton go;
	JButton quit;
	MainWindow mw;
	
	JRadioButton opt1;
	JRadioButton opt2;
	JRadioButton opt3;
	
	public void quitButtonActionListener(){
		mw.showCard("One");
	}
	
	public void goButtonActionListener(){
		playerOptions();
		mw.s4.setUpPlayers();
		mw.showCard("Three");
	}
	
	public void playerOptions(){
		int m = 5;
		if(opt1.isSelected() == true)
		    m = 1;
		else if(opt2.isSelected() == true)
			m = 2;
		else if(opt3.isSelected() == true)
			m = 3;
	    mw.s4.setMaxPlayers(m);
	}
	
	public PlayerSelectScreen(MainWindow mw){
		this.mw = mw;
                //EXTRACIONES
		BoxLayout refac_2 = (new BoxLayout(this, BoxLayout.PAGE_AXIS));
		JLabel Lal = new JLabel("Select Players: ");
                JLabel La2 = new JLabel("Default: 1Player");
                JRadioButton Ra1 =  new JRadioButton("1 Player(Default)");
                JRadioButton Ra2 =  new JRadioButton("2 Players");
                JRadioButton Ra3 =  new JRadioButton("3 Players");  
                 ActionListener ac1 = new ActionListener(){
			public void actionPerformed(ActionEvent event){
				playerOptions();
			}
                 };
                ActionListener act2= new ActionListener(){
			public void actionPerformed(ActionEvent event){
				goButtonActionListener();
			}
		};
                setLayout(refac_2);
		
		JLabel mess = Lal;
		add(mess);
		
		JLabel uc = La2 ;
		add(uc);
		
		//set up radio buttons
		
		opt1 = Ra1;
		opt1.setSelected(true);
		
		opt2 = Ra2;
		opt3 = Ra3;
		
		ButtonGroup grp = new ButtonGroup();
		grp.add(opt1);
		grp.add(opt2);
		grp.add(opt3);
		
		add(opt1);
		add(opt2);
		add(opt3);

		opt1.addActionListener(ac1);
		opt2.addActionListener(ac1);
		
		opt3.addActionListener(ac1);
		
		go = new JButton("Customize Board");
		quit = new JButton("Back");	
		
		go.addActionListener(act2);
		
		quit.addActionListener(act2);
		
		add(go);
		add(quit);
		
	}
	

}
