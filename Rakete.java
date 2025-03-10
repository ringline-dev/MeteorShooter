import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Rakete extends Actor
{
    private int speed = 2;
    private int explodeCounter = 0;
    private int laserCount = 0;
    private boolean explode = false;
    private int energy = 1;
    private int ammo = 0;
    private int shootingSpeed = 40;
    private MyWorld myWorld;
    private int hitCounter = 0;

    public void act()
    {
        if (myWorld == null) {
            myWorld = (MyWorld) getWorld(); // Welt nur einmal zuweisen
        }
        //Tastatursteuerung
        if(Greenfoot.isKeyDown("up")){
            //if(this.getFlughoehe() < 300){
                this.setLocation(this.getX(),this.getY() - speed);
            //}
        }
        if(Greenfoot.isKeyDown("down")){
            this.setLocation(this.getX(),this.getY() + speed);
        }
        if(Greenfoot.isKeyDown("left")){
            this.setLocation(this.getX() - speed,this.getY());
        }
        if(Greenfoot.isKeyDown("right")){
            this.setLocation(this.getX() + speed,this.getY());
        }
        if(Greenfoot.isKeyDown("Space")){
            if(laserCount%shootingSpeed == 0){
                shoot();
            }
            laserCount++;
        }
        
        if(explode){
            explodeCounter++;
            explode();
        }
    }
    
    private void shoot(){
        if(ammo > 0){
            this.getWorld().addObject(new Laser(), this.getX(), this.getY());
            Greenfoot.playSound("laser.wav");
            ammo--;
        }
            
    }
    
    public int getFlughoehe(){
        int y = this.getY();
        int hoeheWelt = this.getWorld().getHeight();
        int flughoehe = hoeheWelt - y;
        
        return flughoehe;
    }
    
    public void hit(){
        hitCounter++;
        Greenfoot.playSound("bumm.wav");
        if(energy > 0){
            energy--;
        } else{
            explode();
        }
        if(hitCounter == 2){
            hitCounter = 0;
            decreaseShootingSpeed();
            decreaseSpeed();
        }
    }
    
    public void explode(){
        if(!explode){
            explode = true;
            this.setImage("rocket_e.png");
        }
        if(explode && explodeCounter == 20){
            this.setImage("explosion_klein.png");
        }
        if(explode && explodeCounter == 40){
            this.setImage("explosion.png"); 
            Greenfoot.playSound("gameover.wav");
            myWorld.setBackground("Mond_GO.jpg");
            myWorld.stopMusic();
            Greenfoot.stop();
        }

        
    }
    
    public void addEnergy(){
        this.energy++;
        Greenfoot.playSound("energy.wav");
        
    }
    
    public int getEnergy(){
        return energy;
    }
    
    public void addAmmo(int ammo){
        this.ammo += ammo;
    }
    
    public int getAmmo(){
        return ammo;
    }
    
    public void increaseSpeed(){
        this.speed++;
    }
    
    public void increaseShootingSpeed(){
        if(shootingSpeed > 10){
            this.shootingSpeed -= 5;
        }
    }
    
    public void decreaseSpeed(){
        if(speed > 2){
            this.speed--;
        }
    }
    
    public void decreaseShootingSpeed(){
        if(shootingSpeed < 60){
            this.shootingSpeed += 5;
        }
        
    }
}
