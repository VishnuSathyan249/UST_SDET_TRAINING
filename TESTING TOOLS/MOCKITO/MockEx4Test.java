package mocktest;

import static org.junit.jupiter.api.Assertions.fail;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MockEx4Test {

	@Test
	public void test() {
		List<String> list = new ArrayList<>();
		List<String> spyOnList = spy(list);
		
		when(spyOnList.size()).thenReturn(10);
		assertEquals(10, spyOnList.size());
		
		//calling real methods since below methods are not stubbed
		spyOnList.add("XXX");
		spyOnList.add("YYY");
		assertEquals("XXX", spyOnList.get(0));
		assertEquals("YYY", spyOnList.get(1));
	}
	
}

