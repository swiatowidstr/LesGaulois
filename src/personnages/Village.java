package personnages;


public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	private Gaulois chef;
	
	
	public String getNom() {
		return nom;
	}
	
	public Gaulois getChef() {
		return chef;
	}
	
	public void setChef(Gaulois chef) {
	    this.chef = chef;
	}
	
	public void ajouterVillageois(Gaulois gaulois) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++; 
	}
	
	
	public Gaulois trouverVillageois(int numvillageois) {
		if (villageois[numvillageois] == null) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village");
			return null;
		}
		else {
			return villageois[numvillageois];
		}
	}
	
	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		
	}
}
