package cn.com.yves.object;

/**
 * 根据api来测试每一个关于Object的方法
 * 
 * @author User
 * 
 */
public class ObjectTest {
	private String arg1;

	// 重写两个受保护的方法 : clone finalize

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String[] args) {
		// 对覆盖后的方法的调用
		// ObjectTest objectTest = new ObjectTest();
		// objectTest.arg1 = "yves";
		// try {
		// ObjectTest ot = (ObjectTest) objectTest.clone();
		// System.out.println(ot.arg1);
		// } catch (CloneNotSupportedException e1) {
		// e1.printStackTrace();
		// }

		// 原生Object调用
		Object object = new Object();
		Object obj = new Object();
		object.equals(obj);
		// 获得class 类的对象有什么用
		object.getClass();// class 字节码可以用于反射的操作.
		System.out.println(object.hashCode());
		System.out.println(object.toString());

		// notify 和notifyall wait等方法都是用于线程的操作,可以在线程中详细查看其功能.
		// object.notify();
		// object.notifyAll();
		// try {
		// // object.wait();
		// // object.wait(1000);
		// // object.wait(100, 100);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}
}
