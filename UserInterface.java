import java.net.URL;
import java.awt.FlowLayout;
import java.awt.GridLayout;

//import java.awt.image.*;
// aucune erreur de compil sans cette importation

//import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

//import java.awt.*;
import java.awt.Dimension;
import java.awt.BorderLayout;

//import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JPanel;

import java.awt.Color; 

import javax.swing.JButton;

/**
 * This class implements a simple graphical user interface with a 
 * text entry area, a text output area and an optional image.
 * 
 * @author Antoine MARMOL
 * @version 11 / 21/05/2024
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    //private JFrame     aMyFrame;
    private MyFrame    aMyFrame;
    private JTextField aEntryField;
    private JTextArea  aLog;
    private JLabel     aImage;
    
    private JButton    aButtonN;
    private JButton    aButtonS;
    private JButton    aButtonE;
    private JButton    aButtonW;
    
    private JButton    aButtonUp;
    private JButton    aButtonDown;
    
    private JButton    aButtonBack;
    private JButton    aButtonInv;
    private JButton    aButtonAct;

    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param pGameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface( final GameEngine pGameEngine )
    {
        this.aEngine = pGameEngine;
        this.createGUI();
    } // UserInterface(.)

    /**
     * Print out some text into the text area.
     * 
     * @param pText The text to be appended to the log.
     */
    public void print( final String pText )
    {
        this.aLog.append( pText );
        this.aLog.setCaretPosition( this.aLog.getDocument().getLength() );
    } // print(.)

    /**
     * Print out some text into the text area, followed by a line break.
     * 
     * @param pText The text to be appended to the log.
     */
    public void println( final String pText )
    {
        this.print( pText + "\n" );
    } // println(.)

    /**
     * Show an image file in the interface.
     * 
     * @param pImageName The name of the image file to be displayed.
     */
    public void showImage( final String pImageName )
    {
        String vImagePath = "Images\\"+ pImageName; // to change the directory
        URL vImageURL = this.getClass().getClassLoader().getResource( vImagePath );
        if ( vImageURL == null )
            System.out.println( "Image not found : " + vImagePath );
        else {
            ImageIcon vIcon = new ImageIcon( vImageURL );
            this.aImage.setIcon( new ImageIcon( vIcon.getImage().getScaledInstance(800,800,java.awt.Image.SCALE_SMOOTH) ) );
        }
    } // showImage(.)

    /**
     * Enable or disable input in the entry field and in the buttons.
     * 
     * @param pOnOff A boolean value indicating whether to enable (true) or disable (false) user interaction.
     */
    public void enable( final boolean pOnOff )
    {
        this.aEntryField.setEditable( pOnOff ); // enable/disable
        this.aEntryField.addActionListener( this );
        this.aButtonN.setEnabled( pOnOff );
        this.aButtonS.setEnabled( pOnOff );
        this.aButtonE.setEnabled( pOnOff );
        this.aButtonW.setEnabled( pOnOff );
        this.aButtonBack.setEnabled( pOnOff );
        this.aButtonInv.setEnabled( pOnOff );
        this.aButtonAct.setEnabled( pOnOff );
        this.aButtonUp.setEnabled( pOnOff );
        this.aButtonDown.setEnabled( pOnOff );
        if ( pOnOff ) { // enable
            this.aEntryField.getCaret().setBlinkRate( 500 ); // cursor blink
            this.aEntryField.addActionListener( this ); // reacts to entry
        }
        else { // disable
            this.aEntryField.getCaret().setBlinkRate( 0 ); // cursor won't blink
            this.aEntryField.removeActionListener( this ); // won't react to entry
        }
    } // enable(.)

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        //Frame
        this.aMyFrame = new MyFrame(); 
        this.aMyFrame.setLayout( null );
        
        //Label / image
        this.aImage = new JLabel();
        JLabel vIcon = new JLabel();
        ImageIcon vLogo = new ImageIcon("Images\\Interface\\ZuulCeLogo.png");
        vIcon.setIcon( new ImageIcon( vLogo.getImage().getScaledInstance(300,300,java.awt.Image.SCALE_SMOOTH) ) );
    
        // Text field
        this.aEntryField = new JTextField( 35 );
        
        // List Scroller
        this.aLog = new JTextArea();
        this.aLog.setEditable( false );
        JScrollPane vListScroller = new JScrollPane( this.aLog );
        
        // buttons
        JPanel vPanelButtons = new JPanel();
        vPanelButtons.setLayout( new GridLayout(3,3) );
        vPanelButtons.setBounds( 250,250,300,300 );
        
        // first line
        vPanelButtons.add( this.aButtonUp = new JButton("up"));
        vPanelButtons.add( this.aButtonN = new JButton("go north"));
        vPanelButtons.add( this.aButtonInv = new JButton("inventory"));
        // second line 
        vPanelButtons.add( this.aButtonW = new JButton("go west"));
        vPanelButtons.add( this.aButtonBack = new JButton("back"));
        vPanelButtons.add( this.aButtonE = new JButton("go east"));
        // third line
        vPanelButtons.add( this.aButtonDown = new JButton("down"));
        vPanelButtons.add( this.aButtonS = new JButton("go south"));
        vPanelButtons.add( this.aButtonAct = new JButton("quit"));
        
        // add some event listeners to some components
        this.aEntryField.addActionListener( this );
        this.aButtonN.addActionListener( this );
        this.aButtonS.addActionListener( this );
        this.aButtonE.addActionListener( this );
        this.aButtonW.addActionListener( this );
        this.aButtonBack.addActionListener( this );
        this.aButtonInv.addActionListener( this );
        this.aButtonAct.addActionListener( this );
        this.aButtonUp.addActionListener( this );
        this.aButtonDown.addActionListener( this );
        
        //Panels
        //Red Panel 
        JPanel vRedPanel = new JPanel();
        //vRedPanel.setBackground(Color.red);
        vRedPanel.setBounds(75, 75, 800, 800);
        vRedPanel.setLayout( new BorderLayout() );
        vRedPanel.add(this.aImage);
        
        //Blue Panel
        JPanel vBluePanel = new JPanel();
        //vBluePanel.setBackground(Color.blue);
        vBluePanel.setBounds(1325, 375, 300, 300);
        vBluePanel.setLayout( new BorderLayout() );
        vBluePanel.add(vPanelButtons);
        
        //Green Panel
        JPanel vGreenPanel = new JPanel();
        //vGreenPanel.setBackground(Color.green);
        vGreenPanel.setBounds(925 ,100,350,600);
        vGreenPanel.setLayout( new BorderLayout() );
        vGreenPanel.add(vListScroller);
        
        //Yellow Panel
        JPanel vYellowPanel = new JPanel();
        //vYellowPanel.setBackground(Color.yellow);
        vYellowPanel.setBounds(925 ,750,700,35);
        vYellowPanel.setLayout( new BorderLayout() );
        vYellowPanel.add(this.aEntryField);
        
        //white Panel
        JPanel vWhitePanel = new JPanel();
        vWhitePanel.setBounds(1325, 75, 300, 300);
        vWhitePanel.setLayout( new BorderLayout() );
        vWhitePanel.add(vIcon);
        
        this.aMyFrame.getContentPane().add( vRedPanel );
        this.aMyFrame.getContentPane().add( vBluePanel );
        this.aMyFrame.getContentPane().add( vGreenPanel );
        this.aMyFrame.getContentPane().add( vYellowPanel );
        this.aMyFrame.getContentPane().add( vWhitePanel );
        
        // to end program when window is closed 
        this.aMyFrame.addWindowListener(
            new WindowAdapter() { // anonymous class
                @Override public void windowClosing(final WindowEvent pE)
                {
                    System.exit(0);
                }
        } );

        
        this.aMyFrame.setVisible( true );
        this.aEntryField.requestFocus();
    } // createGUI()

    /**
     * Actionlistener interface for entry textfield.
     * 
     * @param pE The ActionEvent object representing the action event.
     */
    @Override public void actionPerformed( final ActionEvent pE ) 
    {
        if(this.aButtonN.equals(pE.getSource())){
            this.aEngine.interpretCommand( "go north" );
        } else if(this.aButtonS.equals(pE.getSource())){
            this.aEngine.interpretCommand( "go south" );
        } else if(this.aButtonE.equals(pE.getSource())){
            this.aEngine.interpretCommand( "go east" );
        } else if(this.aButtonW.equals(pE.getSource())){
            this.aEngine.interpretCommand( "go west" );
        } else if(this.aButtonBack.equals(pE.getSource())){
            this.aEngine.interpretCommand( "back" );
        } else if(this.aButtonInv.equals(pE.getSource())){
            this.aEngine.interpretCommand( "inventory" );
        } else if(this.aButtonUp.equals(pE.getSource())){
            this.aEngine.interpretCommand( "go up" );
        } else if(this.aButtonDown.equals(pE.getSource())){
            this.aEngine.interpretCommand( "go down" );
        } else if(this.aButtonAct.equals(pE.getSource())){
            this.aEngine.interpretCommand( "quit" );
        } else {
            // no need to check the type of action at the moment
            // because there is only one possible action (text input) :
            this.processCommand(); // never suppress this line
        }
        
        // no need to check the type of action at the moment
        // because there is only one possible action (text input) :
        // this.processCommand(); // never suppress this line
    } // actionPerformed(.)

    /**
     * A command has been entered in the entry field.  
     * Read the command and do whatever is necessary to process it.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText( "" );

        this.aEngine.interpretCommand( vInput );
    } // processCommand()
} // UserInterface 
