import java.util.Scanner;

public class Test {
	public static void main(String[] args) {

		String str = "Jack Snider has got lots of silver hair lately and he thinks that sucks a lot";
		char[] strArr = str.toCharArray();

		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i] == 32) {
				strArr[i] = strArr[i + 1];
			}
		}
		str = new String(strArr);
		System.out.println(str);

	}
}
