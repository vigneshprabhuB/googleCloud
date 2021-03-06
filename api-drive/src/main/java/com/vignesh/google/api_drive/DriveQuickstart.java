package com.vignesh.google.api_drive;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.Json;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

public class DriveQuickstart {
	static JSONObject jsonObject = new JSONObject();
	private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";

	private static final JsonFactory JSON_FACTORY = JacksonFactory
			.getDefaultInstance();

	// Directory to store user credentials for this application.
	private static final java.io.File CREDENTIALS_FOLDER //
	= new java.io.File(System.getProperty("user.home"), "credentials");

	private static final String CLIENT_SECRET_FILE_NAME = "client_secret.json";

	//
	// Global instance of the scopes required by this quickstart. If modifying
	// these
	// scopes, delete your previously saved credentials/ folder.
	//
	private static final List<String> SCOPES = Collections
			.singletonList(DriveScopes.DRIVE);

	private static Credential getCredentials(
			final NetHttpTransport HTTP_TRANSPORT) throws IOException {

		java.io.File clientSecretFilePath = new java.io.File(
				CREDENTIALS_FOLDER, CLIENT_SECRET_FILE_NAME);

		if (!clientSecretFilePath.exists()) {
			throw new FileNotFoundException("Please copy "
					+ CLIENT_SECRET_FILE_NAME //
					+ " to folder: " + CREDENTIALS_FOLDER.getAbsolutePath());
		}

		// Load client secrets.
		InputStream in = new FileInputStream(clientSecretFilePath);

		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
				JSON_FACTORY, new InputStreamReader(in));

		// Build flow and trigger user authorization request.
		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
				HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
				.setDataStoreFactory(
						new FileDataStoreFactory(CREDENTIALS_FOLDER))
				.setAccessType("offline").build();

		return new AuthorizationCodeInstalledApp(flow,
				new LocalServerReceiver()).authorize("user");
	}

	public static void main(String... args) throws IOException,
			GeneralSecurityException {

	
		// /new DriveQuickstart().getAllFolderFilesFromKnowledgeFoldera("");
		new DriveQuickstart().getAllFolderFilesFromKnowledgeFolder("1W_wSoT8qNXX-x1DcU1it0n2V_aMdkyHe");

	}

	public boolean isFolder(String googleFolderIdParent) throws IOException,
			GeneralSecurityException {

		List<File> list = new ArrayList<File>();
		String query = null;
		String pageToken = null;
		query = " mimeType = 'application/vnd.google-apps.folder' " //
				+ " and '" + googleFolderIdParent + "' in parents";
		do {
			FileList result = DriveQuickstart.getService().files()
					.list()
					.setQ(query)
					.setSpaces("drive")
					//
					// Fields will be assigned values: id, name, createdTime
					.setFields(
							"nextPageToken, files(id, name, createdTime,mimeType)")//
					.setPageToken(pageToken).execute();

			for (File file : result.getFiles()) {
				list.add(file);

			}
			pageToken = result.getNextPageToken();
		} while (pageToken != null);

		return list.size() > 0 ? true : false;
	}

	public HashMap<String, Object> getAllFolderFilesFromKnowledgeFolder(String googleFolderIdParent)throws IOException, GeneralSecurityException {
		
		 HashMap<String, Object>filesDetail=new HashMap<String, Object>();
		List<File> folders = new ArrayList<File>();
		List<File> files = new ArrayList<File>();
	
		String query = null;
		String pageToken = null;
		query = " mimeType = 'application/vnd.google-apps.folder' " //
				+ " and '" + googleFolderIdParent + "' in parents";
		do {
			FileList result = DriveQuickstart.getService().files()
					.list()
					.setQ(query)
					.setSpaces("drive")
					//
					// Fields will be assigned values: id, name, createdTime
					.setFields(
							"nextPageToken, files(id, name, createdTime,mimeType)")//
					.setPageToken(pageToken).execute();

			for (File file : result.getFiles()) {

				folders.add(file);
			}

			pageToken = result.getNextPageToken();

		} while (pageToken != null);
		
		files=this.getAllFolderFilesForId(googleFolderIdParent);
       
        filesDetail.put("folders", folders);
        filesDetail.put("files", files);
        return filesDetail;
	}

	public List<File> getAllFolderFilesForId(String googleFolderIdParent)
			throws IOException, GeneralSecurityException {

		List<File> listFile = new ArrayList<File>();
		String pageToken = null;
		String query2 = " mimeType != 'application/vnd.google-apps.folder' " //
				+ " and '" + googleFolderIdParent + "' in parents";
		do {
			FileList result1 = DriveQuickstart.getService().files().list()
					.setQ(query2).setSpaces("drive") //
					// Fields will be assigned values: id, name, createdTime
					.setFields("nextPageToken, files(id, name, createdTime)")//
					.setPageToken(pageToken).execute();

			for (File file : result1.getFiles()) {
				listFile.add(file);
			}
			pageToken = result1.getNextPageToken();
		} while (pageToken != null);

		return listFile;
	}

	public static Drive getService() throws IOException,
			GeneralSecurityException {
		// System.out.println("CREDENTIALS_FOLDER: " +
		// CREDENTIALS_FOLDER.getAbsolutePath());
		// 1: Create CREDENTIALS_FOLDER
		if (!CREDENTIALS_FOLDER.exists()) {
			CREDENTIALS_FOLDER.mkdirs();

			// System.out.println("Created Folder: " +
			// CREDENTIALS_FOLDER.getAbsolutePath());
			// System.out.println("Copy file " + CLIENT_SECRET_FILE_NAME +
			// " into folder above.. and rerun this class!!");

		}
		// 2: Build a new authorized API client service.
		final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport
				.newTrustedTransport();

		// 3: Read client_secret.json file & create Credential object.
		Credential credential = getCredentials(HTTP_TRANSPORT);

		// 5: Create Google Drive Service.
		Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY,
				credential).setApplicationName(APPLICATION_NAME).build();
		return service;
	}
}

class GoogleDiretories {

	public String id;
	public String name;
	public String createdTime;

	public boolean validity;

	public List<GoogleDiretories> folders = new ArrayList<GoogleDiretories>();
	public List<GoogleDiretories> files = new ArrayList<GoogleDiretories>();

	public List<GoogleDiretories> getFolders() {
		return folders;
	}

	public List<GoogleDiretories> getFiles() {
		return files;
	}

	public void setFolders(List<GoogleDiretories> folders) {
		this.folders = folders;
	}

	public void setFiles(List<GoogleDiretories> files) {
		this.files = files;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public boolean isValidity() {
		return validity;
	}

	public void setValidity(boolean validity) {
		this.validity = validity;
	}

}
