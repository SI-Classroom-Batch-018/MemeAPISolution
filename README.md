# Aufgaben
## Meme App
In dieser App holen wir mit einem API-Call eine Liste aus Meme Vorlagen. Diese Memes werden wir in der App anzeigen lassen, mit der Möglichkeit, eigene Untertitel zu schreiben und zu speichern. 
<p align="center">
<img height="300" src="https://user-images.githubusercontent.com/101095654/228517427-c1e951b1-3c5f-4d8e-ae60-1da70b679dfe.png">
</p>

Die Dokumentation der API, die wir in dieser App benutzen werden, findest Du hier: [MemeAPI](https://imgflip.com/api), schau sie dir einmal an.

* Bevor es losgehen kann, müssen wir noch die richtigen Berechtigungen und Dependencies für den API-Call angeben:
  
  In der *AndroidManifest.xml* Datei:
  ```kotlin
  <uses-permission android:name="android.permission.INTERNET" />
  ```
  
  In der *build.gradle(Module)* Datei unter *dependencies*:
  
  ```kotlin
  //Retrofit
  implementation "com.squareup.retrofit2:retrofit:2.9.0"
  implementation "com.squareup.retrofit2:converter-moshi:2.9.0"
  implementation "com.squareup.moshi:moshi-kotlin:1.13.0"
  ```
  
  > Hinweis: 
  > Falls Android Studio dir ein update der dependencies auf eine neuere Version vorschlägt, kannst du dieses gerne durchführen, achte nur darauf, dass du dann evtl. auch die Kotlin Version updaten musst.
 
* Erstelle eine `data class Meme` im package *data*. Von dieser Klasse können Meme-Objekte instanziiert werden und wird verwendet um die Serverantwort zu übersetzen. In der Dokumentation siehst du, wie die Serverantwort aussieht.

* Baue den API-Service ein. Erstelle dazu eine Datei `MemeApiService` im package *remote*.
  > Hinweis: 
  > Orientiere dich an den Vorlesungsfolien und/oder der Live App.
  
  Die Datei sollte Folgendes enthalten:
  * Die URL der API: ` "https://api.imgflip.com/" `
  * Moshi & Retrofit
  * Eine `suspend fun getMemes()`, die uns die Liste an `Meme` Objekten liefert. Die Funktion befindet sich in einem `Interface MemeApiService`. In der `@GET` Annotation wird die URL so spezifiziert:  
    ` "get_memes" `
  * Ein Objekt `object MemeApi`, welches eine `retrofitService` Variable enthält

* Füge dem App Repository im Konstruktor eine `api` Variable hinzu. Im Repository soll es eine LiveData Variable `memes` geben und eine `suspend fun getMemes()`, welche den API Call über `api.retrofitService` ausführt und das Ergebnis in der LiveData Variable speichert.
  Tipp: hier bietet sich ein `try`-`catch`-Block an
  
* Lade die Informationen aus dem Repository in das ViewModel. Achte darauf die Funktion `loadMemes()` aus dem Repository innerhalb einer Coroutine aufzurufen.

* Über den Klick auf den Refresh Button soll der API Call über das ViewModel ausgeführt werden.

* Beobachte die Daten aus dem ViewModel und lass dir die Memes in der RecyclerView anzeigen.
  * In einem Meme Objekt sollte die Bild URL gespeichert sein. Erstelle daraus eine URI.
    > Hinweis: `url.toUri().buildUpon().scheme("https").build()`
  * Nutze die Funktion `load()` von Coil, die du über die ImageView aufrufen kannst, um das Bild mithilfe der URI zu laden.
  
* Über den Speicherbutton soll der Untertitel des Memes gespeichert werden.

Viel Erfolg! 🚀

