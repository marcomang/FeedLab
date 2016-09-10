package com.mm;


import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.BorderLayout;

/**
 * Created by marcomanglaviti on 16-09-10.
 */
public class Map extends JFrame {

    public Map(){

        WorldWindowGLCanvas wwd = new WorldWindowGLCanvas();
        wwd.setPreferredSize(new Dimension(1000, 800));
        this.getContentPane().add(wwd, BorderLayout.CENTER);
        wwd.setModel(new BasicModel());

    }


}
