/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rotierendegerade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;


  /**
   * @param args the command line arguments
   */
  public class Start
  {
    public Start()
    {
      JFrame frm = new JFrame();
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = frm.getContentPane();
      c.setLayout(new BorderLayout());
      c.setBackground(Color.LIGHT_GRAY);
      Line line = new Line(1000);
      c.add(line);
      frm.setSize(600, 600);
      frm.setVisible(true);
      line.startThread();
      
      
    }
    
    public static void main(String[] args) 
  {
    new Start();
  }
}
