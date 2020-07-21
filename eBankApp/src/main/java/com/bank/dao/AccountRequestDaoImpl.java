package com.bank.dao;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.text.DefaultEditorKit.CutAction;

import org.springframework.stereotype.Repository;
import com.bank.entity.AccountRequest;
import com.bank.entity.BankAccount;
import com.bank.entity.Beneficiary;
import com.bank.entity.Customer;
import com.bank.utils.JpaUtils;

@Repository
public class AccountRequestDaoImpl implements AccountRequestDao {
	private EntityManager manager;
	

	public AccountRequestDaoImpl() {
		manager = JpaUtils.getEntityManager();
	}

	@Override
	public Long addAccountRequest(AccountRequest accntreq) {
		Date dt=new Date();
        accntreq.setApply_Date(dt);
		manager.persist(accntreq);
	      Long result= accntreq.getApplication_Id();
	      return result;
	}

	@Override
	public void beginTransaction() {
		manager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		manager.getTransaction().commit();
	}

	@Override
	public void updateAccountStatus(String acctapvstatus, Long appreqid,String remark) {
		
		AccountRequest acctreq=manager.find(AccountRequest.class, appreqid);
		if(acctapvstatus.equalsIgnoreCase("Accept"))
		{
			/*call method to delete the details of the account request
			 * and add into the customertable*/
	
			Customer cust=new Customer();
			
			cust.setAdhar_No(acctreq.getAdhar_No());
			cust.setEmail(acctreq.getEmail());
			cust.setAcct_type(acctreq.getAcct_type());
			cust.setDob(acctreq.getDob());
			cust.setFather_Name(acctreq.getFather_Name());
			cust.setFirst_Name(acctreq.getFirst_Name());
			cust.setIncome_Source(acctreq.getIncome_Source());
			cust.setLast_Name(acctreq.getLast_Name());
			cust.setMiddle_Name(acctreq.getMiddle_Name());
			cust.setOccupation_Type(acctreq.getOccupation_Type());
			cust.setPan_No(acctreq.getPan_No());
			cust.setPermanant_Address(acctreq.getPermanant_Address());
			cust.setGross_Income(acctreq.getGross_Income());
			cust.setResidential_Address(acctreq.getResidential_Address());
			cust.setApply_Date(acctreq.getApply_Date());
			cust.setPhone(acctreq.getPhone());
			
			manager.persist(cust);
			//removes the user details form account request and transfer to customer table
			if(cust.getCustomer_Id()!=0)
			{
				manager.remove(acctreq);
			}
			//Opens new bank account after successfull transfer
			BankAccount bk=new BankAccount();
			bk.setBranch("Dadar");
			bk.setEmail(cust.getEmail());
			bk.setIfsc("SBIN0000300");
			bk.setMobile(cust.getPhone());
			bk.setType(cust.getAcct_type());
			bk.setCustomer_Id(cust.getCustomer_Id());
		    
		
			
			System.out.println();
			manager.persist(bk);
			
			
		}
		else if(acctapvstatus.equalsIgnoreCase("Reject"))
		{
			acctreq.setStatus("Reject");
			acctreq.setRemark(remark);
			manager.persist(acctreq);
		}	
		else
		{

			acctreq.setStatus("Pending");
			acctreq.setRemark(remark);
			manager.persist(acctreq);
		}

	}	
	
	public void addApprovedreqtoCustomer(AccountRequest acctreq)
	{
		Customer cust=new Customer();
		cust.setAdhar_No(acctreq.getAdhar_No());
		cust.setEmail(acctreq.getEmail());
		beginTransaction();
		manager.persist(cust);
		if(cust.getCustomer_Id()!=0)
		{
			manager.remove(acctreq);
		}
		commitTransaction();
	}

	@Override
	public List<AccountRequest> viewAllaccountrequest() {
		
		ArrayList<AccountRequest> custprofile=new ArrayList<AccountRequest>();
			String query="from AccountRequest";
			custprofile= (ArrayList<AccountRequest>) manager.createQuery(query).getResultList();
			return custprofile;
			
			
		}

	@Override
	public AccountRequest viewAccountrequestById(Long acctreqid) {
		AccountRequest acctreq=new AccountRequest();
		acctreq=manager.find(AccountRequest.class, acctreqid);
		return acctreq;
	}
	

	
	}
	


