package repFactory;

import global.PageId;

import java.util.LinkedList;

import bufmgr.pageDsc;

public class Policy {
	static Policy instance;
	static String policy;
	protected static int MAX;
	protected LinkedList<pageDsc> requested;
	protected LinkedList<pageDsc> countZero;

	protected Policy() {
		// TODO Auto-generated constructor stub
		countZero = new LinkedList<pageDsc>();
		requested = new LinkedList<pageDsc>();
		MAX = -1;
	}

	public static Policy getInstance(String u) {
		if (instance != null) {
			if (!policy.equals(u))// moshkela
				return null;
			return instance;
		} else {
			u=u.toUpperCase();
			switch (u) {
			case "FIFO":
				System.out.println("FIFO");
				return (instance = new FIFO());
			case "LRU":
				System.out.println("LRU");
				return (instance = new LRU());
			case "MRU":
				System.out.println("MRU");
				return (instance = new MRU());
			case "LOVE":
				System.out.println("LOVE");
				return (instance = new LOVE());
			default:
				System.out.println("Default");
				return (instance = new FIFO());
			}
		}
	}
	public boolean isEmpty() {
		return false;
	}

	public pageDsc getFrame() {
		return null;
	}

	public void update(pageDsc pageDsc) {
	}
	
	public void addToCountZero(pageDsc pageDsc) {
		if(pageDsc.getPin_count() == 0){
			countZero.addLast(pageDsc);
		}
	}
	
	public void addToRequested(pageDsc pageDsc) {
		if(!requested.contains(pageDsc)){
			requested.addLast(pageDsc);
		}else{
			requested.remove(pageDsc);
			requested.addLast(pageDsc);
		}
	}
	
	public void removeFromCountZero(pageDsc pageDsc) {
		countZero.remove(pageDsc);
	}

	public int size() {
		// TODO Auto-generated method stub
		return requested.size();
	}
	
//	public void removeFromRequested(pageDsc pageDsc) {
//		requested.remove(pageDsc);
//	}
}
