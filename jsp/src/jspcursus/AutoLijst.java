package jspcursus;
 

import java.util.ArrayList;
import jspcursus.Auto;
 
 
public class AutoLijst {
    private ArrayList<Auto> autolijst;
   
 
    public AutoLijst() {
        autolijst = new ArrayList<Auto>();
        Auto Audi1 = new Auto("Audi", "A1", 23999,
          "image/audi_a3.jpg");
        autolijst.add(Audi1);
        Auto Audi2 = new Auto("Audi", "A3", 45845,
          "image/audi_a3.jpg");
        autolijst.add(Audi2);
        Auto Audi3 = new Auto("Audi", "R8", 125456,
          "image/audi_r8.jpg");
        autolijst.add(Audi3);
        Auto Audi4 = new Auto("Audi", "Audi", 25999,
          "image/audi.jpg");
        autolijst.add(Audi4);
        Auto BMW1 = new Auto("BMW", "I8", 86546,
          "image/bmw_i8.jpg");
        autolijst.add(BMW1);
        Auto Ferrari1 = new Auto("Ferrari", "Enzo", 185564,
          "image/ferrari_enzo.jpg");
        autolijst.add(Ferrari1);
        Auto Ferrari2 = new Auto("Ferrari", "Testarossa", 265110,
          "image/ferrari_testarossa.jpg");
        autolijst.add(Ferrari2);
        Auto Ferrari3 = new Auto("Ferrari", "600 GT", 190780,
          "image/ferrari.jpg");
        autolijst.add(Ferrari3);
        Auto Fiat1 = new Auto("Fiat", "500", 20000,
          "image/fiat_500.jpg");
        autolijst.add(Fiat1);
        Auto Fiat2 = new Auto("Fiat", "Bravo", 7599,
          "image/fiat_bravo.jpg");
        autolijst.add(Fiat2);
        Auto Fiat3 = new Auto("Fiat", "Punto", 9599,
          "image/fiat_punto.jpg");
        autolijst.add(Fiat3);
        Auto Fiat4 = new Auto("Fiat", "B22", 9599,
          "image/fiat.jpg");
        autolijst.add(Fiat4);
        Auto Ford1 = new Auto("Ford", "Fiesta", 16999,
          "image/ford_fiesta.jpg");
        autolijst.add(Ford1);
        Auto Ford2 = new Auto("Ford", "Focus", 21999,
          "image/ford_focus.jpg");
        autolijst.add(Ford2);
        Auto Ford3 = new Auto("Ford", "Mondeo", 26999,
          "image/ford_mondeo.jpg");
        autolijst.add(Ford3);
        Auto Ford4 = new Auto("Ford", "5W-40", 22999,
          "image/ford.jpg");
        autolijst.add(Ford4);
        Auto Lexus = new Auto("Lexus", "St300", 49999,
          "image/lexus.jpg");
        autolijst.add(Lexus);
        Auto Maserati = new Auto("Maserati", "Quattroporte", 65999,
          "image/maserati_quattroporte.jpg");
        autolijst.add(Maserati);
        Auto Mercedes = new Auto("Mercedes", "Cls 388", 85999,
          "image/mercedes.jpg");
        autolijst.add(Mercedes);
        Auto Opel1 = new Auto("Opel", "Astera", 3500,
          "image/opel_astra.jpg");
        autolijst.add(Opel1);
        Auto Opel2 = new Auto("Opel", "Corsa", 7500,
          "image/opel_corsa.jpg");
        autolijst.add(Opel2);
        Auto Opel3 = new Auto("Opel", "Mokka", 7499,
          "image/opel_mokka.jpg");
        autolijst.add(Opel3);
        Auto Opel4 = new Auto("Opel", "Zafira", 9999,
          "image/opel.jpg");
        autolijst.add(Opel4);
        Auto Porsche1 = new Auto("Porsche", "911", 107499,
          "image/porsche_911.jpg");
        autolijst.add(Porsche1);
        Auto Porsche2 = new Auto("Porsche", "Cayenne", 94995,
          "image/porsche_cayenne.jpg");
        autolijst.add(Porsche2);
        Auto Porsche3 = new Auto("Porsche", "Panamera", 65999,
          "image/porsche_panamera.jpg");
        autolijst.add(Porsche3);
        Auto Porsche4 = new Auto("Porsche", "GTI 388", 85999,
          "image/porsche.jpg");
        autolijst.add(Porsche4);
 
   
       
     }
 
    public ArrayList<Auto> getLijst() {
        return autolijst;
    }
   
   
    public ArrayList<Auto> getMerkenMinMax(String merk ,int minprijs ,int maxprijs) {
        ArrayList<Auto> merklijst = new ArrayList<Auto>();
       for (Auto auto: this.autolijst) {
            if ( (merk.equals("alle") || auto.getMerk().equals(merk)) && auto.getPrijs() >= minprijs && auto.getPrijs() <= maxprijs) {
             merklijst.add(auto);
            }
           
        }
        return merklijst;
    }
}