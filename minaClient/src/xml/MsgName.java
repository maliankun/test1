package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;


public class MsgName
{
	/**
	 * @param args
	 */
	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		
	}
	public String parseXML(String xml)
	{
		String msgName = "";
		
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
		msgName = root.attributeValue("msgname");
		return msgName;
	}
}
