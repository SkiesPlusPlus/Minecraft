public class NameItUrself extends Module{

	@Override
	public String getName() {
		return "Hotbarthingidk";
	}

    @EventTarget
    public void renderKeys(RenderEvent event) {
            ScaledResolution resolution = new ScaledResolution(mc);
            int x = resolution.getScaledWidth() / 2 - 87;
            int y = resolution.getScaledHeight() - 18;
            int[] hotbarKeys = getHotbarBindings();
            for (int slot = 0; slot < 9; slot++) {
            mc.fontRendererObj.drawString(getStringPerKey(hotbarKeys[slot]), x + slot * 20, y, -1);
        }
    }
    private String getStringPerKey(int key) {
        return (key < 0) ? ("M" + (key + 101)) : ((key < 256) ? Keyboard.getKeyName(key) : String.format("%c", (char) (key - 256)).toUpperCase());
    }
    private int[] getHotbarBindings() {
        int[] finalResult = new int[9];
        KeyBinding[] bindings = mc.gameSettings.keyBindsHotbar;
        int keyBind = Math.min(finalResult.length, bindings.length);
        for (int i = 0; i < keyBind; i++) {
        	finalResult[i] = bindings[i].getKeyCode();
        }
        return finalResult;
    }  
  
    /*
     * this is not my code 
     * Credits :- https://www.curseforge.com/minecraft/mc-mods/vanilla-enhancements;
     */
}
