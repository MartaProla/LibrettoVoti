package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Memorizza e gestisce un insieme di voti superati.
 *
 */
public class Libretto {

	private List<Voto> voti;
	
	/**
	 * Crea un libretto vuoto nuovo
	 */

	public Libretto() {
		this.voti=new ArrayList<>();
	}

	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v Voto da aggiungere
	 */
	public void add(Voto v) {
		if(this.cercaConflitto(v)==false && this.cercaVoto(v)==false)
			this.voti.add(v);
	}
	
	/**
	 * Dato un Libretto, restituisce una stringa nella quale vi sono solamente i
	 * voti pari al valore specificato
	 * 
	 * @param voto valore specificato
	 * @return stringa formattata per visualizzare il sotto-libretto
	 */
	public String stampaVotiUguali(int voto) {
		String s = "";
		for (Voto v : this.voti) {
			if (v.getVoto() == voto) {
				s += v.toString() + "\n";
			}
		}
		return s;
	}
	
	/**
	 * Genera un nuovo libretto, a partire da quello esistente,
	 * che conterrà esclusivamenti i voti con votazione pari a quella specificata.
	 * @param voto votazione specificata
	 * @return nuovo Libretto "ridotto"
	 */
	public Libretto estraiVotiUguali(int voto) {
		Libretto nuovo = new Libretto() ;
		for(Voto v: this.voti) {
			if(v.getVoto()==voto) {
				nuovo.add(v);
			}
		}
		return nuovo ;
	}
	// delego alla lista di voti di stamparsi
	public String toString() {
		String s = "";
		for (Voto v : this.voti) {
			s += v.toString() + "\n";
		}
		return s;
	}
	//punto tre Ricerca nel Libretto il voto di un esame dato il nome del corso
	public int cercaVoto(String nomeCorso) {
		boolean trovato=false;
		Voto ve=null;
		for(Voto v: this.voti) {
			if(v.getCorso().compareTo(nomeCorso)==0) {
				trovato=true;
				ve=v;
			}
		}
		if(trovato==true)
			return ve.getVoto();
		return 0;
	}
	public boolean cercaVoto(Voto voto) {
		boolean trovato=false;
		for(Voto v: this.voti){
			if(v.getCorso().compareTo(voto.getCorso())==0 && (v.getVoto()==voto.getVoto()))
				trovato=true;
		}
		if(trovato ==true)
			return true;
		else
			return false;
	}
	public boolean cercaConflitto(Voto voto) {
		boolean trovato=false;
		for(Voto v: this.voti){
			if(v.getCorso().compareTo(voto.getCorso())==0 && (v.getVoto()!=voto.getVoto()))
				trovato=true;
		}
		if(trovato ==true)
			return true;
		else
			return false;
	}
	public String LibrettoInOrdineAlfabetico(){
		Collections.sort(this.voti,new comparatoreNomeCorso());
		String s="";
		for(Voto v:voti) {
			s += v.toString() + "\n";
		}
		return s;
	}
	public String LibrettoInOrdineDiVotoDecrescente(){
		Collections.sort(this.voti,new comparatoreVotoCorso());
		String s="";
		for(Voto v:voti) {
			s += v.toString() + "\n";
		}
		return s;
	}
	public Libretto librettoSenzaVoto(int voto) {
		Libretto librettoDepurato=new Libretto();
		for(Voto v:voti) {
			if(v.getVoto()>voto) {
				librettoDepurato.add(v);
			}
		}
		return librettoDepurato;
	}
	public Libretto librettoMigliorato() {
		Libretto librettoMigliorato=new Libretto();
		for(Voto v: voti) {
			if(v.getVoto()>=18 && v.getVoto()<24) {
				v.setVoto(v.getVoto()+1);
				librettoMigliorato.add(v);
			}else {
				if(v.getVoto()>=24) {
					if(v.getVoto()+2<=30) {
						v.setVoto(v.getVoto()+2);
						librettoMigliorato.add(v);
					}
				}
			}
		}
		return librettoMigliorato;
	}
	
	
}
