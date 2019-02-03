//**********************************************************************
//  RocketKaylaRobinson.java       Author: Kayla Robinson
//
//  CSC 295
//  Due Date: February 8, 2019
//  Description: This program demonstrates the Graphic and JApplet class.
//  It uses random color generation for the wings & rocket detail/thruster.
//
//  File path: C:\Users\Kayla\Desktop\csc295
//  <applet code ="RocketKaylaRobinson.class" width=300 height=300>
//
//**********************************************************************

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class RocketKaylaRobinson extends JApplet
{

    public void init() {
        add(new GraphicPanel());
        validate();
    }
}

class GraphicPanel extends JPanel
{
    final int MID = 375;
    final int TOP = 0;

    // Create object with background color
    Color nightSky = new Color(6, 29, 66);

    GraphicPanel() {
        this.setBackground(nightSky);
    }

    public void paint (Graphics page) {

        super.paintComponent(page);

        /**********************   ROCKET BODY    ***************************/
        // Create array for rocket shape
        int rocketBodyX[] = {MID-100, MID-100, MID,    MID+100, MID+100};
        int rocketBodyY[] = {TOP+475, TOP+150, TOP+25, TOP+150, TOP+475};

        // Draw and fill rocket body with random color
        page.setColor(Color.gray);
        page.fillPolygon(rocketBodyX, rocketBodyY, 5);

        /*********************   ROCKET WINGS   ****************************/
        // Create array for left rocket wing
        int rocketLWingX[] = {MID-100, MID-100, MID-200};
        int rocketLWingY[] = {TOP+460, TOP+260, TOP+460};

        // Create array for right rocket wing
        int rocketRWingX[] = {MID+100, MID+100, MID+200};
        int rocketRWingY[] = {TOP+460, TOP+260, TOP+460};

        // Draw and fill rocket wings with random color
        page.setColor(createRandomColor());
        page.fillPolygon(rocketLWingX, rocketLWingY, 3);
        page.fillPolygon(rocketRWingX, rocketRWingY, 3);

        /*********************   ROCKET DETAIL   ****************************/
        // Draw and fill rectangles to add detail/thrusters to rocket body
        page.setColor(createRandomColor());
        page.fillRect(MID-100, TOP+150, 200, 20);      // top detail on body
        page.fillRect(MID-100, TOP+435, 200, 20);      // bottom detail on body
        page.fillRect(MID-55, TOP+475, 110, 40);       // thruster

        // Add USA text to rocket body


        /*********************   ROCKET WINDOW   ****************************/
        // Draw and fill overlapping circles for rocket window
        Color window = new Color(229, 236, 236);
        page.setColor(Color.darkGray);
        page.fillOval(MID-55, TOP+255, 110, 110);       // window panel
        page.setColor(window);
        page.fillOval(MID-50, TOP+260, 100, 100);       // window
        
        //********************   BACKGROUND SKY   *****************************/
        // Draw and fill stars in background
        Color starYellow = new Color(239, 237, 174);
        page.setColor(starYellow);
        drawStar(page, MID-220, TOP+110);                     // left/upper star
        drawStar(page, MID+220, TOP+210);                     // right star
        drawStar(page, MID-270, TOP+560);                     // left/lower star
        
        // Draw and fill Earth below rocket
        drawEarth(page);
        
        // Signature
        page.setColor(Color.white);
        page.drawString("Kayla Dio Robinson", MID+200, TOP+600);

        /*********************   ROCKET FLAMES   ****************************/
        // outer flame
        page.setColor(Color.orange);
        int outerFlameX[] = {MID-55,  MID-100, MID-75,  MID-75,  MID-40,  MID,     MID+40,  MID+75,  MID+75,  MID+100,  MID+55};
        int outerFlameY[] = {TOP+515, TOP+600, TOP+575, TOP+700, TOP+630, TOP+740, TOP+630, TOP+700, TOP+575, TOP+600, TOP+515};
        page.fillPolygon(outerFlameX, outerFlameY, 11);

        // inner flame
        page.setColor(Color.yellow);
        int innerFlameX[] = {MID-45,  MID-90,  MID-65,  MID-65,  MID-30,  MID,     MID+30,  MID+65,  MID+65,  MID+90,  MID+45};
        int innerFlameY[] = {TOP+515, TOP+590, TOP+565, TOP+690, TOP+620, TOP+730, TOP+620, TOP+690, TOP+565, TOP+590, TOP+515};
        page.fillPolygon(innerFlameX, innerFlameY, 11);

    }

    Color createRandomColor () {
        // Create random color object that is not the same as background
        int r, g, b;
        Random rd = new Random();

        r = rd.nextInt(255);
        g = rd.nextInt(255);
        b = rd.nextInt(255);
        Color randomColor = new Color(r,g,b);

        if (randomColor != nightSky && randomColor != Color.gray)
            return randomColor;
        else
            return createRandomColor();
    }
    
    void drawEarth (Graphics page) {
        Color earthBlue = new Color(140,184,255);
        Color earthGreen = new Color(63,122,65);
        
        // water of earth
        page.setColor(earthBlue);
        page.fillOval(0, TOP+650, 750, 500);            // water of earth
        
        // continent 1 (left side)
        page.setColor(earthGreen);
        int continentX[] = {MID-270, MID-245, MID-150, MID-75,  MID-75,  MID-40};
        int continentY[] = {TOP+750, TOP+725, TOP+700, TOP+730, TOP+740, TOP+750};
        page.fillPolygon(continentX,continentY,6);
        
        // continent 2 (right side)
        int continent2X[] = {MID+65,  MID+150, MID+200,  MID+250,  MID+275};
        int continent2Y[] = {TOP+750, TOP+700, TOP+715,  TOP+730, TOP+750};
        page.fillPolygon(continent2X,continent2Y,5);
        
        // continent 3 (middle)
        int continent3X[] = {MID+20,  MID+67,  MID+85,  MID+70,  MID+30};
        int continent3Y[] = {TOP+690, TOP+650, TOP+710,  TOP+720, TOP+730};
        page.fillPolygon(continent3X,continent3Y,5);
    }
    
    void drawStar (Graphics page, int x, int y) {
        // x = starting point on x-axis
        // y = starting point on y-axis
        int starX[] = {x, x-20, x-40, x+10,  x-50};
        int starY[] = {y, y-50, y,    y-30,  y-30};
        page.fillPolygon(starX,starY,5);
    }


}
