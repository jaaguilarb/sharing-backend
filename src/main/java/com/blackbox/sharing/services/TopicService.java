package com.blackbox.sharing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackbox.sharing.domain.Topic;
import com.blackbox.sharing.repositories.TopicRepository;
import com.blackbox.sharing.services.exceptions.ObjectNotFoundException;

@Service
public class TopicService {
	@Autowired
	private TopicRepository reposit;
	public Topic find(Integer id) {
		Topic topic = reposit.findOne(id);
		if (topic == null) {
			throw new ObjectNotFoundException("Object Not Found! Id: " + id
					+ ", Type: " + Topic.class.getName());
		}

		return topic;
	}
}
