package com.example.demo.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;

public class PokemonDomain {

    /**
     * PokeApiからポケモンの一覧を取得する
     *
     * @param url string エンドポイント
     * @return NamedAPIResourceList ポケモンリスト
     */
    public static NamedAPIResourceList getPokemonList(String url) {
        NamedAPIResourceList result = null;
        try {

            URL apiUrl = new URL(url);

            // HttpURLCOnnection型にキャスト
            HttpURLConnection con = (HttpURLConnection) apiUrl.openConnection();
            con.setRequestMethod("GET");
            // 通信リンクを確立
            con.connect();

            StringBuilder stringBuilder = new StringBuilder();
            // apiからデータを取得
            try (InputStream stream = con.getInputStream()) {

                String line;
                // 文字型入力ストリームを作成
                BufferedReader br = new BufferedReader(new InputStreamReader(stream));
                // 取得したデータをjson風に変換
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(System.lineSeparator());
                }
                stream.close();

            } catch (Exception e) {
                System.err.println("Connection Error");
            }
            // apiから取得したjsonをjavaオブジェクトに変換
            result = new com.google.gson.Gson().fromJson(stringBuilder.toString().trim(), NamedAPIResourceList.class);
        } catch (MalformedURLException e) {
            System.err.println("Connection Error");
        } catch (IOException e) {
            System.err.println("Connection Error");
        }
        return result;
    }

    /**
     * PokeApiからポケモンの一覧を取得する
     *
     * @param url string エンドポイント
     * @return Pokemon ポケモンの詳細
     */
    public static Pokemon getPokemonDetail(String url) {
        Pokemon result = null;
        try {

            URL apiUrl = new URL(url);

            // HttpURLCOnnection型にキャスト
            HttpURLConnection con = (HttpURLConnection) apiUrl.openConnection();
            con.setRequestMethod("GET");
            // 通信リンクを確立
            con.connect();

            StringBuilder stringBuilder = new StringBuilder();
            // apiからデータを取得
            try (InputStream stream = con.getInputStream()) {

                String line;
                // 文字型入力ストリームを作成
                BufferedReader br = new BufferedReader(new InputStreamReader(stream));
                // 取得したデータをjson風に変換
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(System.lineSeparator());
                }
                stream.close();

            } catch (Exception e) {
                System.err.println("Connection Error");
            }
            // apiから取得したjsonをjavaオブジェクトに変換
            result = new com.google.gson.Gson().fromJson(stringBuilder.toString().trim(), Pokemon.class);
        } catch (MalformedURLException e) {
            System.err.println("Connection Error");
        } catch (IOException e) {
            System.err.println("Connection Error");
        }
        return result;
    }
}
