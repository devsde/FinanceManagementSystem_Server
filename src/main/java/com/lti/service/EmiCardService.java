package com.lti.service;

import java.util.List;

import com.lti.entity.EmiCard;

public interface EmiCardService {

	
	String addOrUpdateEmiCard(EmiCard emiCard);
	EmiCard getEmiCardByUserId(int userId);
	EmiCard updateEmiCard(EmiCard emiCard);
	
}
