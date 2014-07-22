package filter;

import java.nio.ByteBuffer;

import org.apache.mina.common.IoBuffer;
import org.apache.mina.common.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;


public class MyTextDecoder implements ProtocolDecoder
{

	private StringBuffer res = new StringBuffer();
	public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out)
	throws Exception
	{
		
		ByteBuffer buf = in.buf();
		byte[] msg = new byte[buf.limit()];
		buf.get(msg);
		String ss = new String(msg,"UTF-8");
	
		res.append(ss);
		String m = res.toString();
//		out.write(ss);
//		out.flush();
		if(m.startsWith("<?xml version=\"1.0\"") && m.endsWith("</Name>"))
		{
		out.write(m);
		out.flush();
		res = null;
		res = new StringBuffer();
		}
	}
	public void dispose(IoSession arg0) throws Exception
	{
		
	}

	public void finishDecode(IoSession arg0, ProtocolDecoderOutput arg1)
			throws Exception
	{
		
	}

}
