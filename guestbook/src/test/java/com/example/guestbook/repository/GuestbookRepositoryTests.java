package com.example.guestbook.repository;

import com.example.guestbook.entity.Guestbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class GuestbookRepositoryTests {

	@Autowired
	private GuestbookRepository guestbookRepository;

	@Test
	public void insertDummies() {
		IntStream.rangeClosed(1, 300).forEach(i -> {
			Guestbook guestbook = Guestbook.builder()
					.title("Title..." + i)
					.content("Content... " + i)
					.writer("user" + (i % 10))
					.build();
			System.out.println(guestbookRepository.save(guestbook));
		});
	}

	@Test
	public void updateTest() {
		Optional<Guestbook> result = guestbookRepository.findById(300L); // 현제 존재하는 데이터로 테스트 해볼 것

		if(result.isPresent()) {
			Guestbook guestbook = result.get();

			guestbook.changeTitle("Changed Title...");
			guestbook.changeContent("Changed Content...");

			guestbookRepository.save(guestbook);
		}
	}
}