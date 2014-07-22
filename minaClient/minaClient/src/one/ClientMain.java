package one;

import java.net.InetSocketAddress;

import org.apache.mina.common.ConnectFuture;
import org.apache.mina.common.IoConnector;
import org.apache.mina.common.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import filter.MyTextFactory;

public class ClientMain
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		IoConnector nsa = new NioSocketConnector();
		nsa.getSessionConfig().setReadBufferSize(10240);
		nsa.getFilterChain().addLast("codec", new ProtocolCodecFilter(new MyTextFactory()));
		nsa.setHandler(new ClientHandler());
		IoSession session = null;
		
		try
		{
			ConnectFuture future = nsa.connect(new InetSocketAddress("127.0.0.1",9015)) ;
	        future.awaitUninterruptibly();
	        session = future.getSession();
	        session.getCloseFuture().awaitUninterruptibly();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		 nsa.dispose();
	}

}
