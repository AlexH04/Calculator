package view_control;
//todo: allow user to specify magnitude of graph (ie how much it is zoomed in)
//for instance: magnitude 0.1 mean every dot on the graph is 0.1
//achieve this by multiplying all values by 10 before rounding to int

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.Window;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import util.Math.OPERATOR;

import javax.swing.*;
import java.awt.*;

public class Graph extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Graph frame = new Graph();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    JLabel prompt = new JLabel("Please enter the a value:");
    JTextField inputBox = new JTextField(10);
    JTextField inputBox2 = new JTextField(10);
    JTextField inputBox3 = new JTextField(10);
    JTextField inputBox4 = new JTextField(10);
    public static String a = null;
    public static String b = null;
    public static String c = null;
    public static String d= null;

    public Graph () { //constructor
        inputBox.setBounds(50, 140, 300, 40);
        inputBox2.setBounds(50, 140, 300, 40);
        inputBox3.setBounds(50, 140, 300, 40);
        inputBox4.setBounds(50, 140, 300, 40);
        inputBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = inputBox.getText(); //gets text from user input in textbox
                promptB(); //prompts for second input
            }
        });

        prompt.setBounds(50, 86, 300, 40);

        getContentPane().setBackground(new Color(175, 238, 238));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1920, 1080); //sets size of the window
        getContentPane().setLayout(null);

        getContentPane().add(prompt);
        getContentPane().add(inputBox);
    }

    private void promptB() {
        getContentPane().removeAll(); //removes previous prompt
        repaint(); //leaves background color intact
        inputBox2.setText(""); //resets the text box
        prompt.setText("Please enter the b value:"); //changes the prompt
        getContentPane().add(prompt);
        getContentPane().add(inputBox2);
        inputBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = inputBox2.getText();
                promptC(); //prompts for third input
            }
        });
    }

    private void promptC() {
        getContentPane().removeAll();
        repaint();
        inputBox3.setText("");
        prompt.setText("Please enter the c value:");
        getContentPane().add(prompt);
        getContentPane().add(inputBox3);
        inputBox3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = inputBox3.getText();
                c = inputBox3.getText();
                promptD(); //prompts for third input
            }
        });
    }

    private void promptD() {
        getContentPane().removeAll();
        repaint();
        inputBox4.setText("");
        prompt.setText("Please enter the d value:");
        getContentPane().add(prompt);
        getContentPane().add(inputBox4);
        inputBox4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d = inputBox4.getText();
                graph(a, b, c, d);
            }
        });
    }

    private void graph(String a1, String b1, String c1, String d1) {

        try {
            double numTest = (double)Integer.parseInt(a1);
        } catch (NumberFormatException nfe) {
            getContentPane().removeAll();
            repaint();
            prompt.setText("Please enter only numbers:");
            Graph newGraph1 = new Graph();
            System.out.println("failed");
            return;
        }

        try {
            double numTest = (double)Integer.parseInt(b1);
        } catch (NumberFormatException nfe) {
            getContentPane().removeAll();
            repaint();
            prompt.setText("Please enter only numbers:");
            Graph newGraph1 = new Graph();
            System.out.println("failed");
            return;
        }

        try {
            double numTest = (double)Integer.parseInt(c1);
        } catch (NumberFormatException nfe) {
            getContentPane().removeAll();
            repaint();
            prompt.setText("Please enter only numbers:");
            Graph newGraph1 = new Graph();
            System.out.println("failed");
            return;
        }

        try {
            double numTest = (double)Integer.parseInt(d1);
        } catch (NumberFormatException nfe) {
            getContentPane().removeAll();
            repaint();
            prompt.setText("Please enter only numbers:");
            Graph newGraph1 = new Graph();
            System.out.println("failed");
            return;
        }

        double prevy = -376583.000005; //I don't know why I put this value
        JLabel[][] graph = new JLabel[101][101];
        double sola, solb, vertexX;
        double a = Double.parseDouble(a1), b = Double.parseDouble(b1), c = Double.parseDouble(c1), d = Double.parseDouble(d1);

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (i == 50) {
                    graph[i][j] = new JLabel("-");
                }
                else if (j == 50) {
                    graph[i][j] = new JLabel("|");
                }
                else {
                    graph[i][j] = new JLabel(" ");
                }
            }
        }

        for (double x = -50.0; x <= 50.0; x += 0.01) { //graphs into a 2d array
            double y = (a * x * x * x + b * x * x + c * x + d); //plugs in x

            if ((int)(Math.round(y)) != prevy){
                if (Math.abs(y) < 50.0 && Math.abs(x) < 50.0 && Math.abs(y) > -50.0){
                    graph[50 - (int)(Math.round(y))][50 + (int)(Math.round(x))].setText("0");
                    //50 is the axes
                    //eg if y is -20, the program puts a 0 in the 2d array at row 50 - (-20) = row 70 from the top
                    //if x is q0, the program puts a 0 in column 50 + q0 = column 60 of the 2d array
                    //so "0" is inserted at (60, 70) or (10, -20) in graphical terms
                }
                prevy = (int)(Math.round(y));
            }
        }
        //print out the 2d array as a new window
        getContentPane().removeAll();
        repaint();

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                graph[i][j].setBounds(0 + 10 * j, 0 + 10 * i, 10, 10);
                getContentPane().add(graph[i][j]); //shows jlabel on the window
            }
        }
        
        if ((int)a == 0 && (int)b != 0) { //if quadratic
            if (((int)c * (int)c - 4 * (int)b * (int)d) > 0) { //check if quadratic has 0, 1, or 2 solutions
                JLabel Sol1 = new JLabel();
                Sol1.setBounds(1100, 50, 500, 40);

                sola = ((c - c - c + Math.sqrt(c * c - 4 * b * d)) / (2 * b)); //quadratic formula
                solb = ((c - c - c - Math.sqrt(c * c - 4 * b * d)) / (2 * b));
                Sol1.setText("Roots (quadratic): " + sola + ", " + solb);
                getContentPane().add(Sol1);

                JLabel Vert1 = new JLabel();
                Vert1.setBounds(1100, 100, 500, 40);
                vertexX = -(c / (2 * b)); //x-val of vertex
                Vert1.setText("Vertex (quadratic): (" + vertexX + "," + (b * vertexX * vertexX + c * vertexX + d) + ")"); //y-val of vertex
                getContentPane().add(Vert1);
            } else if (((int)c * (int)c - 4 * (int)b * (int)d) == 0) {
                JLabel Sol2 = new JLabel();
                Sol2.setBounds(1100, 50, 500, 40);

                sola = ((c - c - c + Math.sqrt(c * c - 4 * b * d)) / (2 * b));
                Sol2.setBounds(1100, 50, 100, 40);
                Sol2.setText("Root (quadratic): " + sola);
                getContentPane().add(Sol2);

                JLabel Vert2 = new JLabel();
                Vert2.setBounds(1100, 100, 500, 40);
                vertexX = -(c / (2 * b));
                Vert2.setText("Vertex (quadratic): (" + vertexX + "," + (b * vertexX * vertexX + c * vertexX + d) + ")");
                getContentPane().add(Vert2);
            } else {
                JLabel Sol3 = new JLabel();
                Sol3.setBounds(1100, 50, 500, 40);

                Sol3.setBounds(1100, 50, 500, 40);
                Sol3.setText("No real solutions");
                getContentPane().add(Sol3);

                JLabel Vert3 = new JLabel();
                Vert3.setBounds(1100, 100, 500, 40);
                vertexX = -(c / (2 * b));
                Vert3.setText("Vertex (quadratic): (" + vertexX + "," + (b * vertexX * vertexX + c * vertexX + d) + ")");
                getContentPane().add(Vert3);
            }
        } else if ((int)a == 0 && (int)b == 0 && (int)c != 0) { //if linear
            JLabel Sol4 = new JLabel();
            Sol4.setBounds(1100, 50, 500, 40);

            Sol4.setText("Solution (linear): " + (d - d - d) / c); //formula for solution of linear
            getContentPane().add(Sol4);
        }

        JLabel Yint = new JLabel();
        Yint.setBounds(1100, 50, 500, 40);

        Yint.setBounds(1100, 150, 500, 40);
        Yint.setText("Y-intercept: " + d);
        getContentPane().add(Yint);
    }
}
