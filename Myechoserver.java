import java.net.*; 
import java.io.*; 
class Myechoserver
{
	public static void main(String args[])throws IOException
	{ 
		ServerSocket ss = new ServerSocket(3333);
		System.err.println("Started server on port 3333");
		Socket s = ss.accept();
		System.err.println("Accepted connection from client\n");
		DataInputStream din = new DataInputStream(s.getInputStream()); 
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		String str =" ";
		while(!str.equals("stop"))
		{ 
			str = din.readUTF();
			System.out.println("client says:"+str); 

			dout.writeUTF(str);
			dout.flush();
		}
		
		System.err.println("\nClosing connection with client");
		din.close();
		s.close();
		ss.close();
	}
}
