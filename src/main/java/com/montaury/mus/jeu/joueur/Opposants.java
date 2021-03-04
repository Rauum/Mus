package com.montaury.mus.jeu.joueur;

import com.montaury.mus.jeu.equipe.Equipe;

import java.util.Iterator;
import java.util.List;


public class Opposants {
  private Equipe equipeEsku;
  private Equipe equipeZaku;

  public Opposants(Equipe equipeEsku, Equipe equipeZaku) {
    this.equipeEsku = equipeEsku;
    this.equipeZaku = equipeZaku;
  }

  public void tourner() {
    Equipe tmp = equipeEsku;
    equipeEsku = equipeZaku;
    equipeZaku = tmp;
  }

  public Equipe equipeEsku() {
    return equipeEsku;
  }

  public Equipe equipeZaku() {
    return equipeZaku;
  }

  public Iterator<Equipe> itererDansLOrdre() {
    return new IteratorInfini(this);
  }

  public List<Equipe> dansLOrdre() {
    return List.of(equipeEsku, equipeZaku);
  }

  private static class IteratorInfini implements Iterator<Equipe> {
    private final Opposants opposants;
    private Equipe suivant;

    public IteratorInfini(Opposants opposants) {
      this.opposants = opposants;
      suivant = opposants.equipeEsku;
    }

    @Override
    public boolean hasNext() {
      return true;
    }

    @Override
    public Equipe next() {
      Equipe next = suivant;
      suivant = suivant == opposants.equipeEsku ? opposants.equipeZaku : opposants.equipeEsku;
      return next;
    }
  }
}
