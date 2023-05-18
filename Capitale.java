package tp2;

public class Capitale extends Ville{
	protected String nomPays;
	public Capitale(String nom,String nomPays) {
		super(nom);
		indice=1;  
		this.nomPays=nomPays.toUpperCase();	
	}
	public Capitale(String nom,String nomPays,long nbHabitants) {
		super(nom,nbHabitants);
		indice=1;
		this.nomPays=nomPays.toUpperCase();
	}
	public String toString() {
		if(nbHabitantsConnu()==true) {
			return "Ville de "+nom+"; "+nbHabitants+" habitants. Capitale de "+nomPays;
		}
		else {
			return"Ville de "+nom+"; Capitale de "+nomPays;
		}
	}
	
	/*public char categorie() { //elle permet de definir la categorie 'C'
		return 'C';
	}*/
}
