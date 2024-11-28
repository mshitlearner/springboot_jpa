package in.mshitlearner.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mshitlearner.emp.entity.Accounts;
import in.mshitlearner.emp.entity.AccountsPK;
import in.mshitlearner.emp.repository.AccountsReposirtory;

@Service
public class AccountService {
	
		@Autowired
		private AccountsReposirtory accRep;
		
		public void saveAccountDetails() {
			AccountsPK accountsPK = new AccountsPK();
			accountsPK.setAccNo("ACC01");
			accountsPK.setAccountSeqId(1);
			accountsPK.setAccType("SA");
			
			Accounts accounts = new Accounts();
			accounts.setEmpSeqId(1);
			accounts.setAccPK(accountsPK);
			
			accRep.save(accounts);
		}
}
