package API;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

public class RestoreBD {
    private static RequestBody requestBody;
    private static Request request;
    private static OkHttpClient client;
    private static Response response;
    private static Call call;
    private static String baseUrl = "https://local.tmetric.com:30000/api/tests";

    public static void checkStatusCode() throws ApiException {
        int codeStatus = response.code();
        if (codeStatus != 200) {
            throw new ApiException(codeStatus, "Status code not 200");
        }
    }
    public  static void restoreDB (String nameWorkspace) throws IOException, ApiException, InterruptedException {
        Gson gson = new Gson();
        request = new Request.Builder()
                .header("Content-Type","Application/json")
                .get()
                .url(baseUrl+"/database/"+nameWorkspace )
                .build();

        client = new OkHttpClient();
        call = client.newCall(request);
       response = call.execute();
        checkStatusCode();

    }
}
