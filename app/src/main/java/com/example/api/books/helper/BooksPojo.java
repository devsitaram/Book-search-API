package com.example.api.books.helper;

import java.util.List;

public class BooksPojo {
	private boolean copyright;
	private List<String> translators;
	private Formats formats;
	private List<String> languages;
	private String mediaType;
	private List<String> subjects;
	private List<String> bookshelves;
	private int id;
	private String title;
	private List<AuthorsItem> authors;
	private int downloadCount;

	// getter and setter methods
	public boolean isCopyright(){
		return copyright;
	}

	public List<String> getTranslators(){
		return translators;
	}

	public Formats getFormats(){
		return formats;
	}

	public List<String> getLanguages(){
		return languages;
	}

	public String getMediaType(){
		return mediaType;
	}

	public List<String> getSubjects(){
		return subjects;
	}

	public List<String> getBookshelves(){
		return bookshelves;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public List<AuthorsItem> getAuthors(){
		return authors;
	}

	public int getDownloadCount(){
		return downloadCount;
	}

//	public BooksPojo(int id, String title, List<AuthorsItem> authors){
//		this.id = id;
//		this.title = title;
//		this.authors = authors;
//	}

	// constructor
	public BooksPojo(boolean copyright, List<String> translators, Formats formats, List<String> languages, String mediaType, List<String> subjects, List<String> bookshelves, int id, String title, List<AuthorsItem> authors, int downloadCount) {
		this.copyright = copyright;
		this.translators = translators;
		this.formats = formats;
		this.languages = languages;
		this.mediaType = mediaType;
		this.subjects = subjects;
		this.bookshelves = bookshelves;
		this.id = id;
		this.title = title;
		this.authors = authors;
		this.downloadCount = downloadCount;
	}
}