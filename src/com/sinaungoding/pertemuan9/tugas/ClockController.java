/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Oct 28, 2019 7:29:43 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan9.tugas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class ClockController {

    private Clock clock;
    private boolean paused, stop;
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("HH:mm:ss a");
    private static final SimpleDateFormat FORMAT_DATE = new SimpleDateFormat("EEEEE, dd MMMMM yyyy");

    public ClockController(Clock clock) {
        this.clock = clock;
        this.clock.setLocationRelativeTo(null);
        startTime();
    }

    private void startTime() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stop) {
                    if (!paused) {
                        Date d = new Date();
                        clock.getLbHour().setText(FORMAT.format(d));
                        clock.getLbDate().setText(FORMAT_DATE.format(d));
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ClockController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }

    public void doStart() {
        if (!paused) {
            clock.getBtStart().setText("RESUME");
            System.out.println("pause");
            paused = true;
        } else {
            System.out.println("stop");
            paused = false;
            clock.getBtStart().setText("PAUSE");
        }

    }

    public void doStop() {
        stop = true;
        clock.getBtStart().setText("START");
    }

}
