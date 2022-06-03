package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Dijsktra;
import model.Vertex;

class ContactTesting {
	
	Dijsktra d = new Dijsktra();
	Vertex v1;
	Vertex v2;
	
	private void scene1(){
		d.addEdges();
		v1 = d.getG().getVertex(1);
		v2 = d.getG().getVertex(5);
		d.calculate(v1);
	}

	@Test
	void test() {
		scene1();
		for(Vertex ve:v2.path) {
			System.out.println(ve.getName());
		}
		assertEquals("1",v2.path.get(0).getName());
		assertEquals("2",v2.path.get(1).getName());
		assertEquals("11",v2.path.get(2).getName());
		assertEquals("4",v2.path.get(3).getName());
	}

}
