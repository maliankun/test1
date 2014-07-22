package xml;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


/**
 * 此类是对注册回复消息的操作
 * 此类只有一个生成消息的方法，因为消息中只有一个消息名称，没有其它内容，所以不需要解析消息的方法
 * 方法createDocument :生成消息
 * @author liujh
 *
 */
public class RegisterReMsg
{
	private Object[] result = new Object[]{};
	public static void main(String[] args)
	{
		RegisterReMsg rrm = new RegisterReMsg();
		System.out.println(rrm.createDocument());
		
	}
	/**
	 * 生成消息
	 */
	public String createDocument()
	{
		String message = "";
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("Name");
		root.addAttribute("msgname","RegisterRe");
		root.addElement("a");
		message = document.asXML();
		return message;
	}
	
	public Object[] parseXML(String xml)
	{
		return result;
	}
}
