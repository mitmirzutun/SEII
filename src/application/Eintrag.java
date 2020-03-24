package application;

public class Eintrag {
	private String vorname,nachname,adresse,debugPrefix="application.Eintrag";
	private static boolean DEBUGGING=false;
	public Eintrag(String vorname, String nachname, String adresse) {
		if (DEBUGGING) {
			System.out.println(debugPrefix+": Call of Constructor(String, String, String)");
		}
		this.vorname=vorname;
		this.nachname=nachname;
		this.adresse=adresse;
		if (DEBUGGING) {
			System.out.println(debugPrefix+": First name: "+this.vorname);
			System.out.println(debugPrefix+": Last name: "+this.nachname);
			System.out.println(debugPrefix+": Address: "+this.adresse);
		}
	}
	public Eintrag(Eintrag e) {
		if (DEBUGGING) {
			System.out.println(debugPrefix+": Call of Constructor(Eintrag)");
		}
		this.vorname=e.vorname;
		this.nachname=e.nachname;
		this.adresse=e.adresse;
		if (DEBUGGING) {
			System.out.println(debugPrefix+": First name: "+this.vorname);
			System.out.println(debugPrefix+": Last name: "+this.nachname);
			System.out.println(debugPrefix+": Address: "+this.adresse);
		}
	}
	public String toString() {
		StringBuilder sb = new StringBuilder(2+vorname.length()+nachname.length()+adresse.length());
		sb.append(vorname);
		sb.append(' ');
		sb.append(nachname);
		sb.append('\n');
		sb.append(adresse);
		return sb.toString();
	}
	public String getFirstName() {
		return vorname;
	}
	public String getLastName() {
		return nachname;
	}
	public String getAdress() {
		return adresse;
	}
	public Eintrag clone() {
		return new Eintrag(this);
	}
	public static boolean test() {
		if (DEBUGGING)
			System.out.println("Testing getFirstName");
		Eintrag e = new Eintrag("Max","Mustermann","Musterstraﬂe 4");
		if (!"Max".equals(e.getFirstName())) {
			return false;
		}
		if (DEBUGGING)
			System.out.println("Testing getLastName");
		if (!"Mustermann".equals(e.getLastName())) {
			return false;
		}
		if (DEBUGGING)
			System.out.println("Testing getAdress");
		if (!"Musterstaﬂe 4".equals(e.getAdress())) {
			return false;
		}
		if (DEBUGGING)
			System.out.println("Testing Eintrag(Eintrag)");
		Eintrag e1 = new Eintrag(e);
		if (!e.getAdress().equals(e1.getAdress())) {
			return false;
		}
		if (!e.getFirstName().equals(e.getLastName())) {
			return false;
		}
		if (!e.getLastName().equals(e.getLastName())) {
			return false;
		}
		if (!e.equals(e1)) {
			return false;
		}
		if (DEBUGGING)
			System.out.println("Testing clone/equals");
		if (!e.equals(e.clone())) {
			return false;
		}
		if (e.equals(new Object()))
			return false;
		if (e.equals(new Eintrag("Mustermann","Max","Musterstraﬂe")))
			return false;
		try {
			e.equals(null);
		} catch (Exception exc)  {
			if (!(exc instanceof NullPointerException))
				return false;
			if (!exc.getMessage().equals(new NullPointerException("No Object to compare to")))
				return false;
		}
		if (DEBUGGING)
			System.out.println("Testing toString");
		if (!e.toString().equals("Max Mustermann\nMuserstraﬂe 4")) {
			return false;
		}
		return true;
	}
	public boolean equals(Object o) {
		if (o==null)
			throw new NullPointerException("No Object to compare to");
		if (!(o instanceof Eintrag))
			return false;
		return o.toString().equals(this.toString());
	}
	public static void startDebugging() {
		DEBUGGING=true;
	}
	public static void stopDebugging() {
		DEBUGGING=false;
	}
	public int length() {
		return 2+vorname.length()+nachname.length()+adresse.length();
	}
}
