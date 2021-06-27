import java.net.*; 
import java.io.*; 
class myServer
{
	public static void main(String args[])throws IOException
	{ 
		ServerSocket ss = new ServerSocket(3333);
		Socket s = ss.accept();
		DataInputStream dis = new DataInputStream(s.getInputStream()); 
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in))); 
		String str1 = " ",str2=" ";
		while(!str1.equals("stop"))
		{ 
			str1 = dis.readUTF();
			System.out.println("client says:"+str1); 
			str2=br.readLine(); 
			dos.writeUTF(str2);
			dos.flush();
		}
		dis.close();
		s.close();
		ss.close();
	}

}
