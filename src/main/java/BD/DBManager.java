package BD;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import Classes.Cliente;
import Classes.Ticket;



public class DBManager {
	//INSTALACION DE DATOS
		public void preparedData () throws DBException{
			
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
			
			try {
				tx.begin();
				
				Cliente client1 = new Cliente("Antonio", "antonio@gmail.com", "1234");
				pm.makePersistent(client1);
				Cliente client2 = new Cliente("Paco", "paco@hotmail.com", "5678");
				pm.makePersistent(client2);
				Cliente client3 = new Cliente("Juanjo", "juanjo@gmail.com", "91011");
				pm.makePersistent(client3);
				
							
				
				
				
			
				tx.commit();
				
			} finally {
				if (tx.isActive()) {
					tx.rollback();
				}
				pm.close();
			}
		}
		
		//LISTAR ClienteS DE BD
		public List<Cliente> listarClientes() throws DBException{
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
			
			tx.begin();
			
			Query<Cliente> query = pm.newQuery("javax.jdo.query.SQL","select * from " + "cliente");
			query.setClass(Cliente.class);
				
			List<Cliente> results = query.executeList();
			
			tx.commit();
			pm.close();
			return results;
			
		}
		
		public boolean exiteCliente(Cliente Cliente) throws DBException{
			
			boolean existe = false;
			List<Cliente> clientes = listarClientes();
			
			for (Cliente client : clientes) {
				if (client.getName().equals(Cliente.getName())) {
					 existe = true;
				}
			}

			return existe;

		}
		
		//INSERTAR Cliente
		public void insertarCliente(Cliente client) throws DBException{
			
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
			
			try {
				tx.begin();
				
				pm.makePersistent(client);

				tx.commit();
				
			} finally {
				if (tx.isActive()) {
					tx.rollback();
				}
				pm.close();
			}
			
		}
		
		public Ticket bookATicketaso(Cliente client) {
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
			
			return null;
		
			
		}
}
