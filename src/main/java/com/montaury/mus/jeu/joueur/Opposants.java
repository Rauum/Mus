package com.montaury.mus.jeu.joueur;

import com.montaury.mus.jeu.equipe.Equipe;

import java.util.Iterator;
import java.util.List;


public class Opposants {
  private Joueur joueurEsku;
  private Joueur joueurZaku;
  private Joueur joueur2;
  private Joueur joueur3;
  private Equipe equipeEsku;
  private Equipe equipeZaku;

  public Opposants(Equipe equipeEsku, Equipe equipeZaku) {
    this.joueurEsku = equipeEsku.joueur1;
    this.joueur2 = equipeZaku.joueur1;
    this.joueur3 = equipeEsku.joueur2;
    this.joueurZaku = equipeZaku.joueur2;
  }

  public void tourner() {
    Joueur tmp1 = joueurEsku;
    Joueur tmp2 = joueur2;
    joueurEsku = joueur3;
    joueur2 = joueurZaku;
    joueur3 = tmp2;
    joueurZaku = tmp1;
  }

  public Joueur joueurEsku() {
    return joueurEsku;
  }

  public Joueur joueurZaku() {
    return joueurZaku;
  }

  public Joueur joueur2() {
    return joueur2;
  }

  public Joueur joueur3() {
    return joueur3;
  }

  public Equipe equipeEsku() { return equipeEsku;}

  public Equipe equipeZaku() { return equipeZaku;}


  public Iterator<Joueur> itererDansLOrdre() {
    return new IteratorInfini(this);
  }

  public List<Joueur> dansLOrdre() {
    return List.of(joueurEsku,joueur2,joueur3,joueurZaku);
  }

  private static class IteratorInfini implements Iterator<Joueur> {
    private final Opposants opposants;
    private Joueur suivant;

    public IteratorInfini(Opposants opposants) {
      this.opposants = opposants;
      suivant = opposants.joueurEsku;
    }

    @Override
    public boolean hasNext() {
      return true;
    }

    @Override
    public Joueur next() {
      Joueur next = suivant;
      suivant = suivant == opposants.joueurEsku ? opposants.joueurZaku : opposants.joueurEsku;
      return next;
    }
  }
}
