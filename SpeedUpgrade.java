import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpeedUpgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedUpgrade extends Item
{
    public SpeedUpgrade(Rakete rakete){
        super(rakete);
    }
    
    public void action(){
        meineRakete.increaseSpeed();
        Greenfoot.playSound("ammo.wav");
        remove = true;
    }
}
