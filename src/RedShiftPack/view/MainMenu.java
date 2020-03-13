package RedShiftPack.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author
 */
public class MainMenu extends JFrame {
    
    GridLayout rsMenuGL = new GridLayout(5,1);
    JPanel rsMenuPanel;
    JLabel rsBanner;
    JButton nouvellePartieButton,optionsButton,creditsButton,quitterButton;  
    Font rationalIntegerMenu;
    Font menuFont = new Font("RationalInteger", Font.BOLD, 12);
    GestEvtAction geaMenu = new GestEvtAction();
            
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        Image image = getToolkit().getImage("img/Placeholder.png");
        g2D.drawImage(image, 10, 35, 780, 100, this);
    }
    
    public MainMenu() {
        
        try{
            rationalIntegerMenu = Font.createFont(Font.TRUETYPE_FONT, 
            new File("font/RationalIntegerMenu.ttf")).deriveFont(60f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font/RationalIntegerMenu.ttf")));
        } catch (IOException|FontFormatException fontEX) {
        }    
        
        setTitle("RedShift");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addWindowListener( new java.awt.event.WindowAdapter(){
        @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent){
                if(JOptionPane.showConfirmDialog(null, "Êtes vous sur de vouloir quitter?"
                    + "\nVotre progression ne sera pas sauvegardée!", "Confirmation", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception lnfEX) {
            System.out.println("Erreur de look and feel!");
        }
         
        rsMenuPanel = new JPanel();
        rsMenuPanel.setLayout(rsMenuGL);
        
        rsBanner = new JLabel();
        rsMenuPanel.add(rsBanner);
        
        nouvellePartieButton = new JButton("Nouvelle Partie");
        nouvellePartieButton.setFont(rationalIntegerMenu);
        nouvellePartieButton.addActionListener(geaMenu);
        rsMenuPanel.add(nouvellePartieButton);
        
        optionsButton = new JButton("Options");
        optionsButton.setFont(rationalIntegerMenu);
        optionsButton.addActionListener(geaMenu);
        rsMenuPanel.add(optionsButton);
        
        creditsButton = new JButton("Crédits");
        creditsButton.setFont(rationalIntegerMenu);
        creditsButton.addActionListener(geaMenu);
        rsMenuPanel.add(creditsButton);
        
        quitterButton = new JButton("Quitter");
        quitterButton.setFont(rationalIntegerMenu);
        quitterButton.addActionListener(geaMenu);
        rsMenuPanel.add(quitterButton);
        
        add(rsMenuPanel);
    }

    private class GestEvtAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent aeMenu) {
            if(aeMenu.getSource() == nouvellePartieButton);
                
            if(aeMenu.getSource() == quitterButton)
                if(JOptionPane.showConfirmDialog(null, "Êtes vous sur de vouloir quitter?"
                    + "\nVotre progression ne sera pas sauvegardée!", "Confirmation", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
                    System.exit(0);
            }
        }
    } 
}
