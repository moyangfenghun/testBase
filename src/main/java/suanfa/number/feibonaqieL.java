package suanfa.number;

public class feibonaqieL {
	public long feibonaqie(long num) {
		return num>1?(feibonaqie(num-1)+feibonaqie(num-2)):num;
	}
}
