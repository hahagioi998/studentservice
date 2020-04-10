package shiyan;

import java.util.List;

import cn.com.webxml.ArrayOfString;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;

public class WeaClient {
	public static void main(String[] args) {
		WeatherWS  WeatherWS=new WeatherWS();
		WeatherWSSoap   WeatherWSSoap=WeatherWS.getWeatherWSSoap();
		ArrayOfString  ArrayOfString=WeatherWSSoap.getWeather("Ыежн", null);
		List<String> list=ArrayOfString.getString();
		for(String o:list){
			System.out.println(o);
		}
	}
} 
