import java.util.Comparator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class TempBean implements Comparator<TempBean> {
	private int id;
	private String name;

	public TempBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int compare(TempBean o1, TempBean o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempBean other = (TempBean) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TempBean [id=" + id + ", name=" + name + "]";
	}
}

class ComparatorClass implements Comparator<ComparatorClass> {

	@Override
	public int compare(ComparatorClass o1, ComparatorClass o2) {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}
}

class CallableThreads implements Callable<CallableThreads> {
	@Override
	public CallableThreads call() throws Exception {
		System.out.println("Hello From Call Method");
		return new CallableThreads();
	}

}

class RunnableThread implements Runnable {
	@Override
	public void run() {
		System.out.println("Hello From run Method");
	}
}

public class Test {
	public static void main(String[] args) {
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 10000, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<>(10));
		
		Future<String> futureOject = threadPoolExecutor.submit(new RunnableThread(), "Runnable Tread");
		

	}
}
