package application;

public class Telefonbuch {
	TelefonEntry[] einträge;
	public Telefonbuch(TelefonEntry...einträge) {
		this.einträge=einträge.clone();
	}
	public void addEintrag(TelefonEntry...einträge) {
		TelefonEntry[] tmp=new TelefonEntry[this.einträge.length+einträge.length];
		for (int i=0;i<this.einträge.length;i++) 
			tmp[i]=this.einträge[i];
		for (int i=0;i<einträge.length;i++)
			tmp[i+this.einträge.length]=einträge[i];
	}
	public TelefonEntry[] findEintragbyName(String vorname, String nachname) {
		TelefonEntry[] tmp=new TelefonEntry[0];
		for (int i=0;i<einträge.length;i++) {
			if (einträge[i].getFirstName().equals(vorname)&&einträge[i].getLastName().equals(nachname)) {
				TelefonEntry[] tmp1=new TelefonEntry[tmp.length+1];
				for (int j=0;j<tmp.length;j++)
					tmp1[j]=tmp[j];
				tmp1[tmp.length]=einträge[i];
				tmp=tmp1;
			}
		}
		return tmp;
	}
	public TelefonEntry[] findEintragbyAdress(String adress) {
		TelefonEntry[] tmp=new TelefonEntry[0];
		for (int i=0;i<einträge.length;i++) {
			if (einträge[i].getAdress().equals(adress)) {
				TelefonEntry[] tmp1=new TelefonEntry[tmp.length+1];
				for (int j=0;j<tmp.length;j++)
					tmp1[j]=tmp[j];
				tmp1[tmp.length]=einträge[i];
				tmp=tmp1;
			}
		}
		return tmp;
		
	}
	public TelefonEntry[] findEintragbyFirstName(String vorname) {
		TelefonEntry[] tmp=new TelefonEntry[0];
		for (int i=0;i<einträge.length;i++) {
			if (einträge[i].getFirstName().equals(vorname)) {
				TelefonEntry[] tmp1=new TelefonEntry[tmp.length+1];
				for (int j=0;j<tmp.length;j++)
					tmp1[j]=tmp[j];
				tmp1[tmp.length]=einträge[i];
				tmp=tmp1;
			}
		}
		return tmp;
	}
	public TelefonEntry[] findEintragbyLastName(String nachname) {
		TelefonEntry[] tmp=new TelefonEntry[0];
		for (int i=0;i<einträge.length;i++) {
			if (einträge[i].getLastName().equals(nachname)) {
				TelefonEntry[] tmp1=new TelefonEntry[tmp.length+1];
				for (int j=0;j<tmp.length;j++)
					tmp1[j]=tmp[j];
				tmp1[tmp.length]=einträge[i];
				tmp=tmp1;
			}
		}
		return tmp;
	}
	public String toString() {
		int length=2*einträge.length;
		for (int i=0;i<einträge.length;i++) {
			length+=einträge[i].length();
		}
		StringBuilder sb= new StringBuilder(length);
		for (int i=0;i<einträge.length;i++)
			sb.append(einträge[i].toString());
		return sb.toString();
	}
	public TelefonEntry[] popEintragbyAdress(String adress) {
		TelefonEntry[] tmp1=findEintragbyAdress(adress);
		TelefonEntry[] tmp2=new TelefonEntry[this.einträge.length-tmp1.length+1];
		int n=0;
		for (int i=0;i<tmp2.length;i++) {
			if (einträge[i+n].equals(tmp1[n])) {
				n++;
				continue;
			}
			tmp2[i]=einträge[i+n];
		}
		einträge=tmp2;
		return tmp1;
	}
	public TelefonEntry[] popEintragbyFirstName(String vorname) {
		TelefonEntry[] tmp1=findEintragbyFirstName(vorname);
		TelefonEntry[] tmp2=new TelefonEntry[this.einträge.length-tmp1.length+1];
		int n=0;
		for (int i=0;i<tmp2.length;i++) {
			if (einträge[i+n].equals(tmp1[n])) {
				n++;
				continue;
			}
			tmp2[i]=einträge[i+n];
		}
		einträge=tmp2;
		return tmp1;
	}
	public TelefonEntry[] popEintragbyLastName(String nachname) {
		TelefonEntry[] tmp1=findEintragbyLastName(nachname);
		TelefonEntry[] tmp2=new TelefonEntry[this.einträge.length-tmp1.length+1];
		int n=0;
		for (int i=0;i<tmp2.length;i++) {
			if (einträge[i+n].equals(tmp1[n])) {
				n++;
				continue;
			}
			tmp2[i]=einträge[i+n];
		}
		einträge=tmp2;
		return tmp1;
	}
}
