package renderEngine;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.PixelFormat;

public class DisplayManager {
	private static final int WIDTH = 1280, HEIGHT = 720, FPS_CAP = 120;
	
	public static void CreateDisplay() {
		ContextAttribs attribs = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
		
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.create(new PixelFormat(), attribs);
			Display.setTitle("3D Game Engine");
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		glViewport(0, 0, WIDTH, HEIGHT);
	}
	
	public static void updateDisplay() {
		Display.sync(FPS_CAP);
		Display.update();
	}
	
	public static void closeDisplay() {
		Display.destroy();
	}
}
