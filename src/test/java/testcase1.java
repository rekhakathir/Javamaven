import java.io.IOException;
import java.util.ArrayList;

public class testcase1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		DataDriven d = new DataDriven();
		ArrayList<String> data1 = d.getData("Login");
		System.out.println(data1);
		ArrayList<String> data2 = d.getData("Purchase");
		System.out.println(data2);
		ArrayList<String> data3 = d.getData("Add Profile");
		System.out.println(data3);
		ArrayList<String> data4 = d.getData("Delete Profile");
		System.out.println(data4);
		
	}

}
