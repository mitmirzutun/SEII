package application;

public class Telefonbuch {
	Eintrag[] eintr�ge;
	public Telefonbuch(Eintrag...eintr�ge) {
		this.eintr�ge=eintr�ge.clone();
	}
	public void addEintrag(Eintrag...eintr�ge) {
		Eintrag[] tmp=new Eintrag[this.eintr�ge.length+eintr�ge.length];
		for (int i=0;i<this.eintr�ge.length;i++) 
			tmp[i]=this.eintr�ge[i];
		for (int i=0;i<eintr�ge.length;i++)
			tmp[i+this.eintr�ge.length]=eintr�ge[i];
	}
	public Eintrag[] findEintragbyName(String vorname, String nachname) {
		Eintrag[] tmp=new Eintrag[0];
		for (int i=0;i<eintr�ge.length;i++) {
			if (eintr�ge[i].getFirstName().equals(vorname)&&eintr�ge[i].getLastName().equals(nachname)) {
				Eintrag[] tmp1=new Eintrag[tmp.length+1];
				for (int j=0;j<tmp.length;j++)
					tmp1[j]=tmp[j];
				tmp1[tmp.length]=eintr�ge[i];
				tmp=tmp1;
			}
		}
		return tmp;
	}
	public Eintrag[] findEintragbyAdress(String adress) {
		Eintrag[] tmp=new Eintrag[0];
		for (int i=0;i<eintr�ge.length;i++) {
			if (eintr�ge[i].getAdress().equals(adress)) {
				Eintrag[] tmp1=new Eintrag[tmp.length+1];
				for (int j=0;j<tmp.length;j++)
					tmp1[j]=tmp[j];
				tmp1[tmp.length]=eintr�ge[i];
				tmp=tmp1;
			}
		}
		return tmp;
		
	}
	public Eintrag[] findEintragbyFirstName(String vorname) {
		Eintrag[] tmp=new Eintrag[0];
		for (int i=0;i<eintr�ge.length;i++) {
			if (eintr�ge[i].getFirstName().equals(vorname)) {
				Eintrag[] tmp1=new Eintrag[tmp.length+1];
				for (int j=0;j<tmp.length;j++)
					tmp1[j]=tmp[j];
				tmp1[tmp.length]=eintr�ge[i];
				tmp=tmp1;
			}
		}
		return tmp;
	}
	public Eintrag[] findEintragbyLastName(String nachname) {
		Eintrag[] tmp=new Eintrag[0];
		for (int i=0;i<eintr�ge.length;i++) {
			if (eintr�ge[i].getLastName().equals(nachname)) {
				Eintrag[] tmp1=new Eintrag[tmp.length+1];
				for (int j=0;j<tmp.length;j++)
					tmp1[j]=tmp[j];
				tmp1[tmp.length]=eintr�ge[i];
				tmp=tmp1;
			}
		}
		return tmp;
	}
	public String toString() {
		int length=2*eintr�ge.length;
		for (int i=0;i<eintr�ge.length;i++) {
			length+=eintr�ge[i].length();
		}
		StringBuilder sb= new StringBuilder(length);
		for (int i=0;i<eintr�ge.length;i++)
			sb.append(eintr�ge[i].toString());
		return sb.toString();
	}
	public Eintrag[] popEintragbyAdress(String adress) {
		Eintrag[] tmp1=findEintragbyAdress(adress);
		Eintrag[] tmp2=new Eintrag[this.eintr�ge.length-tmp1.length+1];
		int n=0;
		for (int i=0;i<tmp2.length;i++) {
			if (eintr�ge[i+n].equals(tmp1[n])) {
				n++;
				continue;
			}
			tmp2[i]=eintr�ge[i+n];
		}
		eintr�ge=tmp2;
		return tmp1;
	}
	public Eintrag[] popEintragbyFirstName(String vorname) {
		Eintrag[] tmp1=findEintragbyFirstName(vorname);
		Eintrag[] tmp2=new Eintrag[this.eintr�ge.length-tmp1.length+1];
		int n=0;
		for (int i=0;i<tmp2.length;i++) {
			if (eintr�ge[i+n].equals(tmp1[n])) {
				n++;
				continue;
			}
			tmp2[i]=eintr�ge[i+n];
		}
		eintr�ge=tmp2;
		return tmp1;
	}
	public Eintrag[] popEintragbyLastName(String nachname) {
		Eintrag[] tmp1=findEintragbyLastName(nachname);
		Eintrag[] tmp2=new Eintrag[this.eintr�ge.length-tmp1.length+1];
		int n=0;
		for (int i=0;i<tmp2.length;i++) {
			if (eintr�ge[i+n].equals(tmp1[n])) {
				n++;
				continue;
			}
			tmp2[i]=eintr�ge[i+n];
		}
		eintr�ge=tmp2;
		return tmp1;
	}
}
