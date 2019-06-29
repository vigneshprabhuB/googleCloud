package com.vignesh.google.clouddStoreage;

import java.io.File;
import java.io.FileInputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String... args) throws Exception {
		// Instantiates a client
		String PATH_TO_JSON_KEY = "/oauthClientWeb-ddf19fb0550a.json";

		StorageOptions options = StorageOptions
				.newBuilder()
				.setCredentials(
				GoogleCredentials.fromStream(new FileInputStream(System
				.getProperty("user.dir") + PATH_TO_JSON_KEY)))
				.build();
		Storage storage = options.getService();
		Blob blob = storage.get("oauthclientweb.appspot.com", "demo/");
	   
	
		
				

	}

}
