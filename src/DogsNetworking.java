import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import org.json.JSONObject;

public class DogsNetworking {
    private static final String BASE_URL = "https://api.api-ninjas.com/v1/dogs";
    private static final String API_KEY = "udj1mXwvLfMgGY6U9lf6jA==SxQir5ZAUgy8HopR";

    public static Dogs getDogImage() {
        String url = BASE_URL;
        String urlResponse = "";
        try {
            URI myUri = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder().header("X-Api-Key", API_KEY).uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            urlResponse = response.body();
            System.out.println(urlResponse);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        // create object of response
//        JSONObject jsonObj = new JSONObject(urlResponse);
//
//        // parse current weather info
//        JSONObject currentObj = jsonObj.getJSONObject("current");
//        double tempC = currentObj.getDouble("temp_c");
//        double tempF = currentObj.getDouble("temp_f");
//        JSONObject conditionObj = currentObj.getJSONObject("condition");
//        String condition = conditionObj.getString("text");
//        String iconURL = conditionObj.getString("icon");
//        iconURL = "https:" + iconURL;
//
//        // parse location info
//        JSONObject locationObj = jsonObj.getJSONObject("location");
//        String location = locationObj.getString("name");
//
//        // create and return Weather object
//        Weather weather = new Weather(tempC, tempF, condition, iconURL, location);
//        return weather;
        return null;
    }
}



