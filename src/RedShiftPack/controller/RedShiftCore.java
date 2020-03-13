
package RedShiftPack.controller;
import RedShiftPack.model.PlayerChar;
import RedShiftPack.view.CharCreationMenu;
import RedShiftPack.view.MainMenu;

/**
 *
 * @author samgz
 */
public class RedShiftCore implements Runnable {
    
    private Thread thread;
    
    private boolean running = false;
    
    private void init(){
        MainMenu rsMenuFrame = new MainMenu();
        rsMenuFrame.setVisible(true);
        PlayerChar playerChar = new PlayerChar(5, 5, 5, 5, 5, 5);//!!POUR TEST SLM
        CharCreationMenu charCreationFrame = new CharCreationMenu(playerChar);
        charCreationFrame.setVisible(true);
    }
    
    private void tick(){     
    }
    
    private void render(){
    }
        
    public void run(){
        init();
        while(running){
            tick();
            render();  
        }
        stop();
    }
    
    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop() {
        if (!running)   
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException threadEX) {
            threadEX.printStackTrace();
        }
    }
    
    public void vibeCheck(){  
    }
}
