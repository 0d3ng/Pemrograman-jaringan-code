/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 3, 2019 2:04:57 PM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan10.tugas;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

/**
 *
 * @author od3ng
 */
public class MessageService implements Callable<String> {

    private static final SimpleDateFormat FORMAT_HOUR = new SimpleDateFormat("HH:mm:ss a");

    @Override
    public String call() throws Exception {
        Date d = new Date();
        String stringDate = FORMAT_HOUR.format(d);
        return stringDate + "-> " + StringGenerator.Generated();
    }

}
