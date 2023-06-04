package chap09.member;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberDaoIntTest {
    @Autowired
    MemberDao dao;

    @Test
    void findAll() {
        List<Member> members = dao.selectAll();
        assertNotNull(members);
    }
}
