package thread_trunk;

public class SampleObject {
	synchronized public void methodA() {
		try {
			System.out.println("begin methodA thread name is " + Thread.currentThread().getName());
			Thread.sleep(5000);
			System.out.println("end");
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
