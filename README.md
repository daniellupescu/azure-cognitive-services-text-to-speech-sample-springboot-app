## Azure Text-to-speech demo app

Azure Text-to-speech demo app based on [Azure Text-to-speech Java SDK](https://docs.microsoft.com/en-us/azure/cognitive-services/speech-service/get-started-text-to-speech?tabs=script%2Cwindowsinstall&pivots=programming-language-java).

This is a SpringBoot app that contains 2 services:
- synthesizeAndSaveToFile: Synthesize text and save speech to a .wav file
- synthesizeAndSpeak: Synthesize text and plays the speech on your computer speakers

Edit the application.yml to put your Azure API ket, Azure region, language, output format, and output folder.

Edit the `text` variable in class `ApplicationReadyListener.java` to change the text to synthesize.

Change Maven property `<java.version>` to match the version of your JDK.

## Why this app?

I've been toying with Azure Text-to-speech Java SDK and I found some tricky things.

For instance, in case of runtime errors (e.g. wrong api key), the audio file is generated empty, so it should be deleted.

Also, it seems you can't use the same output format for a synthesized .wav file and a synthesized  speech playing on your speakers. For example, Raw24Khz16BitMonoPcm works with speakers but not with .wav files. Webm16Khz16BitMonoOpus doesn't work with speakers but works with .wav files.

This app does not pretend to be deployed as is, as a SpringBoot app on a server.
Basically, it is only an almost ready-to-use piece of code that anyone can copy into its SpringBoot app.

## Prerequisites
- Maven
- JDK 8+
- A subscription key for Azure Speech service

## Build and run the app
In the root folder:

```sh
mvn clean package
```

```sh
mvn spring-boot:run
```

## License
[MIT](https://choosealicense.com/licenses/mit/)
