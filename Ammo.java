import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ammo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ammo extends Item
{
    public Ammo(Rakete rakete){
        super(rakete);
    }
    
    public void action(){
        meineRakete.addAmmo(50);
        Greenfoot.playSound("ammo.wav");
        remove = true;
    }
}
