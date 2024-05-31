package org.crm.crmproject.Repository;

import lombok.extern.log4j.Log4j2;
import org.crm.crmproject.domain.Board;
import org.crm.crmproject.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsertWithImages() {

        Board board = Board.builder()
                .content("dd")
                .writer("ss")
                .build();

        for (int i = 0; i < 3; i++) {

            board.addImage(UUID.randomUUID().toString(), "file" + i + ".jpg");
        }

        boardRepository.save(board);
    }

//    @Test
//    public void testInsert() {
//        IntStream.rangeClosed(1, 50).forEach(i -> {
//            Board board = Board.builder()
//                    .content("test Content")
//                    .writer("user"+i)
//                    .build();
//
//            boardRepository.save(board);
//        });
//    }


}
