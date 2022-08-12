package com.lti.dao;

import com.lti.entity.EmiCard;

public interface EmiCardDao {
	
	EmiCard addOrUpdateEmiCard(EmiCard emiCard);
	EmiCard getEmiCardByUserId(int userId);
	EmiCard getEmiCardByCardNo(int emiCardNo);

}
