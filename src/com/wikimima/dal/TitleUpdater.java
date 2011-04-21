package com.wikimima.dal;

public interface TitleUpdater {

	public abstract void persist(final String title);

	public abstract void skip(final String title);

	public abstract void select(final String title);

}