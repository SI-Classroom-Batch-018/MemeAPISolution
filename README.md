# Aufgaben

Willkommen zurück bei JokeHub! Wir freuen uns, dass du uns bereits kennst und wir wieder
zusammenarbeiten können. Diesmal haben wir eine neue spannende Aufgabe für dich: Wir benötigen eine
weitere App!

## Meme App

In dieser App holen wir mit einem API-Call eine Liste aus Meme Vorlagen. Diese Memes werden wir in
der App anzeigen lassen, mit der Möglichkeit, eigene Untertitel zu schreiben und zu speichern.
<p align="center">
<img src=img/img1.png width="25%">
</p>

Die Dokumentation der API, die wir in dieser App benutzen werden, findest Du
hier: [MemeAPI](https://imgflip.com/api), schau sie dir einmal an.

* Erstelle eine `data class Meme` in einem neuen package *data/datamodels*. Von dieser Klasse können
  Meme-Objekte instanziiert werden. Die Klasse wird verwendet, um die Serverantwort zu übersetzen. In der
  Dokumentation siehst du, wie die Serverantwort aussieht.

* Baue den API-Service ein. Erstelle dazu eine Datei `MemeApiService` im package *remote*.
  > Hinweis:
  > Orientiere dich an den Vorlesung.

  Die Datei sollte Folgendes enthalten:
    * Die URL der API: ` "https://api.imgflip.com/" `
    * Moshi & Retrofit
    * Eine `suspend fun getMemes()`, die uns die Liste an `Meme` Objekten liefert. Die Funktion
      befindet sich in einem `Interface MemeApiService`. In der `@GET` Annotation wird die URL so
      spezifiziert:  
      ` "get_memes" `
    * Ein Objekt `object MemeApi`, welches eine `retrofitService` Variable enthält

* Füge dem App Repository im Konstruktor eine `api` Variable hinzu. Im Repository soll es eine
  LiveData Variable `memes` geben und eine `suspend fun getMemes()`, welche den API Call
  über `api.retrofitService` ausführt und das Ergebnis in der LiveData Variable speichert.
  Tipp: hier bietet sich ein `try`-`catch`-Block an

* Lade die Informationen aus dem Repository in das ViewModel. Achte darauf die
  Funktion `loadMemes()` aus dem Repository innerhalb einer Coroutine aufzurufen.

* Über den Klick auf den Refresh Button soll der API Call über das ViewModel ausgeführt werden.

* Beobachte die Daten aus dem ViewModel und lass dir die Memes in der RecyclerView anzeigen.
    * In einem Meme Objekt sollte die Bild URL gespeichert sein. Erstelle daraus eine URI.
      > Hinweis: `url.toUri().buildUpon().scheme("https").build()`
    * Nutze die Funktion `load()` von Coil, die du über die ImageView aufrufen kannst, um das Bild
      mithilfe der URI zu laden.

* Über den Speicherbutton soll der Untertitel des Memes gespeichert werden.

Viel Erfolg! 🚀

