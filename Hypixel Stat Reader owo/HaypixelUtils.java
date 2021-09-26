public class GaypixelUtils{
  
   private String hypixelRank = "owo";
   private static JSONObject jsonObject;
   //u can prob use google gson
  
   //https://api.slothpixel.me/api/players/{PlayerName}
  
   public static String getHypixelRank(String name, boolean formatted){
       jsonObject = JSONReader.readJsonFromUrl("https://api.slothpixel.me/api/players/" + name);
       if(formatted){
            return jsonObject.getString("rank_formatted").replace('&', '§');
       }else{
            return jsonObject.getString("rank");
       }
    }
  
  //Reading custom jsons are very easy u can prolly figure out urself ok bye
  //ps : u can use github to host ur jsons too ok
   
  
  
}
