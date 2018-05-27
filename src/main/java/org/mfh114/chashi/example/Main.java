package org.mfh114.chashi.example;

import java.util.List;

import org.mfh114.chashi.graph.GraphFactory;
import org.mfh114.chashi.graph.Vertex;
import org.mfh114.chashi.graph.VertexConnection;
import org.mfh114.chashi.graph.exception.ChashiException;

public class Main {

	public static void main(String[] args) throws ChashiException {

		// Create graph factory
		GraphFactory graphFactory = new GraphFactory();

		// Create vertex for each courses and registered callback
		Vertex c1 = graphFactory.createVertex("C1");
		c1.registerCallBack(new CourseSyllabus("Introductory computer science"));

		Vertex c2 = graphFactory.createVertex("C2");
		c2.registerCallBack(new CourseSyllabus("Java 1"));

		Vertex c3 = graphFactory.createVertex("C3");
		c3.registerCallBack(new CourseSyllabus("Java 2"));

		Vertex c4 = graphFactory.createVertex("C4");
		c4.registerCallBack(new CourseSyllabus("Data Structure"));

		Vertex c5 = graphFactory.createVertex("C5");
		c5.registerCallBack(new CourseSyllabus("Algorithm"));

		Vertex c6 = graphFactory.createVertex("C6");
		c6.registerCallBack(new CourseSyllabus("Database System"));

		Vertex c7 = graphFactory.createVertex("C7");
		c7.registerCallBack(new CourseSyllabus("Software Engineering"));

		Vertex c8 = graphFactory.createVertex("C8");
		c8.registerCallBack(new CourseSyllabus("Design Pattern"));

		Vertex m1 = graphFactory.createVertex("M1");
		m1.registerCallBack(new CourseSyllabus("Linear Algebra"));

		Vertex m2 = graphFactory.createVertex("M2");
		m2.registerCallBack(new CourseSyllabus("Discreate Mathmatics"));

		Vertex m3 = graphFactory.createVertex("M3");
		m3.registerCallBack(new CourseSyllabus("Calculus"));

		Vertex m4 = graphFactory.createVertex("M4");
		m4.registerCallBack(new CourseSyllabus("Statistics"));

		Vertex r = graphFactory.createVertex("R");
		r.registerCallBack(new CourseSyllabus("Senior Report"));

		// Connect vertexes
		VertexConnection vConn = graphFactory.createVertexConnection();
		vConn.from(c1).to(c2).connect();
		vConn.from(c2).to(c3, c4, c5).connect();
		vConn.from(c3).to(c6, c7).connect();
		vConn.from(c4).to(c7).connect();
		vConn.from(c5).to(c7).connect();
		vConn.from(c6).to(c8).connect();
		vConn.from(c7).to(c8).connect();
		vConn.from(c8).to(r).connect();
		vConn.from(m1).to(m2, m3).connect();
		vConn.from(m2).to(m4).connect();
		vConn.from(m3).to(r).connect();
		vConn.from(m4).to(r).connect();

		List<Vertex> sortedVertex = graphFactory.sort();
		graphFactory.emitEvent();

		for (Vertex v : sortedVertex)
			System.out.println(v.getVertexName());
	}

}
