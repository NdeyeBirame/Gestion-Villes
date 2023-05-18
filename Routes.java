package tp2;

public class Routes {
	protected String nom;
	protected float vitesseLimite;
	protected float distance;
	protected Ville destination;
	protected String typeRoute;   // c'est de type de route(route ou autoroute). On va l'utiliser
								// pour l'affichage dans la méthode ListerRoutes()
	public Routes(String nom,float vitesseLimite,float distance,Ville destination) {
		this.nom=nom;
		this.vitesseLimite=vitesseLimite;
		this.distance=distance;
		this.destination=destination;
	}
	public String getNom() {
		return nom;
	}
	public float getVitesseLimite() {
		return vitesseLimite;
	}
	public float getDistance() {
		return distance;
	}
	public Ville getDestination() {
		return destination;
	}



}
