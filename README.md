# 今回やりたいこと
WebAPIとJavaを使用してチーム開発を経験する

## 今回使用するサイト
[PokeApi](https://pokeapi.co/docs/v2)

## 【環境】
| java        | 17    |
| spring-boot | 3.4.3 |

## 参考サイト
[Spring Boot で Thymeleaf 使い方メモ](https://qiita.com/opengl-8080/items/eb3bf3b5301bae398cc2)
[【spring boot】PokeAPIでポケモンの種族値を取得するWebAPIを作成してみた。](https://qiita.com/kohei-takao/items/0405d1d3629166ab16b1)
<br>
# 【準備手順】
1. Docker Desktopを起動する
<br>
2. Visual Studio Codeを起動する
<br>
3. Visual Studio Codeのターミナルを開く
<br>
4. GitHubから以下のコマンドでソースコードをクローンする
```
git clone https://github.com/KeisukeHoshino/playlistJava.git
```
<br>
5. 「コンテナーで再度開く」というダイアログを押下するか、左下の「リモートウィンドウを開く」メニューから「コンテナーで再度開く」を押下
<br>
6. 実行とデバッグから「F5」を押下するか、「デバッグの開始」を押下する
<br>
その後は変更してブラウザを更新したらすぐに反映されるようになる
<br><br>

### APIの結果を確認するツール
ローカルを汚したくない場合
[Talend API Tester - Free Edition](https://chromewebstore.google.com/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm?hl=ja)
VSCode内で完結させたい場合
[Thunder Client](https://marketplace.visualstudio.com/items?itemName=rangav.vscode-thunder-client)
アプリを使いたい場合
[Postman](https://www.postman.com/downloads/)
