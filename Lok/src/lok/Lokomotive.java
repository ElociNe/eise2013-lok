package lok;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lokomotive {

	private static final int STATUS_HAELT = 0;
	private static final int STATUS_FAEHRT = 1;

	private final float zugkraftKg; 
	private int lokStatus; 
	private String lokfuehrerName;
	private String lokfuehrerId;
	private Date lokfuehrerSeit;
	private final List<Object> waggons; 

	public Lokomotive(float zugkraft) {
		this.zugkraftKg = zugkraft;
		this.waggons = new ArrayList<Object>();
		this.lokStatus = STATUS_HAELT;
	}

	public void losfahren() throws Exception {
		if (this.lokStatus == STATUS_HAELT) {
			if (lokfuehrerName != null) {

				float gewicht = 0;
				for (Object w : waggons) {
					if (w instanceof Gueterwaggon) {
						gewicht += ((Gueterwaggon) w).liefereGewichtKg();
					} else if (w instanceof Personenwaggon) {
						gewicht += ((Personenwaggon) w).liefereKg();
					} else if (w instanceof Viehwaggon) {
						gewicht += ((Viehwaggon) w).liefereKg();
					}// if else
				}// for

				if (gewicht <= zugkraftKg) {
					this.lokStatus = STATUS_FAEHRT;
					System.out.println("Die Lok fährt los! Die Last betraegt "
							+ gewicht + "kg");
				} else {
					throw new Exception("Fehler: Lokomotive kann nicht losfahren, da die Waggons zu schwer sind. Es müssen Waggons abgekoppelt werden!");
				} // if else

			} else {
				throw new Exception("Fehler: Kein Lokfuehrer vorhanden!");
			}// if else
		} else {
			throw new Exception("Die Lok faehrt bereits!");
		}// if else

	}// losfahren

	public void anhalten() throws Exception {
		if (this.lokStatus == STATUS_FAEHRT) {
			this.lokStatus = STATUS_HAELT;
			System.out.println("Die Lok hält an");
		} else {
			throw new Exception("Die Lok steht bereits!");
		}
	}// anhalten

	public void ankoppelnGueter(Gueterwaggon g) throws Exception {
		if (this.lokStatus == STATUS_HAELT) {
			if (!this.waggons.contains(g))
				this.waggons.add(g);
		} else {
			throw new Exception("Fehler: Waggons können nur angekoppelt werden, wenn die Lok steht!");
		}
	}// ankoppelnGueter

	public void ankoppelnPerso(Personenwaggon p) throws Exception {
		if (this.lokStatus == STATUS_HAELT) {
			if (!this.waggons.contains(p))
				this.waggons.add(p);
		} else {
			throw new Exception("Fehler: Waggons können nur angekoppelt werden, wenn die Lok steht!");
		}
	}// ankoppelnPerso

	public void ankoppelnVieh(Viehwaggon v) throws Exception {
		if (this.lokStatus == STATUS_HAELT) {
			if (!this.waggons.contains(v))
				this.waggons.add(v);
		} else {
			throw new Exception("Fehler: Waggons können nur angekoppelt werden, wenn die Lok steht!");
		}
	}// ankoppelnVieh

	public void ankoppelnKipp(Kippwaggon v) throws Exception {
		if (this.lokStatus == STATUS_HAELT) {
			if (!this.waggons.contains(v))
				this.waggons.add(v);
		} else {
			throw new Exception("Fehler: Waggons können nur angekoppelt werden, wenn die Lok steht!");
		}
	}// ankoppelnKipp

	public void abkoppelnGueter(Gueterwaggon g) throws Exception {
		if (this.lokStatus == STATUS_HAELT) {
			this.waggons.remove(g);
		} else {
			throw new Exception("Fehler: Waggons können nur abgekoppelt werden, wenn die Lok steht!");
		}

	}// abkoppelnGueter

	public void abkoppelnPerso(Personenwaggon p) throws Exception {
		if (this.lokStatus == STATUS_HAELT) {
			this.waggons.remove(p);
		} else {
			throw new Exception("Fehler: Waggons können nur abgekoppelt werden, wenn die Lok steht!");
		}
	}// abkoppelnPerso

	public void abkoppelnVieh(Viehwaggon v) throws Exception {
		if (this.lokStatus == STATUS_HAELT) {
			this.waggons.remove(v);
		} else {
			throw new Exception("Fehler: Waggons können nur abgekoppelt werden, wenn die Lok steht!");
		}
	}// abkoppelnVieh

	public void abkoppelnKipp(Kippwaggon v) throws Exception {
		if (this.lokStatus == STATUS_HAELT) {
			this.waggons.remove(v);
		} else {
			throw new Exception("Fehler: Waggons können nur abgekoppelt werden, wenn die Lok steht!");
		}
	}// abkoppelnKipp

	public void lokfuehrerSteigtEin(String name, String lokfuehrerId,
			Date lokfuehrerSeit) {
		//lokfuehrer steigt ein
		this.lokfuehrerName = name;
		this.lokfuehrerId = lokfuehrerId;
		this.lokfuehrerSeit = lokfuehrerSeit;
	}// lokfuehrerSteigtEin

	public void lokfuehrerSteigtAus() {
		this.lokfuehrerName = null;
		this.lokfuehrerId = null;
		this.lokfuehrerSeit = null;
	}// lokfuehrerSteigtAus

	public float getZugkraftKg() {
		return zugkraftKg;
	}// getZugkraftKg

	public String getLokfuehrerName() {

		return lokfuehrerName;
	}// getLokfuehrerName

	public int getLokStatus() {
		return lokStatus;
	}

	public void setLokStatus(int lokStatus) {
		this.lokStatus = lokStatus;
	}


	

}
