package Conexao;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConexaoAPI {
    private String endereco = "https://v6.exchangerate-api.com/v6/9a66b296daa3cbda4c9ea2a7/latest/USD";

    public JsonObject puxarDados() throws IOException, InterruptedException {
        URL url = new URL(endereco);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();
        return jsonobj;
    }
}
