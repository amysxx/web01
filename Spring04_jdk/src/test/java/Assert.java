import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author amy
 * @date 2019/9/22 11:29
 */
class Assert {
    @Test
    void standardAssertions() {

        assertEquals(2, 2);
        assertEquals(4, 4, "error message");
        assertTrue(2 == 2, () -> "error message");
    }

    @Test
    void groupedAssertions() {

        // 分组断言，执行分组中所有断言，分组中任何一个断言错误都会一起报告
        assertAll("person", () -> assertEquals("John", "John"), () -> assertEquals("Doe", "Doe"));
    }

    @Test
    void dependentAssertions() {

        // 分组断言
        assertAll("properties", () -> {
            // 在代码块中，如果断言失败，后面的代码将不会运行
            String firstName = "John";
            assertNotNull(firstName);
            // 只有前一个断言通过才会运行
            assertAll("first name", () -> assertTrue(firstName.startsWith("J")),
                    () -> assertTrue(firstName.endsWith("n")));
        }, () -> {
            // 分组断言，不会受到first Name代码块的影响，所以即使上面的断言执行失败，这里的依旧会执行
            String lastName = "Doe";
            assertNotNull(lastName);
            // 只有前一个断言通过才会运行
            assertAll("last name", () -> assertTrue(lastName.startsWith("D")),
                    () -> assertTrue(lastName.endsWith("e")));
        });
    }

    @Test
    void exceptionTesting() {

        // 断言异常，抛出指定的异常，测试才会通过
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });
        assertEquals("a message", exception.getMessage());
    }

    @Test
    void timeoutNotExceeded() {

        // 断言超时
        assertTimeout(ofMinutes(2), () -> {
            // 完成任务小于2分钟时，测试通过。
        });
    }

    @Test
    void timeoutNotExceededWithResult() {

        // 断言成功并返回结果
        String actualResult = assertTimeout(ofMinutes(2), () -> {
            return "result";
        });
        assertEquals("result", actualResult);
    }

    @Test
    void timeoutExceeded() {

        // 断言超时，会在任务执行完毕后才返回，也就是1000毫秒后返回结果
        assertTimeout(ofMillis(10), () -> {
            // 执行任务花费时间1000毫秒
            Thread.sleep(1000);
        });
    }

    @Test
    void timeoutExceededWithPreemptiveTermination() {

        // 断言超时，如果在10毫秒内任务没有执行完毕，会立即返回断言失败，不会等到1000毫秒后
        assertTimeoutPreemptively(ofMillis(10), () -> {
            Thread.sleep(1000);
        });
    }

}