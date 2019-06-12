package mockito;

import callBack.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

/**
 * description: TODO
 *
 * @author 张洋
 * @date: 2019-05-07 19:50
 * @modified By:
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
    @Mock
    Teacher teacher;

    @Mock
    Main mockMain;

    @Spy
    Main spyMain;

    @Test
    public void test1(){
        when(teacher.test(anyString())).thenReturn("hhh");
        assertEquals(teacher.test("123"), "hhh");
    }

    @Test
    public void testMoreThanOneReturnValue(){
        Iterator iterator = mock(Iterator.class);
        when(iterator.next()).thenReturn("hello").thenReturn("world");
        String result = iterator.next() + " " + iterator.next();
        assertEquals(result, "hello world");
    }

    @Test
    public void testReturnValueDependentOnMethodParameter(){
        Comparable c = mock(Comparable.class);
        when(c.compareTo(isA(Teacher.class))).thenReturn(0);

        assertEquals(0, c.compareTo(new Teacher(null)));
    }

    @Test
    public void testThrow(){
        Properties properties = mock(Properties.class);
        when(properties.get("OS")).thenThrow(new IllegalArgumentException());

        try {
            properties.get("OS");
            fail("OS is misslpelled");
        } catch (Exception e) {

        }
    }

    @Test
    public void testSpy(){
        //mock 不会执行真实函数
        mockMain.fun("hhhh");

        System.out.println("=====================");

        //spy 可以执行真实函数
        spyMain.fun("hhhh");

        System.out.println("=====================");
        doCallRealMethod().when(mockMain).fun(anyString());
        mockMain.fun(anyString());
        //返回0 而不是真实的5
        System.out.println(mockMain.getVal());
    }

    @Captor
    private ArgumentCaptor<List<String>> captor;
    @Test
    public final void shouldContainListItem(){
        List<String> asList = Arrays.asList("someElement_test", "someElement");
        final List<String> mockedList = mock(List.class);
        mockedList.addAll(asList);

        System.out.println(mockedList.size());
        verify(mockedList).addAll(captor.capture());
        List<String> allValues = captor.getValue();
//        assertThat(allValues, Mockito.hasItem("someElement"));
    }
}

class Main {

    public void fun(String s) {
        System.out.println(s + " : fun");
        fun1(s);
        fun2(s);
    }

    public void fun1(String s) {
        System.out.println(s + " : fun1");
    }

    private void fun2(String s) {
        System.out.println(s + " : fun2");
    }

    public int getVal(){
        return 5;
    }
}
