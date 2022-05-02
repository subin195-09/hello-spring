package com.example.guestbook;

import com.example.guestbook.entity.Guestbook;
import com.example.guestbook.repository.GuestbookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
class GuestbookApplicationTests {

	@Test
	void contextLoads() {
	}

}
//
//package com.example.guestbook.repository;
//
//		import com.example.guestbook.entity.Guestbook;
//		import org.junit.jupiter.api.Test;
//		import org.springframework.beans.factory.annotation.Autowired;
//		import org.springframework.boot.test.context.SpringBootTest;
//
//		import java.util.stream.IntStream;
//
//@SpringBootTest
//public class GuestbookRepositoryTests {
//
//	@Autowired
//	private GuestbookRepository guestbookRepository;
//
//	@Test
//	public void insertDummies() {
//		IntStream.rangeClosed(1, 300).forEach(i -> {
//			Guestbook guestbook = Guestbook.builder()
//					.title("Title..." + i)
//					.content("Content... " + i)
//					.writer("user" + (i % 10))
//					.build();
//			System.out.println(guestbookRepository.save(guestbook));
//		});
//	}
//}
