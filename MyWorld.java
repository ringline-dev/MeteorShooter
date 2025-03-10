import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class MyWorld extends World 
{

    private Rakete rakete; //Datentyp + Variablenname
    private int meteorCount = 0;
    private int energieCount = 0;
    private int score = 0;
    private GreenfootSound backgroundMusic;
    private boolean started = false;
    private int scoreCount = 0;
    private int meteorGroundSpeed = 1;
    private int meteorSpeedCounter = 0;
    private int meteorLimit = 70;
    private int addonCount = 0;
    private int addonLimit = 240 + Greenfoot.getRandomNumber(450);
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1); 
        score = 0;
        rakete = new Rakete();
        rakete.setRotation(270);
        this.addObject(rakete, 450, 550);
        this.showInfo();
        backgroundMusic = new GreenfootSound("background.mp3");
        backgroundMusic.setVolume(50);
    }
    
    public void act(){
        if (meteorSpeedCounter > 500){
            meteorSpeedCounter = 0;
            meteorGroundSpeed++;
            meteorLimit -= 10;
            meteorCount = 0;
        }
        if(!started){
            started=true;
            backgroundMusic.play();
        }
        if(scoreCount++%20==0){
            score++;
            meteorSpeedCounter++;
        }
        if(meteorCount++ == meteorLimit){
            meteorCount = 0;
            int meteorSpeed = meteorGroundSpeed + Greenfoot.getRandomNumber(3);
            this.addObject(new Meteor(rakete, meteorSpeed), Greenfoot.getRandomNumber(900), 0);
        }
        if(addonCount++ == addonLimit){
            Item item = null;
            int choose = 1+Greenfoot.getRandomNumber(20);
            if(choose <=12){
                item = new Ammo(rakete);
    } else if(choose <= 16){
                item = new WeaponUpgrade(rakete);
            } else{
                item = new SpeedUpgrade(rakete);
            }
            this.addObject(item, 50 + Greenfoot.getRandomNumber(800), 100 + Greenfoot.getRandomNumber(400));
            addonCount = 0;
            addonLimit = 250 + Greenfoot.getRandomNumber(500);
        }
        if(energieCount++ == 500){
            energieCount = 0;
            this.addObject(new Energie(rakete), 0, 50 + Greenfoot.getRandomNumber(400));
        }
        this.showInfo();
    }
    
    private void showInfo(){
        this.showText("Score: " + Integer.toString(this.score), 800,20);
        this.showText("Energie: " + Integer.toString(rakete.getEnergy()), 800, 43);
        this.showText("Ammo: " + Integer.toString(rakete.getAmmo()), 800, 66);
    }
    
    public int getScore(){
        return score;
    }
    
    public void addScore(int add){
        this.score += add;
        this.meteorSpeedCounter += add;
     }
    
    public void stopMusic(){
        this.backgroundMusic.stop();
    }
    
}

