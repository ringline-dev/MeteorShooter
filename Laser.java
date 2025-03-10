import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Laser extends Actor
{
    private List<Meteor> meteorList;
    
    public void act()
    {
        this.setLocation(this.getX(), this.getY()-3);
        this.meteorList = this.getWorld().getObjects(Meteor.class);
        
        for(int i = 0; i < meteorList.size(); i++){
            Meteor meteor = meteorList.get(i);
            if(this.getX() + 7 >= meteor.getX() - 26 && 
            this.getX() - 7 <= meteor.getX() + 26 &&
            this.getY() + 13 >= meteor.getY() - 26 &&      
            this.getY() - 13 <= meteor.getY() + 26)
            {
                meteor.explode();
            }
        }
        if(this.getY()<=10){
            this.getWorld().removeObject(this);
        }
    }
}
