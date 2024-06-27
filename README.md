# ui-scan-sample-android 概要

**ui-scan-sample-android**は、[UI SCAN SDK for android](https://github.com/xtone/ui-scan-android-sdk) が組み込まれたサンプルアプリです。

## UI SCANとは
UI SCANは、デザインファイル（Figma）と実装された画面のスクリーンショットをAI搭載の独自エンジンが自動的に比較し、差分を検出するデザインチェックツールです。UI SCANを使用すると、デザインチェックがこれまでよりも簡単になります。  
   Webサイト: https://ui-scan.com/


## UI SCAN SDK for androidとは
UI SCANが提供するandroid用のSDKです。これを使うことで、開発中のアプリで簡単にスクリーンショットを撮影し、UI SCANにアップロードできます。アプリにコードを追加することで、スクロールビューを含むスクリーンショットを半自動的に撮影して、UI SCANにアップロードできます。


## 使い方
このプロジェクトを使用することで、UI SCANのサンプルプロジェクトにスクリーンショットをアップロードし、UI SCAN上での操作を体験できます。

1. [UI SCAN](https://ui-scan.com/)に登録する
2. UI SCAN内にプロジェクトを作成する
3. UI SCANのFigmaプラグイン入手する
   ※[Figmaプラグインの入手方法](https://help.ui-scan.com/ja/import-designs/figma-plugin)
6. UI SCANの[設定画面](https://app.ui-scan.com/account/apikey/)からAPIキーを入手する
7. Figmaプラグインを使って[デザインデータ（プレイグラウンドファイル）](https://www.figma.com/community/plugin/1385487013070073340/ui-scan-design-uploader)をUI SCANにアップロードする
8. 本アプリ内に含まれるSDKの該当箇所にAPIキーを挿入し、アプリをビルドする  
   ※[UI SCAN SDK for android](https://github.com/xtone/ui-scan-android-sdk) の使い方
9. アプリを起動する  
   (自動でスクリーンショットが撮影され、UI SCANへアップロードされます)
10. UI SCAN上で画面比較を行う
