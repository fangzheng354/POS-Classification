package nju.iip.POS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PreProcess {
	
	
	private static String file_path="lily";//文本路径
	
	private static int count=0;
	
	/**
	 * @description 获得某个板块下帖子的集合
	 * @param txt_name
	 * @return
	 * @throws IOException 
	 */
	public static void getPostList(String txt_name){
		String txt_path=file_path+File.separator+txt_name;
		try{
			FileWriter fw=new FileWriter("D:"+txt_name);
			FileInputStream fs=new FileInputStream(txt_path);
			InputStreamReader is=new InputStreamReader(fs,"UTF-8");
			BufferedReader br=new BufferedReader(is);
			String line=br.readLine();
			while(line!=null){
				ArrayList<String>tagged_words=Tools.segStr(line);
				for(String word:tagged_words){
					fw.write(word+",");
				}
				fw.write("\n");
				System.out.println(count++);
				line=br.readLine();
			}
			fw.flush();
			fw.close();
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @description 获得所有帖子集合
	 * @return
	 * @throws IOException 
	 */
	public static void getAllpostList(){
		File f=new File(file_path);
		String[] txt_list=f.list();
		for(int i=0;i<txt_list.length;i++){
			 getPostList(txt_list[i]);
		}
		
	}
	
	public static void main(String[] args){
		getAllpostList();
	}

}
