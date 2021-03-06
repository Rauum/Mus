package com.montaury.mus.jeu.joueur;

import com.montaury.mus.jeu.carte.Carte;
import com.montaury.mus.jeu.tour.phases.dialogue.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InterfaceJoueurHumain implements InterfaceJoueur {

  private final Scanner scanner = new Scanner(System.in);
  private Main main;

  @Override
  public boolean veutAllerMus() {
    while (true) {
      println("Souhaitez-vous aller mus ? (o/n)");
      String valeurRetournerUtilisateur = scanner.next();
      if (valeurRetournerUtilisateur.equals("o")) {
        return true;
      }
      if (valeurRetournerUtilisateur.equals("n")) {
        return false;
      }
      else {
        System.out.println("Saisie invalide, veuillez recommencer !");
      }
    }
  }

  @Override
  public List<Carte> cartesAJeter() {
    println("Veuillez saisir les cartes à jeter (ex: 1,3) :");
    String aJeter = scanner.next();
    return Arrays.stream(aJeter.split(","))
      .mapToInt(Integer::parseInt)
      .mapToObj(indiceCarte -> main.cartesDuPlusGrandAuPlusPetit().get(indiceCarte - 1))
      .collect(Collectors.toList());
  }

  @Override
  public Choix faireChoixParmi(List<TypeChoix> choixPossibles) {
    while(true) {
    print("Faites un choix entre (en toutes lettres): ");
    println(choixPossibles.stream().map(TypeChoix::nom).collect(Collectors.joining(" | ")));
    String choix = scanner.next();
      if (choix.equalsIgnoreCase("Paso")) return new Paso();
      if (choix.equalsIgnoreCase("Imido")) return new Imido();
      if (choix.equalsIgnoreCase("Hordago")) return new Hordago();
      if (choix.equalsIgnoreCase("Idoki")) return new Idoki();
      if (choix.equalsIgnoreCase("Tira")) return new Tira();
      if (choix.equalsIgnoreCase("Gehiago")) return new Gehiago(1);
      if (choix.equalsIgnoreCase("Kanta")) return new Kanta();
      System.out.println("Saisie invalide, veuillez recommencer !");
    }
  }

  @Override
  public void nouvelleMain(Main main) {
    this.main = main;
  }

  private void println(String string) {
    System.out.println(string);
  }

  private void print(String string) {
    System.out.print(string);
  }
}
