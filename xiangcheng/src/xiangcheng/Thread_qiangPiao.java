package xiangcheng;

/***
 * ģ����߳���Ʊ 
 * ===>�̰߳�ȫ����:������̹߳���ͬһ��ȫ�ֱ�������д�Ĳ�����ʱ�򣬿��ܻ��ܵ������̵߳ĸ��ţ��������ݲ�ͬ���������Ĳ�������������̰߳�ȫ����
 * ==>����̹߳���ͬһ���ֲ���������������̰߳�ȫ����
 * synchronized��==>ͬ�������=>��һ���߳̽���synchronized֮����synchronized�������Ĵ�������ϣ�ִ����֮���ٴ���
 * synchronized������˼����һȺ��ȥ��һ��é�ӣ�����һ����֮����ܽ�������һ��
 * �ŵ㣺��֤�����ݵ�ԭ����
 * ȱ�㣺Ч��̫�ͣ������ܻ��������������=>һ���˽���é��֮���Ǹ�������������
 * ===>ͬ��������ͬ������飨this��������ͬ��---���ͬ������鲻��this�����Ͳ����õ�ͬһ�������Ͳ���ͬ��,��Ϊͬ��������this��
 * ͬ����������̬ͬ������==>����ͬ��
 * @author wq
 *
 */





class Thread01 implements Runnable{
	
	private int piao=100;//�ܹ���100�Ż�Ʊ
	Object bj=new Object();
  public boolean flig=true;
	public void run() {
		if(flig) {
			//ͬ�������this��
			while (piao>0) {
				synchronized (this) {
				if(piao>0) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			System.out.println(Thread.currentThread().getName()+"-���۵�"+(100-piao+1)+"��Ʊ");
			piao--;//ÿ��һ����һ��
			}
			}
			}
			
		}else{
			while(piao>0) {
				sale();//����Ʊ
			}
		}
	}
	//ͬ������
	public synchronized void sale() {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if(piao>0) {
		System.out.println(Thread.currentThread().getName()+"���۵�"+(100-piao+1)+"��Ʊ");
		piao--;//ÿ��һ����һ��
		}
		}
}


public class Thread_qiangPiao {
public static void main(String[] args) throws InterruptedException {
	Thread01 thread=new Thread01();
	Thread t1=new Thread(thread,"���ڢ�");
	Thread t2=new Thread(thread,"���ڢ�");
	t1.start();
	Thread.sleep(50);
	thread.flig=false;
	t2.start();
}
}
