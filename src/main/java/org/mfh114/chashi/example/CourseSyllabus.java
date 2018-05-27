package org.mfh114.chashi.example;

import org.mfh114.chashi.graph.eventEmiter.VertexCallback;
import org.mfh114.chashi.graph.exception.ChashiException;

/***
 * 
 * <p>
 * Course syllabus is class which is implementation VertexCallback.
 * </p>
 * <p>
 * To keep the implementation very simple, it mocks to download course syllabus
 * from the course home page over the network, using random Thread.sleep. In the
 * real life there is chance to have VertexCallback implementation per vertex.
 * </p>
 * 
 *
 */
public class CourseSyllabus implements VertexCallback {

	private final String courseName;

	public CourseSyllabus(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public void call() throws ChashiException {
		int randomSleep = (int) (Math.random() * 500);
		System.out.println("Downloading the " + courseName + " syllabus...");
		try {
			Thread.sleep(randomSleep);
			System.out.println("Download completed for " + courseName + " syllabus...");
		} catch (InterruptedException e) {
			throw new ChashiException(e);
		}
	}

}
