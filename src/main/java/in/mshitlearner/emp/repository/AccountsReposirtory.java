package in.mshitlearner.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mshitlearner.emp.entity.Accounts;
import in.mshitlearner.emp.entity.AccountsPK;

public interface AccountsReposirtory extends  JpaRepository<Accounts, AccountsPK> {

}
