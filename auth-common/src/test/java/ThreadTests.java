import com.auth.Application;
import com.auth.thread.MyRunnable;
import com.auth.thread.MyThread;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest(classes = Application.class)
class ThreadTests {


    /**
     * 输出：my thread
     * 原因：
     *  当执行到Thread类中的run()方法时，会首先判断target是否存在，存在则执行target中的run()方法，也就是实现了Runnable接口并重写了run()方法的类中的run()方法。
     *  但是本实例中存在多态，先执行MyThread这个子类中的run()，执行不到父类中的target(MyRunnable)的run()。
     */
    @Test
    void test1() {
        MyRunnable runnable = new MyRunnable();
        MyThread myThread = new MyThread(runnable);
        myThread.start();
    }

}
