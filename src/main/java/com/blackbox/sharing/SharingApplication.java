package com.blackbox.sharing;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.blackbox.sharing.domain.Enrollment;
import com.blackbox.sharing.domain.Member;
import com.blackbox.sharing.domain.Role;
import com.blackbox.sharing.repositories.EnrollmentRepository;
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
	private EnrollmentRepository enrollmentRepository;

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

		Enrollment e1 = new Enrollment(null);
		Enrollment e2 = new Enrollment(null);
		Enrollment e3 = new Enrollment(null);

		roleRepository.save(Arrays.asList(r1, r2, r3));
		memberRepository.save(Arrays.asList(m1, m2, m3));
		//enrollmentRepository.save(Arrays.asList(e1, e2));
	}
}
