package tp2;

public class Autoroutes extends Routes{
	protected int nombreVoies;
	protected double tarif;
	
	public Autoroutes(String nom,float vitesseLimite,int nombreVoies,float distance,Ville destination,double tarif) {
		super(nom,vitesseLimite,distance,destination);
		this.nombreVoies=nombreVoies;
		this.tarif=tarif;
	}
	public int getNombreVoies() {
		return nombreVoies;
	}
	public double getTarif() {
		return tarif;
	}
}
