package com.eujin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBar {

    private JFrame mainFrame;
    private JButton startButton;
    private JProgressBar progressBar;
    private Task task;

    public ProgressBar() {
        mainFrame = new JFrame("Progress bar Example");
        mainFrame.setSize(600,400);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(3);

        startButton = new JButton("Start");
        startButton.setBounds(50,50,100,50);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                task = new Task();
                task.start();
                //JOptionPane.showMessageDialog(null, "Finish");
            }
        });

        progressBar = new JProgressBar(0,100);
        progressBar.setBounds(50,150,500,50);
        progressBar.setStringPainted(true);

        mainFrame.add(progressBar);
        mainFrame.add(startButton);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new ProgressBar();
	// write your code here
    }

    private class Task extends Thread{

        @Override
        public void run() {
            for (int i = 0; i <= 100 ; i++) {
                progressBar.setValue(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
