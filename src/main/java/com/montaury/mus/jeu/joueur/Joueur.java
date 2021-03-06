package com.montaury.mus.jeu.joueur;

import com.montaury.mus.jeu.carte.Carte;
import com.montaury.mus.jeu.equipe.Equipe;

import java.util.List;

public class Joueur {

  public static Joueur humain(String nom) {return new Joueur(nom, new InterfaceJoueurHumain());}

  public static Joueur ordinateur1() {
    return new Joueur("Ordinateur1", new InterfaceJoueurOrdinateur());
  }

  public static Joueur ordinateur2() {
    return new Joueur("Ordinateur2", new InterfaceJoueurOrdinateur());
  }

  public static Joueur ordinateur3() {
    return new Joueur("Ordinateur3", new InterfaceJoueurOrdinateur());
  }

  private final String nom;
  public final InterfaceJoueur interfaceJoueur;
  private final Main main = Main.vide();

  public Joueur(String nom, InterfaceJoueur interfaceJoueur) {
    this.nom = nom;
    this.interfaceJoueur = interfaceJoueur;
  }

  public String nom() {
    return nom;
  }
  public Main main() {
    return main;
  }

  public void donnerCartes(List<Carte> cartes) {
    main.ajouter(cartes);
    interfaceJoueur.nouvelleMain(main);
  }
}

