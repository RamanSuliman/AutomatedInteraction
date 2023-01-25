package main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Reader 
{
	  public static void main(String[] args) throws Exception 
	  {
		  System.out.println(MessageLister.messages.size());
		  //Start the program 
		  new Reader();
	  }
	  
	  public Reader()
	  {
		  keyLogger();
	  }
	  
	  private void keyLogger()
	  {
		  try {
			  GlobalScreen.registerNativeHook();
		  }catch (Exception e) {
			e.printStackTrace();
		  }
		  GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
			
			public void nativeKeyTyped(NativeKeyEvent e) {}
			public void nativeKeyPressed(NativeKeyEvent e	) {}
			
			public void nativeKeyReleased(NativeKeyEvent e) 
			{
					
			}
		}); 
	  }

}
