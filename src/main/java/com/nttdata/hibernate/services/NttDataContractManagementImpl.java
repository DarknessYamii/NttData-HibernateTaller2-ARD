package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NttDataContract;
import com.nttdata.hibernate.persistence.NttDataContractDaoI;
import com.nttdata.hibernate.persistence.NttDataContractDaoImpl;

/**
 * HIBERNATE - TALLER 2
 * 
 * IMPL CONTRACT SERVICE
 * 
 * @author DarknessYamii
 *
 */
public class NttDataContractManagementImpl implements NttDataContractManagementServiceI {

	/** DAO : NTTDATA_CONTRACT */
	private NttDataContractDaoI contractDao;

	/**
	 * CONSTRUCTOR METHOD
	 */
	public NttDataContractManagementImpl(final Session session) {
		this.contractDao = new NttDataContractDaoImpl(session);
	}

	@Override
	public void insertNewContract(NttDataContract newContract) {

		// Verify null and unexist
		if (newContract != null && newContract.getContractId() == null) {

			// Insert new contract
			contractDao.insert(newContract);
		}

	}

	@Override
	public void updateContract(NttDataContract updatedContract) {

		// Verify null and unexist
		if (updatedContract != null && updatedContract.getContractId() != null) {

			// Update contract
			contractDao.update(updatedContract);
		}

	}

	@Override
	public void deleteContract(NttDataContract deletedContract) {
		// Verify null and unexist
		if (deletedContract != null && deletedContract.getContractId() != null) {

			// Delete contract
			contractDao.delete(deletedContract);

		}

	}

	@Override
	public NttDataContract searchById(Long contractId) {
		
		// Result
		NttDataContract contract = null;
		
		// Verify null
		if(contractId != null) {
			
			// Get contract by Id
			contract = contractDao.searchById(contractId);
		}
		return contract;
	}

	public List<NttDataContract> searchByIdClient(int clientId){
		
		// Result
		List<NttDataContract> contractList = null;
		
		// Get contracts
		contractList = contractDao.searchByIdContract(clientId);
		
		return contractList;
	}
	
	@Override
	public List<NttDataContract> searchAll() {
		
		// Result
		List<NttDataContract> contractsList = new ArrayList<NttDataContract>();
		
		// Get contract
		contractsList = contractDao.searchAll();
		
		return contractsList;
	}

	@Override
	public List<NttDataContract> searchBySalaryAndName(String salary, String name) {
		
		// Result
		List<NttDataContract> contractsList = new ArrayList<NttDataContract>();
		
		// Get contract
		contractsList = contractDao.searchBySalaryAndName(salary, name);
		
		return contractsList;
	}
	
	

}
