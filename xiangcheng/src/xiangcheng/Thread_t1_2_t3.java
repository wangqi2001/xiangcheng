package xiangcheng;
/**
 * t1先执行完毕，t2再执行，执行完毕之后再执行t3
 * join方法
 * @author wq
 *
 */
public class Thread_t1_2_t3 {
public static void main(String[] args) {
	Thread t1=new Thread(new Runnable() {
		@Override
		public void run() {
             for(int i=0; i<5;i++) {
					 System.out.println("t1,i:"+i);
				 }
		}
	});
	t1.start();
	Thread t2=new Thread(new Runnable() {
		@Override
		public void run() {
			try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
             for(int i=0; i<5;i++) {
					 System.out.println("t2,i:"+i);
				 }
		}
	});
	t2.start();
	Thread t3=new Thread(new Runnable() {
		@Override
		public void run() {
			try {
				t2.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             for(int i=0; i<5;i++) {
					 System.out.println("t3,i:"+i);
				 }
		}
	});
	t3.start();
}
}
