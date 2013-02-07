package lok;

public class Gueterwaggon {

	private final float max;
	private final float leer;
	private float gewicht;

	public Gueterwaggon(float leergewichtKg, float max) {
		this.leer = leergewichtKg;
		this.max = max;
		this.gewicht = 0;
	}

	public boolean fuegeHinzuGut(float kg) throws Exception{
		boolean result = false;
		if (this.gewicht + kg <= max) {
			this.gewicht += kg;
			result = true;
			System.out.println("Gut mit "+kg+"kg hinzugef�gt");
		} else {
			throw new Exception("Fehler: Gut mit "+kg+"kg kann nicht hinzugef�gt werden, da das max. Gewicht �berschritten werden w�rde!");
		}
		return result;
	}

	public float getMaxKg() {
		return max;
	}

	public float getLeergewichtKg() {
		return leer;
	}

	public float liefereGewichtKg() {
		return leer+gewicht;
	}

}
