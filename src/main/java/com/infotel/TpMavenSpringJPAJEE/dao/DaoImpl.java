package com.infotel.TpMavenSpringJPAJEE.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.infotel.TpMavenSpringJPAJEE.metier.Personne;

@Transactional
@Repository
public class DaoImpl implements Idao {
	
	@PersistenceContext
	EntityManager em;
	@Override
	public int ajouterPersonne(Personne p) {
		em.persist(p);
		return p.getIdPersonne();
	}
	@Override
	public Personne getPersonne(int idPersonne) {
		Personne p = em.getReference(Personne.class, idPersonne);
		return p;
	}
	@Override
	public int supprimerPersonne(Personne p) {
		em.remove(p);
		return p.getIdPersonne();
	}
	@Override
	public Personne affichagePersonne(int idPersonne) {
		Personne p = em.find(Personne.class, idPersonne);
		return p;
	}
	@Override
	public int modifierPersonne(Personne p) {
		em.merge(p);
		return p.getIdPersonne();
	}
	@Override
	public List<Personne> findAllPersonnes() {
		return em.createQuery("select p from Personne p").getResultList();
	}
	
}
