package application;

public class TelefonEntry {
	private String vorname,nachname,nummer,debugPrefix="application.Eintrag";
	private static boolean DEBUGGING=false;
	public TelefonEntry(String vorname, String nachname, String nummer) {
		if (DEBUGGING) {
			System.out.println(debugPrefix+": Call of Constructor(String, String, String)");
		}
		this.vorname=vorname;
		this.nachname=nachname;
		this.nummer=nummer;
		if (DEBUGGING) {
			System.out.println(debugPrefix+": First name: "+this.vorname);
			System.out.println(debugPrefix+": Last name: "+this.nachname);
			System.out.println(debugPrefix+": Address: "+this.nummer);
		}
	}
	public TelefonEntry(TelefonEntry e) {
		if (DEBUGGING) {
			System.out.println(debugPrefix+": Call of Constructor(Eintrag)");
		}
		this.vorname=e.vorname;
		this.nachname=e.nachname;
		this.nummer=e.nummer;
		if (DEBUGGING) {
			System.out.println(debugPrefix+": First name: "+this.vorname);
			System.out.println(debugPrefix+": Last name: "+this.nachname);
			System.out.println(debugPrefix+": Address: "+this.nummer);
		}
	}
	public void setLastName(String s) {
		nachname=s;
	}
	public void setFirstName(String s) {
		vorname=s;
	}
	public void setNumber(String s) {
		nummer=s;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder(2+vorname.length()+nachname.length()+nummer.length());
		sb.append(vorname);
		sb.append(' ');
		sb.append(nachname);
		sb.append('\n');
		sb.append(nummer);
		return sb.toString();
	}
	public String getFirstName() {
		return vorname;
	}
	public String getLastName() {
		return nachname;
	}
	public String getAdress() {
		return nummer;
	}
	public TelefonEntry clone() {
		return new TelefonEntry(this);
	}
	public static boolean test() {
		if (DEBUGGING)
			System.out.println("Testing getFirstName");
		TelefonEntry e = new TelefonEntry("Max","Mustermann","Musterstraﬂe 4");
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
		TelefonEntry e1 = new TelefonEntry(e);
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
		if (e.equals(new TelefonEntry("Mustermann","Max","Musterstraﬂe")))
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
		if (!(o instanceof TelefonEntry))
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
		return 2+vorname.length()+nachname.length()+nummer.length();
	}
}
