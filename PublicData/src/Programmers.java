
public class Programmers {
	public static int solution(int n) {
        int answer = 0;
        String s = ""+n;
        char[] chars = s.toCharArray();
        for (char c : chars) {
        	int digit =Character.getNumericValue(c);
        	answer += digit;
		}

        return answer;
    }
	public static void main(String[] args) {
		System.out.println(solution(287));
	}
}
