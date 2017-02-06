import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

/**
 * Created by Markus on 05.02.2017.
 */
public class Program {


    public static void main(String[] args) {


        //Alte Liste
        List<Article> old;
        File desktop1 = new File(System.getProperty("user.home"), "Desktop" + "\\alt.csv");
        old = Parser.createList(desktop1);

        //Neue Liste
        List<Article> neu;
        File desktop2 = new File(System.getProperty("user.home"), "Desktop" + "\\neu.csv");
        neu = Parser.createList(desktop2);


        List<Article> delArticle = new ArrayList<Article>();
        File writeDel = new File(System.getProperty("user.home"), "Desktop" + "\\gelöschteArtikel.csv");


        List<Article> newArticle = new ArrayList<Article>();
        File writeNew = new File(System.getProperty("user.home"), "Desktop" + "\\neueArtikel.csv");


        List<Article> unchangedArticle = new ArrayList<Article>();
        File writeUnchanged = new File(System.getProperty("user.home"), "Desktop" + "\\unveraenderteArtikel.csv");


        //Alt vorhanden in neu vorhanden Preis, Bestand
        //gelöschte Artikel ausfindig machen
        for (Article article : old) {

            //Artikel in neuer Liste enthalten?
            if (neu.contains(article)) {


                //Funktioniert nicht liste wird nicht verglichen
                //Artikel übernehmen keine Preis oder Bestandsänderung
                if ((Parser.compareStock(old, neu,article.getId()))) {

                    unchangedArticle.add(article);
                    Parser.createFile(writeUnchanged, unchangedArticle);
                } else {
                    //System.out.println(article.getId());
                }
                // System.out.println(article);
            }


            //Artikel wurde gelöscht d.h. nicht mehr in neuer Liste
            if (!(neu.contains(article))) {

                //In neue Liste mit gelöschten Artikeln übernehmen
                delArticle.add(article);
                Parser.createFile(writeDel, delArticle);

            }
        }

        //Neue Artikel ausfindig machen
        for (Article article : neu) {
            if (!(old.contains(article))) {
                newArticle.add(article);
                Parser.createFile(writeNew, newArticle);
            }

        }


    }


}
