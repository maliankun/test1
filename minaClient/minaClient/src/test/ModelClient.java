package test;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import module.UserInfo;
import module.UserServer;


public class ModelClient {
	
	public static void main(String[] args) throws ClassNotFoundException{
		String host = "localhost";
		  Socket s = null;
		  UserInfo us =new UserInfo();
		  try {
			s = new Socket (host, 43333);
			us.setUsername("lyk");
			us.setUserid("wangwenyue");
			Map<String, String> datamap = new HashMap<String, String>();
			datamap.put("user", "liyakun");
			datamap.put("pwd", "1325646");
			byte[] data = datamap.toString().getBytes("utf-8");
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());  
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			oos.writeObject(us);
			UserServer uu =(UserServer) ois.readObject();
			System.out.println(uu.getSex());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
      	  try {
				
				if(s!=null){
					s.close();
				}
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}}
