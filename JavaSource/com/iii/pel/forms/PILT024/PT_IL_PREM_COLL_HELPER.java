package com.iii.pel.forms.PILT024;

import java.util.List;

import com.iii.pel.forms.PILT024.PILT024_COMPOSITE_ACTION;

public class PT_IL_PREM_COLL_HELPER {
	public void preInsert() {
	}

	public void postInsert() {
	}

	public void preUpdate() {
	}

	public void preBlock() {
	}

	public void whenCreateRecord() {
	}

	public void whenNewRecordInstance() {
	}

	public void postQuery() {
	}

	public void preDelete() {
	}

	public void whenNewBlockInstance() {
	}

	public void executeQuery(PILT024_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_PREM_COLL_DELEGATE().executeSelectStatement(compositeAction);
	}

}