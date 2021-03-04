package com.montaury.mus.jeu.joueur;

import com.montaury.mus.jeu.equipe.Equipe;

import java.util.Iterator;
import java.util.List;


public class Opposants {
  private Joueur joueurEsku;
  private Joueur joueurZaku;

  public Opposants(Joueur joueurEsku, Joueur joueurZaku) {
    this.joueurEsku = joueurEsku;
    this.joueurZaku = joueurZaku;
  }

  public void tourner() {
    Joueur tmp = joueurEsku;
    joueurEsku = joueurZaku;
    joueurZaku = tmp;
  }

  public Joueur joueurEsku() {
    return joueurEsku;
  }

  public Joueur joueurZaku() {
    return joueurZaku;
  }

  public Iterator<Joueur> itererDansLOrdre() {
    return new IteratorInfini(this);
  }

  public List<Joueur> dansLOrdre() {
    return List.of(joueurEsku, joueurZaku);
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
