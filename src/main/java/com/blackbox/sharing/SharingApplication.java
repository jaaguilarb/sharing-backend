package com.blackbox.sharing;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.blackbox.sharing.domain.Course;
import com.blackbox.sharing.domain.Member;
import com.blackbox.sharing.domain.Role;
import com.blackbox.sharing.repositories.CourseRepository;
import com.blackbox.sharing.repositories.MemberRepository;
import com.blackbox.sharing.repositories.RoleRepository;

@ComponentScan
@SpringBootApplication
public class SharingApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private CourseRepository courseRepository;

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
		Member m3 = new Member(null, "Danis", "danis@gmail.com", 0.0f, null, Arrays.asList(r3));

		Course c1 = new Course(null, "Reinforcement learning", "This course is about reinforcement learning with python and keras.");
		Course c2 = new Course(null, "Differential equiations", "This course is about differential equations.");
		Course c3 = new Course(null, "Supervised learning", "This course is about supervised learning.");

		m1.getAssignedCourses().addAll(Arrays.asList(c1, c3));
		m2.getAssignedCourses().addAll(Arrays.asList(c2));
		m3.getAssignedCourses().addAll(Arrays.asList(c1, c2, c3));

		c1.getHasLearners().addAll(Arrays.asList(m1, m3));
		c2.getHasLearners().addAll(Arrays.asList(m2, m3));
		c3.getHasLearners().addAll(Arrays.asList(m1, m3));

		roleRepository.save(Arrays.asList(r1, r2, r3));
		courseRepository.save(Arrays.asList(c1, c2, c3));
		memberRepository.save(Arrays.asList(m1, m2, m3));
	}
}
