package one;

import org.apache.mina.common.IoSession;

import xml.HeartBeatMsg;

public class HeartBeatThread implements Runnable
{
	private IoSession session;
	public HeartBeatThread(IoSession session)
	{
		System.out.println("====  heartBeat thread start  =====");
		this.session = session;
	}
	
	public void run()
	{
		String heartBeat = new HeartBeatMsg().createDocument("123456", "192.168.0.22", "v-0.1", "6125");
		int i = 0;
		while(true)
		{
			session.write(heartBeat);
			try
			{
				Thread.sleep(3000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
