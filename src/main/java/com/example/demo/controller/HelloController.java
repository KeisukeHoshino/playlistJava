package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.form.HelloForm;
import com.example.demo.services.PokemonService;

// コントローラークラス
@Controller
public class HelloController {

    // "/"へのGETリクエストを処理するメソッド
    @GetMapping("/")
    public String helloForm(Model model) {
        // 初期値として空のHelloFormオブジェクトをビューに渡す
        model.addAttribute("form", new HelloForm());
        // "hello.html"テンプレートをレンダリング
        return "hello";
    }

    // "/send"へのPOSTリクエストを処理するメソッド
    @PostMapping("/send")
    public String submitForm(@ModelAttribute HelloForm form, Model model) {
        // 受け取ったフォームデータをビューに返すためにModelに設定
        model.addAttribute("form", form); // フォームオブジェクトを再度ビューに渡す
        // 入力された名前を利用してメッセージを生成し、Modelに設定
        model.addAttribute("message", "こんにちは aa" + form.getName() + "!");
        // "hello.html"テンプレートを再度レンダリング
        return "hello";
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("form", new HelloForm());

        ArrayList<String> pokemonNameList = PokemonService.getPokemonList(100, 0);

        // namesにポケモンの名前を格納
        model.addAttribute("names", pokemonNameList);

        return "test";
    }

    @GetMapping("/detail")
    public String getMethodName(Model model, @RequestParam("pokemonName") String pokemonName) {
        model.addAttribute("pokemonName", pokemonName);
        HashMap<String, String> map = PokemonService.getPokemonDetail(pokemonName);
        model.addAttribute("map", map);
        return "detail";
    }

}
