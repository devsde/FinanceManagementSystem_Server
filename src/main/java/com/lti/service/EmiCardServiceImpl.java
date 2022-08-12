package com.lti.service;

import java.rmi.UnexpectedException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.EmiCardDao;
import com.lti.entity.EmiCard;

@Service
public class EmiCardServiceImpl implements EmiCardService {

	@Autowired
	EmiCardDao emiCardDao;

	public String addOrUpdateEmiCard(EmiCard emiCard) {
		EmiCard emiCard1 = emiCardDao.addOrUpdateEmiCard(emiCard);
		if (emiCard1 != null) {
			return "Emi Card Added";
		} else {
			return "Unexpected Error Occured";
		}
	}

	public EmiCard getEmiCardByUserId(int userId) {
		EmiCard emiCard1 = emiCardDao.getEmiCardByUserId(userId);
		return emiCard1;
	}

	
	public EmiCard updateEmiCard(EmiCard emiCard) {
		return emiCardDao.addOrUpdateEmiCard(emiCard);
	}

}
