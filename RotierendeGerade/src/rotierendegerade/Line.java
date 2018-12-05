/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rotierendegerade;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author nobody
 */

public class Line extends JComponent implements Runnable
{
  private Line2D.Float line;
  private BasicStroke pinsel;
  private static final float DICKE = 8f;
  private float angle;
  private Thread thd;
  private long time;
  
  public Line(long time)
  {
    pinsel = new BasicStroke(DICKE);
    line = new Line2D.Float();
    angle = 0;
    this.time = time;
    
  }
  
  public void startThread()
  {
    thd = new Thread(this);
    thd.start();
  }

  @Override
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                        RenderingHints.VALUE_ANTIALIAS_ON);
    
    int breite = this.getWidth() - 1;
    int hoehe = this.getHeight() - 1;
    
    double radius= Math.min(breite,hoehe)/2;  
    
    g2.setStroke(pinsel);
    
    this.line.setLine(breite/2.0, hoehe/2.0, 
                (breite/2.0) + radius * Math.cos(Math.toRadians(angle)),
                (hoehe/2.0) + radius * Math.sin(Math.toRadians(angle)));
    
    g2.draw(line);
  }

  @Override
  public void run()
  {
    while(true){
      try
      {
        Thread.sleep(time);
                }
      catch (InterruptedException ex)
      {
        Logger.getLogger(Line.class.getName()).log(Level.SEVERE, null, ex);
      }
      angle += 6;
      if(angle == 360)
        angle = 0;
      this.repaint();
    }
  }
}
