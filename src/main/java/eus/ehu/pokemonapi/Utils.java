package eus.ehu.pokemonapi;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Utils {

    public static String readFile(String filename) {
        String content = "";
        try {
            // read filename from resources folder
            URL fileURL = Utils.class.getResource(filename);
            content = new String(Files.readAllBytes(Paths.get(fileURL.getFile())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static String request(String endpoint) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://pokeapi.co/api/v2/" + endpoint)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
