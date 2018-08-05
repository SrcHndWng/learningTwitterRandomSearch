# learningTwitterRandomSearch

## About This

Twitterのアカウントに「@Account Keyword」形式でメッセージを投げると

キーワードで検索した結果からランダムにツイートを選び、返却してくれるBotです。

サンプルなので、無限ループでメッセージ受信を待機しているので注意してください。（Ctrl + Cで抜けます）

## 開発環境など

* openjdk 10.0.2 2018-07-17
* Spring Boot 2.0.4
* Twitter4j 4.0.6

## Usage

### 環境変数

環境変数に以下の値を設定します。

```
TWITTER_CONSUMER_KEY=Twitter APIのCunsumerKey
TWITTER_CONSUMER_SECRET=Twitter APIのConsumerSecret
TWITTER_ACCESS_TOKEN=Twitter APIのAccessToken
TWITTER_ACCESS_TOKEN_SECRET=Twitter APIのAccessTokenSecret
TWITTER_ACCOUNT=Twitter Account名
```

### 実行について

java -jar で起動します。


```
java -jar ビルドしたjarのパス
```

### 終了

Ctrl + Cで終了します。
