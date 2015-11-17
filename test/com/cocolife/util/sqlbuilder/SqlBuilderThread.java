package com.cocolife.util.sqlbuilder;

import com.oris.util.sqlbuilder.SqlBuilderFactory;

/**
 * 
 * @author Ross Zarsuela
 *
 */

public class SqlBuilderThread extends Thread {
	private SqlBuilderFactory factory;
	private Runnable runnable;
	
	public SqlBuilderThread() { 
		super(); 
		factory = new SqlBuilderFactory();
	}
	
	public SqlBuilderThread(String name) { 
		super(name); 
		factory = new SqlBuilderFactory();
	}
	
	public SqlBuilderThread(Runnable run, String name){ 
		super(run, name);
		factory = new SqlBuilderFactory();
	}
	
	public SqlBuilderFactory getFactory() {
		return factory;
	}
	
	@Override
	public void run() {
		runnable.run();
	}
	
	public void setRunnable(Runnable run) {this.runnable=run;}
}
