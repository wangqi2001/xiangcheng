package xiangcheng;

/***
 * 模拟多线程抢票 
 * ===>线程安全问题:当多个线程共享同一个全局变量，做写的操作的时候，可能会受到其他线程的干扰，导致数据不同步，做读的操作，不会产生线程安全问题
 * ==>多个线程共享同一个局部变量，不会产生线程安全问题
 * synchronized锁==>同步代码块=>当一个线程进入synchronized之后会把synchronized所包含的代码给锁上，执行完之后再打开锁
 * synchronized锁的意思就是一群人去抢一个茅坑，上完一个人之后才能进入另外一个
 * 优点：保证了数据的原子性
 * 缺点：效率太低，还可能会出现死锁的问题=>一个人进入茅坑之后那个人死在里面了
 * ===>同步函数跟同步代码块（this锁）可以同步---如果同步代码块不是this锁，就不是用的同一把锁，就不会同步,因为同步函数是this锁
 * 同步函数跟静态同步函数==>不能同步
 * @author wq
 *
 */





class Thread01 implements Runnable{
	
	private int piao=100;//总共有100张火车票
	Object bj=new Object();
  public boolean flig=true;
	public void run() {
		if(flig) {
			//同步代码块this锁
			while (piao>0) {
				synchronized (this) {
				if(piao>0) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			System.out.println(Thread.currentThread().getName()+"-出售第"+(100-piao+1)+"张票");
			piao--;//每卖一张少一张
			}
			}
			}
			
		}else{
			while(piao>0) {
				sale();//出售票
			}
		}
	}
	//同步函数
	public synchronized void sale() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(piao>0) {
		System.out.println(Thread.currentThread().getName()+"出售第"+(100-piao+1)+"张票");
		piao--;//每卖一张少一张
		}
		}
}


public class Thread_qiangPiao {
public static void main(String[] args) throws InterruptedException {
	Thread01 thread=new Thread01();
	Thread t1=new Thread(thread,"窗口①");
	Thread t2=new Thread(thread,"窗口②");
	t1.start();
	Thread.sleep(50);
	thread.flig=false;
	t2.start();
}
}
