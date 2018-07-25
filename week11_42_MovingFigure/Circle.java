/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movingfigure;

import java.awt.Graphics;


public class Circle extends Figure{
    private int diameter;
    
    public Circle(int x, int y, int d){
        super(x,y);
        diameter = d;
    }
        
    @Override
    public void draw(Graphics graphics) {
        graphics.fillOval(getX(), getY(), diameter, diameter);
    }
}
