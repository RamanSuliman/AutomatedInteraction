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
				if(e.getKeyCode() == NativeKeyEvent.VC_SPACE)
				{
					writeMessages();
				}		
			}
		}); 
	  }
	  
	  private void writeMessages()
	  {
		    Robot robot;
			try {
				robot = new Robot();
		
			    // Move the mouse to the search bar
			    //robot.mouseMove(x, y);
		
			    // Click on the search. 
			    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			    ArrayList<String> messages = MessageLister.messages;
			    Iterator<String> ir = messages.iterator();
			    //Iterator<String> iterator = messages.iterator();
			    while (ir.hasNext()) 
			    {
			        String value = ir.next();
			        System.out.println(value);
			        for (char c : value.toCharArray()) 
			    	{
			  	      robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(c));
			  	      robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(c));
			  	    }
				    // Hit enter
				    robot.keyPress(KeyEvent.VK_ENTER);
				    robot.keyRelease(KeyEvent.VK_ENTER);
			        ir.remove();

			    }
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	  

}
