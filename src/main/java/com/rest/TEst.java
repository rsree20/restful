
public class TEst {

	public static void main(String[] args) {
		final String s1 = "player";
		final String s2 = s1 + " unkown";
		final String s3 = s2 + " battles";
		final String s4 = s3 + " ground";
		String s5 = "player unkown battles ground";
		String s6 = new String("player unkown battles");
		System.out.println(s6.intern() == s3);
		String s7 = new String("player unkown");
		System.out.println(s2 == s7.intern());
		System.out.println(s2 == s7);
	}
}
