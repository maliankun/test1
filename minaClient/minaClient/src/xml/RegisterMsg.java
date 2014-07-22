package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * 注册消息的处理类
 * 方法parseXML :解析消息
 * 方法createDocument :生成消息
 * @author liujh
 *
 */
public class RegisterMsg
{

	/**
	 * 返回结果数组，共三个值：
	 * result[0]:终端ID
	 * result[1]:终端IP
	 * result[2]:终端version
	 * result[3]:终端监听端口号
	 */
	private Object[] result = new Object[4];
	
	
	public static void main(String[] args)
	{
		RegisterMsg rm = new RegisterMsg();
		String ss = rm.createDocument("001001", "192.169.0.2","10.2","5014");
		System.out.println(ss);
		Object[] rst = rm.parseXML(ss);
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
	 * @return 返回注册消息
	 */
	public String createDocument(String clientId , String clientIp,String version,String port)
	{
		String message = "";
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("Name");
		root.addAttribute("msgname","Register");
		Element client = root.addElement("client");
		Element id = client.addElement("id");
		Element ip = client.addElement("ip");
		Element v = client.addElement("version");
		Element p = client.addElement("port");
		id.addText(clientId);
		ip.addText(clientIp);
		v.addText(version);
		p.addText(port);
		message = document.asXML();
		
		return message;
	}
}
