import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hit extends Actor
{
    private int removeCounter = 0;

    public void act()
    {
        if(removeCounter%3==0){
            this.setLocation(this.getX() + 1, this.getY() - 1);
        }
        
        if(removeCounter == 25){
            this.getImage().scale(100,100);
        }
        if(removeCounter++ > 50){
            this.getWorld().removeObject(this);
        }
        
    }
}
