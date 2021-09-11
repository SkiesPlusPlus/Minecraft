public class LowRamWarning{

	private static Minecraft mc = Minecraft.getMinecraft();
	private static long timeSincePreviousUpdate = 0L;
	private int info;
	private int infoRest;
	private final String memory = "High memory usage!";
	
    //Crap code ik but whatever
	
  //hook it to GuiIngame or use a event 
	public void drawWarning(ScaledResolution resolution) {
		long max = Runtime.getRuntime().maxMemory();
		long total = Runtime.getRuntime().totalMemory();
		long free = Runtime.getRuntime().freeMemory();
		long finalValue = total - free;
		long currentMem = finalValue * 100L / max;
		if (currentMem > 90L) {
		timeSincePreviousUpdate = System.currentTimeMillis();
		}
		info = mc.fontRendererObj.getStringWidth(memory);
		infoRest = resolution.getScaledWidth() - info - 2;
		if (System.currentTimeMillis() - this.timeSincePreviousUpdate < 15000L) {
			if (mc.currentScreen instanceof GuiChat) {
				Gui.drawRect(2, 2, 100, 35, 0x90000000);
				drawScaledString("Free Memory " + free / 1500000L, 5, 5, 0.9f, -1);
				drawScaledString("Total Memory " + total / 1500000L, 5, 15, 0.9f, -1);
				drawScaledString("Max Memory " + max / 1500000L, 5, 25, 0.9f, -1);
			} else {
				Gui.drawRect(2, 2, 100, 25, 0x90000000);
				drawScaledString(memory, 5, 5, 0.9f, 16724804);
				drawScaledString("Open chat for more info!", 7, 20, 0.7f, 16724804);
			}
		}

	}

	private void drawScaledString(String text, int x, int y, float scale, int color) {
		GlStateManager.pushMatrix();
		GlStateManager.scale(scale, scale, 25);
		mc.fontRendererObj.drawString(text, x, y, color, false);
		GlStateManager.popMatrix();
	}
}
