package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NttDataClient;
import com.nttdata.hibernate.persistence.NttDataClientDaoI;
import com.nttdata.hibernate.persistence.NttDataClientDaoImpl;

/**
 * HIBERNATE - TALLER 2
 * 
 * IMPLEMENTS CLIENT SERVICE
 * 
 * @author DarknessYamii
 *
 */
public class NttDataClientManagementServiceImpl implements NttDataClientManagementServiceI {

	/** DAO: NTTDATA_CLIENT */
	private NttDataClientDaoI clientDao;

	/**
	 * Method Constructor
	 */
	public NttDataClientManagementServiceImpl(final Session session) {
		this.clientDao = new NttDataClientDaoImpl(session);
	}

	@Override
	public void insertNewClient(NttDataClient newClient) {

		// Verify nullable and unexist
		if (newClient != null && newClient.getID() == null) {

			// Insertion new client
			clientDao.insert(newClient);
		}

	}

	@Override
	public void updatePlayer(NttDataClient updatedPlayer) {

		// Verify Nullabe and unexist
		if (updatedPlayer != null && updatedPlayer.getID() != null) {

			// Update client
			clientDao.update(updatedPlayer);

		}

	}

	@Override
	public void deletePlayer(NttDataClient deletedPlayer) {
	
		// Verify Nullable and unexist
		if(deletedPlayer != null && deletedPlayer.getID ()!= null) {
			
			// Delete client
			clientDao.delete(deletedPlayer);
		}
	}

	@Override
	public NttDataClient searchById(Long ID) {
		
		// Result
		NttDataClient client = null;
		
		// Verify Nullable
		if(ID != null) {
			client = clientDao.searchById(ID);
		}
		return client;
	}

	@Override
	public List<NttDataClient> searchAll() {
		List<NttDataClient> clientList = new ArrayList<NttDataClient>();
		
		// Get clients
		clientList = clientDao.searchAll();
		return clientList;
	}

	@Override
	public List<NttDataClient> searchByNameAndFirstName(String name, String firstName) {
		
		// Result
		List<NttDataClient> clientList = new ArrayList<NttDataClient>();
		
		// Get clients
		clientList = clientDao.searchByNameAndFirstName(name, firstName);
		return clientList;
	}
	
	public List<NttDataClient> searchByName(String name){
		
		// Result
		List<NttDataClient> clientList = new ArrayList<NttDataClient>();
		
		// Get clients
		clientList = clientDao.searchByName(name);
		return clientList;
		
	}
	
}
