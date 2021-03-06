package com.infotel.TpMavenSpringJPAJEE.dao;

import java.util.List;

import com.infotel.TpMavenSpringJPAJEE.metier.Personne;

public interface Idao {
	public int ajouterPersonne(Personne p);
	public Personne getPersonne(int idPersonne);
	public int supprimerPersonne(Personne p);
	public Personne affichagePersonne(int idPersonne);
	public int modifierPersonne(Personne p);
	public List<Personne> findAllPersonnes();

}
