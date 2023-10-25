package com.cms.entity;

import java.time.LocalDateTime;

import com.cms.entity.auto._CmsBook;

public class CmsBook extends _CmsBook {

	private static final long serialVersionUID = 1L;

	@Override
	protected void onPreUpdate() {
		this.updatedAt = LocalDateTime.now();
		this.updatedBy = "ADMIN";
	}

	@Override
	protected void onPrePersist() {
		this.createdAt = LocalDateTime.now();
		this.createdBy = "ADMIN";
	}

}
