package com.example.codedesign;

import com.example.app.Application;
import com.example.factories.GUIFactory;
import com.example.factories.MacFactory;
import com.example.factories.windowsFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AbstractFactoryDemo {

	private static Application configApplication(){
		Application application;
		GUIFactory guiFactory;
		String osName = System.getProperty("os.name").toLowerCase();
		if(osName.contains("mac")){
			guiFactory=new MacFactory();
		}else {
			guiFactory=new windowsFactory();
		}
		application=new Application(guiFactory);
		return application;
	}

	public static void main(String[] args) {
		Application application=configApplication();
		application.paint();
	}

}
