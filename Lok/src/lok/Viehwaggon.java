package lok;

public class Viehwaggon {

	private final float maxKg;
	private final int maxVieh;
	private final float leer;
	private float kg;
	private int vieh;

	public Viehwaggon(float leergewicht, float maxKg, int maxVieh) {
		this.leer = leergewicht;
		this.maxKg = maxKg;
		this.maxVieh = maxVieh;
		this.kg = 0;
		this.vieh = 0;
	}

	public boolean fuegeHinzuVieh(float kg) throws Exception {
		boolean result = false;
		if ((this.kg + kg <= maxKg) && (this.vieh + 1 <= this.maxVieh)) {
			this.kg += kg;
			this.vieh++;
			result = true;
			System.out.println(this.vieh +". Vieh mit "+kg+"kg hinzugefügt");
		} else {
			throw new Exception("Vieh mit "+kg+"kg kann nicht " +
					"hinzugefügt werden, da entweder das max. Gewicht oder die max. " +
					"Viehanzahl überschritten werden würde!");
		}
		return result;
	}

	public float getMaxKg() {
		return maxKg;
	}

	public int getMaxVieh() {
		return maxVieh;
	}

	public float getLeergewicht() {
		return leer;
	}

	public float liefereKg() {
		return leer+kg;
	}

}
