package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 心跳消息的操作类
 * 方法parseXML :解析消息
 * 方法createDocument :生成消息
 * @author liujh
 *
 */
public class HeartBeatMsg
{

	/**
	 * 返回值数组，四个值：
	 * result[0]: 终端ID result[1]:ip result[2]:version  result[3]: port
	 */
	private Object[] result = new Object[4];
	
	
	public static void main(String[] args)
	{
		HeartBeatMsg hbm = new HeartBeatMsg();
		String ss = hbm.createDocument("001001","192.168.0.218","1.0.2","5014");
		System.out.println(ss);
		Object[]rst = hbm.parseXML(ss);
		System.out.println(rst[0]);
		System.out.println(rst[1]);
		System.out.println(rst[2]);
		System.out.println(rst[3]);
	}
	
	/**
	 * 解析消息
	 */
	public Object[] parseXML(String xml)
	{
		Document doc=null;
		try
		{
			doc = DocumentHelper.parseText(xml);
		} catch (DocumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element root = doc.getRootElement(); 
		
		Element client = root.element("client");
		String id = client.elementText("id");
		String ip = client.elementText("ip");
		String version = client.elementText("version");
		String port = client.elementText("port");
		
		//设置返回值数组
		
		result[0]= id;
		result[1]= ip;
		result[2]= version;
		result[3]= port;
		
		return result;
	}
	/**
	 * 生成消息
	 * @param clientId ：终端id
	 * @param clientIp ：终端ip
	 * @return 返回心跳消息
	 */
	public String createDocument(String clientId , String clientIp,String c_version,String port)
	{
		String message = "";
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("Name");
		root.addAttribute("msgname","HeartBeat");
		Element client = root.addElement("client");
		Element id = client.addElement("id");
		Element ip = client.addElement("ip");
		Element version = client.addElement("version");
		Element p = client.addElement("port");
		id.addText(clientId);
		ip.addText(clientIp);
		version.addText(c_version);
		p.addText(port);
		
		message = document.asXML();
		
		return message;
	}
}