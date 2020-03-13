package RedShiftPack.view;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import RedShiftPack.model.PlayerChar;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Admin
 */

public class CharCreationMenu extends JFrame{
    
    JLabel labNom, labForce, labIntelligence, labDexterite, labCharisme, labVolonte, labPointsDispo, vitalite, force, 
           intelligence,dexterite, charisme, volonte, pointsDispo;
    JButton plusVitalite, plusForce, plusIntelligence, plusDexterite, plusCharisme, plusVolonte, reset;
    JTextField textNom;
    JPanelImage portrait;
    Font controlFreakCharMenu;
    Font CharMenuFont = new Font("RationalInteger", Font.BOLD, 12);
    GestEvtAction geaCharMenu = new GestEvtAction();
    PlayerChar playerChar = new PlayerChar();
    
    public CharCreationMenu(PlayerChar playerChar){
        
        try{
            controlFreakCharMenu = Font.createFont(Font.TRUETYPE_FONT, 
            new File("font/ControlFreakCharMenu.ttf")).deriveFont(24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("font/ControlFreakCharMenu.ttf")));
        } catch (IOException|FontFormatException fontEX) {
        }    
        
        this.playerChar = playerChar; 
        setSize(350, 500);
        setTitle("Création du personnage");
        setLocationRelativeTo(null);
        GridBagLayout gl = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        
        //Création d'onglets
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        JPanel panelStats = new JPanel ();
        panelStats.setLayout(gl);
        constraints.weightx=1;
        constraints.weighty=1;
        //JPanel panel2 = new JPanel ();
        
        //Composantes de présentation du personnage
        portrait = new JPanelImage();
        portrait.setPreferredSize(new Dimension (128, 128));
        constraints.gridx=3;
        constraints.gridy=2;
        constraints.gridheight=1;
        constraints.gridwidth=1;
        panelStats.add(portrait, constraints);
        
        labNom = new JLabel("Nom :");
        labNom.setFont(controlFreakCharMenu);
        constraints.gridx=7;
        constraints.gridy=2;
        constraints.gridheight=1;
        constraints.gridwidth=3;
        panelStats.add(labNom, constraints);
        
        textNom = new JTextField(6);
        textNom.setFont(controlFreakCharMenu);
        constraints.gridx=7;
        constraints.gridy=2;
        constraints.gridheight=7;
        constraints.gridwidth=3;
        panelStats.add(textNom, constraints);
        
        //Composantes graphiques de stats
        
        //Noms des statistiques
        labPointsDispo = new JLabel("Points disponibles :");
        labPointsDispo.setFont(controlFreakCharMenu);
        constraints.gridx=3;
        constraints.gridy=6;
        constraints.gridheight=1;
        constraints.gridwidth=2;
        panelStats.add(labPointsDispo, constraints);
        
        labForce = new JLabel("Force :");
        labForce.setFont(controlFreakCharMenu);
        constraints.gridy=8;
        panelStats.add(labForce, constraints);
        
        labDexterite = new JLabel("Dexterité :");
        labDexterite.setFont(controlFreakCharMenu);
        constraints.gridy=10;
        panelStats.add(labDexterite, constraints);
        
        labIntelligence = new JLabel("Intelligence :");
        labIntelligence.setFont(controlFreakCharMenu);
        constraints.gridy=12;
        panelStats.add(labIntelligence, constraints);
        
        labCharisme = new JLabel("Charisme :");
        labCharisme.setFont(controlFreakCharMenu);
        constraints.gridy=14;
        panelStats.add(labCharisme, constraints);
        
        labVolonte = new JLabel("Volonté :");
        labVolonte.setFont(controlFreakCharMenu);
        constraints.gridy=16;
        panelStats.add(labVolonte, constraints);
        
        //Affichage du nombre de points investis
        pointsDispo = new JLabel( Integer.toString(playerChar.getPointsDispo()) ); //!!DOIT ÊTRE REMPLACÉ PAR UNE VARIABLE!!
        pointsDispo.setFont(controlFreakCharMenu);
        constraints.gridx=7;
        constraints.gridy=6;
        constraints.gridheight=1;
        constraints.gridwidth=1;
        panelStats.add(pointsDispo, constraints); 
        
        force = new JLabel( Integer.toString(playerChar.getForce()) ); //!!DOIT ÊTRE REMPLACÉ PAR UNE VARIABLE!!
        force.setFont(controlFreakCharMenu);
        constraints.gridy=8;
        panelStats.add(force, constraints);
 
        dexterite = new JLabel( Integer.toString(playerChar.getDexterite()) ); //!!DOIT ÊTRE REMPLACÉ PAR UNE VARIABLE!!
        dexterite.setFont(controlFreakCharMenu);
        constraints.gridy=10;
        panelStats.add(dexterite, constraints);
        
        intelligence = new JLabel( Integer.toString(playerChar.getIntelligence()) ); //!!DOIT ÊTRE REMPLACÉ PAR UNE VARIABLE!!
        intelligence.setFont(controlFreakCharMenu);
        constraints.gridy=12;
        panelStats.add(intelligence, constraints);
        
        charisme = new JLabel( Integer.toString(playerChar.getCharisme()) ); //!!DOIT ÊTRE REMPLACÉ PAR UNE VARIABLE!!
        charisme.setFont(controlFreakCharMenu);
        constraints.gridy=14;
        panelStats.add(charisme, constraints);
        
        volonte = new JLabel( Integer.toString(playerChar.getCharisme()) ); //!!DOIT ÊTRE REMPLACÉ PAR UNE VARIABLE!!
        volonte.setFont(controlFreakCharMenu);
        constraints.gridy=16;
        panelStats.add(volonte, constraints);
        
        //Créations des boutons d'investissement de points
        
        plusForce = new JButton("+");
        plusForce.setFont(controlFreakCharMenu);
        constraints.gridx=9;
        constraints.gridy=8;
        plusForce.addActionListener(geaCharMenu);
        panelStats.add(plusForce, constraints);
        
        plusDexterite = new JButton("+");
        plusDexterite.setFont(controlFreakCharMenu);
        constraints.gridy=10;
        plusDexterite.addActionListener(geaCharMenu);
        panelStats.add(plusDexterite, constraints);
        
        plusIntelligence = new JButton("+");
        plusIntelligence.setFont(controlFreakCharMenu);
        constraints.gridy=12;
        plusIntelligence.addActionListener(geaCharMenu);
        panelStats.add(plusIntelligence, constraints);
        
        plusCharisme = new JButton("+");
        plusCharisme.setFont(controlFreakCharMenu);
        constraints.gridy=14;
        plusCharisme.addActionListener(geaCharMenu);
        panelStats.add(plusCharisme, constraints);
        
        plusVolonte = new JButton("+");
        plusVolonte.setFont(controlFreakCharMenu);
        constraints.gridy=16;
        plusVolonte.addActionListener(geaCharMenu);
        panelStats.add(plusVolonte, constraints);
        
        reset = new JButton("Réinit.");
        reset.setFont(controlFreakCharMenu);
        constraints.gridy=6;
        reset.addActionListener(geaCharMenu);
        panelStats.add(reset, constraints);
        
        //Ajout des onglets
        tabbedPane.add("Attributs", panelStats);
        tabbedPane.setFont(controlFreakCharMenu);  
            
        JPanel panelTalents = new JPanel ();
        panelTalents.setLayout(gl);
        tabbedPane.add("Talents", panelTalents);
        
        JPanel panelEquipement = new JPanel ();
        panelEquipement.setLayout(gl);
        tabbedPane.add("Équipement", panelEquipement);
        
        add(tabbedPane);
        
    }
    
    //Gestion des évènements
    private class GestEvtAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            
            if( (((JButton)event.getSource()).equals(reset)) ){
                playerChar.setForce(5);
                playerChar.setIntelligence(5);
                playerChar.setDexterite(5);
                playerChar.setCharisme(5);
                playerChar.setVolonte(5);
                playerChar.setPointDispo(playerChar.getPointsInitial());
            }
            
            if(playerChar.getPointsDispo()>0){
                
                if( (((JButton)event.getSource()).equals(plusForce)) ){
                    playerChar.setForce( (playerChar.getForce()+1) );
                    playerChar.setPointDispo( (playerChar.getPointsDispo()-1) );
                    //force.setText( Integer.toString(playerChar.getForce()));
                    //pointsDispo.setText( Integer.toString(playerChar.getPointsDispo()));
                }
                if( (((JButton)event.getSource()).equals(plusIntelligence)) ){
                    playerChar.setIntelligence( (playerChar.getIntelligence()+1) );
                    playerChar.setPointDispo( (playerChar.getPointsDispo()-1) );
                    //intelligence.setText( Integer.toString(playerChar.getIntelligence()));
                    //pointsDispo.setText( Integer.toString(playerChar.getPointsDispo()));
                }
                if( (((JButton)event.getSource()).equals(plusDexterite)) ){
                    playerChar.setDexterite( (playerChar.getDexterite()+1) );
                    playerChar.setPointDispo( (playerChar.getPointsDispo()-1) );
                    //dexterite.setText( Integer.toString(playerChar.getDexterite()));
                    //pointsDispo.setText( Integer.toString(playerChar.getPointsDispo()));
                }
                if( (((JButton)event.getSource()).equals(plusCharisme)) ){
                    playerChar.setCharisme( (playerChar.getCharisme()+1) );
                    playerChar.setPointDispo( (playerChar.getPointsDispo()-1) );
                    //charisme.setText( Integer.toString(playerChar.getCharisme()));
                    //pointsDispo.setText( Integer.toString(playerChar.getPointsDispo()));
                }
                if( (((JButton)event.getSource()).equals(plusVolonte)) ){
                    playerChar.setVolonte( (playerChar.getVolonte()+1) );
                    playerChar.setPointDispo( (playerChar.getPointsDispo()-1) );
                    //volonte.setText( Integer.toString(playerChar.getVolonte()));
                    //pointsDispo.setText( Integer.toString(playerChar.getPointsDispo()));
                }
            }
            
            force.setText( Integer.toString(playerChar.getForce()));
            intelligence.setText( Integer.toString(playerChar.getIntelligence()));
            dexterite.setText( Integer.toString(playerChar.getDexterite()));
            charisme.setText( Integer.toString(playerChar.getCharisme()));
            volonte.setText( Integer.toString(playerChar.getVolonte()));
            pointsDispo.setText( Integer.toString(playerChar.getPointsDispo()));
        }
    } 
}

class JPanelImage extends JPanel{
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        Image image = getToolkit().getImage("img/Human_1.png");
        g2D.drawImage(image, 0, 0, 128, 128, this);
        g2D.setStroke(new BasicStroke(4));
        g2D.drawRect(1, 1, 126, 126);
    }
}