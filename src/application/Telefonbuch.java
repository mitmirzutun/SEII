package application;

public class Telefonbuch {
	Eintrag[] einträge;
	public Telefonbuch(Eintrag...einträge) {
		this.einträge=einträge.clone();
	}
	public void addEintrag(Eintrag...einträge) {
		Eintrag[] tmp=new Eintrag[this.einträge.length+einträge.length];
		for (int i=0;i<this.einträge.length;i++) 
			tmp[i]=this.einträge[i];
		for (int i=0;i<einträge.length;i++)
			tmp[i+this.einträge.length]=einträge[i];
	}
	public Eintrag[] findEintragbyName(String vorname, String nachname) {
		Eintrag[] tmp=new Eintrag[0];
		for (int i=0;i<einträge.length;i++) {
			if (einträge[i].getFirstName().equals(vorname)&&einträge[i].getLastName().equals(nachname)) {
				Eintrag[] tmp1=new Eintrag[tmp.length+1];
				for (int j=0;j<tmp.length;j++)
					tmp1[j]=tmp[j];
				tmp1[tmp.length]=einträge[i];
				tmp=tmp1;
			}
		}
		return tmp;
	}
	public Eintrag[] findEintragbyAdress(String adress) {
		Eintrag[] tmp=new Eintrag[0];
		for (int i=0;i<einträge.length;i++) {
			if (einträge[i].getAdress().equals(adress)) {
				Eintrag[] tmp1=new Eintrag[tmp.length+1];
				for (int j=0;j<tmp.length;j++)
					tmp1[j]=tmp[j];
				tmp1[tmp.length]=einträge[i];
				tmp=tmp1;
			}
		}
		return tmp;
		
	}
	public Eintrag[] findEintragbyFirstName(String vorname) {
		Eintrag[] tmp=new Eintrag[0];
		for (int i=0;i<einträge.length;i++) {
			if (einträge[i].getFirstName().equals(vorname)) {
				Eintrag[] tmp1=new Eintrag[tmp.length+1];
				for (int j=0;j<tmp.length;j++)
					tmp1[j]=tmp[j];
				tmp1[tmp.length]=einträge[i];
				tmp=tmp1;
			}
		}
		return tmp;
	}
	public Eintrag[] findEintragbyLastName(String nachname) {
		Eintrag[] tmp=new Eintrag[0];
		for (int i=0;i<einträge.length;i++) {
			if (einträge[i].getLastName().equals(nachname)) {
				Eintrag[] tmp1=new Eintrag[tmp.length+1];
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
	public Eintrag[] popEintragbyAdress(String adress) {
		Eintrag[] tmp1=findEintragbyAdress(adress);
		Eintrag[] tmp2=new Eintrag[this.einträge.length-tmp1.length+1];
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
	public Eintrag[] popEintragbyFirstName(String vorname) {
		Eintrag[] tmp1=findEintragbyFirstName(vorname);
		Eintrag[] tmp2=new Eintrag[this.einträge.length-tmp1.length+1];
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
	public Eintrag[] popEintragbyLastName(String nachname) {
		Eintrag[] tmp1=findEintragbyLastName(nachname);
		Eintrag[] tmp2=new Eintrag[this.einträge.length-tmp1.length+1];
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
