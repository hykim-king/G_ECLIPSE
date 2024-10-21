package com.pcwk.ehr.ed04;

import java.io.*;
import java.net.*;
import java.util.List;

import com.google.gson.Gson;


public class NaverBlogAPI {
	
	public static void main(String[] args) {
		String clientId = "bAr8yPMS8XI2uVvp6Dx_";
		String clientSecret = "Wh0Z1AeYDw";
		
		//검색어. UTF-8로 인코딩되어야 합니다.
		String searchWord = null;
		
		try {
			searchWord = URLEncoder.encode("홍대 베이글", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.printf("searchWord:%s%n",searchWord);
		
		//JSON으로 return
		String apiURL = "https://openapi.naver.com/v1/search/blog.json?query="+searchWord;
		
		System.out.printf("apiURL:%s%n",apiURL);
		
		//------------------------------------------------------------
		
		try {
			URL url=new URL(apiURL);
			HttpURLConnection con =(HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");//요청 방식
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			int responseCode = con.getResponseCode();
			
			System.out.printf("responseCode:%d%n",responseCode);
			
			//인증 성공
			if(200 == responseCode) {
				//
				BufferedReader br =new BufferedReader(new InputStreamReader(con.getInputStream()));
				
				String line = "";
				StringBuilder  sb=new StringBuilder(1000);
				
				while( ( line=br.readLine()) !=null) {
					//System.out.println(line);
					
					sb.append(line+"\n");
				}
				
				//System.out.println(sb.toString());
				//JSON to Object
				Gson gson=new Gson();
				
				Channel channel=gson.fromJson(sb.toString(), Channel.class);
				
				List<Item> list = channel.getItems();
				
				for(Item item :list) {
					System.out.println(item);
				}
				
				
				
				br.close();
			}
			//인증 실패
			else
			{
				System.out.printf("인증 실패:%d%n",responseCode);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//------------------------------------------------------------
		
	}

}
