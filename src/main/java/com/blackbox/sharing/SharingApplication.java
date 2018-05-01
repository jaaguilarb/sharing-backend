package com.blackbox.sharing;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.blackbox.sharing.domain.Course;
import com.blackbox.sharing.domain.Member;
import com.blackbox.sharing.domain.QA;
import com.blackbox.sharing.domain.QAType;
import com.blackbox.sharing.domain.ResourceType;
import com.blackbox.sharing.domain.Role;
import com.blackbox.sharing.domain.Test;
import com.blackbox.sharing.domain.Topic;
import com.blackbox.sharing.repositories.CourseRepository;
import com.blackbox.sharing.repositories.MemberRepository;
import com.blackbox.sharing.repositories.QARepository;
import com.blackbox.sharing.repositories.RoleRepository;
import com.blackbox.sharing.repositories.TestRepository;
import com.blackbox.sharing.repositories.TopicRepository;

@ComponentScan
@SpringBootApplication
public class SharingApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private QARepository qaRepository;
	@Autowired
	private TestRepository testRepository;
	@Autowired
	private TopicRepository topicRepository;

	public static void main(String[] args) {
		SpringApplication.run(SharingApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Role r1 = new Role(null, "Admin");
		Role r2 = new Role(null, "Learner");
		Role r3 = new Role(null, "Assistant");

		Member m1 = new Member(null, "Alba", "alba@gmail.com", 0.0f, null, Arrays.asList(r1));
		Member m2 = new Member(null, "Ikram", "ikram@gmail.com", 0.0f, null, Arrays.asList(r2));
		Member m3 = new Member(null, "Danis", "danis@gmail.com", 0.0f, null, Arrays.asList(r1,r2,r3));

		Course c1 = new Course(null, "Reinforcement learning", "This course is about reinforcement learning with python and keras.");
		Course c2 = new Course(null, "Differential equiations", "This course is about differential equations.");
		Course c3 = new Course(null, "Supervised learning", "This course is about supervised learning.");

		QA q1 = new QA(null, "Is rotation necessary in PCA?", "Yes", "", QAType.YES_NO, null);
		QA q2 = new QA(null, "How is True Positive Rate and Recall related? Write the equation", "True Positive Rate = Recall. Yes, they are equal having the formula (TP/TP + FN)", "", QAType.FILL_IN_THE_BLANK, null);
		QA q3 = new QA(null, "What cross validation technique would you use on time series data set? Is it k-fold or LOOCV?", "Neither", "", QAType.ONLY_ONE_OPTION, null);
		QA q4 = new QA(null, "What do you understand by Type I vs Type II error ?", "1. Type I error is committed when the null hypothesis is true and we reject it. Type II error is committed when the null hypothesis is false and we accept it.:@:2.:@:3.:@:4.", "", QAType.ONLY_ONE_OPTION, null);
		QA q5 = new QA(null, "Which of these is not a supervised learning method", "1.K-Nearest Neighbor:@:2.Decision Trees:@:3.K-Means:@:4.Support Vector Machines", "", QAType.YES_NO, null);

		Test tt1 = new Test(null, Arrays.asList(q1, q2, q3, q4, q5), null);

		Topic tp1 = new Topic(null, "Introduction", "", c3, null, ResourceType.VIDEO);
		Topic tp2 = new Topic(null, "Decision Trees", "", c3, null, ResourceType.VIDEO);
		Topic tp3 = new Topic(null, "Support Vector Machines", "", c3, null, ResourceType.DOCUMENT);
		Topic tp4 = new Topic(null, "K-Nearest Neighbor", "", c3, null, ResourceType.VIDEO);

		tp1.setTest(tt1);
		tp1.setCourse(c3);
		tp2.setCourse(c3);
		tp3.setCourse(c3);
		tp4.setCourse(c3);

		tt1.setTopic(tp1);

		c3.setTopics(Arrays.asList(tp1, tp2, tp3, tp4));
		
		q1.setTest(tt1);
		q2.setTest(tt1);
		q3.setTest(tt1);
		q4.setTest(tt1);
		q5.setTest(tt1);
		tt1.setQuestions(Arrays.asList(q1, q2, q3, q4, q5));

		m1.getAssignedCourses().addAll(Arrays.asList(c1, c3));
		m2.getAssignedCourses().addAll(Arrays.asList(c2));
		m3.getAssignedCourses().addAll(Arrays.asList(c1, c2, c3));

		c1.getLearners().addAll(Arrays.asList(m1, m3));
		c2.getLearners().addAll(Arrays.asList(m2, m3));
		c3.getLearners().addAll(Arrays.asList(m1, m3));

		roleRepository.save(Arrays.asList(r1, r2, r3));
		memberRepository.save(Arrays.asList(m1, m2, m3));
		courseRepository.save(Arrays.asList(c1, c2, c3));
		topicRepository.save(Arrays.asList(tp1, tp2, tp3, tp4));
		testRepository.save(Arrays.asList(tt1));
		qaRepository.save(Arrays.asList(q1, q2, q3, q4, q5));
	}
}
