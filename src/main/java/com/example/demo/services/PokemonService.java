package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.demo.domain.PokemonDomain;
import com.github.oscar0812.pokeapi.models.pokemon.Pokemon;
import com.github.oscar0812.pokeapi.models.resources.NamedAPIResourceList;
import com.github.oscar0812.pokeapi.models.utility.NamedAPIResource;

public class PokemonService {

    /**
     * ポケモンの一覧を取得する
     *
     * @param limit  int 件数
     * @param offset int リストの始まりのid
     * @return ArrayList<String> ポケモンのリスト
     */
    public static ArrayList<String> getPokemonList(int limit, int offset) {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon?limit=" + limit + "&offset=" + offset;
        NamedAPIResourceList pokemonList = PokemonDomain.getPokemonList(apiUrl);
        // namesにポケモンの一覧を格納
        ArrayList<String> pokemonNameList = new ArrayList<>();
        for (NamedAPIResource list : pokemonList.getResults()) {
            pokemonNameList.add(list.getName());
        }
        return pokemonNameList;
    }

    /**
     * ポケモンの詳細情報を取得する
     *
     * @param pokemonName int ポケモンの名前
     * @return HashMap<String, String> ポケモンの詳細情報
     */
    public static HashMap<String, String> getPokemonDetail(String pokemonName) {
        String apiUrl = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;
        Pokemon pokemonDetail = PokemonDomain.getPokemonDetail(apiUrl);
        // namesにポケモンの一覧を格納

        HashMap<String, String> map = new HashMap<>();

        // ポケモンのタイプを設定する
        map.put("firstType", pokemonDetail.getTypes().get(0).getType().getName());
        if (pokemonDetail.getTypes().size() == 2) {
            map.put("secondType", pokemonDetail.getTypes().get(1).getType().getName());
        }
        // ポケモンの正面画像を設定する
        map.put("image", pokemonDetail.getSprites().getFrontDefault());

        return map;
    }
}
