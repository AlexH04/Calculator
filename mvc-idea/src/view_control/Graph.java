package view_control;

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
    private final JLabel graphArea = new JLabel("");

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
    public static String a = null;
    public static String b = null;
    public static String c = null;
    public static String d= null;

    public Graph () { //constructor
        inputBox.setBounds(50, 140, 300, 40);
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
        setBounds(100, 100, 418, 315);
        getContentPane().setLayout(null);
        graphArea.setForeground(Color.WHITE);
        graphArea.setFont(new Font("Lucida Grande", Font.PLAIN, 72));
        graphArea.setHorizontalAlignment(SwingConstants.RIGHT);
        graphArea.setBounds(18, 6, 377, 67);
        getContentPane().add(graphArea);

        getContentPane().add(prompt);
        getContentPane().add(inputBox);
    }

    private void promptB() {
        getContentPane().removeAll(); //removes previous prompt
        repaint(); //leaves background color intact
        inputBox.setText(""); //resets the text box
        prompt.setText("Please enter the b value:"); //changes the prompt
        getContentPane().add(prompt);
        getContentPane().add(inputBox);
        inputBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = inputBox.getText();
                promptC(); //prompts for third input
            }
        });
    }

    private void promptC() {
        getContentPane().removeAll();
        repaint();
        inputBox.setText("");
        prompt.setText("Please enter the c value:");
        getContentPane().add(prompt); //this still displays b for some reason
        getContentPane().add(inputBox);
        inputBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = inputBox.getText();
                promptD(); //prompts for third input
            }
        });
    }

    private void promptD() {
        getContentPane().removeAll();
        repaint();
        inputBox.setText("");
        prompt.setText("Please enter the d value:");
        getContentPane().add(prompt); //this still displays b for some reason
        getContentPane().add(inputBox);
        inputBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d = inputBox.getText();
                graph(a, b, c, d);
            }
        });
    }

    private void graph(String a, String b, String c, String d) {
        //c++ code goes here
        //print out the 2d array as a giant label
    }
}
