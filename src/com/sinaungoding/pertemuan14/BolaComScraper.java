/*
 * Pemrograman-jaringan

 * Copyright (c) 2019
 * All rights reserved.
 * Written by od3ng created on Dec 9, 2019 9:09:17 AM
 * Blog    : sinaungoding.com
 * Email   : lepengdados@gmail.com
 * Github  : 0d3ng
 * Hp      : 085878554150
 */
package com.sinaungoding.pertemuan14;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author od3ng
 */
public class BolaComScraper {

    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect("https://www.bola.com/sea-games").get();
            //digunakan untuk mengambil section
            Elements els = document.select("section.content-promotion--stm__wrapper");
            //parsing kembali ke dalam bentuk document
            Document parse = Jsoup.parse(els.html());
            Elements allElements = parse.select("div.content-promotion--stm__item");
            for (Element element : allElements) {
                Elements allElements2 = element.getAllElements();
                for (int i = 0; i < allElements2.size(); i++) {
                    System.out.println(""+allElements2.get(i).tagName());
                    switch (i) {
                        case 10:
                            System.out.println("" + allElements2.get(i).text());
                            break;
                    }

                }
            }

//            Elements select = parse.select("div#content-promotion-*");
//            System.out.println(""+select.size());
        } catch (IOException ex) {
            Logger.getLogger(BolaComScraper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
