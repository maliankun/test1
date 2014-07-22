package one;

import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;

import xml.MsgName;
import xml.RegisterMsg;

public class ClientHandler  extends IoHandlerAdapter
{

	@Override
	public void messageReceived(IoSession session, Object message)
			throws Exception
	{
		String msg = message.toString();
		String msgName = new MsgName().parseXML(msg);
		if(msgName.equals("RegisterRe"))
		{
			new Thread(new HeartBeatThread(session)).start();
		}
		
	}

	@Override
	public void messageSent(IoSession session, Object message) throws Exception
	{
		System.out.println("===========  client sent msg:: "+message);
	}

	@Override
	public void sessionCreated(IoSession session) throws Exception
	{
		String register = new RegisterMsg().createDocument("123456", "192.168.0.22", "v-0.1", "6125");
		session.write(register);
	}

}
