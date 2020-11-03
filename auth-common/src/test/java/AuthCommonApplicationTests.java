import com.auth.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = Application.class)
class AuthCommonApplicationTests {

    @Test
    void test1() {
        System.out.println(100/21);
        System.out.println(100%21);
    }

}
