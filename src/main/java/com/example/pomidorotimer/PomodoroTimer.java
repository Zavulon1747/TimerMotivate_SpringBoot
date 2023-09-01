package com.example.pomidorotimer;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Component
public class PomodoroTimer {

    private AtomicBoolean isRunning = new AtomicBoolean(false);

    long endTime = 0;

    public void timer(int hours, int minutes, int seconds) {
        AtomicInteger hoursCounter = new AtomicInteger(hours);
        AtomicInteger minutesCounter = new AtomicInteger(minutes);
        AtomicInteger secondsCounter = new AtomicInteger(seconds);
        StringBuffer description = new StringBuffer("");
//

        JFrame frame = new JFrame("Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
        JLabel label = new JLabel();
        frame.add(label);

        JTextField hoursField = new JTextField(2);
        JTextField minutesField = new JTextField(2);
        JTextField secondsField = new JTextField(2);
        JTextField descriptionField = new JTextField(2);

        JPanel panel = new JPanel();
        panel.add(hoursField);
        panel.add(minutesField);
        panel.add(secondsField);
        panel.add(descriptionField);


        JButton button = new JButton("Set");

        button.addActionListener(e -> {
            hoursCounter.set(Integer.parseInt(hoursField.getText()));
            minutesCounter.set(Integer.parseInt(minutesField.getText()));
            secondsCounter.set(Integer.parseInt(secondsField.getText()));
            description.append(descriptionField.getText());
            isRunning.set(true);
        });
        panel.add(button);
        frame.add(panel);

        //from current time to end time and show it in the center of the frame
        label.setText(String.format("%02d:%02d:%02d", hoursCounter.get(), minutesCounter.get(), secondsCounter.get()));
        label.setLocation(100, 0);
        label.setFont(new Font(label.getName(), Font.BOLD, 40));




        ImageIcon image = new ImageIcon("src/main/resources/images/background.jpg");
        frame.add(new JLabel(image, JLabel.CENTER));
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);

        //start timer
        startTimer(hoursCounter, minutesCounter, secondsCounter, label, description);


        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("src/main/resources/sounds/Чика.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-10.0f);
            JOptionPane.showMessageDialog(frame, "Time is up!");
            clip.stop();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //method to start timer and change label every second
    private void startTimer(AtomicInteger hoursCounter, AtomicInteger minutesCounter, AtomicInteger secondsCounter, JLabel label, StringBuffer description) {
        while (!isRunning.get()) {
            endTime = System.currentTimeMillis() + (hoursCounter.get() * 60 * 60 * 1000) + (minutesCounter.get() * 60 * 1000) + (secondsCounter.get() * 1000);
        }

        while (System.currentTimeMillis() < endTime) {
            long timeLeft = endTime - System.currentTimeMillis();
            int hoursLeft = (int) timeLeft / (1000 * 60 * 60);
            int minutesLeft = (int) (timeLeft - hoursLeft * 1000 * 60 * 60) / (1000 * 60);
            int secondsLeft = (int) (timeLeft - hoursLeft * 1000 * 60 * 60 - minutesLeft * 1000 * 60) / 1000;
            label.setText(String.format("%02d:%02d:%02d", hoursLeft, minutesLeft, secondsLeft));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}


