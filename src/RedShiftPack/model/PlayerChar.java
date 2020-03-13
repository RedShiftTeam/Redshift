
package RedShiftPack.model;

/**
 *
 * @author Admin
 */
public class PlayerChar {
    
    //Point de Charac
    final public int POINTS_INI = 60;//INUTILE POUR L'INSTANT
    int vitalite, force, dexterite, intelligence, pointsDispo, pointsInitial, charisme, volonte;
    
    
    //[PH]Constructeurs
    public PlayerChar(){
        
    }
    public PlayerChar(int force, int dexterite, int intelligence, int charisme, int volonte, int pointsDispo){
        this.force = force;
        this.dexterite = dexterite;
        this.intelligence = intelligence;
        this.charisme = charisme;
        this.volonte = volonte;
        this.pointsDispo = pointsDispo;
        this.pointsInitial = (force + dexterite + intelligence + charisme + volonte + pointsDispo) - 25;
    }
    
    //GET
    public int getForce(){
        return force;
    }
    public int getDexterite(){
        return dexterite;
    }
    public int getIntelligence(){
        return intelligence;
    }
    public int getCharisme(){
        return charisme;
    }
    public int getVolonte(){
        return volonte;
    }
    public int getPointsDispo(){
        return pointsDispo;
    }
    
    //[PH]
    public int getPointsInitial(){
        return pointsInitial;
    }
    
    //Mutateurs

    public void setForce(int force){
        this.force = force;
    }
    public void setDexterite(int dexterite){
        this.dexterite = dexterite;
    }
    public void setIntelligence(int intelligence){
        this.intelligence = intelligence;
    }
    public void setCharisme(int charisme){
        this.charisme = charisme;
    }
    public void setVolonte(int volonte){
        this.volonte = volonte;
    }
    public void setPointDispo(int pointsDispo){
        this.pointsDispo = pointsDispo;
    }
    
}
