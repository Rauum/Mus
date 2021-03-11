package com.montaury.mus.jeu.equipe;

import com.montaury.mus.jeu.joueur.Joueur;

public class Equipe {

    public static Equipe EquipeHumOrdi(String nomJoueur) { return new Equipe("EquipeHumOrdi", Joueur.humain(nomJoueur)); }
    public static Equipe EquipeOrdiOrdi(){
        return new Equipe("EquipeOrdiOrdi", Joueur.ordinateur());
    }

    private final String nom;
    public final Joueur joueur1;


    public Equipe(String nom, Joueur joueur1){
        this.nom = nom;
        this.joueur1 = joueur1;
    }
}
