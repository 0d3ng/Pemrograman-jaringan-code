/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 3, 2019 1:42:06 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan10.tugas;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author od3ng
 */
public class MessageGeneratorContoller {

    private static final int NTHREAD = 10;
    private ExecutorService clockService = Executors.newSingleThreadExecutor();
    private ScheduledExecutorService broker = Executors
            .newScheduledThreadPool(NTHREAD);
    private MessageGenerator generator;

    public MessageGeneratorContoller(MessageGenerator generator) {
        this.generator = generator;
        this.generator.setLocationRelativeTo(null);
        startClock();
        startMessage();
    }

    private void startClock() {
        Clock c = new Clock(generator);
        clockService.submit(c);
    }

    private void startMessage() {
        new Thread(() -> {
            for (;;) {
                MessageService service = new MessageService();
                ScheduledFuture<String> schedule = broker.
                        schedule(service, 500, TimeUnit.MILLISECONDS);
                try {
                    String message = schedule.get();
                    message += "\n";
//                    System.out.println("" + message);
                    StyledDocument doc = generator.getTxtPane().getStyledDocument();
                    doc.insertString(0, "", null);
                    doc.insertString(doc.getLength(), message, null);
                } catch (InterruptedException | ExecutionException
                        | BadLocationException ex) {
                    Logger.getLogger(MessageGeneratorContoller.class.getName())
                            .log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

}

interface ClockUpdater {

    void onChanged(String date, String hour);
}
