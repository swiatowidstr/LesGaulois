package personnages;

import objets.Equipement;

public class Gaulois {
	private String nom;
//	private int force;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[0];
	private int effetPotion = 1;
	private Village village;
	public final String texte = "Bonjour, je m'appelle " + nom + ". J'habite dans le village de ";

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

//	public String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	@Override
	public String toString() {
		return nom;
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + "Envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force * effetPotion) / 3);
//		if (effetPotion > 1) {
//			effetPotion--;
//		}
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophees[i];
		}
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void sePresenter() {
		if (village != null && this == village.getChef()) {
			parler(texte + village.getNom() + ".");
		} else if (village != null) {
			parler(texte + village.getNom() + ".");
		} else {
			parler(texte + ". Je voyage de villages en villages.");
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix);
	}
}
