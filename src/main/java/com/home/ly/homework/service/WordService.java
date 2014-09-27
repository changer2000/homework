package com.home.ly.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.ly.homework.dao.WordDao;
import com.home.ly.homework.peer.WordPeer;
import com.home.system.service.BaseService;

@Service
public class WordService extends BaseService {
	
	@Autowired
	private WordDao wordDao;
	
	public WordPeer saveOneWord(String word, String content) {
		WordPeer peer = new WordPeer();
		peer.setWord(word);
		peer.setContent(content);
		wordDao.save(peer);
		return peer;
	}
	
	public WordDao getWordDao() {
		return wordDao;
	}

	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	
	
}
