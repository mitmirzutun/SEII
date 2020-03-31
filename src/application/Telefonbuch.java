package application;

public class Telefonbuch {
	TelefonEntry[] eintr�ge;
	public Telefonbuch(TelefonEntry...eintr�ge) {
		this.eintr�ge=eintr�ge.clone();
	}
	public void addEintrag(TelefonEntry...eintr�ge) {
		TelefonEntry[] tmp=new TelefonEntry[this.eintr�ge.length+eintr�ge.length];
		for (int i=0;i<this.eintr�ge.length;i++) 
			tmp[i]=this.eintr�ge[i];
		for (int i=0;i<eintr�ge.length;i++)
			tmp[i+this.eintr�ge.length]=eintr�ge[i];
	}
	public TelefonEntry[] findEintragbyName(String vorname, String nachname) {
		TelefonEntry[] tmp=new TelefonEntry[0];
		for (int i=0;i<eintr�ge.length;i++) {
			if (eintr�ge[i].getFirstName().equals(vorname)&&eintr�ge[i].getLastName().equals(nachname)) {
				TelefonEntry[] tmp1=new TelefonEntry[tmp.length+1];
				for (int j=0;j<tmp.length;j++)
					tmp1[j]=tmp[j];
				tmp1[tmp.length]=eintr�ge[i];
				tmp=tmp1;
			}
		}
		return tmp;
	}
	public TelefonEntry[] findEintragbyAdress(String adress) {
		TelefonEntry[] tmp=new TelefonEntry[0];
		for (int i=0;i<eintr�ge.length;i++) {
			if (eintr�ge[i].getAdress().equals(adress)) {
				TelefonEntry[] tmp1=new TelefonEntry[tmp.length+1];
				for (int j=0;j<tmp.length;j++)
					tmp1[j]=tmp[j];
				tmp1[tmp.length]=eintr�ge[i];
				tmp=tmp1;
			}
		}
		return tmp;
		
	}
	public TelefonEntry[] findEintragbyFirstName(String vorname) {
		TelefonEntry[] tmp=new TelefonEntry[0];
		for (int i=0;i<eintr�ge.length;i++) {
			if (eintr�ge[i].getFirstName().equals(vorname)) {
				TelefonEntry[] tmp1=new TelefonEntry[tmp.length+1];
				for (int j=0;j<tmp.length;j++)
					tmp1[j]=tmp[j];
				tmp1[tmp.length]=eintr�ge[i];
				tmp=tmp1;
			}
		}
		return tmp;
	}
	public TelefonEntry[] findEintragbyLastName(String nachname) {
		TelefonEntry[] tmp=new TelefonEntry[0];
		for (int i=0;i<eintr�ge.length;i++) {
			if (eintr�ge[i].getLastName().equals(nachname)) {
				TelefonEntry[] tmp1=new TelefonEntry[tmp.length+1];
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
	public TelefonEntry[] popEintragbyAdress(String adress) {
		TelefonEntry[] tmp1=findEintragbyAdress(adress);
		TelefonEntry[] tmp2=new TelefonEntry[this.eintr�ge.length-tmp1.length+1];
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
	public TelefonEntry[] popEintragbyFirstName(String vorname) {
		TelefonEntry[] tmp1=findEintragbyFirstName(vorname);
		TelefonEntry[] tmp2=new TelefonEntry[this.eintr�ge.length-tmp1.length+1];
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
	public TelefonEntry[] popEintragbyLastName(String nachname) {
		TelefonEntry[] tmp1=findEintragbyLastName(nachname);
		TelefonEntry[] tmp2=new TelefonEntry[this.eintr�ge.length-tmp1.length+1];
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
