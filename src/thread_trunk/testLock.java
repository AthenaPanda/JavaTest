package thread_trunk;

public class testLock extends Thread{
	private LockService service;
	public testLock(LockService service) {
		super();
		this.service = service;
	}
	@Override
	public void run() {
		//service.testMethod();
		service.testMethodB();
	}
}