/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Dec 9, 2019 12:31:56 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan14;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author od3ng
 */
public class BliBliScrapper {

    public static void main(String[] args) {
        try {
//            String url = "https://www.blibli.com/c/3/samsung/SA-1000110/54593?page=1"
//                    + "&start=0&category=SA-1000110&sort=";
            String url = "https://www.blibli.com/amp/c/3/samsung/SA-1000110/54593";
            Validate.isTrue(true, "URL " + url + " tidak dapat diakses");
            System.out.println("Fetching " + url + " ...");
            Document document = Jsoup.connect(url).get();
            Elements div = document.select("div.product-item");
            div.stream().forEach(el -> {
                Elements allElements = el.getAllElements();
                for (int i = 0; i < allElements.size(); i++) {
                    switch (i) {
                        case 2://image
                            System.out.println("" + allElements.get(i).attr("src"));
                            break;
                        case 3://detail
                            System.out.println("" + allElements.get(i).text());
                            break;
                        case 5://harga
                            System.out.println("" + allElements.get(i).text());
                            break;
                        case 7://produk yang sama
                            System.out.println("" + allElements.get(i).text());
                            break;
                        case 15://komentar
                            System.out.println("" + allElements.get(i).text());
                            break;
                    }

                }
            });
        } catch (IOException ex) {
            Logger.getLogger(BliBliScrapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
