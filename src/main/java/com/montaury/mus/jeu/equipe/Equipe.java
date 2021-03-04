package com.montaury.mus.jeu.equipe;

import com.montaury.mus.jeu.joueur.Joueur;

public class Equipe {

    public static Equipe equipe1(String nomJoueur) {

        return new Equipe("Equipe1", Joueur.humain(nomJoueur), Joueur.ordinateur1());
    }
    public static Equipe equipe2(){
        return new Equipe("Equipe1", Joueur.ordinateur2() , Joueur.ordinateur3());
    }

    private final String nom;
    public final Joueur joueur1;
    public final Joueur joueur2;


    public Equipe(String nom, Joueur joueur1, Joueur joueur2){
        this.nom = nom;
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }
}
