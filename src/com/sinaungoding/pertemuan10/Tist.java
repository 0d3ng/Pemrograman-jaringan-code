/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Nov 3, 2019 6:06:53 AM
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
public class Tist implements Callable<String> {

    private String name;

    public Tist(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        return name + " Message from Callable";
    }

}
