/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 3, 2019 1:48:47 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan10.tugas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author od3ng
 */
public class Clock implements Runnable, ClockUpdater {

    private static final SimpleDateFormat FORMAT_DATE = new SimpleDateFormat("dd MMM yyyy");
    private static final SimpleDateFormat FORMAT_HOUR = new SimpleDateFormat("HH:mm:ss a");
    
    private MessageGenerator generator;

    public Clock(MessageGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        while (true) {            
            try {
                Date d = new Date();
                String date = FORMAT_DATE.format(d);
                String hour = FORMAT_HOUR.format(d);
                onChanged(date, hour);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Clock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void onChanged(String date, String hour) {
        generator.getLbDate().setText(date);
        generator.getLbHour().setText(hour);
    }

}
