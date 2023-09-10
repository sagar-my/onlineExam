package exam;

import java.io.*;
import java.util.*;

public class StudentLogin extends Authentication {
	static int flag = -1;

	public int login() {
		try {
			int count = 0;
			String username;
			char[] password;
			Scanner sc = new Scanner(System.in);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Student name:");
			username = br.readLine();
			System.out.println("Enter Student Password");
			password = sc.nextLine().toCharArray();

			try (BufferedReader reader = new BufferedReader(new FileReader("Student.txt"))) {
				List<String> lines = new ArrayList<String>();
				String line = reader.readLine();
				while (line != null) {
					lines.add(line);
					line = reader.readLine();
				}
				LineNumberReader lnr = new LineNumberReader(new FileReader(new File("Student.txt")));
				lnr.skip(Long.MAX_VALUE);
				int cnt = lnr.getLineNumber();
				lnr.close();
				for (int i = 0; i < cnt; i++) {
					String ranStr = lines.get(i);
					String str[] = ranStr.split(",");
					if (str[0].equals(username) && str[1].equals(new String(password))) {
						count++;
					}
				}
			}
			if (count == 1) {
				flag = 1;
			} else {
				flag = 0;
			}
		} catch (Exception e) {

		}
		return flag;
	}

}