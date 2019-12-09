/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 3, 2019 10:33:08 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan10;

import java.util.concurrent.Callable;

/**
 *
 * @author od3ng
 */
public class Tost implements Callable<Long> {

    @Override
    public Long call() throws Exception {
        Long total = new Long(0);
        for (long i = 0; i < 5; i++) {
            total += i;
        }
        return total;
    }

}
