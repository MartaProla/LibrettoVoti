package it.polito.tdp.libretto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Memorizza e gestisce un insieme di voti superati.
 *
 */
public class Libretto {

	private List<Voto> voti=new ArrayList<>();;
	
	/**
	 * Crea un libretto vuoto nuovo
	 */

	public Libretto() {
		super();
		
	}
	/**
	 * Copy constructor
	 * "Shallow" copia superficiale, fa una copia dell'oggetto corrente, ho una specie di condivisione --> qua devo solo stamparli
	 * 
	 * ["Deep" copaia profonda vengono copiati anche i singoli voti] -->se devo modificarlo
	 * @param lib
	 */
	public Libretto(Libretto lib ) {
		super();
		this.voti.addAll(lib.voti);// sto copiando il libretto
		
	}
	/**
	 * Aggiunge un nuovo voto al libretto
	 * 
	 * @param v Voto da aggiungere
	 */
	public boolean add(Voto v) {
		if(this.cercaConflitto(v)==false && this.cercaVoto(v)==false) {
			this.voti.add(v);
			return true;
		}else
			return false;
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
	// se non ho il corso con il nome return null
	/** 
	 * 
	 * @param nomeCorso
	 * @return il {@link Voto}
	 */
	/*public Voto cercaVoto(String nomeCorso) {
		for(Voto v: this.voti) {
			if(v.getCorso().compareTo(nomeCorso)==0) {
				return v;
			}
		}
		return null;
	}*/
	
	public Voto cercaVoto(String nomeCorso) {
		//Sto usando indexOf, mi sono creata un voto provvisorio. 
		//indexOf mi andrà a cercare dentro il libretto quel Voto che soddisfa il metodo equals--> è stato dichiarato su nomeCorso
		// per questo risultano i campi voto e data come 0 e null, tanto non li considero
		int pos=this.voti.indexOf(new Voto(nomeCorso,0,null));
		if(pos!=-1)
			return this.voti.get(pos);
		else
			return null;
	}
	
	/*public boolean cercaVoto(Voto voto) {
		boolean trovato=false;
		for(Voto v: this.voti){
			if(v.getCorso().compareTo(voto.getCorso())==0 && (v.getVoto()==voto.getVoto()))
				trovato=true;
		}
		if(trovato ==true)
			return true;
		else
			return false;
	}*/
	public boolean cercaVoto(Voto voto) {
		Voto esiste =this.cercaVoto(voto.getCorso());
		if(esiste==null)
			return false;
		
		/*if(esiste.getVoto()==voto.getVoto())
			return true;
		else 
			false;*/
		return (esiste.getVoto()==voto.getVoto());
		
	}
	
	/*public boolean cercaConflitto(Voto voto) {
		boolean trovato=false;
		for(Voto v: this.voti){
			if(v.getCorso().compareTo(voto.getCorso())==0 && (v.getVoto()!=voto.getVoto()))
				trovato=true;
		}
		if(trovato ==true)
			return true;
		else
			return false;
	}*/
	public boolean cercaConflitto(Voto voto) {
		Voto esiste =this.cercaVoto(voto.getCorso());
		if(esiste==null)
			return false;
		return (esiste.getVoto()!=voto.getVoto());
	}
	/*public Libretto librettoMigliorato() {
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
		return librettoMigliorato;*/
	/**
	 * Restituisce un nuovo libretto migliorando i voti del libretto attuale
	 * @return
	 */
	
	/*public Libretto creaLibrettoMigliorato() {
		Libretto nuovo=new Libretto();
		for(Voto v:this.voti) {
			Voto v2=v;// ATTENZIONE qua sto usando i voti del libretto quello del libretto inziale. Mi da quindi un errore nella 
						// scrittura, infatti mi vengano stampati tutti e libretti con i voti 30,30,26 mentre vorrei: libretto modificato 30,30,26
						// e quello di partenza lo vorrei 30,28,26
			if(v2.getVoto()>=24) {
				v2.setVoto(v2.getVoto()+2);
				if(v2.getVoto()>30)
					v2.setVoto(30);
			}else {
				if(v2.getVoto()>=18) {
					v2.setVoto(v2.getVoto()+1);
				}
			}
			nuovo.add(v2);
		}
		return nuovo;
	}*/
	// Vediamo dunque come fare una copia del libretto. 
	// Uso o copy custructor o metodo clone
	
	public Libretto creaLibrettoMigliorato() {
		Libretto nuovo=new Libretto();
		for(Voto v:this.voti) {
			// il copi constructor lo farà direttamente voto. 
			//Voto v2=new Voto(v); // Vot v2=new Voto( v.getCorso,v.getVoto, v.getData) -->potrei farlo, ma nel momento in cui a voto si aggiunge un parametro 
								// risulterebbe complicato
			Voto v2=v.clone();
			if(v2.getVoto()>=24) {
				v2.setVoto(v2.getVoto()+2);
				if(v2.getVoto()>30)
					v2.setVoto(30);
			}else {
				if(v2.getVoto()>=18) {
					v2.setVoto(v2.getVoto()+1);
				}
			}
			nuovo.add(v2);
		}
		return nuovo;
	}
	
	/*public String LibrettoInOrdineAlfabetico(){
		Collections.sort(this.voti,new comparatoreNomeCorso());
		String s="";
		for(Voto v:voti) {
			s += v.toString() + "\n";
		}
		return s;
	}*/
	
	public void  LibrettoInOrdineAlfabetico(){
		Collections.sort(this.voti);
	}
	
	
	public void LibrettoInOrdineDiVotoDecrescente(){
		Collections.sort(this.voti,new comparatoreVotoCorso());
	}
	
	// elimina dal libretto tutti i voti <24
	
	public void librettoSenzaVoto(int voto) {
		List<Voto>daRimuovere=new ArrayList<>();
		for(Voto v:voti) {
			if(v.getVoto()<voto)
				daRimuovere.add(v);
		}
		/*for (Voto v: daRimuovere) {
			this.voti.remove(v);
		}*/
		this.voti.removeAll(daRimuovere);
	}
	
}

	
	
	

