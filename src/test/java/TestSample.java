import com.my.config.RootContext;
import com.my.config.ServletContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.transaction.annotation.Transactional;

@SpringJUnitWebConfig({RootContext.class, ServletContext.class})
@Slf4j
@Transactional
public class TestSample {

    @Test
    public void test() {

    }
}
