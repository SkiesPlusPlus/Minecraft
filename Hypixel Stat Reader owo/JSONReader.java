 
 
 
 public static JSONObject readJsonFromUrl(String url){
        InputStream is = null;
        try {
            is = new URL(url).openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String readAll(Reader rd){
        StringBuilder sb = new StringBuilder();
        int cp;
        while (true) {
            try {
                if (!((cp = rd.read()) != -1)) break;
                sb.append((char) cp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
