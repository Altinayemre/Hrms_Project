package com.emre.hrmsProject.core.adapters.verifications;

//import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.emre.hrmsProject.business.abstracts.CandidateCheckService;
import com.emre.hrmsProject.entities.concretes.Candidate;

//import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements CandidateCheckService {

	@Override
	public boolean checkCandidate(Candidate candidate) {

		/*KPSPublicSoapProxy proxy = new KPSPublicSoapProxy();
		boolean result = false;
		try {
			if (proxy.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()),
					candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(),
					candidate.getBirthYear())) {
			return result = true;

			} else {
				return result = false;
			}

		} catch (NumberFormatException | RemoteException e) {

			e.getMessage();
		}
		return result;*/
		
		return true;
	}

}
