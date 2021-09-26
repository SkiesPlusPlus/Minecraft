public class GaypixelUtils{
  
   private String hypixelRank = ""; 
   private static JSONObject jsonObject;
   //https://api.slothpixel.me/api/players/{PlayerName}
  
   public static String getHypixelRank(String name, boolean formatted){
       jsonObject = JSONReader.readJsonFromUrl("https://api.slothpixel.me/api/players/" + name);
       if(formatted){
            return jsonObject.getString("rank_formatted").replace('&', '§');
       }else{
            return jsonObject.getString("rank");
       }
    } 
  
    public static String getCurrentVersion(){
        jsonObject = JSONReader.readJsonFromUrl("https://raw.githubusercontent.com/SkiesPlusPlus/my-test-stuff-/main/whitelist.json");
        return object.jsonObject("version");
      //Reading ur jsons for version checking etc
    }
  
}
