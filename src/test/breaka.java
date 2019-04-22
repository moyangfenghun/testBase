package test;

public class breaka {
	public void breaksa() {
		int m=10,i=0;
		ok:
		while (m>=0) {
			for (; i<15 ; i++) {
				if(i==4) {
					break ok;
				}
			}
			i++;
			System.out.println(i);
			m--;
		}
		System.out.println(i);
	}
}
