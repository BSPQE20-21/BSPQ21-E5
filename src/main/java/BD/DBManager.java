package BD;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import Classes.Cliente;



public class DBManager {
	//INSTALACION DE DATOS
		public void preparedData () throws DBException{
			
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
			
			try {
				tx.begin();
				
				Cliente client = new Cliente("Hiquer", 20, 11);
				pm.makePersistent(client);
				
				
				
			
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
			
			Query<Cliente> query = pm.newQuery("javax.jdo.query.SQL","select * from " + "Cliente");
			query.setClass(Cliente.class);
				
			List<Cliente> results = query.executeList();
			
			tx.commit();
			pm.close();
			return results;
			
		}
		
		public boolean exiteCliente(Cliente Cliente) throws DBException{
			
			boolean existe = false;
			List<Cliente> Clientes = listarClientes();
			
			for (Cliente client : Clientes) {
				if (client.getName().equals(Cliente.getName())) {
					existe = true;
				}
			}

			return existe;

		}
		
		//INSERTAR Cliente
		public void insertarCliente(Cliente user) throws DBException{
			
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();
			
			try {
				tx.begin();
				
				pm.makePersistent(user);

				tx.commit();
				
			} finally {
				if (tx.isActive()) {
					tx.rollback();
				}
				pm.close();
			}
			
		}
}
