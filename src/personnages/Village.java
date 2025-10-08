package personnages;

public class Village {
	private String nom;
	private int nbVillageois = 0;
	private Gaulois[] villageois;
	private Gaulois chef;

	public Village(String nom, int nbMaxVillageois) {
		this.nom = nom;
		this.villageois = new Gaulois[nbMaxVillageois];
	}

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
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		} else {
			System.out.println("Le village est plein !");
		}
	}

	public Gaulois trouverVillageois(int numvillageois) {
		int index = numvillageois - 1;
		if (villageois[index] == null) {
			System.out.println("Il n'y a pas autant d'habitants dans notre village");
			return null;
		} else {
			return villageois[index];
		}
	}

	public void afficherVillageois() {
		System.out
				.println("Dans le village " + nom + " du chef " + chef.getNom() + " vivent les légendaires gaulois : ");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println(" - " + villageois[i].getNom());
		}
	}

	public static void main(String[] args) {
		Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
		Village village = new Village("Village des Irréductibles", 30);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillageois();
		Gaulois obelix = new Gaulois("Obélix", 25);
		village.ajouterVillageois(obelix);
		village.afficherVillageois();
		Gaulois doublepolemix = new Gaulois("DoublePolémix", 4);
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublepolemix.sePresenter();
	}
}
