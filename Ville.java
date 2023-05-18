package tp2;
import java.util.*;

public class Ville {
	protected String nom;
	protected long nbHabitants;
	protected int indice=0;         // nous permet de connaître les villes de la catégorie C
	protected ArrayList<Routes> routes=new ArrayList<Routes>();
	
	public Ville(String nom) {
		this.nom=nom.toUpperCase();  //toUpperCase permet de mettre en majuscule une chaine de caractere
		nbHabitants=0;
	}
	public Ville(String nom,long nombre) {
		this.nom=nom.toUpperCase();
		if(nombre<0) {
			nbHabitants=0;  // si le nombre d'habitants est négatif on considére que c'est inconnu
		}
		else {
			nbHabitants=nombre;
		}
	}
	public String getNom() {
		return nom;
	}
	public long getNbHabitants(){
		return nbHabitants;	
	}
	public void setNbHabitants(long nombre) {
		if(nombre<=0) {
			nbHabitants=0;
		}
		else {
			nbHabitants=nombre;
		}
	}
	public boolean nbHabitantsConnu() {
		if(nbHabitants==0) {
			return false;
		}
		else {
			return true;
		}
	
	}
	public String toString() {
		if(nbHabitantsConnu()==false) {
			return "Ville de "+nom;
		}
		else {
			return "Ville de "+nom+"; "+nbHabitants+" habitants";
		}
	}
	public char categorie() {
		//pour ajouter les catégories on a ajouter une autre variable indice que l'on donne une valeur 
		//(ici 0 )et on change ensuite sa valeur dans Capitale pour pouvoir faire les tests
		if( indice==0) {
			if(nbHabitants<500000 && nbHabitants!=0) {
				return 'A';
			}
			else if(nbHabitants>=500000) {
				return 'B';
			}
			else {
				return '?';
			}
		}
		else {
			return'C';
		}
	
	}
	/*public char categorie() {   //on a créé une autre méthode categorie pour afficher autrement les categorie
	 * 							//ici on definit la categorie 'A','B' et '?'
	 							//puis on définit la categorie 'C' dans la classe Capitale
	 							 //en redefinissant la methode categorie()
		if(nbHabitants<500000 && nbHabitants!=0) {
			return 'A';
		}
		else if(nbHabitants>=500000) {
			return 'B';
		}
		else {
			return '?';
		}
	}*/
	public void addRoute(Routes route,boolean estRoute) {
		routes.add(route);
		/*if(estRoute==true) {
			route.typeRoute="Route";
		}
		else {
			route.typeRoute="Autoroute";
		}*/
	}
	public void listerRoutes() {
		System.out.println("Au départ de "+nom);
		for(int i=0;i<routes.size();i++) {
			Routes r=routes.get(i);
			System.out.println(r.nom+"->"+r.destination.nom+" ("+r.getClass().getSimpleName()+")");

		}
		System.out.println("--------------------------");
	}
	public void listerItineraires(Ville villeDestination) { // on affiche les itineraires entre deux villes avec au plus 
															//une ville étape
		for(int i=0;i<routes.size();i++) {
			Routes r=routes.get(i);
			if(r.destination==villeDestination) {
				System.out.print(r.nom+"-"+r.destination+" ;\n");
			}
			else {
				for(int j=0;j<r.destination.routes.size();j++) {
					Routes R=r.destination.routes.get(j);
					if(R.destination==villeDestination) {
						System.out.print(r.nom+"-"+r.destination.nom+" ; "+R.nom+"-"+R.destination.nom+" ;");
						System.out.println();
					}
					else {
						continue;       	
					}
				}
				
			}
		}
	}
	
	//Bonus
	public void afficherArrayList(ArrayList<Routes>chemin) {  //affiche le contenu d'un arraylist donné
		for(int i=0;i<chemin.size();i++) {
			Routes r=chemin.get(i);
			System.out.print(r.nom+"-"+r.destination.nom+" ;");
		}
		System.out.println();
	}
	public double calculFrais(ArrayList<Routes>chemin) { //calcul et retourne la somme des tarifs 
		double prixTrajet=0;
		for(int i=0;i<chemin.size();i++) {
			Routes r=chemin.get(i);
			if(r instanceof Autoroutes) {  //pour verifier si l aroute est une autoroute parce que seul les autoroutes ont un tarif
				prixTrajet+=((Autoroutes) r).tarif;
			}
		}
		return prixTrajet;
	}
	
	 
	public void lesItineraires(Ville villeDestination,int n) { //affiche tous les itinéraires
												              //vers une ville avec au plus n villes intermédiaires
		for(int i=0;i<routes.size();i++) {
			int m=0;
			ArrayList<Routes> chemin=new ArrayList<Routes>();  //c'est dans l'ArrayList chemin qu'on va stocker toutes les routes pouvant former un trajet complet
			Routes R=routes.get(i);
			if(R.destination==villeDestination) {    //si la route va directement à la ville destination on affiche seulement chemin aprés y avoir ajouter la route
				chemin.add(R);
				afficherArrayList(chemin);	
			}
			else {
				chemin.add(R);
				m++;
				for(int j=0;j<R.destination.routes.size();j++) {     //Pour chaque route de la ville destination on stocke tous les trajet 
					//passant par au plus n ville dans chemin mais on arrete de stocker si la ville destination d'une route est la ville recherchée
					while(m<=n && R.destination!=villeDestination) {  
						R=R.destination.routes.get(j);
						chemin.add(R);
						m++;
					}
					if(m>n) {                         //au cas où on sort du bouble while avec m=n+1 et la destination de la derniere route est la ville recherchée on affiche le trajet
						if (R.destination==villeDestination) {
							afficherArrayList(chemin);
						}
					}
					else {                   
						afficherArrayList(chemin);
					}
					chemin.clear();  //on efface le contenu de l'arraylist pour pouvoir y stocker à nouveau
					
				}
					
			}
		}
	}
	
	public void meilleurTrajet(Ville villeDestination,int n) {
		ArrayList<Double> prix=new ArrayList<Double>();
		ArrayList<ArrayList<Routes>> trajet=new ArrayList<ArrayList<Routes>>();
		double prixMin=0;
		for(int i=0;i<routes.size();i++) {
			double prixTrajet=0;
			int m=0;
			ArrayList<Routes> chemin=new ArrayList<Routes>();  //c'est dans l'ArrayList chemin qu'on va stocker toutes les routes pouvant former un trajet complet
			Routes R=routes.get(i);
			if(R.destination==villeDestination) {    //si la route va directement à la ville destination on affiche seulement chemin aprés y avoir ajouter la route
				chemin.add(R);
				if(R instanceof Autoroutes)	{
					prixTrajet=((Autoroutes) R).tarif;
				}
				prix.add(prixTrajet);
				trajet.add(chemin);
				if(prixMin>=prixTrajet) {
					prixMin=prixTrajet;
				}
			}
			else {
				chemin.add(R);
				m++;
				if(R instanceof Autoroutes) {
					prixTrajet=((Autoroutes) R).tarif;
				}
				double t=prixTrajet;  //c'est pour conserver cette valeur
				for(int j=0;j<R.destination.routes.size();j++) {     //puis chaque route de la ville destination
					prixTrajet=t;
					while(m<=n && R.destination!=villeDestination) {
						R=R.destination.routes.get(j);
						chemin.add(R);
						m++;
					}
					if(m>n) {
						if (R.destination==villeDestination) {
							prixTrajet+=calculFrais(chemin);
							prix.add(prixTrajet);
							trajet.add(chemin);
						}
					}
					else {
						prixTrajet+=calculFrais(chemin);
						prix.add(prixTrajet);
						trajet.add(chemin);
					}
					chemin.clear();
				}
					
			}
		}
		for(int i=0;i<prix.size();i++) {
			if(prixMin>=prix.get(i)) {
				prixMin=prix.get(i);
			}
		}
		for(int i=0;i<trajet.size();i++) {
			ArrayList<Routes> list=trajet.get(i);
			if(prixMin==calculFrais(list)) {
				afficherArrayList(list);
			}
		}
	}
}


