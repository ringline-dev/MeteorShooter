import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Item extends Actor
{
    private int existCounter = 0;
    private int existLimit = 400;
    public Rakete meineRakete;
    public boolean remove = false;
    
    
    public Item(Rakete rakete){
        meineRakete = rakete;
    }
    
    public void act()
    {
        if(existCounter++ == existLimit){
            remove = true;
        }
        if(this.getX() + 20 >= meineRakete.getX() - 24 && 
            this.getX() -20 <= meineRakete.getX() + 24 &&
            this.getY() + 30 >= meineRakete.getY() - 45 &&      
            this.getY() -30 <= meineRakete.getY() + 45)
        {
            action();
        }
        if(remove){
            this.getWorld().removeObject(this);
        }
    }
    
    public abstract void action();
}
