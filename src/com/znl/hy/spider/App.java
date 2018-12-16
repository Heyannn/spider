package com.znl.hy.spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * ��������
 * @author hy
 */
 
public class App {
	// alt + /
	public static void main(String[] args) {
		//Ŀ�� URL
		String url ="https://movie.douban.com/top250";
				
		//ʹ��jsoup
		try {
			Document doc=Jsoup.connect(url).get();
			Elements es= doc.select(".grid_view .item");
			System.out.println(es.size());
			
			//����һ��ӰƬ���б�
			Arraylist<Film> list = new Arraylist<>();
			
			for(Element e :es){
				Film f = new Film();
				//ÿһ��ӰƬ
				Element t = e.select(".title").first();
				String num = e.select(".star span").last().text();
				System.out.println(t.text() + ","+ num);
				
				//f.id
				//f.title
				list.add(f);
			}
			
			
			
			
			//String title = doc.title();
			//String data = doc.data();
			
			//System.out.println(title);
			//System.out.println(data);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
