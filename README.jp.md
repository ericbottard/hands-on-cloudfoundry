Note: Instructions in English are available [here](https://github.com/ericbottard/hands-on-cloudfoundry/blob/master/README.md)

#CLOUDFOUNDRYハンズオンセミナー
##実習 1 (5 to 30分)
　このエクセサイズでは、ハンズオンを始める前にあらかじめ準備しておかなければならないことを実施いたします。
###VMC
ターミナルで'vmc'コマンドを実行してみてください。もし、ターミナルに以下の文字が表示さえるようでしたら、次のステップに進みください。 
```bash   
vmc: command not found
```
次のステップに進みください。

1. ターミナルで`ruby -v` を実行してください。Rubyバージョン1.9.2もしくは1.8.7が必要になります。Rubyのインストールは以下を参考にしてください。 
    * windowsの場合、 http://www.rubyinstaller.org を参照してください。
    * Macの場合、デフォルトでRubyがインストールされているので, rvm（https://rvm.io/）を使ってvmcバージョンの動くrubyバージョンもインストールし同居させてください。
    * linuxの場合、 `apt` もしくは rvm（https://rvm.io/）を使ってインストールしてください。
1. `sudo gem install vmc -V`を実行してください。

###SpringSource Tool Suite (STS)の場合

1. http://www.springsource.org/spring-tool-suite-download にブラウザアクセスしてください。
1. バージョン3.0.0以降をダウンロードしてください。
1. unzip後、インストーラを起動し、環境に応じて各オプションの設定を行ってください。

####CloudFoundry Pluginのインストール
STSの`Help > About`で、CloudFoundryのiconがないこを確認する。

1. `Help> Eclipse Marketplace` にアクセスしてください。
2. "CloudFoundry"で検索してください。
3. STSにインストール、その後、STSを再起動してください。

###Gitツールのインストール

1. http://git-scm.com/downloads にブラウザアクセスをしてください。
1. このブラウザの説明に従って'Git'をインストールしてください。

###Mavenのインストール 
1. ターミナルにて`mvn --version` を実行してください。
1. このチュートリアルでは3.0.3以降のMavenを推奨いたします。
1. もし、Mavenがインストールされていなければ、STSにも含まれています。

###ボーナス:
既にMicro Cloud Foundryがダウンロードされているなら、セットアップしてみてください。

##実習 2 (20分)

###Wローカル環境でのアプリケーション動作 (10分)
1. https://github.com/ericbottard/spring-social-showcase からGit Cloneコマンドにてアプリケーションをコピーしてください。
1. ローカル環境でテストしてください。 (`mvn tomcat:run` もしは STSにて"Import as Maven project"を実行し、新しく作成したvFabric tcServerにドラック＆ドロップしてください。

###.クラウド環境でのアプリケーション動作(10分)
1.  http://cloudfoundry.com でアカウント作成 ("Sign up for cloud foundry")
    1. emailアドレスがアカウントになります。
    1. サインアップ後、送られてきたemailにパスワードが記述されています。パスワードは変更可能です。
    1. サインアップ時には、本セッションで割り当てられたプロモートコードを利用してください。
1. CloudFoundryへのアプリケーションのデプロイは、`vmc push`コマンドを利用してください。アプリケーションサービスはPostgreSQL serviceをバインディングしてください。
1. Look Ma! I'm in the Cloud!

ヒント:

- 最初にアプリケーションのビルドが必要です。(`mvn package`)
- ビルドの結果は`target/`に出力されます。
- `vmc` を動作させるためのカレントディレクトリを指定します。`--path xxxx` のオプションを使う事で実行場所を指定できます。
-　vmcでアプリ名など必要な設定を行います。

###ボーナス:
一度、アプリケーション及びサービスを削除し、STSを使って再度アプリケーションを展開してください。

##実習 3 (10分)

以下のコマンドを実行してください。

 * `vmc apps` (展開されているアプリケーション名の表示)
 * `vmc instances` *your_app_name* `+1`
 * `vmc services` (利用可能なサービス名の表示)
 * `vmc runtimes`
 * `vmc frameworks`
 * `vmc stats` *your_app_name*
 * `vmc logs` *your_app_name*
 * `vmc help`

###ボーナス:
 * `vmc files`を実行してください。
 * WEB-INFのディレクトリを参照し、何が変更されているか調査してください。

##実習 4 (15分)

実習4を始めるにあたり、https://github.com/ericbottard/hands-on-cloudfoundry のコードをコピーしてスケルトンとしてご利用ください。いくつかコードがコメントアウトされているとこは、コメントを削除し、次のステップに進んでください。わからないところは、遠慮なくRepoやTwitterを使って質問してください。
もう一度、STSを使ってコピーされたプロジェクトをMavenプロジェクトとしてインポートします。

1. 環境変数を表示するwebアプリを作成します。。
1. まずはローカルにデプロイ、その後、CloudFoundryにデプロイします。。
1. "VCAP_*"で変数を参照します。
1. 次に自分で作成したアプリケーションにサービスをバインドします。
1. その後、`VCAP_SERVICES`の環境変数はどのようになっているか確認してください。

##ボーナス:
同じようにRuby on Rails、sinatraもしくはnode.jsでも実施してみてください。

ヒント: sinatraでの例を以下に記述します。
```ruby
require 'rubygems'
require 'sinatra'
get '/' do
	s = ''
	  ENV.each{|k, v| s += "#{k} = #{v}<br>"}
	s
end
```

##実習 5 (15分)

1. 最初のデータソースをembedded H2 DBに設定します。(もしくは、自分の環境にあったその他のDBでも構いません）.
2. Databaseが使えるようにPersonControllerクラスを改修します。
3. ローカル環境にデプロイしなさい。
3. PostgreSQLサービスを使ったCloud Foundryのアプリケーションとしてデプロイしましょう。アプリケーションはなにも変更せずに動作いたします。

ヒント:

- Springは、EmbeddedDatabaseFactory`を利用することにより、簡単にembeddedデータベースを作成することができます。
- Personsレコードを保存しているデータを読み込む場合。そのときの`jdbcTemplate.query(sql, parameters, BeanPropertyRowMapper)`を確認してください。
- Personsレコードを新しく永続化する場合、T`jdbcTemplate.update(sql, new BeanPropertySqlParameterSource)` を確認してください。

###ボーナス:
DataSourceをインジェクションするときのログ出力を確認します。ローカルにてどのような処理がされていますか？、また、CloudFoundry上ではどうでしょうか？

##実習 6 (15分)

1.さらにもう一つデータストアを追加します。（embedded H2） 
2. 二つのデータストアが使えるように`CopyController`を改修いたします。 
3. ローカル環境にデプロイしてください。
4. Cloud Foundry上にデプロイしてください。ログを見ながら何が違うか比較してください。

ヒント:

- アプリケーションのスタート／ストップの操作を行ってみてください。

##実習 7 (20分)

1. もし、クラスに@Configurationを利用している場合は、二つのデータソースを削除します。
2. context-ex7.xmlにて、'default'と'cloud'の二つのプロファイルを作成します。
3. default'プロファイルの中に二つのローカルデータソースをを宣言します。その宣言の中で、`<jdbc: />` namesplaceを利用することができます。
4. この場合 `<cloud:xxx />` namespace.を利用します。
###ボーナス:

XML関連の情報を削除し、その代わりに@Configuration`を利用してみてください。

ヒント: 

- プロファイル情報をもとに`@Profile()`を使って設定を行ってください。
- `@Configuration`で定義したクラス内で、`CloudEnvironment` をインジェクションすることができます。
-  relational servicesに関する情報を得るためには、`serviceInfoType` と同様な `RdbmsServiceInfo.class`にある`cloudEnvironment.getServiceInfo(String name, Class<T> serviceInfoType)`を使うことができます。