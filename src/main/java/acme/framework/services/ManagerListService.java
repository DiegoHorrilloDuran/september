package acme.framework.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Manager;
import acme.framework.entities.UserRole;
import acme.framework.repositories.ManagerRepository;

@Service
public class ManagerListService implements AbstractListService<UserRole, Manager>{
	
	// Internal state ---------------------------------------------------------

		@Autowired
		protected ManagerRepository repository;
			
		@Override
		public boolean authorise(final Request<Manager> request) {
			assert request != null;

			return true;
		}


		@Override
		public void unbind(final Request<Manager> request, final Manager entity, final Model model) {
			assert request != null;
			assert entity != null;
			assert model != null;

			request.unbind(entity, model, "id");
			
		}

		@Override
		public Collection<Manager> findMany(final Request<Manager> request) {
			assert request != null;
			
			final Collection<Manager> res;
			
			res = this.repository.findMany();
			
			return res;
		}

}
