import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Markus on 05.02.2017.
 */
public class Parser {


    public static List<Article> createList(File file) {

        String line = "";
        String cvsSplitBy = ";";

        List<Article> list = new ArrayList<Article>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {


                Article article = null;

                // use ; as separator
                String[] text = line.split(cvsSplitBy);

                article = new Article(text[0], text[1], text[2], text[3], text[4]);

                list.add(article);

                //System.out.println("Country [code= " + text[1] + " , name=" + text[2] + "]");

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;

    }

    public static void createFile(File file, List<Article> list) {

        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(file));
            out.write("Artikelnr. ;" + "Name ;" + "EAN ;" + "Bestand ;" + "Preis ;" + "\n");

            for (Article article : list) {

                out.write(article.getId() + ";" + article.getName() + ";" + article.getEan() + ";" + article.getBestand() + ";" + article.getPreis() + "\n");
            }

        } catch (IOException e) {

            System.out.println(e.getMessage());
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ioe) {
                    // do nothing
                }
            }

        }

    }

    public static boolean compareStock(List<Article> fristList, List<Article> secondList, String id) {


        for (Article secondListData : secondList) {
            for (Article fristListData : fristList) {
               // if(fristListData.getId().equals(id)) {
                if(fristListData.getId() == id) {
                    if (Article.equateBestand(fristListData.getBestand(), secondListData.getBestand())) {
                        return true;
                    }
                }

            }

        }

        return false;

    }

    public static boolean comparePrice(List<Article> fristList, List<Article> secondList, String id) {


        for (Article secondListData : secondList) {
            for (Article fristListData : fristList) {
                // if(fristListData.getId().equals(id)) {
                if(fristListData.getId() == id) {
                    if (Article.equatePreis(fristListData.getPreis(), secondListData.getPreis())) {
                        return true;
                    }
                }

            }

        }

        return false;

    }


}
