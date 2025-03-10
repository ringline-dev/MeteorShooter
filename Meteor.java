import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Meteor here.
 * 
 * @author (your name) w
 * @version (a version number or a date)
 */
public class Meteor extends Actor
{
    //Instanzvariablen
    private int rotation;
    private int speedVertical;
    private Rakete meineRakete;//neu, Deklaration einer Raketen-Variable
    private boolean hitted = false;
    private boolean explode = false;
    private boolean remove = false;
    private int explodeCounter = 0;
    
    //Konstruktor, hier steht alles, was (einmalig) 
    //beim Erzeugen eines Meteors passieren soll
    public Meteor(Rakete rakete, int speed){
        meineRakete = rakete;//neu
        speedVertical = speed;
        rotation = -5 + Greenfoot.getRandomNumber(10);
    }
    
    //hier steht alles, was immer wieder ausgeführt werden soll
    public void act()
    {
        this.setLocation(this.getX(), this.getY() + speedVertical);
        this.setRotation(this.getRotation() + rotation);
        //Kollisionsprüfung
        if(this.getX() + 26 >= meineRakete.getX() - 24 && 
            this.getX() -26 <= meineRakete.getX() + 24 &&
            this.getY() + 26 >= meineRakete.getY() - 45 &&      
            this.getY() -26 <= meineRakete.getY() + 45 &&
            !hitted)
        {
            hitted = true;
            
            if(meineRakete.getEnergy() > 0){
                this.getWorld().addObject(new Hit(), this.getX(), this.getY());
            }
            meineRakete.hit();
        }
        
        if(explode){
            if(explodeCounter++ == 20){
                remove = true;
            }
            
        }
        
        if(this.getY() > 590){
            remove = true;
        }
        
        if(remove){
            this.getWorld().removeObject(this);
        }
    }
    
    public void explode(){
        this.setImage("explosion_klein.png");
        this.explode = true;
    }
}
