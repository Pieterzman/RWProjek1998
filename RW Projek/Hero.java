public class Hero
{
  private double xpos, ypos, sightDeg;
  private static final double heroRadius = 2, sightRadius = 0.25, degIncrement = 6;
  
  public Hero() //Initially the hero is in the middle, bottom of the screen pointing up
  {
    xpos = 0;
    ypos = GameScreen.getMinY() + heroRadius; //getMinY gets the lowest point of the canvas
    drawHero();
    sightDeg = Math.toRadians(90);
  }
  
  public void drawHero()
  {
    StdDraw.setPenColor();
    StdDraw.filledCircle(xpos,ypos,heroRadius); //Draws the hero at the current x and y position
  }
  public void drawSight()
  {
    StdDraw.setPenColor(StdDraw.GREEN);
    StdDraw.filledCircle(getSightX(), getSightY(), sightRadius); //Draws the sight at its current x and y position
  }
  
  public double getXPos()
  {
    return xpos;
  }
  
  public double getYPos()
  {
    return ypos;
  }
  
  public double getSightX()
  {
    return xpos + heroRadius*Math.cos(sightDeg);
  }
  public double getSightY()
  {
    return GameScreen.getMinY() + heroRadius*Math.sin(sightDeg) + heroRadius;
  }
  public void setAcceleration(double acceleration)
  {
    //TO DO
  }
  public void setSightDeg(double d)
  {
    sightDeg = Math.toRadians(d);
  }
  public double getSightDeg()
  {
    return Math.toDegrees(sightDeg);
  }
  public void setXPos(double x)
  {
    if(x < getXPos() && ((getXPos()-2) <= GameScreen.getMinX())) //If trying to go left, and it is on or past left border
      return;
    if(x > getXPos() && ((getXPos()+2) >= GameScreen.getMaxX())) //If trying to go right, and it is on or past right border
      return;
    xpos = x;
  }
  
  public static double getHeroRadius()
  {
    return heroRadius;
  }
  
}