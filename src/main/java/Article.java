/**
 * Created by Markus on 05.02.2017.
 */
public class Article {


    private String id;
    private String name;
    private String ean;
    private String bestand;
    private String preis;



    public Article(String id, String name, String ean, String bestand, String preis)
    {
        this.id = id;
        this.name = name;
        this.ean = ean;
        this.bestand = bestand;
        this.preis = preis;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getBestand() {
        return bestand;
    }

    public void setBestand(String bestand) {
        this.bestand = bestand;
    }

    public String getPreis() {
        return preis;
    }

    public void setPreis(String preis) {
        this.preis = preis;
    }

    @Override
    public String toString()
    {
        return "ID: " + id + " ";
    }

    @Override
    public boolean equals(Object object)
    {
        boolean returnvalue = false;

        if(object instanceof Article) {
            Article obj = (Article) object;
            returnvalue = obj.id.equals(this.id);

        }
        return returnvalue;

    }

    public static boolean equateBestand(String bestand, String  bestand2 ) {
        return (bestand==null) ? (bestand2 == null) : bestand.equals(bestand2);
    }

    public static boolean equatePreis(String preis, String  preis2 ) {
        return (preis==null) ? (preis2 == null) : preis.equals(preis2);
    }


}
