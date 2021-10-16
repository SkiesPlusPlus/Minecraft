public class RamWarning {

	private static Minecraft mc = Minecraft.getMinecraft();
	private static long timeSincePreviousUpdate = 0L;
	private final String memory = "High memory usage!";
	
    //Crap code ik but whatever
	
  //Hook it to GuiIngame#renderOverlay or use a event!
	public void drawWarning() {
		long max = Runtime.getRuntime().maxMemory();
		long total = Runtime.getRuntime().totalMemory();
		long free = Runtime.getRuntime().freeMemory();
		long finalValue = total - free;
		long currentMem = finalValue * 100L / max;
		if (currentMem > 90L) {
		timeSincePreviousUpdate = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - this.timeSincePreviousUpdate < 15000L) {
			if (mc.currentScreen instanceof GuiChat) {
				Gui.drawRect(2, 2, 100, 35, 0x90000000);
				drawScaledString("Free Memory " + free / 1500000L, 5, 5, 0.9f, -1);
				drawScaledString("Total Memory " + total / 1500000L, 5, 15, 0.9f, -1);
				drawScaledString("Max Memory " + max / 1500000L, 5, 25, 0.9f, -1);
        //shows more info if chat is opened
			} else {
				Gui.drawRect(2, 2, 100, 25, 0x90000000);
				drawScaledString(memory, 5, 5, 0.9f, 16724804);
				drawScaledString("Open chat for more info!", 7, 20, 0.7f, 16724804);
			}
		}

	}

	private void drawScaledString(String text, int x, int y, float scale, int color) {
		//this is not how u scale a string u have to translate it but whatever
		GlStateManager.pushMatrix();
		GlStateManager.scale(scale, scale, 25);
		mc.fontRendererObj.drawString(text, x, y, color, false);
		GlStateManager.popMatrix();
	}
}
