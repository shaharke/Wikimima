package com.wikimima.dal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wikimima.model.TitleInfo;

@Component
public class AsyncTitleUpdaterImpl implements TitleUpdater {

	@Autowired
	private TitlesDao titlesDao;

	private ExecutorService taskExecutor = Executors.newSingleThreadExecutor();

	/* (non-Javadoc)
	 * @see com.wikimima.dal.TitleUpdater#persist(java.lang.String)
	 */
	@Override
	public void persist(final String title) {
		taskExecutor.submit(new Runnable() {

			@Override
			public void run() {
				TitleInfo info = titlesDao.find(title);
				if (info == null) {
					titlesDao.save(new TitleInfo(title));
				}
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.wikimima.dal.TitleUpdater#skip(java.lang.String)
	 */
	@Override
	public void skip(final String title) {
		taskExecutor.submit(new Runnable() {

			@Override
			public void run() {
				TitleInfo info = titlesDao.find(title);
				info.skip();
				titlesDao.update(info);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.wikimima.dal.TitleUpdater#select(java.lang.String)
	 */
	@Override
	public void select(final String title) {
		taskExecutor.submit(new Runnable() {

			@Override
			public void run() {
				TitleInfo info = titlesDao.find(title);
				info.select();
				titlesDao.update(info);
			}
		});
	}

}
