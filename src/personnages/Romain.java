package personnages;

import objets.Equipement;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified() : "La force doit être positive.";
	}

	private boolean isInvariantVerified() {
		return (force >= 0);
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	public String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup >= 0 : "La force du coup doit etre positive .";

		int ancienneForce = force;

		force -= forceCoup;
		if (force <= 0) {
			parler("j'abandonne ! ");
		} else {
			parler("Aïe");
		}

		assert force <= ancienneForce : "La force doit avoir diminué après avoir pris un coup .";

		assert isInvariantVerified() : "La force doit être positive .";
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			ajouterEquipement(equipement);
			break;
		case 1: 
			if (equipements[0] == equipement) {
				possedeDeja(equipement);
			}
			else {
				ajouterEquipement(equipement);
			}
			break;
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé !");
			break;
		
		}
	}
	
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}
	
	private void possedeDeja(Equipement equipement) {
		System.out.println("Le soldat " + nom + " possède déjà un " + equipement + ".");
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println("Les équipements disponibles sont les suivants :");
		for (Equipement e : Equipement.values()) {
			System.out.println(" - " + e);
		}
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
	}
}
