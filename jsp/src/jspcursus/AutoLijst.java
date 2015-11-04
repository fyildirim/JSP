package jspcursus;
 

import java.util.ArrayList;
import jspcursus.Auto;
 
 
public class AutoLijst {
    private ArrayList<Auto> autolijst;
   
 
    public AutoLijst() {
        autolijst = new ArrayList<Auto>();
        Auto ford1 = new Auto("Ford", "Fiesta", 23999, 
          "images/autos/fordfiesta.jpg");
        autolijst.add(ford1);
        Auto ford2 = new Auto("Ford", "Focus", 18995, 
          "images/autos/fordfocus.jpg");
        autolijst.add(ford2);
        Auto opel1 = new Auto("Opel", "Astra", 14895, 
          "images/autos/opelastra.jpg");
        autolijst.add(opel1);
        Auto opel2 = new Auto("Opel", "Insignia", 65450, 
          "images/autos/opelinsignia.jpg");
        autolijst.add(opel2);
        Auto subaru1 = new Auto("Subaru", "Forester", 34750, 
          "images/autos/subaruforester.jpg");
        autolijst.add(subaru1);
        Auto subaru2 = new Auto("Subaru", "Impreza", 28345, 
          "images/autos/subaruimpreza.jpg");
        autolijst.add(subaru2);
        Auto mercedes1 = new Auto("Mercedes", "E 63", 110995, 
          "images/autos/mercedede63.png");
        autolijst.add(mercedes1);
        Auto mercedes2 = new Auto("Mercedes", "CLA 45", 190780, 
          "images/autos/mercedescla45.jpg");
        autolijst.add(mercedes2);
        Auto ferrari1 = new Auto("Ferrari", "612 GTO", 350500, 
          "images/autos/ferrari612.jpg");
        autolijst.add(ferrari1);
        Auto citroen1 = new Auto("Citroen", "2CV", 459, 
          "images/autos/citroen2cv.jpg");
        autolijst.add(citroen1);
        Auto mini1 = new Auto("Mini", "Cooper", 34495, 
          "images/autos/minicooper.jpg");
        autolijst.add(mini1);
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