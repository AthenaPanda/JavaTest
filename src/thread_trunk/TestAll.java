package thread_trunk;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class TestAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* a. Test thread execution sequence 
		 * 
		try {
			MyThread myThread = new MyThread();
			myThread.setName("myThread");
			myThread.start();
			for (int i = 0; i < 10; i++) {
				int time = (int)(Math.random() * 1000);
				Thread.sleep(time);
				System.out.println("main =" + Thread.currentThread().getName());
			}
			
			//create other thread with Runnable
			MyRunnable myRunnable = new MyRunnable();
			Thread threadForRun = new Thread(myRunnable);
			threadForRun.start();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		
		/*
		 * b. Test thread  Unshare var
		 *
		MyThread threadA = new MyThread("A");
		MyThread threadB = new MyThread("B");
		MyThread threadC = new MyThread("C");
		threadA.start();
		threadB.start();
		threadC.start();
		*/
		/*
		 * c. Test thread share var 
		 *
		MyThread  threadShare = new MyThread();
		Thread threadA = new Thread(threadShare, "A");
		Thread threadB = new Thread(threadShare, "B");
		Thread threadC = new Thread(threadShare, "C");
		threadA.start();
		threadB.start();
		threadC.start();
		System.out.println("current status is " + threadA.isAlive() + ". Id is " + threadA.getId());
		*/
		
		/*
		 * Test yield method
		 *
		MyThread threadY = new MyThread();
		threadY.start();
		*/
		/*
		 * test thread priority
		 *
		for(int i = 0; i<5; i++) {
			MyThread threadFirst = new MyThread();
			threadFirst.setPriority(5);
			threadFirst.start();
			
			SecondThread threadSecond= new SecondThread();
			threadSecond.setPriority(6);
			threadSecond.start();
		}
		*/
		/*  
		 * e. test synchornized 
		 * the lock is for object not method or code
		 */
		/*SampleObject mainObject = new SampleObject();
		MyThread threadA = new MyThread(mainObject);
		threadA.setName("A");
		SecondThread threadB = new SecondThread(mainObject);
		threadB.setName("B");
		threadA.start();
		threadB.start();
		
		try {
			Object lock= new Object();
			ThirdThread threaC = new ThirdThread(lock);
			threaC.start();
			Thread.sleep(3000);
			FourthThread threadD = new FourthThread(lock);
			threadD.start();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		
		//product and consumer
		/*String lockPro = new String("");
		Product product = new Product(lockPro);
		Consumer consumer = new Consumer(lockPro);
		ThreadP threadP = new ThreadP(product);
		ThreadCon con = new ThreadCon(consumer);
		threadP.start();
		con.start();*/
		
		//add  byte stream for thread pipe
		try {
			WriteData dataOut = new WriteData();
			ReadData datainData = new ReadData();
			PipedInputStream input = new PipedInputStream();
			PipedOutputStream out = new PipedOutputStream();
			out.connect(input);
			
			ThreadRead threadRead = new ThreadRead(datainData, input);
			threadRead.start();
			Thread.sleep(2000);
			ThreadWrite threadWrite = new ThreadWrite(dataOut, out);
			threadWrite.start();			
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			JoinThread threadJ = new JoinThread();
			threadJ.start();
			threadJ.join();
			System.out.println("current time");
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//lock test
		/*LockService service = new LockService();
		testLock a1 = new testLock(service);
		testLock a2 = new testLock(service);
		testLock a3 = new testLock(service);
		a1.start();
		a2.start();
		a3.start();*/
		
		//loct object test
		/*try {
			LockService service = new LockService();
			SecondThread threadA1 = new SecondThread(service);
			threadA1.setName("A1");
			threadA1.start();
			
			ThirdThread threadA2 = new ThirdThread(service);
			threadA2.setName("A2");
			threadA2.start();
			ThreadRead.sleep(100);
			
			FourthThread threadB1 = new FourthThread(service);
			threadB1.setName("B1");
			threadB1.start();
			
			testLock threadB2 = new testLock(service);
			threadB2.setName("B2");
			threadB2.start();
			
			
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		
		/*try {
			LockService service = new LockService();
			testLock threadLock = new testLock(service);
			threadLock.start();
			//Thread.sleep(3000);
			//service.signal();
			FourthThread threadConFourthThread = new FourthThread(service);
			threadConFourthThread.start();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		LockService service_rw = new LockService();
		testLock thread_rr = new testLock(service_rw);
		thread_rr.setName("RLock1");
		FourthThread thread_rr1 = new FourthThread(service_rw);
		thread_rr1.setName("Rlock2");
		SecondThread thread_rw = new SecondThread(service_rw);
		thread_rw.setName("WLock1");
		thread_rr.start();
		thread_rr1.start();
		thread_rw.start();
	}

}
