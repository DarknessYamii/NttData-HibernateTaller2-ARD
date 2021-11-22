package com.nttdata.hibernate;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NttDataClient;
import com.nttdata.hibernate.persistence.NttDataContract;
import com.nttdata.hibernate.services.NttDataClientManagementServiceI;
import com.nttdata.hibernate.services.NttDataClientManagementServiceImpl;
import com.nttdata.hibernate.services.NttDataContractManagementImpl;
import com.nttdata.hibernate.services.NttDataContractManagementServiceI;

/**
 * Hello world!
 *
 */
public class NttDataHibernateMain {
	public static void main(String[] args) {
		// Open Session
		final Session session = NttDataHibernateUtil.getSessionFactory().openSession();

		// Init servicies
		final NttDataClientManagementServiceI clientService = new NttDataClientManagementServiceImpl(session);
		final NttDataContractManagementServiceI contractService = new NttDataContractManagementImpl(session);
		// Auditory
		final String updatedUser = "NTTDATAINFO_SYS";
		final Date updatedDate = new Date();

		// Generate Client
		final NttDataClient clientA = new NttDataClient();
		clientA.setName("Andres");
		clientA.setFirstName("Ruiz");
		clientA.setSecondName("Delgado");
		clientA.setDNI("15456782T");
		clientA.setUpdatedDate(updatedDate);
		clientA.setUpdatedUser(updatedUser);

		final NttDataClient clientB = new NttDataClient();
		clientB.setName("Javier");
		clientB.setFirstName("Campos");
		clientB.setSecondName("Cuevas");
		clientB.setDNI("47562710K");
		clientB.setUpdatedDate(updatedDate);
		clientB.setUpdatedUser(updatedUser);
		
		final NttDataClient clientC = new NttDataClient();
		clientC.setName("Ana");
		clientC.setFirstName("Gonzalez");
		clientC.setSecondName("Carranza");
		clientC.setDNI("11223344A");
		clientC.setUpdatedDate(updatedDate);
		clientC.setUpdatedUser(updatedUser);
		
		// Generate Contract
		final NttDataContract contract1 = new NttDataContract();
		contract1.setEffectiveDate(new Date(2021, 11, 18));
		contract1.setExpiryDate(new Date(2022, 11, 18));
		contract1.setSalary("100");
		contract1.setUpdatedUser(updatedUser);
		contract1.setUpdatedDate(updatedDate);

		final NttDataContract contract2 = new NttDataContract();
		contract2.setEffectiveDate(new Date(2021, 01, 10));
		contract2.setExpiryDate(new Date(2022, 01, 10));
		contract2.setSalary("300");
		contract2.setUpdatedUser(updatedUser);
		contract2.setUpdatedDate(updatedDate);

		final NttDataContract contract3 = new NttDataContract();
		contract3.setEffectiveDate(new Date(2021, 11, 19));
		contract3.setExpiryDate(new Date(2022, 06, 01));
		contract3.setSalary("2000");
		contract3.setUpdatedDate(updatedDate);
		contract3.setUpdatedUser(updatedUser);

		// Associate contracts to clients
		contract1.setClient(clientA);
		contract2.setClient(clientC);
		contract3.setClient(clientB);

		// Services client
		clientService.insertNewClient(clientA);
		clientService.insertNewClient(clientB);
		clientService.insertNewClient(clientC);
		// Services contract
		contractService.insertNewContract(contract1);
		contractService.insertNewContract(contract2);
		contractService.insertNewContract(contract3);

		// Consults
		List<NttDataClient> clients = clientService.searchByNameAndFirstName("A%", "R%");
		for (final NttDataClient client : clients) {
			System.out.println(client.getName() + " | " + client.getFirstName());
		}

		List<NttDataContract> contracts = contractService.searchByIdClient(1);
		for (final NttDataContract contract : contracts) {
			System.out.println(contract.getClient() + " | ContractID : " + contract.getContractId() + " | SALARY : " + contract.getSalary());
		}
		
		// JPA Criteria (Consult)
		List<NttDataClient> clientsCriteria = clientService.searchByName("A%");
		for(final NttDataClient client : clientsCriteria) {
			System.out.println(client.getName());
		}
		
		List<NttDataContract> contractsCriteria = contractService.searchBySalaryAndName("10", "A%");
		for(final NttDataContract contract : contractsCriteria) {
			System.out.println("Salary : " + contract.getSalary() + " | Name : " + contract.getClient().getName());
		}
		
		
		session.close();
	
		

	}
}
