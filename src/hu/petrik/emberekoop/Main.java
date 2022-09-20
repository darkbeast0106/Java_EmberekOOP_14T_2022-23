package hu.petrik.emberekoop;

public class Main {
    public static void main(String[] args) {
        Ember human = new Ember("Gipsz Jakab", "2001-1-1","Budapest");
        Ember human2 = new Ember("Teszt Elek", "1985-12-15","Debrecen");
        Ember human3 = new Ember("Kovács István", "1999-3-30","Szeged");
        System.out.println(human);
        System.out.println(human2);
        System.out.println(human3);
    }
}
