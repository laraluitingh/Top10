package com.example.top10;

import java.io.Serializable;
import java.util.ArrayList;

public class TopTen implements Serializable {

    private String name;
    private String Address;
    private String cusineType;
    private double rating;
    private String pic;

    public TopTen(){

    }

    public TopTen(String name, String address, String cusineType, double rating, String pic) {
        this.name = name;
        Address = address;
        this.cusineType = cusineType;
        this.rating = rating;
        this.pic=pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }


    public String getCusineType() {
        return cusineType;
    }

    public void setCusineType(String cusineType) {
        this.cusineType = cusineType;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }


    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return Address;
    }

    //setting up TopTen data

    public static ArrayList<TopTen> getRest(){
        ArrayList<TopTen> rest=new ArrayList();
        rest.add(new TopTen("Quay", "Upper Overseas Passenger Terminal, The Rocks NSW 2000", "Modern Australian", 4.5, "quay_p" ));
       rest.add(new TopTen("Saint Peter", "362 Oxford St, Paddington NSW 2021", "Seafood", 4.5, "saint_peter_p"  ));
        rest.add(new TopTen("Hubert", "15 Bligh St, Sydney NSW 2000", "French", 4.4, "hurbert_p" ));
        rest.add(new TopTen("Ester", "46-52 Meagher St, Chippendale NSW 2008", "Modern Australian", 4.5, "ester_p" ));
        rest.add(new TopTen("Totti's", "283 Bondi Rd, Bondi NSW 2026", "Italian", 4.5, "totti_p" ));
        rest.add(new TopTen("Sang by Mabasa", "98 Fitzroy St, Surry Hills NSW 2010", "Korean", 4.3,"sbm_p" ));
        rest.add(new TopTen("Mr Wong", " 3 Bridge Ln, Sydney NSW 2000", "Chinese", 4.4, "wong_p" ));
        rest.add(new TopTen("Spice I am ", " 90 Wentworth Ave, Surry Hills NSW 2010", "Thai", 4.3, "spice_p" ));
        rest.add(new TopTen("Jack and Knife", "76 Stanley St, Darlinghurst NSW 2010", "Canadian, Australian, International", 4.7, "jack_p" ));
        rest.add(new TopTen("The Ternary", "100 Murray St, Pyrmont NSW 2009", "Modern Australian", 4.6 , "aternery_p"));

        return rest;
    }

    //finding specific restaurant by determining which string is the same as the restaurant name and then returning the specific object

public static TopTen pick(String nameR){
        for(TopTen t: getRest()){
            if (nameR.equals(t.getName())){
                return t;
            }
        }
      return null;
}
}
