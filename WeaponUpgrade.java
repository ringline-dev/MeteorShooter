import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WeaponUpgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponUpgrade extends Item
{
    public WeaponUpgrade(Rakete rakete){
        super(rakete);
    }
    
    public void action(){
        meineRakete.increaseShootingSpeed();
        Greenfoot.playSound("ammo.wav");
        remove = true;
    }
}
