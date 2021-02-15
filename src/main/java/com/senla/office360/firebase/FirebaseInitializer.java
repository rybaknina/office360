package com.senla.office360.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
/*
examples:
   https://medium.com/techwasti/spring-boot-firebase-crud-b0afab27b26e
   https://medium.com/@prakash_chandra/crud-operations-in-springboot-using-firestore-f342e95e7802
video firebase vs SQL:
   https://firebase.google.com/docs/database/video-series
* */
@Service
public class FirebaseInitializer {
    @PostConstruct
    public void initialize() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/db/serviceaccount.json"); // download own json test db or paid db

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://office360-34a31-default-rtdb.firebaseio.com/") // name of your test db
                .build();

        FirebaseApp.initializeApp(options);
    }
}
