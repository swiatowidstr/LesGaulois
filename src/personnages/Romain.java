package personnages;

public class Romain {
	private String nom;
	private int force;

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

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
	}
}
