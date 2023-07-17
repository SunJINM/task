import org.junit.*;

public class JunitFlowTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("before...");
    }
    @After
    public void tearDown() {
        System.out.println("after");
    }

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("beforeClass...");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("afterClass...");
    }
    @Test
    public void test1() {
        System.out.println("test1方法...");
    }

    @Test
    public void test2() {
        System.out.println("test2方法...");
    }
}
