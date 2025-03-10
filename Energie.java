import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class Energie extends Actor
{
    private Rakete meineRakete;
    private int speed;
    private boolean remove;
    private MyWorld myWorld;
    
    public Energie(Rakete rakete){
        meineRakete = rakete;
        speed = 3;
        remove = false;
        this.getImage().scale(80, 80);
        
    }
    
    public void act()
    {
        if(myWorld == null){
            myWorld = (MyWorld) this.getWorld();
        }
        this.setLocation(this.getX() + speed, this.getY() -Greenfoot.getRandomNumber(20)+ Greenfoot.getRandomNumber(20));
        
        if(this.getX() + 20 >= meineRakete.getX() - 24 && 
            this.getX() -20 <= meineRakete.getX() + 24 &&
            this.getY() + 20 >= meineRakete.getY() - 45 &&      
            this.getY() -20 <= meineRakete.getY() + 45)
        {
            meineRakete.addEnergy();
            myWorld.addScore(100);
            remove = true;
        }
        
        if(this.getX() > 890){
            remove = true;
        }
        
        if(remove){this.getWorld().removeObject(this);}
    }
    
    
}
