package repositories;

public class debug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MyAccountDAO one = new MyAccountDAO();
		
		
		int two = one.findAccountId(1004);
		
		System.out.println(two);
		

	}

}
